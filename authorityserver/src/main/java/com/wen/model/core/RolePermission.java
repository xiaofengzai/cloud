package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RolePermission {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 角色主键
     */
    @Column(name = "role_id",updatable = false,length = 36)
    private String roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;

    /**
     * 权限主键id
     */
    @Column(name = "permission_id",updatable = false,length = 36)
    private String permissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id",insertable = false,updatable = false)
    private Permission permission;

}