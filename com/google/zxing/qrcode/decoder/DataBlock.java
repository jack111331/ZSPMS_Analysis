package com.google.zxing.qrcode.decoder;

final class DataBlock {
  private final byte[] codewords;
  
  private final int numDataCodewords;
  
  private DataBlock(int paramInt, byte[] paramArrayOfbyte) {
    this.numDataCodewords = paramInt;
    this.codewords = paramArrayOfbyte;
  }
  
  static DataBlock[] getDataBlocks(byte[] paramArrayOfbyte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel) {
    if (paramArrayOfbyte.length == paramVersion.getTotalCodewords()) {
      Version.ECBlocks eCBlocks = paramVersion.getECBlocksForLevel(paramErrorCorrectionLevel);
      Version.ECB[] arrayOfECB = eCBlocks.getECBlocks();
      int i = arrayOfECB.length;
      int j = 0;
      int k = 0;
      while (j < i) {
        k += arrayOfECB[j].getCount();
        j++;
      } 
      DataBlock[] arrayOfDataBlock = new DataBlock[k];
      int m = arrayOfECB.length;
      i = 0;
      for (k = 0; i < m; k = j) {
        Version.ECB eCB = arrayOfECB[i];
        j = k;
        k = 0;
        while (k < eCB.getCount()) {
          int i3 = eCB.getDataCodewords();
          arrayOfDataBlock[j] = new DataBlock(i3, new byte[eCBlocks.getECCodewordsPerBlock() + i3]);
          k++;
          j++;
        } 
        i++;
      } 
      i = (arrayOfDataBlock[0]).codewords.length;
      for (j = arrayOfDataBlock.length - 1; j >= 0 && (arrayOfDataBlock[j]).codewords.length != i; j--);
      int i1 = j + 1;
      int n = i - eCBlocks.getECCodewordsPerBlock();
      i = 0;
      j = 0;
      while (i < n) {
        m = 0;
        while (m < k) {
          (arrayOfDataBlock[m]).codewords[i] = (byte)paramArrayOfbyte[j];
          m++;
          j++;
        } 
        i++;
      } 
      m = i1;
      for (i = j; m < k; i++) {
        (arrayOfDataBlock[m]).codewords[n] = (byte)paramArrayOfbyte[i];
        m++;
      } 
      int i2 = (arrayOfDataBlock[0]).codewords.length;
      for (j = n; j < i2; j++) {
        m = 0;
        while (m < k) {
          if (m < i1) {
            n = j;
          } else {
            n = j + 1;
          } 
          (arrayOfDataBlock[m]).codewords[n] = (byte)paramArrayOfbyte[i];
          m++;
          i++;
        } 
      } 
      return arrayOfDataBlock;
    } 
    throw new IllegalArgumentException();
  }
  
  byte[] getCodewords() {
    return this.codewords;
  }
  
  int getNumDataCodewords() {
    return this.numDataCodewords;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\DataBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */