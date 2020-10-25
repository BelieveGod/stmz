package com.stmz.mgr.repository;

import com.stmz.mgr.entity.MenuItem;
import com.stmz.mgr.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName MenuItemDao
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:53
 * @Version 1.0
 */
public interface MenuItemDao extends JpaRepository<MenuItem,Long>, JpaSpecificationExecutor<MenuItem> {

}
