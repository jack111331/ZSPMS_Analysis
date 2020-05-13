package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

public final class DataMatrixReader implements Reader {
  private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
  
  private final Decoder decoder = new Decoder();
  
  private static BitMatrix extractPureBits(BitMatrix paramBitMatrix) throws NotFoundException {
    int[] arrayOfInt1 = paramBitMatrix.getTopLeftOnBit();
    int[] arrayOfInt2 = paramBitMatrix.getBottomRightOnBit();
    if (arrayOfInt1 != null && arrayOfInt2 != null) {
      int i = moduleSize(arrayOfInt1, paramBitMatrix);
      int j = arrayOfInt1[1];
      int k = arrayOfInt2[1];
      int m = arrayOfInt1[0];
      int n = (arrayOfInt2[0] - m + 1) / i;
      int i1 = (k - j + 1) / i;
      if (n > 0 && i1 > 0) {
        int i2 = i / 2;
        BitMatrix bitMatrix = new BitMatrix(n, i1);
        for (k = 0; k < i1; k++) {
          for (byte b = 0; b < n; b++) {
            if (paramBitMatrix.get(b * i + m + i2, k * i + j + i2))
              bitMatrix.set(b, k); 
          } 
        } 
        return bitMatrix;
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int moduleSize(int[] paramArrayOfint, BitMatrix paramBitMatrix) throws NotFoundException {
    int i = paramBitMatrix.getWidth();
    int j = paramArrayOfint[0];
    int k = paramArrayOfint[1];
    while (j < i && paramBitMatrix.get(j, k))
      j++; 
    if (j != i) {
      j -= paramArrayOfint[0];
      if (j != 0)
        return j; 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, ChecksumException, FormatException {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    DecoderResult decoderResult;
    ResultPoint[] arrayOfResultPoint;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.PURE_BARCODE)) {
      BitMatrix bitMatrix = extractPureBits(paramBinaryBitmap.getBlackMatrix());
      decoderResult = this.decoder.decode(bitMatrix);
      arrayOfResultPoint = NO_POINTS;
    } else {
      DetectorResult detectorResult = (new Detector(decoderResult.getBlackMatrix())).detect();
      decoderResult = this.decoder.decode(detectorResult.getBits());
      arrayOfResultPoint = detectorResult.getPoints();
    } 
    Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.DATA_MATRIX);
    List list = decoderResult.getByteSegments();
    if (list != null)
      result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list); 
    String str = decoderResult.getECLevel();
    if (str != null)
      result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str); 
    return result;
  }
  
  public void reset() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\DataMatrixReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */