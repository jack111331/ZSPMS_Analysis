package com.google.zxing.datamatrix.encoder;

final class DataMatrixSymbolInfo144 extends SymbolInfo {
  DataMatrixSymbolInfo144() {
    super(false, 1558, 620, 22, 22, 36, -1, 62);
  }
  
  public int getDataLengthForInterleavedBlock(int paramInt) {
    return (paramInt <= 8) ? 156 : 155;
  }
  
  public int getInterleavedBlockCount() {
    return 10;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\DataMatrixSymbolInfo144.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */