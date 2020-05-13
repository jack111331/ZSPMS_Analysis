package com.alipay.security.mobile.module.a.a;

public final class a {
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
  
  public static byte[] a(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    byte[] arrayOfByte = paramString.getBytes("US-ASCII");
    int i = arrayOfByte.length;
    int j = 0;
    label52: while (true) {
      if (j < i) {
        int k;
        for (k = j;; k = j) {
          byte[] arrayOfByte1 = b;
          j = k + 1;
          byte b = arrayOfByte1[arrayOfByte[k]];
          if (j >= i || b != -1) {
            if (b != -1) {
              for (k = j;; k = j) {
                arrayOfByte1 = b;
                j = k + 1;
                byte b1 = arrayOfByte1[arrayOfByte[k]];
                if (j >= i || b1 != -1) {
                  if (b1 != -1) {
                    stringBuffer.append((char)(b << 2 | (b1 & 0x30) >>> 4));
                    for (k = j;; k = j) {
                      j = k + 1;
                      k = arrayOfByte[k];
                      if (k == 61) {
                        arrayOfByte = stringBuffer.toString().getBytes("iso8859-1");
                        continue;
                      } 
                      b = b[k];
                      if (j >= i || b != -1) {
                        if (b != -1) {
                          stringBuffer.append((char)((b1 & 0xF) << 4 | (b & 0x3C) >>> 2));
                          for (k = j;; k = j) {
                            j = k + 1;
                            k = arrayOfByte[k];
                            if (k == 61)
                              return stringBuffer.toString().getBytes("iso8859-1"); 
                            k = b[k];
                            if (j >= i || k != -1) {
                              if (k != -1) {
                                stringBuffer.append((char)(k | (b & 0x3) << 6));
                                continue label52;
                              } 
                              return stringBuffer.toString().getBytes("iso8859-1");
                            } 
                          } 
                          break;
                        } 
                        continue;
                      } 
                    } 
                    break;
                  } 
                  continue;
                } 
              } 
              break;
            } 
            continue;
          } 
        } 
        break;
      } 
      continue;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */