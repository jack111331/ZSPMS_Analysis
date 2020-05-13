package com.zz.sdk.i;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bs {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final char[] b = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(String paramString) {
    try {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return a(arrayOfByte);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalStateException("UTF-8: " + unsupportedEncodingException);
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    return c(d(paramArrayOfbyte));
  }
  
  private static MessageDigest a() {
    return b("MD5");
  }
  
  public static char[] a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramBoolean) {
      char[] arrayOfChar1 = a;
      return a(paramArrayOfbyte, arrayOfChar1);
    } 
    char[] arrayOfChar = b;
    return a(paramArrayOfbyte, arrayOfChar);
  }
  
  protected static char[] a(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
    int i = 0;
    int j = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[j << 1];
    for (byte b = 0; b < j; b++) {
      int k = i + 1;
      arrayOfChar[i] = (char)paramArrayOfchar[(paramArrayOfbyte[b] & 0xF0) >>> 4];
      i = k + 1;
      arrayOfChar[k] = (char)paramArrayOfchar[paramArrayOfbyte[b] & 0xF];
    } 
    return arrayOfChar;
  }
  
  static MessageDigest b(String paramString) {
    try {
      return MessageDigest.getInstance(paramString);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException(noSuchAlgorithmException.getMessage());
    } 
  }
  
  public static char[] b(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, true);
  }
  
  public static String c(byte[] paramArrayOfbyte) {
    return new String(b(paramArrayOfbyte));
  }
  
  public static byte[] d(byte[] paramArrayOfbyte) {
    return a().digest(paramArrayOfbyte);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */