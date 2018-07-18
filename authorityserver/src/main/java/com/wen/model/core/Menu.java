package com.wen.model.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Menu {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单URL
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 父级菜单
     */
    @Column(name = "parent_m_id")
    private Integer parentMId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}