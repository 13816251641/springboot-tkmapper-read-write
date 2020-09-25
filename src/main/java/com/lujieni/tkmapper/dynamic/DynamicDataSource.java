package com.lujieni.tkmapper.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description 路由切换
 * @Auther lujieni
 * @Date 2020/4/16
 *
 *
 * getConnection()和 getConnection(String username,String password)
 * 我认为是从数据库连接池中去拿连接
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ContextDatasourceTypeHolder.getDatasourceType();
    }
}
