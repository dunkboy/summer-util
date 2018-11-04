package org.poor.framework.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.poor.framework.test.datasource.DataSourceSupport;
import org.poor.framework.utils.annotation.DataSource;
import org.poor.framework.utils.string.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: DataSourceAop</p>
 * <p>Description: DataSourceAop</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/3 11:39</p>
 * @author cb
 * @version 1.0
 **/
@Aspect
@Slf4j
@Component
@Order(1)
public class DataSourceAop
{
    //@within在类上设置
    //@annotation在方法上进行设置
    @Pointcut("@within(org.poor.framework.utils.annotation.DataSource)||@annotation(org.poor.framework.utils.annotation.DataSource)")
    public void pointcut()
    {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint)
    {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取方法上的注解
        DataSource annotationClass = method.getAnnotation(DataSource.class);
        if (annotationClass == null)
        {
            //获取类上面的注解
            annotationClass = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
            if (annotationClass == null)
            {
                return;
            }
        }
        //获取注解上的数据源的值的信息
        String dataSourceKey = annotationClass.value();
        if (!StringUtils.isBlank(dataSourceKey))
        {
            //给当前的执行SQL的操作设置特殊的数据源的信息
            DataSourceSupport.put(dataSourceKey);
        }
        log.info("AOP动态切换数据源，className" + joinPoint.getTarget().getClass().getName() + "methodName" + method.getName() + ";dataSourceKey:" + dataSourceKey == "" ? "默认数据源" : dataSourceKey);
    }

    @After("pointcut()")
    public void after(JoinPoint point)
    {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        DataSourceSupport.clear();
    }

}
