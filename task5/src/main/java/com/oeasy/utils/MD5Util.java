package com.oeasy.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class MD5Util {
    public static String stringToMD5(String string) {
        MessageDigest messageDigest = null;
        try {
            messageDigest= MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 计算md5函数
        messageDigest.update(string.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
