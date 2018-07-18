package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Page {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 页面元素编码
     */
    @Column(name = "page_code")
    private String pageCode;

}