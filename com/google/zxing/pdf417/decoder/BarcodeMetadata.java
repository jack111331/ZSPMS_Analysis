package com.google.zxing.pdf417.decoder;

final class BarcodeMetadata {
  private final int columnCount;
  
  private final int errorCorrectionLevel;
  
  private final int rowCount;
  
  private final int rowCountLowerPart;
  
  private final int rowCountUpperPart;
  
  BarcodeMetadata(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.columnCount = paramInt1;
    this.errorCorrectionLevel = paramInt4;
    this.rowCountUpperPart = paramInt2;
    this.rowCountLowerPart = paramInt3;
    this.rowCount = paramInt2 + paramInt3;
  }
  
  int getColumnCount() {
    return this.columnCount;
  }
  
  int getErrorCorrectionLevel() {
    return this.errorCorrectionLevel;
  }
  
  int getRowCount() {
    return this.rowCount;
  }
  
  int getRowCountLowerPart() {
    return this.rowCountLowerPart;
  }
  
  int getRowCountUpperPart() {
    return this.rowCountUpperPart;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\BarcodeMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */