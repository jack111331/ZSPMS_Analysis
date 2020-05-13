package com.sdk.base.framework.utils.i;

import android.content.Context;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a extends a {
  private static final String a = a.class.getName();
  
  private static boolean b = c.h;
  
  private static String c = "a6Hy5Hb8IfX46D1f";
  
  public static String a(int paramInt) {
    Random random = new Random();
    byte b = 0;
    String str;
    for (str = ""; b < paramInt; str = str2) {
      String str1;
      String str2;
      if (random.nextInt(2) % 2 == 0) {
        str1 = "char";
      } else {
        str1 = "num";
      } 
      if ("char".equalsIgnoreCase(str1)) {
        byte b1;
        if (random.nextInt(2) % 2 == 0) {
          b1 = 65;
        } else {
          b1 = 97;
        } 
        str2 = str + (char)(b1 + random.nextInt(26));
      } else {
        str2 = str;
        if ("num".equalsIgnoreCase(str1))
          str2 = str + String.valueOf(random.nextInt(10)); 
      } 
      b++;
    } 
    return str;
  }
  
  public static String a(Context paramContext) {
    String str1 = com.sdk.base.framework.utils.a.a.b(paramContext, c.a);
    String str2 = str1;
    if (com.sdk.base.framework.utils.k.a.a(str1).booleanValue()) {
      str2 = a(16);
      com.sdk.base.framework.utils.a.a.b(paramContext, c.a, str2);
    } 
    return str2;
  }
  
  public static String a(String paramString1, String paramString2) {
    return b(paramString1, paramString2, c);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    String str = null;
    if (paramString1 != null) {
      try {
        if (paramString1.length() == 0 || paramString1.trim().length() == 0) {
          logError(a, "EncryptCbcIv", "encrypt content is null", b);
          return str;
        } 
        if (paramString2 == null) {
          logError(a, "EncryptCbcIv", "encrypt key is null", b);
          return str;
        } 
      } catch (Exception exception) {
        logError(a, "EncryptCbcIv", exception.getMessage(), b);
        return str;
      } 
      if (paramString2.length() != 16) {
        logError(a, "EncryptCbcIv", "encrypt key length error", b);
        return str;
      } 
      if (paramString3.length() != 16) {
        logError(a, "EncryptCbcIv", "ivStr length error", b);
        return str;
      } 
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString2.getBytes("utf-8"), "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(paramString3.getBytes("utf-8"));
      cipher.init(1, secretKeySpec, ivParameterSpec);
      return c.a(cipher.doFinal(paramString1.getBytes("utf-8")));
    } 
    logError(a, "EncryptCbcIv", "encrypt content is null", b);
    return str;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3) {
    if (paramString1 != null) {
      Exception exception;
      try {
        if (paramString1.length() == 0 || paramString1.trim().length() == 0)
          return null; 
        if (paramString2 == null) {
          exception = new Exception();
          this("decrypt key is null");
          throw exception;
        } 
      } catch (Exception null) {
        throw new Exception("decrypt errot", exception);
      } 
      if (paramString2.length() != 16) {
        exception = new Exception();
        this("decrypt key length error");
        throw exception;
      } 
      if (paramString3.length() != 16) {
        exception = new Exception();
        this(" iv decrypt key length error");
        throw exception;
      } 
      byte[] arrayOfByte = c.a((String)exception);
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString2.getBytes("utf-8"), "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(paramString3.getBytes("utf-8"));
      cipher.init(2, secretKeySpec, ivParameterSpec);
      return new String(cipher.doFinal(arrayOfByte), "utf-8");
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */