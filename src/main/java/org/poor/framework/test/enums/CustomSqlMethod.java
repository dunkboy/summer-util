package org.poor.framework.test.enums;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: CustomSqlMethod</p>
 * <p>Description: CustomSqlMethod</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/6 22:12</p>
 * @author cb
 * @version 1.0
 **/
public enum CustomSqlMethod
{
    /**
     * 插入
     */
    BATCH_INSERT("batchInsert", "插入多条数据（选择字段插入）", "<script>\nINSERT INTO %s %s VALUES %s\n</script>"),
    /**
     * 批量更新
     */
    BATCH_UPDATE("batchUpdate", "更新多条数据（选择字段更新）", "<script>\nUPDATE %s %s WHERE %s\n</script>");

    private final String method;
    private final String desc;
    private final String sql;

    CustomSqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }
}
