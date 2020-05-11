package com.lujieni.tkmapper.service.impl;

import com.lujieni.tkmapper.dynamic.AnotherDatasource;
import com.lujieni.tkmapper.mybatis.service.AbstractBaseService;
import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import com.lujieni.tkmapper.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl extends AbstractBaseService<StudentDao, StudentPO> implements IStudentService {
    @Override
    public List<StudentVO> findStudentByName() {
        return dao.findStudentByName("陆捷旎");
    }

    @Override
    @AnotherDatasource
    public StudentPO findStudentById() {
        return dao.selectByPrimaryKey(1);
    }

    @Override
    @Transactional //自己配置数据源,事务也是能生效的
    public Integer insertOne() {
        int num = dao.insert(new StudentPO().setName("张飞2").setAge(77));
        int i = 5/0;
        return num;
    }
}
