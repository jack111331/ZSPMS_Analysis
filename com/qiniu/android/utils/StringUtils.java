package com.qiniu.android.utils;

import java.io.UnsupportedEncodingException;

public final class StringUtils {
  public static boolean isBlank(String paramString) {
    return (paramString == null || paramString.trim().equals(""));
  }
  
  public static boolean isNullOrEmpty(String paramString) {
    return (paramString == null || "".equals(paramString));
  }
  
  public static String join(String[] paramArrayOfString, String paramString) {
    if (paramArrayOfString == null)
      return null; 
    int i = paramArrayOfString.length;
    boolean bool = false;
    if (paramString != null && !paramString.equals("")) {
      j = paramString.length();
    } else {
      j = 0;
    } 
    if (i == 0) {
      j = 0;
    } else {
      int k;
      if (paramArrayOfString[0] == null) {
        k = 16;
      } else {
        k = paramArrayOfString[0].length();
      } 
      j = (k + j) * i;
    } 
    StringBuilder stringBuilder = new StringBuilder(j);
    for (int j = bool; j < i; j++) {
      if (j > 0)
        stringBuilder.append(paramString); 
      if (paramArrayOfString[j] != null)
        stringBuilder.append(paramArrayOfString[j]); 
    } 
    return stringBuilder.toString();
  }
  
  public static String jsonJoin(String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    byte b = 0;
    StringBuilder stringBuilder = new StringBuilder((paramArrayOfString[0].length() + 3) * i);
    while (b < i) {
      if (b > 0)
        stringBuilder.append(','); 
      stringBuilder.append('"');
      stringBuilder.append(paramArrayOfString[b]);
      stringBuilder.append('"');
      b++;
    } 
    return stringBuilder.toString();
  }
  
  public static String strip(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      char c = paramString.charAt(b);
      if (c > '\037' && c < '')
        stringBuilder.append(c); 
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] utf8Bytes(String paramString) {
    try {
      return paramString.getBytes("utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\androi\\utils\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */