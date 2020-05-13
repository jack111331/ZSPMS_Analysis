package com.google.zxing;

public abstract class LuminanceSource {
  private final int height;
  
  private final int width;
  
  protected LuminanceSource(int paramInt1, int paramInt2) {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    throw new UnsupportedOperationException("This luminance source does not support cropping.");
  }
  
  public final int getHeight() {
    return this.height;
  }
  
  public abstract byte[] getMatrix();
  
  public abstract byte[] getRow(int paramInt, byte[] paramArrayOfbyte);
  
  public final int getWidth() {
    return this.width;
  }
  
  public LuminanceSource invert() {
    return new InvertedLuminanceSource(this);
  }
  
  public boolean isCropSupported() {
    return false;
  }
  
  public boolean isRotateSupported() {
    return false;
  }
  
  public LuminanceSource rotateCounterClockwise() {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
  }
  
  public LuminanceSource rotateCounterClockwise45() {
    throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
  }
  
  public final String toString() {
    byte[] arrayOfByte = new byte[this.width];
    StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
    for (byte b = 0; b < this.height; b++) {
      arrayOfByte = getRow(b, arrayOfByte);
      for (byte b1 = 0; b1 < this.width; b1++) {
        int j;
        int i = arrayOfByte[b1] & 0xFF;
        if (i < 64) {
          i = 35;
          j = i;
        } else if (i < 128) {
          i = 43;
          j = i;
        } else if (i < 192) {
          i = 46;
          j = i;
        } else {
          i = 32;
          j = i;
        } 
        stringBuilder.append(j);
      } 
      stringBuilder.append('\n');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\LuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */