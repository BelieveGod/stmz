package com.stmz.mgr.shiro.realm;

import com.stmz.mgr.controller.TeacherController;
import com.stmz.mgr.entity.Role;
import com.stmz.mgr.entity.User;
import com.stmz.mgr.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MyRealm
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/23 8:42
 * @Version 1.0
 */
public class MyRealm extends AuthorizingRealm {
    private static final transient Logger logger= LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName=(String) principalCollection.getPrimaryPrincipal();
        User user = userService.findByUserName(userName);
        List<Role> roles = userService.findRoleByUserId(user.getId());
        Set<String> roleNames = new HashSet<>();
        roles.forEach(role -> {roleNames.add(role.getRoleName()); } );
        SimpleAuthorizationInfo authorizationInfo =new SimpleAuthorizationInfo(roleNames);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName =(String) authenticationToken.getPrincipal();

        User user = userService.findByUserName(userName);
        if(user == null){
            logger.info("userName:{}的用户不存在", userName);
            throw new UnknownAccountException("找不到此用户");
        }

        return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
    }
}
