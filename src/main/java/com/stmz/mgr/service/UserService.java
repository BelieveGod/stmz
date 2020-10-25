package com.stmz.mgr.service;

import com.stmz.mgr.entity.*;
import com.stmz.mgr.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/17 8:56
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleDao roleDao;


    @Autowired
    private MenuItemDao menuItemDao;


    @Autowired
    private RoleRelateMenuItemDao roleRelateMenuItemDao;

    @Autowired
    private UserRelateRoleDao userRelateRoleDao;

    public List<MenuItem> findMenuItemByRoleId(Long roleId){
        List<RoleRelateMenuItem> byRoleId = roleRelateMenuItemDao.findByRoleId(roleId);
        List<Long> menuItemIds = new LinkedList<>();
        byRoleId.forEach(roleRelateMenuItem -> menuItemIds.add(roleRelateMenuItem.getMenuItemId()));

        return menuItemDao.findAllById(menuItemIds);

    }

    public List<Role> findRoleByUserId(Long userId){
        List<UserRelateRole> byUserId = userRelateRoleDao.findByUserId(userId);
        List<Long> roleIds = new LinkedList<>();
        byUserId.forEach(userRelateRole -> roleIds.add(userRelateRole.getRoleId()));

        return roleDao.findAllById(roleIds);
    }

    public User findByUserId(Long userId){
        Optional<User> byId = userRepository.findById(userId);
        return byId.orElse(null);
    }

    public User findByUserName(String userName){
       return  userRepository.findByUserName(userName);
    }

    public void relateUserAndRole(Long userId,Long roleId){
        UserRelateRole userRelateRole=new UserRelateRole();
        userRelateRole.setUserId(userId);
        userRelateRole.setRoleId(roleId);
        userRelateRoleDao.save(userRelateRole);
    }

    public User saveUser(User user){
        return userRepository.save(user);

    }
}
