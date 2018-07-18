package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class File {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件路径
     */
    @Column(name = "file_url")
    private String fileUrl;

}