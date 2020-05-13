package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

final class MultiFinderPatternFinder extends FinderPatternFinder {
  private static final float DIFF_MODSIZE_CUTOFF = 0.5F;
  
  private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05F;
  
  private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
  
  private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0F;
  
  private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0F;
  
  MultiFinderPatternFinder(BitMatrix paramBitMatrix) {
    super(paramBitMatrix);
  }
  
  MultiFinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback) {
    super(paramBitMatrix, paramResultPointCallback);
  }
  
  private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
    List<FinderPattern> list = getPossibleCenters();
    int i = list.size();
    if (i >= 3) {
      if (i == 3)
        return new FinderPattern[][] { { list.get(0), list.get(1), list.get(2) } }; 
      Collections.sort(list, new ModuleSizeComparator());
      ArrayList<FinderPattern[]> arrayList = new ArrayList();
      for (byte b = 0; b < i - 2; b++) {
        FinderPattern finderPattern = list.get(b);
        if (finderPattern != null)
          for (int j = b + 1; j < i - 1; j++) {
            FinderPattern finderPattern1 = list.get(j);
            if (finderPattern1 != null) {
              float f = (finderPattern.getEstimatedModuleSize() - finderPattern1.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern1.getEstimatedModuleSize());
              if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern1.getEstimatedModuleSize()) <= 0.5F || f < 0.05F) {
                for (int k = j + 1; k < i; k++) {
                  FinderPattern finderPattern2 = list.get(k);
                  if (finderPattern2 != null) {
                    f = (finderPattern1.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern1.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                    if (Math.abs(finderPattern1.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) <= 0.5F || f < 0.05F) {
                      FinderPattern[] arrayOfFinderPattern = new FinderPattern[3];
                      arrayOfFinderPattern[0] = finderPattern;
                      arrayOfFinderPattern[1] = finderPattern1;
                      arrayOfFinderPattern[2] = finderPattern2;
                      ResultPoint.orderBestPatterns((ResultPoint[])arrayOfFinderPattern);
                      FinderPatternInfo finderPatternInfo = new FinderPatternInfo(arrayOfFinderPattern);
                      float f1 = ResultPoint.distance((ResultPoint)finderPatternInfo.getTopLeft(), (ResultPoint)finderPatternInfo.getBottomLeft());
                      f = ResultPoint.distance((ResultPoint)finderPatternInfo.getTopRight(), (ResultPoint)finderPatternInfo.getBottomLeft());
                      float f2 = ResultPoint.distance((ResultPoint)finderPatternInfo.getTopLeft(), (ResultPoint)finderPatternInfo.getTopRight());
                      float f3 = (f1 + f2) / finderPattern.getEstimatedModuleSize() * 2.0F;
                      if (f3 <= 180.0F && f3 >= 9.0F && Math.abs((f1 - f2) / Math.min(f1, f2)) < 0.1F) {
                        f3 = (float)Math.sqrt((f1 * f1 + f2 * f2));
                        if (Math.abs((f - f3) / Math.min(f, f3)) < 0.1F)
                          arrayList.add(arrayOfFinderPattern); 
                      } 
                    } else {
                      break;
                    } 
                  } 
                } 
              } else {
                break;
              } 
            } 
          }  
      } 
      if (!arrayList.isEmpty())
        return arrayList.<FinderPattern[]>toArray(new FinderPattern[arrayList.size()][]); 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    boolean bool = false;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.TRY_HARDER)) {
      i = 1;
    } else {
      i = 0;
    } 
    BitMatrix bitMatrix = getImage();
    int j = bitMatrix.getHeight();
    int k = bitMatrix.getWidth();
    int m = j * 3 / 388;
    if (m < 3 || i)
      m = 3; 
    int[] arrayOfInt = new int[5];
    int n;
    for (n = m - 1; n < j; n += m) {
      clearCounts(arrayOfInt);
      byte b = 0;
      i = 0;
      while (b < k) {
        if (bitMatrix.get(b, n)) {
          int i2 = i;
          if ((i & 0x1) == 1)
            i2 = i + 1; 
          arrayOfInt[i2] = arrayOfInt[i2] + 1;
          i = i2;
        } else if ((i & 0x1) == 0) {
          if (i == 4) {
            if (foundPatternCross(arrayOfInt) && handlePossibleCenter(arrayOfInt, n, b)) {
              clearCounts(arrayOfInt);
              i = 0;
            } else {
              shiftCounts2(arrayOfInt);
              i = 3;
            } 
          } else {
            arrayOfInt[++i] = arrayOfInt[i] + 1;
          } 
        } else {
          arrayOfInt[i] = arrayOfInt[i] + 1;
        } 
        b++;
      } 
      if (foundPatternCross(arrayOfInt))
        handlePossibleCenter(arrayOfInt, n, k); 
    } 
    FinderPattern[][] arrayOfFinderPattern = selectMutipleBestPatterns();
    ArrayList<FinderPatternInfo> arrayList = new ArrayList();
    int i1 = arrayOfFinderPattern.length;
    for (int i = bool; i < i1; i++) {
      FinderPattern[] arrayOfFinderPattern1 = arrayOfFinderPattern[i];
      ResultPoint.orderBestPatterns((ResultPoint[])arrayOfFinderPattern1);
      arrayList.add(new FinderPatternInfo(arrayOfFinderPattern1));
    } 
    return arrayList.isEmpty() ? EMPTY_RESULT_ARRAY : arrayList.<FinderPatternInfo>toArray(new FinderPatternInfo[arrayList.size()]);
  }
  
  private static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
    private ModuleSizeComparator() {}
    
    public int compare(FinderPattern param1FinderPattern1, FinderPattern param1FinderPattern2) {
      double d = (param1FinderPattern2.getEstimatedModuleSize() - param1FinderPattern1.getEstimatedModuleSize());
      return (d < 0.0D) ? -1 : ((d > 0.0D) ? 1 : 0);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\multi\qrcode\detector\MultiFinderPatternFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */