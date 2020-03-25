package com.lujieni.tkmapper.service;

import com.lujieni.tkmapper.domain.vo.StudentVO;

import java.util.List;

public interface IStudentService {
    List<StudentVO> findStudentByName();
}
