package com.stmz.mgr.controller;

import com.stmz.mgr.entity.TbClass;
import com.stmz.mgr.entity.Teacher;
import com.stmz.mgr.service.CourseService;
import com.stmz.mgr.service.TbClassService;
import com.stmz.mgr.service.TeacherService;
import com.stmz.mgr.support.Result;
import com.stmz.mgr.vo.CourseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/23 15:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    private static final transient Logger logger= LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TbClassService tbClassService;

    @GetMapping("/panel")
    private String toPanel(){
        return "coursePanel";
    }

    @GetMapping("/courses")
    @ResponseBody
    public Result listCourse(Integer page,Integer limit,String teacherSn){
        Page<CourseVO> courseVOPage=null;
        if(StringUtils.isBlank(teacherSn)){
            courseVOPage = courseService.listCourse(page, limit);
        }
        else{
            courseVOPage=courseService.listCourse(page,limit,teacherSn);
        }

        Result result = new Result();
        result.setCode(0);
        result.setMsg("");
        result.setCount((int)courseVOPage.getTotalElements());
        result.setData(courseVOPage.getContent());
        return result;
    }

    @GetMapping("/course")
    public String toAddCourse(Model model){
        List<TbClass> tbClasses = tbClassService.listClass();
        List<Teacher> teachers = teacherService.listTeacher();
        model.addAttribute("tbClasses",tbClasses);
        model.addAttribute("teachers",teachers);
        return "courseInfo";
    }

    @GetMapping("/{teacherId:\\d+}/{classId:\\d+}")
    public String toViewCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("classId") Long classId, Model model){

        CourseVO courseVO = courseService.findById(teacherId, classId);
        model.addAttribute("courseVO",courseVO);
        return "courseInfo";

    }

    @PostMapping("/course")
    @ResponseBody
    public Result addCourse(@RequestBody CourseVO courseVO){
        try {
            courseService.saveCourse(courseVO);
        }catch (Exception e){
            logger.error("添加错误",e);
            return Result.fail();
        }
        return Result.ok();
    }


    @PutMapping("/{teacherId:\\d+}/{classId:\\d+}")
    @ResponseBody
    public Result updateCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("classId") Long classId,@RequestBody CourseVO courseVO){
        logger.info("保存{}",courseVO.toString());

        return Result.ok();
    }

    @DeleteMapping("/{teacherId:\\d+}/{classId:\\d+}")
    @ResponseBody
    public Result removeCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("classId") Long classId){
        logger.info("删除{}/{}",teacherId,classId);
        courseService.removeCourse(teacherId,classId);
        return Result.ok();
    }



}
