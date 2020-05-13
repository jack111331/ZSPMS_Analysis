package com.google.zxing;

public final class PlanarYUVLuminanceSource extends LuminanceSource {
  private static final int THUMBNAIL_SCALE_FACTOR = 2;
  
  private final int dataHeight;
  
  private final int dataWidth;
  
  private final int left;
  
  private final int top;
  
  private final byte[] yuvData;
  
  public PlanarYUVLuminanceSource(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
    super(paramInt5, paramInt6);
    if (paramInt3 + paramInt5 <= paramInt1 && paramInt4 + paramInt6 <= paramInt2) {
      this.yuvData = paramArrayOfbyte;
      this.dataWidth = paramInt1;
      this.dataHeight = paramInt2;
      this.left = paramInt3;
      this.top = paramInt4;
      if (paramBoolean)
        reverseHorizontal(paramInt5, paramInt6); 
      return;
    } 
    throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
  }
  
  private void reverseHorizontal(int paramInt1, int paramInt2) {
    byte[] arrayOfByte = this.yuvData;
    int i = this.top * this.dataWidth + this.left;
    byte b = 0;
    while (b < paramInt2) {
      int j = paramInt1 / 2;
      int k = i + paramInt1 - 1;
      int m = i;
      while (m < j + i) {
        byte b1 = arrayOfByte[m];
        arrayOfByte[m] = (byte)arrayOfByte[k];
        arrayOfByte[k] = (byte)b1;
        m++;
        k--;
      } 
      b++;
      i += this.dataWidth;
    } 
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + paramInt1, this.top + paramInt2, paramInt3, paramInt4, false);
  }
  
  public byte[] getMatrix() {
    int i = getWidth();
    int j = getHeight();
    if (i == this.dataWidth && j == this.dataHeight)
      return this.yuvData; 
    int k = i * j;
    byte[] arrayOfByte = new byte[k];
    int m = this.top * this.dataWidth + this.left;
    int n = this.dataWidth;
    byte b = 0;
    int i1 = m;
    if (i == n) {
      System.arraycopy(this.yuvData, m, arrayOfByte, 0, k);
      return arrayOfByte;
    } 
    while (b < j) {
      System.arraycopy(this.yuvData, i1, arrayOfByte, b * i, i);
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
          System.arraycopy(this.yuvData, (paramInt + i3) * i4 + i5, arrayOfByte1, 0, i);
          return arrayOfByte1;
        } 
        int n = this.top;
        int i1 = this.dataWidth;
        int i2 = this.left;
        System.arraycopy(this.yuvData, (paramInt + n) * i1 + i2, arrayOfByte1, 0, i);
        return arrayOfByte1;
      } 
    } else {
      throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(paramInt)));
    } 
    byte[] arrayOfByte = new byte[i];
    int j = this.top;
    int k = this.dataWidth;
    int m = this.left;
    System.arraycopy(this.yuvData, (paramInt + j) * k + m, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public int getThumbnailHeight() {
    return getHeight() / 2;
  }
  
  public int getThumbnailWidth() {
    return getWidth() / 2;
  }
  
  public boolean isCropSupported() {
    return true;
  }
  
  public int[] renderThumbnail() {
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    int[] arrayOfInt = new int[i * j];
    byte[] arrayOfByte = this.yuvData;
    int k = this.top * this.dataWidth + this.left;
    for (byte b = 0; b < j; b++) {
      for (byte b1 = 0; b1 < i; b1++)
        arrayOfInt[b * i + b1] = (arrayOfByte[(b1 << 1) + k] & 0xFF) * 65793 | 0xFF000000; 
      k += this.dataWidth << 1;
    } 
    return arrayOfInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\PlanarYUVLuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */