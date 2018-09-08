package org.poor.framework.utils.jwt;

import java.util.ArrayList;
import java.util.List;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: Keys</p>
 * <p>Description: Keys</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/9/8 22:39</p>
 * @author cb
 * @version 1.0
 **/


public class Keys
{
    private List<Jwk> keys = new ArrayList<>();

    public List<Jwk> getKeys()
    {
        return keys;
    }

    public void setKeys(List<Jwk> keys)
    {
        this.keys = keys;
    }
}
