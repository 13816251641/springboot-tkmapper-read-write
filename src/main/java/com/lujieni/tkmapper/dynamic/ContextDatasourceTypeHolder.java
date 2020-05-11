package com.lujieni.tkmapper.dynamic;

import org.springframework.context.annotation.Configuration;

/**
 * @Auther lujieni
 * @Date 2020/4/16
 *
 */
@Configuration
public class ContextDatasourceTypeHolder {
    /*
       ThreadLocal为static的唯一原因就是别的方法都是static的
     */
    private static ThreadLocal<String> datasourceTypeHolder = new ThreadLocal<>();
    /**
     * 设置当前操作的数据源类型
     */
    public static void setDatasourceType(String dataSourceType) {
        datasourceTypeHolder.set(dataSourceType);
    }

    /**
     * 获取当前操作的数据源类型
     */
    public static String getDatasourceType() {
        return datasourceTypeHolder.get();
    }

    /**
     * 每次使用完ThreadLocal，都调用它的remove()方法，清除数据
     */
    public static void clearDatasourceType() {
        datasourceTypeHolder.remove();
    }

}
