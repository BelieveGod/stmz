package com.stmz.mgr.entity.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName UserRelateRoleID
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:04
 * @Version 1.0
 */
public class UserRelateRoleID implements Serializable {

    private Long userId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRelateRoleID that = (UserRelateRoleID) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}
