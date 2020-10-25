package com.stmz.mgr.repository;

import com.stmz.mgr.entity.RoleRelateMenuItem;
import com.stmz.mgr.entity.UserRelateRole;
import com.stmz.mgr.entity.id.RoleRelateMenuItemID;
import com.stmz.mgr.entity.id.UserRelateRoleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleRelateMenuItemDao extends JpaRepository<RoleRelateMenuItem, RoleRelateMenuItemID>, JpaSpecificationExecutor<RoleRelateMenuItem> {
        List<RoleRelateMenuItem> findByRoleId(Long roleId);

}
