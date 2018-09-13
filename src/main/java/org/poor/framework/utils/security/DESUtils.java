package org.poor.framework.utils.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: DESUtils</p>
 * <p>Description: DESUtils</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/6/30 15:46</p>
 * @author cb
 * @version 1.0
 **/

public abstract class DESUtils
{
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DESUtils.class);
    /**
     * DES 密钥
     */
    private static String key = "remark";
    /**
     * objKey
     */
    private static Key objKey;

    /**
     * 加密
     */
    public static String encrypt(String plaintext) throws Exception
    {
        // 获取加解密实例
        Cipher desCipher = Cipher.getInstance("DES");
        // 初始化加密模式
        desCipher.init(Cipher.ENCRYPT_MODE, generatorKey());
        // 获取加密内容以UTF-8为标准转化的字节进行加密后再使用base64编码成字符串
        return encodeBase64String(desCipher.doFinal(plaintext.getBytes("UTF-8")));
    }

    /**
     * 解密
     */
    public static String decrypt(String ciphertext) throws Exception
    {
        Cipher desCipher = Cipher.getInstance("DES");
        // 初始化加密模式
        desCipher.init(Cipher.DECRYPT_MODE, generatorKey());
        //密文base64解码
        byte[] bytes = desCipher.doFinal(decodeBase64(ciphertext));
        return new String(bytes, "UTF-8");
    }

    /**
     * 生成密钥对象Key
     */
    private static Key generatorKey() throws Exception
    {
        if (objKey == null)
        {
            KeyGenerator generator;
            SecureRandom random = null;
            try
            {
                generator = KeyGenerator.getInstance("DES");
                random = SecureRandom.getInstance("SHA1PRNG");
                random.setSeed(key.getBytes("UTF-8"));
                generator.init(random);
                objKey = generator.generateKey();
            }
            catch (NoSuchAlgorithmException e)
            {
                logger.error("###", e);
            }
            catch (UnsupportedEncodingException e)
            {
                logger.error("###", e);
            }
        }
        return objKey;
    }

}
