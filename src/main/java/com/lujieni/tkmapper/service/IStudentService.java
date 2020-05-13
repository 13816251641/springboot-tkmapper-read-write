package com.lujieni.tkmapper.service;

import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import com.lujieni.tkmapper.dynamic.AnotherDatasource;

import java.util.List;

/**
 * 主要放一些自定义的对表的操作
 */
public interface IStudentService {
    List<StudentVO> findStudentByName();

    StudentPO findStudentById();

    Integer insertOne() throws Exception;


}
