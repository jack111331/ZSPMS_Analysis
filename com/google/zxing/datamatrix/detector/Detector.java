package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Detector {
  private final BitMatrix image;
  
  private final WhiteRectangleDetector rectangleDetector;
  
  public Detector(BitMatrix paramBitMatrix) throws NotFoundException {
    this.image = paramBitMatrix;
    this.rectangleDetector = new WhiteRectangleDetector(paramBitMatrix);
  }
  
  private ResultPoint correctTopRight(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt) {
    float f1 = distance(paramResultPoint1, paramResultPoint2);
    float f2 = paramInt;
    f1 /= f2;
    paramInt = distance(paramResultPoint3, paramResultPoint4);
    float f3 = paramResultPoint4.getX();
    float f4 = paramResultPoint3.getX();
    float f5 = paramInt;
    f4 = (f3 - f4) / f5;
    f5 = (paramResultPoint4.getY() - paramResultPoint3.getY()) / f5;
    ResultPoint resultPoint = new ResultPoint(paramResultPoint4.getX() + f4 * f1, paramResultPoint4.getY() + f1 * f5);
    f2 = distance(paramResultPoint1, paramResultPoint3) / f2;
    paramInt = distance(paramResultPoint2, paramResultPoint4);
    f5 = paramResultPoint4.getX();
    f4 = paramResultPoint2.getX();
    f1 = paramInt;
    f5 = (f5 - f4) / f1;
    f1 = (paramResultPoint4.getY() - paramResultPoint2.getY()) / f1;
    paramResultPoint1 = new ResultPoint(paramResultPoint4.getX() + f5 * f2, paramResultPoint4.getY() + f2 * f1);
    return !isValid(resultPoint) ? (isValid(paramResultPoint1) ? paramResultPoint1 : null) : (!isValid(paramResultPoint1) ? resultPoint : ((Math.abs(transitionsBetween(paramResultPoint3, resultPoint).getTransitions() - transitionsBetween(paramResultPoint2, resultPoint).getTransitions()) <= Math.abs(transitionsBetween(paramResultPoint3, paramResultPoint1).getTransitions() - transitionsBetween(paramResultPoint2, paramResultPoint1).getTransitions())) ? resultPoint : paramResultPoint1));
  }
  
  private ResultPoint correctTopRightRectangular(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2) {
    float f1 = distance(paramResultPoint1, paramResultPoint2) / paramInt1;
    int i = distance(paramResultPoint3, paramResultPoint4);
    float f2 = paramResultPoint4.getX();
    float f3 = paramResultPoint3.getX();
    float f4 = i;
    f3 = (f2 - f3) / f4;
    f4 = (paramResultPoint4.getY() - paramResultPoint3.getY()) / f4;
    ResultPoint resultPoint = new ResultPoint(paramResultPoint4.getX() + f3 * f1, paramResultPoint4.getY() + f1 * f4);
    f1 = distance(paramResultPoint1, paramResultPoint3) / paramInt2;
    i = distance(paramResultPoint2, paramResultPoint4);
    f3 = paramResultPoint4.getX();
    f2 = paramResultPoint2.getX();
    f4 = i;
    f3 = (f3 - f2) / f4;
    f4 = (paramResultPoint4.getY() - paramResultPoint2.getY()) / f4;
    paramResultPoint1 = new ResultPoint(paramResultPoint4.getX() + f3 * f1, paramResultPoint4.getY() + f1 * f4);
    return !isValid(resultPoint) ? (isValid(paramResultPoint1) ? paramResultPoint1 : null) : (!isValid(paramResultPoint1) ? resultPoint : ((Math.abs(paramInt1 - transitionsBetween(paramResultPoint3, resultPoint).getTransitions()) + Math.abs(paramInt2 - transitionsBetween(paramResultPoint2, resultPoint).getTransitions()) <= Math.abs(paramInt1 - transitionsBetween(paramResultPoint3, paramResultPoint1).getTransitions()) + Math.abs(paramInt2 - transitionsBetween(paramResultPoint2, paramResultPoint1).getTransitions())) ? resultPoint : paramResultPoint1));
  }
  
  private static int distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return MathUtils.round(ResultPoint.distance(paramResultPoint1, paramResultPoint2));
  }
  
  private static void increment(Map<ResultPoint, Integer> paramMap, ResultPoint paramResultPoint) {
    Integer integer = paramMap.get(paramResultPoint);
    int i = 1;
    if (integer != null)
      i = 1 + integer.intValue(); 
    paramMap.put(paramResultPoint, Integer.valueOf(i));
  }
  
  private boolean isValid(ResultPoint paramResultPoint) {
    return (paramResultPoint.getX() >= 0.0F && paramResultPoint.getX() < this.image.getWidth() && paramResultPoint.getY() > 0.0F && paramResultPoint.getY() < this.image.getHeight());
  }
  
  private static BitMatrix sampleGrid(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2) throws NotFoundException {
    GridSampler gridSampler = GridSampler.getInstance();
    float f1 = paramInt1 - 0.5F;
    float f2 = paramInt2 - 0.5F;
    return gridSampler.sampleGrid(paramBitMatrix, paramInt1, paramInt2, 0.5F, 0.5F, f1, 0.5F, f1, f2, 0.5F, f2, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint4.getX(), paramResultPoint4.getY(), paramResultPoint3.getX(), paramResultPoint3.getY(), paramResultPoint2.getX(), paramResultPoint2.getY());
  }
  
  private ResultPointsAndTransitions transitionsBetween(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    boolean bool;
    int i = (int)paramResultPoint1.getX();
    int j = (int)paramResultPoint1.getY();
    int k = (int)paramResultPoint2.getX();
    int m = (int)paramResultPoint2.getY();
    int n = Math.abs(m - j);
    int i1 = Math.abs(k - i);
    int i2 = 0;
    byte b = 1;
    if (n > i1) {
      bool = true;
    } else {
      bool = false;
    } 
    i1 = i;
    n = j;
    int i3 = k;
    int i4 = m;
    if (bool) {
      n = i;
      i1 = j;
      i4 = k;
      i3 = m;
    } 
    int i5 = Math.abs(i3 - i1);
    int i6 = Math.abs(i4 - n);
    j = -i5 / 2;
    if (n < i4) {
      i = 1;
    } else {
      i = -1;
    } 
    if (i1 >= i3)
      b = -1; 
    BitMatrix bitMatrix = this.image;
    if (bool) {
      m = n;
    } else {
      m = i1;
    } 
    if (bool) {
      k = i1;
    } else {
      k = n;
    } 
    boolean bool1 = bitMatrix.get(m, k);
    m = i2;
    while (true) {
      i2 = m;
      if (i1 != i3) {
        bitMatrix = this.image;
        if (bool) {
          k = n;
        } else {
          k = i1;
        } 
        if (bool) {
          i2 = i1;
        } else {
          i2 = n;
        } 
        boolean bool2 = bitMatrix.get(k, i2);
        k = m;
        boolean bool3 = bool1;
        if (bool2 != bool1) {
          k = m + 1;
          bool3 = bool2;
        } 
        int i7 = j + i6;
        m = n;
        j = i7;
        if (i7 > 0) {
          i2 = k;
          if (n != i4) {
            m = n + i;
            j = i7 - i5;
          } else {
            break;
          } 
        } 
        i1 += b;
        n = m;
        m = k;
        bool1 = bool3;
        continue;
      } 
      break;
    } 
    return new ResultPointsAndTransitions(paramResultPoint1, paramResultPoint2, i2);
  }
  
  public DetectorResult detect() throws NotFoundException {
    ResultPoint resultPoint5;
    ResultPoint resultPoint7;
    ResultPoint[] arrayOfResultPoint = this.rectangleDetector.detect();
    ResultPoint resultPoint1 = arrayOfResultPoint[0];
    ResultPoint resultPoint2 = arrayOfResultPoint[1];
    ResultPoint resultPoint3 = arrayOfResultPoint[2];
    ResultPoint resultPoint4 = arrayOfResultPoint[3];
    ArrayList<ResultPointsAndTransitions> arrayList = new ArrayList(4);
    arrayList.add(transitionsBetween(resultPoint1, resultPoint2));
    arrayList.add(transitionsBetween(resultPoint1, resultPoint3));
    arrayList.add(transitionsBetween(resultPoint2, resultPoint4));
    arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
    ResultPoint resultPoint6 = null;
    Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
    ResultPointsAndTransitions resultPointsAndTransitions1 = arrayList.get(0);
    ResultPointsAndTransitions resultPointsAndTransitions2 = arrayList.get(1);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    increment((Map)hashMap, resultPointsAndTransitions1.getFrom());
    increment((Map)hashMap, resultPointsAndTransitions1.getTo());
    increment((Map)hashMap, resultPointsAndTransitions2.getFrom());
    increment((Map)hashMap, resultPointsAndTransitions2.getTo());
    Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
    ResultPointsAndTransitions resultPointsAndTransitions3 = null;
    resultPointsAndTransitions2 = resultPointsAndTransitions3;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      ResultPoint resultPoint = (ResultPoint)entry.getKey();
      if (((Integer)entry.getValue()).intValue() == 2) {
        resultPoint7 = resultPoint;
        continue;
      } 
      if (resultPoint6 == null) {
        resultPoint6 = resultPoint;
        continue;
      } 
      resultPoint5 = resultPoint;
    } 
    if (resultPoint6 != null && resultPoint7 != null && resultPoint5 != null) {
      ResultPoint resultPoint8;
      BitMatrix bitMatrix2;
      ResultPoint[] arrayOfResultPoint1 = new ResultPoint[3];
      arrayOfResultPoint1[0] = resultPoint6;
      arrayOfResultPoint1[1] = resultPoint7;
      arrayOfResultPoint1[2] = resultPoint5;
      ResultPoint.orderBestPatterns(arrayOfResultPoint1);
      ResultPoint resultPoint10 = arrayOfResultPoint1[0];
      ResultPoint resultPoint9 = arrayOfResultPoint1[1];
      resultPoint6 = arrayOfResultPoint1[2];
      if (!hashMap.containsKey(resultPoint1)) {
        resultPoint8 = resultPoint1;
      } else if (!hashMap.containsKey(resultPoint2)) {
        resultPoint8 = resultPoint2;
      } else if (!hashMap.containsKey(resultPoint3)) {
        resultPoint8 = resultPoint3;
      } else {
        resultPoint8 = resultPoint4;
      } 
      int i = transitionsBetween(resultPoint6, resultPoint8).getTransitions();
      int j = transitionsBetween(resultPoint10, resultPoint8).getTransitions();
      int k = i;
      if ((i & 0x1) == 1)
        k = i + 1; 
      i = k + 2;
      k = j;
      if ((j & 0x1) == 1)
        k = j + 1; 
      k += 2;
      if (i * 4 >= k * 7 || k * 4 >= i * 7) {
        resultPoint7 = resultPoint6;
        resultPoint2 = correctTopRightRectangular(resultPoint9, resultPoint10, resultPoint6, resultPoint8, i, k);
        resultPoint5 = resultPoint2;
        if (resultPoint2 == null)
          resultPoint5 = resultPoint8; 
        j = transitionsBetween(resultPoint7, resultPoint5).getTransitions();
        i = transitionsBetween(resultPoint10, resultPoint5).getTransitions();
        k = j;
        if ((j & 0x1) == 1)
          k = j + 1; 
        j = i;
        if ((i & 0x1) == 1)
          j = i + 1; 
        bitMatrix1 = sampleGrid(this.image, resultPoint7, resultPoint9, resultPoint10, resultPoint5, k, j);
        return new DetectorResult(bitMatrix1, new ResultPoint[] { resultPoint6, resultPoint9, resultPoint10, resultPoint5 });
      } 
      resultPoint7 = correctTopRight(resultPoint9, resultPoint10, resultPoint6, (ResultPoint)bitMatrix1, Math.min(k, i));
      resultPoint5 = resultPoint7;
      if (resultPoint7 == null)
        bitMatrix2 = bitMatrix1; 
      j = Math.max(transitionsBetween(resultPoint6, (ResultPoint)bitMatrix2).getTransitions(), transitionsBetween(resultPoint10, (ResultPoint)bitMatrix2).getTransitions()) + 1;
      k = j;
      if ((j & 0x1) == 1)
        k = j + 1; 
      BitMatrix bitMatrix1 = sampleGrid(this.image, resultPoint6, resultPoint9, resultPoint10, (ResultPoint)bitMatrix2, k, k);
      return new DetectorResult(bitMatrix1, new ResultPoint[] { resultPoint6, resultPoint9, resultPoint10, (ResultPoint)bitMatrix2 });
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static final class ResultPointsAndTransitions {
    private final ResultPoint from;
    
    private final ResultPoint to;
    
    private final int transitions;
    
    private ResultPointsAndTransitions(ResultPoint param1ResultPoint1, ResultPoint param1ResultPoint2, int param1Int) {
      this.from = param1ResultPoint1;
      this.to = param1ResultPoint2;
      this.transitions = param1Int;
    }
    
    ResultPoint getFrom() {
      return this.from;
    }
    
    ResultPoint getTo() {
      return this.to;
    }
    
    int getTransitions() {
      return this.transitions;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.from);
      stringBuilder.append("/");
      stringBuilder.append(this.to);
      stringBuilder.append('/');
      stringBuilder.append(this.transitions);
      return stringBuilder.toString();
    }
  }
  
  private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
    private ResultPointsAndTransitionsComparator() {}
    
    public int compare(Detector.ResultPointsAndTransitions param1ResultPointsAndTransitions1, Detector.ResultPointsAndTransitions param1ResultPointsAndTransitions2) {
      return param1ResultPointsAndTransitions1.getTransitions() - param1ResultPointsAndTransitions2.getTransitions();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */