package org.poor.framework.test.datasource;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: DataSourceSupport</p>
 * <p>Description: DataSourceSupport</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/2 14:53</p>
 * @author cb
 * @version 1.0
 **/
public class DataSourceSupport
{
    private static ThreadLocal<String> datasourceThredLocal = new ThreadLocal<String>();

    /**
     * <p>Description: 设置当前线程的数据源</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/11/2 15:05</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  key 数据源标识
     */
    public static void put(String key)
    {
        datasourceThredLocal.set(key);
    }

    /**
     * <p>Description: 返回数据源key</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/11/2 15:07</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @return String
     */
    public static String get()
    {
        return datasourceThredLocal.get();
    }

    /**
     * <p>Description: 清除数据源</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/11/2 15:25</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     */
    public static void clear()
    {
        datasourceThredLocal.remove();
    }


}
