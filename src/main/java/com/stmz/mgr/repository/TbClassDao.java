package com.stmz.mgr.repository;

import com.stmz.mgr.entity.Role;
import com.stmz.mgr.entity.TbClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName TbClassDao
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/23 15:58
 * @Version 1.0
 */
public interface TbClassDao extends JpaRepository<TbClass,Long>, JpaSpecificationExecutor<TbClass> {


}
