package com.google.zxing.pdf417;

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
import com.google.zxing.common.DecoderResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Map;

public final class PDF417Reader implements Reader, MultipleBarcodeReader {
  private static Result[] decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean) throws NotFoundException, FormatException, ChecksumException {
    ArrayList<Result> arrayList = new ArrayList();
    PDF417DetectorResult pDF417DetectorResult = Detector.detect(paramBinaryBitmap, paramMap, paramBoolean);
    for (ResultPoint[] arrayOfResultPoint : pDF417DetectorResult.getPoints()) {
      DecoderResult decoderResult = PDF417ScanningDecoder.decode(pDF417DetectorResult.getBits(), arrayOfResultPoint[4], arrayOfResultPoint[5], arrayOfResultPoint[6], arrayOfResultPoint[7], getMinCodewordWidth(arrayOfResultPoint), getMaxCodewordWidth(arrayOfResultPoint));
      Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.PDF_417);
      result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decoderResult.getECLevel());
      PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata)decoderResult.getOther();
      if (pDF417ResultMetadata != null)
        result.putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata); 
      arrayList.add(result);
    } 
    return arrayList.<Result>toArray(new Result[arrayList.size()]);
  }
  
  private static int getMaxCodewordWidth(ResultPoint[] paramArrayOfResultPoint) {
    return Math.max(Math.max(getMaxWidth(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), getMaxWidth(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) * 17 / 18), Math.max(getMaxWidth(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), getMaxWidth(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) * 17 / 18));
  }
  
  private static int getMaxWidth(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return (paramResultPoint1 == null || paramResultPoint2 == null) ? 0 : (int)Math.abs(paramResultPoint1.getX() - paramResultPoint2.getX());
  }
  
  private static int getMinCodewordWidth(ResultPoint[] paramArrayOfResultPoint) {
    return Math.min(Math.min(getMinWidth(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), getMinWidth(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) * 17 / 18), Math.min(getMinWidth(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), getMinWidth(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) * 17 / 18));
  }
  
  private static int getMinWidth(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return (paramResultPoint1 == null || paramResultPoint2 == null) ? Integer.MAX_VALUE : (int)Math.abs(paramResultPoint1.getX() - paramResultPoint2.getX());
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, FormatException, ChecksumException {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    Result[] arrayOfResult = decode(paramBinaryBitmap, paramMap, false);
    if (arrayOfResult != null && arrayOfResult.length != 0 && arrayOfResult[0] != null)
      return arrayOfResult[0]; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    return decodeMultiple(paramBinaryBitmap, null);
  }
  
  public Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    try {
      return decode(paramBinaryBitmap, paramMap, true);
    } catch (FormatException|ChecksumException formatException) {
      throw NotFoundException.getNotFoundInstance();
    } 
  }
  
  public void reset() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\PDF417Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */