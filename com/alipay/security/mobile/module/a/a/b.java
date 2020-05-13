package com.alipay.security.mobile.module.a.a;

import com.alipay.security.mobile.module.a.a;
import java.security.MessageDigest;

public final class b {
  public static String a(String paramString) {
    String str1;
    String str2 = null;
    byte b1 = 0;
    try {
      if (a.a(paramString))
        return str2; 
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      while (b1 < arrayOfByte.length) {
        stringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(arrayOfByte[b1]) }));
        b1++;
      } 
      str1 = stringBuilder.toString();
    } catch (Exception exception) {
      str1 = str2;
    } 
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */