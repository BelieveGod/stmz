package com.stmz.mgr.entity.id;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName RoleRelateMenuItemID
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:25
 * @Version 1.0
 */
public class RoleRelateMenuItemID implements Serializable {
    private Long roleId;

    private Long MenuItemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRelateMenuItemID that = (RoleRelateMenuItemID) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(MenuItemId, that.MenuItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, MenuItemId);
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuItemId() {
        return MenuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        MenuItemId = menuItemId;
    }
}
