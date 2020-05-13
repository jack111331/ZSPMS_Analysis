package com.chuanglan.shanyan_sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64 {
  private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  private static int a(char paramChar) {
    if (paramChar >= 'A' && paramChar <= 'Z')
      return paramChar - 65; 
    if (paramChar >= 'a' && paramChar <= 'z')
      return paramChar - 97 + 26; 
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48 + 26 + 26; 
    switch (paramChar) {
      default:
        throw new RuntimeException("unexpected code: " + paramChar);
      case '+':
        return 62;
      case '/':
        return 63;
      case '=':
        break;
    } 
    return 0;
  }
  
  private static void a(String paramString, OutputStream paramOutputStream) {
    byte b = 0;
    int i = paramString.length();
    while (true) {
      if (b < i && paramString.charAt(b) <= ' ') {
        b++;
        continue;
      } 
      if (b != i) {
        int j = (a(paramString.charAt(b)) << 18) + (a(paramString.charAt(b + 1)) << 12) + (a(paramString.charAt(b + 2)) << 6) + a(paramString.charAt(b + 3));
        paramOutputStream.write(j >> 16 & 0xFF);
        if (paramString.charAt(b + 2) != '=') {
          paramOutputStream.write(j >> 8 & 0xFF);
          if (paramString.charAt(b + 3) != '=') {
            paramOutputStream.write(j & 0xFF);
            b += 4;
            continue;
          } 
        } 
      } 
      return;
    } 
  }
  
  public static byte[] decode(String paramString) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      a(paramString, byteArrayOutputStream);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      try {
        byteArrayOutputStream.close();
      } catch (IOException iOException) {
        System.err.println("Error while decoding BASE64: " + iOException.toString());
      } 
    } catch (IOException iOException) {
      throw new RuntimeException();
    } 
  }
  
  public static String encode(byte[] paramArrayOfbyte) {
    int i = paramArrayOfbyte.length;
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 3 / 2);
    int j = 0;
    byte b = 0;
    while (b <= i - 3) {
      int k = (paramArrayOfbyte[b] & 0xFF) << 16 | (paramArrayOfbyte[b + 1] & 0xFF) << 8 | paramArrayOfbyte[b + 2] & 0xFF;
      stringBuffer.append(a[k >> 18 & 0x3F]);
      stringBuffer.append(a[k >> 12 & 0x3F]);
      stringBuffer.append(a[k >> 6 & 0x3F]);
      stringBuffer.append(a[k & 0x3F]);
      k = j + 1;
      if (j >= 14) {
        stringBuffer.append(" ");
        k = 0;
      } 
      b += 3;
      j = k;
    } 
    if (b == 0 + i - 2) {
      byte b1 = paramArrayOfbyte[b];
      int k = (paramArrayOfbyte[b + 1] & 0xFF) << 8 | (b1 & 0xFF) << 16;
      stringBuffer.append(a[k >> 18 & 0x3F]);
      stringBuffer.append(a[k >> 12 & 0x3F]);
      stringBuffer.append(a[k >> 6 & 0x3F]);
      stringBuffer.append("=");
      return stringBuffer.toString();
    } 
    if (b == 0 + i - 1) {
      int k = (paramArrayOfbyte[b] & 0xFF) << 16;
      stringBuffer.append(a[k >> 18 & 0x3F]);
      stringBuffer.append(a[k >> 12 & 0x3F]);
      stringBuffer.append("==");
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */