package com.stmz.mgr.actionExtend.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/17 9:28
 */

@Configuration
@ComponentScan(basePackages = {"com.stmz.mgr.actionExtend"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {


}
