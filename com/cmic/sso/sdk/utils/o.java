package com.cmic.sso.sdk.utils;

import android.os.Build;
import com.cmic.sso.sdk.utils.a.a;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class o {
  private static final String a = o.class.getSimpleName();
  
  private static o d = null;
  
  private PublicKey b = null;
  
  private PrivateKey c = null;
  
  private o() {
    try {
      if (this.b == null)
        b(); 
      if (this.c == null)
        c(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static o a() {
    if (d == null)
      d = new o(); 
    return d;
  }
  
  private void b() {
    try {
      KeyFactory keyFactory;
      a a = new a();
      this();
      byte[] arrayOfByte = a.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/YHP9utFGOhGk7Xf5L7jOgQz5\nv2JKxdrIE3yzYsHoZJwzKC7Ttx380UZmBFzr5I1k6FFMn/YGXd4ts6UHT/nzsCIc\ngZlTTem7Pjdm1V9bJgQ6iQvFHsvT+vNgJ3wAIRd+iCMXm8y96yZhD2+SH5odBYS2\nZzwTYXBQDvB/rTfdjwIDAQAB");
      if (Build.VERSION.SDK_INT >= 28) {
        keyFactory = KeyFactory.getInstance("RSA");
      } else {
        keyFactory = KeyFactory.getInstance("RSA", "BC");
      } 
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(arrayOfByte);
      this.b = keyFactory.generatePublic(x509EncodedKeySpec);
      return;
    } catch (IOException iOException) {
      throw new Exception("公钥数据流读取错误");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥输入流为空");
    } 
  }
  
  private void c() {
    try {
      KeyFactory keyFactory;
      a a = new a();
      this();
      byte[] arrayOfByte = a.a("MIICXgIBAAKBgQCkzAyTd86uiPMkvwGPevdr77TnoCAfpuruO5c6XnbcbaMevG3r\nPN6Dzx4OXVx7wYXoXG4rnjD8/qoIutmpS71CuafyhqGhqdsTMKKL7njWvn0KWbdL\nBl6croB68tFbAnIU8Nf95bHm1MW366riPKiN4yOgI+ig9qa4/lFFgH1RjQIDAQAB\nAoGBAIC5wrkORKug3gw+BwIEk3AEddLYCT+wKqKceaxmTYIxQdGoblPp4AYlqtyd\noLgqmma+jHAVyT5VzouzKIJNXy+WqahMN3vmLIt7ois7Vpt6131eI5uapWVNUN7+\nYv+u4FlvGiJIlKsmLJweIbAqVNOCOmJzP6ycgpxR8qDUSwYBAkEA1USGJq/3CLE4\ncXV6QraWWdHiwo6xk/8E6M+xv3IyMG8CdycgCl2Het/XAFdng1sX1P1ezIGrHVz1\nBhyt+7imnQJBAMXRPuX3Tov/esVZSBeGxKWLOoZ4mmpoPAY603Ir680rzAbvY7Q/\nq6s7XEjpZC4iyQhwZ0d4FW7LnyQY+UJg67ECQQCDPKS03+nLnorWPu2aahOBeEfr\nY7XhFbhmr5B4+APsjBNfUWNFHaMGOQJsQlz/lynGNpiEjnLHIfHh7foegdV9AkEA\nqDETE6BELpBYKHeS7j3t8PsCFddxI0vgzUMzCP4DDX1Rigv8cAM6yOo9utiGDxwQ\nZZZ8ma2mO3/xnVWGiUOy4QJAO3undOfAICj7yg0L/SqlXZ5VgeYr0mP1Y+yn5Ng3\ne6AxVJJ6wXQRkLEhmVTogfJFmQKXYeAoqNoMHkxtwJCTOQ==\n");
      PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec();
      this(arrayOfByte);
      if (Build.VERSION.SDK_INT >= 28) {
        keyFactory = KeyFactory.getInstance("RSA");
      } else {
        keyFactory = KeyFactory.getInstance("RSA", "BC");
      } 
      this.c = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
      return;
    } catch (IOException iOException) {
      throw new Exception("公钥数据流读取错误");
    } catch (NullPointerException nullPointerException) {
      throw new Exception("公钥输入流为空");
    } 
  }
  
  public String a(String paramString) {
    String str1;
    String str2 = null;
    if (this.b == null) {
      h.a(a, "mServerPublicKey == null");
      return str2;
    } 
    try {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, this.b);
      paramString = u.a(cipher.doFinal(paramString.getBytes("UTF-8")));
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = str2;
    } 
    return str1;
  }
  
  public String a(byte[] paramArrayOfbyte) {
    try {
      Signature signature = Signature.getInstance("SHA256withRSA");
      signature.initSign(this.c);
      signature.update(paramArrayOfbyte);
      String str = u.a(signature.sign());
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */