package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class e {
  private static String a = "DESede/CBC/PKCS5Padding";
  
  public static String a(String paramString1, String paramString2) {
    Exception exception2 = null;
    try {
      paramString1 = a.a(a(paramString1, paramString2.getBytes()));
    } catch (Exception exception1) {
      exception1 = exception2;
    } 
    return (String)exception1;
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfbyte) {
    Exception exception2 = null;
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString.getBytes(), "DESede");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[8]);
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      byte[] arrayOfByte = cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception1) {
      exception1 = exception2;
    } 
    return (byte[])exception1;
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      byte[] arrayOfByte = b(paramString1, a.a(paramString2));
      paramString1 = new String();
      this(arrayOfByte);
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  public static byte[] b(String paramString, byte[] paramArrayOfbyte) {
    Exception exception2 = null;
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString.getBytes(), "DESede");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[8]);
      Cipher cipher = Cipher.getInstance(a);
      cipher.init(2, secretKeySpec, ivParameterSpec);
      byte[] arrayOfByte = cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception1) {
      exception1 = exception2;
    } 
    return (byte[])exception1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\encrypt\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */