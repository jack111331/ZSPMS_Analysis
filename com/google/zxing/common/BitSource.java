package com.google.zxing.common;

public final class BitSource {
  private int bitOffset;
  
  private int byteOffset;
  
  private final byte[] bytes;
  
  public BitSource(byte[] paramArrayOfbyte) {
    this.bytes = paramArrayOfbyte;
  }
  
  public int available() {
    return (this.bytes.length - this.byteOffset) * 8 - this.bitOffset;
  }
  
  public int getBitOffset() {
    return this.bitOffset;
  }
  
  public int getByteOffset() {
    return this.byteOffset;
  }
  
  public int readBits(int paramInt) {
    if (paramInt > 0 && paramInt <= 32 && paramInt <= available()) {
      int j;
      if (this.bitOffset > 0) {
        int k = 8 - this.bitOffset;
        if (paramInt < k) {
          j = paramInt;
        } else {
          j = k;
        } 
        k -= j;
        k = (255 >> 8 - j << k & this.bytes[this.byteOffset]) >> k;
        int m = paramInt - j;
        this.bitOffset += j;
        paramInt = k;
        j = m;
        if (this.bitOffset == 8) {
          this.bitOffset = 0;
          this.byteOffset++;
          paramInt = k;
          j = m;
        } 
      } else {
        boolean bool = false;
        j = paramInt;
        paramInt = bool;
      } 
      int i = paramInt;
      if (j > 0) {
        while (j >= 8) {
          paramInt = paramInt << 8 | this.bytes[this.byteOffset] & 0xFF;
          this.byteOffset++;
          j -= 8;
        } 
        i = paramInt;
        if (j > 0) {
          i = 8 - j;
          i = paramInt << j | (255 >> i << i & this.bytes[this.byteOffset]) >> i;
          this.bitOffset += j;
        } 
      } 
      return i;
    } 
    throw new IllegalArgumentException(String.valueOf(paramInt));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\BitSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */