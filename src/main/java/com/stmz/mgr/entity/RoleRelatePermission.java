package com.stmz.mgr.entity;

import com.stmz.mgr.entity.id.RoleRelatePermissionID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @ClassName RoleRelatePermission
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:29
 * @Version 1.0
 */

@Entity
@Table(name="TB_ROLE_REL_PERMISSION")
@IdClass(RoleRelatePermissionID.class)
public class RoleRelatePermission {

    @Id
    private Long roleId;

    @Id
    private Long PermissionId;

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
