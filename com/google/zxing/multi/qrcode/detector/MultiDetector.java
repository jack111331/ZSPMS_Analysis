package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.detector.Detector;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Map;

public final class MultiDetector extends Detector {
  private static final DetectorResult[] EMPTY_DETECTOR_RESULTS = new DetectorResult[0];
  
  public MultiDetector(BitMatrix paramBitMatrix) {
    super(paramBitMatrix);
  }
  
  public DetectorResult[] detectMulti(Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    ResultPointCallback resultPointCallback;
    BitMatrix bitMatrix = getImage();
    if (paramMap == null) {
      resultPointCallback = null;
    } else {
      resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
    } 
    FinderPatternInfo[] arrayOfFinderPatternInfo = (new MultiFinderPatternFinder(bitMatrix, resultPointCallback)).findMulti(paramMap);
    if (arrayOfFinderPatternInfo.length != 0) {
      ArrayList<DetectorResult> arrayList = new ArrayList();
      int i = arrayOfFinderPatternInfo.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          FinderPatternInfo finderPatternInfo = arrayOfFinderPatternInfo[b];
          try {
            arrayList.add(processFinderPatternInfo(finderPatternInfo));
          } catch (ReaderException readerException) {}
          b++;
          continue;
        } 
        return arrayList.isEmpty() ? EMPTY_DETECTOR_RESULTS : arrayList.<DetectorResult>toArray(new DetectorResult[arrayList.size()]);
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\multi\qrcode\detector\MultiDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */