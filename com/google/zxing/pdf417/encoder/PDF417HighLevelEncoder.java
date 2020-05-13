package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class PDF417HighLevelEncoder {
  private static final int BYTE_COMPACTION = 1;
  
  private static final Charset DEFAULT_ENCODING;
  
  private static final int ECI_CHARSET = 927;
  
  private static final int ECI_GENERAL_PURPOSE = 926;
  
  private static final int ECI_USER_DEFINED = 925;
  
  private static final int LATCH_TO_BYTE = 924;
  
  private static final int LATCH_TO_BYTE_PADDED = 901;
  
  private static final int LATCH_TO_NUMERIC = 902;
  
  private static final int LATCH_TO_TEXT = 900;
  
  private static final byte[] MIXED;
  
  private static final int NUMERIC_COMPACTION = 2;
  
  private static final byte[] PUNCTUATION;
  
  private static final int SHIFT_TO_BYTE = 913;
  
  private static final int SUBMODE_ALPHA = 0;
  
  private static final int SUBMODE_LOWER = 1;
  
  private static final int SUBMODE_MIXED = 2;
  
  private static final int SUBMODE_PUNCTUATION = 3;
  
  private static final int TEXT_COMPACTION = 0;
  
  private static final byte[] TEXT_MIXED_RAW = new byte[] { 
      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
      38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 
      43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
  
  private static final byte[] TEXT_PUNCTUATION_RAW = new byte[] { 
      59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 
      33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 
      34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
  
  static {
    MIXED = new byte[128];
    PUNCTUATION = new byte[128];
    DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
    Arrays.fill(MIXED, (byte)-1);
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b2 < TEXT_MIXED_RAW.length; b2++) {
      byte b = TEXT_MIXED_RAW[b2];
      if (b > 0)
        MIXED[b] = (byte)(byte)b2; 
    } 
    Arrays.fill(PUNCTUATION, (byte)-1);
    for (b2 = b1; b2 < TEXT_PUNCTUATION_RAW.length; b2++) {
      b1 = TEXT_PUNCTUATION_RAW[b2];
      if (b1 > 0)
        PUNCTUATION[b1] = (byte)(byte)b2; 
    } 
  }
  
  private static int determineConsecutiveBinaryCount(String paramString, int paramInt, Charset paramCharset) throws WriterException {
    CharsetEncoder charsetEncoder = paramCharset.newEncoder();
    int i = paramString.length();
    int j = paramInt;
    while (j < i) {
      char c = paramString.charAt(j);
      byte b = 0;
      char c1 = c;
      while (true) {
        c = b;
        if (b < 13) {
          c = b;
          if (isDigit(c1)) {
            int k = j + ++b;
            c = b;
            if (k < i) {
              c = paramString.charAt(k);
              c1 = c;
              continue;
            } 
          } 
        } 
        break;
      } 
      if (c >= '\r')
        return j - paramInt; 
      c1 = paramString.charAt(j);
      if (charsetEncoder.canEncode(c1)) {
        j++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder("Non-encodable character detected: ");
      stringBuilder.append(c1);
      stringBuilder.append(" (Unicode: ");
      stringBuilder.append(c1);
      stringBuilder.append(')');
      throw new WriterException(stringBuilder.toString());
    } 
    return j - paramInt;
  }
  
  private static int determineConsecutiveDigitCount(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    int j = 0;
    int k = 0;
    if (paramInt < i) {
      j = paramCharSequence.charAt(paramInt);
      int m = paramInt;
      int n = j;
      paramInt = k;
      while (true) {
        j = paramInt;
        if (isDigit(n)) {
          j = paramInt;
          if (m < i) {
            k = paramInt + 1;
            j = m + 1;
            paramInt = k;
            m = j;
            if (j < i) {
              m = paramCharSequence.charAt(j);
              paramInt = k;
              n = m;
              m = j;
            } 
            continue;
          } 
        } 
        break;
      } 
    } 
    return j;
  }
  
  private static int determineConsecutiveTextCount(CharSequence paramCharSequence, int paramInt) {
    int k;
    int i = paramCharSequence.length();
    int j = paramInt;
    while (true) {
      k = j;
      if (j < i) {
        char c = paramCharSequence.charAt(j);
        k = 0;
        int n = c;
        int m = j;
        while (k < 13 && isDigit(n) && m < i) {
          int i1 = k + 1;
          j = m + 1;
          m = j;
          k = i1;
          if (j < i) {
            k = paramCharSequence.charAt(j);
            m = j;
            n = k;
            k = i1;
          } 
        } 
        if (k >= 13)
          return m - paramInt - k; 
        j = m;
        if (k <= 0) {
          k = m;
          if (isText(paramCharSequence.charAt(m))) {
            j = m + 1;
            continue;
          } 
          break;
        } 
        continue;
      } 
      break;
    } 
    return k - paramInt;
  }
  
  private static void encodeBinary(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder) {
    int i;
    if (paramInt2 == 1 && paramInt3 == 0) {
      paramStringBuilder.append('Α');
    } else if (paramInt2 % 6 == 0) {
      paramStringBuilder.append('Μ');
    } else {
      paramStringBuilder.append('΅');
    } 
    if (paramInt2 >= 6) {
      char[] arrayOfChar = new char[5];
      paramInt3 = paramInt1;
      while (true) {
        i = paramInt3;
        if (paramInt1 + paramInt2 - paramInt3 >= 6) {
          long l2;
          boolean bool = false;
          long l1 = 0L;
          byte b = 0;
          while (true) {
            i = bool;
            l2 = l1;
            if (b < 6) {
              l1 = (l1 << 8L) + (paramArrayOfbyte[paramInt3 + b] & 0xFF);
              b++;
              continue;
            } 
            break;
          } 
          while (i < 5) {
            arrayOfChar[i] = (char)(char)(int)(l2 % 900L);
            l2 /= 900L;
            i++;
          } 
          for (i = 4; i >= 0; i--)
            paramStringBuilder.append(arrayOfChar[i]); 
          paramInt3 += 6;
          continue;
        } 
        break;
      } 
    } else {
      i = paramInt1;
    } 
    while (i < paramInt1 + paramInt2) {
      paramStringBuilder.append((char)(paramArrayOfbyte[i] & 0xFF));
      i++;
    } 
  }
  
  static String encodeHighLevel(String paramString, Compaction paramCompaction, Charset paramCharset) throws WriterException {
    byte[] arrayOfByte;
    Charset charset;
    int j;
    int k;
    StringBuilder stringBuilder = new StringBuilder(paramString.length());
    if (paramCharset == null) {
      charset = DEFAULT_ENCODING;
    } else {
      charset = paramCharset;
      if (!DEFAULT_ENCODING.equals(paramCharset)) {
        CharacterSetECI characterSetECI = CharacterSetECI.getCharacterSetECIByName(paramCharset.name());
        charset = paramCharset;
        if (characterSetECI != null) {
          encodingECI(characterSetECI.getValue(), stringBuilder);
          charset = paramCharset;
        } 
      } 
    } 
    int i = paramString.length();
    switch (paramCompaction) {
      default:
        j = 0;
        k = 0;
        label48: while (true) {
          int m = 0;
          while (j < i) {
            int n = determineConsecutiveDigitCount(paramString, j);
            if (n >= 13) {
              stringBuilder.append('Ά');
              k = 2;
              encodeNumeric(paramString, j, n, stringBuilder);
              j += n;
              continue label48;
            } 
            int i1 = determineConsecutiveTextCount(paramString, j);
            if (i1 >= 5 || n == i) {
              n = k;
              if (k != 0) {
                stringBuilder.append('΄');
                n = 0;
                m = 0;
              } 
              m = encodeText(paramString, j, i1, stringBuilder, m);
              j += i1;
              k = n;
              continue;
            } 
            i1 = determineConsecutiveBinaryCount(paramString, j, charset);
            n = i1;
            if (i1 == 0)
              n = 1; 
            n += j;
            byte[] arrayOfByte1 = paramString.substring(j, n).getBytes(charset);
            if (arrayOfByte1.length == 1 && k == 0) {
              encodeBinary(arrayOfByte1, 0, 1, 0, stringBuilder);
            } else {
              encodeBinary(arrayOfByte1, 0, arrayOfByte1.length, k, stringBuilder);
              k = 1;
              m = 0;
            } 
            j = n;
          } 
          break;
        } 
        return stringBuilder.toString();
      case NUMERIC:
        stringBuilder.append('Ά');
        encodeNumeric(paramString, 0, i, stringBuilder);
        return stringBuilder.toString();
      case BYTE:
        arrayOfByte = paramString.getBytes(charset);
        encodeBinary(arrayOfByte, 0, arrayOfByte.length, 1, stringBuilder);
        return stringBuilder.toString();
      case TEXT:
        break;
    } 
    encodeText((CharSequence)arrayOfByte, 0, i, stringBuilder, 0);
    return stringBuilder.toString();
  }
  
  private static void encodeNumeric(String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder) {
    StringBuilder stringBuilder = new StringBuilder(paramInt2 / 3 + 1);
    BigInteger bigInteger1 = BigInteger.valueOf(900L);
    BigInteger bigInteger2 = BigInteger.valueOf(0L);
    int i;
    for (i = 0; i < paramInt2; i += j) {
      stringBuilder.setLength(0);
      int j = Math.min(44, paramInt2 - i);
      StringBuilder stringBuilder1 = new StringBuilder("1");
      int k = paramInt1 + i;
      stringBuilder1.append(paramString.substring(k, k + j));
      BigInteger bigInteger = new BigInteger(stringBuilder1.toString());
      while (true) {
        stringBuilder.append((char)bigInteger.mod(bigInteger1).intValue());
        BigInteger bigInteger3 = bigInteger.divide(bigInteger1);
        bigInteger = bigInteger3;
        if (bigInteger3.equals(bigInteger2)) {
          for (k = stringBuilder.length() - 1; k >= 0; k--)
            paramStringBuilder.append(stringBuilder.charAt(k)); 
          break;
        } 
      } 
    } 
  }
  
  private static int encodeText(CharSequence paramCharSequence, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder(paramInt2);
    int i = 0;
    while (true) {
      int j = paramInt1 + i;
      char c = paramCharSequence.charAt(j);
      switch (paramInt3) {
        default:
          if (isPunctuation(c)) {
            stringBuilder.append((char)PUNCTUATION[c]);
          } else {
            stringBuilder.append('\035');
            paramInt3 = 0;
            continue;
          } 
          j = i + 1;
          i = j;
        case 2:
          if (isMixed(c)) {
            stringBuilder.append((char)MIXED[c]);
          } else {
            if (isAlphaUpper(c)) {
              stringBuilder.append('\034');
              break;
            } 
            if (isAlphaLower(c)) {
              stringBuilder.append('\033');
            } else {
              if (++j < paramInt2 && isPunctuation(paramCharSequence.charAt(j))) {
                paramInt3 = 3;
                stringBuilder.append('\031');
                continue;
              } 
              stringBuilder.append('\035');
              stringBuilder.append((char)PUNCTUATION[c]);
              j = i + 1;
              i = j;
            } 
            paramInt3 = 1;
          } 
          j = i + 1;
          i = j;
        case 1:
          if (isAlphaLower(c)) {
            if (c == ' ') {
              stringBuilder.append('\032');
            } else {
              stringBuilder.append((char)(c - 97));
            } 
          } else if (isAlphaUpper(c)) {
            stringBuilder.append('\033');
            stringBuilder.append((char)(c - 65));
          } else {
            if (isMixed(c)) {
              stringBuilder.append('\034');
            } else {
              stringBuilder.append('\035');
              stringBuilder.append((char)PUNCTUATION[c]);
              j = i + 1;
              i = j;
            } 
            paramInt3 = 2;
          } 
          j = i + 1;
          i = j;
        case 0:
          if (isAlphaUpper(c)) {
            if (c == ' ') {
              stringBuilder.append('\032');
            } else {
              stringBuilder.append((char)(c - 65));
            } 
          } else {
            if (isAlphaLower(c)) {
              stringBuilder.append('\033');
            } else {
              if (isMixed(c)) {
                stringBuilder.append('\034');
              } else {
                stringBuilder.append('\035');
                stringBuilder.append((char)PUNCTUATION[c]);
                j = i + 1;
                i = j;
              } 
              paramInt3 = 2;
            } 
            paramInt3 = 1;
          } 
          j = i + 1;
          i = j;
      } 
      paramInt3 = 0;
    } 
  }
  
  private static void encodingECI(int paramInt, StringBuilder paramStringBuilder) throws WriterException {
    if (paramInt >= 0 && paramInt < 900) {
      paramStringBuilder.append('Ο');
      paramStringBuilder.append((char)paramInt);
      return;
    } 
    if (paramInt < 810900) {
      paramStringBuilder.append('Ξ');
      paramStringBuilder.append((char)(paramInt / 900 - 1));
      paramStringBuilder.append((char)(paramInt % 900));
      return;
    } 
    if (paramInt < 811800) {
      paramStringBuilder.append('Ν');
      paramStringBuilder.append((char)(810900 - paramInt));
      return;
    } 
    throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(paramInt)));
  }
  
  private static boolean isAlphaLower(char paramChar) {
    return (paramChar == ' ' || (paramChar >= 'a' && paramChar <= 'z'));
  }
  
  private static boolean isAlphaUpper(char paramChar) {
    return (paramChar == ' ' || (paramChar >= 'A' && paramChar <= 'Z'));
  }
  
  private static boolean isDigit(char paramChar) {
    return (paramChar >= '0' && paramChar <= '9');
  }
  
  private static boolean isMixed(char paramChar) {
    return (MIXED[paramChar] != -1);
  }
  
  private static boolean isPunctuation(char paramChar) {
    return (PUNCTUATION[paramChar] != -1);
  }
  
  private static boolean isText(char paramChar) {
    return (paramChar == '\t' || paramChar == '\n' || paramChar == '\r' || (paramChar >= ' ' && paramChar <= '~'));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\encoder\PDF417HighLevelEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */