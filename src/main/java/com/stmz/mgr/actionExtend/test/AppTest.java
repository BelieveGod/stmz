package com.stmz.mgr.actionExtend.test;

import com.stmz.mgr.actionExtend.service.HCService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/17 9:32
 */
public class AppTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        HCService hcService = context.getBean("HCService", HCService.class);
        hcService.login("zhangsan","123");
        boolean logout = hcService.logout();
        System.out.println("logout = " + logout);
    }
}
