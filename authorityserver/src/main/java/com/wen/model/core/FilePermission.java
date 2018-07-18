package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FilePermission  {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件主键id
     */
    @Column(name = "file_id",updatable = false,length = 36)
    private String fileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id",insertable = false,updatable = false)
    private File file;

    /**
     * 权限主键id
     */
    @Column(name = "permission_id",updatable = false,length = 36)
    private String permissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id",insertable = false,updatable = false)
    private Permission permission;
}