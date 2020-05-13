package com.google.zxing.datamatrix.decoder;

final class DataBlock {
  private final byte[] codewords;
  
  private final int numDataCodewords;
  
  private DataBlock(int paramInt, byte[] paramArrayOfbyte) {
    this.numDataCodewords = paramInt;
    this.codewords = paramArrayOfbyte;
  }
  
  static DataBlock[] getDataBlocks(byte[] paramArrayOfbyte, Version paramVersion) {
    Version.ECBlocks eCBlocks = paramVersion.getECBlocks();
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
    j = 0;
    k = 0;
    while (j < m) {
      Version.ECB eCB = arrayOfECB[j];
      i = 0;
      while (i < eCB.getCount()) {
        int i4 = eCB.getDataCodewords();
        arrayOfDataBlock[k] = new DataBlock(i4, new byte[eCBlocks.getECCodewords() + i4]);
        i++;
        k++;
      } 
      j++;
    } 
    int i1 = (arrayOfDataBlock[0]).codewords.length - eCBlocks.getECCodewords();
    int i2 = i1 - 1;
    i = 0;
    j = 0;
    while (i < i2) {
      m = 0;
      while (m < k) {
        (arrayOfDataBlock[m]).codewords[i] = (byte)paramArrayOfbyte[j];
        m++;
        j++;
      } 
      i++;
    } 
    if (paramVersion.getVersionNumber() == 24) {
      m = 1;
    } else {
      m = 0;
    } 
    if (m != 0) {
      i = 8;
    } else {
      i = k;
    } 
    int n = 0;
    while (n < i) {
      (arrayOfDataBlock[n]).codewords[i2] = (byte)paramArrayOfbyte[j];
      n++;
      j++;
    } 
    int i3 = (arrayOfDataBlock[0]).codewords.length;
    n = j;
    for (j = i1; j < i3; j++) {
      i = 0;
      while (i < k) {
        if (m != 0) {
          i1 = (i + 8) % k;
        } else {
          i1 = i;
        } 
        if (m != 0 && i1 > 7) {
          i2 = j - 1;
        } else {
          i2 = j;
        } 
        (arrayOfDataBlock[i1]).codewords[i2] = (byte)paramArrayOfbyte[n];
        i++;
        n++;
      } 
    } 
    if (n == paramArrayOfbyte.length)
      return arrayOfDataBlock; 
    throw new IllegalArgumentException();
  }
  
  byte[] getCodewords() {
    return this.codewords;
  }
  
  int getNumDataCodewords() {
    return this.numDataCodewords;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\decoder\DataBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */