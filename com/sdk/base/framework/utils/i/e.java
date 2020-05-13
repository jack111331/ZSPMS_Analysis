package com.sdk.base.framework.utils.i;

import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import com.sdk.base.framework.utils.k.a;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class e extends a {
  private static final String a = e.class.getName();
  
  private static boolean b = c.h;
  
  private static final char[] c = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static String a(String paramString) {
    String str = null;
    if (a.a(paramString).booleanValue())
      return str; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes(Charset.defaultCharset()));
      paramString = new String();
      this(a(messageDigest.digest()));
    } catch (Exception exception) {
      logError(a, "encrypt", exception.getMessage(), b);
      exception = null;
    } 
    return (String)exception;
  }
  
  private static char[] a(byte[] paramArrayOfbyte) {
    int i = 0;
    int j = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[j << 1];
    for (byte b = 0; b < j; b++) {
      int k = i + 1;
      arrayOfChar[i] = (char)c[(paramArrayOfbyte[b] & 0xF0) >>> 4];
      i = k + 1;
      arrayOfChar[k] = (char)c[paramArrayOfbyte[b] & 0xF];
    } 
    return arrayOfChar;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */