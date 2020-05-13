package com.google.zxing;

public final class InvertedLuminanceSource extends LuminanceSource {
  private final LuminanceSource delegate;
  
  public InvertedLuminanceSource(LuminanceSource paramLuminanceSource) {
    super(paramLuminanceSource.getWidth(), paramLuminanceSource.getHeight());
    this.delegate = paramLuminanceSource;
  }
  
  public LuminanceSource crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new InvertedLuminanceSource(this.delegate.crop(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public byte[] getMatrix() {
    byte[] arrayOfByte1 = this.delegate.getMatrix();
    int i = getWidth() * getHeight();
    byte[] arrayOfByte2 = new byte[i];
    for (byte b = 0; b < i; b++)
      arrayOfByte2[b] = (byte)(byte)(255 - (arrayOfByte1[b] & 0xFF)); 
    return arrayOfByte2;
  }
  
  public byte[] getRow(int paramInt, byte[] paramArrayOfbyte) {
    paramArrayOfbyte = this.delegate.getRow(paramInt, paramArrayOfbyte);
    int i = getWidth();
    for (paramInt = 0; paramInt < i; paramInt++)
      paramArrayOfbyte[paramInt] = (byte)(byte)(255 - (paramArrayOfbyte[paramInt] & 0xFF)); 
    return paramArrayOfbyte;
  }
  
  public LuminanceSource invert() {
    return this.delegate;
  }
  
  public boolean isCropSupported() {
    return this.delegate.isCropSupported();
  }
  
  public boolean isRotateSupported() {
    return this.delegate.isRotateSupported();
  }
  
  public LuminanceSource rotateCounterClockwise() {
    return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
  }
  
  public LuminanceSource rotateCounterClockwise45() {
    return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\InvertedLuminanceSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */