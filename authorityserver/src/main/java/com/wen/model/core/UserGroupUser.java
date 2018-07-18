package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserGroupUser {
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
     * 用户ID
     */
    @Column(name = "user_id",updatable = false,length = 36)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

}