package com.lujieni.tkmapper.service.impl;

import com.lujieni.tkmapper.dynamic.AnotherDatasource;
import com.lujieni.tkmapper.mybatis.service.AbstractBaseService;
import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import com.lujieni.tkmapper.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImpl extends AbstractBaseService<StudentDao, StudentPO> implements IStudentService {

    @Autowired
    private HelloServiceImpl helloService;

    @Override
    public List<StudentVO> findStudentByName() {
        return super.dao.findStudentByName("陆捷旎");
    }


    @Override
    @AnotherDatasource(value = "slave")
    public StudentPO findStudentById(Integer id) {
        System.out.println("findStudentById");

        /*
         StudentPO show = show(id);//S 方法中直接调用本类方法不会发生代理
         StudentPO show2 = helloService.show(id);//M 方法中调用其他类的方法会代理
         return super.dao.selectByPrimaryKey(id);//M
        */
        helloService.insert();//先查从,在插入主,主中的事务是生效的
        return null;
    }


    @AnotherDatasource(value = "master")
    public StudentPO show(Integer id){
        return super.dao.selectByPrimaryKey(id);
    }

    /*
        自己配置数据源,事务也是能生效的
        @Transactional在非public修饰的方法使用并不会抛出异常,但是会导致事务失效
        @Transactional(rollbackFor = Exception.class) @Transactional默认只回滚运行时异常(继承自RuntimeException的异常)或者Error才回滚事务,这样配置运行和非运行时异常都回滚
        @Transactional(noRollbackFor = ArithmeticException.class) 5/0 数学异常不回滚
        @Transactional(rollbackFor = NullPointerException.class) ArithmeticException也会回滚,这点要注意
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @AnotherDatasource
    public Integer insertOne() throws Exception {
        int num = dao.insert(new StudentPO().setName("张飞2").setAge(77));
        throw new IOException();
    }
}
