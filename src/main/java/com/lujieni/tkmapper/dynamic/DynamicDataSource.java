package com.lujieni.tkmapper.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description 路由切换
 * @Auther lujieni
 * @Date 2020/4/16
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ContextDatasourceTypeHolder.getDatasourceType();
    }
}
