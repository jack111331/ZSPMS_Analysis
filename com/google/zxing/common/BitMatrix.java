package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {
  private final int[] bits;
  
  private final int height;
  
  private final int rowSize;
  
  private final int width;
  
  public BitMatrix(int paramInt) {
    this(paramInt, paramInt);
  }
  
  public BitMatrix(int paramInt1, int paramInt2) {
    if (paramInt1 > 0 && paramInt2 > 0) {
      this.width = paramInt1;
      this.height = paramInt2;
      this.rowSize = (paramInt1 + 31) / 32;
      this.bits = new int[this.rowSize * paramInt2];
      return;
    } 
    throw new IllegalArgumentException("Both dimensions must be greater than 0");
  }
  
  private BitMatrix(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint) {
    this.width = paramInt1;
    this.height = paramInt2;
    this.rowSize = paramInt3;
    this.bits = paramArrayOfint;
  }
  
  private String buildToString(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
    for (byte b = 0; b < this.height; b++) {
      for (byte b1 = 0; b1 < this.width; b1++) {
        String str;
        if (get(b1, b)) {
          str = paramString1;
        } else {
          str = paramString2;
        } 
        stringBuilder.append(str);
      } 
      stringBuilder.append(paramString3);
    } 
    return stringBuilder.toString();
  }
  
  public static BitMatrix parse(String paramString1, String paramString2, String paramString3) {
    if (paramString1 != null) {
      boolean[] arrayOfBoolean = new boolean[paramString1.length()];
      boolean bool = false;
      int i = 0;
      byte b1 = 0;
      byte b2 = 0;
      int j = -1;
      int k = 0;
      while (i < paramString1.length()) {
        if (paramString1.charAt(i) == '\n' || paramString1.charAt(i) == '\r') {
          byte b = b2;
          int n = j;
          int i1 = k;
          if (b1 > b2) {
            if (j == -1) {
              j = b1 - b2;
            } else if (b1 - b2 != j) {
              throw new IllegalArgumentException("row lengths do not match");
            } 
            i1 = k + 1;
            b = b1;
            n = j;
          } 
          i++;
          b2 = b;
          j = n;
          k = i1;
          continue;
        } 
        if (paramString1.substring(i, paramString2.length() + i).equals(paramString2)) {
          i += paramString2.length();
          arrayOfBoolean[b1] = true;
          b1++;
          continue;
        } 
        if (paramString1.substring(i, paramString3.length() + i).equals(paramString3)) {
          i += paramString3.length();
          arrayOfBoolean[b1] = false;
          b1++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder("illegal character encountered: ");
        stringBuilder.append(paramString1.substring(i));
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      i = j;
      int m = k;
      if (b1 > b2) {
        if (j == -1) {
          j = b1 - b2;
        } else if (b1 - b2 != j) {
          throw new IllegalArgumentException("row lengths do not match");
        } 
        m = k + 1;
        i = j;
      } 
      BitMatrix bitMatrix = new BitMatrix(i, m);
      for (j = bool; j < b1; j++) {
        if (arrayOfBoolean[j])
          bitMatrix.set(j % i, j / i); 
      } 
      return bitMatrix;
    } 
    throw new IllegalArgumentException();
  }
  
  public static BitMatrix parse(boolean[][] paramArrayOfboolean) {
    int i = paramArrayOfboolean.length;
    int j = (paramArrayOfboolean[0]).length;
    BitMatrix bitMatrix = new BitMatrix(j, i);
    for (byte b = 0; b < i; b++) {
      boolean[] arrayOfBoolean = paramArrayOfboolean[b];
      for (byte b1 = 0; b1 < j; b1++) {
        if (arrayOfBoolean[b1])
          bitMatrix.set(b1, b); 
      } 
    } 
    return bitMatrix;
  }
  
  public void clear() {
    int i = this.bits.length;
    for (byte b = 0; b < i; b++)
      this.bits[b] = 0; 
  }
  
  public BitMatrix clone() {
    return new BitMatrix(this.width, this.height, this.rowSize, (int[])this.bits.clone());
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof BitMatrix))
      return false; 
    paramObject = paramObject;
    return (this.width == ((BitMatrix)paramObject).width && this.height == ((BitMatrix)paramObject).height && this.rowSize == ((BitMatrix)paramObject).rowSize && Arrays.equals(this.bits, ((BitMatrix)paramObject).bits));
  }
  
  public void flip(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = 1 << (paramInt1 & 0x1F) ^ arrayOfInt[paramInt2];
  }
  
  public boolean get(int paramInt1, int paramInt2) {
    int i = this.rowSize;
    int j = paramInt1 / 32;
    return ((this.bits[paramInt2 * i + j] >>> (paramInt1 & 0x1F) & 0x1) != 0);
  }
  
  public int[] getBottomRightOnBit() {
    int i;
    for (i = this.bits.length - 1; i >= 0 && this.bits[i] == 0; i--);
    if (i < 0)
      return null; 
    int j = i / this.rowSize;
    int k = this.rowSize;
    int m = this.bits[i];
    byte b;
    for (b = 31; m >>> b == 0; b--);
    return new int[] { (i % k << 5) + b, j };
  }
  
  public int[] getEnclosingRectangle() {
    int i = this.width;
    int j = this.height;
    int k = -1;
    int m = -1;
    byte b = 0;
    while (b < this.height) {
      int n = m;
      m = k;
      byte b1 = 0;
      for (k = n; b1 < this.rowSize; k = i5) {
        int i1 = this.bits[this.rowSize * b + b1];
        int i2 = i;
        int i3 = m;
        int i4 = j;
        int i5 = k;
        if (i1 != 0) {
          n = j;
          if (b < j)
            n = b; 
          j = k;
          if (b > k)
            j = b; 
          int i6 = b1 << 5;
          byte b2 = 31;
          k = i;
          if (i6 < i) {
            for (k = 0; i1 << 31 - k == 0; k++);
            i5 = k + i6;
            k = i;
            if (i5 < i)
              k = i5; 
          } 
          i2 = k;
          i3 = m;
          i4 = n;
          i5 = j;
          if (i6 + 31 > m) {
            for (i = b2; i1 >>> i == 0; i--);
            i = i6 + i;
            i2 = k;
            i3 = m;
            i4 = n;
            i5 = j;
            if (i > m) {
              i3 = i;
              i5 = j;
              i4 = n;
              i2 = k;
            } 
          } 
        } 
        b1++;
        i = i2;
        m = i3;
        j = i4;
      } 
      b++;
      n = k;
      k = m;
      m = n;
    } 
    return (k < i || m < j) ? null : new int[] { i, j, k - i + 1, m - j + 1 };
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public BitArray getRow(int paramInt, BitArray paramBitArray) {
    if (paramBitArray == null || paramBitArray.getSize() < this.width) {
      paramBitArray = new BitArray(this.width);
    } else {
      paramBitArray.clear();
    } 
    int i = this.rowSize;
    for (byte b = 0; b < this.rowSize; b++)
      paramBitArray.setBulk(b << 5, this.bits[paramInt * i + b]); 
    return paramBitArray;
  }
  
  public int getRowSize() {
    return this.rowSize;
  }
  
  public int[] getTopLeftOnBit() {
    byte b1;
    for (b1 = 0; b1 < this.bits.length && this.bits[b1] == 0; b1++);
    if (b1 == this.bits.length)
      return null; 
    int i = b1 / this.rowSize;
    int j = this.rowSize;
    int k = this.bits[b1];
    byte b2;
    for (b2 = 0; k << 31 - b2 == 0; b2++);
    return new int[] { (b1 % j << 5) + b2, i };
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int hashCode() {
    return (((this.width * 31 + this.width) * 31 + this.height) * 31 + this.rowSize) * 31 + Arrays.hashCode(this.bits);
  }
  
  public void rotate180() {
    int i = getWidth();
    int j = getHeight();
    BitArray bitArray1 = new BitArray(i);
    BitArray bitArray2 = new BitArray(i);
    for (i = 0; i < (j + 1) / 2; i++) {
      bitArray1 = getRow(i, bitArray1);
      int k = j - 1 - i;
      bitArray2 = getRow(k, bitArray2);
      bitArray1.reverse();
      bitArray2.reverse();
      setRow(i, bitArray2);
      setRow(k, bitArray1);
    } 
  }
  
  public void set(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = 1 << (paramInt1 & 0x1F) | arrayOfInt[paramInt2];
  }
  
  public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt2 >= 0 && paramInt1 >= 0) {
      if (paramInt4 > 0 && paramInt3 > 0) {
        int i = paramInt3 + paramInt1;
        paramInt4 += paramInt2;
        if (paramInt4 <= this.height && i <= this.width) {
          while (paramInt2 < paramInt4) {
            int j = this.rowSize;
            for (paramInt3 = paramInt1; paramInt3 < i; paramInt3++) {
              int[] arrayOfInt = this.bits;
              int k = paramInt3 / 32 + j * paramInt2;
              arrayOfInt[k] = arrayOfInt[k] | 1 << (paramInt3 & 0x1F);
            } 
            paramInt2++;
          } 
          return;
        } 
        throw new IllegalArgumentException("The region must fit inside the matrix");
      } 
      throw new IllegalArgumentException("Height and width must be at least 1");
    } 
    throw new IllegalArgumentException("Left and top must be nonnegative");
  }
  
  public void setRow(int paramInt, BitArray paramBitArray) {
    System.arraycopy(paramBitArray.getBitArray(), 0, this.bits, paramInt * this.rowSize, this.rowSize);
  }
  
  public String toString() {
    return toString("X ", "  ");
  }
  
  public String toString(String paramString1, String paramString2) {
    return buildToString(paramString1, paramString2, "\n");
  }
  
  @Deprecated
  public String toString(String paramString1, String paramString2, String paramString3) {
    return buildToString(paramString1, paramString2, paramString3);
  }
  
  public void unset(int paramInt1, int paramInt2) {
    paramInt2 = paramInt2 * this.rowSize + paramInt1 / 32;
    int[] arrayOfInt = this.bits;
    arrayOfInt[paramInt2] = (1 << (paramInt1 & 0x1F) ^ 0xFFFFFFFF) & arrayOfInt[paramInt2];
  }
  
  public void xor(BitMatrix paramBitMatrix) {
    if (this.width == paramBitMatrix.getWidth() && this.height == paramBitMatrix.getHeight() && this.rowSize == paramBitMatrix.getRowSize()) {
      BitArray bitArray = new BitArray(this.width);
      for (byte b = 0; b < this.height; b++) {
        int i = this.rowSize;
        int[] arrayOfInt = paramBitMatrix.getRow(b, bitArray).getBitArray();
        for (byte b1 = 0; b1 < this.rowSize; b1++) {
          int[] arrayOfInt1 = this.bits;
          int j = i * b + b1;
          arrayOfInt1[j] = arrayOfInt1[j] ^ arrayOfInt[b1];
        } 
      } 
      return;
    } 
    throw new IllegalArgumentException("input matrix dimensions do not match");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\BitMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */