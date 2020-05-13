package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.util.ArrayList;
import java.util.Formatter;

public final class PDF417ScanningDecoder {
  private static final int CODEWORD_SKEW_SIZE = 2;
  
  private static final int MAX_EC_CODEWORDS = 512;
  
  private static final int MAX_ERRORS = 3;
  
  private static final ErrorCorrection errorCorrection = new ErrorCorrection();
  
  private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn) throws NotFoundException {
    if (paramDetectionResultRowIndicatorColumn == null)
      return null; 
    int[] arrayOfInt = paramDetectionResultRowIndicatorColumn.getRowHeights();
    if (arrayOfInt == null)
      return null; 
    int i = getMax(arrayOfInt);
    int j = arrayOfInt.length;
    boolean bool = false;
    int k = 0;
    int m = 0;
    while (true) {
      n = m;
      if (k < j) {
        int i1 = arrayOfInt[k];
        m += i - i1;
        n = m;
        if (i1 <= 0) {
          k++;
          continue;
        } 
      } 
      break;
    } 
    Codeword[] arrayOfCodeword = paramDetectionResultRowIndicatorColumn.getCodewords();
    m = 0;
    k = n;
    int n;
    for (n = m; k > 0 && arrayOfCodeword[n] == null; n++)
      k--; 
    j = arrayOfInt.length - 1;
    m = bool;
    while (true) {
      n = m;
      if (j >= 0) {
        m += i - arrayOfInt[j];
        n = m;
        if (arrayOfInt[j] <= 0) {
          j--;
          continue;
        } 
      } 
      break;
    } 
    for (m = arrayOfCodeword.length - 1; n > 0 && arrayOfCodeword[m] == null; m--)
      n--; 
    return paramDetectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(k, n, paramDetectionResultRowIndicatorColumn.isLeft());
  }
  
  private static void adjustCodewordCount(DetectionResult paramDetectionResult, BarcodeValue[][] paramArrayOfBarcodeValue) throws NotFoundException {
    BarcodeValue barcodeValue = paramArrayOfBarcodeValue[0][1];
    int[] arrayOfInt = barcodeValue.getValue();
    int i = paramDetectionResult.getBarcodeColumnCount() * paramDetectionResult.getBarcodeRowCount() - getNumberOfECCodeWords(paramDetectionResult.getBarcodeECLevel());
    if (arrayOfInt.length == 0) {
      if (i > 0 && i <= 928) {
        barcodeValue.setValue(i);
        return;
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    if (arrayOfInt[0] != i)
      barcodeValue.setValue(i); 
  }
  
  private static int adjustCodewordStartColumn(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {
    if (paramBoolean) {
      b1 = -1;
    } else {
      b1 = 1;
    } 
    byte b2 = b1;
    byte b1 = 0;
    int i = paramInt3;
    while (b1 < 2) {
      while ((paramBoolean ? (i >= paramInt1) : (i < paramInt2)) && paramBoolean == paramBitMatrix.get(i, paramInt4)) {
        if (Math.abs(paramInt3 - i) > 2)
          return paramInt3; 
        i += b2;
      } 
      b2 = -b2;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      b1++;
    } 
    return i;
  }
  
  private static boolean checkCodewordSkew(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt2 - 2 <= paramInt1 && paramInt1 <= paramInt3 + 2);
  }
  
  private static int correctErrors(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) throws ChecksumException {
    if ((paramArrayOfint2 == null || paramArrayOfint2.length <= paramInt / 2 + 3) && paramInt >= 0 && paramInt <= 512)
      return errorCorrection.decode(paramArrayOfint1, paramInt, paramArrayOfint2); 
    throw ChecksumException.getChecksumInstance();
  }
  
  private static BarcodeValue[][] createBarcodeMatrix(DetectionResult paramDetectionResult) {
    BarcodeValue[][] arrayOfBarcodeValue = new BarcodeValue[paramDetectionResult.getBarcodeRowCount()][paramDetectionResult.getBarcodeColumnCount() + 2];
    byte b1;
    for (b1 = 0; b1 < arrayOfBarcodeValue.length; b1++) {
      for (byte b = 0; b < (arrayOfBarcodeValue[b1]).length; b++)
        arrayOfBarcodeValue[b1][b] = new BarcodeValue(); 
    } 
    DetectionResultColumn[] arrayOfDetectionResultColumn = paramDetectionResult.getDetectionResultColumns();
    int i = arrayOfDetectionResultColumn.length;
    byte b2 = 0;
    b1 = 0;
    while (b2 < i) {
      DetectionResultColumn detectionResultColumn = arrayOfDetectionResultColumn[b2];
      if (detectionResultColumn != null)
        for (Codeword codeword : detectionResultColumn.getCodewords()) {
          if (codeword != null) {
            int j = codeword.getRowNumber();
            if (j >= 0 && j < arrayOfBarcodeValue.length)
              arrayOfBarcodeValue[j][b1].setValue(codeword.getValue()); 
          } 
        }  
      b1++;
      b2++;
    } 
    return arrayOfBarcodeValue;
  }
  
  private static DecoderResult createDecoderResult(DetectionResult paramDetectionResult) throws FormatException, ChecksumException, NotFoundException {
    BarcodeValue[][] arrayOfBarcodeValue = createBarcodeMatrix(paramDetectionResult);
    adjustCodewordCount(paramDetectionResult, arrayOfBarcodeValue);
    ArrayList<Integer> arrayList1 = new ArrayList();
    int[] arrayOfInt1 = new int[paramDetectionResult.getBarcodeRowCount() * paramDetectionResult.getBarcodeColumnCount()];
    ArrayList<int[]> arrayList = new ArrayList();
    ArrayList<Integer> arrayList2 = new ArrayList();
    boolean bool = false;
    byte b;
    for (b = 0; b < paramDetectionResult.getBarcodeRowCount(); b++) {
      int i;
      for (i = 0; i < paramDetectionResult.getBarcodeColumnCount(); i = j) {
        BarcodeValue[] arrayOfBarcodeValue1 = arrayOfBarcodeValue[b];
        int j = i + 1;
        int[] arrayOfInt2 = arrayOfBarcodeValue1[j].getValue();
        i = paramDetectionResult.getBarcodeColumnCount() * b + i;
        if (arrayOfInt2.length == 0) {
          arrayList1.add(Integer.valueOf(i));
        } else if (arrayOfInt2.length == 1) {
          arrayOfInt1[i] = arrayOfInt2[0];
        } else {
          arrayList2.add(Integer.valueOf(i));
          arrayList.add(arrayOfInt2);
        } 
      } 
    } 
    int[][] arrayOfInt = new int[arrayList.size()][];
    for (b = bool; b < arrayOfInt.length; b++)
      arrayOfInt[b] = arrayList.get(b); 
    return createDecoderResultFromAmbiguousValues(paramDetectionResult.getBarcodeECLevel(), arrayOfInt1, PDF417Common.toIntArray(arrayList1), PDF417Common.toIntArray(arrayList2), arrayOfInt);
  }
  
  private static DecoderResult createDecoderResultFromAmbiguousValues(int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[][] paramArrayOfint) throws FormatException, ChecksumException {
    int[] arrayOfInt = new int[paramArrayOfint3.length];
    byte b = 100;
    while (b > 0) {
      byte b1;
      for (b1 = 0; b1 < arrayOfInt.length; b1++)
        paramArrayOfint1[paramArrayOfint3[b1]] = paramArrayOfint[b1][arrayOfInt[b1]]; 
      try {
        return decodeCodewords(paramArrayOfint1, paramInt, paramArrayOfint2);
      } catch (ChecksumException checksumException) {
        if (arrayOfInt.length != 0) {
          b1 = 0;
          while (b1 < arrayOfInt.length) {
            if (arrayOfInt[b1] < (paramArrayOfint[b1]).length - 1) {
              arrayOfInt[b1] = arrayOfInt[b1] + 1;
              break;
            } 
            arrayOfInt[b1] = 0;
            if (b1 != arrayOfInt.length - 1) {
              b1++;
              continue;
            } 
            throw ChecksumException.getChecksumInstance();
          } 
          b--;
          continue;
        } 
        throw ChecksumException.getChecksumInstance();
      } 
    } 
    throw ChecksumException.getChecksumInstance();
  }
  
  public static DecoderResult decode(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2) throws NotFoundException, FormatException, ChecksumException {
    DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn1;
    DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2;
    DetectionResult detectionResult;
    boolean bool;
    BoundingBox boundingBox = new BoundingBox(paramBitMatrix, paramResultPoint1, paramResultPoint2, paramResultPoint3, paramResultPoint4);
    paramResultPoint2 = null;
    ResultPoint resultPoint = paramResultPoint2;
    paramResultPoint4 = resultPoint;
    int i = 0;
    while (i < 2) {
      if (paramResultPoint1 != null)
        detectionResultRowIndicatorColumn1 = getRowIndicatorColumn(paramBitMatrix, boundingBox, paramResultPoint1, true, paramInt1, paramInt2); 
      if (paramResultPoint3 != null)
        detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(paramBitMatrix, boundingBox, paramResultPoint3, false, paramInt1, paramInt2); 
      detectionResult = merge(detectionResultRowIndicatorColumn1, detectionResultRowIndicatorColumn2);
      if (detectionResult != null) {
        if (i == 0 && detectionResult.getBoundingBox() != null && (detectionResult.getBoundingBox().getMinY() < boundingBox.getMinY() || detectionResult.getBoundingBox().getMaxY() > boundingBox.getMaxY())) {
          boundingBox = detectionResult.getBoundingBox();
          i++;
          continue;
        } 
        detectionResult.setBoundingBox(boundingBox);
        break;
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    int j = detectionResult.getBarcodeColumnCount() + 1;
    detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn1);
    detectionResult.setDetectionResultColumn(j, detectionResultRowIndicatorColumn2);
    if (detectionResultRowIndicatorColumn1 != null) {
      bool = true;
    } else {
      bool = false;
    } 
    int k = 1;
    i = paramInt2;
    paramInt2 = k;
    while (paramInt2 <= j) {
      int m;
      if (bool) {
        m = paramInt2;
      } else {
        m = j - paramInt2;
      } 
      int n = paramInt1;
      k = i;
      if (detectionResult.getDetectionResultColumn(m) == null) {
        DetectionResultColumn detectionResultColumn;
        if (m == 0 || m == j) {
          boolean bool1;
          if (m == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          detectionResultColumn = new DetectionResultRowIndicatorColumn(boundingBox, bool1);
        } else {
          detectionResultColumn = new DetectionResultColumn(boundingBox);
        } 
        detectionResult.setDetectionResultColumn(m, detectionResultColumn);
        int i1 = boundingBox.getMinY();
        k = i;
        i = paramInt1;
        n = -1;
        paramInt1 = k;
        k = n;
        while (i1 <= boundingBox.getMaxY()) {
          n = getStartColumn(detectionResult, m, i1, bool);
          if (n < 0 || n > boundingBox.getMaxX())
            if (k != -1) {
              n = k;
            } else {
              continue;
            }  
          Codeword codeword = detectCodeword(paramBitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), bool, n, i1, i, paramInt1);
          if (codeword != null) {
            detectionResultColumn.setCodeword(i1, codeword);
            i = Math.min(i, codeword.getWidth());
            paramInt1 = Math.max(paramInt1, codeword.getWidth());
            k = n;
          } 
          continue;
          i1++;
        } 
        k = paramInt1;
        n = i;
      } 
      paramInt2++;
      paramInt1 = n;
      i = k;
    } 
    return createDecoderResult(detectionResult);
  }
  
  private static DecoderResult decodeCodewords(int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2) throws FormatException, ChecksumException {
    if (paramArrayOfint1.length != 0) {
      int i = 1 << paramInt + 1;
      int j = correctErrors(paramArrayOfint1, paramArrayOfint2, i);
      verifyCodewordCount(paramArrayOfint1, i);
      DecoderResult decoderResult = DecodedBitStreamParser.decode(paramArrayOfint1, String.valueOf(paramInt));
      decoderResult.setErrorsCorrected(Integer.valueOf(j));
      decoderResult.setErasures(Integer.valueOf(paramArrayOfint2.length));
      return decoderResult;
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static Codeword detectCodeword(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    paramInt3 = adjustCodewordStartColumn(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    int[] arrayOfInt = getModuleBitCount(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    if (arrayOfInt == null)
      return null; 
    paramInt4 = MathUtils.sum(arrayOfInt);
    if (paramBoolean) {
      paramInt2 = paramInt3 + paramInt4;
      paramInt1 = paramInt3;
      paramInt3 = paramInt2;
    } else {
      for (paramInt1 = 0; paramInt1 < arrayOfInt.length / 2; paramInt1++) {
        paramInt2 = arrayOfInt[paramInt1];
        arrayOfInt[paramInt1] = arrayOfInt[arrayOfInt.length - 1 - paramInt1];
        arrayOfInt[arrayOfInt.length - 1 - paramInt1] = paramInt2;
      } 
      paramInt1 = paramInt3 - paramInt4;
    } 
    if (!checkCodewordSkew(paramInt4, paramInt5, paramInt6))
      return null; 
    paramInt4 = PDF417CodewordDecoder.getDecodedValue(arrayOfInt);
    paramInt2 = PDF417Common.getCodeword(paramInt4);
    return (paramInt2 == -1) ? null : new Codeword(paramInt1, paramInt3, getCodewordBucketNumber(paramInt4), paramInt2);
  }
  
  private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2) {
    BarcodeMetadata barcodeMetadata;
    if (paramDetectionResultRowIndicatorColumn1 != null) {
      BarcodeMetadata barcodeMetadata1 = paramDetectionResultRowIndicatorColumn1.getBarcodeMetadata();
      if (barcodeMetadata1 != null) {
        if (paramDetectionResultRowIndicatorColumn2 != null) {
          barcodeMetadata = paramDetectionResultRowIndicatorColumn2.getBarcodeMetadata();
          if (barcodeMetadata != null)
            return (barcodeMetadata1.getColumnCount() != barcodeMetadata.getColumnCount() && barcodeMetadata1.getErrorCorrectionLevel() != barcodeMetadata.getErrorCorrectionLevel() && barcodeMetadata1.getRowCount() != barcodeMetadata.getRowCount()) ? null : barcodeMetadata1; 
        } 
        return barcodeMetadata1;
      } 
    } 
    return (barcodeMetadata == null) ? null : barcodeMetadata.getBarcodeMetadata();
  }
  
  private static int[] getBitCountForCodeword(int paramInt) {
    int[] arrayOfInt = new int[8];
    int i = 0;
    for (int j = 7;; j = n) {
      int k = paramInt & 0x1;
      int m = i;
      int n = j;
      if (k != i) {
        n = j - 1;
        if (n >= 0) {
          m = k;
        } else {
          return arrayOfInt;
        } 
      } 
      arrayOfInt[n] = arrayOfInt[n] + 1;
      paramInt >>= 1;
      i = m;
    } 
  }
  
  private static int getCodewordBucketNumber(int paramInt) {
    return getCodewordBucketNumber(getBitCountForCodeword(paramInt));
  }
  
  private static int getCodewordBucketNumber(int[] paramArrayOfint) {
    return (paramArrayOfint[0] - paramArrayOfint[2] + paramArrayOfint[4] - paramArrayOfint[6] + 9) % 9;
  }
  
  private static int getMax(int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    int j = -1;
    for (byte b = 0; b < i; b++)
      j = Math.max(j, paramArrayOfint[b]); 
    return j;
  }
  
  private static int[] getModuleBitCount(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {
    byte b;
    int[] arrayOfInt = new int[8];
    if (paramBoolean) {
      b = 1;
    } else {
      b = -1;
    } 
    boolean bool = paramBoolean;
    byte b1 = 0;
    while ((paramBoolean ? (paramInt3 < paramInt2) : (paramInt3 >= paramInt1)) && b1 < 8) {
      if (paramBitMatrix.get(paramInt3, paramInt4) == bool) {
        arrayOfInt[b1] = arrayOfInt[b1] + 1;
        paramInt3 += b;
        continue;
      } 
      b1++;
      if (!bool) {
        bool = true;
        continue;
      } 
      bool = false;
    } 
    if (b1 != 8) {
      if (paramBoolean)
        paramInt1 = paramInt2; 
      if (paramInt3 != paramInt1 || b1 != 7)
        return null; 
    } 
    return arrayOfInt;
  }
  
  private static int getNumberOfECCodeWords(int paramInt) {
    return 2 << paramInt;
  }
  
  private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix paramBitMatrix, BoundingBox paramBoundingBox, ResultPoint paramResultPoint, boolean paramBoolean, int paramInt1, int paramInt2) {
    DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(paramBoundingBox, paramBoolean);
    for (byte b = 0; b < 2; b++) {
      byte b1;
      if (b == 0) {
        b1 = 1;
      } else {
        b1 = -1;
      } 
      int i = (int)paramResultPoint.getX();
      int j;
      for (j = (int)paramResultPoint.getY(); j <= paramBoundingBox.getMaxY() && j >= paramBoundingBox.getMinY(); j += b1) {
        Codeword codeword = detectCodeword(paramBitMatrix, 0, paramBitMatrix.getWidth(), paramBoolean, i, j, paramInt1, paramInt2);
        if (codeword != null) {
          detectionResultRowIndicatorColumn.setCodeword(j, codeword);
          if (paramBoolean) {
            i = codeword.getStartX();
          } else {
            i = codeword.getEndX();
          } 
        } 
      } 
    } 
    return detectionResultRowIndicatorColumn;
  }
  
  private static int getStartColumn(DetectionResult paramDetectionResult, int paramInt1, int paramInt2, boolean paramBoolean) {
    byte b;
    if (paramBoolean) {
      b = 1;
    } else {
      b = -1;
    } 
    Codeword codeword = null;
    int i = paramInt1 - b;
    if (isValidBarcodeColumn(paramDetectionResult, i))
      codeword = paramDetectionResult.getDetectionResultColumn(i).getCodeword(paramInt2); 
    if (codeword != null)
      return paramBoolean ? codeword.getEndX() : codeword.getStartX(); 
    codeword = paramDetectionResult.getDetectionResultColumn(paramInt1).getCodewordNearby(paramInt2);
    if (codeword != null)
      return paramBoolean ? codeword.getStartX() : codeword.getEndX(); 
    if (isValidBarcodeColumn(paramDetectionResult, i))
      codeword = paramDetectionResult.getDetectionResultColumn(i).getCodewordNearby(paramInt2); 
    if (codeword != null)
      return paramBoolean ? codeword.getEndX() : codeword.getStartX(); 
    i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (true) {
      i = paramInt2 - b;
      if (isValidBarcodeColumn(paramDetectionResult, i)) {
        Codeword[] arrayOfCodeword = paramDetectionResult.getDetectionResultColumn(i).getCodewords();
        int j = arrayOfCodeword.length;
        for (paramInt2 = 0; paramInt2 < j; paramInt2++) {
          Codeword codeword1 = arrayOfCodeword[paramInt2];
          if (codeword1 != null) {
            if (paramBoolean) {
              paramInt2 = codeword1.getEndX();
            } else {
              paramInt2 = codeword1.getStartX();
            } 
            return paramInt2 + b * paramInt1 * (codeword1.getEndX() - codeword1.getStartX());
          } 
        } 
        paramInt1++;
        paramInt2 = i;
        continue;
      } 
      return paramBoolean ? paramDetectionResult.getBoundingBox().getMinX() : paramDetectionResult.getBoundingBox().getMaxX();
    } 
  }
  
  private static boolean isValidBarcodeColumn(DetectionResult paramDetectionResult, int paramInt) {
    return (paramInt >= 0 && paramInt <= paramDetectionResult.getBarcodeColumnCount() + 1);
  }
  
  private static DetectionResult merge(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2) throws NotFoundException {
    if (paramDetectionResultRowIndicatorColumn1 == null && paramDetectionResultRowIndicatorColumn2 == null)
      return null; 
    BarcodeMetadata barcodeMetadata = getBarcodeMetadata(paramDetectionResultRowIndicatorColumn1, paramDetectionResultRowIndicatorColumn2);
    return (barcodeMetadata == null) ? null : new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(paramDetectionResultRowIndicatorColumn1), adjustBoundingBox(paramDetectionResultRowIndicatorColumn2)));
  }
  
  public static String toString(BarcodeValue[][] paramArrayOfBarcodeValue) {
    Formatter formatter = new Formatter();
    byte b = 0;
    while (true) {
      Throwable throwable1 = null;
      Throwable throwable2 = throwable1;
      try {
        if (b < paramArrayOfBarcodeValue.length) {
          throwable2 = throwable1;
          formatter.format("Row %2d: ", new Object[] { Integer.valueOf(b) });
          byte b1 = 0;
          while (true) {
            throwable2 = throwable1;
            if (b1 < (paramArrayOfBarcodeValue[b]).length) {
              BarcodeValue barcodeValue = paramArrayOfBarcodeValue[b][b1];
              throwable2 = throwable1;
              if ((barcodeValue.getValue()).length == 0) {
                throwable2 = throwable1;
                formatter.format("        ", null);
              } else {
                throwable2 = throwable1;
                formatter.format("%4d(%2d)", new Object[] { Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]) });
              } 
              b1++;
              continue;
            } 
            throwable2 = throwable1;
            break;
          } 
          formatter.format("%n", new Object[0]);
          b++;
          continue;
        } 
        throwable2 = throwable1;
        String str = formatter.toString();
        formatter.close();
        return str;
      } catch (Throwable throwable) {
        throwable2 = throwable;
        throw throwable;
      } finally {}
      if (throwable2 != null) {
        try {
          formatter.close();
        } catch (Throwable throwable) {
          throwable2.addSuppressed(throwable);
        } 
      } else {
        formatter.close();
      } 
      throw paramArrayOfBarcodeValue;
    } 
  }
  
  private static void verifyCodewordCount(int[] paramArrayOfint, int paramInt) throws FormatException {
    if (paramArrayOfint.length >= 4) {
      int i = paramArrayOfint[0];
      if (i <= paramArrayOfint.length) {
        if (i == 0) {
          if (paramInt < paramArrayOfint.length) {
            paramArrayOfint[0] = paramArrayOfint.length - paramInt;
            return;
          } 
          throw FormatException.getFormatInstance();
        } 
        return;
      } 
      throw FormatException.getFormatInstance();
    } 
    throw FormatException.getFormatInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\PDF417ScanningDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */