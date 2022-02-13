package cn.edu.nju.agiledevblog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5Utils
 * @Description: MD5加密工具类
 */
public class MD5Utils {

    /**
     * @description MD5加密
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer stringBuffer = new StringBuffer("");
            for (byte b : byteDigest) {
                i = b;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            LoggerFactory.getLogger(MD5Utils.class).error(e.toString());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(code("Lg10is1.0"));
    }

}
