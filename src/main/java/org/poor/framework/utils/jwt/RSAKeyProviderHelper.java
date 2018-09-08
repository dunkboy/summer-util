package org.poor.framework.utils.jwt;/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: RSAKeyProviderHelper</p>
 * <p>Description: RSAKeyProviderHelper</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: remark holdings</p>
 * <p>CreateTime: 2018/9/8 21:48</p>
 * @author cb
 * @version 1.0
 **/

import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.poor.framework.utils.json.FastJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class RSAKeyProviderHelper implements RSAKeyProvider
{

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RSAKeyProviderHelper.class);
    /**
     * One-line comment
     */
    private static final Random RANDOM = new Random();
    /**
     * One-line comment
     */
    private static Keys jwks;
    /**
     * jwks.json
     */
    private final String path = this.getClass().getClassLoader().getResource("jwk/jwks.json").getPath();

    /**
     * Create an Id for the above key
     */
    private static final String[] PRIVATE_KEY_IDS = {"sig1536380281", "sig1536380287", "sig1536380379", "sig1536380440"};
    /**
     * One-line comment
     */
    private final String privateKeyId;

    public RSAKeyProviderHelper()
    {
        int i = RANDOM.nextInt(4);
        this.privateKeyId = PRIVATE_KEY_IDS[i];
    }

    @Override
    public RSAPublicKey getPublicKeyById(String kid)
    {
        RSAPublicKey publicKey = null;
        try
        {
            publicKey = (RSAPublicKey) getProvider().get(kid).getPublicKey();
            return publicKey;
        }
        catch (Exception e)
        {
            logger.error("###", e);
        }
        return null;
    }

    @Override
    public RSAPrivateKey getPrivateKey()
    {
        return getJwkPrivateKey();
    }

    @Override
    public String getPrivateKeyId()
    {
        return privateKeyId;
    }

    private JwkProvider getProvider() throws Exception
    {
        JwkProvider provider = new JwkProviderBuilder(new File(path).toURI().toURL())
                .cached(10, 24, TimeUnit.HOURS)
                .rateLimited(10, 1, TimeUnit.MINUTES)
                .build();
        return provider;
    }

    private RSAPrivateKey getJwkPrivateKey()
    {
        if (jwks == null)
        {
            String jsonStr = null;
            try
            {
                jsonStr = FileUtils.readFileToString(new File(path), "UTF-8");
            }
            catch (IOException e)
            {
                logger.error("###", e);
            }
            jwks = FastJsonUtil.parseObject(jsonStr, Keys.class);
        }
        Jwk jwk = jwks.getKeys().stream().filter(item -> item.getKid().equals(privateKeyId)).findAny().get();
        BigInteger modulus = new BigInteger(1, Base64.decodeBase64(jwk.getN()));
        BigInteger privateExp = new BigInteger(1, Base64.decodeBase64(jwk.getD()));
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(modulus, privateExp);

        RSAPrivateKey privateKey = null;
        try
        {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            privateKey = (RSAPrivateKey) factory.generatePrivate(keySpec);
        }
        catch (NoSuchAlgorithmException e)
        {
            logger.error("###", e);
        }
        catch (InvalidKeySpecException e)
        {
            logger.error("###", e);
        }
        return privateKey;
    }

}
