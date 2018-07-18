package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色类型
     */
    @Column(name="role_type")
    private Integer roleType;

}