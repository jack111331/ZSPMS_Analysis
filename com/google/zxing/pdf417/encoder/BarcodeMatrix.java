package com.google.zxing.pdf417.encoder;

public final class BarcodeMatrix {
  private int currentRow;
  
  private final int height;
  
  private final BarcodeRow[] matrix;
  
  private final int width;
  
  BarcodeMatrix(int paramInt1, int paramInt2) {
    this.matrix = new BarcodeRow[paramInt1];
    int i = this.matrix.length;
    for (byte b = 0; b < i; b++)
      this.matrix[b] = new BarcodeRow((paramInt2 + 4) * 17 + 1); 
    this.width = paramInt2 * 17;
    this.height = paramInt1;
    this.currentRow = -1;
  }
  
  BarcodeRow getCurrentRow() {
    return this.matrix[this.currentRow];
  }
  
  public byte[][] getMatrix() {
    return getScaledMatrix(1, 1);
  }
  
  public byte[][] getScaledMatrix(int paramInt1, int paramInt2) {
    byte[][] arrayOfByte = new byte[this.height * paramInt2][this.width * paramInt1];
    int i = this.height * paramInt2;
    for (byte b = 0; b < i; b++)
      arrayOfByte[i - b - 1] = this.matrix[b / paramInt2].getScaledRow(paramInt1); 
    return arrayOfByte;
  }
  
  void set(int paramInt1, int paramInt2, byte paramByte) {
    this.matrix[paramInt2].set(paramInt1, paramByte);
  }
  
  void startRow() {
    this.currentRow++;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\encoder\BarcodeMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */