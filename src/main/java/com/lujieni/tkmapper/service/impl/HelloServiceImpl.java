package com.lujieni.tkmapper.service.impl;

import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.dynamic.AnotherDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl {

    @Autowired
    private StudentDao studentDao;

    @AnotherDatasource(value = "master")
    public StudentPO show(Integer id){
        return studentDao.selectByPrimaryKey(id);
    }
}