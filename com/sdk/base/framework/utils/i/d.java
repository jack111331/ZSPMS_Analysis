package com.sdk.base.framework.utils.i;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class d {
  private static char[] a = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static byte[] b = new byte[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
      -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -1, -1, -1, -1, -1 };
  
  public static String a(String paramString) {
    return a(paramString.getBytes("utf-8"));
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    int i = paramArrayOfbyte.length;
    int j = 0;
    while (true) {
      int m;
      if (j < i) {
        k = j + 1;
        m = paramArrayOfbyte[j] & 0xFF;
        if (k == i) {
          stringBuffer.append(a[m >>> 2]);
          stringBuffer.append(a[(m & 0x3) << 4]);
          stringBuffer.append("==");
          return stringBuffer.toString();
        } 
      } else {
        return stringBuffer.toString();
      } 
      int n = k + 1;
      int k = paramArrayOfbyte[k] & 0xFF;
      if (n == i) {
        stringBuffer.append(a[m >>> 2]);
        stringBuffer.append(a[(m & 0x3) << 4 | (k & 0xF0) >>> 4]);
        stringBuffer.append(a[(k & 0xF) << 2]);
        stringBuffer.append("=");
        return stringBuffer.toString();
      } 
      j = n + 1;
      n = paramArrayOfbyte[n] & 0xFF;
      stringBuffer.append(a[m >>> 2]);
      stringBuffer.append(a[(m & 0x3) << 4 | (k & 0xF0) >>> 4]);
      stringBuffer.append(a[(k & 0xF) << 2 | (n & 0xC0) >>> 6]);
      stringBuffer.append(a[n & 0x3F]);
    } 
  }
  
  public static String b(String paramString) {
    return new String(c(paramString), Charset.defaultCharset());
  }
  
  public static byte[] c(String paramString) {
    byte[] arrayOfByte = paramString.getBytes(Charset.defaultCharset());
    int i = arrayOfByte.length;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
    int j = 0;
    label49: while (true) {
      if (j < i) {
        label46: while (true) {
          byte[] arrayOfByte1 = b;
          int k = j + 1;
          byte b = arrayOfByte1[arrayOfByte[j]];
          if (k >= i || b != -1) {
            byte b1;
            if (b == -1)
              continue; 
            while (true) {
              arrayOfByte1 = b;
              j = k + 1;
              b1 = arrayOfByte1[arrayOfByte[k]];
              if (j >= i || b1 != -1)
                break; 
              k = j;
            } 
            if (b1 != -1) {
              byteArrayOutputStream.write(b << 2 | (b1 & 0x30) >>> 4);
              for (k = j;; k = j) {
                j = k + 1;
                k = arrayOfByte[k];
                if (k == 61) {
                  arrayOfByte = byteArrayOutputStream.toByteArray();
                  continue label46;
                } 
                b = b[k];
                if (j >= i || b != -1) {
                  if (b != -1) {
                    byteArrayOutputStream.write((b1 & 0xF) << 4 | (b & 0x3C) >>> 2);
                    for (k = j;; k = j) {
                      j = k + 1;
                      k = arrayOfByte[k];
                      if (k == 61)
                        return byteArrayOutputStream.toByteArray(); 
                      k = b[k];
                      if (j >= i || k != -1) {
                        if (k != -1) {
                          byteArrayOutputStream.write(k | (b & 0x3) << 6);
                          continue label49;
                        } 
                        return byteArrayOutputStream.toByteArray();
                      } 
                    } 
                    break;
                  } 
                  continue label46;
                } 
              } 
              break;
            } 
            continue;
          } 
          j = k;
        } 
        break;
      } 
      continue;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */