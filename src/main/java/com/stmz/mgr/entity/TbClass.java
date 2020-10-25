package com.stmz.mgr.entity;

import javax.persistence.*;

/**
 * @ClassName TbClass
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:42
 * @Version 1.0
 */
@Entity
@Table
public class TbClass {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

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
}
