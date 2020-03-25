package com.lujieni.tkmapper.mybatis.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class BasicEntity {
    @Id
    @Column(
            name = "id"
    )
    private Integer id;
}
