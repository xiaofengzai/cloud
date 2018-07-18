package com.wen.excel;

import com.wen.GlobalConstant;
import com.wen.FileUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * Created by szty on 2018/5/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvConvertConfig extends BaseImportInfo {
    /**
     * 读取数据的起始行，默认去掉Excel第一行的表头
     */
    private Integer startRowIndex=1;
    /**
     * csv的字段分隔符
     */
    private String separator= GlobalConstant.SEPARATOR;
    /**
     * csv的换行符
     */
    private String newLine= GlobalConstant.NEW_LINE;
    /**
     * 指定写入Excel的指定列索引，空则写入所有列
     */
    private Integer[] filterRows={};
    /**
     * 默认一次写入CSV 200行
     */
    private Integer batchSize=200;

    private String[] headerNames ={};

    public CsvConvertConfig(String oid, String bid) {
        super(oid,bid);
    }

    public CsvConvertConfig(String oid, String bid, Integer[] filterRows) {
        this(oid,bid);
        if(filterRows!=null){
            this.filterRows = filterRows;
        }
    }

    public CsvConvertConfig(String oid, String bid, Integer[] filterRows, String[] headerNames) {
        this(oid,bid,filterRows);
        if(headerNames!=null){
            this.headerNames=headerNames;
        }
    }

    public String getSavePath(){
        return FileUtils.getJarPath()+"contract"+ File.separator+getOid()+".csv";
    }


}
