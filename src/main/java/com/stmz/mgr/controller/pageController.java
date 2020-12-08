package com.stmz.mgr.controller;

import com.stmz.mgr.entity.MenuItem;
import com.stmz.mgr.entity.Role;
import com.stmz.mgr.entity.Teacher;
import com.stmz.mgr.entity.User;
import com.stmz.mgr.service.TeacherService;
import com.stmz.mgr.service.UserService;
import com.stmz.mgr.support.Result;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName pageController
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 7:17
 * @Version 1.0
 */
@Controller
public class pageController {
    private static final transient Logger logger= LoggerFactory.getLogger(pageController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/manage")
    public String toManage( Model model){
        Subject subject = SecurityUtils.getSubject();
        User user =(User)subject.getSession().getAttribute("user");
//        User user = userService.findByUserId(userId);
        List<Role> roles = userService.findRoleByUserId(user.getId());
        Role role = roles.get(0);
        List<MenuItem> menuItems = userService.findMenuItemByRoleId(role.getId());
        model.addAttribute("user",user);
        model.addAttribute("menuItems", menuItems);

        return "dashboard";
    }

    @GetMapping("/menuItems")
    @ResponseBody
    public List<MenuItem> getMenuItems(Long roleId){
        return userService.findMenuItemByRoleId(roleId);
    }

    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login( String userName,String password){
        // todo
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            User user = userService.findByUserName(userName);
            // 缓存 user
            subject.getSession().setAttribute("user",user);
            if(subject.hasRole("教师")){
                Teacher teacher = teacherService.findByUserName(user.getUserName());
                subject.getSession().setAttribute("teacher",teacher);
            }
        }catch (AuthenticationException e){
            logger.info("{}:{},登陆失败", userName, password);
            return Result.fail();
        }
        return Result.ok();
    }


    @RequestMapping("/test")
    @ResponseBody
    public Result test() throws Exception {
        return null;
    }

    @RequestMapping("/msg")
    @ResponseBody
    public Result msg() throws Exception {
        return Result.ok();
    }
}
