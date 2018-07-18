package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Operation {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作名称
     */
    @Column(name = "operation_name")
    private String operationName;

    /**
     * 操作编码
     */
    @Column(name = "operation_code")
    private String operationCode;

    /**
     * 拦截的url
     */
    private String url;

    /**
     * 父级操作id
     */
    @Column(name = "parent_id")
    private String parentId;
}