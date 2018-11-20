package org.poor.framework.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: CustomBaseMapper</p>
 * <p>Description: CustomBaseMapper</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/19 16:53</p>
 * @author cb
 * @version 1.0
 **/
public interface CustomBaseMapper<T> extends BaseMapper<T>
{
    int batchInsert(@Param(Constants.COLLECTION) Collection<T> list);

    int batchUpdate(@Param(Constants.COLLECTION) Collection<T> list);

    int saveOrUpdate(@Param(Constants.COLLECTION) Collection<T> list);


}
