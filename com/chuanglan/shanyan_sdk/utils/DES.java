package com.chuanglan.shanyan_sdk.utils;

import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {
  private static byte[] a = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
  
  private static String a(String paramString1, String paramString2) {
    IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "DES");
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    cipher.init(1, secretKeySpec, ivParameterSpec);
    return Base64.encode(cipher.doFinal(paramString1.getBytes()));
  }
  
  public static String decryptDES(String paramString1, String paramString2) {
    byte[] arrayOfByte = Base64.decode(paramString1);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "DES");
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    cipher.init(2, secretKeySpec, ivParameterSpec);
    return new String(cipher.doFinal(arrayOfByte));
  }
  
  public static void main(String[] paramArrayOfString) {
    String str = a("{\"pagesize\":\"5\",\"page\":\"1\",\"time\":\"55555\",\"code\":\"10010\"}", "88888888");
    System.out.println("明文：" + "{\"pagesize\":\"5\",\"page\":\"1\",\"time\":\"55555\",\"code\":\"10010\"}");
    System.out.println("密文：" + str);
    URLEncoder.encode(str, "UTF-8");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\DES.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */