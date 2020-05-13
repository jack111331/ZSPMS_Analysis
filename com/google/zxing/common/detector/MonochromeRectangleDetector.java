package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector {
  private static final int MAX_MODULES = 32;
  
  private final BitMatrix image;
  
  public MonochromeRectangleDetector(BitMatrix paramBitMatrix) {
    this.image = paramBitMatrix;
  }
  
  private int[] blackWhiteRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    int i = (paramInt3 + paramInt4) / 2;
    int j;
    for (j = i; j >= paramInt3; j = n) {
      int n;
      if (paramBoolean ? this.image.get(j, paramInt1) : this.image.get(paramInt1, j)) {
        j--;
        continue;
      } 
      int m = j;
      while (true) {
        n = m - 1;
        if (n >= paramInt3) {
          if (paramBoolean) {
            m = n;
            if (this.image.get(n, paramInt1))
              break; 
            continue;
          } 
          m = n;
          if (this.image.get(paramInt1, n))
            break; 
          continue;
        } 
        break;
      } 
      if (n < paramInt3 || j - n > paramInt2)
        break; 
    } 
    int k = j + 1;
    for (paramInt3 = i; paramInt3 < paramInt4; paramInt3 = i) {
      if (paramBoolean ? this.image.get(paramInt3, paramInt1) : this.image.get(paramInt1, paramInt3)) {
        paramInt3++;
        continue;
      } 
      j = paramInt3;
      while (true) {
        i = j + 1;
        if (i < paramInt4) {
          if (paramBoolean) {
            j = i;
            if (this.image.get(i, paramInt1))
              break; 
            continue;
          } 
          j = i;
          if (this.image.get(paramInt1, i))
            break; 
          continue;
        } 
        break;
      } 
      if (i >= paramInt4 || i - paramInt3 > paramInt2)
        break; 
    } 
    paramInt1 = paramInt3 - 1;
    return (paramInt1 > k) ? new int[] { k, paramInt1 } : null;
  }
  
  private ResultPoint findCornerFromCenter(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) throws NotFoundException {
    int i = paramInt1;
    int j = paramInt5;
    for (int[] arrayOfInt = null; j < paramInt8 && j >= paramInt7 && i < paramInt4 && i >= paramInt3; arrayOfInt = arrayOfInt1) {
      int[] arrayOfInt1;
      if (paramInt2 == 0) {
        arrayOfInt1 = blackWhiteRange(j, paramInt9, paramInt3, paramInt4, true);
      } else {
        arrayOfInt1 = blackWhiteRange(i, paramInt9, paramInt7, paramInt8, false);
      } 
      if (arrayOfInt1 == null) {
        if (arrayOfInt != null) {
          paramInt4 = 1;
          paramInt3 = 1;
          if (paramInt2 == 0) {
            paramInt2 = j - paramInt6;
            if (arrayOfInt[0] < paramInt1) {
              if (arrayOfInt[1] > paramInt1) {
                paramInt1 = paramInt3;
                if (paramInt6 > 0)
                  paramInt1 = 0; 
                return new ResultPoint(arrayOfInt[paramInt1], paramInt2);
              } 
              return new ResultPoint(arrayOfInt[0], paramInt2);
            } 
            return new ResultPoint(arrayOfInt[1], paramInt2);
          } 
          paramInt1 = i - paramInt2;
          if (arrayOfInt[0] < paramInt5) {
            if (arrayOfInt[1] > paramInt5) {
              float f = paramInt1;
              paramInt1 = paramInt4;
              if (paramInt2 < 0)
                paramInt1 = 0; 
              return new ResultPoint(f, arrayOfInt[paramInt1]);
            } 
            return new ResultPoint(paramInt1, arrayOfInt[0]);
          } 
          return new ResultPoint(paramInt1, arrayOfInt[1]);
        } 
        throw NotFoundException.getNotFoundInstance();
      } 
      j += paramInt6;
      i += paramInt2;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public ResultPoint[] detect() throws NotFoundException {
    int i = this.image.getHeight();
    int j = this.image.getWidth();
    int k = i / 2;
    int m = j / 2;
    int n = Math.max(1, i / 256);
    int i1 = Math.max(1, j / 256);
    int i2 = -n;
    int i3 = m / 2;
    int i4 = (int)findCornerFromCenter(m, 0, 0, j, k, i2, 0, i, i3).getY() - 1;
    int i5 = -i1;
    int i6 = k / 2;
    ResultPoint resultPoint1 = findCornerFromCenter(m, i5, 0, j, k, 0, i4, i, i6);
    i5 = (int)resultPoint1.getX() - 1;
    ResultPoint resultPoint2 = findCornerFromCenter(m, i1, i5, j, k, 0, i4, i, i6);
    i1 = (int)resultPoint2.getX() + 1;
    ResultPoint resultPoint3 = findCornerFromCenter(m, 0, i5, i1, k, n, i4, i, i3);
    return new ResultPoint[] { findCornerFromCenter(m, 0, i5, i1, k, i2, i4, (int)resultPoint3.getY() + 1, m / 4), resultPoint1, resultPoint2, resultPoint3 };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\detector\MonochromeRectangleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */