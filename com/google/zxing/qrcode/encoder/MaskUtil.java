package com.google.zxing.qrcode.encoder;

final class MaskUtil {
  private static final int N1 = 3;
  
  private static final int N2 = 3;
  
  private static final int N3 = 40;
  
  private static final int N4 = 10;
  
  static int applyMaskPenaltyRule1(ByteMatrix paramByteMatrix) {
    return applyMaskPenaltyRule1Internal(paramByteMatrix, true) + applyMaskPenaltyRule1Internal(paramByteMatrix, false);
  }
  
  private static int applyMaskPenaltyRule1Internal(ByteMatrix paramByteMatrix, boolean paramBoolean) {
    int i;
    int j;
    if (paramBoolean) {
      i = paramByteMatrix.getHeight();
    } else {
      i = paramByteMatrix.getWidth();
    } 
    if (paramBoolean) {
      j = paramByteMatrix.getWidth();
    } else {
      j = paramByteMatrix.getHeight();
    } 
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    byte b = 0;
    int k = 0;
    while (b < i) {
      byte b1 = 0;
      int m = 0;
      int n;
      for (n = -1; b1 < j; n = i3) {
        int i2;
        int i3;
        if (paramBoolean) {
          i2 = arrayOfByte[b][b1];
        } else {
          i2 = arrayOfByte[b1][b];
        } 
        if (i2 == n) {
          i2 = m + 1;
          i3 = n;
        } else {
          n = k;
          if (m >= 5)
            n = k + m - 5 + 3; 
          m = 1;
          i3 = i2;
          k = n;
          i2 = m;
        } 
        b1++;
        m = i2;
      } 
      int i1 = k;
      if (m >= 5)
        i1 = k + m - 5 + 3; 
      k = i1;
      b++;
    } 
    return k;
  }
  
  static int applyMaskPenaltyRule2(ByteMatrix paramByteMatrix) {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    byte b = 0;
    int k = 0;
    while (b < j - 1) {
      byte[] arrayOfByte1 = arrayOfByte[b];
      int m = 0;
      while (m < i - 1) {
        byte b1 = arrayOfByte1[m];
        int n = m + 1;
        int i1 = k;
        if (b1 == arrayOfByte1[n]) {
          int i2 = b + 1;
          i1 = k;
          if (b1 == arrayOfByte[i2][m]) {
            i1 = k;
            if (b1 == arrayOfByte[i2][n])
              i1 = k + 1; 
          } 
        } 
        m = n;
        k = i1;
      } 
      b++;
    } 
    return k * 3;
  }
  
  static int applyMaskPenaltyRule3(ByteMatrix paramByteMatrix) {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < j) {
      byte b = 0;
      while (true)
        b++; 
      continue;
      b1++;
    } 
    return b2 * 40;
  }
  
  static int applyMaskPenaltyRule4(ByteMatrix paramByteMatrix) {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    int k = 0;
    int m = 0;
    while (k < j) {
      byte[] arrayOfByte1 = arrayOfByte[k];
      byte b = 0;
      while (b < i) {
        int n = m;
        if (arrayOfByte1[b] == 1)
          n = m + 1; 
        b++;
        m = n;
      } 
      k++;
    } 
    k = paramByteMatrix.getHeight() * paramByteMatrix.getWidth();
    return Math.abs((m << 1) - k) * 10 / k * 10;
  }
  
  static boolean getDataMaskBit(int paramInt1, int paramInt2, int paramInt3) {
    switch (paramInt1) {
      default:
        throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(paramInt1)));
      case 7:
        paramInt1 = paramInt3 * paramInt2 % 3 + (paramInt3 + paramInt2 & 0x1) & 0x1;
        break;
      case 6:
        paramInt1 = paramInt3 * paramInt2;
        paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3 & 0x1;
        break;
      case 5:
        paramInt1 = paramInt3 * paramInt2;
        paramInt1 = (paramInt1 & 0x1) + paramInt1 % 3;
        break;
      case 4:
        paramInt1 = paramInt3 / 2 + paramInt2 / 3 & 0x1;
        break;
      case 3:
        paramInt1 = (paramInt3 + paramInt2) % 3;
        break;
      case 2:
        paramInt1 = paramInt2 % 3;
        break;
      case 1:
        paramInt1 = paramInt3 & 0x1;
        break;
      case 0:
        paramInt1 = paramInt3 + paramInt2 & 0x1;
        break;
    } 
    return (paramInt1 == 0);
  }
  
  private static boolean isWhiteHorizontal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.min(paramInt2, paramArrayOfbyte.length);
    while (paramInt1 < paramInt2) {
      if (paramArrayOfbyte[paramInt1] == 1)
        return false; 
      paramInt1++;
    } 
    return true;
  }
  
  private static boolean isWhiteVertical(byte[][] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    paramInt2 = Math.max(paramInt2, 0);
    paramInt3 = Math.min(paramInt3, paramArrayOfbyte.length);
    while (paramInt2 < paramInt3) {
      if (paramArrayOfbyte[paramInt2][paramInt1] == 1)
        return false; 
      paramInt2++;
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\encoder\MaskUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */