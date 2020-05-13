package com.google.zxing.pdf417.encoder;

final class BarcodeRow {
  private int currentLocation;
  
  private final byte[] row;
  
  BarcodeRow(int paramInt) {
    this.row = new byte[paramInt];
    this.currentLocation = 0;
  }
  
  private void set(int paramInt, boolean paramBoolean) {
    this.row[paramInt] = (byte)(byte)paramBoolean;
  }
  
  void addBar(boolean paramBoolean, int paramInt) {
    for (byte b = 0; b < paramInt; b++) {
      int i = this.currentLocation;
      this.currentLocation = i + 1;
      set(i, paramBoolean);
    } 
  }
  
  byte[] getScaledRow(int paramInt) {
    byte[] arrayOfByte = new byte[this.row.length * paramInt];
    for (byte b = 0; b < arrayOfByte.length; b++)
      arrayOfByte[b] = (byte)this.row[b / paramInt]; 
    return arrayOfByte;
  }
  
  void set(int paramInt, byte paramByte) {
    this.row[paramInt] = (byte)paramByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\encoder\BarcodeRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */