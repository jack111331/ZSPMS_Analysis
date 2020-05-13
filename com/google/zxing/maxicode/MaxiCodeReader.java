package com.google.zxing.maxicode;

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
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;

public final class MaxiCodeReader implements Reader {
  private static final int MATRIX_HEIGHT = 33;
  
  private static final int MATRIX_WIDTH = 30;
  
  private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
  
  private final Decoder decoder = new Decoder();
  
  private static BitMatrix extractPureBits(BitMatrix paramBitMatrix) throws NotFoundException {
    int[] arrayOfInt = paramBitMatrix.getEnclosingRectangle();
    if (arrayOfInt != null) {
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      int k = arrayOfInt[2];
      int m = arrayOfInt[3];
      BitMatrix bitMatrix = new BitMatrix(30, 33);
      for (byte b = 0; b < 33; b++) {
        int n = (b * m + m / 2) / 33;
        for (byte b1 = 0; b1 < 30; b1++) {
          if (paramBitMatrix.get((b1 * k + k / 2 + (b & 0x1) * k / 2) / 30 + i, n + j))
            bitMatrix.set(b1, b); 
        } 
      } 
      return bitMatrix;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, ChecksumException, FormatException {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    if (paramMap != null && paramMap.containsKey(DecodeHintType.PURE_BARCODE)) {
      BitMatrix bitMatrix = extractPureBits(paramBinaryBitmap.getBlackMatrix());
      DecoderResult decoderResult = this.decoder.decode(bitMatrix, paramMap);
      Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), NO_POINTS, BarcodeFormat.MAXICODE);
      String str = decoderResult.getECLevel();
      if (str != null)
        result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str); 
      return result;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\maxicode\MaxiCodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */