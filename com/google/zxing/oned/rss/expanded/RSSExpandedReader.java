package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {
  private static final int[] EVEN_TOTAL_SUBSET;
  
  private static final int[][] FINDER_PATTERNS;
  
  private static final int[][] FINDER_PATTERN_SEQUENCES;
  
  private static final int FINDER_PAT_A = 0;
  
  private static final int FINDER_PAT_B = 1;
  
  private static final int FINDER_PAT_C = 2;
  
  private static final int FINDER_PAT_D = 3;
  
  private static final int FINDER_PAT_E = 4;
  
  private static final int FINDER_PAT_F = 5;
  
  private static final int[] GSUM;
  
  private static final int MAX_PAIRS = 11;
  
  private static final int[] SYMBOL_WIDEST = new int[] { 7, 5, 4, 3, 1 };
  
  private static final int[][] WEIGHTS;
  
  private final List<ExpandedPair> pairs = new ArrayList<ExpandedPair>(11);
  
  private final List<ExpandedRow> rows = new ArrayList<ExpandedRow>();
  
  private final int[] startEnd = new int[2];
  
  private boolean startFromEven;
  
  static {
    EVEN_TOTAL_SUBSET = new int[] { 4, 20, 52, 104, 204 };
    GSUM = new int[] { 0, 348, 1388, 2948, 3988 };
    FINDER_PATTERNS = new int[][] { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, { 3, 4, 6, 1 }, { 3, 2, 8, 1 }, { 2, 6, 5, 1 }, { 2, 2, 9, 1 } };
    int[] arrayOfInt1 = { 185, 133, 188, 142, 4, 12, 36, 108 };
    int[] arrayOfInt2 = { 120, 149, 25, 75, 14, 42, 126, 167 };
    int[] arrayOfInt3 = { 55, 165, 73, 8, 24, 72, 5, 15 };
    WEIGHTS = new int[][] { 
        { 1, 3, 9, 27, 81, 32, 96, 77 }, { 20, 60, 180, 118, 143, 7, 21, 63 }, { 189, 145, 13, 39, 117, 140, 209, 205 }, { 193, 157, 49, 147, 19, 57, 171, 91 }, { 62, 186, 136, 197, 169, 85, 44, 132 }, arrayOfInt1, { 113, 128, 173, 97, 80, 29, 87, 50 }, { 150, 28, 84, 41, 123, 158, 52, 156 }, { 46, 138, 203, 187, 139, 206, 196, 166 }, { 76, 17, 51, 153, 37, 111, 122, 155 }, 
        { 43, 129, 176, 106, 107, 110, 119, 146 }, { 16, 48, 144, 10, 30, 90, 59, 177 }, { 109, 116, 137, 200, 178, 112, 125, 164 }, { 70, 210, 208, 202, 184, 130, 179, 115 }, { 134, 191, 151, 31, 93, 68, 204, 190 }, { 148, 22, 66, 198, 172, 94, 71, 2 }, { 6, 18, 54, 162, 64, 192, 154, 40 }, arrayOfInt2, { 79, 26, 78, 23, 69, 207, 199, 175 }, { 103, 98, 83, 38, 114, 131, 182, 124 }, 
        { 161, 61, 183, 127, 170, 88, 53, 159 }, arrayOfInt3, { 45, 135, 194, 160, 58, 174, 100, 89 } };
    arrayOfInt1 = new int[] { 0, 0 };
    arrayOfInt2 = new int[] { 0, 2, 1, 3 };
    arrayOfInt3 = new int[] { 0, 4, 1, 3, 2 };
    int[] arrayOfInt4 = { 0, 4, 1, 3, 3, 5 };
    int[] arrayOfInt5 = { 0, 4, 1, 3, 4, 5, 5 };
    int[] arrayOfInt6 = { 0, 0, 1, 1, 2, 2, 3, 3 };
    int[] arrayOfInt7 = { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 };
    int[] arrayOfInt8 = { 
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 
        5 };
    FINDER_PATTERN_SEQUENCES = new int[][] { arrayOfInt1, { 0, 1, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 0, 0, 1, 1, 2, 2, 3, 4, 4 }, arrayOfInt7, arrayOfInt8 };
  }
  
  private void adjustOddEvenCounts(int paramInt) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getOddCounts : ()[I
    //   4: invokestatic sum : ([I)I
    //   7: istore_2
    //   8: aload_0
    //   9: invokevirtual getEvenCounts : ()[I
    //   12: invokestatic sum : ([I)I
    //   15: istore_3
    //   16: iconst_0
    //   17: istore #4
    //   19: iload_2
    //   20: bipush #13
    //   22: if_icmple -> 34
    //   25: iconst_1
    //   26: istore #5
    //   28: iconst_0
    //   29: istore #6
    //   31: goto -> 54
    //   34: iload_2
    //   35: iconst_4
    //   36: if_icmpge -> 48
    //   39: iconst_0
    //   40: istore #5
    //   42: iconst_1
    //   43: istore #6
    //   45: goto -> 54
    //   48: iconst_0
    //   49: istore #5
    //   51: goto -> 28
    //   54: iload_3
    //   55: bipush #13
    //   57: if_icmple -> 69
    //   60: iconst_0
    //   61: istore #7
    //   63: iconst_1
    //   64: istore #8
    //   66: goto -> 86
    //   69: iload_3
    //   70: iconst_4
    //   71: if_icmpge -> 80
    //   74: iconst_1
    //   75: istore #7
    //   77: goto -> 83
    //   80: iconst_0
    //   81: istore #7
    //   83: iconst_0
    //   84: istore #8
    //   86: iload_2
    //   87: iload_3
    //   88: iadd
    //   89: iload_1
    //   90: isub
    //   91: istore #9
    //   93: iload_2
    //   94: iconst_1
    //   95: iand
    //   96: iconst_1
    //   97: if_icmpne -> 105
    //   100: iconst_1
    //   101: istore_1
    //   102: goto -> 107
    //   105: iconst_0
    //   106: istore_1
    //   107: iload_3
    //   108: iconst_1
    //   109: iand
    //   110: ifne -> 116
    //   113: iconst_1
    //   114: istore #4
    //   116: iload #9
    //   118: iconst_1
    //   119: if_icmpne -> 156
    //   122: iload_1
    //   123: ifeq -> 141
    //   126: iload #4
    //   128: ifne -> 137
    //   131: iconst_1
    //   132: istore #5
    //   134: goto -> 236
    //   137: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   140: athrow
    //   141: iload #4
    //   143: ifeq -> 152
    //   146: iconst_1
    //   147: istore #8
    //   149: goto -> 236
    //   152: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   155: athrow
    //   156: iload #9
    //   158: iconst_m1
    //   159: if_icmpne -> 196
    //   162: iload_1
    //   163: ifeq -> 181
    //   166: iload #4
    //   168: ifne -> 177
    //   171: iconst_1
    //   172: istore #6
    //   174: goto -> 236
    //   177: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   180: athrow
    //   181: iload #4
    //   183: ifeq -> 192
    //   186: iconst_1
    //   187: istore #7
    //   189: goto -> 236
    //   192: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   195: athrow
    //   196: iload #9
    //   198: ifne -> 329
    //   201: iload_1
    //   202: ifeq -> 231
    //   205: iload #4
    //   207: ifeq -> 227
    //   210: iload_2
    //   211: iload_3
    //   212: if_icmpge -> 221
    //   215: iconst_1
    //   216: istore #8
    //   218: goto -> 171
    //   221: iconst_1
    //   222: istore #7
    //   224: goto -> 131
    //   227: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   230: athrow
    //   231: iload #4
    //   233: ifne -> 325
    //   236: iload #6
    //   238: ifeq -> 264
    //   241: iload #5
    //   243: ifne -> 260
    //   246: aload_0
    //   247: invokevirtual getOddCounts : ()[I
    //   250: aload_0
    //   251: invokevirtual getOddRoundingErrors : ()[F
    //   254: invokestatic increment : ([I[F)V
    //   257: goto -> 264
    //   260: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   263: athrow
    //   264: iload #5
    //   266: ifeq -> 280
    //   269: aload_0
    //   270: invokevirtual getOddCounts : ()[I
    //   273: aload_0
    //   274: invokevirtual getOddRoundingErrors : ()[F
    //   277: invokestatic decrement : ([I[F)V
    //   280: iload #7
    //   282: ifeq -> 308
    //   285: iload #8
    //   287: ifne -> 304
    //   290: aload_0
    //   291: invokevirtual getEvenCounts : ()[I
    //   294: aload_0
    //   295: invokevirtual getOddRoundingErrors : ()[F
    //   298: invokestatic increment : ([I[F)V
    //   301: goto -> 308
    //   304: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   307: athrow
    //   308: iload #8
    //   310: ifeq -> 324
    //   313: aload_0
    //   314: invokevirtual getEvenCounts : ()[I
    //   317: aload_0
    //   318: invokevirtual getEvenRoundingErrors : ()[F
    //   321: invokestatic decrement : ([I[F)V
    //   324: return
    //   325: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   328: athrow
    //   329: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   332: athrow
  }
  
  private boolean checkChecksum() {
    ExpandedPair expandedPair = this.pairs.get(0);
    DataCharacter dataCharacter2 = expandedPair.getLeftChar();
    DataCharacter dataCharacter1 = expandedPair.getRightChar();
    if (dataCharacter1 == null)
      return false; 
    int i = dataCharacter1.getChecksumPortion();
    byte b = 1;
    int j = 2;
    while (b < this.pairs.size()) {
      ExpandedPair expandedPair1 = this.pairs.get(b);
      int k = i + expandedPair1.getLeftChar().getChecksumPortion();
      int m = j + 1;
      DataCharacter dataCharacter = expandedPair1.getRightChar();
      i = k;
      j = m;
      if (dataCharacter != null) {
        i = k + dataCharacter.getChecksumPortion();
        j = m + 1;
      } 
      b++;
    } 
    return ((j - 4) * 211 + i % 211 == dataCharacter2.getValue());
  }
  
  private List<ExpandedPair> checkRows(List<ExpandedRow> paramList, int paramInt) throws NotFoundException {
    while (true) {
      if (paramInt < this.rows.size()) {
        ExpandedRow expandedRow = this.rows.get(paramInt);
        this.pairs.clear();
        for (ExpandedRow expandedRow1 : paramList)
          this.pairs.addAll(expandedRow1.getPairs()); 
        this.pairs.addAll(expandedRow.getPairs());
        if (isValidSequence(this.pairs)) {
          if (checkChecksum())
            return this.pairs; 
          ArrayList<ExpandedRow> arrayList = new ArrayList<ExpandedRow>(paramList);
          arrayList.add(expandedRow);
          try {
            return checkRows(arrayList, paramInt + 1);
          } catch (NotFoundException notFoundException) {}
        } 
        paramInt++;
        continue;
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
  }
  
  private List<ExpandedPair> checkRows(boolean paramBoolean) {
    if (this.rows.size() > 25) {
      this.rows.clear();
      return null;
    } 
    this.pairs.clear();
    if (paramBoolean)
      Collections.reverse(this.rows); 
    try {
      ArrayList<ExpandedRow> arrayList = new ArrayList();
      this();
      List<ExpandedPair> list = checkRows(arrayList, 0);
    } catch (NotFoundException notFoundException) {
      notFoundException = null;
    } 
    if (paramBoolean)
      Collections.reverse(this.rows); 
    return (List<ExpandedPair>)notFoundException;
  }
  
  static Result constructResult(List<ExpandedPair> paramList) throws NotFoundException, FormatException {
    String str = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(paramList)).parseInformation();
    ResultPoint[] arrayOfResultPoint1 = ((ExpandedPair)paramList.get(0)).getFinderPattern().getResultPoints();
    ResultPoint[] arrayOfResultPoint2 = ((ExpandedPair)paramList.get(paramList.size() - 1)).getFinderPattern().getResultPoints();
    ResultPoint resultPoint1 = arrayOfResultPoint1[0];
    ResultPoint resultPoint2 = arrayOfResultPoint1[1];
    ResultPoint resultPoint3 = arrayOfResultPoint2[0];
    ResultPoint resultPoint4 = arrayOfResultPoint2[1];
    BarcodeFormat barcodeFormat = BarcodeFormat.RSS_EXPANDED;
    return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2, resultPoint3, resultPoint4 }, barcodeFormat);
  }
  
  private void findNextPair(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt) throws NotFoundException {
    int[] arrayOfInt = getDecodeFinderCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    if (paramInt < 0)
      if (paramList.isEmpty()) {
        paramInt = 0;
      } else {
        paramInt = ((ExpandedPair)paramList.get(paramList.size() - 1)).getFinderPattern().getStartEnd()[1];
      }  
    if (paramList.size() % 2 != 0) {
      j = 1;
    } else {
      j = 0;
    } 
    int k = j;
    if (this.startFromEven)
      k = j ^ 0x1; 
    int m = 0;
    while (paramInt < i) {
      int i1 = paramBitArray.get(paramInt) ^ true;
      m = i1;
      if (i1 != 0) {
        paramInt++;
        m = i1;
      } 
    } 
    int j = paramInt;
    boolean bool = false;
    int n = paramInt;
    paramInt = j;
    j = bool;
    while (n < i) {
      if (paramBitArray.get(n) != m) {
        arrayOfInt[j] = arrayOfInt[j] + 1;
      } else {
        if (j == 3) {
          if (k != 0)
            reverseCounters(arrayOfInt); 
          if (isFinderPattern(arrayOfInt)) {
            this.startEnd[0] = paramInt;
            this.startEnd[1] = n;
            return;
          } 
          if (k != 0)
            reverseCounters(arrayOfInt); 
          paramInt += arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          j--;
        } else {
          j++;
        } 
        arrayOfInt[j] = 1;
        if (m == 0) {
          m = 1;
        } else {
          m = 0;
        } 
      } 
      n++;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int getNextSecondBar(BitArray paramBitArray, int paramInt) {
    if (paramBitArray.get(paramInt)) {
      paramInt = paramBitArray.getNextSet(paramBitArray.getNextUnset(paramInt));
    } else {
      paramInt = paramBitArray.getNextUnset(paramBitArray.getNextSet(paramInt));
    } 
    return paramInt;
  }
  
  private static boolean isNotA1left(FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2) {
    return (paramFinderPattern.getValue() != 0 || !paramBoolean1 || !paramBoolean2);
  }
  
  private static boolean isPartialRow(Iterable<ExpandedPair> paramIterable, Iterable<ExpandedRow> paramIterable1) {
    Iterator<ExpandedRow> iterator = paramIterable1.iterator();
    while (true) {
      boolean bool = iterator.hasNext();
      boolean bool1 = false;
      if (bool) {
        boolean bool2;
        ExpandedRow expandedRow = iterator.next();
        Iterator<ExpandedPair> iterator1 = paramIterable.iterator();
        while (true) {
          if (iterator1.hasNext()) {
            boolean bool3;
            ExpandedPair expandedPair = iterator1.next();
            Iterator<ExpandedPair> iterator2 = expandedRow.getPairs().iterator();
            while (true) {
              if (iterator2.hasNext()) {
                if (expandedPair.equals(iterator2.next())) {
                  boolean bool4 = true;
                  break;
                } 
                continue;
              } 
              bool3 = false;
              break;
            } 
            if (!bool3) {
              bool3 = bool1;
              break;
            } 
            continue;
          } 
          bool2 = true;
          break;
        } 
        if (bool2)
          return true; 
        continue;
      } 
      return false;
    } 
  }
  
  private static boolean isValidSequence(List<ExpandedPair> paramList) {
    for (int[] arrayOfInt : FINDER_PATTERN_SEQUENCES) {
      if (paramList.size() <= arrayOfInt.length) {
        byte b = 0;
        while (true) {
          if (b < paramList.size()) {
            if (((ExpandedPair)paramList.get(b)).getFinderPattern().getValue() != arrayOfInt[b]) {
              b = 0;
              break;
            } 
            b++;
            continue;
          } 
          b = 1;
          break;
        } 
        if (b != 0)
          return true; 
      } 
    } 
    return false;
  }
  
  private FinderPattern parseFoundFinderPattern(BitArray paramBitArray, int paramInt, boolean paramBoolean) {
    int i;
    int j;
    int k;
    if (paramBoolean) {
      for (i = this.startEnd[0] - 1; i >= 0 && !paramBitArray.get(i); i--);
      j = this.startEnd[0] - ++i;
      k = this.startEnd[1];
    } else {
      i = this.startEnd[0];
      k = paramBitArray.getNextUnset(this.startEnd[1] + 1);
      j = k - this.startEnd[1];
    } 
    int[] arrayOfInt = getDecodeFinderCounters();
    System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, arrayOfInt.length - 1);
    arrayOfInt[0] = j;
    try {
      j = parseFinderValue(arrayOfInt, FINDER_PATTERNS);
      return new FinderPattern(j, new int[] { i, k }, i, k, paramInt);
    } catch (NotFoundException notFoundException) {
      return null;
    } 
  }
  
  private static void removePartialRows(List<ExpandedPair> paramList, List<ExpandedRow> paramList1) {
    Iterator<ExpandedRow> iterator = paramList1.iterator();
    while (true) {
      boolean bool;
      if (iterator.hasNext()) {
        ExpandedRow expandedRow = iterator.next();
        if (expandedRow.getPairs().size() != paramList.size()) {
          Iterator<ExpandedPair> iterator1 = expandedRow.getPairs().iterator();
          while (true) {
            boolean bool1 = iterator1.hasNext();
            boolean bool2 = false;
            bool = true;
            if (bool1) {
              ExpandedPair expandedPair = iterator1.next();
              Iterator<ExpandedPair> iterator2 = paramList.iterator();
              while (true) {
                if (iterator2.hasNext()) {
                  if (expandedPair.equals(iterator2.next()))
                    break; 
                  continue;
                } 
                bool = false;
                break;
              } 
              if (!bool) {
                bool = bool2;
              } else {
                continue;
              } 
            } else {
              bool = true;
              break;
            } 
            if (bool)
              iterator.remove(); 
          } 
        } else {
          continue;
        } 
      } else {
        break;
      } 
      if (bool)
        iterator.remove(); 
    } 
  }
  
  private static void reverseCounters(int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    for (byte b = 0; b < i / 2; b++) {
      int j = paramArrayOfint[b];
      int k = i - b - 1;
      paramArrayOfint[b] = paramArrayOfint[k];
      paramArrayOfint[k] = j;
    } 
  }
  
  private void storeRow(int paramInt, boolean paramBoolean) {
    boolean bool3;
    boolean bool1 = false;
    byte b = 0;
    boolean bool2 = false;
    while (true) {
      bool3 = bool1;
      if (b < this.rows.size()) {
        ExpandedRow expandedRow = this.rows.get(b);
        if (expandedRow.getRowNumber() > paramInt) {
          bool3 = expandedRow.isEquivalent(this.pairs);
          break;
        } 
        bool2 = expandedRow.isEquivalent(this.pairs);
        b++;
        continue;
      } 
      break;
    } 
    if (bool3 || bool2)
      return; 
    if (isPartialRow(this.pairs, this.rows))
      return; 
    this.rows.add(b, new ExpandedRow(this.pairs, paramInt, paramBoolean));
    removePartialRows(this.pairs, this.rows);
  }
  
  DataCharacter decodeDataCharacter(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2) throws NotFoundException {
    int[] arrayOfInt = getDataCharacterCounters();
    int i;
    for (i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = 0; 
    if (paramBoolean2) {
      recordPatternInReverse(paramBitArray, paramFinderPattern.getStartEnd()[0], arrayOfInt);
    } else {
      recordPattern(paramBitArray, paramFinderPattern.getStartEnd()[1], arrayOfInt);
      i = arrayOfInt.length - 1;
      byte b = 0;
      while (b < i) {
        int j = arrayOfInt[b];
        arrayOfInt[b] = arrayOfInt[i];
        arrayOfInt[i] = j;
        b++;
        i--;
      } 
    } 
    float f1 = MathUtils.sum(arrayOfInt) / 17.0F;
    float f2 = (paramFinderPattern.getStartEnd()[1] - paramFinderPattern.getStartEnd()[0]) / 15.0F;
    if (Math.abs(f1 - f2) / f2 <= 0.3F) {
      int[] arrayOfInt1 = getOddCounts();
      int[] arrayOfInt2 = getEvenCounts();
      float[] arrayOfFloat2 = getOddRoundingErrors();
      float[] arrayOfFloat1 = getEvenRoundingErrors();
      int j;
      for (j = 0; j < arrayOfInt.length; j++) {
        f2 = arrayOfInt[j] * 1.0F / f1;
        int i1 = (int)(0.5F + f2);
        if (i1 <= 0) {
          if (f2 >= 0.3F) {
            i = 1;
          } else {
            throw NotFoundException.getNotFoundInstance();
          } 
        } else {
          i = i1;
          if (i1 > 8)
            if (f2 <= 8.7F) {
              i = 8;
            } else {
              throw NotFoundException.getNotFoundInstance();
            }  
        } 
        i1 = j / 2;
        if ((j & 0x1) == 0) {
          arrayOfInt1[i1] = i;
          arrayOfFloat2[i1] = f2 - i;
        } else {
          arrayOfInt2[i1] = i;
          arrayOfFloat1[i1] = f2 - i;
        } 
      } 
      adjustOddEvenCounts(17);
      j = paramFinderPattern.getValue();
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 2;
      } 
      int m = j * 4 + i + (paramBoolean2 ^ true) - 1;
      int k = arrayOfInt1.length - 1;
      i = 0;
      j = 0;
      while (k >= 0) {
        int i1 = i;
        if (isNotA1left(paramFinderPattern, paramBoolean1, paramBoolean2)) {
          i1 = WEIGHTS[m][k * 2];
          i1 = i + arrayOfInt1[k] * i1;
        } 
        j += arrayOfInt1[k];
        k--;
        i = i1;
      } 
      int n = arrayOfInt2.length - 1;
      for (k = 0; n >= 0; k = i1) {
        int i1 = k;
        if (isNotA1left(paramFinderPattern, paramBoolean1, paramBoolean2)) {
          i1 = WEIGHTS[m][n * 2 + 1];
          i1 = k + arrayOfInt2[n] * i1;
        } 
        n--;
      } 
      if ((j & 0x1) == 0 && j <= 13 && j >= 4) {
        j = (13 - j) / 2;
        int i1 = SYMBOL_WIDEST[j];
        n = RSSUtils.getRSSvalue(arrayOfInt1, i1, true);
        i1 = RSSUtils.getRSSvalue(arrayOfInt2, 9 - i1, false);
        return new DataCharacter(n * EVEN_TOTAL_SUBSET[j] + i1 + GSUM[j], i + k);
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    this.pairs.clear();
    this.startFromEven = false;
    try {
      return constructResult(decodeRow2pairs(paramInt, paramBitArray));
    } catch (NotFoundException notFoundException) {
      this.pairs.clear();
      this.startFromEven = true;
      return constructResult(decodeRow2pairs(paramInt, paramBitArray));
    } 
  }
  
  List<ExpandedPair> decodeRow2pairs(int paramInt, BitArray paramBitArray) throws NotFoundException {
    boolean bool = false;
    while (!bool) {
      try {
        this.pairs.add(retrieveNextPair(paramBitArray, this.pairs, paramInt));
      } catch (NotFoundException notFoundException) {
        if (!this.pairs.isEmpty()) {
          bool = true;
          continue;
        } 
        throw notFoundException;
      } 
    } 
    if (checkChecksum())
      return this.pairs; 
    boolean bool1 = this.rows.isEmpty();
    storeRow(paramInt, false);
    if ((bool1 ^ true) != 0) {
      List<ExpandedPair> list = checkRows(false);
      if (list != null)
        return list; 
      list = checkRows(true);
      if (list != null)
        return list; 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  List<ExpandedRow> getRows() {
    return this.rows;
  }
  
  public void reset() {
    this.pairs.clear();
    this.rows.clear();
  }
  
  ExpandedPair retrieveNextPair(BitArray paramBitArray, List<ExpandedPair> paramList, int paramInt) throws NotFoundException {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface size : ()I
    //   6: iconst_2
    //   7: irem
    //   8: ifne -> 17
    //   11: iconst_1
    //   12: istore #4
    //   14: goto -> 20
    //   17: iconst_0
    //   18: istore #4
    //   20: iload #4
    //   22: istore #5
    //   24: aload_0
    //   25: getfield startFromEven : Z
    //   28: ifeq -> 37
    //   31: iload #4
    //   33: iconst_1
    //   34: ixor
    //   35: istore #5
    //   37: iconst_m1
    //   38: istore #6
    //   40: iconst_1
    //   41: istore #7
    //   43: aload_0
    //   44: aload_1
    //   45: aload_2
    //   46: iload #6
    //   48: invokespecial findNextPair : (Lcom/google/zxing/common/BitArray;Ljava/util/List;I)V
    //   51: aload_0
    //   52: aload_1
    //   53: iload_3
    //   54: iload #5
    //   56: invokespecial parseFoundFinderPattern : (Lcom/google/zxing/common/BitArray;IZ)Lcom/google/zxing/oned/rss/FinderPattern;
    //   59: astore #8
    //   61: aload #8
    //   63: ifnonnull -> 85
    //   66: aload_1
    //   67: aload_0
    //   68: getfield startEnd : [I
    //   71: iconst_0
    //   72: iaload
    //   73: invokestatic getNextSecondBar : (Lcom/google/zxing/common/BitArray;I)I
    //   76: istore #6
    //   78: iload #7
    //   80: istore #9
    //   82: goto -> 88
    //   85: iconst_0
    //   86: istore #9
    //   88: iload #9
    //   90: istore #7
    //   92: iload #9
    //   94: ifne -> 43
    //   97: aload_0
    //   98: aload_1
    //   99: aload #8
    //   101: iload #5
    //   103: iconst_1
    //   104: invokevirtual decodeDataCharacter : (Lcom/google/zxing/common/BitArray;Lcom/google/zxing/oned/rss/FinderPattern;ZZ)Lcom/google/zxing/oned/rss/DataCharacter;
    //   107: astore #10
    //   109: aload_2
    //   110: invokeinterface isEmpty : ()Z
    //   115: ifne -> 148
    //   118: aload_2
    //   119: aload_2
    //   120: invokeinterface size : ()I
    //   125: iconst_1
    //   126: isub
    //   127: invokeinterface get : (I)Ljava/lang/Object;
    //   132: checkcast com/google/zxing/oned/rss/expanded/ExpandedPair
    //   135: invokevirtual mustBeLast : ()Z
    //   138: ifne -> 144
    //   141: goto -> 148
    //   144: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   147: athrow
    //   148: aload_0
    //   149: aload_1
    //   150: aload #8
    //   152: iload #5
    //   154: iconst_0
    //   155: invokevirtual decodeDataCharacter : (Lcom/google/zxing/common/BitArray;Lcom/google/zxing/oned/rss/FinderPattern;ZZ)Lcom/google/zxing/oned/rss/DataCharacter;
    //   158: astore_1
    //   159: goto -> 165
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_1
    //   165: new com/google/zxing/oned/rss/expanded/ExpandedPair
    //   168: dup
    //   169: aload #10
    //   171: aload_1
    //   172: aload #8
    //   174: iconst_1
    //   175: invokespecial <init> : (Lcom/google/zxing/oned/rss/DataCharacter;Lcom/google/zxing/oned/rss/DataCharacter;Lcom/google/zxing/oned/rss/FinderPattern;Z)V
    //   178: areturn
    // Exception table:
    //   from	to	target	type
    //   148	159	162	com/google/zxing/NotFoundException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\RSSExpandedReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */