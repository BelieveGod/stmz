package com.stmz.mgr.actionExtend.service;

import org.springframework.stereotype.Service;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/17 9:19
 */

@Service
public class HCService {

    public void login(String userName,String password){
        System.out.println("登录:"+userName+":"+password);
//        throw new RuntimeException("登录异常");

    }

    public  boolean logout(){
        System.out.println("注销");
        if(true) {
            throw new RuntimeException("人为异常");
        }
        return true;
    }


}
