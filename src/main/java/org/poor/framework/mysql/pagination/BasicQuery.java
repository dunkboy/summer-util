package org.poor.framework.mysql.pagination;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: BasicQuery</p>
 * <p>Description: BasicQuery</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/26 14:32</p>
 * @author cb
 * @version 1.0
 **/


public class BasicQuery
{
    private int offset;
    private int limit;

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }
}
