package com.lujieni.tkmapper.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Auther lujieni
 * @Date 2020/4/16
 */
@Order(Integer.MIN_VALUE)// 保证@AnotherDatasource的切面在@Transactional之前执行
@Aspect
@Component
public class DatasourceChangeAspect {

    /**
     * 根据注解上指定的数据源类型切换数据源
     * @param joinPoint
     */
    @Around("@annotation(AnotherDatasource)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            /* 获取目标类 */
            Class<?> targetClazz = joinPoint.getTarget().getClass();
            /* 获取执行的方法名 */
            String methodName = joinPoint.getSignature().getName();
            /* 获取此方法的参数列表 */
            Class<?>[] par = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
            /* 获取到实际执行的方法 */
            Method objMethod = targetClazz.getMethod(((MethodSignature) joinPoint.getSignature()).getName(), par);
            //从执行的方法上获取注解
            AnotherDatasource annotation = objMethod.getAnnotation(AnotherDatasource.class);
            if (annotation != null) {
                //将注解上指定的数据源类型读取到
                String datasourceType = annotation.value();
                //设置当前处理的数据源类型为注解上指定的
                ContextDatasourceTypeHolder.setDatasourceType(datasourceType);
            }
            Object result = joinPoint.proceed();
            return result;
        } finally {
            ContextDatasourceTypeHolder.clearDatasourceType();
        }
    }


}
