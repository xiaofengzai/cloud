package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserGroupRole  {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户组
     */
    @Column(name = "user_group_id",updatable = false,length = 36)
    private String userGroupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_group_id",insertable = false,updatable = false)
    private UserGroup userGroup;


    /**
     * 角色主键
     */
    @Column(name = "role_id",updatable = false,length = 36)
    private String roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;
}