package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector {
  private final BitMatrix image;
  
  private ResultPointCallback resultPointCallback;
  
  public Detector(BitMatrix paramBitMatrix) {
    this.image = paramBitMatrix;
  }
  
  private float calculateModuleSizeOneWay(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    float f1 = sizeOfBlackWhiteBlackRunBothWays((int)paramResultPoint1.getX(), (int)paramResultPoint1.getY(), (int)paramResultPoint2.getX(), (int)paramResultPoint2.getY());
    float f2 = sizeOfBlackWhiteBlackRunBothWays((int)paramResultPoint2.getX(), (int)paramResultPoint2.getY(), (int)paramResultPoint1.getX(), (int)paramResultPoint1.getY());
    return Float.isNaN(f1) ? (f2 / 7.0F) : (Float.isNaN(f2) ? (f1 / 7.0F) : ((f1 + f2) / 14.0F));
  }
  
  private static int computeDimension(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, float paramFloat) throws NotFoundException {
    int i = (MathUtils.round(ResultPoint.distance(paramResultPoint1, paramResultPoint2) / paramFloat) + MathUtils.round(ResultPoint.distance(paramResultPoint1, paramResultPoint3) / paramFloat)) / 2 + 7;
    int j = i & 0x3;
    if (j != 0) {
      switch (j) {
        default:
          return i;
        case 3:
          throw NotFoundException.getNotFoundInstance();
        case 2:
          break;
      } 
      i--;
    } 
    i++;
  }
  
  private static PerspectiveTransform createTransform(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt) {
    float f2;
    float f3;
    float f4;
    float f1 = paramInt - 3.5F;
    if (paramResultPoint4 != null) {
      f2 = paramResultPoint4.getX();
      f3 = paramResultPoint4.getY();
      f4 = f1 - 3.0F;
    } else {
      f2 = paramResultPoint2.getX();
      float f5 = paramResultPoint1.getX();
      float f6 = paramResultPoint3.getX();
      float f7 = paramResultPoint2.getY();
      f3 = paramResultPoint1.getY();
      f4 = paramResultPoint3.getY();
      f2 = f2 - f5 + f6;
      f3 = f7 - f3 + f4;
      f4 = f1;
    } 
    return PerspectiveTransform.quadrilateralToQuadrilateral(3.5F, 3.5F, f1, 3.5F, f4, f4, 3.5F, f1, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY(), f2, f3, paramResultPoint3.getX(), paramResultPoint3.getY());
  }
  
  private static BitMatrix sampleGrid(BitMatrix paramBitMatrix, PerspectiveTransform paramPerspectiveTransform, int paramInt) throws NotFoundException {
    return GridSampler.getInstance().sampleGrid(paramBitMatrix, paramInt, paramInt, paramPerspectiveTransform);
  }
  
  private float sizeOfBlackWhiteBlackRun(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i;
    int k;
    byte b2;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      int i4 = paramInt1;
      k = paramInt3;
      paramInt1 = paramInt4;
      paramInt4 = paramInt2;
      paramInt3 = i4;
    } else {
      int i4 = paramInt1;
      paramInt1 = paramInt3;
      k = paramInt4;
      paramInt3 = paramInt2;
      paramInt4 = i4;
    } 
    int m = Math.abs(paramInt1 - paramInt4);
    int n = Math.abs(k - paramInt3);
    int i1 = -m / 2;
    byte b1 = -1;
    if (paramInt4 < paramInt1) {
      b2 = 1;
    } else {
      b2 = -1;
    } 
    if (paramInt3 < k)
      b1 = 1; 
    int i2 = paramInt1 + b2;
    paramInt2 = paramInt3;
    int j = 0;
    paramInt1 = paramInt4;
    int i3 = i;
    while (paramInt1 != i2) {
      int i5;
      boolean bool;
      if (i3) {
        i4 = paramInt2;
      } else {
        i4 = paramInt1;
      } 
      if (i3) {
        i5 = paramInt1;
      } else {
        i5 = paramInt2;
      } 
      if (j == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      i = j;
      if (bool == this.image.get(i4, i5)) {
        if (j == 2)
          return MathUtils.distance(paramInt1, paramInt2, paramInt4, paramInt3); 
        i = j + 1;
      } 
      int i4 = i1 + n;
      j = paramInt2;
      i1 = i4;
      if (i4 > 0) {
        j = i;
        if (paramInt2 != k) {
          j = paramInt2 + b1;
          i1 = i4 - m;
        } else {
          break;
        } 
      } 
      paramInt1 += b2;
      paramInt2 = j;
      j = i;
    } 
    return (j == 2) ? MathUtils.distance(i2, k, paramInt4, paramInt3) : Float.NaN;
  }
  
  private float sizeOfBlackWhiteBlackRunBothWays(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f2;
    float f1 = sizeOfBlackWhiteBlackRun(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = paramInt1 - paramInt3 - paramInt1;
    boolean bool = false;
    if (paramInt3 < 0) {
      f2 = paramInt1 / (paramInt1 - paramInt3);
      paramInt3 = 0;
    } else if (paramInt3 >= this.image.getWidth()) {
      f2 = (this.image.getWidth() - 1 - paramInt1) / (paramInt3 - paramInt1);
      paramInt3 = this.image.getWidth() - 1;
    } else {
      f2 = 1.0F;
    } 
    float f3 = paramInt2;
    paramInt4 = (int)(f3 - (paramInt4 - paramInt2) * f2);
    if (paramInt4 < 0) {
      f2 = f3 / (paramInt2 - paramInt4);
      paramInt4 = bool;
    } else if (paramInt4 >= this.image.getHeight()) {
      f2 = (this.image.getHeight() - 1 - paramInt2) / (paramInt4 - paramInt2);
      paramInt4 = this.image.getHeight() - 1;
    } else {
      f2 = 1.0F;
    } 
    return f1 + sizeOfBlackWhiteBlackRun(paramInt1, paramInt2, (int)(paramInt1 + (paramInt3 - paramInt1) * f2), paramInt4) - 1.0F;
  }
  
  protected final float calculateModuleSize(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3) {
    return (calculateModuleSizeOneWay(paramResultPoint1, paramResultPoint2) + calculateModuleSizeOneWay(paramResultPoint1, paramResultPoint3)) / 2.0F;
  }
  
  public DetectorResult detect() throws NotFoundException, FormatException {
    return detect(null);
  }
  
  public final DetectorResult detect(Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    ResultPointCallback resultPointCallback;
    if (paramMap == null) {
      resultPointCallback = null;
    } else {
      resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
    } 
    this.resultPointCallback = resultPointCallback;
    return processFinderPatternInfo((new FinderPatternFinder(this.image, this.resultPointCallback)).find(paramMap));
  }
  
  protected final AlignmentPattern findAlignmentInRegion(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2) throws NotFoundException {
    int i = (int)(paramFloat2 * paramFloat1);
    int j = Math.max(0, paramInt1 - i);
    int k = Math.min(this.image.getWidth() - 1, paramInt1 + i) - j;
    paramFloat2 = k;
    float f = 3.0F * paramFloat1;
    if (paramFloat2 >= f) {
      paramInt1 = Math.max(0, paramInt2 - i);
      paramInt2 = Math.min(this.image.getHeight() - 1, paramInt2 + i) - paramInt1;
      if (paramInt2 >= f)
        return (new AlignmentPatternFinder(this.image, j, paramInt1, k, paramInt2, paramFloat1, this.resultPointCallback)).find(); 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected final BitMatrix getImage() {
    return this.image;
  }
  
  protected final ResultPointCallback getResultPointCallback() {
    return this.resultPointCallback;
  }
  
  protected final DetectorResult processFinderPatternInfo(FinderPatternInfo paramFinderPatternInfo) throws NotFoundException, FormatException {
    FinderPattern finderPattern1 = paramFinderPatternInfo.getTopLeft();
    FinderPattern finderPattern2 = paramFinderPatternInfo.getTopRight();
    FinderPattern finderPattern3 = paramFinderPatternInfo.getBottomLeft();
    float f = calculateModuleSize(finderPattern1, finderPattern2, finderPattern3);
    if (f >= 1.0F) {
      ResultPoint[] arrayOfResultPoint;
      int i = computeDimension(finderPattern1, finderPattern2, finderPattern3, f);
      Version version = Version.getProvisionalVersionForDimension(i);
      int j = version.getDimensionForVersion();
      FinderPatternInfo finderPatternInfo = null;
      paramFinderPatternInfo = finderPatternInfo;
      if ((version.getAlignmentPatternCenters()).length > 0) {
        float f1 = finderPattern2.getX();
        float f2 = finderPattern1.getX();
        float f3 = finderPattern3.getX();
        float f4 = finderPattern2.getY();
        float f5 = finderPattern1.getY();
        float f6 = finderPattern3.getY();
        float f7 = 1.0F - 3.0F / (j - 7);
        int k = (int)(finderPattern1.getX() + (f1 - f2 + f3 - finderPattern1.getX()) * f7);
        int m = (int)(finderPattern1.getY() + f7 * (f4 - f5 + f6 - finderPattern1.getY()));
        j = 4;
        while (true) {
          paramFinderPatternInfo = finderPatternInfo;
          if (j <= 16) {
            f4 = j;
            try {
              AlignmentPattern alignmentPattern = findAlignmentInRegion(f, k, m, f4);
              break;
            } catch (NotFoundException notFoundException) {
              j <<= 1;
              continue;
            } 
          } 
          break;
        } 
      } 
      PerspectiveTransform perspectiveTransform = createTransform(finderPattern1, finderPattern2, finderPattern3, (ResultPoint)notFoundException, i);
      BitMatrix bitMatrix = sampleGrid(this.image, perspectiveTransform, i);
      if (notFoundException == null) {
        arrayOfResultPoint = new ResultPoint[3];
        arrayOfResultPoint[0] = finderPattern3;
        arrayOfResultPoint[1] = finderPattern1;
        arrayOfResultPoint[2] = finderPattern2;
      } else {
        arrayOfResultPoint = new ResultPoint[] { finderPattern3, finderPattern1, finderPattern2, (ResultPoint)arrayOfResultPoint };
      } 
      return new DetectorResult(bitMatrix, arrayOfResultPoint);
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */