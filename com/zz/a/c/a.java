package com.zz.a.c;

import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a {
  private static final String a = "AES/ECB/PKCS5Padding";
  
  public static String a(String paramString1, String paramString2) {
    Exception exception2 = null;
    try {
      Key key = a(paramString1);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(1, key);
      byte[] arrayOfByte = cipher.doFinal(paramString2.getBytes());
    } catch (Exception exception1) {
      exception1.printStackTrace();
      exception1 = exception2;
    } 
    return new String(Base64.encodeBase64((byte[])exception1));
  }
  
  private static Key a(String paramString) {
    try {
      return new SecretKeySpec(paramString.getBytes(), "AES");
    } catch (Exception exception) {
      exception.printStackTrace();
      throw exception;
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    Exception exception2 = null;
    try {
      Key key = a(paramString1);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(2, key);
      byte[] arrayOfByte = cipher.doFinal(Base64.decodeBase64(paramString2));
    } catch (Exception exception1) {
      exception1.printStackTrace();
      exception1 = exception2;
    } 
    return (new String((byte[])exception1)).trim();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */