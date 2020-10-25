package com.stmz.mgr.entity;

import com.stmz.mgr.entity.id.RoleRelateMenuItemID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @ClassName RoleRelateMenuItem
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:27
 * @Version 1.0
 */

@Entity
@Table(name="TB_ROLE_REL_MENU_ITEM")
@IdClass(RoleRelateMenuItemID.class)
public class RoleRelateMenuItem {

    @Id
    private Long roleId;

    @Id
    private Long MenuItemId;

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
