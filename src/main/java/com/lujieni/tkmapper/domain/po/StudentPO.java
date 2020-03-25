package com.lujieni.tkmapper.domain.po;


import com.lujieni.tkmapper.mybatis.entity.BasicEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_student")
@Data
public class StudentPO extends BasicEntity {
    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;
}
