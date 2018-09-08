package org.poor.framework;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.poor.framework.test.A;
import org.poor.framework.utils.json.FastJsonUtil;
import org.poor.framework.utils.jwt.Jwt;
import org.poor.framework.utils.jwt.JwtUtil;
import org.poor.framework.utils.jwt.RSAKeyProviderHelper;

import java.io.File;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test.json for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(true);
    }

    public static void main(String[] args) throws Exception
    {
        //######################################################
//        String test.json = "fkdsfkdsj${key1}fdfdsfdsfds${key2}";
//        String newtest= StringUtils.replaceEval(test.json, new IStringReplaceProcess()
//        {
//            @Override
//            public String doReplace(String key, StringBuffer src, int prefixIndex, int suffixIndex)
//            {
//
//                if (key.equalsIgnoreCase("key1")){
//                    return "@@@@";
//
//                }else if (key.equalsIgnoreCase("key2")){
//                    return "######";
//
//                }
//                return null;
//            }
//        });
//        System.out.println(test.json);
//        System.out.println(newtest);
        //######################################################
        //Header
        Jwt jwt = new Jwt();
        jwt.getHeader().put("alg", "HS256");
        jwt.getHeader().put("typ", "JWT");
        //Payload
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.DATE, 1);
        Date expiresDate = nowTime.getTime();
        jwt.getPayload().put("expiresAt", expiresDate);
        jwt.getPayload().put("userName", "sb");
        jwt.getPayload().put("userId", "adsadsadsadsadsadsad");
        String token = JwtUtil.createToken(jwt);
        System.out.println(token);
        DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
        System.out.println(decodedJWT.getExpiresAt().toString());
        System.out.println(decodedJWT.getSubject());
        System.out.println(decodedJWT.getAudience());
        System.out.println(decodedJWT.getKeyId());
        System.out.println(decodedJWT.getClaim("user_id").asString());
        System.out.println(decodedJWT.getIssuedAt());
        System.out.println(decodedJWT.getIssuer());
        //######################################################
    }
}
