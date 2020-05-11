package com.lujieni.tkmapper.dynamic;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotherDatasource {

    /**
     * 使用此注解所指定的数据源查找的key，默认为从库，
     * 如果使用此注解就认为不想使用原来的主库，所以此处默认为slave，
     * 如果后续增加其他数据库配置，使用此注解的地方修改查找的key即可，框架不需要做修改
     */
    String value() default "slave";

}
