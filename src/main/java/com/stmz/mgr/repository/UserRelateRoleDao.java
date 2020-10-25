package com.stmz.mgr.repository;

import com.stmz.mgr.entity.Role;
import com.stmz.mgr.entity.UserRelateRole;
import com.stmz.mgr.entity.id.UserRelateRoleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName UserRelateRoleDao
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:52
 * @Version 1.0
 */
public interface UserRelateRoleDao extends JpaRepository<UserRelateRole, UserRelateRoleID>, JpaSpecificationExecutor<UserRelateRole> {
    List<UserRelateRole> findByUserId(Long userId);



}
