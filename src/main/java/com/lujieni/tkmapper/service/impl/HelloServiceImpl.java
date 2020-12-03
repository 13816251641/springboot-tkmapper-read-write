package com.lujieni.tkmapper.service.impl;

import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.dynamic.AnotherDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloServiceImpl {

    @Autowired
    private StudentDao studentDao;

    @AnotherDatasource(value = "master")
    public StudentPO show(Integer id){
        return studentDao.selectByPrimaryKey(id);
    }

    /**
     * @Description: 事务是有效的!!!
     * @param
     * @return:
     * @Author: lujieni
     * @Date: 2020/12/3
     */
    @AnotherDatasource(value = "master")
    @Transactional(rollbackFor = Exception.class)
    public void insert(){
        StudentPO p1 = new StudentPO();
        p1.setName("超人");
        p1.setGender("男");
        p1.setAge(99);
        studentDao.insert(p1);

        int i = 5 / 0;

        StudentPO p2 = new StudentPO();
        p1.setName("蝙蝠侠");
        p1.setGender("男");
        p1.setAge(11);
        studentDao.insert(p2);


    }




}