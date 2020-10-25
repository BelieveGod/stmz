package com.stmz.mgr.repository;

import com.stmz.mgr.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubjectDao extends JpaRepository<Subject,Long>, JpaSpecificationExecutor<Subject> {
}
