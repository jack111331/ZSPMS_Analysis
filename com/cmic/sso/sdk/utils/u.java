package com.cmic.sso.sdk.utils;

import java.util.Locale;

public class u {
  public static String a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      stringBuffer.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfbyte[b] & 0xFF) }));
    } 
    return stringBuffer.toString().toUpperCase(Locale.getDefault());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\util\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */