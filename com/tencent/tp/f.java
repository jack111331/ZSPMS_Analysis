package com.tencent.tp;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.RSAPublicKeySpec;

public class f {
  public static boolean a() {
    boolean bool;
    if (!b() && !c() && !d()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean b() {
    return MessageDigest.isEqual("123456".getBytes(), "456".getBytes());
  }
  
  public static boolean c() {
    try {
      Signature signature = Signature.getInstance("SHA1withRSA");
      RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec();
      BigInteger bigInteger1 = new BigInteger();
      this("123456", 16);
      BigInteger bigInteger2 = new BigInteger();
      this("11", 16);
      this(bigInteger1, bigInteger2);
      signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(rSAPublicKeySpec));
      signature.update("367".getBytes());
      return signature.verify("123098".getBytes());
    } catch (NoSuchAlgorithmException|java.security.spec.InvalidKeySpecException|java.security.InvalidKeyException|java.security.SignatureException noSuchAlgorithmException) {
      return false;
    } 
  }
  
  public static boolean d() {
    try {
      Signature signature = Signature.getInstance("SHA1withRSA");
      RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec();
      BigInteger bigInteger1 = new BigInteger();
      this("12345678", 16);
      BigInteger bigInteger2 = new BigInteger();
      this("11", 16);
      this(bigInteger1, bigInteger2);
      signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(rSAPublicKeySpec));
      signature.update("367".getBytes());
      return signature.verify("123908".getBytes(), 1, 5);
    } catch (NoSuchAlgorithmException|java.security.spec.InvalidKeySpecException|java.security.InvalidKeyException|java.security.SignatureException noSuchAlgorithmException) {
      return false;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */