package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

class DetectionResultColumn {
  private static final int MAX_NEARBY_DISTANCE = 5;
  
  private final BoundingBox boundingBox;
  
  private final Codeword[] codewords;
  
  DetectionResultColumn(BoundingBox paramBoundingBox) {
    this.boundingBox = new BoundingBox(paramBoundingBox);
    this.codewords = new Codeword[paramBoundingBox.getMaxY() - paramBoundingBox.getMinY() + 1];
  }
  
  final BoundingBox getBoundingBox() {
    return this.boundingBox;
  }
  
  final Codeword getCodeword(int paramInt) {
    return this.codewords[imageRowToCodewordIndex(paramInt)];
  }
  
  final Codeword getCodewordNearby(int paramInt) {
    Codeword codeword = getCodeword(paramInt);
    if (codeword != null)
      return codeword; 
    for (byte b = 1; b < 5; b++) {
      int i = imageRowToCodewordIndex(paramInt) - b;
      if (i >= 0) {
        codeword = this.codewords[i];
        if (codeword != null)
          return codeword; 
      } 
      i = imageRowToCodewordIndex(paramInt) + b;
      if (i < this.codewords.length) {
        codeword = this.codewords[i];
        if (codeword != null)
          return codeword; 
      } 
    } 
    return null;
  }
  
  final Codeword[] getCodewords() {
    return this.codewords;
  }
  
  final int imageRowToCodewordIndex(int paramInt) {
    return paramInt - this.boundingBox.getMinY();
  }
  
  final void setCodeword(int paramInt, Codeword paramCodeword) {
    this.codewords[imageRowToCodewordIndex(paramInt)] = paramCodeword;
  }
  
  public String toString() {
    Throwable throwable2;
    Formatter formatter = new Formatter();
    String str1 = null;
    String str2 = str1;
    try {
      Codeword[] arrayOfCodeword = this.codewords;
      str2 = str1;
      int i = arrayOfCodeword.length;
      byte b1 = 0;
      byte b2 = 0;
      while (b1 < i) {
        Codeword codeword = arrayOfCodeword[b1];
        if (codeword == null) {
          str2 = str1;
          formatter.format("%3d:    |   %n", new Object[] { Integer.valueOf(b2) });
          b2++;
        } else {
          str2 = str1;
          formatter.format("%3d: %3d|%3d%n", new Object[] { Integer.valueOf(b2), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()) });
          b2++;
        } 
        b1++;
      } 
      str2 = str1;
      str1 = formatter.toString();
      formatter.close();
      return str1;
    } catch (Throwable throwable) {
      throwable2 = throwable;
      throw throwable;
    } finally {}
    if (throwable2 != null) {
      try {
        formatter.close();
      } catch (Throwable throwable1) {
        throwable2.addSuppressed(throwable1);
      } 
    } else {
      throwable1.close();
    } 
    throw str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResultColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */