package org.poor.framework.test.domain;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: MyUser</p>
 * <p>Description: MyUser</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/9/2 20:55</p>
 * @author cb
 * @version 1.0
 **/

import lombok.Data;

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
@Data
public class MyUser
{
    /**
     * id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;

}
