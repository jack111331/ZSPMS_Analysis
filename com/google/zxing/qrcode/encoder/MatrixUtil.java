package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil {
  private static final int[][] POSITION_ADJUSTMENT_PATTERN;
  
  private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
  
  private static final int[][] POSITION_DETECTION_PATTERN;
  
  private static final int[][] TYPE_INFO_COORDINATES;
  
  private static final int TYPE_INFO_MASK_PATTERN = 21522;
  
  private static final int TYPE_INFO_POLY = 1335;
  
  private static final int VERSION_INFO_POLY = 7973;
  
  static {
    int[] arrayOfInt1 = { 1, 0, 1, 1, 1, 0, 1 };
    POSITION_DETECTION_PATTERN = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt1, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 1, 0, 0, 0, 1 };
    int[] arrayOfInt2 = { 1, 0, 0, 0, 1 };
    int[] arrayOfInt3 = { 1, 1, 1, 1, 1 };
    POSITION_ADJUSTMENT_PATTERN = new int[][] { { 1, 1, 1, 1, 1 }, arrayOfInt1, { 1, 0, 1, 0, 1 }, arrayOfInt2, arrayOfInt3 };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 22, -1, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 26, -1, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 30, -1, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 34, -1, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt17 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt18 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt19 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt20 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt21 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt22 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt23 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt24 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt25 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt26 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt27 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt28 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt29 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt30 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt31 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt32 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt33 = { 6, 24, 50, 76, 102, 128, 154 };
    int[] arrayOfInt34 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt35 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt36 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt37 = { 6, 30, 58, 86, 114, 142, 170 };
    POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][] { 
        arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, 
        arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, { 6, 30, 54, 78, -1, -1, -1 }, arrayOfInt17, arrayOfInt18, arrayOfInt19, 
        { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, 
        arrayOfInt28, arrayOfInt29, arrayOfInt30, arrayOfInt31, arrayOfInt32, arrayOfInt33, arrayOfInt34, arrayOfInt35, arrayOfInt36, arrayOfInt37 };
    arrayOfInt1 = new int[] { 8, 2 };
    arrayOfInt2 = new int[] { 4, 8 };
    arrayOfInt3 = new int[] { 0, 8 };
    TYPE_INFO_COORDINATES = new int[][] { 
        { 8, 0 }, { 8, 1 }, arrayOfInt1, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, 
        arrayOfInt2, { 3, 8 }, { 2, 8 }, { 1, 8 }, arrayOfInt3 };
  }
  
  static void buildMatrix(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, int paramInt, ByteMatrix paramByteMatrix) throws WriterException {
    clearMatrix(paramByteMatrix);
    embedBasicPatterns(paramVersion, paramByteMatrix);
    embedTypeInfo(paramErrorCorrectionLevel, paramInt, paramByteMatrix);
    maybeEmbedVersionInfo(paramVersion, paramByteMatrix);
    embedDataBits(paramBitArray, paramInt, paramByteMatrix);
  }
  
  static int calculateBCHCode(int paramInt1, int paramInt2) {
    if (paramInt2 != 0) {
      int i = findMSBSet(paramInt2);
      for (paramInt1 <<= i - 1; findMSBSet(paramInt1) >= i; paramInt1 ^= paramInt2 << findMSBSet(paramInt1) - i);
      return paramInt1;
    } 
    throw new IllegalArgumentException("0 polynomial");
  }
  
  static void clearMatrix(ByteMatrix paramByteMatrix) {
    paramByteMatrix.clear((byte)-1);
  }
  
  static void embedBasicPatterns(Version paramVersion, ByteMatrix paramByteMatrix) throws WriterException {
    embedPositionDetectionPatternsAndSeparators(paramByteMatrix);
    embedDarkDotAtLeftBottomCorner(paramByteMatrix);
    maybeEmbedPositionAdjustmentPatterns(paramVersion, paramByteMatrix);
    embedTimingPatterns(paramByteMatrix);
  }
  
  private static void embedDarkDotAtLeftBottomCorner(ByteMatrix paramByteMatrix) throws WriterException {
    if (paramByteMatrix.get(8, paramByteMatrix.getHeight() - 8) != 0) {
      paramByteMatrix.set(8, paramByteMatrix.getHeight() - 8, 1);
      return;
    } 
    throw new WriterException();
  }
  
  static void embedDataBits(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix) throws WriterException {
    int i = paramByteMatrix.getWidth() - 1;
    int j = paramByteMatrix.getHeight() - 1;
    int k = 0;
    byte b = -1;
    while (i > 0) {
      int m = i;
      int n = k;
      int i1 = j;
      if (i == 6) {
        m = i - 1;
        i1 = j;
        n = k;
      } 
      while (i1 >= 0 && i1 < paramByteMatrix.getHeight()) {
        j = 0;
        while (j < 2) {
          k = m - j;
          i = n;
          if (isEmpty(paramByteMatrix.get(k, i1))) {
            boolean bool1;
            if (n < paramBitArray.getSize()) {
              bool1 = paramBitArray.get(n);
              n++;
            } else {
              bool1 = false;
            } 
            boolean bool2 = bool1;
            if (paramInt != -1) {
              bool2 = bool1;
              if (MaskUtil.getDataMaskBit(paramInt, k, i1))
                if (!bool1) {
                  bool2 = true;
                } else {
                  bool2 = false;
                }  
            } 
            paramByteMatrix.set(k, i1, bool2);
            i = n;
          } 
          j++;
          n = i;
        } 
        i1 += b;
      } 
      b = -b;
      j = i1 + b;
      i = m - 2;
      k = n;
    } 
    if (k == paramBitArray.getSize())
      return; 
    StringBuilder stringBuilder = new StringBuilder("Not all bits consumed: ");
    stringBuilder.append(k);
    stringBuilder.append('/');
    stringBuilder.append(paramBitArray.getSize());
    throw new WriterException(stringBuilder.toString());
  }
  
  private static void embedHorizontalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix) throws WriterException {
    byte b = 0;
    while (b < 8) {
      int i = paramInt1 + b;
      if (isEmpty(paramByteMatrix.get(i, paramInt2))) {
        paramByteMatrix.set(i, paramInt2, 0);
        b++;
        continue;
      } 
      throw new WriterException();
    } 
  }
  
  private static void embedPositionAdjustmentPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix) {
    for (byte b = 0; b < 5; b++) {
      int[] arrayOfInt = POSITION_ADJUSTMENT_PATTERN[b];
      for (byte b1 = 0; b1 < 5; b1++)
        paramByteMatrix.set(paramInt1 + b1, paramInt2 + b, arrayOfInt[b1]); 
    } 
  }
  
  private static void embedPositionDetectionPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix) {
    for (byte b = 0; b < 7; b++) {
      int[] arrayOfInt = POSITION_DETECTION_PATTERN[b];
      for (byte b1 = 0; b1 < 7; b1++)
        paramByteMatrix.set(paramInt1 + b1, paramInt2 + b, arrayOfInt[b1]); 
    } 
  }
  
  private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix paramByteMatrix) throws WriterException {
    int i = (POSITION_DETECTION_PATTERN[0]).length;
    embedPositionDetectionPattern(0, 0, paramByteMatrix);
    embedPositionDetectionPattern(paramByteMatrix.getWidth() - i, 0, paramByteMatrix);
    embedPositionDetectionPattern(0, paramByteMatrix.getWidth() - i, paramByteMatrix);
    embedHorizontalSeparationPattern(0, 7, paramByteMatrix);
    embedHorizontalSeparationPattern(paramByteMatrix.getWidth() - 8, 7, paramByteMatrix);
    embedHorizontalSeparationPattern(0, paramByteMatrix.getWidth() - 8, paramByteMatrix);
    embedVerticalSeparationPattern(7, 0, paramByteMatrix);
    embedVerticalSeparationPattern(paramByteMatrix.getHeight() - 7 - 1, 0, paramByteMatrix);
    embedVerticalSeparationPattern(7, paramByteMatrix.getHeight() - 7, paramByteMatrix);
  }
  
  private static void embedTimingPatterns(ByteMatrix paramByteMatrix) {
    for (int i = 8; i < paramByteMatrix.getWidth() - 8; i = j) {
      int j = i + 1;
      int k = j % 2;
      if (isEmpty(paramByteMatrix.get(i, 6)))
        paramByteMatrix.set(i, 6, k); 
      if (isEmpty(paramByteMatrix.get(6, i)))
        paramByteMatrix.set(6, i, k); 
    } 
  }
  
  static void embedTypeInfo(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix) throws WriterException {
    BitArray bitArray = new BitArray();
    makeTypeInfoBits(paramErrorCorrectionLevel, paramInt, bitArray);
    for (paramInt = 0; paramInt < bitArray.getSize(); paramInt++) {
      boolean bool = bitArray.get(bitArray.getSize() - 1 - paramInt);
      int[] arrayOfInt = TYPE_INFO_COORDINATES[paramInt];
      paramByteMatrix.set(arrayOfInt[0], arrayOfInt[1], bool);
      if (paramInt < 8) {
        paramByteMatrix.set(paramByteMatrix.getWidth() - paramInt - 1, 8, bool);
      } else {
        paramByteMatrix.set(8, paramByteMatrix.getHeight() - 7 + paramInt - 8, bool);
      } 
    } 
  }
  
  private static void embedVerticalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix) throws WriterException {
    byte b = 0;
    while (b < 7) {
      int i = paramInt2 + b;
      if (isEmpty(paramByteMatrix.get(paramInt1, i))) {
        paramByteMatrix.set(paramInt1, i, 0);
        b++;
        continue;
      } 
      throw new WriterException();
    } 
  }
  
  static int findMSBSet(int paramInt) {
    return 32 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  private static boolean isEmpty(int paramInt) {
    return (paramInt == -1);
  }
  
  static void makeTypeInfoBits(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray) throws WriterException {
    if (QRCode.isValidMaskPattern(paramInt)) {
      paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
      paramBitArray.appendBits(paramInt, 5);
      paramBitArray.appendBits(calculateBCHCode(paramInt, 1335), 10);
      BitArray bitArray = new BitArray();
      bitArray.appendBits(21522, 15);
      paramBitArray.xor(bitArray);
      if (paramBitArray.getSize() == 15)
        return; 
      StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
      stringBuilder.append(paramBitArray.getSize());
      throw new WriterException(stringBuilder.toString());
    } 
    throw new WriterException("Invalid mask pattern");
  }
  
  static void makeVersionInfoBits(Version paramVersion, BitArray paramBitArray) throws WriterException {
    paramBitArray.appendBits(paramVersion.getVersionNumber(), 6);
    paramBitArray.appendBits(calculateBCHCode(paramVersion.getVersionNumber(), 7973), 12);
    if (paramBitArray.getSize() == 18)
      return; 
    StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
    stringBuilder.append(paramBitArray.getSize());
    throw new WriterException(stringBuilder.toString());
  }
  
  private static void maybeEmbedPositionAdjustmentPatterns(Version paramVersion, ByteMatrix paramByteMatrix) {
    if (paramVersion.getVersionNumber() < 2)
      return; 
    null = paramVersion.getVersionNumber();
    for (int i : POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[null - 1]) {
      if (i >= 0) {
        int j = null.length;
        for (byte b = 0; b < j; b++) {
          int k = null[b];
          if (k >= 0 && isEmpty(paramByteMatrix.get(k, i)))
            embedPositionAdjustmentPattern(k - 2, i - 2, paramByteMatrix); 
        } 
      } 
    } 
  }
  
  static void maybeEmbedVersionInfo(Version paramVersion, ByteMatrix paramByteMatrix) throws WriterException {
    if (paramVersion.getVersionNumber() < 7)
      return; 
    BitArray bitArray = new BitArray();
    makeVersionInfoBits(paramVersion, bitArray);
    byte b1 = 0;
    byte b2 = 17;
    while (b1 < 6) {
      for (byte b = 0; b < 3; b++) {
        boolean bool = bitArray.get(b2);
        b2--;
        paramByteMatrix.set(b1, paramByteMatrix.getHeight() - 11 + b, bool);
        paramByteMatrix.set(paramByteMatrix.getHeight() - 11 + b, b1, bool);
      } 
      b1++;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\encoder\MatrixUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */