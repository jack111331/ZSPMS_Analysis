package com.qiniu.android.dns.util;

import java.io.IOException;

public final class Hex {
  private static final char[] DIGITS_LOWER = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final char[] DIGITS_UPPER = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static byte[] decodeHex(char[] paramArrayOfchar) throws HexDecodeException {
    int i = paramArrayOfchar.length;
    if ((i & 0x1) == 0) {
      byte[] arrayOfByte = new byte[i >> 1];
      byte b1 = 0;
      for (byte b2 = 0; b1 < i; b2++) {
        int j = toDigit(paramArrayOfchar[b1], b1);
        int k = toDigit(paramArrayOfchar[++b1], b1);
        b1++;
        arrayOfByte[b2] = (byte)(byte)((j << 4 | k) & 0xFF);
      } 
      return arrayOfByte;
    } 
    throw new HexDecodeException("Odd number of characters.");
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte) {
    return encodeHex(paramArrayOfbyte, true);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte, boolean paramBoolean) {
    char[] arrayOfChar;
    if (paramBoolean) {
      arrayOfChar = DIGITS_LOWER;
    } else {
      arrayOfChar = DIGITS_UPPER;
    } 
    return encodeHex(paramArrayOfbyte, arrayOfChar);
  }
  
  private static char[] encodeHex(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
    int i = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[i << 1];
    byte b = 0;
    int j = 0;
    while (b < i) {
      int k = j + 1;
      arrayOfChar[j] = (char)paramArrayOfchar[(paramArrayOfbyte[b] & 0xF0) >>> 4];
      j = k + 1;
      arrayOfChar[k] = (char)paramArrayOfchar[paramArrayOfbyte[b] & 0xF];
      b++;
    } 
    return arrayOfChar;
  }
  
  public static String encodeHexString(byte[] paramArrayOfbyte) {
    return new String(encodeHex(paramArrayOfbyte));
  }
  
  protected static int toDigit(char paramChar, int paramInt) throws HexDecodeException {
    int i = Character.digit(paramChar, 16);
    if (i != -1)
      return i; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Illegal hexadecimal character ");
    stringBuilder.append(paramChar);
    stringBuilder.append(" at index ");
    stringBuilder.append(paramInt);
    throw new HexDecodeException(stringBuilder.toString());
  }
  
  public static class HexDecodeException extends IOException {
    public HexDecodeException(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dn\\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */