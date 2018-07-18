package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserRole  {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户

     */
    @Column(name = "user_id",updatable = false,length = 36)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    /**
     * 角色id
     */
    @Column(name = "role_id",updatable = false,length = 36)
    private String roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private Role role;
}