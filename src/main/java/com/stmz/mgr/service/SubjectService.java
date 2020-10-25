package com.stmz.mgr.service;

import com.stmz.mgr.controller.TeacherController;
import com.stmz.mgr.entity.Subject;
import com.stmz.mgr.repository.SubjectDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SubjectService
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/23 15:17
 * @Version 1.0
 */
@Service
public class SubjectService {

    private static final transient Logger logger= LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> listSubjects(){
        return subjectDao.findAll();
    }
}
