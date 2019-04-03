package com.glcxw.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.RandomUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;

public class ThreeDESUtil {

    private static final String KEY = "abcdefghijklmnopqrstuvwx";

    /**
     * 3DESECB加密,key必须是长度大于等于 3*8 = 24 位
     * @param src
     * @return
     * @throws Exception
     */
    public static String encryptThreeDESECB(String key,String src) throws Exception {
        DESedeKeySpec dks = new DESedeKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        byte[] b = cipher.doFinal(src.getBytes());

        return Base64.encode(b).replaceAll("\r", "").replaceAll("\n", "");

    }

    /**
     * 3DES ECB解密,key必须是长度大于等于 3*8 = 24 位
     * @param src
     * @return
     * @throws Exception
     */
    public static String decryptThreeDESECB(String key,String src) throws Exception {
        // --通过base64,将字符串转成byte数组
        byte[] bytesrc = Base64.decode(src);
        // --解密的key
        DESedeKeySpec dks = new DESedeKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // --Chipher对象解密
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        byte[] retByte = cipher.doFinal(bytesrc);

        return new String(retByte);
    }

    public static void main(String[] args) throws Exception {

        String random = RandomUtil.randomNumbers(24);
        //random = RandomUtil.randomString(24);
        System.out.println(random);
        String memberId = "5164";
        String token = "9f7e3e5bcc6a4db291b0b8a482388f3a";
        String tokenVal = (memberId+","+token).trim();

        String encrypt = ThreeDESUtil.encryptThreeDESECB(random,tokenVal);

        System.out.println(ThreeDESUtil.decryptThreeDESECB(random,encrypt));

    }
}
