package com.zz.lib.org.myapache.commons.codec.binary;

import java.io.UnsupportedEncodingException;

public class StringUtils {
  public static byte[] getBytesIso8859_1(String paramString) {
    return getBytesUnchecked(paramString, "ISO-8859-1");
  }
  
  public static byte[] getBytesUnchecked(String paramString1, String paramString2) {
    if (paramString1 == null)
      return null; 
    try {
      return paramString1.getBytes(paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw newIllegalStateException(paramString2, unsupportedEncodingException);
    } 
  }
  
  public static byte[] getBytesUsAscii(String paramString) {
    return getBytesUnchecked(paramString, "US-ASCII");
  }
  
  public static byte[] getBytesUtf16(String paramString) {
    return getBytesUnchecked(paramString, "UTF-16");
  }
  
  public static byte[] getBytesUtf16Be(String paramString) {
    return getBytesUnchecked(paramString, "UTF-16BE");
  }
  
  public static byte[] getBytesUtf16Le(String paramString) {
    return getBytesUnchecked(paramString, "UTF-16LE");
  }
  
  public static byte[] getBytesUtf8(String paramString) {
    return getBytesUnchecked(paramString, "UTF-8");
  }
  
  private static IllegalStateException newIllegalStateException(String paramString, UnsupportedEncodingException paramUnsupportedEncodingException) {
    return new IllegalStateException(String.valueOf(paramString) + ": " + paramUnsupportedEncodingException);
  }
  
  public static String newString(byte[] paramArrayOfbyte, String paramString) {
    if (paramArrayOfbyte == null)
      return null; 
    try {
      return new String(paramArrayOfbyte, paramString);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw newIllegalStateException(paramString, unsupportedEncodingException);
    } 
  }
  
  public static String newStringIso8859_1(byte[] paramArrayOfbyte) {
    return newString(paramArrayOfbyte, "ISO-8859-1");
  }
  
  public static String newStringUsAscii(byte[] paramArrayOfbyte) {
    return newString(paramArrayOfbyte, "US-ASCII");
  }
  
  public static String newStringUtf16(byte[] paramArrayOfbyte) {
    return newString(paramArrayOfbyte, "UTF-16");
  }
  
  public static String newStringUtf16Be(byte[] paramArrayOfbyte) {
    return newString(paramArrayOfbyte, "UTF-16BE");
  }
  
  public static String newStringUtf16Le(byte[] paramArrayOfbyte) {
    return newString(paramArrayOfbyte, "UTF-16LE");
  }
  
  public static String newStringUtf8(byte[] paramArrayOfbyte) {
    return newString(paramArrayOfbyte, "UTF-8");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */