package com.lujieni.tkmapper.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 配置多数据源
 * @Author shen
 * @Date 2019/3/28 0:50
 **/
@Configuration
public class DataSourceConfig {

    //数据源1
    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.master") // application.properteis中对应属性的前缀
        public DataSource master() {
        return new DruidDataSource();
    }

    //数据源2
    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")  // application.properteis中对应属性的前缀
    public DataSource slave() {
        return new DruidDataSource();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();//我们自己定义的类
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(master());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("master",master());
        dsMap.put("slave", slave());

        dynamicDataSource.setTargetDataSources(dsMap);//最终会放入resolvedDataSources中
        return dynamicDataSource;
    }

}

