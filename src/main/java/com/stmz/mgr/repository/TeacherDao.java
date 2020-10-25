package com.stmz.mgr.repository;

import com.stmz.mgr.entity.Role;
import com.stmz.mgr.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherDao extends JpaRepository<Teacher,Long>, JpaSpecificationExecutor<Teacher> {

    Teacher findByUserName(String userName);
}
