package com.cmic.sso.sdk.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j {
  static char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(String paramString) {
    String str1;
    String str2 = null;
    if (TextUtils.isEmpty(paramString))
      return str2; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      str1 = str2;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str1 = str2;
    } 
    return str1;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    byte b = 0;
    char[] arrayOfChar = new char[32];
    int i = 0;
    while (b < 16) {
      byte b1 = paramArrayOfbyte[b];
      int k = i + 1;
      arrayOfChar[i] = (char)a[b1 >>> 4 & 0xF];
      i = k + 1;
      arrayOfChar[k] = (char)a[b1 & 0xF];
      b++;
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */