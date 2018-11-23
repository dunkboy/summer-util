package org.poor.framework.utils.http;

import com.google.common.collect.Maps;
import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;


/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: FeignCreateUtils</p>
 * <p>Description: FeignCreateUtils</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/8/25 21:58</p>
 * @author cb
 * @version 1.0
 **/
@Slf4j
public class FeignCreateUtils
{

    private static Map<String, Object> cacheMap = Maps.newConcurrentMap();

    public static synchronized <T> T getService(String url, Class<T> cls) throws NoSuchAlgorithmException, KeyManagementException
    {
        Object obj = cacheMap.get(url + cls.getSimpleName());
        if (null == obj)
        {
            SSLContext ctx = null;
            try
            {
                ctx = SSLContext.getInstance("SSL");
                X509TrustManager tm = new X509TrustManager()
                {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain,
                                                   String authType) throws CertificateException
                    {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain,
                                                   String authType) throws CertificateException
                    {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers()
                    {
                        return null;
                    }
                };
                ctx.init(null, new TrustManager[]{tm}, null);
            }
            catch (NoSuchAlgorithmException e)
            {
                log.error("###【获取feign失败】###", e);
                throw e;
            }
            catch (KeyManagementException e)
            {
                log.error("###【获取feign失败】###", e);
                throw e;
            }
//            okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
//            builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//            builder.sslSocketFactory(createSSLSocketFactory());
//            builder.hostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    return true;
//                }
//            });
            obj = Feign.builder().logLevel(Logger.Level.FULL).encoder(new GsonEncoder())
                    .decoder(new GsonDecoder()).client(new Client.Default(ctx.getSocketFactory(),
                            new HostnameVerifier()
                            {
                                @Override
                                public boolean verify(String hostname, SSLSession sslSession)
                                {
                                    return true;
                                }
                            })).logger(new Slf4jLogger()).target(cls, url);
            cacheMap.put(url + cls.getSimpleName(), obj);
        }
        return (T) obj;
    }

}
