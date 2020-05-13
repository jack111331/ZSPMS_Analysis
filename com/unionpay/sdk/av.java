package com.unionpay.sdk;

import android.util.Base64;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class av {
  private static final byte[] a = new byte[] { 
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
      0, 0, 0, 0, 0, 0 };
  
  static String a(String paramString) {
    try {
      SecretKeySpec secretKeySpec = c(ab.a(ab.mContext));
      byte[] arrayOfByte1 = a;
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(arrayOfByte1);
      cipher.init(1, secretKeySpec, ivParameterSpec);
      String str = Base64.encodeToString(cipher.doFinal(arrayOfByte2), 2);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  static String b(String paramString) {
    try {
      SecretKeySpec secretKeySpec;
      String str2 = az.a();
      if (str2 == null) {
        secretKeySpec = c(ab.a(ab.mContext));
      } else {
        secretKeySpec = new SecretKeySpec(Base64.decode((String)secretKeySpec, 2), "AES");
      } 
      byte[] arrayOfByte3 = Base64.decode(paramString, 2);
      byte[] arrayOfByte1 = a;
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      IvParameterSpec ivParameterSpec = new IvParameterSpec();
      this(arrayOfByte1);
      cipher.init(2, secretKeySpec, ivParameterSpec);
      byte[] arrayOfByte2 = cipher.doFinal(arrayOfByte3);
      String str1 = new String();
      this(arrayOfByte2, "UTF-8");
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  private static SecretKeySpec c(String paramString) {
    String str2 = az.a();
    if (str2 != null)
      return new SecretKeySpec(Base64.decode(str2, 2), "AES"); 
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    messageDigest.update(arrayOfByte, 0, arrayOfByte.length);
    arrayOfByte = messageDigest.digest();
    String str1 = Base64.encodeToString(arrayOfByte, 2);
    if (ab.mContext != null)
      h.a(ab.mContext, "UPpref_longtime", "UPaes_key", str1); 
    return new SecretKeySpec(arrayOfByte, "AES");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */