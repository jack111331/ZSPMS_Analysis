package com.unionpay.mobile.android.utils;

public final class b {
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int i = paramArrayOfbyte.length;
    for (byte b1 = 0; b1 < i; b1++) {
      int j = paramArrayOfbyte[b1] & 0xFF;
      stringBuilder.append("0123456789abcdef".charAt(j >> 4));
      stringBuilder.append("0123456789abcdef".charAt(j & 0xF));
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length / 2;
    byte[] arrayOfByte = new byte[i];
    for (byte b1 = 0; b1 < i; b1++) {
      int j = Character.digit(arrayOfChar[b1 * 2], 16) << 4 | Character.digit(arrayOfChar[b1 * 2 + 1], 16);
      int k = j;
      if (j > 127)
        k = j - 256; 
      arrayOfByte[b1] = (byte)(byte)k;
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */