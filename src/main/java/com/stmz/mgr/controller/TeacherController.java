package com.stmz.mgr.controller;

import com.stmz.mgr.entity.Subject;
import com.stmz.mgr.entity.Teacher;
import com.stmz.mgr.entity.User;
import com.stmz.mgr.repository.TeacherDao;
import com.stmz.mgr.service.SubjectService;
import com.stmz.mgr.service.TeacherService;
import com.stmz.mgr.service.UserService;
import com.stmz.mgr.support.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.criteria.Predicate;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 13:20
 * @Version 1.0
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private static final transient Logger logger= LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserService userService;

    @RequestMapping("/panel")
    public String toTeacherPanel(){
        return "teacherPanel";
    }

    @GetMapping("/teachers")
    @ResponseBody
    public Result listTeacher(Integer page,Integer limit,String teacherSn){

        Page<Teacher> teacherPage = teacherService.listTeacher(page, limit, teacherSn);
        Result result=new Result();
        result.setCode(0);
        result.setMsg("");
        result.setCount((int)teacherPage.getTotalElements());
        result.setData(teacherPage.getContent());

        return result;
    }


    @GetMapping("/teacher")
    public String toAddTeacher(){
        return "teacherInfo";
    }

    @DeleteMapping("/teachers")
    @ResponseBody
    public Result batchRemoveTeacher(){
        // todo
        return null;
    }

    @GetMapping("/{id:\\d+}")
    public String toViewTeacher(@PathVariable("id") Long id, Model model){
        logger.info("查看ID:{}的老师");
        Teacher teacher = teacherService.findTeacherById(id);

        List<Subject> subjects = subjectService.listSubjects();

        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects",subjects);
        return "teacherInfo";
    }

    @PostMapping("/teacher")
    @ResponseBody
    public Result addTeacher(@RequestBody Teacher teacher){

        logger.info("addTeacher:{}",teacher.toString());
        teacherService.saveTeacher(teacher);

        return Result.ok();
    }

    @PutMapping("/{id:\\d+}")
    @ResponseBody
    public Result updateTeacher(@PathVariable("id") Long id,@RequestBody Teacher teacher){
        logger.info("保存{}",teacher.toString());
        Teacher teacherById = teacherService.findTeacherById(teacher.getId());
        BeanUtils.copyProperties(teacher, teacherById,"userName");

        teacherService.saveTeacher(teacherById);
        return Result.ok();
    }

    @DeleteMapping("/{id:\\d+}")
    @ResponseBody
    public Result removeTeacher(@PathVariable("id") Long id){
        teacherService.removeTeacher(id);
        return Result.ok();
    }


    @GetMapping("/myInfo")
    public String toViewMyInfo( Model model){
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        Teacher teacher = (Teacher)subject.getSession().getAttribute("teacher");
        logger.info("查看ID:{}的老师");

        List<Subject> subjects = subjectService.listSubjects();

        model.addAttribute("teacher", teacher);
        model.addAttribute("subjects",subjects);
        return "teacherInfo";
    }

    @GetMapping("/assign")
    public String toAssign(Model model){
        List<Teacher> teachers = teacherService.listTeacher();
        model.addAttribute("teachers",teachers);
        return "assignAccount";
    }

    @PostMapping("/assign")
    @ResponseBody
    public Result toAssign(@RequestBody Map map, Model model){
        String userName = (String) map.get("userName");
        String password = (String) map.get("password");
        Long teacherId = Long.parseLong((String)map.get("teacherId"));
        User user=new User();

        user.setUserName(userName);
        user.setPassword(password);
        user=userService.saveUser(user);
        userService.relateUserAndRole(user.getId(),2l);

        Teacher teacher = teacherService.findTeacherById(teacherId);
        teacher.setUserName(userName);
        teacherService.saveTeacher(teacher);
        return Result.ok();
    }
}
