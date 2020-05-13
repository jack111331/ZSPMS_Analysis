package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector {
  private static final int[] EXPECTED_CORNER_BITS = new int[] { 3808, 476, 2107, 1799 };
  
  private boolean compact;
  
  private final BitMatrix image;
  
  private int nbCenterLayers;
  
  private int nbDataBlocks;
  
  private int nbLayers;
  
  private int shift;
  
  public Detector(BitMatrix paramBitMatrix) {
    this.image = paramBitMatrix;
  }
  
  private static float distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return MathUtils.distance(paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY());
  }
  
  private static float distance(Point paramPoint1, Point paramPoint2) {
    return MathUtils.distance(paramPoint1.getX(), paramPoint1.getY(), paramPoint2.getX(), paramPoint2.getY());
  }
  
  private static ResultPoint[] expandSquare(ResultPoint[] paramArrayOfResultPoint, int paramInt1, int paramInt2) {
    float f1 = paramInt2 / paramInt1 * 2.0F;
    float f2 = paramArrayOfResultPoint[0].getX();
    float f3 = paramArrayOfResultPoint[2].getX();
    float f4 = paramArrayOfResultPoint[0].getY();
    float f5 = paramArrayOfResultPoint[2].getY();
    float f6 = (paramArrayOfResultPoint[0].getX() + paramArrayOfResultPoint[2].getX()) / 2.0F;
    float f7 = (paramArrayOfResultPoint[0].getY() + paramArrayOfResultPoint[2].getY()) / 2.0F;
    f2 = (f2 - f3) * f1;
    f4 = (f4 - f5) * f1;
    ResultPoint resultPoint1 = new ResultPoint(f6 + f2, f7 + f4);
    ResultPoint resultPoint2 = new ResultPoint(f6 - f2, f7 - f4);
    f3 = paramArrayOfResultPoint[1].getX();
    f2 = paramArrayOfResultPoint[3].getX();
    f5 = paramArrayOfResultPoint[1].getY();
    f4 = paramArrayOfResultPoint[3].getY();
    f7 = (paramArrayOfResultPoint[1].getX() + paramArrayOfResultPoint[3].getX()) / 2.0F;
    f6 = (paramArrayOfResultPoint[1].getY() + paramArrayOfResultPoint[3].getY()) / 2.0F;
    f2 = (f3 - f2) * f1;
    f1 *= f5 - f4;
    return new ResultPoint[] { resultPoint1, new ResultPoint(f7 + f2, f6 + f1), resultPoint2, new ResultPoint(f7 - f2, f6 - f1) };
  }
  
  private void extractParameters(ResultPoint[] paramArrayOfResultPoint) throws NotFoundException {
    int i = 0;
    if (isValid(paramArrayOfResultPoint[0]) && isValid(paramArrayOfResultPoint[1]) && isValid(paramArrayOfResultPoint[2]) && isValid(paramArrayOfResultPoint[3])) {
      int j = this.nbCenterLayers * 2;
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = sampleLine(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1], j);
      arrayOfInt[1] = sampleLine(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2], j);
      arrayOfInt[2] = sampleLine(paramArrayOfResultPoint[2], paramArrayOfResultPoint[3], j);
      arrayOfInt[3] = sampleLine(paramArrayOfResultPoint[3], paramArrayOfResultPoint[0], j);
      this.shift = getRotation(arrayOfInt, j);
      long l = 0L;
      while (i < 4) {
        j = arrayOfInt[(this.shift + i) % 4];
        if (this.compact) {
          l = (l << 7L) + (j >> 1 & 0x7F);
        } else {
          l = (l << 10L) + ((j >> 2 & 0x3E0) + (j >> 1 & 0x1F));
        } 
        i++;
      } 
      i = getCorrectedParameterData(l, this.compact);
      if (this.compact) {
        this.nbLayers = (i >> 6) + 1;
        this.nbDataBlocks = (i & 0x3F) + 1;
        return;
      } 
      this.nbLayers = (i >> 11) + 1;
      this.nbDataBlocks = (i & 0x7FF) + 1;
      return;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private ResultPoint[] getBullsEyeCorners(Point paramPoint) throws NotFoundException {
    Object object1;
    this.nbCenterLayers = 1;
    Object object2 = paramPoint;
    Object object3 = object2;
    Object object4 = object3;
    int i = 1;
    while (this.nbCenterLayers < 9) {
      Point point1 = getFirstDifferent((Point)object1, i, 1, -1);
      Point point2 = getFirstDifferent((Point)object2, i, 1, 1);
      Point point3 = getFirstDifferent((Point)object3, i, -1, 1);
      Point point4 = getFirstDifferent((Point)object4, i, -1, -1);
      if (this.nbCenterLayers > 2) {
        double d = (distance(point4, point1) * this.nbCenterLayers / distance((Point)object4, (Point)object1) * (this.nbCenterLayers + 2));
        if (d >= 0.75D && d <= 1.25D && isWhiteOrBlackRectangle(point1, point2, point3, point4))
          continue; 
        break;
      } 
      continue;
      i ^= 0x1;
      this.nbCenterLayers++;
      object4 = SYNTHETIC_LOCAL_VARIABLE_9;
      object1 = SYNTHETIC_LOCAL_VARIABLE_6;
      object2 = SYNTHETIC_LOCAL_VARIABLE_7;
      object3 = SYNTHETIC_LOCAL_VARIABLE_8;
    } 
    if (this.nbCenterLayers == 5 || this.nbCenterLayers == 7) {
      if (this.nbCenterLayers == 5) {
        i = 1;
      } else {
        i = 0;
      } 
      this.compact = i;
      object1 = new ResultPoint(object1.getX() + 0.5F, object1.getY() - 0.5F);
      object2 = new ResultPoint(object2.getX() + 0.5F, object2.getY() + 0.5F);
      object3 = new ResultPoint(object3.getX() - 0.5F, object3.getY() + 0.5F);
      object4 = new ResultPoint(object4.getX() - 0.5F, object4.getY() - 0.5F);
      int j = this.nbCenterLayers;
      int k = this.nbCenterLayers;
      return expandSquare(new ResultPoint[] { (ResultPoint)object1, (ResultPoint)object2, (ResultPoint)object3, (ResultPoint)object4 }, j * 2 - 3, k * 2);
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private int getColor(Point paramPoint1, Point paramPoint2) {
    float f1 = distance(paramPoint1, paramPoint2);
    float f2 = (paramPoint2.getX() - paramPoint1.getX()) / f1;
    float f3 = (paramPoint2.getY() - paramPoint1.getY()) / f1;
    float f4 = paramPoint1.getX();
    float f5 = paramPoint1.getY();
    boolean bool1 = this.image.get(paramPoint1.getX(), paramPoint1.getY());
    int i = (int)Math.ceil(f1);
    boolean bool2 = false;
    int j = 0;
    byte b = 0;
    while (b < i) {
      f4 += f2;
      f5 += f3;
      int k = j;
      if (this.image.get(MathUtils.round(f4), MathUtils.round(f5)) != bool1)
        k = j + 1; 
      b++;
      j = k;
    } 
    f5 = j / f1;
    if (f5 > 0.1F && f5 < 0.9F)
      return 0; 
    if (f5 <= 0.1F)
      bool2 = true; 
    return (bool2 == bool1) ? 1 : -1;
  }
  
  private static int getCorrectedParameterData(long paramLong, boolean paramBoolean) throws NotFoundException {
    int i;
    byte b;
    if (paramBoolean) {
      i = 7;
      b = 2;
    } else {
      i = 10;
      b = 4;
    } 
    int[] arrayOfInt = new int[i];
    int j;
    for (j = i - 1; j >= 0; j--) {
      arrayOfInt[j] = (int)paramLong & 0xF;
      paramLong >>= 4L;
    } 
    try {
      ReedSolomonDecoder reedSolomonDecoder = new ReedSolomonDecoder();
      this(GenericGF.AZTEC_PARAM);
      reedSolomonDecoder.decode(arrayOfInt, i - b);
      j = 0;
      i = 0;
      while (j < b) {
        i = (i << 4) + arrayOfInt[j];
        j++;
      } 
      return i;
    } catch (ReedSolomonException reedSolomonException) {
      throw NotFoundException.getNotFoundInstance();
    } 
  }
  
  private int getDimension() {
    return this.compact ? (this.nbLayers * 4 + 11) : ((this.nbLayers <= 4) ? (this.nbLayers * 4 + 15) : (this.nbLayers * 4 + ((this.nbLayers - 4) / 8 + 1) * 2 + 15));
  }
  
  private Point getFirstDifferent(Point paramPoint, boolean paramBoolean, int paramInt1, int paramInt2) {
    int i = paramPoint.getX() + paramInt1;
    int j;
    for (j = paramPoint.getY() + paramInt2; isValid(i, j) && this.image.get(i, j) == paramBoolean; j += paramInt2)
      i += paramInt1; 
    int k = i - paramInt1;
    i = j - paramInt2;
    for (j = k; isValid(j, i) && this.image.get(j, i) == paramBoolean; j += paramInt1);
    j -= paramInt1;
    for (paramInt1 = i; isValid(j, paramInt1) && this.image.get(j, paramInt1) == paramBoolean; paramInt1 += paramInt2);
    return new Point(j, paramInt1 - paramInt2);
  }
  
  private Point getMatrixCenter() {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    ResultPoint resultPoint3;
    ResultPoint resultPoint4;
    try {
      WhiteRectangleDetector whiteRectangleDetector = new WhiteRectangleDetector();
      this(this.image);
      ResultPoint[] arrayOfResultPoint = whiteRectangleDetector.detect();
      resultPoint2 = arrayOfResultPoint[0];
      resultPoint3 = arrayOfResultPoint[1];
      resultPoint4 = arrayOfResultPoint[2];
      resultPoint1 = arrayOfResultPoint[3];
    } catch (NotFoundException notFoundException) {
      int k = this.image.getWidth() / 2;
      int m = this.image.getHeight() / 2;
      int n = k + 7;
      int i1 = m - 7;
      resultPoint1 = getFirstDifferent(new Point(n, i1), false, 1, -1).toResultPoint();
      m += 7;
      resultPoint3 = getFirstDifferent(new Point(n, m), false, 1, 1).toResultPoint();
      n = k - 7;
      resultPoint4 = getFirstDifferent(new Point(n, m), false, -1, 1).toResultPoint();
      ResultPoint resultPoint = getFirstDifferent(new Point(n, i1), false, -1, -1).toResultPoint();
      resultPoint2 = resultPoint1;
      resultPoint1 = resultPoint;
    } 
    int j = MathUtils.round((resultPoint2.getX() + resultPoint1.getX() + resultPoint3.getX() + resultPoint4.getX()) / 4.0F);
    int i = MathUtils.round((resultPoint2.getY() + resultPoint1.getY() + resultPoint3.getY() + resultPoint4.getY()) / 4.0F);
    try {
      WhiteRectangleDetector whiteRectangleDetector = new WhiteRectangleDetector();
      this(this.image, 15, j, i);
      ResultPoint[] arrayOfResultPoint = whiteRectangleDetector.detect();
      resultPoint2 = arrayOfResultPoint[0];
      resultPoint4 = arrayOfResultPoint[1];
      ResultPoint resultPoint5 = arrayOfResultPoint[2];
      ResultPoint resultPoint6 = arrayOfResultPoint[3];
    } catch (NotFoundException notFoundException) {
      int k = j + 7;
      int m = i - 7;
      resultPoint2 = getFirstDifferent(new Point(k, m), false, 1, -1).toResultPoint();
      i += 7;
      resultPoint4 = getFirstDifferent(new Point(k, i), false, 1, 1).toResultPoint();
      j -= 7;
      resultPoint1 = getFirstDifferent(new Point(j, i), false, -1, 1).toResultPoint();
      resultPoint3 = getFirstDifferent(new Point(j, m), false, -1, -1).toResultPoint();
    } 
    return new Point(MathUtils.round((resultPoint2.getX() + resultPoint3.getX() + resultPoint4.getX() + resultPoint1.getX()) / 4.0F), MathUtils.round((resultPoint2.getY() + resultPoint3.getY() + resultPoint4.getY() + resultPoint1.getY()) / 4.0F));
  }
  
  private ResultPoint[] getMatrixCornerPoints(ResultPoint[] paramArrayOfResultPoint) {
    return expandSquare(paramArrayOfResultPoint, this.nbCenterLayers * 2, getDimension());
  }
  
  private static int getRotation(int[] paramArrayOfint, int paramInt) throws NotFoundException {
    int i = paramArrayOfint.length;
    boolean bool = false;
    byte b = 0;
    int j = 0;
    while (b < i) {
      int k = paramArrayOfint[b];
      j = (j << 3) + (k >> paramInt - 2 << 1) + (k & 0x1);
      b++;
    } 
    for (paramInt = bool; paramInt < 4; paramInt++) {
      if (Integer.bitCount(EXPECTED_CORNER_BITS[paramInt] ^ ((j & 0x1) << 11) + (j >> 1)) <= 2)
        return paramInt; 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private boolean isValid(int paramInt1, int paramInt2) {
    return (paramInt1 >= 0 && paramInt1 < this.image.getWidth() && paramInt2 > 0 && paramInt2 < this.image.getHeight());
  }
  
  private boolean isValid(ResultPoint paramResultPoint) {
    return isValid(MathUtils.round(paramResultPoint.getX()), MathUtils.round(paramResultPoint.getY()));
  }
  
  private boolean isWhiteOrBlackRectangle(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4) {
    paramPoint1 = new Point(paramPoint1.getX() - 3, paramPoint1.getY() + 3);
    paramPoint2 = new Point(paramPoint2.getX() - 3, paramPoint2.getY() - 3);
    paramPoint3 = new Point(paramPoint3.getX() + 3, paramPoint3.getY() - 3);
    paramPoint4 = new Point(paramPoint4.getX() + 3, paramPoint4.getY() + 3);
    int i = getColor(paramPoint4, paramPoint1);
    return (i == 0) ? false : ((getColor(paramPoint1, paramPoint2) != i) ? false : ((getColor(paramPoint2, paramPoint3) != i) ? false : ((getColor(paramPoint3, paramPoint4) == i))));
  }
  
  private BitMatrix sampleGrid(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4) throws NotFoundException {
    GridSampler gridSampler = GridSampler.getInstance();
    int i = getDimension();
    float f1 = i / 2.0F;
    float f2 = f1 - this.nbCenterLayers;
    f1 += this.nbCenterLayers;
    return gridSampler.sampleGrid(paramBitMatrix, i, i, f2, f2, f1, f2, f1, f1, f2, f1, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY(), paramResultPoint3.getX(), paramResultPoint3.getY(), paramResultPoint4.getX(), paramResultPoint4.getY());
  }
  
  private int sampleLine(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt) {
    float f1 = distance(paramResultPoint1, paramResultPoint2);
    float f2 = f1 / paramInt;
    float f3 = paramResultPoint1.getX();
    float f4 = paramResultPoint1.getY();
    float f5 = (paramResultPoint2.getX() - paramResultPoint1.getX()) * f2 / f1;
    f1 = f2 * (paramResultPoint2.getY() - paramResultPoint1.getY()) / f1;
    byte b = 0;
    int i;
    for (i = 0; b < paramInt; i = j) {
      BitMatrix bitMatrix = this.image;
      f2 = b;
      int j = i;
      if (bitMatrix.get(MathUtils.round(f2 * f5 + f3), MathUtils.round(f2 * f1 + f4)))
        j = i | 1 << paramInt - b - 1; 
      b++;
    } 
    return i;
  }
  
  public AztecDetectorResult detect() throws NotFoundException {
    return detect(false);
  }
  
  public AztecDetectorResult detect(boolean paramBoolean) throws NotFoundException {
    ResultPoint[] arrayOfResultPoint = getBullsEyeCorners(getMatrixCenter());
    if (paramBoolean) {
      ResultPoint resultPoint = arrayOfResultPoint[0];
      arrayOfResultPoint[0] = arrayOfResultPoint[2];
      arrayOfResultPoint[2] = resultPoint;
    } 
    extractParameters(arrayOfResultPoint);
    return new AztecDetectorResult(sampleGrid(this.image, arrayOfResultPoint[this.shift % 4], arrayOfResultPoint[(this.shift + 1) % 4], arrayOfResultPoint[(this.shift + 2) % 4], arrayOfResultPoint[(this.shift + 3) % 4]), getMatrixCornerPoints(arrayOfResultPoint), this.compact, this.nbDataBlocks, this.nbLayers);
  }
  
  static final class Point {
    private final int x;
    
    private final int y;
    
    Point(int param1Int1, int param1Int2) {
      this.x = param1Int1;
      this.y = param1Int2;
    }
    
    int getX() {
      return this.x;
    }
    
    int getY() {
      return this.y;
    }
    
    ResultPoint toResultPoint() {
      return new ResultPoint(getX(), getY());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("<");
      stringBuilder.append(this.x);
      stringBuilder.append(' ');
      stringBuilder.append(this.y);
      stringBuilder.append('>');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */