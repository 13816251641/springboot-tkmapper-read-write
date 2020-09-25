package com.lujieni.tkmapper.controller;

import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import com.lujieni.tkmapper.service.IStudentService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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

    @RequestMapping(value = "/v1/findStudentById", method = RequestMethod.GET)
    public StudentPO findStudentById(){
        StudentPO studentPO = studentService.findStudentById(1);
        return studentPO;
    }

    @RequestMapping(value = "/v1/insertOne", method = RequestMethod.GET)
    public Integer insertOne() throws Exception {
        Integer integer = studentService.insertOne();
        return integer;
    }
}
