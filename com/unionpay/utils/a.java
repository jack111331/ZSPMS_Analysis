package com.unionpay.utils;

public final class a {
  public static String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      int j = paramArrayOfbyte[b] & 0xFF;
      stringBuilder.append("0123456789abcdef".charAt(j >> 4));
      stringBuilder.append("0123456789abcdef".charAt(j & 0xF));
    } 
    return stringBuilder.toString();
  }
  
  public static byte[] a(String paramString) {
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length / 2;
    byte[] arrayOfByte = new byte[i];
    for (byte b = 0; b < i; b++) {
      int j = Character.digit(arrayOfChar[b * 2], 16) << 4 | Character.digit(arrayOfChar[b * 2 + 1], 16);
      int k = j;
      if (j > 127)
        k = j - 256; 
      arrayOfByte[b] = (byte)(byte)k;
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */