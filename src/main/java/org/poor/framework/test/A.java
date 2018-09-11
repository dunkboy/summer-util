package org.poor.framework.test;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: A</p>
 * <p>Description: A</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/31 23:11</p>
 * @author cb
 * @version 1.0
 **/

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *      _mZ***~*=e_
 *    ,Z~   @@W    \.                           ] g-
 *    d`    ,8s     @i                          ]W`__
 *    @b V**   _W`Vs                        ,P~
 *    ['\=m__gmmZ*~   'i    _____             if    _________g
 *    W                ]mY~~~~~~~~*e_        _A=/~~~~~~   '~~@     mm-
 *    M                      __.    'Vc   ,=~                ]i   ]@@
 *    ].   ,m=*+m.           ~~~*s     \m/                   ]`   ]@@
 *    ][  iP,__ ][               '[     's                   ]s___g@@
 *     W   N/**_A`                WebMvcConfiguration      '.                  ][  '~~~
 *     ]i   ~~~\__                i       `                  ][
 *  ___gW    ,Z~`'Vs             g`       -                  ][
 * f`   !W   M W@i W          _g/`        ,                  ][
 *      ,@b  '\===f`                      ]                  ][    ,g.
 * +===f~ Mb                              Z                  ][    @@[
 *      gzY*W.                           i!                  ][   -@@!
 *    ,Z`   'Ms                         gb                   ]b____@@
 *    !b   ,gZVWs                     ,v`'\c.                ]~~~~**f
 *     ~***~`   VMm_                ,zf     YD-_.            ]
 *                '~*em__       __zf`        b  '~\=es____  ,@
 *                      ~~~~~~~~`            !i        ,~VP~V*
 *                                            WebMvcConfiguration.     ]7 ~@[
 *                                            ]AA=s. '~='WebMvcConfiguration[
 *                                            W V.       ~
 */

public class A
{

    //    @JSONField(serialize=false)
    @JSONField(serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
