package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

final class DetectionResult {
  private static final int ADJUST_ROW_NUMBER_SKIP = 2;
  
  private final int barcodeColumnCount;
  
  private final BarcodeMetadata barcodeMetadata;
  
  private BoundingBox boundingBox;
  
  private final DetectionResultColumn[] detectionResultColumns;
  
  DetectionResult(BarcodeMetadata paramBarcodeMetadata, BoundingBox paramBoundingBox) {
    this.barcodeMetadata = paramBarcodeMetadata;
    this.barcodeColumnCount = paramBarcodeMetadata.getColumnCount();
    this.boundingBox = paramBoundingBox;
    this.detectionResultColumns = new DetectionResultColumn[this.barcodeColumnCount + 2];
  }
  
  private void adjustIndicatorColumnRowNumbers(DetectionResultColumn paramDetectionResultColumn) {
    if (paramDetectionResultColumn != null)
      ((DetectionResultRowIndicatorColumn)paramDetectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata); 
  }
  
  private static boolean adjustRowNumber(Codeword paramCodeword1, Codeword paramCodeword2) {
    if (paramCodeword2 == null)
      return false; 
    if (paramCodeword2.hasValidRowNumber() && paramCodeword2.getBucket() == paramCodeword1.getBucket()) {
      paramCodeword1.setRowNumber(paramCodeword2.getRowNumber());
      return true;
    } 
    return false;
  }
  
  private static int adjustRowNumberIfValid(int paramInt1, int paramInt2, Codeword paramCodeword) {
    if (paramCodeword == null)
      return paramInt2; 
    int i = paramInt2;
    if (!paramCodeword.hasValidRowNumber())
      if (paramCodeword.isValidRowNumber(paramInt1)) {
        paramCodeword.setRowNumber(paramInt1);
        i = 0;
      } else {
        i = paramInt2 + 1;
      }  
    return i;
  }
  
  private int adjustRowNumbers() {
    int i = adjustRowNumbersByRow();
    if (i == 0)
      return 0; 
    for (byte b = 1; b < this.barcodeColumnCount + 1; b++) {
      Codeword[] arrayOfCodeword = this.detectionResultColumns[b].getCodewords();
      for (byte b1 = 0; b1 < arrayOfCodeword.length; b1++) {
        if (arrayOfCodeword[b1] != null && !arrayOfCodeword[b1].hasValidRowNumber())
          adjustRowNumbers(b, b1, arrayOfCodeword); 
      } 
    } 
    return i;
  }
  
  private void adjustRowNumbers(int paramInt1, int paramInt2, Codeword[] paramArrayOfCodeword) {
    Codeword[] arrayOfCodeword2;
    Codeword codeword = paramArrayOfCodeword[paramInt2];
    Codeword[] arrayOfCodeword1 = this.detectionResultColumns[paramInt1 - 1].getCodewords();
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.detectionResultColumns;
    if (arrayOfDetectionResultColumn[++paramInt1] != null) {
      arrayOfCodeword2 = this.detectionResultColumns[paramInt1].getCodewords();
    } else {
      arrayOfCodeword2 = arrayOfCodeword1;
    } 
    Codeword[] arrayOfCodeword3 = new Codeword[14];
    arrayOfCodeword3[2] = arrayOfCodeword1[paramInt2];
    arrayOfCodeword3[3] = arrayOfCodeword2[paramInt2];
    boolean bool = false;
    if (paramInt2 > 0) {
      paramInt1 = paramInt2 - 1;
      arrayOfCodeword3[0] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[4] = arrayOfCodeword1[paramInt1];
      arrayOfCodeword3[5] = arrayOfCodeword2[paramInt1];
    } 
    if (paramInt2 > 1) {
      paramInt1 = paramInt2 - 2;
      arrayOfCodeword3[8] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[10] = arrayOfCodeword1[paramInt1];
      arrayOfCodeword3[11] = arrayOfCodeword2[paramInt1];
    } 
    if (paramInt2 < paramArrayOfCodeword.length - 1) {
      paramInt1 = paramInt2 + 1;
      arrayOfCodeword3[1] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[6] = arrayOfCodeword1[paramInt1];
      arrayOfCodeword3[7] = arrayOfCodeword2[paramInt1];
    } 
    paramInt1 = bool;
    if (paramInt2 < paramArrayOfCodeword.length - 2) {
      paramInt1 = paramInt2 + 2;
      arrayOfCodeword3[9] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[12] = arrayOfCodeword1[paramInt1];
      arrayOfCodeword3[13] = arrayOfCodeword2[paramInt1];
      paramInt1 = bool;
    } 
    while (paramInt1 < 14) {
      if (adjustRowNumber(codeword, arrayOfCodeword3[paramInt1]))
        return; 
      paramInt1++;
    } 
  }
  
  private int adjustRowNumbersByRow() {
    adjustRowNumbersFromBothRI();
    return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
  }
  
  private void adjustRowNumbersFromBothRI() {
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.detectionResultColumns;
    byte b = 0;
    if (arrayOfDetectionResultColumn[0] == null || this.detectionResultColumns[this.barcodeColumnCount + 1] == null)
      return; 
    Codeword[] arrayOfCodeword1 = this.detectionResultColumns[0].getCodewords();
    Codeword[] arrayOfCodeword2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
    while (b < arrayOfCodeword1.length) {
      if (arrayOfCodeword1[b] != null && arrayOfCodeword2[b] != null && arrayOfCodeword1[b].getRowNumber() == arrayOfCodeword2[b].getRowNumber())
        for (byte b1 = 1; b1 <= this.barcodeColumnCount; b1++) {
          Codeword codeword = this.detectionResultColumns[b1].getCodewords()[b];
          if (codeword != null) {
            codeword.setRowNumber(arrayOfCodeword1[b].getRowNumber());
            if (!codeword.hasValidRowNumber())
              this.detectionResultColumns[b1].getCodewords()[b] = null; 
          } 
        }  
      b++;
    } 
  }
  
