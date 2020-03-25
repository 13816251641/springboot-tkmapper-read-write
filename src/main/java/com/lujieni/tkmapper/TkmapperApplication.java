package com.lujieni.tkmapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.**.dao") //扫描的mapper接口
public class TkmapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkmapperApplication.class, args);
    }

}
