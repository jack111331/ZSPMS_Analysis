package com.google.zxing;

public final class RGBLuminanceSource extends LuminanceSource {
  private final int dataHeight;
  
  private final int dataWidth;
  
  private final int left;
  
  private final byte[] luminances;
  
  private final int top;
  
  public RGBLuminanceSource(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    super(paramInt1, paramInt2);
    this.dataWidth = paramInt1;
    this.dataHeight = paramInt2;
    int i = 0;
    this.left = 0;
    this.top = 0;
    paramInt2 = paramInt1 * paramInt2;
    this.luminances = new byte[paramInt2];
    for (paramInt1 = i; paramInt1 < paramInt2; paramInt1++) {
      i = paramArrayOfint[paramInt1];
      this.luminances[paramInt1] = (byte)(byte)(((i >> 16 & 0xFF) + (i >> 7 & 0x1FE) + (i & 0xFF)) / 4);
    } 
  }
  
  private RGBLuminanceSource(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    super(paramInt5, paramInt6);
    if (paramInt5 + paramInt3 <= paramInt1 && paramInt6 + paramInt4 <= paramInt2) {
      this.luminances = paramArrayOfbyte;
      this.dataWidth = paramInt1;
      this.dataHeight = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      return;
    } 
    throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + paramInt1, this.top + paramInt2, paramInt3, paramInt4);
  }
  
  public byte[] getMatrix() {
    int i = getWidth();
    int j = getHeight();
    if (i == this.dataWidth && j == this.dataHeight)
      return this.luminances; 
    int k = i * j;
    byte[] arrayOfByte = new byte[k];
    int m = this.top * this.dataWidth + this.left;
    int n = this.dataWidth;
    byte b = 0;
    int i1 = m;
    if (i == n) {
      System.arraycopy(this.luminances, m, arrayOfByte, 0, k);
      return arrayOfByte;
    } 
    while (b < j) {
      System.arraycopy(this.luminances, i1, arrayOfByte, b * i, i);
      i1 += this.dataWidth;
      b++;
    } 
    return arrayOfByte;
  }
  
  public byte[] getRow(int paramInt, byte[] paramArrayOfbyte) {
    int i;
    if (paramInt >= 0 && paramInt < getHeight()) {
      i = getWidth();
      if (paramArrayOfbyte != null) {
        byte[] arrayOfByte1 = paramArrayOfbyte;
        if (paramArrayOfbyte.length < i) {
          arrayOfByte1 = new byte[i];
          int i3 = this.top;
          int i4 = this.dataWidth;
          int i5 = this.left;
          System.arraycopy(this.luminances, (paramInt + i3) * i4 + i5, arrayOfByte1, 0, i);
          return arrayOfByte1;
        } 
        int n = this.top;
        int i1 = this.dataWidth;
        int i2 = this.left;
        System.arraycopy(this.luminances, (paramInt + n) * i1 + i2, arrayOfByte1, 0, i);
        return arrayOfByte1;
      } 
    } else {
      throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(paramInt)));
    } 
    byte[] arrayOfByte = new byte[i];
    int j = this.top;
    int k = this.dataWidth;
    int m = this.left;
    System.arraycopy(this.luminances, (paramInt + j) * k + m, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public boolean isCropSupported() {
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\RGBLuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */