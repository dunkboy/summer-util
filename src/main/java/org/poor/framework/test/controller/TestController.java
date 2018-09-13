package org.poor.framework.test.controller;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: TestController</p>
 * <p>Description: TestController</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/8/31 23:31</p>
 * @author cb
 * @version 1.0
 **/

import org.poor.framework.test.A;
import org.poor.framework.test.domain.MyUser;
import org.poor.framework.test.service.MyUserService;
import org.poor.framework.utils.json.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
@RestController
@RequestMapping("/test")
public class TestController
{
    @Autowired
    private MyUserService myUserService;

    @PostMapping(value = "/123")
    public void get(@RequestBody A b, HttpServletResponse response) throws Exception
    {
        System.out.println(b.getName());
        System.out.println(b.getAge());
        System.out.println("==============");
        List<MyUser> user = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            MyUser my = new MyUser();
            my.setName(String.valueOf(i));
            my.setPassword(String.valueOf(i));
            my.setAge(i);
            my.setSex(i);
            user.add(my);
        }
        myUserService.insertList(user);
    }

    @PutMapping(value = "/hehe")
    public void hehe(Object obj)
    {
        System.out.println("?????");
    }
}
