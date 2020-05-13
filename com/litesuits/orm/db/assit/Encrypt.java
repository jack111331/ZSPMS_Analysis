package com.litesuits.orm.db.assit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Encrypt {
  public static char[] hexDigits = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static byte[] getEncodeBytes(String paramString1, String paramString2) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(paramString2);
      messageDigest.update(paramString1.getBytes());
      return messageDigest.digest();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      noSuchAlgorithmException.printStackTrace();
      return null;
    } 
  }
  
  public static String getEncodeString(String paramString1, String paramString2) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString1.getBytes());
      byte[] arrayOfByte = messageDigest.digest();
      int i = arrayOfByte.length;
      char[] arrayOfChar = new char[i * 2];
      byte b = 0;
      int j = 0;
      while (b < i) {
        byte b1 = arrayOfByte[b];
        int k = j + 1;
        arrayOfChar[j] = (char)hexDigits[b1 >>> 4 & 0xF];
        j = k + 1;
        arrayOfChar[k] = (char)hexDigits[b1 & 0xF];
        b++;
      } 
      return new String(arrayOfChar);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String getMD2EncString(String paramString) {
    return getEncodeString(paramString, "MD2");
  }
  
  public static String getMD5EncString(String paramString) {
    return getEncodeString(paramString, "MD5");
  }
  
  public static String getSHA1EncString(String paramString) {
    return getEncodeString(paramString, "SHA-1");
  }
  
  public static String getSHA256EncString(String paramString) {
    return getEncodeString(paramString, "SHA-256");
  }
  
  public static String getSHA384EncString(String paramString) {
    return getEncodeString(paramString, "SHA-384");
  }
  
  public static String getSHA512EncString(String paramString) {
    return getEncodeString(paramString, "SHA-512");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\Encrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */