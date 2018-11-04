package org.poor.framework.test.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: DynamicDataSource</p>
 * <p>Description: DynamicDataSource</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/2 14:51</p>
 * @author cb
 * @version 1.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource
{
    @Override
    protected Object determineCurrentLookupKey()
    {
        return DataSourceSupport.get();
    }
}
