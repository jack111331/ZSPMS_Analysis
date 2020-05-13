package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code39Reader extends OneDReader {
  static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
  
  static final int ASTERISK_ENCODING = 148;
  
  static final int[] CHARACTER_ENCODINGS = new int[] { 
      52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 
      265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 
      259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 
      385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 
      162, 138, 42 };
  
  private final int[] counters;
  
  private final StringBuilder decodeRowResult;
  
  private final boolean extendedMode;
  
  private final boolean usingCheckDigit;
  
  public Code39Reader() {
    this(false);
  }
  
  public Code39Reader(boolean paramBoolean) {
    this(paramBoolean, false);
  }
  
  public Code39Reader(boolean paramBoolean1, boolean paramBoolean2) {
    this.usingCheckDigit = paramBoolean1;
    this.extendedMode = paramBoolean2;
    this.decodeRowResult = new StringBuilder(20);
    this.counters = new int[9];
  }
  
  private static String decodeExtended(CharSequence paramCharSequence) throws FormatException {
    int i = paramCharSequence.length();
    StringBuilder stringBuilder = new StringBuilder(i);
    for (byte b = 0; b < i; b++) {
      char c = paramCharSequence.charAt(b);
      if (c == '+' || c == '$' || c == '%' || c == '/') {
        char c1 = paramCharSequence.charAt(++b);
        if (c != '+') {
          if (c != '/') {
            switch (c) {
              default:
                c1 = Character.MIN_VALUE;
                c = c1;
                break;
              case '%':
                if (c1 >= 'A' && c1 <= 'E') {
                  c1 = (char)(c1 - 38);
                  c = c1;
                  break;
                } 
                if (c1 >= 'F' && c1 <= 'J') {
                  c1 = (char)(c1 - 11);
                  c = c1;
                  break;
                } 
                if (c1 >= 'K' && c1 <= 'O') {
                  c1 = (char)(c1 + 16);
                  c = c1;
                  break;
                } 
                if (c1 >= 'P' && c1 <= 'T') {
                  c1 = (char)(c1 + 43);
                  c = c1;
                  break;
                } 
                if (c1 != 'U') {
                  if (c1 == 'V') {
                    c1 = '@';
                    c = c1;
                    break;
                  } 
                  if (c1 == 'W') {
                    c1 = '`';
                    c = c1;
                    break;
                  } 
                  if (c1 == 'X' || c1 == 'Y' || c1 == 'Z') {
                    c1 = '';
                    c = c1;
                    break;
                  } 
                  throw FormatException.getFormatInstance();
                } 
              case '$':
                if (c1 >= 'A' && c1 <= 'Z') {
                  c1 = (char)(c1 - 64);
                  c = c1;
                  break;
                } 
                throw FormatException.getFormatInstance();
            } 
          } else if (c1 >= 'A' && c1 <= 'O') {
            c1 = (char)(c1 - 32);
            c = c1;
          } else if (c1 == 'Z') {
            c1 = ':';
            c = c1;
          } else {
            throw FormatException.getFormatInstance();
          } 
        } else if (c1 >= 'A' && c1 <= 'Z') {
          c1 = (char)(c1 + 32);
          c = c1;
        } else {
          throw FormatException.getFormatInstance();
        } 
        stringBuilder.append(c);
      } else {
        stringBuilder.append(c);
      } 
    } 
    return stringBuilder.toString();
  }
  
  private static int[] findAsteriskPattern(BitArray paramBitArray, int[] paramArrayOfint) throws NotFoundException {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int k = paramArrayOfint.length;
    int m = j;
    boolean bool = false;
    int n = 0;
    while (j < i) {
      int i1;
      if (paramBitArray.get(j) != bool) {
        paramArrayOfint[n] = paramArrayOfint[n] + 1;
        i1 = m;
      } else {
        if (n == k - 1) {
          if (toNarrowWidePattern(paramArrayOfint) == 148 && paramBitArray.isRange(Math.max(0, m - (j - m) / 2), m, false))
            return new int[] { m, j }; 
          int i3 = m + paramArrayOfint[0] + paramArrayOfint[1];
          m = n - 1;
          System.arraycopy(paramArrayOfint, 2, paramArrayOfint, 0, m);
          paramArrayOfint[m] = 0;
          paramArrayOfint[n] = 0;
          m = n - 1;
          n = i3;
        } else {
          int i3 = n + 1;
          n = m;
          m = i3;
        } 
        paramArrayOfint[m] = 1;
        int i2 = bool ^ true;
        i1 = n;
        n = m;
      } 
      j++;
      m = i1;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static char patternToChar(int paramInt) throws NotFoundException {
    for (byte b = 0; b < CHARACTER_ENCODINGS.length; b++) {
      if (CHARACTER_ENCODINGS[b] == paramInt)
        return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(b); 
    } 
    if (paramInt == 148)
      return '*'; 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int toNarrowWidePattern(int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    boolean bool = false;
    for (int j = 0;; j = n) {
      int k = paramArrayOfint.length;
      int m = 0;
      int n;
      for (n = Integer.MAX_VALUE; m < k; n = i4) {
        int i3 = paramArrayOfint[m];
        int i4 = n;
        if (i3 < n) {
          i4 = n;
          if (i3 > j)
            i4 = i3; 
        } 
        m++;
      } 
      int i1 = 0;
      j = 0;
      int i2 = 0;
      for (m = 0; i1 < i; m = k) {
        int i3 = paramArrayOfint[i1];
        int i4 = j;
        int i5 = i2;
        k = m;
        if (i3 > n) {
          i5 = i2 | 1 << i - 1 - i1;
          i4 = j + 1;
          k = m + i3;
        } 
        i1++;
        j = i4;
        i2 = i5;
      } 
      if (j == 3) {
        i1 = j;
        j = bool;
        while (j < i && i1 > 0) {
          int i3 = paramArrayOfint[j];
          k = i1;
          if (i3 > n) {
            k = i1 - 1;
            if (i3 << 1 >= m)
              return -1; 
          } 
          j++;
          i1 = k;
        } 
        return i2;
      } 
      if (j <= 3)
        return -1; 
    } 
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    int[] arrayOfInt2 = this.counters;
    Arrays.fill(arrayOfInt2, 0);
    StringBuilder stringBuilder = this.decodeRowResult;
    stringBuilder.setLength(0);
    int[] arrayOfInt1 = findAsteriskPattern(paramBitArray, arrayOfInt2);
    int i = paramBitArray.getNextSet(arrayOfInt1[1]);
    int j = paramBitArray.getSize();
    while (true) {
      recordPattern(paramBitArray, i, arrayOfInt2);
      int k = toNarrowWidePattern(arrayOfInt2);
      if (k >= 0) {
        char c = patternToChar(k);
        stringBuilder.append(c);
        int m = arrayOfInt2.length;
        int n = i;
        for (k = 0; k < m; k++)
          n += arrayOfInt2[k]; 
        m = paramBitArray.getNextSet(n);
        if (c == '*') {
          stringBuilder.setLength(stringBuilder.length() - 1);
          int i1 = arrayOfInt2.length;
          n = 0;
          k = 0;
          while (n < i1) {
            k += arrayOfInt2[n];
            n++;
          } 
          if (m == j || m - i - k << 1 >= k) {
            if (this.usingCheckDigit) {
              j = stringBuilder.length() - 1;
              n = 0;
              m = 0;
              while (n < j) {
                m += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.decodeRowResult.charAt(n));
                n++;
              } 
              if (stringBuilder.charAt(j) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(m % 43)) {
                stringBuilder.setLength(j);
              } else {
                throw ChecksumException.getChecksumInstance();
              } 
            } 
            if (stringBuilder.length() != 0) {
              String str;
              if (this.extendedMode) {
                str = decodeExtended(stringBuilder);
              } else {
                str = stringBuilder.toString();
              } 
              float f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
              float f2 = i;
              float f3 = k / 2.0F;
              float f4 = paramInt;
              ResultPoint resultPoint2 = new ResultPoint(f1, f4);
              ResultPoint resultPoint1 = new ResultPoint(f2 + f3, f4);
              BarcodeFormat barcodeFormat = BarcodeFormat.CODE_39;
              return new Result(str, null, new ResultPoint[] { resultPoint2, resultPoint1 }, barcodeFormat);
            } 
            throw NotFoundException.getNotFoundInstance();
          } 
          throw NotFoundException.getNotFoundInstance();
        } 
        i = m;
        continue;
      } 
      throw NotFoundException.getNotFoundInstance();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\Code39Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */