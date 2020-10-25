package com.stmz.mgr.repository;

import com.stmz.mgr.entity.Role;
import com.stmz.mgr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName RoleDao
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:51
 * @Version 1.0
 */
public interface RoleDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {

}
