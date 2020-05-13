package com.tencent.wxop.stat.b;

final class j extends i {
  private static final int[] cJ = new int[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
      -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1 };
  
  private static final int[] cK = new int[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
      -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1 };
  
  private int bf;
  
  private final int[] cL;
  
  private int cu;
  
  public j(byte[] paramArrayOfbyte) {
    this.cI = paramArrayOfbyte;
    this.cL = cJ;
    this.cu = 0;
    this.bf = 0;
  }
  
  public final boolean a(byte[] paramArrayOfbyte, int paramInt) {
    int i2;
    int i3;
    if (this.cu == 6)
      return false; 
    int k = paramInt + 0;
    int m = this.cu;
    int n = this.bf;
    byte[] arrayOfByte = this.cI;
    int[] arrayOfInt = this.cL;
    paramInt = 0;
    int i1 = 0;
    while (true) {
      i2 = i1;
      i3 = n;
      if (paramInt < k) {
        i2 = i1;
        int i4 = n;
        i3 = paramInt;
        if (m == 0) {
          i4 = paramInt;
          paramInt = n;
          while (i4 + 4 <= k) {
            n = arrayOfInt[paramArrayOfbyte[i4] & 0xFF] << 18 | arrayOfInt[paramArrayOfbyte[i4 + 1] & 0xFF] << 12 | arrayOfInt[paramArrayOfbyte[i4 + 2] & 0xFF] << 6 | arrayOfInt[paramArrayOfbyte[i4 + 3] & 0xFF];
            paramInt = n;
            if (n >= 0) {
              arrayOfByte[i1 + 2] = (byte)(byte)n;
              arrayOfByte[i1 + 1] = (byte)(byte)(n >> 8);
              arrayOfByte[i1] = (byte)(byte)(n >> 16);
              i1 += 3;
              i4 += 4;
              paramInt = n;
            } 
          } 
          i2 = i1;
          i3 = paramInt;
          if (i4 < k) {
            i3 = i4;
            i4 = paramInt;
            i2 = i1;
          } else {
            break;
          } 
        } 
        paramInt = i3 + 1;
        n = arrayOfInt[paramArrayOfbyte[i3] & 0xFF];
        switch (m) {
          case 0:
            if (n >= 0) {
              m++;
              i1 = i2;
              break;
            } 
            if (n != -1) {
              this.cu = 6;
              return false;
            } 
            i1 = i2;
            n = i4;
            break;
          case 1:
            if (n >= 0) {
              n = i4 << 6 | n;
              m++;
              i1 = i2;
              break;
            } 
            if (n != -1) {
              this.cu = 6;
              return false;
            } 
            i1 = i2;
            n = i4;
            break;
          case 2:
            if (n >= 0) {
              n = i4 << 6 | n;
              m++;
              i1 = i2;
              break;
            } 
            if (n == -2) {
              arrayOfByte[i2] = (byte)(byte)(i4 >> 4);
              m = 4;
              i1 = i2 + 1;
              n = i4;
              break;
            } 
            if (n != -1) {
              this.cu = 6;
              return false;
            } 
            i1 = i2;
            n = i4;
            break;
          case 3:
            if (n >= 0) {
              n = i4 << 6 | n;
              arrayOfByte[i2 + 2] = (byte)(byte)n;
              arrayOfByte[i2 + 1] = (byte)(byte)(n >> 8);
              arrayOfByte[i2] = (byte)(byte)(n >> 16);
              i1 = i2 + 3;
              m = 0;
              break;
            } 
            if (n == -2) {
              arrayOfByte[i2 + 1] = (byte)(byte)(i4 >> 2);
              arrayOfByte[i2] = (byte)(byte)(i4 >> 10);
              i1 = i2 + 2;
              m = 5;
              n = i4;
              break;
            } 
            if (n != -1) {
              this.cu = 6;
              return false;
            } 
            i1 = i2;
            n = i4;
            break;
          case 4:
            if (n == -2) {
              m++;
              i1 = i2;
              n = i4;
              break;
            } 
            if (n != -1) {
              this.cu = 6;
              return false;
            } 
            i1 = i2;
            n = i4;
            break;
          case 5:
            if (n != -1) {
              this.cu = 6;
              return false;
            } 
            i1 = i2;
            n = i4;
            break;
        } 
        continue;
      } 
      break;
    } 
    paramInt = i2;
    switch (m) {
      default:
        paramInt = i2;
      case 0:
        this.cu = m;
        this.g = paramInt;
        return true;
      case 1:
        this.cu = 6;
        return false;
      case 2:
        arrayOfByte[i2] = (byte)(byte)(i3 >> 4);
        paramInt = i2 + 1;
      case 3:
        n = i2 + 1;
        arrayOfByte[i2] = (byte)(byte)(i3 >> 10);
        paramInt = n + 1;
        arrayOfByte[n] = (byte)(byte)(i3 >> 2);
      case 4:
        break;
    } 
    this.cu = 6;
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */