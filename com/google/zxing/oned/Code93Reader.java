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

public final class Code93Reader extends OneDReader {
  private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
  
  static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
  
  private static final int ASTERISK_ENCODING;
  
  static final int[] CHARACTER_ENCODINGS;
  
  private final int[] counters = new int[6];
  
  private final StringBuilder decodeRowResult = new StringBuilder(20);
  
  static {
    int[] arrayOfInt = new int[48];
    arrayOfInt[0] = 276;
    arrayOfInt[1] = 328;
    arrayOfInt[2] = 324;
    arrayOfInt[3] = 322;
    arrayOfInt[4] = 296;
    arrayOfInt[5] = 292;
    arrayOfInt[6] = 290;
    arrayOfInt[7] = 336;
    arrayOfInt[8] = 274;
    arrayOfInt[9] = 266;
    arrayOfInt[10] = 424;
    arrayOfInt[11] = 420;
    arrayOfInt[12] = 418;
    arrayOfInt[13] = 404;
    arrayOfInt[14] = 402;
    arrayOfInt[15] = 394;
    arrayOfInt[16] = 360;
    arrayOfInt[17] = 356;
    arrayOfInt[18] = 354;
    arrayOfInt[19] = 308;
    arrayOfInt[20] = 282;
    arrayOfInt[21] = 344;
    arrayOfInt[22] = 332;
    arrayOfInt[23] = 326;
    arrayOfInt[24] = 300;
    arrayOfInt[25] = 278;
    arrayOfInt[26] = 436;
    arrayOfInt[27] = 434;
    arrayOfInt[28] = 428;
    arrayOfInt[29] = 422;
    arrayOfInt[30] = 406;
    arrayOfInt[31] = 410;
    arrayOfInt[32] = 364;
    arrayOfInt[33] = 358;
    arrayOfInt[34] = 310;
    arrayOfInt[35] = 314;
    arrayOfInt[36] = 302;
    arrayOfInt[37] = 468;
    arrayOfInt[38] = 466;
    arrayOfInt[39] = 458;
    arrayOfInt[40] = 366;
    arrayOfInt[41] = 374;
    arrayOfInt[42] = 430;
    arrayOfInt[43] = 294;
    arrayOfInt[44] = 474;
    arrayOfInt[45] = 470;
    arrayOfInt[46] = 306;
    arrayOfInt[47] = 350;
    CHARACTER_ENCODINGS = arrayOfInt;
    ASTERISK_ENCODING = arrayOfInt[47];
  }
  
  private static void checkChecksums(CharSequence paramCharSequence) throws ChecksumException {
    int i = paramCharSequence.length();
    checkOneChecksum(paramCharSequence, i - 2, 20);
    checkOneChecksum(paramCharSequence, i - 1, 15);
  }
  
  private static void checkOneChecksum(CharSequence paramCharSequence, int paramInt1, int paramInt2) throws ChecksumException {
    int i = paramInt1 - 1;
    int j = 0;
    int k = 1;
    while (i >= 0) {
      j += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(i)) * k;
      int m = k + 1;
      k = m;
      if (m > paramInt2)
        k = 1; 
      i--;
    } 
    if (paramCharSequence.charAt(paramInt1) == ALPHABET[j % 47])
      return; 
    throw ChecksumException.getChecksumInstance();
  }
  
  private static String decodeExtended(CharSequence paramCharSequence) throws FormatException {
    int i = paramCharSequence.length();
    StringBuilder stringBuilder = new StringBuilder(i);
    for (byte b = 0; b < i; b++) {
      char c = paramCharSequence.charAt(b);
      if (c >= 'a' && c <= 'd') {
        if (b < i - 1) {
          char c1 = paramCharSequence.charAt(++b);
          switch (c) {
            default:
              c1 = Character.MIN_VALUE;
              c = c1;
              break;
            case 'd':
              if (c1 >= 'A' && c1 <= 'Z') {
                c1 = (char)(c1 + 32);
                c = c1;
                break;
              } 
              throw FormatException.getFormatInstance();
            case 'c':
              if (c1 >= 'A' && c1 <= 'O') {
                c1 = (char)(c1 - 32);
                c = c1;
                break;
              } 
              if (c1 == 'Z') {
                c1 = ':';
                c = c1;
                break;
              } 
              throw FormatException.getFormatInstance();
            case 'b':
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
              if (c1 >= 'P' && c1 <= 'S') {
                c1 = (char)(c1 + 43);
                c = c1;
                break;
              } 
              if (c1 >= 'T' && c1 <= 'Z') {
                c1 = '';
                c = c1;
                break;
              } 
              throw FormatException.getFormatInstance();
            case 'a':
              if (c1 >= 'A' && c1 <= 'Z') {
                c1 = (char)(c1 - 64);
                c = c1;
                break;
              } 
              throw FormatException.getFormatInstance();
          } 
          stringBuilder.append(c);
        } else {
          throw FormatException.getFormatInstance();
        } 
      } else {
        stringBuilder.append(c);
      } 
    } 
    return stringBuilder.toString();
  }
  
  private int[] findAsteriskPattern(BitArray paramBitArray) throws NotFoundException {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    Arrays.fill(this.counters, 0);
    int[] arrayOfInt = this.counters;
    int k = arrayOfInt.length;
    int m = j;
    boolean bool = false;
    int n = 0;
    while (j < i) {
      int i1;
      if (paramBitArray.get(j) != bool) {
        arrayOfInt[n] = arrayOfInt[n] + 1;
        i1 = m;
      } else {
        if (n == k - 1) {
          if (toPattern(arrayOfInt) == ASTERISK_ENCODING)
            return new int[] { m, j }; 
          int i3 = m + arrayOfInt[0] + arrayOfInt[1];
          m = n - 1;
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, m);
          arrayOfInt[m] = 0;
          arrayOfInt[n] = 0;
          m = n - 1;
          n = i3;
        } else {
          int i3 = n + 1;
          n = m;
          m = i3;
        } 
        arrayOfInt[m] = 1;
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
        return ALPHABET[b]; 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static int toPattern(int[] paramArrayOfint) {
    int i = paramArrayOfint.length;
    int j = 0;
    int k = 0;
    while (j < i) {
      k += paramArrayOfint[j];
      j++;
    } 
    int m = paramArrayOfint.length;
    i = 0;
    j = 0;
    while (i < m) {
      int n = Math.round(paramArrayOfint[i] * 9.0F / k);
      if (n <= 0 || n > 4)
        return -1; 
      if ((i & 0x1) == 0) {
        for (byte b = 0; b < n; b++)
          j = j << 1 | 0x1; 
      } else {
        j <<= n;
      } 
      i++;
    } 
    return j;
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    int[] arrayOfInt1 = findAsteriskPattern(paramBitArray);
    int i = paramBitArray.getNextSet(arrayOfInt1[1]);
    int j = paramBitArray.getSize();
    int[] arrayOfInt2 = this.counters;
    Arrays.fill(arrayOfInt2, 0);
    StringBuilder stringBuilder = this.decodeRowResult;
    stringBuilder.setLength(0);
    while (true) {
      recordPattern(paramBitArray, i, arrayOfInt2);
      int k = toPattern(arrayOfInt2);
      if (k >= 0) {
        char c = patternToChar(k);
        stringBuilder.append(c);
        int m = arrayOfInt2.length;
        k = i;
        byte b;
        for (b = 0; b < m; b++)
          k += arrayOfInt2[b]; 
        m = paramBitArray.getNextSet(k);
        if (c == '*') {
          stringBuilder.deleteCharAt(stringBuilder.length() - 1);
          int n = arrayOfInt2.length;
          b = 0;
          k = 0;
          while (b < n) {
            k += arrayOfInt2[b];
            b++;
          } 
          if (m != j && paramBitArray.get(m)) {
            if (stringBuilder.length() >= 2) {
              checkChecksums(stringBuilder);
              stringBuilder.setLength(stringBuilder.length() - 2);
              String str = decodeExtended(stringBuilder);
              float f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
              float f2 = i;
              float f3 = k / 2.0F;
              float f4 = paramInt;
              ResultPoint resultPoint1 = new ResultPoint(f1, f4);
              ResultPoint resultPoint2 = new ResultPoint(f2 + f3, f4);
              BarcodeFormat barcodeFormat = BarcodeFormat.CODE_93;
              return new Result(str, null, new ResultPoint[] { resultPoint1, resultPoint2 }, barcodeFormat);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\Code93Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */