package com.alipay.sdk.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b {
  public static String a(int paramInt, String paramString1, String paramString2) {
    try {
      byte[] arrayOfByte1;
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramString2.getBytes(), "DES");
      Cipher cipher = Cipher.getInstance("DES");
      cipher.init(paramInt, secretKeySpec);
      if (paramInt == 2) {
        arrayOfByte1 = a.a(paramString1);
      } else {
        arrayOfByte1 = arrayOfByte1.getBytes("UTF-8");
      } 
      byte[] arrayOfByte2 = cipher.doFinal(arrayOfByte1);
      if (paramInt == 2) {
        String str1 = new String();
        this(arrayOfByte2);
        return str1;
      } 
      String str = a.a(arrayOfByte2);
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  private static String a(String paramString1, String paramString2) {
    return a(1, paramString1, paramString2);
  }
  
  private static String b(String paramString1, String paramString2) {
    return a(2, paramString1, paramString2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\encrypt\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */