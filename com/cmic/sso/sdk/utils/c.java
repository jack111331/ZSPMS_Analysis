package com.cmic.sso.sdk.utils;

import java.security.MessageDigest;

public class c {
  protected static char[] a;
  
  protected static MessageDigest b;
  
  private static final char[] c = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  static {
    a = new char[] { 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f' };
    b = null;
    try {
      b = MessageDigest.getInstance("MD5");
    } catch (Exception exception) {}
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    b.update(paramArrayOfbyte);
    return b(b.digest());
  }
  
  private static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuffer stringBuffer = new StringBuffer(paramInt2 * 2);
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
      a(paramArrayOfbyte[i], stringBuffer); 
    return stringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer) {
    char c1 = a[(paramByte & 0xF0) >> 4];
    char c2 = a[paramByte & 0xF];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  private static String b(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */