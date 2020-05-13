package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

final class AlignmentPatternFinder {
  private final int[] crossCheckStateCount;
  
  private final int height;
  
  private final BitMatrix image;
  
  private final float moduleSize;
  
  private final List<AlignmentPattern> possibleCenters;
  
  private final ResultPointCallback resultPointCallback;
  
  private final int startX;
  
  private final int startY;
  
  private final int width;
  
  AlignmentPatternFinder(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, ResultPointCallback paramResultPointCallback) {
    this.image = paramBitMatrix;
    this.possibleCenters = new ArrayList<AlignmentPattern>(5);
    this.startX = paramInt1;
    this.startY = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.moduleSize = paramFloat;
    this.crossCheckStateCount = new int[3];
    this.resultPointCallback = paramResultPointCallback;
  }
  
  private static float centerFromEnd(int[] paramArrayOfint, int paramInt) {
    return (paramInt - paramArrayOfint[2]) - paramArrayOfint[1] / 2.0F;
  }
  
  private float crossCheckVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    BitMatrix bitMatrix = this.image;
    int i = bitMatrix.getHeight();
    int[] arrayOfInt = this.crossCheckStateCount;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    int j;
    for (j = paramInt1; j >= 0 && bitMatrix.get(paramInt2, j) && arrayOfInt[1] <= paramInt3; j--)
      arrayOfInt[1] = arrayOfInt[1] + 1; 
    if (j < 0 || arrayOfInt[1] > paramInt3)
      return Float.NaN; 
    while (j >= 0 && !bitMatrix.get(paramInt2, j) && arrayOfInt[0] <= paramInt3) {
      arrayOfInt[0] = arrayOfInt[0] + 1;
      j--;
    } 
    if (arrayOfInt[0] > paramInt3)
      return Float.NaN; 
    while (++paramInt1 < i && bitMatrix.get(paramInt2, paramInt1) && arrayOfInt[1] <= paramInt3) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      paramInt1++;
    } 
    if (paramInt1 == i || arrayOfInt[1] > paramInt3)
      return Float.NaN; 
    while (paramInt1 < i && !bitMatrix.get(paramInt2, paramInt1) && arrayOfInt[2] <= paramInt3) {
      arrayOfInt[2] = arrayOfInt[2] + 1;
      paramInt1++;
    } 
    return (arrayOfInt[2] > paramInt3) ? Float.NaN : ((Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - paramInt4) * 5 >= paramInt4 * 2) ? Float.NaN : (foundPatternCross(arrayOfInt) ? centerFromEnd(arrayOfInt, paramInt1) : Float.NaN));
  }
  
  private boolean foundPatternCross(int[] paramArrayOfint) {
    float f1 = this.moduleSize;
    float f2 = f1 / 2.0F;
    for (byte b = 0; b < 3; b++) {
      if (Math.abs(f1 - paramArrayOfint[b]) >= f2)
        return false; 
    } 
    return true;
  }
  
  private AlignmentPattern handlePossibleCenter(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    int i = paramArrayOfint[0];
    int j = paramArrayOfint[1];
    int k = paramArrayOfint[2];
    float f1 = centerFromEnd(paramArrayOfint, paramInt2);
    float f2 = crossCheckVertical(paramInt1, (int)f1, paramArrayOfint[1] * 2, i + j + k);
    if (!Float.isNaN(f2)) {
      float f = (paramArrayOfint[0] + paramArrayOfint[1] + paramArrayOfint[2]) / 3.0F;
      for (AlignmentPattern alignmentPattern1 : this.possibleCenters) {
        if (alignmentPattern1.aboutEquals(f, f2, f1))
          return alignmentPattern1.combineEstimate(f2, f1, f); 
      } 
      AlignmentPattern alignmentPattern = new AlignmentPattern(f1, f2, f);
      this.possibleCenters.add(alignmentPattern);
      if (this.resultPointCallback != null)
        this.resultPointCallback.foundPossibleResultPoint(alignmentPattern); 
    } 
    return null;
  }
  
  AlignmentPattern find() throws NotFoundException {
    int i = this.startX;
    int j = this.height;
    int k = this.width + i;
    int m = this.startY;
    int n = j / 2;
    int[] arrayOfInt = new int[3];
    for (byte b = 0; b < j; b++) {
      if ((b & 0x1) == 0) {
        i1 = (b + 1) / 2;
      } else {
        i1 = -((b + 1) / 2);
      } 
      int i2 = i1 + m + n;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[2] = 0;
      int i3;
      for (i3 = i; i3 < k && !this.image.get(i3, i2); i3++);
      int i1 = 0;
      for (int i4 = i3; i4 < k; i4++) {
        if (this.image.get(i4, i2)) {
          if (i1 == 1) {
            arrayOfInt[1] = arrayOfInt[1] + 1;
          } else if (i1 == 2) {
            if (foundPatternCross(arrayOfInt)) {
              AlignmentPattern alignmentPattern = handlePossibleCenter(arrayOfInt, i2, i4);
              if (alignmentPattern != null)
                return alignmentPattern; 
            } 
            arrayOfInt[0] = arrayOfInt[2];
            arrayOfInt[1] = 1;
            arrayOfInt[2] = 0;
            i1 = 1;
          } else {
            arrayOfInt[++i1] = arrayOfInt[i1] + 1;
          } 
        } else {
          i3 = i1;
          if (i1 == 1)
            i3 = i1 + 1; 
          arrayOfInt[i3] = arrayOfInt[i3] + 1;
          i1 = i3;
        } 
      } 
      if (foundPatternCross(arrayOfInt)) {
        AlignmentPattern alignmentPattern = handlePossibleCenter(arrayOfInt, i2, k);
        if (alignmentPattern != null)
          return alignmentPattern; 
      } 
    } 
    if (!this.possibleCenters.isEmpty())
      return this.possibleCenters.get(0); 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\detector\AlignmentPatternFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */