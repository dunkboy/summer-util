package org.poor.framework.utils.verification_code;

import com.github.bingoohuang.patchca.background.MyCustomBackgroundFactory;
import com.github.bingoohuang.patchca.color.ColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.DiffuseRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.DoubleRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.MarbleRippleFilterFactory;
import com.github.bingoohuang.patchca.filter.predefined.WobbleRippleFilterFactory;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.service.Captcha;
import com.github.bingoohuang.patchca.word.RandomWordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;

import static org.poor.framework.utils.constant.PublicConstant.RANDOM;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: GenerateVerificationCode</p>
 * <p>Description: GenerateVerificationCode</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/9/13 17:01</p>
 * @author cb
 * @version 1.0
 **/

public abstract class GenerateVerificationCode
{
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(GenerateVerificationCode.class);

    private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
    //验证码字符集
    private static final int VERIFY_CODE_TYPE = 3;

    /**
     * 初始化
     */
    static
    {
        // 设置颜色
        cs.setColorFactory(new ColorFactory()
        {
            @Override
            public Color getColor(int x)
            {
                int[] c = new int[3];
                int i = RANDOM.nextInt(c.length);
                for (int fi = 0; fi < c.length; fi++)
                {
                    if (fi == i)
                    {
                        c[fi] = RANDOM.nextInt(71);
                    }
                    else
                    {
                        c[fi] = RANDOM.nextInt(256);
                    }
                }
                return new Color(c[0], c[1], c[2]);
            }
        });
        RandomWordFactory wf = new RandomWordFactory();
        //验证码字符集
        switch (VERIFY_CODE_TYPE)
        {
            //纯数字
            case 1:
                wf.setCharacters("0123456789");
                break;
            //纯字母
            case 2:
                wf.setCharacters("abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
                break;
            //数字字母混合
            default:
                wf.setCharacters("23456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
                break;
        }
        // 验证码位数 最大
        wf.setMaxLength(4);
        // 最小
        wf.setMinLength(4);
        cs.setWordFactory(wf);
        // 设置图片大小
        cs.setWidth(170);
        cs.setHeight(60);
        // 设置字体大小
        RandomFontFactory font = new RandomFontFactory();
        font.setMaxSize(32);
        font.setMinSize(42);
        cs.setFontFactory(font);
        // 干扰线
        MyCustomBackgroundFactory background = new MyCustomBackgroundFactory();
        cs.setBackgroundFactory(background);
    }

    /**
     * 设置 http 相应头信息
     *
     * @param response
     */
    protected static void setResponseHeaders(HttpServletResponse response)
    {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", 0);
    }

    /**
     * 输出验证码到响应流
     *
     * @param response
     */
    public void outputCaptcha(HttpServletResponse response)
    {
        //验证码效果
        switch (RANDOM.nextInt(5))
        {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
            default:
                break;
        }

        setResponseHeaders(response);
        String verifyCode;
        try
        {
            // 验证码
            Captcha captcha = cs.getCaptcha();
            verifyCode = captcha.getChallenge();
            //记录验证码
            recordCaptcha(verifyCode);

            ImageIO.write(captcha.getImage(), "png", response.getOutputStream());
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * <p>Description: 自定义实现验证码的记录</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/9/13 17:15</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  captcha
     */
    public abstract void recordCaptcha(String captcha);
}
