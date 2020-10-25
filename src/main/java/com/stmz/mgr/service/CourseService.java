package com.stmz.mgr.service;

import com.stmz.mgr.entity.TbClass;
import com.stmz.mgr.entity.Teacher;
import com.stmz.mgr.entity.TeacherRelateClass;
import com.stmz.mgr.entity.id.TeacherRelateClassID;
import com.stmz.mgr.repository.TbClassDao;
import com.stmz.mgr.repository.TeacherDao;
import com.stmz.mgr.repository.TeacherRelateClassDao;
import com.stmz.mgr.vo.CourseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import java.util.*;

/**
 * @ClassName TeacherRelateClassService
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/23 16:02
 * @Version 1.0
 */
@Service
public class CourseService {
    private static final transient Logger logger= LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TbClassDao tbClassDao;
    @Autowired
    private TeacherRelateClassDao teacherRelateClassDao;

    public Page<CourseVO> listCourse(Integer page,Integer limit,String teacherSn){
        if(StringUtils.isBlank(teacherSn)){
            throw new IllegalArgumentException("teacherSn 不能为空白");
        }
        Pageable pageAble = PageRequest.of(page - 1, limit);


        Optional<Teacher> teacherOpt = teacherDao.findOne((r, q, b) -> {
                return b.equal(r.get("teacherSn"), teacherSn);
        });
        Teacher teacher= teacherOpt.get();


        Page<TeacherRelateClass> teacherRelateClassPage = teacherRelateClassDao.findAll((r, q, b) -> {
            if(teacher.getId()==null){
                throw new NullPointerException("teacherId 为空");
            }
                return b.equal(r.get("teacherId"),teacher.getId());
        },pageAble);

        return transform(teacherRelateClassPage);
    }

    public Page<CourseVO> listCourse(Integer page,Integer limit) {
        Pageable pageAble = PageRequest.of(page - 1, limit);
        List<CourseVO> couseVOList=new LinkedList<>();

        Page<TeacherRelateClass> teacherRelateClassPage = teacherRelateClassDao.findAll(pageAble);
        return transform(teacherRelateClassPage);

    }

    private  Page<CourseVO> transform(Page<TeacherRelateClass> teacherRelateClassPage){
        List<CourseVO> couseVOList=new LinkedList<>();

        List<TeacherRelateClass> content = teacherRelateClassPage.getContent();
        content.forEach(item -> {
            couseVOList.add(transform(item));
        });

        return new PageImpl(couseVOList, teacherRelateClassPage.getPageable(), teacherRelateClassPage.getTotalElements());
    }

    public CourseVO transform(TeacherRelateClass teacherRelateClass){
        Optional<TbClass> byId = tbClassDao.findById(teacherRelateClass.getClassId());
        TbClass tbClass = byId.get();
        Optional<Teacher> byId1 = teacherDao.findById(teacherRelateClass.getTeacherId());
        Teacher teacher1 = byId1.get();
        // 转换
        CourseVO courseVO=new CourseVO();
        courseVO.setClassId(tbClass.getId());
        courseVO.setClassName(tbClass.getName());
        courseVO.setTeacherId(teacher1.getId());
        courseVO.setTeacherName(teacher1.getName());
        courseVO.setTeacherSn(teacher1.getTeacherSn());
        courseVO.setSubjectName(teacher1.getSubjectName());
        return courseVO;
    }

    public CourseVO findById(Long teacherId,Long classId){
        TeacherRelateClassID id= new TeacherRelateClassID();
        id.setTeacherId(teacherId);
        id.setClassId(classId);

        Optional<TeacherRelateClass> byId = teacherRelateClassDao.findById(id);
        TeacherRelateClass teacherRelateClass = byId.get();
        return transform(teacherRelateClass);
    }

    public CourseVO saveCourse(CourseVO courseVO){
        TeacherRelateClass teacherRelateClass=new TeacherRelateClass();
        teacherRelateClass.setClassId(courseVO.getClassId());
        teacherRelateClass.setTeacherId(courseVO.getTeacherId());
        teacherRelateClassDao.save(teacherRelateClass);
        return courseVO;

    }

    public void removeCourse(Long teacherId,Long classId){
        TeacherRelateClassID id=new TeacherRelateClassID();
        id.setClassId(classId);
        id.setTeacherId(teacherId);
        teacherRelateClassDao.deleteById(id);
    }
}
