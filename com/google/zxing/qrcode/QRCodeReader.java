package com.google.zxing.qrcode;

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
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader implements Reader {
  private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
  
  private final Decoder decoder = new Decoder();
  
  private static BitMatrix extractPureBits(BitMatrix paramBitMatrix) throws NotFoundException {
    int[] arrayOfInt1 = paramBitMatrix.getTopLeftOnBit();
    int[] arrayOfInt2 = paramBitMatrix.getBottomRightOnBit();
    if (arrayOfInt1 != null && arrayOfInt2 != null) {
      float f = moduleSize(arrayOfInt1, paramBitMatrix);
      int i = arrayOfInt1[1];
      int j = arrayOfInt2[1];
      int k = arrayOfInt1[0];
      int m = arrayOfInt2[0];
      if (k < m && i < j) {
        int n = j - i;
        int i1 = m;
        if (n != m - k) {
          i1 = k + n;
          if (i1 >= paramBitMatrix.getWidth())
            throw NotFoundException.getNotFoundInstance(); 
        } 
        int i2 = Math.round((i1 - k + 1) / f);
        n = Math.round((n + 1) / f);
        if (i2 > 0 && n > 0) {
          if (n == i2) {
            int i3 = (int)(f / 2.0F);
            i += i3;
            m = k + i3;
            k = (int)((i2 - 1) * f) + m - i1;
            i1 = m;
            if (k > 0)
              if (k <= i3) {
                i1 = m - k;
              } else {
                throw NotFoundException.getNotFoundInstance();
              }  
            j = (int)((n - 1) * f) + i - j;
            m = i;
            if (j > 0)
              if (j <= i3) {
                m = i - j;
              } else {
                throw NotFoundException.getNotFoundInstance();
              }  
            BitMatrix bitMatrix = new BitMatrix(i2, n);
            for (i = 0; i < n; i++) {
              i3 = (int)(i * f);
              for (j = 0; j < i2; j++) {
                if (paramBitMatrix.get((int)(j * f) + i1, i3 + m))
                  bitMatrix.set(j, i); 
              } 
            } 
            return bitMatrix;
          } 
          throw NotFoundException.getNotFoundInstance();
        } 
        throw NotFoundException.getNotFoundInstance();
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static float moduleSize(int[] paramArrayOfint, BitMatrix paramBitMatrix) throws NotFoundException {
    int i = paramBitMatrix.getHeight();
    int j = paramBitMatrix.getWidth();
    int k = paramArrayOfint[0];
    boolean bool = true;
    int m = paramArrayOfint[1];
    int n;
    for (n = 0; k < j && m < i; n = i3) {
      int i2;
      boolean bool1 = bool;
      int i3 = n;
      if (bool != paramBitMatrix.get(k, m)) {
        i3 = n + 1;
        if (i3 != 5) {
          i2 = bool ^ true;
        } else {
          break;
        } 
      } 
      k++;
      m++;
      int i1 = i2;
    } 
    if (k != j && m != i)
      return (k - paramArrayOfint[0]) / 7.0F; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, ChecksumException, FormatException {
    return decode(paramBinaryBitmap, null);
  }
  
  public final Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    DecoderResult decoderResult;
    ResultPoint[] arrayOfResultPoint;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.PURE_BARCODE)) {
      BitMatrix bitMatrix = extractPureBits(paramBinaryBitmap.getBlackMatrix());
      decoderResult = this.decoder.decode(bitMatrix, paramMap);
      arrayOfResultPoint = NO_POINTS;
    } else {
      DetectorResult detectorResult = (new Detector(decoderResult.getBlackMatrix())).detect((Map)arrayOfResultPoint);
      decoderResult = this.decoder.decode(detectorResult.getBits(), (Map)arrayOfResultPoint);
      arrayOfResultPoint = detectorResult.getPoints();
    } 
    if (decoderResult.getOther() instanceof QRCodeDecoderMetaData)
      ((QRCodeDecoderMetaData)decoderResult.getOther()).applyMirroredCorrection(arrayOfResultPoint); 
    Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.QR_CODE);
    List list = decoderResult.getByteSegments();
    if (list != null)
      result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, list); 
    String str = decoderResult.getECLevel();
    if (str != null)
      result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str); 
    if (decoderResult.hasStructuredAppend()) {
      result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResult.getStructuredAppendSequenceNumber()));
      result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResult.getStructuredAppendParity()));
    } 
    return result;
  }
  
  protected final Decoder getDecoder() {
    return this.decoder;
  }
  
  public void reset() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\QRCodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */