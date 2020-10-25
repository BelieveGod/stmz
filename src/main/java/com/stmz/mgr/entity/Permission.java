package com.stmz.mgr.entity;

import javax.persistence.*;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 7:52
 * @Version 1.0
 */

@Entity
@Table(name="TB_PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String permissionString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionString() {
        return permissionString;
    }

    public void setPermissionString(String permissionString) {
        this.permissionString = permissionString;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionString='" + permissionString + '\'' +
                '}';
    }
}
