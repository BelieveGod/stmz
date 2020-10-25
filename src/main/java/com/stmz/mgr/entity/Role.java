package com.stmz.mgr.entity;

import javax.persistence.*;

/**
 * @ClassName Role
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 7:51
 * @Version 1.0
 */

@Entity
@Table(name="TB_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
