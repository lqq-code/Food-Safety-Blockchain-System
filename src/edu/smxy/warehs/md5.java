package edu.smxy.warehs;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class md5 {
	public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }
    public static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }
    // 应用sha256算法让一个输入转变成256位的hash值
 	public static String applySha256(String input) {
 		try {
 			MessageDigest digest = MessageDigest.getInstance("SHA-256");
 			byte[] hash = digest.digest(input.getBytes("UTF-8"));
 			StringBuffer hexString = new StringBuffer();
 			for (int i = 0; i < hash.length; i++) {
 				String hex = Integer.toHexString(0xff & hash[i]);
 				if (hex.length() == 1)
 					hexString.append('0');
 				hexString.append(hex);
 			}
 			return hexString.toString();
 		} catch (Exception e) {
 			throw new RuntimeException(e);
 		}
 	}
 	public static String Base64Encode(String res) {
 			/*if(res.length()<8)
 				return Base64Encode("0"+res);
 			else*/
 				return Base64.encodeBase64String(res.getBytes());
    }
 	public static String Base64Decode(String res) {
 		       return new String(Base64.decodeBase64(res));
     }
}
