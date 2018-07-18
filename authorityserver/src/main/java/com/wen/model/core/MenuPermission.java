package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MenuPermission   {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 菜单主键
     */
    @Column(name = "menu_id",updatable = false,length = 36)
    private String menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id",insertable = false,updatable = false)
    private Menu menu;

    /**
     * 权限主键id
     */
    @Column(name = "permission_id",updatable = false,length = 36)
    private String permissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id",insertable = false,updatable = false)
    private Permission permission;
}