package com.stmz.mgr.entity;

import com.stmz.mgr.entity.id.UserRelateRoleID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @ClassName UserRelateRole
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 7:59
 * @Version 1.0
 */
@Entity
@Table(name="TB_USER_REL_ROLE")
@IdClass(UserRelateRoleID.class)
public class UserRelateRole {

    @Id
    private Long userId;

    @Id
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


}
