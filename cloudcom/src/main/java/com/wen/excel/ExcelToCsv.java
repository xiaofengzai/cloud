package com.wen.excel;

import com.wen.BusinessException;
import com.wen.GlobalConstant;
import com.wen.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created by szty on 2018/5/22.
 */
public class ExcelToCsv {
    private static final Logger logger = LoggerFactory.getLogger(ExcelToCsv.class);
    private static DecimalFormat df = new DecimalFormat("0");
    public static Integer transfer(MultipartFile file, CsvConvertConfig config){
        Integer rowCount=0;
        BufferedInputStream inputStream=null;
        Workbook wb = null;
        BufferedWriter writer=null;
        File saveCSV = new File(config.getSavePath());
        try
        {
            if(saveCSV.exists()){
                saveCSV.delete();
            }
            saveCSV.createNewFile();
             writer = new BufferedWriter(new FileWriter(saveCSV));
            inputStream=new BufferedInputStream(file.getInputStream());
            wb=createWookbook(inputStream);
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
            closeInputStream(inputStream);
            return rowCount;
        }

        Sheet sheet = wb.getSheetAt(0);
        if(sheet==null || config.getStartRowIndex()>sheet.getLastRowNum()){
            closeInputStream(inputStream);
            return 0;
        }
        rowCount=sheet.getLastRowNum()+1-config.getStartRowIndex();
        StringBuffer content=new StringBuffer();
        Short firstCellIndex=null;
        Short lastCellIndex=null;
        String[] headerNames=config.getHeaderNames();
        if(headerNames.length>0){
            validateHeader(inputStream,sheet.getRow(0),headerNames);
        }
        for (int i = config.getStartRowIndex(); i <= sheet.getLastRowNum(); i++)
        {
            Row row = sheet.getRow(i);
            if(row==null)
                continue;
            if(firstCellIndex==null){
                firstCellIndex=row.getFirstCellNum();
                lastCellIndex=row.getLastCellNum();
            }
            if(headerNames.length>0 && lastCellIndex>headerNames.length){
                lastCellIndex=(short)headerNames.length;
            }
            readRow(config, content, firstCellIndex, lastCellIndex, row);
            try {
                if(i>0 && i%config.getBatchSize()==0){
                    writer.write(content.toString());
                    content.setLength(0);
                }

            }catch (IOException ioe){
                logger.error(ioe.getMessage());
            }
        }

        try
        {
            if(!StringUtils.isEmpty(content)){
                writer.write(content.toString());
                content.setLength(0);
            }
            writer.close();
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }
        closeInputStream(inputStream);
        return rowCount;
    }

    private static void readRow(CsvConvertConfig config, StringBuffer content, Short firstCellIndex, Short lastCellIndex, Row row) {
        Cell cell=null;
        int filterRowsLength=config.getFilterRows().length;
        if(filterRowsLength>0){
            for(int j=0;j<filterRowsLength;j++){
                int rowIndex=config.getFilterRows()[j];
                if(rowIndex<firstCellIndex || rowIndex>=lastCellIndex)
                    throw new BusinessException("读取列超出范围");
                cell=row.getCell(rowIndex);
                if(cell!=null){
                    appendCellValue(cell,content);
                }
                if(j<filterRowsLength-1){
                    content.append(config.getSeparator());
                }else{
                    content.append(config.getNewLine());
                }
            }
        }else{
            for (int j=firstCellIndex;j<lastCellIndex;j++){
                cell=row.getCell(j);
                if(cell!=null){
                    appendCellValue(cell,content);
                }
                if(j<lastCellIndex-1){
                    content.append(config.getSeparator());
                }else{
                    content.append(config.getNewLine());
                }
            }
        }
    }

    private static Workbook createWookbook(BufferedInputStream inputStream){
        try {
            String headerInfo= FileUtils.getFileHeader(inputStream,4);
            if(headerInfo.equals("d0cf11e0")){
                return new HSSFWorkbook(inputStream);
            }else if(headerInfo.equals("504b0304")){
                return new XSSFWorkbook(inputStream);
            }else
                throw new BusinessException("文件格式不支持");
        } catch (IOException e) {
            logger.error("解析Excel文件异常",e);
            throw new BusinessException("解析Excel文件异常");
        }
    }

    private static void appendCellValue(Cell cell,StringBuffer content){
        int cellType=cell.getCellType();
        switch (cellType){
            case Cell.CELL_TYPE_BOOLEAN:
                content.append(cell.getBooleanCellValue()?1:0);
                break;
            case Cell.CELL_TYPE_NUMERIC:
                content.append(df.format(cell.getNumericCellValue()));
                break ;
            case Cell.CELL_TYPE_STRING:
                 content.append(filerStringValue(cell.getStringCellValue().replaceAll("\r|\n", "")));
                 break;
            default:
        }
    }

    public static Object filerStringValue(String src){
        //todo 日期处理
        if(Arrays.asList(GlobalConstant.TRUE_BOOLEAN.split(GlobalConstant.SEPARATOR)).contains(src))
            return 1;
        if(Arrays.asList(GlobalConstant.FALSE_BOOLEAN.split(GlobalConstant.SEPARATOR)).contains(src))
            return 0;
        return src;
    }

    private static void validateHeader(BufferedInputStream inputStream,Row header,String[] headerNames){
        Cell headerCell=null;
        for (int i=0;i<headerNames.length;i++){
            headerCell=header.getCell(i);
            if(header==null || !headerCell.getStringCellValue().toString().equals(headerNames[i])) {
                closeInputStream(inputStream);
                throw new BusinessException("模板格式不正确");
            }
        }
    }

    private static void closeInputStream(BufferedInputStream inputStream){
        if(inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
