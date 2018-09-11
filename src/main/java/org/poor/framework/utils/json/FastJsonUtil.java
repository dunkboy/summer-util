package org.poor.framework.utils.json;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;


import static org.poor.framework.utils.constant.PublicConstant.CHARACTER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: FastJsonUtil</p>
 * <p>Description: FastJsonUtil</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/31 20:56</p>
 * @author cb
 * @version 1.0
 **/


public abstract class FastJsonUtil extends JSON
{
    /**
     * <p>Description: 响应json数据</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: remark holdings</p>
     * <p>CreateTime:2018/9/2 11:39</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  object 输出对象
     * @param  response 响应
     */
    public static <T> void responseJsonData(T object, HttpServletResponse response) throws Exception
    {
        response.setCharacterEncoding(CHARACTER);
        response.setContentType(APPLICATION_JSON_UTF8_VALUE);
        writeJSONString(response.getOutputStream(), object);
    }

}
