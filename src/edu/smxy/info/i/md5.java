package edu.smxy.info.i;

import java.math.BigInteger;
import java.security.MessageDigest;

public class md5 {
	public static String getMD5String(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
}
