package com.google.zxing.aztec;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.Map;

public final class AztecReader implements Reader {
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, FormatException {
    return decode(paramBinaryBitmap, null);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    Detector detector = new Detector(paramBinaryBitmap.getBlackMatrix());
    boolean bool = false;
    DecoderResult decoderResult = null;
    try {
      AztecDetectorResult aztecDetectorResult = detector.detect(false);
      ResultPoint[] arrayOfResultPoint = aztecDetectorResult.getPoints();
      try {
        Decoder decoder2 = new Decoder();
        this();
        DecoderResult decoderResult1 = decoder2.decode(aztecDetectorResult);
        decoder2 = null;
        decoderResult = decoderResult1;
        Decoder decoder1 = decoder2;
      } catch (NotFoundException notFoundException) {
        Object object1 = null;
      } catch (FormatException formatException) {}
    } catch (NotFoundException notFoundException) {
      paramBinaryBitmap = null;
    } catch (FormatException formatException1) {
      paramBinaryBitmap = null;
      FormatException formatException2 = formatException1;
      formatException1 = null;
    } 
    Object object = null;
  }
  
  public void reset() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\AztecReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */