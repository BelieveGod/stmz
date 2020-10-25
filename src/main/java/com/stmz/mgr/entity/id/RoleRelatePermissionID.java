package com.stmz.mgr.entity.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName RoleRelatePermissionID
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:23
 * @Version 1.0
 */
public class RoleRelatePermissionID implements Serializable {

    private Long roleId;

    private Long PermissionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRelatePermissionID that = (RoleRelatePermissionID) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(PermissionId, that.PermissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, PermissionId);
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Long permissionId) {
        PermissionId = permissionId;
    }
}
