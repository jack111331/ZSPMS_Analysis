package com.alibaba.fastjson.util;

import java.util.Arrays;

public class Base64 {
  public static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  public static final int[] IA = new int[256];
  
  static {
    Arrays.fill(IA, -1);
    int i = CA.length;
    for (byte b = 0; b < i; b++)
      IA[CA[b]] = b; 
    IA[61] = 0;
  }
  
  public static byte[] decodeFast(String paramString) {
    int m;
    byte b;
    int i = paramString.length();
    boolean bool = false;
    if (i == 0)
      return new byte[0]; 
    int j = i - 1;
    int k = 0;
    while (true) {
      m = j;
      if (k < j) {
        m = j;
        if (IA[paramString.charAt(k) & 0xFF] < 0) {
          k++;
          continue;
        } 
      } 
      break;
    } 
    while (m > 0 && IA[paramString.charAt(m) & 0xFF] < 0)
      m--; 
    if (paramString.charAt(m) == '=') {
      if (paramString.charAt(m - 1) == '=') {
        j = 2;
      } else {
        j = 1;
      } 
    } else {
      j = 0;
    } 
    int n = m - k + 1;
    if (i > 76) {
      if (paramString.charAt(76) == '\r') {
        i = n / 78;
      } else {
        i = 0;
      } 
      b = i << 1;
    } else {
      b = 0;
    } 
    int i1 = ((n - b) * 6 >> 3) - j;
    byte[] arrayOfByte = new byte[i1];
    int i2 = i1 / 3;
    int i3 = 0;
    i = 0;
    n = k;
    for (k = i3; k < i2 * 3; k = i3 + 1) {
      int[] arrayOfInt = IA;
      int i4 = n + 1;
      i3 = arrayOfInt[paramString.charAt(n)];
      arrayOfInt = IA;
      n = i4 + 1;
      i4 = arrayOfInt[paramString.charAt(i4)];
      arrayOfInt = IA;
      int i5 = n + 1;
      int i6 = arrayOfInt[paramString.charAt(n)];
      arrayOfInt = IA;
      n = i5 + 1;
      i5 = i3 << 18 | i4 << 12 | i6 << 6 | arrayOfInt[paramString.charAt(i5)];
      i4 = k + 1;
      arrayOfByte[k] = (byte)(byte)(i5 >> 16);
      i3 = i4 + 1;
      arrayOfByte[i4] = (byte)(byte)(i5 >> 8);
      arrayOfByte[i3] = (byte)(byte)i5;
      k = i;
      if (b > 0) {
        k = ++i;
        if (i == 19) {
          n += 2;
          i = 0;
          continue;
        } 
      } 
      i = k;
      continue;
    } 
    if (k < i1) {
      b = 0;
      i = bool;
      while (n <= m - j) {
        i |= IA[paramString.charAt(n)] << 18 - b * 6;
        b++;
        n++;
      } 
      j = 16;
      while (k < i1) {
        arrayOfByte[k] = (byte)(byte)(i >> j);
        j -= 8;
        k++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static byte[] decodeFast(String paramString, int paramInt1, int paramInt2) {
    int k;
    byte b;
    boolean bool = false;
    if (paramInt2 == 0)
      return new byte[0]; 
    int i = paramInt1 + paramInt2 - 1;
    int j = paramInt1;
    while (true) {
      k = i;
      if (j < i) {
        k = i;
        if (IA[paramString.charAt(j)] < 0) {
          j++;
          continue;
        } 
      } 
      break;
    } 
    while (k > 0 && IA[paramString.charAt(k)] < 0)
      k--; 
    if (paramString.charAt(k) == '=') {
      if (paramString.charAt(k - 1) == '=') {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      } 
    } else {
      paramInt1 = 0;
    } 
    i = k - j + 1;
    if (paramInt2 > 76) {
      if (paramString.charAt(76) == '\r') {
        paramInt2 = i / 78;
      } else {
        paramInt2 = 0;
      } 
      b = paramInt2 << 1;
    } else {
      b = 0;
    } 
    int m = ((i - b) * 6 >> 3) - paramInt1;
    byte[] arrayOfByte = new byte[m];
    int n = m / 3;
    i = j;
    paramInt2 = 0;
    j = 0;
    while (paramInt2 < n * 3) {
      int[] arrayOfInt = IA;
      int i1 = i + 1;
      int i2 = arrayOfInt[paramString.charAt(i)];
      arrayOfInt = IA;
      i = i1 + 1;
      int i3 = arrayOfInt[paramString.charAt(i1)];
      arrayOfInt = IA;
      i1 = i + 1;
      int i4 = arrayOfInt[paramString.charAt(i)];
      arrayOfInt = IA;
      i = i1 + 1;
      i1 = i2 << 18 | i3 << 12 | i4 << 6 | arrayOfInt[paramString.charAt(i1)];
      i3 = paramInt2 + 1;
      arrayOfByte[paramInt2] = (byte)(byte)(i1 >> 16);
      i2 = i3 + 1;
      arrayOfByte[i3] = (byte)(byte)(i1 >> 8);
      arrayOfByte[i2] = (byte)(byte)i1;
      paramInt2 = j;
      if (b > 0) {
        paramInt2 = ++j;
        if (j == 19) {
          i += 2;
          paramInt2 = 0;
        } 
      } 
      i2++;
      j = paramInt2;
      paramInt2 = i2;
    } 
    if (paramInt2 < m) {
      b = 0;
      j = bool;
      while (i <= k - paramInt1) {
        j |= IA[paramString.charAt(i)] << 18 - b * 6;
        b++;
        i++;
      } 
      paramInt1 = 16;
      while (paramInt2 < m) {
        arrayOfByte[paramInt2] = (byte)(byte)(j >> paramInt1);
        paramInt1 -= 8;
        paramInt2++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static byte[] decodeFast(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    int k;
    byte b;
    boolean bool = false;
    if (paramInt2 == 0)
      return new byte[0]; 
    int i = paramInt1 + paramInt2 - 1;
    int j = paramInt1;
    while (true) {
      k = i;
      if (j < i) {
        k = i;
        if (IA[paramArrayOfchar[j]] < 0) {
          j++;
          continue;
        } 
      } 
      break;
    } 
    while (k > 0 && IA[paramArrayOfchar[k]] < 0)
      k--; 
    if (paramArrayOfchar[k] == '=') {
      if (paramArrayOfchar[k - 1] == '=') {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      } 
    } else {
      paramInt1 = 0;
    } 
    i = k - j + 1;
    if (paramInt2 > 76) {
      if (paramArrayOfchar[76] == '\r') {
        paramInt2 = i / 78;
      } else {
        paramInt2 = 0;
      } 
      b = paramInt2 << 1;
    } else {
      b = 0;
    } 
    int m = ((i - b) * 6 >> 3) - paramInt1;
    byte[] arrayOfByte = new byte[m];
    int n = m / 3;
    i = j;
    paramInt2 = 0;
    j = 0;
    while (paramInt2 < n * 3) {
      int[] arrayOfInt = IA;
      int i1 = i + 1;
      int i2 = arrayOfInt[paramArrayOfchar[i]];
      arrayOfInt = IA;
      i = i1 + 1;
      i1 = arrayOfInt[paramArrayOfchar[i1]];
      arrayOfInt = IA;
      int i3 = i + 1;
      int i4 = arrayOfInt[paramArrayOfchar[i]];
      arrayOfInt = IA;
      i = i3 + 1;
      i1 = i2 << 18 | i1 << 12 | i4 << 6 | arrayOfInt[paramArrayOfchar[i3]];
      i3 = paramInt2 + 1;
      arrayOfByte[paramInt2] = (byte)(byte)(i1 >> 16);
      i2 = i3 + 1;
      arrayOfByte[i3] = (byte)(byte)(i1 >> 8);
      arrayOfByte[i2] = (byte)(byte)i1;
      paramInt2 = j;
      if (b > 0) {
        paramInt2 = ++j;
        if (j == 19) {
          i += 2;
          j = 0;
          continue;
        } 
      } 
      j = paramInt2;
      continue;
      paramInt2 = SYNTHETIC_LOCAL_VARIABLE_13 + 1;
    } 
    if (paramInt2 < m) {
      b = 0;
      j = bool;
      while (i <= k - paramInt1) {
        j |= IA[paramArrayOfchar[i]] << 18 - b * 6;
        b++;
        i++;
      } 
      paramInt1 = 16;
      while (paramInt2 < m) {
        arrayOfByte[paramInt2] = (byte)(byte)(j >> paramInt1);
        paramInt1 -= 8;
        paramInt2++;
      } 
    } 
    return arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */