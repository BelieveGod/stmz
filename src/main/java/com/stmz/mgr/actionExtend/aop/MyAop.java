package com.stmz.mgr.actionExtend.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAop {

    @Pointcut("execution(* com.stmz.mgr.actionExtend.service.HCService.logout(..))")
    public void point(){}


//    @Before(value = "execution(* com.stmz.mgr.actionExtend.service.HCService.login(String,String)) && args(userName,password)" )
    public void before(JoinPoint joinPoint, String userName, String password){
        System.out.println("初始化资源");
        userName = userName + "##";
        password = password + "##";
    }

    @After("point()")
    public void after(){
        System.out.println("after 资源");
    }


    @AfterReturning("point()")
    public void afterReturn(){
        System.out.println("afterReturn 资源");
    }

    @AfterThrowing("point()")
    public void afterThrow(){
        System.out.println("afterThrow 资源");
    }

    @Around("point()")
    public Object arround(ProceedingJoinPoint pj) throws Throwable {
        try {

            Object proceed = pj.proceed();
            boolean result=(boolean)proceed;
            System.out.println("注销结果"+result);
            return !result;
        } catch (Throwable throwable) {
            System.out.println("Around 异常");
//            throwable.printStackTrace();
            throw throwable;
        }

    }

    @Around("execution(* com.stmz.mgr.actionExtend.service.HCService.login(String,String)) && args(userName,password) ")
    public void arround(ProceedingJoinPoint pj, String userName, String password){
        try {
            System.out.println("Around 初始化");
            System.out.println("userName = " + userName);
            System.out.println("password = " + password);
            userName=userName+"##";
            password=password+"##";
            Object[] objs=new Object[]{userName,password};
            pj.proceed(objs);
            System.out.println("Around 释放资源");
        } catch (Throwable throwable) {
            System.out.println("Around 异常");
            throwable.printStackTrace();
        }
    }


}
