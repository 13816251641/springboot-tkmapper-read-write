package com.lujieni.tkmapper.dao;

import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StudentDao extends Mapper<StudentPO>  { //BaseDao<StudentPO>

        List<StudentVO> findStudentByName(String name);

}
