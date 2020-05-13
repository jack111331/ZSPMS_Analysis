package com.chuanglan.shanyan_sdk.utils;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class RSAUtils {
  private static String a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length);
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      String str = Integer.toHexString(paramArrayOfbyte[b] & 0xFF);
      if (str.length() < 2)
        stringBuffer.append(0); 
      stringBuffer.append(str.toUpperCase());
    } 
    return stringBuffer.toString();
  }
  
  public static String encryptData(byte[] paramArrayOfbyte, PublicKey paramPublicKey) {
    String str;
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, paramPublicKey);
      str = a(cipher.doFinal(paramArrayOfbyte));
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static PublicKey loadPublicKey(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(arrayOfByte);
      return keyFactory.generatePublic(x509EncodedKeySpec);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此算法");
    } catch (InvalidKeySpecException invalidKeySpecException) {
      throw new Exception("公钥非法");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥数据为空");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\RSAUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */