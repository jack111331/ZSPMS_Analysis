package com.unionpay.mobile.android.pboctransaction.nfc;

public final class c {
  private static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  public static String a(byte[] paramArrayOfbyte, int paramInt) {
    byte b = 0;
    char[] arrayOfChar = new char[paramInt * 2];
    int i = 0;
    while (b < paramInt + 0) {
      byte b1 = paramArrayOfbyte[b];
      int j = i + 1;
      arrayOfChar[i] = (char)a[b1 >> 4 & 0xF];
      i = j + 1;
      arrayOfChar[j] = (char)a[b1 & 0xF];
      b++;
    } 
    return new String(arrayOfChar);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\nfc\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */