package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PermissionOperation  {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 权限主键id
     */
    @Column(name = "permission_id",updatable = false,length = 36)
    private String permissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id",insertable = false,updatable = false)
    private Permission permission;

    /**
     * 操作id
     */
    @Column(name = "operation_id",updatable = false,length = 36)
    private String operationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id",insertable = false,updatable = false)
    private Operation operation;
}