package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Permission {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限类型
     */
    @Column(name = "permission_type")
    private String permissionType;

}