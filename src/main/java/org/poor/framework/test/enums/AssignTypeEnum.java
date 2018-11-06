package org.poor.framework.test.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.core.enums.IEnum;
import org.poor.framework.utils.serialize.CustomEnumConvert;

import java.io.Serializable;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: AssignTypeEnum</p>
 * <p>Description: AssignTypeEnum</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/9/21 10:10</p>
 *
 * @author cb
 * @version 1.0
 **/
@JSONType(deserializer = CustomEnumConvert.class)
public enum AssignTypeEnum implements IEnum
{

    /**
     * 未分配
     */
    NOT_ASSIGN(1, "未分配"),
    /**
     * 已分配
     */
    HAVE_ASSIGN(2, "已分配");

    AssignTypeEnum(Integer type, String desc)
    {
        this.type = type;
        this.desc = desc;
    }

//    @EnumValue
    private int type;

    private String desc;

    public Integer getType()
    {
        return type;
    }

    public String getDesc()
    {
        return desc;
    }

    @Override
    public String toString()
    {
        return getType().toString();
    }

    @Override
    public Serializable getValue()
    {
        return getType();
    }
}