  private int adjustRowNumbersFromLRI() {
    if (this.detectionResultColumns[0] == null)
      return 0; 
    Codeword[] arrayOfCodeword = this.detectionResultColumns[0].getCodewords();
    byte b = 0;
    int i;
    for (i = 0; b < arrayOfCodeword.length; i = j) {
      int j = i;
      if (arrayOfCodeword[b] != null) {
        int k = arrayOfCodeword[b].getRowNumber();
        byte b1 = 1;
        int m = 0;
        while (b1 < this.barcodeColumnCount + 1 && m < 2) {
          Codeword codeword = this.detectionResultColumns[b1].getCodewords()[b];
          int n = m;
          j = i;
          if (codeword != null) {
            m = adjustRowNumberIfValid(k, m, codeword);
            n = m;
            j = i;
            if (!codeword.hasValidRowNumber()) {
              j = i + 1;
              n = m;
            } 
          } 
          b1++;
          m = n;
          i = j;
        } 
        j = i;
      } 
      b++;
    } 
    return i;
  }
  
  private int adjustRowNumbersFromRRI() {
    if (this.detectionResultColumns[this.barcodeColumnCount + 1] == null)
      return 0; 
    Codeword[] arrayOfCodeword = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
    byte b = 0;
    int i;
    for (i = 0; b < arrayOfCodeword.length; i = j) {
      int j = i;
      if (arrayOfCodeword[b] != null) {
        int k = arrayOfCodeword[b].getRowNumber();
        j = this.barcodeColumnCount + 1;
        int m = 0;
        while (j > 0 && m < 2) {
          Codeword codeword = this.detectionResultColumns[j].getCodewords()[b];
          int n = m;
          int i1 = i;
          if (codeword != null) {
            m = adjustRowNumberIfValid(k, m, codeword);
            n = m;
            i1 = i;
            if (!codeword.hasValidRowNumber()) {
              i1 = i + 1;
              n = m;
            } 
          } 
          j--;
          m = n;
          i = i1;
        } 
        j = i;
      } 
      b++;
    } 
    return i;
  }
  
  int getBarcodeColumnCount() {
    return this.barcodeColumnCount;
  }
  
  int getBarcodeECLevel() {
    return this.barcodeMetadata.getErrorCorrectionLevel();
  }
  
  int getBarcodeRowCount() {
    return this.barcodeMetadata.getRowCount();
  }
  
  BoundingBox getBoundingBox() {
    return this.boundingBox;
  }
  
  DetectionResultColumn getDetectionResultColumn(int paramInt) {
    return this.detectionResultColumns[paramInt];
  }
  
  DetectionResultColumn[] getDetectionResultColumns() {
    adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
    adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
    for (int i = 928;; i = j) {
      int j = adjustRowNumbers();
      if (j <= 0 || j >= i)
        break; 
    } 
    return this.detectionResultColumns;
  }
  
  void setBoundingBox(BoundingBox paramBoundingBox) {
    this.boundingBox = paramBoundingBox;
  }
  
  void setDetectionResultColumn(int paramInt, DetectionResultColumn paramDetectionResultColumn) {
    this.detectionResultColumns[paramInt] = paramDetectionResultColumn;
  }
  
  public String toString() {
    DetectionResultColumn detectionResultColumn1 = this.detectionResultColumns[0];
    DetectionResultColumn detectionResultColumn2 = detectionResultColumn1;
    if (detectionResultColumn1 == null)
      detectionResultColumn2 = this.detectionResultColumns[this.barcodeColumnCount + 1]; 
    Formatter formatter = new Formatter();
    DetectionResultColumn detectionResultColumn3 = null;
    byte b = 0;
    while (true) {
      Throwable throwable;
      detectionResultColumn1 = detectionResultColumn3;
      try {
        if (b < (detectionResultColumn2.getCodewords()).length) {
          detectionResultColumn1 = detectionResultColumn3;
          formatter.format("CW %3d:", new Object[] { Integer.valueOf(b) });
          byte b1 = 0;
          while (true) {
            detectionResultColumn1 = detectionResultColumn3;
            if (b1 < this.barcodeColumnCount + 2) {
              detectionResultColumn1 = detectionResultColumn3;
              if (this.detectionResultColumns[b1] == null) {
                detectionResultColumn1 = detectionResultColumn3;
                formatter.format("    |   ", new Object[0]);
              } else {
                detectionResultColumn1 = detectionResultColumn3;
                Codeword codeword = this.detectionResultColumns[b1].getCodewords()[b];
                if (codeword == null) {
                  detectionResultColumn1 = detectionResultColumn3;
                  formatter.format("    |   ", new Object[0]);
                } else {
                  detectionResultColumn1 = detectionResultColumn3;
                  formatter.format(" %3d|%3d", new Object[] { Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()) });
                } 
              } 
              b1++;
              continue;
            } 
            detectionResultColumn1 = detectionResultColumn3;
            break;
          } 
          formatter.format("%n", new Object[0]);
          b++;
          continue;
        } 
        detectionResultColumn1 = detectionResultColumn3;
        String str = formatter.toString();
        formatter.close();
        return str;
      } catch (Throwable throwable1) {
        throwable = throwable1;
        throw throwable1;
      } finally {}
      if (throwable != null) {
        try {
          formatter.close();
        } catch (Throwable throwable1) {
          throwable.addSuppressed(throwable1);
        } 
      } else {
        formatter.close();
      } 
      throw detectionResultColumn2;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */