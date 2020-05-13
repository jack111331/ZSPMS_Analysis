package com.tencent.wxop.stat.b;

import android.util.Base64;

public final class g {
  private static byte[] a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    int i = 0;
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int j = paramArrayOfbyte2.length;
    if (j <= 0 || j > 256)
      throw new IllegalArgumentException("key must be between 1 and 256 bytes"); 
    int k;
    for (k = 0; k < 256; k++) {
      arrayOfInt1[k] = k;
      arrayOfInt2[k] = paramArrayOfbyte2[k % j];
    } 
    j = 0;
    for (k = 0; k < 256; k++) {
      j = j + arrayOfInt1[k] + arrayOfInt2[k] & 0xFF;
      int n = arrayOfInt1[k];
      arrayOfInt1[k] = arrayOfInt1[j];
      arrayOfInt1[j] = n;
    } 
    paramArrayOfbyte2 = new byte[paramArrayOfbyte1.length];
    int m = 0;
    k = 0;
    for (j = i; j < paramArrayOfbyte1.length; j++) {
      m = m + 1 & 0xFF;
      k = k + arrayOfInt1[m] & 0xFF;
      i = arrayOfInt1[m];
      arrayOfInt1[m] = arrayOfInt1[k];
      arrayOfInt1[k] = i;
      paramArrayOfbyte2[j] = (byte)(byte)(arrayOfInt1[arrayOfInt1[m] + arrayOfInt1[k] & 0xFF] ^ paramArrayOfbyte1[j]);
    } 
    return paramArrayOfbyte2;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
  }
  
  public static byte[] c(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */