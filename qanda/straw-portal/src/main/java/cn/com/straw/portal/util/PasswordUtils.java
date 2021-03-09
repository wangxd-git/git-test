package cn.com.straw.portal.util;

import org.springframework.util.DigestUtils;

public class PasswordUtils {
     public static String encode(String rawPassword){
         return DigestUtils.md5DigestAsHex(rawPassword.getBytes());
     }
}
