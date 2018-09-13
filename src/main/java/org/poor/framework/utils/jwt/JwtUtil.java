package org.poor.framework.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: JwtUtil</p>
 * <p>Description: JwtUtil</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/9/8 23:09</p>
 * @author cb
 * @version 1.0
 **/


public class JwtUtil
{
    private static Algorithm algorithm = Algorithm.RSA256(new RSAKeyProviderHelper());

    public static String createToken(Jwt jwt)
    {
        String token = JWT.create()
                .withHeader(jwt.getHeader())
                .withExpiresAt((Date) jwt.getPayload().get("expiresAt"))
                .withIssuedAt(new Date())
                .withIssuer("poor")
                .withAudience("boy", "girl")
                .withSubject((String) jwt.getPayload().get("userName"))
                .withClaim("user_id", (String) jwt.getPayload().get("userId"))
                .sign(algorithm);
        return token;
    }

    public static DecodedJWT verifyToken(String token)
    {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("poor")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }
}
