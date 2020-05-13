package com.herosdk.d;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ao {
  private static final int a = 117;
  
  private static final int b = 128;
  
  public static RSAPublicKey a(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString, 2);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(arrayOfByte);
      return (RSAPublicKey)keyFactory.generatePublic(x509EncodedKeySpec);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此算法");
    } catch (InvalidKeySpecException invalidKeySpecException) {
      throw new Exception("公钥非法");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥数据为空");
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public static void a() {}
  
  public static byte[] a(RSAPrivateKey paramRSAPrivateKey, byte[] paramArrayOfbyte) {
    if (paramRSAPrivateKey == null)
      throw new Exception("加密私钥为空, 请设置"); 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, paramRSAPrivateKey);
      return a(cipher, paramArrayOfbyte, 117);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此加密算法");
    } catch (NoSuchPaddingException null) {
      null.printStackTrace();
      return null;
    } catch (InvalidKeyException invalidKeyException) {
      throw new Exception("加密私钥非法,请检查");
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      throw new Exception("明文长度非法");
    } catch (BadPaddingException badPaddingException) {
      throw new Exception("明文数据已损坏");
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public static byte[] a(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfbyte) {
    if (paramRSAPublicKey == null)
      throw new Exception("加密公钥为空, 请设置"); 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, paramRSAPublicKey);
      return a(cipher, paramArrayOfbyte, 117);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此加密算法");
    } catch (NoSuchPaddingException null) {
      null.printStackTrace();
      return null;
    } catch (InvalidKeyException invalidKeyException) {
      throw new Exception("加密公钥非法,请检查");
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      throw new Exception("明文长度非法");
    } catch (BadPaddingException badPaddingException) {
      throw new Exception("明文数据已损坏");
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  private static byte[] a(Cipher paramCipher, byte[] paramArrayOfbyte, int paramInt) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      this();
      int i = paramArrayOfbyte.length;
      for (int j = 0; i > j; j += paramInt) {
        byte[] arrayOfByte1;
        if (i > j + paramInt) {
          arrayOfByte1 = paramCipher.doFinal(paramArrayOfbyte, j, paramInt);
        } else {
          arrayOfByte1 = paramCipher.doFinal(paramArrayOfbyte, j, i - j);
        } 
        byteArrayOutputStream.write(arrayOfByte1, 0, arrayOfByte1.length);
      } 
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.close();
      return arrayOfByte;
    } catch (IllegalBlockSizeException null) {
      null.printStackTrace();
      return null;
    } catch (BadPaddingException null) {
      null.printStackTrace();
      return null;
    } catch (IOException null) {
      null.printStackTrace();
      return null;
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public static RSAPrivateKey b(String paramString) {
    try {
      byte[] arrayOfByte = Base64.decode(paramString, 2);
      PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec();
      this(arrayOfByte);
      return (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpec);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此算法");
    } catch (InvalidKeySpecException invalidKeySpecException) {
      throw new Exception("私钥非法");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("私钥数据为空");
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public static byte[] b(RSAPrivateKey paramRSAPrivateKey, byte[] paramArrayOfbyte) {
    if (paramRSAPrivateKey == null)
      throw new Exception("解密私钥为空, 请设置"); 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(2, paramRSAPrivateKey);
      return a(cipher, paramArrayOfbyte, 128);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此解密算法");
    } catch (NoSuchPaddingException null) {
      null.printStackTrace();
      return null;
    } catch (InvalidKeyException invalidKeyException) {
      throw new Exception("解密私钥非法,请检查");
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      throw new Exception("密文长度非法");
    } catch (BadPaddingException badPaddingException) {
      throw new Exception("密文数据已损坏");
    } catch (Exception exception) {
      throw exception;
    } 
  }
  
  public static byte[] b(RSAPublicKey paramRSAPublicKey, byte[] paramArrayOfbyte) {
    if (paramRSAPublicKey == null)
      throw new Exception("解密公钥为空, 请设置"); 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(2, paramRSAPublicKey);
      return a(cipher, paramArrayOfbyte, 128);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new Exception("无此解密算法");
    } catch (NoSuchPaddingException null) {
      null.printStackTrace();
      return null;
    } catch (InvalidKeyException invalidKeyException) {
      throw new Exception("解密公钥非法,请检查");
    } catch (IllegalBlockSizeException illegalBlockSizeException) {
      throw new Exception("密文长度非法");
    } catch (BadPaddingException badPaddingException) {
      throw new Exception("密文数据已损坏");
    } catch (Exception exception) {
      throw exception;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */