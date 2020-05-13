package com.herosdk.d;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b {
  private static final Charset a = Charset.forName("UTF-8");
  
  private static final int b = 32;
  
  public static String a(String paramString1, String paramString2) {
    return new String(a(paramString1.getBytes(a), paramString2.getBytes(a)), a);
  }
  
  public static String a(byte[] paramArrayOfbyte, String paramString1, String paramString2) {
    return new String(b(paramArrayOfbyte, paramString1.getBytes(a)), Charset.forName(paramString2));
  }
  
  public static byte[] a(String paramString1, String paramString2, String paramString3) {
    return a(paramString1.getBytes(Charset.forName(paramString2)), paramString3.getBytes(a));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    return a(paramArrayOfbyte, paramString.getBytes(a));
  }
  
  public static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte2, "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(paramArrayOfbyte2, 0, 16);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      return Base64.encode(cipher.doFinal(c.a(paramArrayOfbyte1)), 2);
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage(), exception);
    } 
  }
  
  public static byte[] b(String paramString1, String paramString2) {
    return a(paramString1.getBytes(a), paramString2.getBytes(a));
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, String paramString) {
    return b(paramArrayOfbyte, paramString.getBytes(a));
  }
  
  public static byte[] b(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte2, "AES");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(Arrays.copyOfRange(paramArrayOfbyte2, 0, 16));
      cipher.init(2, secretKeySpec, ivParameterSpec);
      return c.b(cipher.doFinal(Base64.decode(paramArrayOfbyte1, 2)));
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage(), exception);
    } 
  }
  
  public static String c(byte[] paramArrayOfbyte, String paramString) {
    return new String(b(paramArrayOfbyte, paramString.getBytes(a)), a);
  }
  
  public static byte[] c(String paramString1, String paramString2) {
    return b(paramString1.getBytes(a), paramString2.getBytes(a));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */