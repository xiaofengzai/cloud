package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserGroup {
    /**
     * 主键
     */
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    /**
     * 用户组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 父级用户组名称
     */
    @Column(name = "parent_group_name")
    private String parentGroupName;

}