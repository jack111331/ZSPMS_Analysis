package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class DecodedBitStreamParser {
  private static final int AL = 28;
  
  private static final int AS = 27;
  
  private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
  
  private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
  
  private static final int BYTE_COMPACTION_MODE_LATCH = 901;
  
  private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
  
  private static final int ECI_CHARSET = 927;
  
  private static final int ECI_GENERAL_PURPOSE = 926;
  
  private static final int ECI_USER_DEFINED = 925;
  
  private static final BigInteger[] EXP900;
  
  private static final int LL = 27;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
  
  private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
  
  private static final int MACRO_PDF417_TERMINATOR = 922;
  
  private static final int MAX_NUMERIC_CODEWORDS = 15;
  
  private static final char[] MIXED_CHARS;
  
  private static final int ML = 28;
  
  private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
  
  private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
  
  private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
  
  private static final int PAL = 29;
  
  private static final int PL = 25;
  
  private static final int PS = 29;
  
  private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
  
  private static final int TEXT_COMPACTION_MODE_LATCH = 900;
  
  static {
    MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    BigInteger[] arrayOfBigInteger = new BigInteger[16];
    EXP900 = arrayOfBigInteger;
    arrayOfBigInteger[0] = BigInteger.ONE;
    BigInteger bigInteger = BigInteger.valueOf(900L);
    EXP900[1] = bigInteger;
    for (byte b = 2; b < EXP900.length; b++) {
      arrayOfBigInteger = EXP900;
      arrayOfBigInteger[b] = arrayOfBigInteger[b - 1].multiply(bigInteger);
    } 
  }
  
  private static int byteCompaction(int paramInt1, int[] paramArrayOfint, Charset paramCharset, int paramInt2, StringBuilder paramStringBuilder) {
    int i;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = false;
    if (paramInt1 != 901) {
      if (paramInt1 != 924) {
        i = paramInt2;
      } else {
        boolean bool1 = false;
        paramInt1 = 0;
        long l = 0L;
        while (true) {
          i = paramInt2;
          if (paramInt2 < paramArrayOfint[0]) {
            i = paramInt2;
            if (!bool1) {
              i = paramInt2 + 1;
              int j = paramArrayOfint[paramInt2];
              if (j < 900) {
                paramInt2 = paramInt1 + 1;
                l = l * 900L + j;
              } else if (j != 928) {
                long l2;
                switch (j) {
                  default:
                    switch (j) {
                      default:
                        paramInt2 = paramInt1;
                        paramInt1 = i;
                        l2 = l;
                        break;
                      case 922:
                      case 923:
                      case 924:
                        break;
                    } 
                  case 900:
                  case 901:
                  case 902:
                    i--;
                    bool1 = true;
                    l2 = l;
                    paramInt2 = paramInt1;
                    paramInt1 = i;
                    break;
                } 
                i = paramInt2;
                l = l2;
                if (paramInt2 % 5 == 0) {
                  i = paramInt2;
                  l = l2;
                  if (paramInt2 > 0) {
                    for (paramInt2 = 0; paramInt2 < 6; paramInt2++)
                      byteArrayOutputStream.write((byte)(int)(l2 >> (5 - paramInt2) * 8)); 
                    i = 0;
                    l = 0L;
                  } 
                } 
                paramInt2 = paramInt1;
                paramInt1 = i;
                continue;
              } 
            } else {
              break;
            } 
          } else {
            break;
          } 
          paramInt1 = i;
          long l1 = l;
          break;
        } 
      } 
    } else {
      int[] arrayOfInt = new int[6];
      paramInt1 = paramInt2 + 1;
      paramInt2 = paramArrayOfint[paramInt2];
      int j = 0;
      while (true) {
        int k = 0;
        long l = 0L;
        i = paramInt2;
        paramInt2 = k;
        while (paramInt1 < paramArrayOfint[0] && !j) {
          k = paramInt2 + 1;
          arrayOfInt[paramInt2] = i;
          l = l * 900L + i;
          paramInt2 = paramInt1 + 1;
          i = paramArrayOfint[paramInt1];
          if (i != 928)
            switch (i) {
              default:
                switch (i) {
                  case 922:
                  case 923:
                  case 924:
                    break;
                } 
                continue;
              case 900:
              case 901:
              case 902:
                break;
            }  
          paramInt1 = paramInt2 - 1;
          paramInt2 = k;
          j = 1;
        } 
        break;
      } 
      if (paramInt1 == paramArrayOfint[0] && i < 900) {
        j = paramInt2 + 1;
        arrayOfInt[paramInt2] = i;
        paramInt2 = j;
        i = bool;
      } else {
        i = bool;
      } 
      while (i < paramInt2) {
        byteArrayOutputStream.write((byte)arrayOfInt[i]);
        i++;
      } 
      i = paramInt1;
    } 
    paramStringBuilder.append(new String(byteArrayOutputStream.toByteArray(), paramCharset));
    return i;
  }
  
  static DecoderResult decode(int[] paramArrayOfint, String paramString) throws FormatException {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfint.length << 1);
    Charset charset = StandardCharsets.ISO_8859_1;
    int i = paramArrayOfint[1];
    PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
    int j = 2;
    while (j < paramArrayOfint[0]) {
      if (i != 913) {
        switch (i) {
          default:
            switch (i) {
              default:
                j = textCompaction(paramArrayOfint, j - 1, stringBuilder);
                break;
              case 928:
                j = decodeMacroBlock(paramArrayOfint, j, pDF417ResultMetadata);
                break;
              case 927:
                i = j + 1;
                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(paramArrayOfint[j]).name());
                j = i;
                break;
              case 926:
                j += 2;
                break;
              case 925:
                j++;
                break;
              case 922:
              case 923:
                throw FormatException.getFormatInstance();
              case 924:
                break;
            } 
          case 902:
            j = numericCompaction(paramArrayOfint, j, stringBuilder);
            break;
          case 901:
            j = byteCompaction(i, paramArrayOfint, charset, j, stringBuilder);
            break;
          case 900:
            j = textCompaction(paramArrayOfint, j, stringBuilder);
            break;
        } 
      } else {
        i = j + 1;
        stringBuilder.append((char)paramArrayOfint[j]);
        j = i;
      } 
      if (j < paramArrayOfint.length) {
        int k = j + 1;
        i = paramArrayOfint[j];
        j = k;
        continue;
      } 
      throw FormatException.getFormatInstance();
    } 
    if (stringBuilder.length() != 0) {
      DecoderResult decoderResult = new DecoderResult(null, stringBuilder.toString(), null, paramString);
      decoderResult.setOther(pDF417ResultMetadata);
      return decoderResult;
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static String decodeBase900toBase10(int[] paramArrayOfint, int paramInt) throws FormatException {
    BigInteger bigInteger = BigInteger.ZERO;
    for (byte b = 0; b < paramInt; b++)
      bigInteger = bigInteger.add(EXP900[paramInt - b - 1].multiply(BigInteger.valueOf(paramArrayOfint[b]))); 
    String str = bigInteger.toString();
    if (str.charAt(0) == '1')
      return str.substring(1); 
    throw FormatException.getFormatInstance();
  }
  
  static int decodeMacroBlock(int[] paramArrayOfint, int paramInt, PDF417ResultMetadata paramPDF417ResultMetadata) throws FormatException {
    if (paramInt + 2 <= paramArrayOfint[0]) {
      int[] arrayOfInt = new int[2];
      int i = 0;
      while (i < 2) {
        arrayOfInt[i] = paramArrayOfint[paramInt];
        i++;
        paramInt++;
      } 
      paramPDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(arrayOfInt, 2)));
      StringBuilder stringBuilder = new StringBuilder();
      paramInt = textCompaction(paramArrayOfint, paramInt, stringBuilder);
      paramPDF417ResultMetadata.setFileId(stringBuilder.toString());
      if (paramArrayOfint[paramInt] == 923) {
        i = paramInt + 1;
      } else {
        i = -1;
      } 
      while (paramInt < paramArrayOfint[0]) {
        switch (paramArrayOfint[paramInt]) {
          default:
            throw FormatException.getFormatInstance();
          case 923:
            switch (paramArrayOfint[++paramInt]) {
              default:
                throw FormatException.getFormatInstance();
              case 6:
                stringBuilder = new StringBuilder();
                paramInt = numericCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.setChecksum(Integer.parseInt(stringBuilder.toString()));
                continue;
              case 5:
                stringBuilder = new StringBuilder();
                paramInt = numericCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.setFileSize(Long.parseLong(stringBuilder.toString()));
                continue;
              case 4:
                stringBuilder = new StringBuilder();
                paramInt = textCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.setAddressee(stringBuilder.toString());
                continue;
              case 3:
                stringBuilder = new StringBuilder();
                paramInt = textCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.setSender(stringBuilder.toString());
                continue;
              case 2:
                stringBuilder = new StringBuilder();
                paramInt = numericCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.setTimestamp(Long.parseLong(stringBuilder.toString()));
                continue;
              case 1:
                stringBuilder = new StringBuilder();
                paramInt = numericCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.setSegmentCount(Integer.parseInt(stringBuilder.toString()));
                continue;
              case 0:
                break;
            } 
            stringBuilder = new StringBuilder();
            paramInt = textCompaction(paramArrayOfint, paramInt + 1, stringBuilder);
            paramPDF417ResultMetadata.setFileName(stringBuilder.toString());
            continue;
          case 922:
            break;
        } 
        paramInt++;
        paramPDF417ResultMetadata.setLastSegment(true);
      } 
      if (i != -1) {
        int j = paramInt - i;
        int k = j;
        if (paramPDF417ResultMetadata.isLastSegment())
          k = j - 1; 
        paramPDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(paramArrayOfint, i, k + i));
      } 
      return paramInt;
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeTextCompaction(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt, StringBuilder paramStringBuilder) {
    Mode mode1 = Mode.ALPHA;
    Mode mode2 = Mode.ALPHA;
    for (byte b = 0; b < paramInt; b++) {
      int j;
      int i = paramArrayOfint1[b];
      switch (mode1) {
        default:
          i = 0;
          j = i;
        case PUNCT_SHIFT:
          if (i < 29) {
            i = PUNCT_CHARS[i];
          } else {
            if (i != 29) {
              if (i != 900) {
                if (i == 913)
                  paramStringBuilder.append((char)paramArrayOfint2[b]); 
              } else {
                mode1 = Mode.ALPHA;
              } 
            } else {
              mode1 = Mode.ALPHA;
            } 
            mode1 = mode2;
          } 
          mode1 = mode2;
          j = i;
          break;
        case ALPHA_SHIFT:
        
        case PUNCT:
          if (i < 29) {
            i = PUNCT_CHARS[i];
            j = i;
            break;
          } 
          if (i != 29) {
            if (i != 900) {
              if (i == 913)
                paramStringBuilder.append((char)paramArrayOfint2[b]); 
            } else {
              mode1 = Mode.ALPHA;
            } 
          } else {
            mode1 = Mode.ALPHA;
          } 
        case MIXED:
          if (i < 25) {
            i = MIXED_CHARS[i];
            j = i;
            break;
          } 
          if (i != 900) {
            if (i != 913) {
              Mode mode = mode1;
              switch (i) {
                case 29:
                  mode2 = Mode.PUNCT_SHIFT;
                  i = 0;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  j = i;
                  break;
                case 28:
                  mode1 = Mode.ALPHA;
                  break;
                case 27:
                  mode1 = Mode.LOWER;
                  break;
                case 25:
                  mode1 = Mode.PUNCT;
                  break;
                case 26:
                
              } 
            } else {
              paramStringBuilder.append((char)paramArrayOfint2[b]);
            } 
          } else {
            mode1 = Mode.ALPHA;
          } 
        case LOWER:
          if (i < 26) {
            i = (char)(i + 97);
            j = i;
            break;
          } 
          if (i != 900) {
            if (i != 913) {
              Mode mode = mode1;
              switch (i) {
                case 29:
                  mode2 = Mode.PUNCT_SHIFT;
                  i = 0;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  j = i;
                  break;
                case 28:
                  mode1 = Mode.MIXED;
                  break;
                case 27:
                  mode2 = Mode.ALPHA_SHIFT;
                  i = 0;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  j = i;
                  break;
                case 26:
                
              } 
            } else {
              paramStringBuilder.append((char)paramArrayOfint2[b]);
            } 
          } else {
            mode1 = Mode.ALPHA;
          } 
        case ALPHA:
          if (i < 26) {
            i = (char)(i + 65);
            j = i;
            break;
          } 
          if (i != 900) {
            if (i != 913) {
              Mode mode = mode1;
              switch (i) {
                case 29:
                  mode2 = Mode.PUNCT_SHIFT;
                  i = 0;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  j = i;
                  break;
                case 28:
                  mode1 = Mode.MIXED;
                  break;
                case 27:
                  mode1 = Mode.LOWER;
                  break;
                case 26:
                  i = 32;
                  mode1 = mode;
                  j = i;
                  break;
              } 
            } else {
              paramStringBuilder.append((char)paramArrayOfint2[b]);
            } 
          } else {
            mode1 = Mode.ALPHA;
          } 
      } 
      if (j != 0)
        paramStringBuilder.append(j); 
      continue;
    } 
  }
  
  private static int numericCompaction(int[] paramArrayOfint, int paramInt, StringBuilder paramStringBuilder) throws FormatException {
    // Byte code:
    //   0: bipush #15
    //   2: newarray int
    //   4: astore_3
    //   5: iconst_0
    //   6: istore #4
    //   8: iconst_0
    //   9: istore #5
    //   11: iload_1
    //   12: istore #6
    //   14: iload #5
    //   16: istore_1
    //   17: iload #6
    //   19: aload_0
    //   20: iconst_0
    //   21: iaload
    //   22: if_icmpge -> 201
    //   25: iload #4
    //   27: ifne -> 201
    //   30: iload #6
    //   32: iconst_1
    //   33: iadd
    //   34: istore #5
    //   36: aload_0
    //   37: iload #6
    //   39: iaload
    //   40: istore #7
    //   42: iload #5
    //   44: aload_0
    //   45: iconst_0
    //   46: iaload
    //   47: if_icmpne -> 53
    //   50: iconst_1
    //   51: istore #4
    //   53: iload #7
    //   55: sipush #900
    //   58: if_icmpge -> 76
    //   61: aload_3
    //   62: iload_1
    //   63: iload #7
    //   65: iastore
    //   66: iinc #1, 1
    //   69: iload #5
    //   71: istore #6
    //   73: goto -> 152
    //   76: iload #7
    //   78: sipush #928
    //   81: if_icmpeq -> 143
    //   84: iload #7
    //   86: tableswitch default -> 108, 900 -> 143, 901 -> 143
    //   108: iload #7
    //   110: tableswitch default -> 136, 922 -> 143, 923 -> 143, 924 -> 143
    //   136: iload #5
    //   138: istore #6
    //   140: goto -> 152
    //   143: iload #5
    //   145: iconst_1
    //   146: isub
    //   147: istore #6
    //   149: iconst_1
    //   150: istore #4
    //   152: iload_1
    //   153: bipush #15
    //   155: irem
    //   156: ifeq -> 175
    //   159: iload #7
    //   161: sipush #902
    //   164: if_icmpeq -> 175
    //   167: iload_1
    //   168: istore #5
    //   170: iload #4
    //   172: ifeq -> 195
    //   175: iload_1
    //   176: istore #5
    //   178: iload_1
    //   179: ifle -> 195
    //   182: aload_2
    //   183: aload_3
    //   184: iload_1
    //   185: invokestatic decodeBase900toBase10 : ([II)Ljava/lang/String;
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: iconst_0
    //   193: istore #5
    //   195: iload #5
    //   197: istore_1
    //   198: goto -> 17
    //   201: iload #6
    //   203: ireturn
  }
  
  private static int textCompaction(int[] paramArrayOfint, int paramInt, StringBuilder paramStringBuilder) {
    int[] arrayOfInt1 = new int[paramArrayOfint[0] - paramInt << 1];
    int[] arrayOfInt2 = new int[paramArrayOfint[0] - paramInt << 1];
    boolean bool = false;
    byte b = 0;
    while (true) {
      int i;
      if (paramInt < paramArrayOfint[0] && !bool) {
        i = paramInt + 1;
        paramInt = paramArrayOfint[paramInt];
        if (paramInt < 900) {
          arrayOfInt1[b] = paramInt / 30;
          arrayOfInt1[b + 1] = paramInt % 30;
          b += 2;
        } else {
          if (paramInt != 913) {
            if (paramInt != 928)
              switch (paramInt) {
                default:
                  switch (paramInt) {
                    case 922:
                    case 923:
                    case 924:
                      break;
                  } 
                  continue;
                case 900:
                  arrayOfInt1[b] = 900;
                  b++;
                  paramInt = i;
                  break;
                case 901:
                case 902:
                  break;
              }  
            paramInt = i - 1;
            bool = true;
            continue;
          } 
          arrayOfInt1[b] = 913;
          paramInt = i + 1;
          arrayOfInt2[b] = paramArrayOfint[i];
          b++;
          continue;
        } 
      } else {
        break;
      } 
      paramInt = i;
      break;
    } 
    decodeTextCompaction(arrayOfInt1, arrayOfInt2, b, paramStringBuilder);
    return paramInt;
  }
  
  private enum Mode {
    ALPHA, ALPHA_SHIFT, LOWER, MIXED, PUNCT, PUNCT_SHIFT;
    
    static {
      $VALUES = new Mode[] { ALPHA, LOWER, MIXED, PUNCT, ALPHA_SHIFT, PUNCT_SHIFT };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */