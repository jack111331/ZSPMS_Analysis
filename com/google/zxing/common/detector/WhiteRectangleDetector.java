package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
  private static final int CORR = 1;
  
  private static final int INIT_SIZE = 10;
  
  private final int downInit;
  
  private final int height;
  
  private final BitMatrix image;
  
  private final int leftInit;
  
  private final int rightInit;
  
  private final int upInit;
  
  private final int width;
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix) throws NotFoundException {
    this(paramBitMatrix, 10, paramBitMatrix.getWidth() / 2, paramBitMatrix.getHeight() / 2);
  }
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3) throws NotFoundException {
    this.image = paramBitMatrix;
    this.height = paramBitMatrix.getHeight();
    this.width = paramBitMatrix.getWidth();
    paramInt1 /= 2;
    this.leftInit = paramInt2 - paramInt1;
    this.rightInit = paramInt2 + paramInt1;
    this.upInit = paramInt3 - paramInt1;
    this.downInit = paramInt3 + paramInt1;
    if (this.upInit >= 0 && this.leftInit >= 0 && this.downInit < this.height && this.rightInit < this.width)
      return; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private ResultPoint[] centerEdges(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4) {
    float f1 = paramResultPoint1.getX();
    float f2 = paramResultPoint1.getY();
    float f3 = paramResultPoint2.getX();
    float f4 = paramResultPoint2.getY();
    float f5 = paramResultPoint3.getX();
    float f6 = paramResultPoint3.getY();
    float f7 = paramResultPoint4.getX();
    float f8 = paramResultPoint4.getY();
    return (f1 < this.width / 2.0F) ? new ResultPoint[] { new ResultPoint(f7 - 1.0F, f8 + 1.0F), new ResultPoint(f3 + 1.0F, f4 + 1.0F), new ResultPoint(f5 - 1.0F, f6 - 1.0F), new ResultPoint(f1 + 1.0F, f2 - 1.0F) } : new ResultPoint[] { new ResultPoint(f7 + 1.0F, f8 + 1.0F), new ResultPoint(f3 + 1.0F, f4 - 1.0F), new ResultPoint(f5 - 1.0F, f6 + 1.0F), new ResultPoint(f1 - 1.0F, f2 - 1.0F) };
  }
  
  private boolean containsBlackPoint(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = paramInt1;
    if (paramBoolean) {
      while (paramInt1 <= paramInt2) {
        if (this.image.get(paramInt1, paramInt3))
          return true; 
        paramInt1++;
      } 
    } else {
      while (i <= paramInt2) {
        if (this.image.get(paramInt3, i))
          return true; 
        i++;
      } 
    } 
    return false;
  }
  
  private ResultPoint getBlackPointOnSegment(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    int i = MathUtils.round(MathUtils.distance(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    float f = i;
    paramFloat3 = (paramFloat3 - paramFloat1) / f;
    f = (paramFloat4 - paramFloat2) / f;
    for (byte b = 0; b < i; b++) {
      paramFloat4 = b;
      int j = MathUtils.round(paramFloat4 * paramFloat3 + paramFloat1);
      int k = MathUtils.round(paramFloat4 * f + paramFloat2);
      if (this.image.get(j, k))
        return new ResultPoint(j, k); 
    } 
    return null;
  }
  
  public ResultPoint[] detect() throws NotFoundException {
    int i2;
    int i3;
    int i4;
    boolean bool7;
    int i5;
    int i = this.leftInit;
    int j = this.rightInit;
    int k = this.upInit;
    int m = this.downInit;
    boolean bool1 = false;
    boolean bool2 = true;
    int n = 1;
    int i1 = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    while (true) {
      i2 = j;
      i3 = k;
      i4 = m;
      bool7 = bool1;
      i5 = i;
      if (n) {
        boolean bool = true;
        i2 = 0;
        i4 = i1;
        while ((bool || i4 == 0) && j < this.width) {
          boolean bool8 = containsBlackPoint(k, m, j, false);
          if (bool8) {
            j++;
            i4 = 1;
            i2 = 1;
            bool = bool8;
            continue;
          } 
          bool = bool8;
          if (i4 == 0) {
            j++;
            bool = bool8;
          } 
        } 
        if (j < this.width) {
          bool = true;
          while ((bool || !bool3) && m < this.height) {
            boolean bool8 = containsBlackPoint(i, j, m, true);
            if (bool8) {
              m++;
              bool3 = true;
              i2 = 1;
              bool = bool8;
              continue;
            } 
            bool = bool8;
            if (!bool3) {
              m++;
              bool = bool8;
            } 
          } 
          if (m < this.height) {
            bool = true;
            while ((bool || !bool4) && i >= 0) {
              boolean bool8 = containsBlackPoint(k, m, i, false);
              if (bool8) {
                i--;
                bool4 = true;
                i2 = 1;
                bool = bool8;
                continue;
              } 
              bool = bool8;
              if (!bool4) {
                i--;
                bool = bool8;
              } 
            } 
            if (i >= 0) {
              bool = true;
              while ((bool || !bool6) && k >= 0) {
                boolean bool8 = containsBlackPoint(i, j, k, true);
                if (bool8) {
                  k--;
                  bool6 = true;
                  i2 = 1;
                  bool = bool8;
                  continue;
                } 
                bool = bool8;
                if (!bool6) {
                  k--;
                  bool = bool8;
                } 
              } 
              if (k >= 0) {
                if (i2 != 0)
                  bool5 = true; 
                n = i2;
                i1 = i4;
                continue;
              } 
            } 
          } 
        } 
        bool7 = true;
        i2 = j;
        i3 = k;
        i4 = m;
        i5 = i;
      } 
      break;
    } 
    if (!bool7 && bool5) {
      i = i2 - i5;
      ResultPoint resultPoint1 = null;
      ResultPoint resultPoint2 = null;
      for (k = 1; resultPoint2 == null && k < i; k++)
        resultPoint2 = getBlackPointOnSegment(i5, (i4 - k), (i5 + k), i4); 
      if (resultPoint2 != null) {
        ResultPoint resultPoint = null;
        for (k = 1; resultPoint == null && k < i; k++)
          resultPoint = getBlackPointOnSegment(i5, (i3 + k), (i5 + k), i3); 
        if (resultPoint != null) {
          ResultPoint resultPoint3 = null;
          for (k = 1; resultPoint3 == null && k < i; k++)
            resultPoint3 = getBlackPointOnSegment(i2, (i3 + k), (i2 - k), i3); 
          if (resultPoint3 != null) {
            for (k = bool2; resultPoint1 == null && k < i; k++)
              resultPoint1 = getBlackPointOnSegment(i2, (i4 - k), (i2 - k), i4); 
            if (resultPoint1 != null)
              return centerEdges(resultPoint1, resultPoint2, resultPoint3, resultPoint); 
            throw NotFoundException.getNotFoundInstance();
          } 
          throw NotFoundException.getNotFoundInstance();
        } 
        throw NotFoundException.getNotFoundInstance();
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\detector\WhiteRectangleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */