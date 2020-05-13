package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.Dimensions;
import com.google.zxing.pdf417.encoder.PDF417;
import java.nio.charset.Charset;
import java.util.Map;

public final class PDF417Writer implements Writer {
  private static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
  
  private static final int WHITE_SPACE = 30;
  
  private static BitMatrix bitMatrixFromBitArray(byte[][] paramArrayOfbyte, int paramInt) {
    int i = (paramArrayOfbyte[0]).length;
    int j = paramInt * 2;
    BitMatrix bitMatrix = new BitMatrix(i + j, paramArrayOfbyte.length + j);
    bitMatrix.clear();
    i = bitMatrix.getHeight() - paramInt - 1;
    j = 0;
    while (j < paramArrayOfbyte.length) {
      byte[] arrayOfByte = paramArrayOfbyte[j];
      for (byte b = 0; b < (paramArrayOfbyte[0]).length; b++) {
        if (arrayOfByte[b] == 1)
          bitMatrix.set(b + paramInt, i); 
      } 
      j++;
      i--;
    } 
    return bitMatrix;
  }
  
  private static BitMatrix bitMatrixFromEncoder(PDF417 paramPDF417, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws WriterException {
    byte b;
    paramPDF417.generateBarcodeLogic(paramString, paramInt1);
    byte[][] arrayOfByte = paramPDF417.getBarcodeMatrix().getScaledMatrix(1, 4);
    if (paramInt3 > paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    if ((arrayOfByte[0]).length < arrayOfByte.length) {
      b = 1;
    } else {
      b = 0;
    } 
    if (paramInt1 != b) {
      arrayOfByte = rotateArray(arrayOfByte);
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    paramInt2 /= (arrayOfByte[0]).length;
    paramInt3 /= arrayOfByte.length;
    if (paramInt2 >= paramInt3)
      paramInt2 = paramInt3; 
    if (paramInt2 > 1) {
      arrayOfByte = paramPDF417.getBarcodeMatrix().getScaledMatrix(paramInt2, paramInt2 << 2);
      byte[][] arrayOfByte1 = arrayOfByte;
      if (paramInt1 != 0)
        arrayOfByte1 = rotateArray(arrayOfByte); 
      return bitMatrixFromBitArray(arrayOfByte1, paramInt4);
    } 
    return bitMatrixFromBitArray(arrayOfByte, paramInt4);
  }
  
  private static byte[][] rotateArray(byte[][] paramArrayOfbyte) {
    byte[][] arrayOfByte = new byte[(paramArrayOfbyte[0]).length][paramArrayOfbyte.length];
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      int i = paramArrayOfbyte.length;
      for (byte b1 = 0; b1 < (paramArrayOfbyte[0]).length; b1++)
        arrayOfByte[b1][i - b - 1] = (byte)paramArrayOfbyte[b][b1]; 
    } 
    return arrayOfByte;
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) throws WriterException {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    Dimensions dimensions;
    if (paramBarcodeFormat == BarcodeFormat.PDF_417) {
      PDF417 pDF417 = new PDF417();
      int i = 30;
      int j = 2;
      if (paramMap != null) {
        if (paramMap.containsKey(EncodeHintType.PDF417_COMPACT))
          pDF417.setCompact(Boolean.valueOf(paramMap.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue()); 
        if (paramMap.containsKey(EncodeHintType.PDF417_COMPACTION))
          pDF417.setCompaction(Compaction.valueOf(paramMap.get(EncodeHintType.PDF417_COMPACTION).toString())); 
        if (paramMap.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
          dimensions = (Dimensions)paramMap.get(EncodeHintType.PDF417_DIMENSIONS);
          pDF417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
        } 
        if (paramMap.containsKey(EncodeHintType.MARGIN))
          i = Integer.parseInt(paramMap.get(EncodeHintType.MARGIN).toString()); 
        if (paramMap.containsKey(EncodeHintType.ERROR_CORRECTION))
          j = Integer.parseInt(paramMap.get(EncodeHintType.ERROR_CORRECTION).toString()); 
        if (paramMap.containsKey(EncodeHintType.CHARACTER_SET))
          pDF417.setEncoding(Charset.forName(paramMap.get(EncodeHintType.CHARACTER_SET).toString())); 
      } else {
        j = 2;
        i = 30;
      } 
      return bitMatrixFromEncoder(pDF417, paramString, j, paramInt1, paramInt2, i);
    } 
    throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(dimensions)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\PDF417Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */