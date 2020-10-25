package com.stmz.mgr.service;

import com.stmz.mgr.entity.Teacher;
import com.stmz.mgr.repository.TeacherDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName TeacherService
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/22 11:37
 * @Version 1.0
 */

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    public Page<Teacher> listTeacher(Integer page,Integer limit,String teacherSn){
        Teacher t=new Teacher();
//        if(StringUtils.isNoneBlank(teacherSn)){
//            t.setTeacherSn(teacherSn);
//        }
//        Example<Teacher> example = Example.of(t);
//        Page<Teacher> teacherPage = teacherDao.findAll(example,PageRequest.of(page-1, limit));

        /*
            用 JPA Specification 的方式
         */
        Page<Teacher> teacherPage = teacherDao.findAll((r,q,b)->{
            Predicate teacherSnEqual=null;
            if(StringUtils.isNoneBlank(teacherSn)){

                teacherSnEqual = b.equal(r.get("teacherSn"), teacherSn);
            }
            return teacherSnEqual;
        }, PageRequest.of(page-1, limit));

        return  teacherPage;
    }

    public Teacher saveTeacher(Teacher teacher){
        return teacherDao.save(teacher);
    }


    public List<Teacher> listTeacher(){
        return  teacherDao.findAll();
    }

    public Teacher findTeacherById(Long id){
        Optional<Teacher> byId = teacherDao.findById(id);
        return byId.orElse(null);
    }

    public void removeTeacher(Long id){
        teacherDao.deleteById(id);
    }

    public Teacher findByUserName(String userName){
        return teacherDao.findByUserName(userName);
    }
}
