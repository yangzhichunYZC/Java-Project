package com.inkss.hb.common;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public String getMD5(String str) {
     /*   //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String strMD5 = null;
        try {
            strMD5 = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strMD5;*/

        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        byte[] tmp = str.getBytes();
        try {
            MessageDigest dig = MessageDigest.getInstance("MD5");
            dig.update(tmp);
            byte[] md = dig.digest();
            int j = md.length;
            char[] aa = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                aa[k++] = hex[byte0 >>> 4 & 0xf];
                aa[k++] = hex[byte0 & 0xf];
            }
            return new String(aa);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean checkMD5(String newStr, String oldStr) {
        return getMD5(newStr).equals(oldStr);
    }
}
