package com.google.zxing.qrcode.encoder;

import java.util.Arrays;

public final class ByteMatrix {
  private final byte[][] bytes;
  
  private final int height;
  
  private final int width;
  
  public ByteMatrix(int paramInt1, int paramInt2) {
    this.bytes = new byte[paramInt2][paramInt1];
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void clear(byte paramByte) {
    byte[][] arrayOfByte = this.bytes;
    int i = arrayOfByte.length;
    for (byte b = 0; b < i; b++)
      Arrays.fill(arrayOfByte[b], paramByte); 
  }
  
  public byte get(int paramInt1, int paramInt2) {
    return this.bytes[paramInt2][paramInt1];
  }
  
  public byte[][] getArray() {
    return this.bytes;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public void set(int paramInt1, int paramInt2, byte paramByte) {
    this.bytes[paramInt2][paramInt1] = (byte)paramByte;
  }
  
  public void set(int paramInt1, int paramInt2, int paramInt3) {
    this.bytes[paramInt2][paramInt1] = (byte)(byte)paramInt3;
  }
  
  public void set(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.bytes[paramInt2][paramInt1] = (byte)(byte)paramBoolean;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(this.width * 2 * this.height + 2);
    for (byte b = 0; b < this.height; b++) {
      byte[] arrayOfByte = this.bytes[b];
      for (byte b1 = 0; b1 < this.width; b1++) {
        switch (arrayOfByte[b1]) {
          default:
            stringBuilder.append("  ");
            break;
          case 1:
            stringBuilder.append(" 1");
            break;
          case 0:
            stringBuilder.append(" 0");
            break;
        } 
      } 
      stringBuilder.append('\n');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\encoder\ByteMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */