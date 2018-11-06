package org.poor.framework.utils.serialize;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.baomidou.mybatisplus.core.toolkit.EnumUtils;

import java.lang.reflect.Type;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: CustomEnumConvert</p>
 * <p>Description: CustomEnumConvert</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/11/6 10:00</p>
 * @author cb
 * @version 1.0
 **/
public class CustomEnumConvert implements ObjectDeserializer
{
    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName)
    {
        final JSONLexer lexer = parser.lexer;
        final int token = lexer.token();
        Class cls = (Class) type;
        Object[] enumConstants = cls.getEnumConstants();
        if (IEnum.class.isAssignableFrom(cls))
        {
            return (T) EnumUtils.valueOf(cls, lexer.intValue());
        }
        else
        {
            //没实现IEnum接口的 默认的按名字或者按ordinal
            if (token == JSONToken.LITERAL_INT)
            {
                int intValue = lexer.intValue();
                lexer.nextToken(JSONToken.COMMA);

                if (intValue < 0 || intValue > enumConstants.length)
                {
                    throw new JSONException("parse enum " + cls.getName() + " error, value : " + intValue);
                }
                return (T) enumConstants[intValue];
            }
            else if (token == JSONToken.LITERAL_STRING)
            {
                return (T) Enum.valueOf(cls, lexer.stringVal());
            }
        }
        return null;
    }

    @Override
    public int getFastMatchToken()
    {
        return JSONToken.LITERAL_INT;
    }

}
