package com.google.zxing.pdf417.decoder;

final class Codeword {
  private static final int BARCODE_ROW_UNKNOWN = -1;
  
  private final int bucket;
  
  private final int endX;
  
  private int rowNumber = -1;
  
  private final int startX;
  
  private final int value;
  
  Codeword(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.startX = paramInt1;
    this.endX = paramInt2;
    this.bucket = paramInt3;
    this.value = paramInt4;
  }
  
  int getBucket() {
    return this.bucket;
  }
  
  int getEndX() {
    return this.endX;
  }
  
  int getRowNumber() {
    return this.rowNumber;
  }
  
  int getStartX() {
    return this.startX;
  }
  
  int getValue() {
    return this.value;
  }
  
  int getWidth() {
    return this.endX - this.startX;
  }
  
  boolean hasValidRowNumber() {
    return isValidRowNumber(this.rowNumber);
  }
  
  boolean isValidRowNumber(int paramInt) {
    return (paramInt != -1 && this.bucket == paramInt % 3 * 3);
  }
  
  void setRowNumber(int paramInt) {
    this.rowNumber = paramInt;
  }
  
  void setRowNumberAsRowIndicatorColumn() {
    this.rowNumber = this.value / 30 * 3 + this.bucket / 3;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.rowNumber);
    stringBuilder.append("|");
    stringBuilder.append(this.value);
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\Codeword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */