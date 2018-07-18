package com.wen.excel;

import com.wen.myeunm.TimeFormatEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by szty on 2018/6/11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SheetConfig {
    List<SheetHeader> currentHeaders;
    private Map<String,TimeFormatEnum> timeFormatMap=null;
    String sheetNameTemplate;

    public SheetConfig(List<SheetHeader> currentHeaders, Map<String, TimeFormatEnum> timeFormatMap) {
        this.currentHeaders = currentHeaders;
        this.timeFormatMap = timeFormatMap;
    }

    public SheetConfig(List<SheetHeader> currentHeaders) {
        this(currentHeaders,new HashMap<>());

    }
}
