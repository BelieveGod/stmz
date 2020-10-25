package com.stmz.mgr.repository;

import com.stmz.mgr.entity.TbClass;
import com.stmz.mgr.entity.TeacherRelateClass;
import com.stmz.mgr.entity.id.TeacherRelateClassID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRelateClassDao extends JpaRepository<TeacherRelateClass, TeacherRelateClassID>, JpaSpecificationExecutor<TeacherRelateClass> {

}
