package com.wen.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseImportInfo {
    /**
     * 导入操作ID
     */
    private String oid;
    /**
     * 导入操作的业务ID
     */
    private String bid;


}