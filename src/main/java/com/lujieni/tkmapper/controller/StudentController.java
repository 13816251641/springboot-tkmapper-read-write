package com.lujieni.tkmapper.controller;

import com.lujieni.tkmapper.domain.vo.StudentVO;
import com.lujieni.tkmapper.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/v1/findStudentByName", method = RequestMethod.GET)
    public List<StudentVO> findStudentByName(){
        return studentService.findStudentByName();
    }



}
