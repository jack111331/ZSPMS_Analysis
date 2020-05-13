package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader {
  static final int[] END_PATTERN;
  
  static final int[][] L_AND_G_PATTERNS;
  
  static final int[][] L_PATTERNS;
  
  private static final float MAX_AVG_VARIANCE = 0.48F;
  
  private static final float MAX_INDIVIDUAL_VARIANCE = 0.7F;
  
  static final int[] MIDDLE_PATTERN;
  
  static final int[] START_END_PATTERN = new int[] { 1, 1, 1 };
  
  private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
  
  private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
  
  private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();
  
  static {
    MIDDLE_PATTERN = new int[] { 1, 1, 1, 1, 1 };
    END_PATTERN = new int[] { 1, 1, 1, 1, 1, 1 };
    byte b = 10;
    L_PATTERNS = new int[][] { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
    L_AND_G_PATTERNS = new int[20][];
    System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
    while (b < 20) {
      int[] arrayOfInt1 = L_PATTERNS[b - 10];
      int[] arrayOfInt2 = new int[arrayOfInt1.length];
      for (byte b1 = 0; b1 < arrayOfInt1.length; b1++)
        arrayOfInt2[b1] = arrayOfInt1[arrayOfInt1.length - b1 - 1]; 
      L_AND_G_PATTERNS[b] = arrayOfInt2;
      b++;
    } 
  }
  
  static boolean checkStandardUPCEANChecksum(CharSequence paramCharSequence) throws FormatException {
    int i = paramCharSequence.length();
    if (i == 0)
      return false; 
    int j = i - 1;
    i = Character.digit(paramCharSequence.charAt(j), 10);
    return (getStandardUPCEANChecksum(paramCharSequence.subSequence(0, j)) == i);
  }
  
  static int decodeDigit(BitArray paramBitArray, int[] paramArrayOfint, int paramInt, int[][] paramArrayOfint1) throws NotFoundException {
    recordPattern(paramBitArray, paramInt, paramArrayOfint);
    int i = paramArrayOfint1.length;
    float f = 0.48F;
    int j = -1;
    paramInt = 0;
    while (paramInt < i) {
      float f1 = patternMatchVariance(paramArrayOfint, paramArrayOfint1[paramInt], 0.7F);
      float f2 = f;
      if (f1 < f) {
        j = paramInt;
        f2 = f1;
      } 
      paramInt++;
      f = f2;
    } 
    if (j >= 0)
      return j; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  static int[] findGuardPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfint) throws NotFoundException {
    return findGuardPattern(paramBitArray, paramInt, paramBoolean, paramArrayOfint, new int[paramArrayOfint.length]);
  }
  
  private static int[] findGuardPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfint1, int[] paramArrayOfint2) throws NotFoundException {
    int i = paramBitArray.getSize();
    if (paramBoolean) {
      paramInt = paramBitArray.getNextUnset(paramInt);
    } else {
      paramInt = paramBitArray.getNextSet(paramInt);
    } 
    int j = paramArrayOfint1.length;
    int k = paramInt;
    int m = 0;
    int n = paramInt;
    paramInt = k;
    k = m;
    while (n < i) {
      boolean bool = paramBitArray.get(n);
      boolean bool1 = true;
      if (bool != paramBoolean) {
        paramArrayOfint2[k] = paramArrayOfint2[k] + 1;
        m = paramInt;
      } else {
        if (k == j - 1) {
          if (patternMatchVariance(paramArrayOfint2, paramArrayOfint1, 0.7F) < 0.48F)
            return new int[] { paramInt, n }; 
          m = paramInt + paramArrayOfint2[0] + paramArrayOfint2[1];
          paramInt = k - 1;
          System.arraycopy(paramArrayOfint2, 2, paramArrayOfint2, 0, paramInt);
          paramArrayOfint2[paramInt] = 0;
          paramArrayOfint2[k] = 0;
          paramInt = k - 1;
          k = m;
        } else {
          m = k + 1;
          k = paramInt;
          paramInt = m;
        } 
        paramArrayOfint2[paramInt] = 1;
        if (!paramBoolean) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        } 
        m = k;
        k = paramInt;
      } 
      n++;
      paramInt = m;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  static int[] findStartGuardPattern(BitArray paramBitArray) throws NotFoundException {
    int[] arrayOfInt1 = new int[START_END_PATTERN.length];
    int[] arrayOfInt2 = null;
    boolean bool = false;
    int i = 0;
    while (!bool) {
      Arrays.fill(arrayOfInt1, 0, START_END_PATTERN.length, 0);
      arrayOfInt2 = findGuardPattern(paramBitArray, i, false, START_END_PATTERN, arrayOfInt1);
      int j = arrayOfInt2[0];
      i = arrayOfInt2[1];
      int k = j - i - j;
      if (k >= 0)
        bool = paramBitArray.isRange(k, j, false); 
    } 
    return arrayOfInt2;
  }
  
  static int getStandardUPCEANChecksum(CharSequence paramCharSequence) throws FormatException {
    int i = paramCharSequence.length();
    int j = i - 1;
    int k = 0;
    while (j >= 0) {
      int m = paramCharSequence.charAt(j) - 48;
      if (m >= 0 && m <= 9) {
        k += m;
        j -= 2;
        continue;
      } 
      throw FormatException.getFormatInstance();
    } 
    k *= 3;
    j = i - 2;
    while (j >= 0) {
      i = paramCharSequence.charAt(j) - 48;
      if (i >= 0 && i <= 9) {
        k += i;
        j -= 2;
        continue;
      } 
      throw FormatException.getFormatInstance();
    } 
    return (1000 - k) % 10;
  }
  
  boolean checkChecksum(String paramString) throws FormatException {
    return checkStandardUPCEANChecksum(paramString);
  }
  
  int[] decodeEnd(BitArray paramBitArray, int paramInt) throws NotFoundException {
    return findGuardPattern(paramBitArray, paramInt, false, START_END_PATTERN);
  }
  
  protected abstract int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException;
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    return decodeRow(paramInt, paramBitArray, findStartGuardPattern(paramBitArray), paramMap);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfint, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    ResultPointCallback resultPointCallback;
    BitArray bitArray = null;
    if (paramMap == null) {
      resultPointCallback = null;
    } else {
      resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
    } 
    boolean bool = true;
    if (resultPointCallback != null)
      resultPointCallback.foundPossibleResultPoint(new ResultPoint((paramArrayOfint[0] + paramArrayOfint[1]) / 2.0F, paramInt)); 
    StringBuilder stringBuilder = this.decodeRowStringBuffer;
    stringBuilder.setLength(0);
    int i = decodeMiddle(paramBitArray, paramArrayOfint, stringBuilder);
    if (resultPointCallback != null)
      resultPointCallback.foundPossibleResultPoint(new ResultPoint(i, paramInt)); 
    int[] arrayOfInt = decodeEnd(paramBitArray, i);
    if (resultPointCallback != null)
      resultPointCallback.foundPossibleResultPoint(new ResultPoint((arrayOfInt[0] + arrayOfInt[1]) / 2.0F, paramInt)); 
    int j = arrayOfInt[1];
    i = j - arrayOfInt[0] + j;
    if (i < paramBitArray.getSize() && paramBitArray.isRange(j, i, false)) {
      String str = stringBuilder.toString();
      if (str.length() >= 8) {
        if (checkChecksum(str)) {
          int[] arrayOfInt1;
          float f1 = (paramArrayOfint[1] + paramArrayOfint[0]) / 2.0F;
          float f2 = (arrayOfInt[1] + arrayOfInt[0]) / 2.0F;
          BarcodeFormat barcodeFormat = getBarcodeFormat();
          float f3 = paramInt;
          Result result = new Result(str, null, new ResultPoint[] { new ResultPoint(f1, f3), new ResultPoint(f2, f3) }barcodeFormat);
          try {
            Result result1 = this.extensionReader.decodeRow(paramInt, paramBitArray, arrayOfInt[1]);
            result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, result1.getText());
            result.putAllMetadata(result1.getResultMetadata());
            result.addResultPoints(result1.getResultPoints());
            paramInt = result1.getText().length();
          } catch (ReaderException readerException) {
            paramInt = 0;
          } 
          if (paramMap == null) {
            paramBitArray = bitArray;
          } else {
            arrayOfInt1 = (int[])paramMap.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
          } 
          if (arrayOfInt1 != null) {
            j = arrayOfInt1.length;
            i = 0;
            while (true) {
              if (i < j) {
                if (paramInt == arrayOfInt1[i]) {
                  paramInt = bool;
                  break;
                } 
                i++;
                continue;
              } 
              paramInt = 0;
              break;
            } 
            if (paramInt == 0)
              throw NotFoundException.getNotFoundInstance(); 
          } 
          if (barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) {
            String str1 = this.eanManSupport.lookupCountryIdentifier(str);
            if (str1 != null)
              result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, str1); 
          } 
          return result;
        } 
        throw ChecksumException.getChecksumInstance();
      } 
      throw FormatException.getFormatInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  abstract BarcodeFormat getBarcodeFormat();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCEANReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */