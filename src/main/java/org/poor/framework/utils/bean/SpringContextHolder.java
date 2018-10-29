package org.poor.framework.utils.bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext.
 *
 * @author Xiang QuanChao
 * @date 18/1/24 下午2:03
 */
@Slf4j
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean
{

    /**
     *
     */
    private static ApplicationContext applicationContext;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
    {

        if (SpringContextHolder.applicationContext == null)
        {
            SpringContextHolder.applicationContext = applicationContext;
        }
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(String name)
    {

        if (StringUtils.isBlank(name))
        {
            return null;
        }
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType)
    {

        if (null == requiredType)
        {
            return null;
        }
        return applicationContext.getBean(requiredType);
    }

    /**
     * <p>Description: get bean</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/6/3 14:38</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  id
     * @return T
     */
    public static <T> T get(String id, Class<T> clazz)
    {
        return applicationContext.getBean(id, clazz);
    }

    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy() throws Exception
    {
        applicationContext = null;
    }
}