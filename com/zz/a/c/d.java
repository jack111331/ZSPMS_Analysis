package com.zz.a.c;

import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d {
  public static String a(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      byte[] arrayOfByte = Base64.encodeBase64(MessageDigest.getInstance("MD5").digest(paramString.getBytes("utf-8")));
      String str = new String();
      this(arrayOfByte, "utf-8");
      paramString = str;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return paramString;
  }
  
  public static void a(String[] paramArrayOfString) {
    System.out.println(a("19951018QQ"));
    System.out.println(b("e木易"));
    System.out.println(a("alisa"));
    System.out.println(a("cooguo"));
  }
  
  public static final String b(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes("utf-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuffer stringBuffer = new StringBuffer();
      this("");
      for (byte b = 0; b < arrayOfByte.length; b++) {
        byte b1 = arrayOfByte[b];
        int i = b1;
        if (b1 < 0)
          i = b1 + 256; 
        if (i < 16)
          stringBuffer.append("0"); 
        stringBuffer.append(Integer.toHexString(i));
      } 
      messageDigest.reset();
      return stringBuffer.toString().toLowerCase();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      System.out.println("系统加密异常" + noSuchAlgorithmException);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      System.out.println("系统加密异常编码" + unsupportedEncodingException);
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */