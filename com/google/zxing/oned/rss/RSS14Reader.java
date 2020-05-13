package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader {
  private static final int[][] FINDER_PATTERNS;
  
  private static final int[] INSIDE_GSUM;
  
  private static final int[] INSIDE_ODD_TOTAL_SUBSET;
  
  private static final int[] INSIDE_ODD_WIDEST;
  
  private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = new int[] { 1, 10, 34, 70, 126 };
  
  private static final int[] OUTSIDE_GSUM;
  
  private static final int[] OUTSIDE_ODD_WIDEST;
  
  private final List<Pair> possibleLeftPairs = new ArrayList<Pair>();
  
  private final List<Pair> possibleRightPairs = new ArrayList<Pair>();
  
  static {
    INSIDE_ODD_TOTAL_SUBSET = new int[] { 4, 20, 48, 81 };
    OUTSIDE_GSUM = new int[] { 0, 161, 961, 2015, 2715 };
    INSIDE_GSUM = new int[] { 0, 336, 1036, 1516 };
    OUTSIDE_ODD_WIDEST = new int[] { 8, 6, 4, 3, 1 };
    INSIDE_ODD_WIDEST = new int[] { 2, 4, 6, 8 };
    int[] arrayOfInt1 = { 3, 5, 5, 1 };
    int[] arrayOfInt2 = { 3, 3, 7, 1 };
    int[] arrayOfInt3 = { 3, 1, 9, 1 };
    int[] arrayOfInt4 = { 2, 7, 4, 1 };
    int[] arrayOfInt5 = { 1, 5, 7, 1 };
    int[] arrayOfInt6 = { 1, 3, 9, 1 };
    FINDER_PATTERNS = new int[][] { { 3, 8, 2, 1 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 2, 5, 6, 1 }, { 2, 3, 8, 1 }, arrayOfInt5, arrayOfInt6 };
  }
  
  private static void addOrTally(Collection<Pair> paramCollection, Pair paramPair) {
    boolean bool2;
    if (paramPair == null)
      return; 
    boolean bool1 = false;
    Iterator<Pair> iterator = paramCollection.iterator();
    while (true) {
      bool2 = bool1;
      if (iterator.hasNext()) {
        Pair pair = iterator.next();
        if (pair.getValue() == paramPair.getValue()) {
          pair.incrementCount();
          bool2 = true;
          break;
        } 
        continue;
      } 
      break;
    } 
    if (!bool2)
      paramCollection.add(paramPair); 
  }
  
  private void adjustOddEvenCounts(boolean paramBoolean, int paramInt) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getOddCounts : ()[I
    //   4: invokestatic sum : ([I)I
    //   7: istore_3
    //   8: aload_0
    //   9: invokevirtual getEvenCounts : ()[I
    //   12: invokestatic sum : ([I)I
    //   15: istore #4
    //   17: iconst_0
    //   18: istore #5
    //   20: iload_1
    //   21: ifeq -> 125
    //   24: iload_3
    //   25: bipush #12
    //   27: if_icmple -> 39
    //   30: iconst_0
    //   31: istore #6
    //   33: iconst_1
    //   34: istore #7
    //   36: goto -> 56
    //   39: iload_3
    //   40: iconst_4
    //   41: if_icmpge -> 50
    //   44: iconst_1
    //   45: istore #6
    //   47: goto -> 53
    //   50: iconst_0
    //   51: istore #6
    //   53: iconst_0
    //   54: istore #7
    //   56: iload #4
    //   58: bipush #12
    //   60: if_icmple -> 76
    //   63: iload #7
    //   65: istore #8
    //   67: iconst_0
    //   68: istore #7
    //   70: iconst_1
    //   71: istore #9
    //   73: goto -> 188
    //   76: iload #4
    //   78: iconst_4
    //   79: if_icmpge -> 92
    //   82: iconst_1
    //   83: istore #9
    //   85: iload #7
    //   87: istore #8
    //   89: goto -> 111
    //   92: iload #7
    //   94: istore #8
    //   96: iload #6
    //   98: istore #9
    //   100: iconst_0
    //   101: istore #7
    //   103: iload #9
    //   105: istore #6
    //   107: iload #7
    //   109: istore #9
    //   111: iconst_0
    //   112: istore #10
    //   114: iload #9
    //   116: istore #7
    //   118: iload #10
    //   120: istore #9
    //   122: goto -> 188
    //   125: iload_3
    //   126: bipush #11
    //   128: if_icmple -> 140
    //   131: iconst_0
    //   132: istore #6
    //   134: iconst_1
    //   135: istore #7
    //   137: goto -> 157
    //   140: iload_3
    //   141: iconst_5
    //   142: if_icmpge -> 151
    //   145: iconst_1
    //   146: istore #6
    //   148: goto -> 154
    //   151: iconst_0
    //   152: istore #6
    //   154: iconst_0
    //   155: istore #7
    //   157: iload #4
    //   159: bipush #10
    //   161: if_icmple -> 171
    //   164: iload #7
    //   166: istore #8
    //   168: goto -> 67
    //   171: iload #6
    //   173: istore #9
    //   175: iload #7
    //   177: istore #8
    //   179: iload #4
    //   181: iconst_4
    //   182: if_icmpge -> 100
    //   185: goto -> 82
    //   188: iload_3
    //   189: iload #4
    //   191: iadd
    //   192: iload_2
    //   193: isub
    //   194: istore #10
    //   196: iload_3
    //   197: iconst_1
    //   198: iand
    //   199: iload_1
    //   200: if_icmpne -> 208
    //   203: iconst_1
    //   204: istore_2
    //   205: goto -> 210
    //   208: iconst_0
    //   209: istore_2
    //   210: iload #4
    //   212: iconst_1
    //   213: iand
    //   214: iconst_1
    //   215: if_icmpne -> 221
    //   218: iconst_1
    //   219: istore #5
    //   221: iload #10
    //   223: iconst_1
    //   224: if_icmpne -> 261
    //   227: iload_2
    //   228: ifeq -> 246
    //   231: iload #5
    //   233: ifne -> 242
    //   236: iconst_1
    //   237: istore #8
    //   239: goto -> 342
    //   242: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   245: athrow
    //   246: iload #5
    //   248: ifeq -> 257
    //   251: iconst_1
    //   252: istore #9
    //   254: goto -> 342
    //   257: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   260: athrow
    //   261: iload #10
    //   263: iconst_m1
    //   264: if_icmpne -> 301
    //   267: iload_2
    //   268: ifeq -> 286
    //   271: iload #5
    //   273: ifne -> 282
    //   276: iconst_1
    //   277: istore #6
    //   279: goto -> 342
    //   282: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   285: athrow
    //   286: iload #5
    //   288: ifeq -> 297
    //   291: iconst_1
    //   292: istore #7
    //   294: goto -> 342
    //   297: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   300: athrow
    //   301: iload #10
    //   303: ifne -> 435
    //   306: iload_2
    //   307: ifeq -> 337
    //   310: iload #5
    //   312: ifeq -> 333
    //   315: iload_3
    //   316: iload #4
    //   318: if_icmpge -> 327
    //   321: iconst_1
    //   322: istore #6
    //   324: goto -> 251
    //   327: iconst_1
    //   328: istore #7
    //   330: goto -> 236
    //   333: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   336: athrow
    //   337: iload #5
    //   339: ifne -> 431
    //   342: iload #6
    //   344: ifeq -> 370
    //   347: iload #8
    //   349: ifne -> 366
    //   352: aload_0
    //   353: invokevirtual getOddCounts : ()[I
    //   356: aload_0
    //   357: invokevirtual getOddRoundingErrors : ()[F
    //   360: invokestatic increment : ([I[F)V
    //   363: goto -> 370
    //   366: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   369: athrow
    //   370: iload #8
    //   372: ifeq -> 386
    //   375: aload_0
    //   376: invokevirtual getOddCounts : ()[I
    //   379: aload_0
    //   380: invokevirtual getOddRoundingErrors : ()[F
    //   383: invokestatic decrement : ([I[F)V
    //   386: iload #7
    //   388: ifeq -> 414
    //   391: iload #9
    //   393: ifne -> 410
    //   396: aload_0
    //   397: invokevirtual getEvenCounts : ()[I
    //   400: aload_0
    //   401: invokevirtual getOddRoundingErrors : ()[F
    //   404: invokestatic increment : ([I[F)V
    //   407: goto -> 414
    //   410: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   413: athrow
    //   414: iload #9
    //   416: ifeq -> 430
    //   419: aload_0
    //   420: invokevirtual getEvenCounts : ()[I
    //   423: aload_0
    //   424: invokevirtual getEvenRoundingErrors : ()[F
    //   427: invokestatic decrement : ([I[F)V
    //   430: return
    //   431: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   434: athrow
    //   435: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   438: athrow
  }
  
  private static boolean checkChecksum(Pair paramPair1, Pair paramPair2) {
    int i = paramPair1.getChecksumPortion();
    int j = paramPair2.getChecksumPortion();
    int k = paramPair1.getFinderPattern().getValue() * 9 + paramPair2.getFinderPattern().getValue();
    int m = k;
    if (k > 72)
      m = k - 1; 
    k = m;
    if (m > 8)
      k = m - 1; 
    return ((i + j * 16) % 79 == k);
  }
  
  private static Result constructResult(Pair paramPair1, Pair paramPair2) {
    String str2 = String.valueOf(paramPair1.getValue() * 4537077L + paramPair2.getValue());
    StringBuilder stringBuilder = new StringBuilder(14);
    int i;
    for (i = 13 - str2.length(); i > 0; i--)
      stringBuilder.append('0'); 
    stringBuilder.append(str2);
    i = 0;
    int j = 0;
    while (i < 13) {
      int k = stringBuilder.charAt(i) - 48;
      int m = k;
      if ((i & 0x1) == 0)
        m = k * 3; 
      j += m;
      i++;
    } 
    j = 10 - j % 10;
    i = j;
    if (j == 10)
      i = 0; 
    stringBuilder.append(i);
    ResultPoint[] arrayOfResultPoint1 = paramPair1.getFinderPattern().getResultPoints();
    ResultPoint[] arrayOfResultPoint2 = paramPair2.getFinderPattern().getResultPoints();
    String str1 = stringBuilder.toString();
    ResultPoint resultPoint1 = arrayOfResultPoint1[0];
    ResultPoint resultPoint2 = arrayOfResultPoint1[1];
    ResultPoint resultPoint3 = arrayOfResultPoint2[0];
    ResultPoint resultPoint4 = arrayOfResultPoint2[1];
    BarcodeFormat barcodeFormat = BarcodeFormat.RSS_14;
    return new Result(str1, null, new ResultPoint[] { resultPoint1, resultPoint2, resultPoint3, resultPoint4 }, barcodeFormat);
  }
  
  private DataCharacter decodeDataCharacter(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean) throws NotFoundException {
    int[] arrayOfInt2 = getDataCharacterCounters();
    int i;
    for (i = 0; i < arrayOfInt2.length; i++)
      arrayOfInt2[i] = 0; 
    if (paramBoolean) {
      recordPatternInReverse(paramBitArray, paramFinderPattern.getStartEnd()[0], arrayOfInt2);
    } else {
      recordPattern(paramBitArray, paramFinderPattern.getStartEnd()[1] + 1, arrayOfInt2);
      i = arrayOfInt2.length - 1;
      j = 0;
      while (j < i) {
        int i1 = arrayOfInt2[j];
        arrayOfInt2[j] = arrayOfInt2[i];
        arrayOfInt2[i] = i1;
        j++;
        i--;
      } 
    } 
    if (paramBoolean) {
      j = 16;
    } else {
      j = 15;
    } 
    float f = MathUtils.sum(arrayOfInt2) / j;
    int[] arrayOfInt3 = getOddCounts();
    int[] arrayOfInt1 = getEvenCounts();
    float[] arrayOfFloat2 = getOddRoundingErrors();
    float[] arrayOfFloat1 = getEvenRoundingErrors();
    int k;
    for (k = 0; k < arrayOfInt2.length; k++) {
      float f1 = arrayOfInt2[k] / f;
      int i1 = (int)(0.5F + f1);
      if (i1 <= 0) {
        i = 1;
      } else {
        i = i1;
        if (i1 > 8)
          i = 8; 
      } 
      i1 = k / 2;
      if ((k & 0x1) == 0) {
        arrayOfInt3[i1] = i;
        arrayOfFloat2[i1] = f1 - i;
      } else {
        arrayOfInt1[i1] = i;
        arrayOfFloat1[i1] = f1 - i;
      } 
    } 
    adjustOddEvenCounts(paramBoolean, j);
    k = arrayOfInt3.length - 1;
    int j = 0;
    i = 0;
    while (k >= 0) {
      j = j * 9 + arrayOfInt3[k];
      i += arrayOfInt3[k];
      k--;
    } 
    k = arrayOfInt1.length - 1;
    int n = 0;
    int m = 0;
    while (k >= 0) {
      n = n * 9 + arrayOfInt1[k];
      m += arrayOfInt1[k];
      k--;
    } 
    j += n * 3;
    if (paramBoolean) {
      if ((i & 0x1) == 0 && i <= 12 && i >= 4) {
        k = (12 - i) / 2;
        m = OUTSIDE_ODD_WIDEST[k];
        i = RSSUtils.getRSSvalue(arrayOfInt3, m, false);
        m = RSSUtils.getRSSvalue(arrayOfInt1, 9 - m, true);
        return new DataCharacter(i * OUTSIDE_EVEN_TOTAL_SUBSET[k] + m + OUTSIDE_GSUM[k], j);
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    if ((m & 0x1) == 0 && m <= 10 && m >= 4) {
      i = (10 - m) / 2;
      k = INSIDE_ODD_WIDEST[i];
      m = RSSUtils.getRSSvalue(arrayOfInt3, k, true);
      return new DataCharacter(RSSUtils.getRSSvalue(arrayOfInt1, 9 - k, false) * INSIDE_ODD_TOTAL_SUBSET[i] + m + INSIDE_GSUM[i], j);
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private Pair decodePair(BitArray paramBitArray, boolean paramBoolean, int paramInt, Map<DecodeHintType, ?> paramMap) {
    try {
      ResultPointCallback resultPointCallback;
      int[] arrayOfInt = findFinderPattern(paramBitArray, paramBoolean);
      FinderPattern finderPattern = parseFoundFinderPattern(paramBitArray, paramInt, paramBoolean, arrayOfInt);
      if (paramMap == null) {
        paramMap = null;
      } else {
        resultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
      } 
      if (resultPointCallback != null) {
        float f1 = (arrayOfInt[0] + arrayOfInt[1]) / 2.0F;
        float f2 = f1;
        if (paramBoolean)
          f2 = (paramBitArray.getSize() - 1) - f1; 
        ResultPoint resultPoint = new ResultPoint();
        this(f2, paramInt);
        resultPointCallback.foundPossibleResultPoint(resultPoint);
      } 
      DataCharacter dataCharacter = decodeDataCharacter(paramBitArray, finderPattern, true);
      null = decodeDataCharacter(paramBitArray, finderPattern, false);
      return new Pair(dataCharacter.getValue() * 1597 + null.getValue(), dataCharacter.getChecksumPortion() + null.getChecksumPortion() * 4, finderPattern);
    } catch (NotFoundException notFoundException) {
      return null;
    } 
  }
  
  private int[] findFinderPattern(BitArray paramBitArray, int paramBoolean) throws NotFoundException {
    int m;
    int[] arrayOfInt = getDecodeFinderCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int j = paramBitArray.getSize();
    int k = 0;
    int n = 0;
    while (k < j) {
      int i4 = paramBitArray.get(k) ^ true;
      n = i4;
      if (paramBoolean != i4) {
        k++;
        m = i4;
      } 
    } 
    int i1 = k;
    int i2 = 0;
    int i = m;
    int i3 = k;
    while (i3 < j) {
      if (paramBitArray.get(i3) != i) {
        arrayOfInt[i2] = arrayOfInt[i2] + 1;
        k = i2;
      } else {
        if (i2 == 3) {
          if (isFinderPattern(arrayOfInt))
            return new int[] { i1, i3 }; 
          i1 += arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          k = i2 - 1;
        } else {
          k = i2 + 1;
        } 
        arrayOfInt[k] = 1;
        if (i == 0) {
          boolean bool = true;
        } else {
          boolean bool = false;
        } 
      } 
      i3++;
      i2 = k;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private FinderPattern parseFoundFinderPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfint) throws NotFoundException {
    boolean bool = paramBitArray.get(paramArrayOfint[0]);
    int i;
    for (i = paramArrayOfint[0] - 1; i >= 0 && bool != paramBitArray.get(i); i--);
    int j = i + 1;
    i = paramArrayOfint[0];
    int[] arrayOfInt = getDecodeFinderCounters();
    System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, arrayOfInt.length - 1);
    arrayOfInt[0] = i - j;
    int k = parseFinderValue(arrayOfInt, FINDER_PATTERNS);
    int m = paramArrayOfint[1];
    if (paramBoolean) {
      i = paramBitArray.getSize();
      m = paramBitArray.getSize() - 1 - m;
      i = i - 1 - j;
    } else {
      i = j;
    } 
    return new FinderPattern(k, new int[] { j, paramArrayOfint[1] }, i, m, paramInt);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    Pair pair2 = decodePair(paramBitArray, false, paramInt, paramMap);
    addOrTally(this.possibleLeftPairs, pair2);
    paramBitArray.reverse();
    pair1 = decodePair(paramBitArray, true, paramInt, paramMap);
    addOrTally(this.possibleRightPairs, pair1);
    paramBitArray.reverse();
    for (Pair pair : this.possibleLeftPairs) {
      if (pair.getCount() > 1)
        for (Pair pair1 : this.possibleRightPairs) {
          if (pair1.getCount() > 1 && checkChecksum(pair, pair1))
            return constructResult(pair, pair1); 
        }  
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset() {
    this.possibleLeftPairs.clear();
    this.possibleRightPairs.clear();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\RSS14Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */