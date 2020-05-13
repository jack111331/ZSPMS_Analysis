package com.cmic.sso.sdk.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {
  public static String a(String paramString1, String paramString2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString1.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[cipher.getBlockSize()]);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      String str = b.a(cipher.doFinal(paramString2.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  public static String a(byte[] paramArrayOfbyte, String paramString) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[cipher.getBlockSize()]);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      String str = b.a(cipher.doFinal(paramString.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  public static String b(String paramString1, String paramString2) {
    try {
      byte[] arrayOfByte2 = b.a(paramString2);
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString1.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[cipher.getBlockSize()]);
      cipher.init(2, secretKeySpec, ivParameterSpec);
      byte[] arrayOfByte1 = cipher.doFinal(arrayOfByte2);
      String str = new String();
      this(arrayOfByte1, "UTF-8");
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  public static String b(byte[] paramArrayOfbyte, String paramString) {
    try {
      byte[] arrayOfByte = b.a(paramString);
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte, "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(new byte[cipher.getBlockSize()]);
      cipher.init(2, secretKeySpec, ivParameterSpec);
      arrayOfByte = cipher.doFinal(arrayOfByte);
      String str = new String();
      this(arrayOfByte, "UTF-8");
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */