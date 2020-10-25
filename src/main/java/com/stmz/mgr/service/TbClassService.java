package com.stmz.mgr.service;

import com.stmz.mgr.entity.TbClass;
import com.stmz.mgr.repository.TbClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TbClassService
 * @Description TODO
 * @Author believeGod
 * @Date 2020/10/24 15:38
 * @Version 1.0
 */

@Service
public class TbClassService {


    @Autowired
    private TbClassDao tbClassDao;


    public List<TbClass> listClass(){
        return tbClassDao.findAll();
    }
}
