package com.sina.weibo.sdk.utils;

public final class Base64 {
  private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
  
  private static byte[] codes = new byte[256];
  
  static {
    for (byte b = 0;; b++) {
      if (b >= 'Ā') {
        for (b = 65;; b++) {
          if (b > 90) {
            for (b = 97;; b++) {
              if (b > 122) {
                for (b = 48;; b++) {
                  if (b > 57) {
                    codes[43] = (byte)62;
                    codes[47] = (byte)63;
                    return;
                  } 
                  codes[b] = (byte)(byte)(b + 52 - 48);
                } 
                break;
              } 
              codes[b] = (byte)(byte)(b + 26 - 97);
            } 
            break;
          } 
          codes[b] = (byte)(byte)(b - 65);
        } 
        break;
      } 
      codes[b] = (byte)-1;
    } 
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte) {
    int i = (paramArrayOfbyte.length + 3) / 4 * 3;
    int j = i;
    if (paramArrayOfbyte.length > 0) {
      j = i;
      if (paramArrayOfbyte[paramArrayOfbyte.length - 1] == 61)
        j = i - 1; 
    } 
    i = j;
    if (paramArrayOfbyte.length > 1) {
      i = j;
      if (paramArrayOfbyte[paramArrayOfbyte.length - 2] == 61)
        i = j - 1; 
    } 
    byte[] arrayOfByte = new byte[i];
    i = 0;
    int k = 0;
    int m = 0;
    int n;
    for (n = 0;; n = j) {
      if (i >= paramArrayOfbyte.length) {
        if (k == arrayOfByte.length)
          return arrayOfByte; 
        throw new RuntimeException("miscalculated data length!");
      } 
      byte b = codes[paramArrayOfbyte[i] & 0xFF];
      int i1 = k;
      int i2 = m;
      j = n;
      if (b >= 0) {
        n += true;
        m = m << 6 | b;
        i1 = k;
        i2 = m;
        j = n;
        if (n >= 8) {
          j = n - 8;
          arrayOfByte[k] = (byte)(byte)(m >> j & 0xFF);
          i1 = k + 1;
          i2 = m;
        } 
      } 
      i++;
      k = i1;
      m = i2;
    } 
  }
  
  public static char[] encode(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[(paramArrayOfbyte.length + 2) / 3 * 4];
    byte b1 = 0;
    for (byte b2 = 0;; b2 += 4) {
      if (b1 >= paramArrayOfbyte.length)
        return arrayOfChar; 
      int i = (paramArrayOfbyte[b1] & 0xFF) << 8;
      int j = b1 + 1;
      int k = paramArrayOfbyte.length;
      int m = 1;
      if (j < k) {
        i |= paramArrayOfbyte[j] & 0xFF;
        k = 1;
      } else {
        k = 0;
      } 
      i <<= 8;
      j = b1 + 2;
      if (j < paramArrayOfbyte.length) {
        i |= paramArrayOfbyte[j] & 0xFF;
      } else {
        m = 0;
      } 
      char[] arrayOfChar1 = alphabet;
      j = 64;
      if (m) {
        m = i & 0x3F;
      } else {
        m = 64;
      } 
      arrayOfChar[b2 + 3] = (char)arrayOfChar1[m];
      m = i >> 6;
      arrayOfChar1 = alphabet;
      i = j;
      if (k != 0)
        i = m & 0x3F; 
      arrayOfChar[b2 + 2] = (char)arrayOfChar1[i];
      k = m >> 6;
      arrayOfChar[b2 + 1] = (char)alphabet[k & 0x3F];
      arrayOfChar[b2 + 0] = (char)alphabet[k >> 6 & 0x3F];
      b1 += 3;
    } 
  }
  
  public static byte[] encodebyte(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[(paramArrayOfbyte.length + 2) / 3 * 4];
    byte b1 = 0;
    for (byte b2 = 0;; b2 += 4) {
      if (b1 >= paramArrayOfbyte.length)
        return arrayOfByte; 
      int i = (paramArrayOfbyte[b1] & 0xFF) << 8;
      int j = b1 + 1;
      int k = paramArrayOfbyte.length;
      int m = 1;
      if (j < k) {
        i |= paramArrayOfbyte[j] & 0xFF;
        j = 1;
      } else {
        j = 0;
      } 
      i <<= 8;
      k = b1 + 2;
      if (k < paramArrayOfbyte.length) {
        i |= paramArrayOfbyte[k] & 0xFF;
      } else {
        m = 0;
      } 
      char[] arrayOfChar = alphabet;
      k = 64;
      if (m) {
        m = i & 0x3F;
      } else {
        m = 64;
      } 
      arrayOfByte[b2 + 3] = (byte)(byte)arrayOfChar[m];
      m = i >> 6;
      arrayOfChar = alphabet;
      i = k;
      if (j != 0)
        i = m & 0x3F; 
      arrayOfByte[b2 + 2] = (byte)(byte)arrayOfChar[i];
      j = m >> 6;
      arrayOfByte[b2 + 1] = (byte)(byte)alphabet[j & 0x3F];
      arrayOfByte[b2 + 0] = (byte)(byte)alphabet[j >> 6 & 0x3F];
      b1 += 3;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */