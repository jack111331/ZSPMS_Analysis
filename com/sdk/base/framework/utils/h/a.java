package com.sdk.base.framework.utils.h;

import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class a {
  private static final String a = a.class.getSimpleName();
  
  private static Boolean b = Boolean.valueOf(c.h);
  
  public static PublicKey a(String paramString) {
    Exception exception2 = null;
    try {
      com.sdk.base.framework.e.a a1 = new com.sdk.base.framework.e.a();
      this();
      byte[] arrayOfByte = a1.a(paramString);
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(arrayOfByte);
      PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
    } catch (Exception exception1) {
      b.c(a, exception1.toString(), b);
      exception1 = exception2;
    } 
    return (PublicKey)exception1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */