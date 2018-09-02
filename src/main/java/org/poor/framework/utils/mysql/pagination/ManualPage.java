package org.poor.framework.utils.mysql.pagination;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: ManualPage</p>
 * <p>Description: ManualPage</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/26 14:24</p>
 * @author cb
 * @version 1.0
 **/


public abstract class ManualPage
{
    /**
     * <p>Description: 获取页数</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/8/26 14:26</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  total 总数
     * @param  limit  每页大小
     * @return 总页数
     */
    private static int getLoopCount(int total, int limit)
    {
        return (total / limit) + (total % limit > 0 ? 1 : 0);
    }

    /**
     * <p>Description: 循环处理数据，每次处理limit条</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/8/26 15:06</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  t
     */
    public <T extends BasicQuery> void forPagingProcessing(T t)
    {
        int total = countTotal(t);
        if (total == 0)
        {
            return;
        }
        int loopCount = getLoopCount(total, t.getLimit());
        int offset = t.getOffset();
        for (int i = 0; i < loopCount; i++)
        {
            offset = resetQuery(offset, t);
            everyTimehandling(t);
        }
    }

    /**
     * 每一次如何处理
     */
    public abstract <T extends BasicQuery> void everyTimehandling(T t);

    /**
     * 统计总数
     */
    public abstract <T extends BasicQuery> int countTotal(T t);

    /**
     * 重置分页查询条件
     */
    private static <T extends BasicQuery> int resetQuery(int offset, T query)
    {
        // 偏移量
        query.setOffset(offset);
        offset += query.getLimit();
        return offset;
    }
}
