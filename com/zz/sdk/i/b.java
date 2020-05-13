package com.zz.sdk.i;

public class b {
  static final boolean a = false;
  
  static final boolean b = false;
  
  private static final String c = "GxU3wLPAzOpEbDH5mKRaVZfSNgs07.q8Y4I2CMnoW-6dtke9XvijFyl1BcQrhTJu";
  
  private static final byte[] d = "GxU3wLPAzOpEbDH5mKRaVZfSNgs07.q8Y4I2CMnoW-6dtke9XvijFyl1BcQrhTJu".getBytes();
  
  private static final byte[] e = new byte[128];
  
  static {
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < '') {
        e[b2] = (byte)-1;
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < d.length) {
      e[d[b3]] = (byte)(byte)b3;
      b3++;
    } 
  }
  
  public static void a(String[] paramArrayOfString) {}
  
  public static byte[] a(String paramString) {
    return b(paramString.getBytes());
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[(paramArrayOfbyte.length * 4 + 2) / 3];
    byte b1 = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    while (true) {
      if (b1 < paramArrayOfbyte.length) {
        int m = paramArrayOfbyte[b1] & 0xFF | k;
        k = i + 2;
        i = j + 1;
        arrayOfByte[j] = (byte)d[m >> k & 0x3F];
        if (k == 6) {
          j = i + 1;
          arrayOfByte[i] = (byte)d[m & 0x3F];
          i = 0;
        } else {
          j = i;
          i = k;
        } 
        b1++;
        k = m << 8;
        continue;
      } 
      if (i > 0)
        arrayOfByte[j] = (byte)d[k >> i + 2 & 0x3F]; 
      return arrayOfByte;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    byte b1 = 0;
    int i = paramArrayOfbyte.length;
    byte b2 = 0;
    while (b2 < i) {
      byte b3 = paramArrayOfbyte[b2];
      if (b3 >= 0 && b3 < 128 && e[b3] != -1) {
        b2++;
        continue;
      } 
      return null;
    } 
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length * 3 / 4];
    b2 = 0;
    i = 0;
    int j = 0;
    while (b1 < paramArrayOfbyte.length) {
      j = e[paramArrayOfbyte[b1]] | j;
      if (b2 >= 2) {
        b2 -= 2;
        arrayOfByte[i] = (byte)(byte)(j >> b2 & 0xFF);
        i++;
      } else {
        b2 += 6;
      } 
      j <<= 6;
      b1++;
    } 
    return arrayOfByte;
  }
  
  static {
    byte b3;
    byte b1 = 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */