package com.google.zxing.common;

import java.util.Arrays;

public final class BitArray implements Cloneable {
  private int[] bits;
  
  private int size;
  
  public BitArray() {
    this.size = 0;
    this.bits = new int[1];
  }
  
  public BitArray(int paramInt) {
    this.size = paramInt;
    this.bits = makeArray(paramInt);
  }
  
  BitArray(int[] paramArrayOfint, int paramInt) {
    this.bits = paramArrayOfint;
    this.size = paramInt;
  }
  
  private void ensureCapacity(int paramInt) {
    if (paramInt > this.bits.length << 5) {
      int[] arrayOfInt = makeArray(paramInt);
      System.arraycopy(this.bits, 0, arrayOfInt, 0, this.bits.length);
      this.bits = arrayOfInt;
    } 
  }
  
  private static int[] makeArray(int paramInt) {
    return new int[(paramInt + 31) / 32];
  }
  
  public void appendBit(boolean paramBoolean) {
    ensureCapacity(this.size + 1);
    if (paramBoolean) {
      int[] arrayOfInt = this.bits;
      int i = this.size / 32;
      arrayOfInt[i] = arrayOfInt[i] | 1 << (this.size & 0x1F);
    } 
    this.size++;
  }
  
  public void appendBitArray(BitArray paramBitArray) {
    int i = paramBitArray.size;
    ensureCapacity(this.size + i);
    for (byte b = 0; b < i; b++)
      appendBit(paramBitArray.get(b)); 
  }
  
  public void appendBits(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0 && paramInt2 <= 32) {
      ensureCapacity(this.size + paramInt2);
      while (paramInt2 > 0) {
        boolean bool = true;
        if ((paramInt1 >> paramInt2 - 1 & 0x1) != 1)
          bool = false; 
        appendBit(bool);
        paramInt2--;
      } 
      return;
    } 
    throw new IllegalArgumentException("Num bits must be between 0 and 32");
  }
  
  public void clear() {
    int i = this.bits.length;
    for (byte b = 0; b < i; b++)
      this.bits[b] = 0; 
  }
  
  public BitArray clone() {
    return new BitArray((int[])this.bits.clone(), this.size);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof BitArray))
      return false; 
    paramObject = paramObject;
    return (this.size == ((BitArray)paramObject).size && Arrays.equals(this.bits, ((BitArray)paramObject).bits));
  }
  
  public void flip(int paramInt) {
    int[] arrayOfInt = this.bits;
    int i = paramInt / 32;
    arrayOfInt[i] = 1 << (paramInt & 0x1F) ^ arrayOfInt[i];
  }
  
  public boolean get(int paramInt) {
    return ((1 << (paramInt & 0x1F) & this.bits[paramInt / 32]) != 0);
  }
  
  public int[] getBitArray() {
    return this.bits;
  }
  
  public int getNextSet(int paramInt) {
    if (paramInt >= this.size)
      return this.size; 
    int i = paramInt / 32;
    for (paramInt = ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF) & this.bits[i]; paramInt == 0; paramInt = this.bits[i]) {
      if (++i == this.bits.length)
        return this.size; 
    } 
    paramInt = (i << 5) + Integer.numberOfTrailingZeros(paramInt);
    return (paramInt > this.size) ? this.size : paramInt;
  }
  
  public int getNextUnset(int paramInt) {
    if (paramInt >= this.size)
      return this.size; 
    int i = paramInt / 32;
    for (paramInt = ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF) & (this.bits[i] ^ 0xFFFFFFFF); paramInt == 0; paramInt = this.bits[i] ^ 0xFFFFFFFF) {
      if (++i == this.bits.length)
        return this.size; 
    } 
    paramInt = (i << 5) + Integer.numberOfTrailingZeros(paramInt);
    return (paramInt > this.size) ? this.size : paramInt;
  }
  
  public int getSize() {
    return this.size;
  }
  
  public int getSizeInBytes() {
    return (this.size + 7) / 8;
  }
  
  public int hashCode() {
    return this.size * 31 + Arrays.hashCode(this.bits);
  }
  
  public boolean isRange(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramInt2 >= paramInt1 && paramInt1 >= 0 && paramInt2 <= this.size) {
      if (paramInt2 == paramInt1)
        return true; 
      int i = paramInt2 - 1;
      int j = paramInt1 / 32;
      int k = i / 32;
      for (int m = j; m <= k; m++) {
        int n = 31;
        if (m > j) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramInt1 & 0x1F;
        } 
        if (m >= k)
          n = 0x1F & i; 
        n = (2 << n) - (1 << paramInt2);
        int i1 = this.bits[m];
        if (paramBoolean) {
          paramInt2 = n;
        } else {
          paramInt2 = 0;
        } 
        if ((i1 & n) != paramInt2)
          return false; 
      } 
      return true;
    } 
    throw new IllegalArgumentException();
  }
  
  public void reverse() {
    int[] arrayOfInt = new int[this.bits.length];
    int i = (this.size - 1) / 32;
    int j = i + 1;
    int k;
    for (k = 0; k < j; k++) {
      long l = this.bits[k];
      l = (l & 0x55555555L) << 1L | l >> 1L & 0x55555555L;
      l = (l & 0x33333333L) << 2L | l >> 2L & 0x33333333L;
      l = (l & 0xF0F0F0FL) << 4L | l >> 4L & 0xF0F0F0FL;
      l = (l & 0xFF00FFL) << 8L | l >> 8L & 0xFF00FFL;
      arrayOfInt[i - k] = (int)((l & 0xFFFFL) << 16L | l >> 16L & 0xFFFFL);
    } 
    i = this.size;
    k = j << 5;
    if (i != k) {
      int m = k - this.size;
      k = arrayOfInt[0] >>> m;
      for (i = 1; i < j; i++) {
        int n = arrayOfInt[i];
        arrayOfInt[i - 1] = k | n << 32 - m;
        k = n >>> m;
      } 
      arrayOfInt[j - 1] = k;
    } 
    this.bits = arrayOfInt;
  }
  
  public void set(int paramInt) {
    int[] arrayOfInt = this.bits;
    int i = paramInt / 32;
    arrayOfInt[i] = 1 << (paramInt & 0x1F) | arrayOfInt[i];
  }
  
  public void setBulk(int paramInt1, int paramInt2) {
    this.bits[paramInt1 / 32] = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2) {
    if (paramInt2 >= paramInt1 && paramInt1 >= 0 && paramInt2 <= this.size) {
      if (paramInt2 == paramInt1)
        return; 
      int i = paramInt2 - 1;
      int j = paramInt1 / 32;
      int k = i / 32;
      for (paramInt2 = j; paramInt2 <= k; paramInt2++) {
        int n;
        int m = 31;
        if (paramInt2 > j) {
          n = 0;
        } else {
          n = paramInt1 & 0x1F;
        } 
        if (paramInt2 >= k)
          m = 0x1F & i; 
        int[] arrayOfInt = this.bits;
        arrayOfInt[paramInt2] = (2 << m) - (1 << n) | arrayOfInt[paramInt2];
      } 
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public void toBytes(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    for (byte b = 0; b < paramInt3; b++) {
      byte b1 = 0;
      int i;
      for (i = 0; b1 < 8; i = j) {
        int j = i;
        if (get(paramInt1))
          j = i | 1 << 7 - b1; 
        paramInt1++;
        b1++;
      } 
      paramArrayOfbyte[paramInt2 + b] = (byte)(byte)i;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(this.size + this.size / 8 + 1);
    for (byte b = 0; b < this.size; b++) {
      byte b1;
      if ((b & 0x7) == 0)
        stringBuilder.append(' '); 
      if (get(b)) {
        byte b2 = 88;
        b1 = b2;
      } else {
        byte b2 = 46;
        b1 = b2;
      } 
      stringBuilder.append(b1);
    } 
    return stringBuilder.toString();
  }
  
  public void xor(BitArray paramBitArray) {
    if (this.size == paramBitArray.size) {
      for (byte b = 0; b < this.bits.length; b++) {
        int[] arrayOfInt = this.bits;
        arrayOfInt[b] = arrayOfInt[b] ^ paramBitArray.bits[b];
      } 
      return;
    } 
    throw new IllegalArgumentException("Sizes don't match");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\BitArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */