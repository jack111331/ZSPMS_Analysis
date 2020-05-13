package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class CodaBarReader extends OneDReader {
  static final char[] ALPHABET = "0123456789-$:/.+ABCD".toCharArray();
  
  private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
  
  static final int[] CHARACTER_ENCODINGS = new int[] { 
      3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 
      12, 24, 69, 81, 84, 21, 26, 41, 11, 14 };
  
  private static final float MAX_ACCEPTABLE = 2.0F;
  
  private static final int MIN_CHARACTER_LENGTH = 3;
  
  private static final float PADDING = 1.5F;
  
  private static final char[] STARTEND_ENCODING = new char[] { 'A', 'B', 'C', 'D' };
  
  private int counterLength = 0;
  
  private int[] counters = new int[80];
  
  private final StringBuilder decodeRowResult = new StringBuilder(20);
  
  static boolean arrayContains(char[] paramArrayOfchar, char paramChar) {
    if (paramArrayOfchar != null) {
      int i = paramArrayOfchar.length;
      for (byte b = 0; b < i; b++) {
        if (paramArrayOfchar[b] == paramChar)
          return true; 
      } 
    } 
    return false;
  }
  
  private void counterAppend(int paramInt) {
    this.counters[this.counterLength] = paramInt;
    this.counterLength++;
    if (this.counterLength >= this.counters.length) {
      int[] arrayOfInt = new int[this.counterLength << 1];
      System.arraycopy(this.counters, 0, arrayOfInt, 0, this.counterLength);
      this.counters = arrayOfInt;
    } 
  }
  
  private int findStartPattern() throws NotFoundException {
    for (byte b = 1; b < this.counterLength; b += 2) {
      int i = toNarrowWidePattern(b);
      if (i != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[i])) {
        byte b1 = b;
        i = 0;
        while (b1 < b + 7) {
          i += this.counters[b1];
          b1++;
        } 
        if (b == 1 || this.counters[b - 1] >= i / 2)
          return b; 
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private void setCounters(BitArray paramBitArray) throws NotFoundException {
    this.counterLength = 0;
    int i = paramBitArray.getNextUnset(0);
    int j = paramBitArray.getSize();
    if (i < j) {
      boolean bool = true;
      byte b = 0;
      while (i < j) {
        if (paramBitArray.get(i) != bool) {
          b++;
        } else {
          counterAppend(b);
          int k = bool ^ true;
          b = 1;
        } 
        i++;
      } 
      counterAppend(b);
      return;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private int toNarrowWidePattern(int paramInt) {
    int i = paramInt + 7;
    if (i >= this.counterLength)
      return -1; 
    int[] arrayOfInt = this.counters;
    int j = Integer.MAX_VALUE;
    boolean bool = false;
    int k = paramInt;
    int m = Integer.MAX_VALUE;
    int n;
    for (n = 0; k < i; n = i7) {
      int i5 = arrayOfInt[k];
      int i6 = m;
      if (i5 < m)
        i6 = i5; 
      int i7 = n;
      if (i5 > n)
        i7 = i5; 
      k += 2;
      m = i6;
    } 
    int i4 = (m + n) / 2;
    n = paramInt + 1;
    k = 0;
    int i1 = j;
    while (n < i) {
      m = arrayOfInt[n];
      int i5 = i1;
      if (m < i1)
        i5 = m; 
      int i6 = k;
      if (m > k)
        i6 = m; 
      n += 2;
      i1 = i5;
      k = i6;
    } 
    int i3 = (i1 + k) / 2;
    k = 0;
    int i2 = 128;
    n = 0;
    while (true) {
      m = bool;
      if (k < 7) {
        if ((k & 0x1) == 0) {
          i1 = i4;
        } else {
          i1 = i3;
        } 
        i2 >>= 1;
        m = n;
        if (arrayOfInt[paramInt + k] > i1)
          m = n | i2; 
        k++;
        n = m;
        continue;
      } 
      break;
    } 
    while (m < CHARACTER_ENCODINGS.length) {
      if (CHARACTER_ENCODINGS[m] == n)
        return m; 
      m++;
    } 
    return -1;
  }
  
  private void validatePattern(int paramInt) throws NotFoundException {
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 0;
    arrayOfInt2[2] = 0;
    arrayOfInt2[3] = 0;
    int i = this.decodeRowResult.length() - 1;
    byte b = 0;
    int j = paramInt;
    int k = 0;
    while (true) {
      int m = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(k)];
      int n;
      for (n = 6; n >= 0; n--) {
        int i1 = (n & 0x1) + ((m & 0x1) << 1);
        arrayOfInt1[i1] = arrayOfInt1[i1] + this.counters[j + n];
        arrayOfInt2[i1] = arrayOfInt2[i1] + 1;
        m >>= 1;
      } 
      if (k < i) {
        j += 8;
        k++;
        continue;
      } 
      float[] arrayOfFloat1 = new float[4];
      float[] arrayOfFloat2 = new float[4];
      m = 0;
      while (true) {
        k = b;
        j = paramInt;
        if (m < 2) {
          arrayOfFloat2[m] = 0.0F;
          k = m + 2;
          arrayOfFloat2[k] = (arrayOfInt1[m] / arrayOfInt2[m] + arrayOfInt1[k] / arrayOfInt2[k]) / 2.0F;
          arrayOfFloat1[m] = arrayOfFloat2[k];
          arrayOfFloat1[k] = (arrayOfInt1[k] * 2.0F + 1.5F) / arrayOfInt2[k];
          m++;
          continue;
        } 
        break;
      } 
      while (true) {
        m = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(k)];
        paramInt = 6;
        while (paramInt >= 0) {
          n = (paramInt & 0x1) + ((m & 0x1) << 1);
          float f = this.counters[j + paramInt];
          if (f >= arrayOfFloat2[n] && f <= arrayOfFloat1[n]) {
            m >>= 1;
            paramInt--;
            continue;
          } 
          throw NotFoundException.getNotFoundInstance();
        } 
        if (k < i) {
          j += 8;
          k++;
          continue;
        } 
        break;
      } 
      return;
    } 
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    Arrays.fill(this.counters, 0);
    setCounters(paramBitArray);
    int i = findStartPattern();
    this.decodeRowResult.setLength(0);
    int j = i;
    while (true) {
      int k = toNarrowWidePattern(j);
      if (k != -1) {
        this.decodeRowResult.append((char)k);
        int m = j + 8;
        if (this.decodeRowResult.length() <= 1 || !arrayContains(STARTEND_ENCODING, ALPHABET[k])) {
          j = m;
          if (m >= this.counterLength) {
            int[] arrayOfInt = this.counters;
            int n = m - 1;
            int i1 = arrayOfInt[n];
            j = -8;
            k = 0;
            while (j < -1) {
              k += this.counters[m + j];
              j++;
            } 
            if (m >= this.counterLength || i1 >= k / 2) {
              validatePattern(i);
              for (j = 0; j < this.decodeRowResult.length(); j++)
                this.decodeRowResult.setCharAt(j, ALPHABET[this.decodeRowResult.charAt(j)]); 
              char c = this.decodeRowResult.charAt(0);
              if (arrayContains(STARTEND_ENCODING, c)) {
                c = this.decodeRowResult.charAt(this.decodeRowResult.length() - 1);
                if (arrayContains(STARTEND_ENCODING, c)) {
                  if (this.decodeRowResult.length() > 3) {
                    if (paramMap == null || !paramMap.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                      this.decodeRowResult.deleteCharAt(this.decodeRowResult.length() - 1);
                      this.decodeRowResult.deleteCharAt(0);
                    } 
                    k = 0;
                    j = 0;
                    while (k < i) {
                      j += this.counters[k];
                      k++;
                    } 
                    float f1 = j;
                    while (i < n) {
                      j += this.counters[i];
                      i++;
                    } 
                    float f2 = j;
                    String str = this.decodeRowResult.toString();
                    float f3 = paramInt;
                    ResultPoint resultPoint2 = new ResultPoint(f1, f3);
                    ResultPoint resultPoint1 = new ResultPoint(f2, f3);
                    BarcodeFormat barcodeFormat = BarcodeFormat.CODABAR;
                    return new Result(str, null, new ResultPoint[] { resultPoint2, resultPoint1 }, barcodeFormat);
                  } 
                  throw NotFoundException.getNotFoundInstance();
                } 
                throw NotFoundException.getNotFoundInstance();
              } 
              throw NotFoundException.getNotFoundInstance();
            } 
            throw NotFoundException.getNotFoundInstance();
          } 
          continue;
        } 
        continue;
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\CodaBarReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */