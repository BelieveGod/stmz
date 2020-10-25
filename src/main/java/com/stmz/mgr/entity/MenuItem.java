package com.stmz.mgr.entity;

import javax.persistence.*;

/**
 * @ClassName MenuItem
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 7:53
 * @Version 1.0
 */
@Entity
@Table(name="TB_MENU_ITEM")
public class MenuItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String url;

    private Long parentId;

    private Boolean Leaf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean isLeaf() {
        return Leaf;
    }

    public void setLeaf(Boolean leaf) {
        Leaf = leaf;
    }
}
