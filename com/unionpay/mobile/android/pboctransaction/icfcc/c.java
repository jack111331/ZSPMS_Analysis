package com.unionpay.mobile.android.pboctransaction.icfcc;

import com.unionpay.mobile.android.pboctransaction.e;

public final class c {
  public static String a(String paramString1, String paramString2) {
    byte b = 1;
    if (paramString1 == null)
      return null; 
    byte[] arrayOfByte = e.a(paramString1);
    int i = 0;
    while (true) {
      if (i < arrayOfByte.length) {
        int j;
        if ((byte)(arrayOfByte[i] & 0x1F) == 31) {
          j = 2;
        } else {
          j = 1;
        } 
        byte[] arrayOfByte1 = new byte[j];
        System.arraycopy(arrayOfByte, i, arrayOfByte1, 0, j);
        if (e.a(arrayOfByte1, j).compareToIgnoreCase(paramString2) == 0) {
          int m = j + i;
          if ((byte)(arrayOfByte[m] & 0x80) != Byte.MIN_VALUE) {
            i = arrayOfByte[m] & 0xFF;
            j = b;
          } else {
            j = (arrayOfByte[m] & Byte.MAX_VALUE) + 1;
            if (j == 2) {
              i = arrayOfByte[m + 1] & 0xFF;
            } else if (j == 3) {
              i = (arrayOfByte[m + 1] & 0xFF) << 8 | arrayOfByte[m + 2] & 0xFF;
            } else if (j == 4) {
              i = (arrayOfByte[m + 1] & 0xFF) << 16 | (arrayOfByte[m + 2] & 0xFF) << 8 | arrayOfByte[m + 3] & 0xFF;
            } else {
              i = 0;
            } 
          } 
          byte[] arrayOfByte2 = new byte[i];
          System.arraycopy(arrayOfByte, m + j, arrayOfByte2, 0, i);
          return e.a(arrayOfByte2, i);
        } 
        if ((arrayOfByte[i] & 0x20) == 32) {
          j += i;
          if (j < arrayOfByte.length && (byte)(arrayOfByte[j] & 0x80) == Byte.MIN_VALUE) {
            i = (arrayOfByte[j] & Byte.MAX_VALUE) + 1;
          } else {
            i = 1;
          } 
          i += j;
          continue;
        } 
        int k = i + j;
        if (k < arrayOfByte.length && (byte)(arrayOfByte[k] & 0x80) == 0) {
          i = arrayOfByte[k] & 0xFF;
          j = 1;
        } else {
          if (k < arrayOfByte.length) {
            j = (arrayOfByte[k] & Byte.MAX_VALUE) + 1;
          } else {
            j = 0;
          } 
          if (j == 2 && k + 1 < arrayOfByte.length) {
            i = arrayOfByte[k + 1] & 0xFF;
          } else if (j == 3 && k + 2 < arrayOfByte.length) {
            i = (arrayOfByte[k + 1] & 0xFF) << 8 | arrayOfByte[k + 2] & 0xFF;
          } else if (j == 4 && k + 2 < arrayOfByte.length) {
            i = (arrayOfByte[k + 1] & 0xFF) << 16 | (arrayOfByte[k + 2] & 0xFF) << 8 | arrayOfByte[k + 3] & 0xFF;
          } else {
            i = 0;
          } 
        } 
        i = i + j + k;
        continue;
      } 
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\icfcc\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */