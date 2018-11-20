package org.poor.framework.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: Column</p>
 * <p>Description: Column</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/7 18:07</p>
 * @author cb
 * @version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column
{
    /**
     * 批量插入字段选择 false不要 true要要
     */
    boolean batchInsert() default false;

    /**
     * 批量更新字段选择 false不要 true要要
     */
    boolean batchUpdateSet() default false;

    /**
     * 批量更新过滤字段选择 false不要 true要要
     */
    boolean batchUpdateFilter() default false;

    /**
     * 批量合并更新字段选择 false不要 true要要
     */
    boolean batchSaveOrUpdate() default false;

}
