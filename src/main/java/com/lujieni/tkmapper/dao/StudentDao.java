package com.lujieni.tkmapper.dao;

import com.lujieni.tkmapper.mybatis.basedao.BaseDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.domain.vo.StudentVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends BaseDao<StudentPO> {

        List<StudentVO> findStudentByName(String name);
}
