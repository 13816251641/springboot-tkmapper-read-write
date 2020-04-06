package com.lujieni.tkmapper.service;

import com.lujieni.tkmapper.domain.vo.StudentVO;

import java.util.List;

/**
 * 主要放一些自定义的对表的操作
 */
public interface IStudentService {
    List<StudentVO> findStudentByName();
}
