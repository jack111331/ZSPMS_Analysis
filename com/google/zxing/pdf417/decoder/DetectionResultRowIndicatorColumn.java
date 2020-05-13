package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
  private final boolean isLeft;
  
  DetectionResultRowIndicatorColumn(BoundingBox paramBoundingBox, boolean paramBoolean) {
    super(paramBoundingBox);
    this.isLeft = paramBoolean;
  }
  
  private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata paramBarcodeMetadata) {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    BoundingBox boundingBox = getBoundingBox();
    if (this.isLeft) {
      resultPoint2 = boundingBox.getTopLeft();
    } else {
      resultPoint2 = boundingBox.getTopRight();
    } 
    if (this.isLeft) {
      resultPoint1 = boundingBox.getBottomLeft();
    } else {
      resultPoint1 = resultPoint1.getBottomRight();
    } 
    int i = imageRowToCodewordIndex((int)resultPoint2.getY());
    int j = imageRowToCodewordIndex((int)resultPoint1.getY());
    Codeword[] arrayOfCodeword = getCodewords();
    int k = -1;
    int m = 0;
    int n;
    for (n = 1;; n = i3) {
      int i1;
      int i2;
      int i3;
      if (i < j) {
        i1 = k;
        i2 = m;
        i3 = n;
        if (arrayOfCodeword[i] != null) {
          Codeword codeword = arrayOfCodeword[i];
          codeword.setRowNumberAsRowIndicatorColumn();
          i2 = codeword.getRowNumber() - k;
          if (i2 == 0) {
            i2 = m + 1;
            i1 = k;
            i3 = n;
          } else {
            if (i2 == 1) {
              n = Math.max(n, m);
              i2 = codeword.getRowNumber();
            } else {
              if (codeword.getRowNumber() >= paramBarcodeMetadata.getRowCount()) {
                arrayOfCodeword[i] = null;
                i1 = k;
                i2 = m;
                i3 = n;
              } else {
                i2 = codeword.getRowNumber();
                k = 1;
                i1 = i2;
                i2 = k;
                i3 = n;
              } 
              i++;
              k = i1;
              m = i2;
              n = i3;
            } 
            k = 1;
            i1 = i2;
            i2 = k;
            i3 = n;
          } 
        } 
      } else {
        break;
      } 
      i++;
      k = i1;
      m = i2;
    } 
  }
  
  private void removeIncorrectCodewords(Codeword[] paramArrayOfCodeword, BarcodeMetadata paramBarcodeMetadata) {
    for (byte b = 0; b < paramArrayOfCodeword.length; b++) {
      Codeword codeword = paramArrayOfCodeword[b];
      if (paramArrayOfCodeword[b] != null) {
        int i = codeword.getValue() % 30;
        int j = codeword.getRowNumber();
        if (j > paramBarcodeMetadata.getRowCount()) {
          paramArrayOfCodeword[b] = null;
        } else {
          int k = j;
          if (!this.isLeft)
            k = j + 2; 
          switch (k % 3) {
            case 2:
              if (i + 1 != paramBarcodeMetadata.getColumnCount())
                paramArrayOfCodeword[b] = null; 
              break;
            case 1:
              if (i / 3 != paramBarcodeMetadata.getErrorCorrectionLevel() || i % 3 != paramBarcodeMetadata.getRowCountLowerPart())
                paramArrayOfCodeword[b] = null; 
              break;
            case 0:
              if (i * 3 + 1 != paramBarcodeMetadata.getRowCountUpperPart())
                paramArrayOfCodeword[b] = null; 
              break;
          } 
        } 
      } 
    } 
  }
  
  private void setRowNumbers() {
    for (Codeword codeword : getCodewords()) {
      if (codeword != null)
        codeword.setRowNumberAsRowIndicatorColumn(); 
    } 
  }
  
  void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata paramBarcodeMetadata) {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    Codeword[] arrayOfCodeword = getCodewords();
    setRowNumbers();
    removeIncorrectCodewords(arrayOfCodeword, paramBarcodeMetadata);
    BoundingBox boundingBox = getBoundingBox();
    if (this.isLeft) {
      resultPoint2 = boundingBox.getTopLeft();
    } else {
      resultPoint2 = boundingBox.getTopRight();
    } 
    if (this.isLeft) {
      resultPoint1 = boundingBox.getBottomLeft();
    } else {
      resultPoint1 = resultPoint1.getBottomRight();
    } 
    int i = imageRowToCodewordIndex((int)resultPoint2.getY());
    int j = imageRowToCodewordIndex((int)resultPoint1.getY());
    int k = -1;
    int m = 0;
    int n;
    for (n = 1;; n = i3) {
      int i1;
      int i2;
      int i3;
      if (i < j) {
        i1 = k;
        i2 = m;
        i3 = n;
        if (arrayOfCodeword[i] != null) {
          Codeword codeword = arrayOfCodeword[i];
          i2 = codeword.getRowNumber() - k;
          if (i2 == 0) {
            i2 = m + 1;
            i1 = k;
            i3 = n;
          } else {
            if (i2 == 1) {
              n = Math.max(n, m);
              i2 = codeword.getRowNumber();
            } else {
              if (i2 < 0 || codeword.getRowNumber() >= paramBarcodeMetadata.getRowCount() || i2 > i) {
                arrayOfCodeword[i] = null;
                i3 = n;
                i2 = m;
                i1 = k;
              } else {
                i1 = i2;
                if (n > 2)
                  i1 = i2 * (n - 2); 
                if (i1 >= i) {
                  i2 = 1;
                } else {
                  i2 = 0;
                } 
                for (i3 = 1; i3 <= i1 && i2 == 0; i3++) {
                  if (arrayOfCodeword[i - i3] != null) {
                    i2 = 1;
                  } else {
                    i2 = 0;
                  } 
                } 
                if (i2 != 0) {
                  arrayOfCodeword[i] = null;
                  i1 = k;
                  i2 = m;
                  i3 = n;
                } else {
                  i2 = codeword.getRowNumber();
                  k = 1;
                  i1 = i2;
                  i2 = k;
                  i3 = n;
                } 
              } 
              i++;
              k = i1;
              m = i2;
              n = i3;
            } 
            k = 1;
            i1 = i2;
            i2 = k;
            i3 = n;
          } 
        } 
      } else {
        break;
      } 
      i++;
      k = i1;
      m = i2;
    } 
  }
  
  BarcodeMetadata getBarcodeMetadata() {
    Codeword[] arrayOfCodeword = getCodewords();
    BarcodeValue barcodeValue1 = new BarcodeValue();
    BarcodeValue barcodeValue2 = new BarcodeValue();
    BarcodeValue barcodeValue3 = new BarcodeValue();
    BarcodeValue barcodeValue4 = new BarcodeValue();
    int i = arrayOfCodeword.length;
    for (byte b = 0; b < i; b++) {
      Codeword codeword = arrayOfCodeword[b];
      if (codeword != null) {
        codeword.setRowNumberAsRowIndicatorColumn();
        int j = codeword.getValue() % 30;
        int k = codeword.getRowNumber();
        int m = k;
        if (!this.isLeft)
          m = k + 2; 
        switch (m % 3) {
          case 2:
            barcodeValue1.setValue(j + 1);
            break;
          case 1:
            barcodeValue4.setValue(j / 3);
            barcodeValue3.setValue(j % 3);
            break;
          case 0:
            barcodeValue2.setValue(j * 3 + 1);
            break;
        } 
      } 
    } 
    if ((barcodeValue1.getValue()).length == 0 || (barcodeValue2.getValue()).length == 0 || (barcodeValue3.getValue()).length == 0 || (barcodeValue4.getValue()).length == 0 || barcodeValue1.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90)
      return null; 
    BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue1.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
    removeIncorrectCodewords(arrayOfCodeword, barcodeMetadata);
    return barcodeMetadata;
  }
  
  int[] getRowHeights() {
    BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
    if (barcodeMetadata == null)
      return null; 
    adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
    int[] arrayOfInt = new int[barcodeMetadata.getRowCount()];
    for (Codeword codeword : getCodewords()) {
      if (codeword != null) {
        int i = codeword.getRowNumber();
        if (i < arrayOfInt.length)
          arrayOfInt[i] = arrayOfInt[i] + 1; 
      } 
    } 
    return arrayOfInt;
  }
  
  boolean isLeft() {
    return this.isLeft;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("IsLeft: ");
    stringBuilder.append(this.isLeft);
    stringBuilder.append('\n');
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResultRowIndicatorColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */