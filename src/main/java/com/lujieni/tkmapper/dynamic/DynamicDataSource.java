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

    /**
     * 从Holder中获取当前操作的数据源类型，交由spring去获取相应的数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return ContextDatasourceTypeHolder.getDatasourceType();
    }
}
