package org.poor.framework.utils.jwt;

import java.util.HashMap;
import java.util.Map;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: Jwt</p>
 * <p>Description: Jwt</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/9/8 23:10</p>
 * @author cb
 * @version 1.0
 **/

public class Jwt
{
    private Map<String, Object> header = new HashMap<>();
    private Map<String, Object> payload = new HashMap<>();

    public Map<String, Object> getHeader()
    {
        return header;
    }

    public void setHeader(Map<String, Object> header)
    {
        this.header = header;
    }

    public Map<String, Object> getPayload()
    {
        return payload;
    }

    public void setPayload(Map<String, Object> payload)
    {
        this.payload = payload;
    }
}
