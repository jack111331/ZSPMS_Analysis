package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
  private static final int CENTER_QUORUM = 2;
  
  protected static final int MAX_MODULES = 97;
  
  protected static final int MIN_SKIP = 3;
  
  private final int[] crossCheckStateCount;
  
  private boolean hasSkipped;
  
  private final BitMatrix image;
  
  private final List<FinderPattern> possibleCenters;
  
  private final ResultPointCallback resultPointCallback;
  
  public FinderPatternFinder(BitMatrix paramBitMatrix) {
    this(paramBitMatrix, null);
  }
  
  public FinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback) {
    this.image = paramBitMatrix;
    this.possibleCenters = new ArrayList<FinderPattern>();
    this.crossCheckStateCount = new int[5];
    this.resultPointCallback = paramResultPointCallback;
  }
  
  private static float centerFromEnd(int[] paramArrayOfint, int paramInt) {
    return (paramInt - paramArrayOfint[4] - paramArrayOfint[3]) - paramArrayOfint[2] / 2.0F;
  }
  
  private boolean crossCheckDiagonal(int paramInt1, int paramInt2) {
    int[] arrayOfInt = getCrossCheckStateCount();
    int i;
    for (i = 0; paramInt1 >= i && paramInt2 >= i && this.image.get(paramInt2 - i, paramInt1 - i); i++)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    if (arrayOfInt[2] == 0)
      return false; 
    while (paramInt1 >= i && paramInt2 >= i && !this.image.get(paramInt2 - i, paramInt1 - i)) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      i++;
    } 
    if (arrayOfInt[1] == 0)
      return false; 
    while (paramInt1 >= i && paramInt2 >= i && this.image.get(paramInt2 - i, paramInt1 - i)) {
      arrayOfInt[0] = arrayOfInt[0] + 1;
      i++;
    } 
    if (arrayOfInt[0] == 0)
      return false; 
    int j = this.image.getHeight();
    int k = this.image.getWidth();
    int m = 1;
    while (true) {
      int n = paramInt1 + m;
      i = m;
      if (n < j) {
        int i1 = paramInt2 + m;
        i = m;
        if (i1 < k) {
          i = m;
          if (this.image.get(i1, n)) {
            arrayOfInt[2] = arrayOfInt[2] + 1;
            m++;
            continue;
          } 
        } 
      } 
      break;
    } 
    while (true) {
      int n = paramInt1 + i;
      if (n < j) {
        m = paramInt2 + i;
        if (m < k && !this.image.get(m, n)) {
          arrayOfInt[3] = arrayOfInt[3] + 1;
          i++;
          continue;
        } 
      } 
      break;
    } 
    if (arrayOfInt[3] == 0)
      return false; 
    while (true) {
      int n = paramInt1 + i;
      if (n < j) {
        m = paramInt2 + i;
        if (m < k && this.image.get(m, n)) {
          arrayOfInt[4] = arrayOfInt[4] + 1;
          i++;
          continue;
        } 
      } 
      break;
    } 
    return (arrayOfInt[4] == 0) ? false : foundPatternDiagonal(arrayOfInt);
  }
  
  private float crossCheckHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    BitMatrix bitMatrix = this.image;
    int i = bitMatrix.getWidth();
    int[] arrayOfInt = getCrossCheckStateCount();
    int j;
    for (j = paramInt1; j >= 0 && bitMatrix.get(j, paramInt2); j--)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    int k = j;
    if (j < 0)
      return Float.NaN; 
    while (k >= 0 && !bitMatrix.get(k, paramInt2) && arrayOfInt[1] <= paramInt3) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      k--;
    } 
    if (k < 0 || arrayOfInt[1] > paramInt3)
      return Float.NaN; 
    while (k >= 0 && bitMatrix.get(k, paramInt2) && arrayOfInt[0] <= paramInt3) {
      arrayOfInt[0] = arrayOfInt[0] + 1;
      k--;
    } 
    if (arrayOfInt[0] > paramInt3)
      return Float.NaN; 
    while (++paramInt1 < i && bitMatrix.get(paramInt1, paramInt2)) {
      arrayOfInt[2] = arrayOfInt[2] + 1;
      paramInt1++;
    } 
    j = paramInt1;
    if (paramInt1 == i)
      return Float.NaN; 
    while (j < i && !bitMatrix.get(j, paramInt2) && arrayOfInt[3] < paramInt3) {
      arrayOfInt[3] = arrayOfInt[3] + 1;
      j++;
    } 
    if (j == i || arrayOfInt[3] >= paramInt3)
      return Float.NaN; 
    while (j < i && bitMatrix.get(j, paramInt2) && arrayOfInt[4] < paramInt3) {
      arrayOfInt[4] = arrayOfInt[4] + 1;
      j++;
    } 
    return (arrayOfInt[4] >= paramInt3) ? Float.NaN : ((Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 5 >= paramInt4) ? Float.NaN : (foundPatternCross(arrayOfInt) ? centerFromEnd(arrayOfInt, j) : Float.NaN));
  }
  
  private float crossCheckVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    BitMatrix bitMatrix = this.image;
    int i = bitMatrix.getHeight();
    int[] arrayOfInt = getCrossCheckStateCount();
    int j;
    for (j = paramInt1; j >= 0 && bitMatrix.get(paramInt2, j); j--)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    int k = j;
    if (j < 0)
      return Float.NaN; 
    while (k >= 0 && !bitMatrix.get(paramInt2, k) && arrayOfInt[1] <= paramInt3) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      k--;
    } 
    if (k < 0 || arrayOfInt[1] > paramInt3)
      return Float.NaN; 
    while (k >= 0 && bitMatrix.get(paramInt2, k) && arrayOfInt[0] <= paramInt3) {
      arrayOfInt[0] = arrayOfInt[0] + 1;
      k--;
    } 
    if (arrayOfInt[0] > paramInt3)
      return Float.NaN; 
    for (j = paramInt1 + 1; j < i && bitMatrix.get(paramInt2, j); j++)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    paramInt1 = j;
    if (j == i)
      return Float.NaN; 
    while (paramInt1 < i && !bitMatrix.get(paramInt2, paramInt1) && arrayOfInt[3] < paramInt3) {
      arrayOfInt[3] = arrayOfInt[3] + 1;
      paramInt1++;
    } 
    if (paramInt1 == i || arrayOfInt[3] >= paramInt3)
      return Float.NaN; 
    while (paramInt1 < i && bitMatrix.get(paramInt2, paramInt1) && arrayOfInt[4] < paramInt3) {
      arrayOfInt[4] = arrayOfInt[4] + 1;
      paramInt1++;
    } 
    return (arrayOfInt[4] >= paramInt3) ? Float.NaN : ((Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 5 >= paramInt4 * 2) ? Float.NaN : (foundPatternCross(arrayOfInt) ? centerFromEnd(arrayOfInt, paramInt1) : Float.NaN));
  }
  
  private int findRowSkip() {
    if (this.possibleCenters.size() <= 1)
      return 0; 
    FinderPattern finderPattern = null;
    for (FinderPattern finderPattern1 : this.possibleCenters) {
      if (finderPattern1.getCount() >= 2) {
        if (finderPattern == null) {
          finderPattern = finderPattern1;
          continue;
        } 
        this.hasSkipped = true;
        return (int)(Math.abs(finderPattern.getX() - finderPattern1.getX()) - Math.abs(finderPattern.getY() - finderPattern1.getY())) / 2;
      } 
    } 
    return 0;
  }
  
  protected static boolean foundPatternCross(int[] paramArrayOfint) {
    byte b = 0;
    int i = 0;
    while (b < 5) {
      int j = paramArrayOfint[b];
      if (j == 0)
        return false; 
      i += j;
      b++;
    } 
    if (i < 7)
      return false; 
    float f1 = i / 7.0F;
    float f2 = f1 / 2.0F;
    return (Math.abs(f1 - paramArrayOfint[0]) < f2 && Math.abs(f1 - paramArrayOfint[1]) < f2 && Math.abs(f1 * 3.0F - paramArrayOfint[2]) < 3.0F * f2 && Math.abs(f1 - paramArrayOfint[3]) < f2 && Math.abs(f1 - paramArrayOfint[4]) < f2);
  }
  
  protected static boolean foundPatternDiagonal(int[] paramArrayOfint) {
    byte b = 0;
    int i = 0;
    while (b < 5) {
      int j = paramArrayOfint[b];
      if (j == 0)
        return false; 
      i += j;
      b++;
    } 
    if (i < 7)
      return false; 
    float f1 = i / 7.0F;
    float f2 = f1 / 1.333F;
    return (Math.abs(f1 - paramArrayOfint[0]) < f2 && Math.abs(f1 - paramArrayOfint[1]) < f2 && Math.abs(f1 * 3.0F - paramArrayOfint[2]) < 3.0F * f2 && Math.abs(f1 - paramArrayOfint[3]) < f2 && Math.abs(f1 - paramArrayOfint[4]) < f2);
  }
  
  private int[] getCrossCheckStateCount() {
    clearCounts(this.crossCheckStateCount);
    return this.crossCheckStateCount;
  }
  
  private boolean haveMultiplyConfirmedCenters() {
    int i = this.possibleCenters.size();
    Iterator<FinderPattern> iterator1 = this.possibleCenters.iterator();
    float f1 = 0.0F;
    byte b = 0;
    float f2 = 0.0F;
    while (iterator1.hasNext()) {
      FinderPattern finderPattern = iterator1.next();
      if (finderPattern.getCount() >= 2) {
        b++;
        f2 += finderPattern.getEstimatedModuleSize();
      } 
    } 
    if (b < 3)
      return false; 
    float f3 = f2 / i;
    Iterator<FinderPattern> iterator2 = this.possibleCenters.iterator();
    while (iterator2.hasNext())
      f1 += Math.abs(((FinderPattern)iterator2.next()).getEstimatedModuleSize() - f3); 
    return (f1 <= f2 * 0.05F);
  }
  
  private FinderPattern[] selectBestPatterns() throws NotFoundException {
    int i = this.possibleCenters.size();
    if (i >= 3) {
      float f = 0.0F;
      if (i > 3) {
        Iterator<FinderPattern> iterator = this.possibleCenters.iterator();
        float f1 = 0.0F;
        float f2;
        for (f2 = 0.0F; iterator.hasNext(); f2 += f4 * f4) {
          float f4 = ((FinderPattern)iterator.next()).getEstimatedModuleSize();
          f1 += f4;
        } 
        float f3 = i;
        f1 /= f3;
        f2 = (float)Math.sqrt((f2 / f3 - f1 * f1));
        Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f1));
        f2 = Math.max(0.2F * f1, f2);
        for (i = 0; i < this.possibleCenters.size() && this.possibleCenters.size() > 3; i = j + 1) {
          int j = i;
          if (Math.abs(((FinderPattern)this.possibleCenters.get(i)).getEstimatedModuleSize() - f1) > f2) {
            this.possibleCenters.remove(i);
            j = i - 1;
          } 
        } 
      } 
      if (this.possibleCenters.size() > 3) {
        Iterator<FinderPattern> iterator = this.possibleCenters.iterator();
        float f1;
        for (f1 = f; iterator.hasNext(); f1 += ((FinderPattern)iterator.next()).getEstimatedModuleSize());
        f1 /= this.possibleCenters.size();
        Collections.sort(this.possibleCenters, new CenterComparator(f1));
        this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
      } 
      return new FinderPattern[] { this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2) };
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  protected final void clearCounts(int[] paramArrayOfint) {
    for (byte b = 0; b < paramArrayOfint.length; b++)
      paramArrayOfint[b] = 0; 
  }
  
  final FinderPatternInfo find(Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    int i;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.TRY_HARDER)) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = this.image.getHeight();
    int k = this.image.getWidth();
    int m = j * 3 / 388;
    if (m < 3 || i)
      m = 3; 
    int[] arrayOfInt = new int[5];
    int n = m - 1;
    boolean bool = false;
    while (n < j && !bool) {
      clearCounts(arrayOfInt);
      i = 0;
      int i1 = 0;
      int i2 = m;
      m = i1;
      while (i < k) {
        if (this.image.get(i, n)) {
          i1 = m;
          if ((m & 0x1) == 1)
            i1 = m + 1; 
          arrayOfInt[i1] = arrayOfInt[i1] + 1;
          m = i1;
        } else if ((m & 0x1) == 0) {
          if (m == 4) {
            if (foundPatternCross(arrayOfInt)) {
              if (handlePossibleCenter(arrayOfInt, n, i)) {
                boolean bool1;
                if (this.hasSkipped) {
                  bool1 = haveMultiplyConfirmedCenters();
                  m = n;
                } else {
                  i2 = findRowSkip();
                  m = n;
                  bool1 = bool;
                  if (i2 > arrayOfInt[2]) {
                    m = n + i2 - arrayOfInt[2] - 2;
                    i = k - 1;
                    bool1 = bool;
                  } 
                } 
                clearCounts(arrayOfInt);
                i1 = 0;
                i2 = 2;
                n = m;
                m = i1;
                bool = bool1;
              } else {
                shiftCounts2(arrayOfInt);
                m = 3;
              } 
            } else {
              shiftCounts2(arrayOfInt);
              m = 3;
            } 
          } else {
            arrayOfInt[++m] = arrayOfInt[m] + 1;
          } 
        } else {
          arrayOfInt[m] = arrayOfInt[m] + 1;
        } 
        i++;
      } 
      if (foundPatternCross(arrayOfInt) && handlePossibleCenter(arrayOfInt, n, k)) {
        m = arrayOfInt[0];
        if (this.hasSkipped)
          bool = haveMultiplyConfirmedCenters(); 
      } else {
        m = i2;
      } 
      n += m;
    } 
    FinderPattern[] arrayOfFinderPattern = selectBestPatterns();
    ResultPoint.orderBestPatterns((ResultPoint[])arrayOfFinderPattern);
    return new FinderPatternInfo(arrayOfFinderPattern);
  }
  
  protected final BitMatrix getImage() {
    return this.image;
  }
  
  protected final List<FinderPattern> getPossibleCenters() {
    return this.possibleCenters;
  }
  
  protected final boolean handlePossibleCenter(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    boolean bool = false;
    int i = paramArrayOfint[0] + paramArrayOfint[1] + paramArrayOfint[2] + paramArrayOfint[3] + paramArrayOfint[4];
    paramInt2 = (int)centerFromEnd(paramArrayOfint, paramInt2);
    float f = crossCheckVertical(paramInt1, paramInt2, paramArrayOfint[2], i);
    if (!Float.isNaN(f)) {
      paramInt1 = (int)f;
      float f1 = crossCheckHorizontal(paramInt2, paramInt1, paramArrayOfint[2], i);
      if (!Float.isNaN(f1) && crossCheckDiagonal(paramInt1, (int)f1)) {
        float f2 = i / 7.0F;
        paramInt2 = 0;
        while (true) {
          paramInt1 = bool;
          if (paramInt2 < this.possibleCenters.size()) {
            FinderPattern finderPattern = this.possibleCenters.get(paramInt2);
            if (finderPattern.aboutEquals(f2, f, f1)) {
              this.possibleCenters.set(paramInt2, finderPattern.combineEstimate(f, f1, f2));
              paramInt1 = 1;
              break;
            } 
            paramInt2++;
            continue;
          } 
          break;
        } 
        if (paramInt1 == 0) {
          FinderPattern finderPattern = new FinderPattern(f1, f, f2);
          this.possibleCenters.add(finderPattern);
          if (this.resultPointCallback != null)
            this.resultPointCallback.foundPossibleResultPoint(finderPattern); 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  @Deprecated
  protected final boolean handlePossibleCenter(int[] paramArrayOfint, int paramInt1, int paramInt2, boolean paramBoolean) {
    return handlePossibleCenter(paramArrayOfint, paramInt1, paramInt2);
  }
  
  protected final void shiftCounts2(int[] paramArrayOfint) {
    paramArrayOfint[0] = paramArrayOfint[2];
    paramArrayOfint[1] = paramArrayOfint[3];
    paramArrayOfint[2] = paramArrayOfint[4];
    paramArrayOfint[3] = 1;
    paramArrayOfint[4] = 0;
  }
  
  private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
    private final float average;
    
    private CenterComparator(float param1Float) {
      this.average = param1Float;
    }
    
    public int compare(FinderPattern param1FinderPattern1, FinderPattern param1FinderPattern2) {
      int i = Integer.compare(param1FinderPattern2.getCount(), param1FinderPattern1.getCount());
      return (i == 0) ? Float.compare(Math.abs(param1FinderPattern1.getEstimatedModuleSize() - this.average), Math.abs(param1FinderPattern2.getEstimatedModuleSize() - this.average)) : i;
    }
  }
  
  private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
    private final float average;
    
    private FurthestFromAverageComparator(float param1Float) {
      this.average = param1Float;
    }
    
    public int compare(FinderPattern param1FinderPattern1, FinderPattern param1FinderPattern2) {
      return Float.compare(Math.abs(param1FinderPattern2.getEstimatedModuleSize() - this.average), Math.abs(param1FinderPattern1.getEstimatedModuleSize() - this.average));
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\detector\FinderPatternFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */