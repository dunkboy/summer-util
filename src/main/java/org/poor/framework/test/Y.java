package org.poor.framework.test;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: Y</p>
 * <p>Description: Y</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/8/31 23:47</p>
 * @author cb
 * @version 1.0
 **/

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

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
 *     W   N/**_A`                Y      '.                  ][  '~~~
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
 *                                            Y.     ]7 ~@[
 *                                            ]AA=s. '~='Y[
 *                                            W V.       ~
 */
@Configuration
public class Y extends WebMvcConfigurationSupport
{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        converter.setSupportedMediaTypes(supportedMediaTypes);

        //自定义配置...converterx
//        FastJsonConfig config = new FastJsonConfig();
        //config.set ...
        //converter.setFastJsonConfig(config);
        converters.add(converter);
    }
}