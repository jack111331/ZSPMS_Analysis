package com.aliyun.sls.android.sdk.utils;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinaryUtil {
  public static String calculateBase64Md5(String paramString) throws IOException {
    return toBase64String(calculateMd5(paramString));
  }
  
  public static String calculateBase64Md5(byte[] paramArrayOfbyte) {
    return toBase64String(calculateMd5(paramArrayOfbyte));
  }
  
  public static byte[] calculateMd5(String paramString) throws IOException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[4096];
      FileInputStream fileInputStream = new FileInputStream();
      File file = new File();
      this(paramString);
      this(file);
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          messageDigest.update(arrayOfByte, 0, i);
          continue;
        } 
        fileInputStream.close();
        return messageDigest.digest();
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException("MD5 algorithm not found.");
    } 
  }
  
  public static byte[] calculateMd5(byte[] paramArrayOfbyte) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramArrayOfbyte);
      return messageDigest.digest();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new RuntimeException("MD5 algorithm not found.");
    } 
  }
  
  public static String calculateMd5Str(String paramString) throws IOException {
    return getMd5StrFromBytes(calculateMd5(paramString));
  }
  
  public static String calculateMd5Str(byte[] paramArrayOfbyte) {
    return getMd5StrFromBytes(calculateMd5(paramArrayOfbyte));
  }
  
  public static byte[] fromBase64String(String paramString) {
    return Base64.decode(paramString, 0);
  }
  
  public static String getMd5StrFromBytes(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      stringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfbyte[b]) }));
    } 
    return stringBuilder.toString();
  }
  
  public static String toBase64String(byte[] paramArrayOfbyte) {
    return new String(Base64.encode(paramArrayOfbyte, 0));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\BinaryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */