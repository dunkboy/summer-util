package org.poor.framework.utils.jwt;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: Jwk</p>
 * <p>Description: Jwk</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/9/8 22:17</p>
 * @author cb
 * @version 1.0
 **/


public class Jwk
{
    private String kid;
    private String n;
    private String d;

    public String getKid()
    {
        return kid;
    }

    public void setKid(String kid)
    {
        this.kid = kid;
    }

    public String getN()
    {
        return n;
    }

    public void setN(String n)
    {
        this.n = n;
    }

    public String getD()
    {
        return d;
    }

    public void setD(String d)
    {
        this.d = d;
    }
}
