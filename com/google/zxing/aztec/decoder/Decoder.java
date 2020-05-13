package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;

public final class Decoder {
  private static final String[] DIGIT_TABLE;
  
  private static final String[] LOWER_TABLE;
  
  private static final String[] MIXED_TABLE;
  
  private static final String[] PUNCT_TABLE;
  
  private static final String[] UPPER_TABLE = new String[] { 
      "CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", 
      "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
      "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", 
      "CTRL_DL", "CTRL_BS" };
  
  private AztecDetectorResult ddata;
  
  static {
    LOWER_TABLE = new String[] { 
        "CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", 
        "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", 
        "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", 
        "CTRL_DL", "CTRL_BS" };
    MIXED_TABLE = new String[] { 
        "CTRL_PS", " ", "\001", "\002", "\003", "\004", "\005", "\006", "\007", "\b", 
        "\t", "\n", "\013", "\f", "\r", "\033", "\034", "\035", "\036", "\037", 
        "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", 
        "CTRL_PL", "CTRL_BS" };
    PUNCT_TABLE = new String[] { 
        "", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", 
        "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", 
        "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", 
        "}", "CTRL_UL" };
    DIGIT_TABLE = new String[] { 
        "CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", 
        "8", "9", ",", ".", "CTRL_UL", "CTRL_US" };
  }
  
  static byte[] convertBoolArrayToByteArray(boolean[] paramArrayOfboolean) {
    byte[] arrayOfByte = new byte[(paramArrayOfboolean.length + 7) / 8];
    for (byte b = 0; b < arrayOfByte.length; b++)
      arrayOfByte[b] = readByte(paramArrayOfboolean, b << 3); 
    return arrayOfByte;
  }
  
  private boolean[] correctBits(boolean[] paramArrayOfboolean) throws FormatException {
    // Byte code:
    //   0: aload_0
    //   1: getfield ddata : Lcom/google/zxing/aztec/AztecDetectorResult;
    //   4: invokevirtual getNbLayers : ()I
    //   7: istore_2
    //   8: bipush #8
    //   10: istore_3
    //   11: iload_2
    //   12: iconst_2
    //   13: if_icmpgt -> 27
    //   16: bipush #6
    //   18: istore_3
    //   19: getstatic com/google/zxing/common/reedsolomon/GenericGF.AZTEC_DATA_6 : Lcom/google/zxing/common/reedsolomon/GenericGF;
    //   22: astore #4
    //   24: goto -> 78
    //   27: aload_0
    //   28: getfield ddata : Lcom/google/zxing/aztec/AztecDetectorResult;
    //   31: invokevirtual getNbLayers : ()I
    //   34: bipush #8
    //   36: if_icmpgt -> 47
    //   39: getstatic com/google/zxing/common/reedsolomon/GenericGF.AZTEC_DATA_8 : Lcom/google/zxing/common/reedsolomon/GenericGF;
    //   42: astore #4
    //   44: goto -> 78
    //   47: aload_0
    //   48: getfield ddata : Lcom/google/zxing/aztec/AztecDetectorResult;
    //   51: invokevirtual getNbLayers : ()I
    //   54: bipush #22
    //   56: if_icmpgt -> 70
    //   59: bipush #10
    //   61: istore_3
    //   62: getstatic com/google/zxing/common/reedsolomon/GenericGF.AZTEC_DATA_10 : Lcom/google/zxing/common/reedsolomon/GenericGF;
    //   65: astore #4
    //   67: goto -> 78
    //   70: bipush #12
    //   72: istore_3
    //   73: getstatic com/google/zxing/common/reedsolomon/GenericGF.AZTEC_DATA_12 : Lcom/google/zxing/common/reedsolomon/GenericGF;
    //   76: astore #4
    //   78: aload_0
    //   79: getfield ddata : Lcom/google/zxing/aztec/AztecDetectorResult;
    //   82: invokevirtual getNbDatablocks : ()I
    //   85: istore #5
    //   87: aload_1
    //   88: arraylength
    //   89: iload_3
    //   90: idiv
    //   91: istore #6
    //   93: iload #6
    //   95: iload #5
    //   97: if_icmplt -> 382
    //   100: aload_1
    //   101: arraylength
    //   102: istore_2
    //   103: iload #6
    //   105: newarray int
    //   107: astore #7
    //   109: iload_2
    //   110: iload_3
    //   111: irem
    //   112: istore_2
    //   113: iconst_0
    //   114: istore #8
    //   116: iload #8
    //   118: iload #6
    //   120: if_icmpge -> 144
    //   123: aload #7
    //   125: iload #8
    //   127: aload_1
    //   128: iload_2
    //   129: iload_3
    //   130: invokestatic readCode : ([ZII)I
    //   133: iastore
    //   134: iinc #8, 1
    //   137: iload_2
    //   138: iload_3
    //   139: iadd
    //   140: istore_2
    //   141: goto -> 116
    //   144: new com/google/zxing/common/reedsolomon/ReedSolomonDecoder
    //   147: astore_1
    //   148: aload_1
    //   149: aload #4
    //   151: invokespecial <init> : (Lcom/google/zxing/common/reedsolomon/GenericGF;)V
    //   154: aload_1
    //   155: aload #7
    //   157: iload #6
    //   159: iload #5
    //   161: isub
    //   162: invokevirtual decode : ([II)V
    //   165: iconst_1
    //   166: iload_3
    //   167: ishl
    //   168: iconst_1
    //   169: isub
    //   170: istore #9
    //   172: iconst_0
    //   173: istore #8
    //   175: iconst_0
    //   176: istore_2
    //   177: iload #8
    //   179: iload #5
    //   181: if_icmpge -> 239
    //   184: aload #7
    //   186: iload #8
    //   188: iaload
    //   189: istore #10
    //   191: iload #10
    //   193: ifeq -> 235
    //   196: iload #10
    //   198: iload #9
    //   200: if_icmpeq -> 235
    //   203: iload #10
    //   205: iconst_1
    //   206: if_icmpeq -> 221
    //   209: iload_2
    //   210: istore #6
    //   212: iload #10
    //   214: iload #9
    //   216: iconst_1
    //   217: isub
    //   218: if_icmpne -> 226
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore #6
    //   226: iinc #8, 1
    //   229: iload #6
    //   231: istore_2
    //   232: goto -> 177
    //   235: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   238: athrow
    //   239: iload #5
    //   241: iload_3
    //   242: imul
    //   243: iload_2
    //   244: isub
    //   245: newarray boolean
    //   247: astore_1
    //   248: iconst_0
    //   249: istore #6
    //   251: iconst_0
    //   252: istore_2
    //   253: iload #6
    //   255: iload #5
    //   257: if_icmpge -> 374
    //   260: aload #7
    //   262: iload #6
    //   264: iaload
    //   265: istore #11
    //   267: iload #11
    //   269: iconst_1
    //   270: if_icmpeq -> 331
    //   273: iload #11
    //   275: iload #9
    //   277: iconst_1
    //   278: isub
    //   279: if_icmpne -> 285
    //   282: goto -> 331
    //   285: iload_3
    //   286: iconst_1
    //   287: isub
    //   288: istore #10
    //   290: iload_2
    //   291: istore #8
    //   293: iload #10
    //   295: iflt -> 365
    //   298: iconst_1
    //   299: iload #10
    //   301: ishl
    //   302: iload #11
    //   304: iand
    //   305: ifeq -> 314
    //   308: iconst_1
    //   309: istore #12
    //   311: goto -> 317
    //   314: iconst_0
    //   315: istore #12
    //   317: aload_1
    //   318: iload_2
    //   319: iload #12
    //   321: bastore
    //   322: iinc #10, -1
    //   325: iinc #2, 1
    //   328: goto -> 290
    //   331: iload #11
    //   333: iconst_1
    //   334: if_icmple -> 343
    //   337: iconst_1
    //   338: istore #12
    //   340: goto -> 346
    //   343: iconst_0
    //   344: istore #12
    //   346: aload_1
    //   347: iload_2
    //   348: iload_2
    //   349: iload_3
    //   350: iadd
    //   351: iconst_1
    //   352: isub
    //   353: iload #12
    //   355: invokestatic fill : ([ZIIZ)V
    //   358: iload_2
    //   359: iload_3
    //   360: iconst_1
    //   361: isub
    //   362: iadd
    //   363: istore #8
    //   365: iinc #6, 1
    //   368: iload #8
    //   370: istore_2
    //   371: goto -> 253
    //   374: aload_1
    //   375: areturn
    //   376: astore_1
    //   377: aload_1
    //   378: invokestatic getFormatInstance : (Ljava/lang/Throwable;)Lcom/google/zxing/FormatException;
    //   381: athrow
    //   382: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   385: athrow
    // Exception table:
    //   from	to	target	type
    //   144	165	376	com/google/zxing/common/reedsolomon/ReedSolomonException
  }
  
  private boolean[] extractBits(BitMatrix paramBitMatrix) {
    boolean bool = this.ddata.isCompact();
    int i = this.ddata.getNbLayers();
    if (bool) {
      j = 11;
    } else {
      j = 14;
    } 
    int k = j + (i << 2);
    int[] arrayOfInt = new int[k];
    boolean[] arrayOfBoolean = new boolean[totalBitsInLayer(i, bool)];
    if (bool) {
      for (j = 0; j < arrayOfInt.length; j++)
        arrayOfInt[j] = j; 
    } else {
      int m = k / 2;
      int n = (k + 1 + (m - 1) / 15 * 2) / 2;
      for (j = 0; j < m; j++) {
        int i1 = j / 15 + j;
        arrayOfInt[m - j - 1] = n - i1 - 1;
        arrayOfInt[m + j] = i1 + n + 1;
      } 
    } 
    byte b = 0;
    int j = 0;
    while (b < i) {
      if (bool) {
        b1 = 9;
      } else {
        b1 = 12;
      } 
      int m = (i - b << 2) + b1;
      int n = b << 1;
      int i1 = k - 1 - n;
      for (byte b1 = 0; b1 < m; b1++) {
        int i2 = b1 << 1;
        for (byte b2 = 0; b2 < 2; b2++) {
          int i3 = n + b2;
          int i4 = arrayOfInt[i3];
          int i5 = n + b1;
          arrayOfBoolean[j + i2 + b2] = paramBitMatrix.get(i4, arrayOfInt[i5]);
          i4 = arrayOfInt[i5];
          i5 = i1 - b2;
          arrayOfBoolean[m * 2 + j + i2 + b2] = paramBitMatrix.get(i4, arrayOfInt[i5]);
          i4 = arrayOfInt[i5];
          i5 = i1 - b1;
          arrayOfBoolean[m * 4 + j + i2 + b2] = paramBitMatrix.get(i4, arrayOfInt[i5]);
          arrayOfBoolean[m * 6 + j + i2 + b2] = paramBitMatrix.get(arrayOfInt[i5], arrayOfInt[i3]);
        } 
      } 
      j += m << 3;
      b++;
    } 
    return arrayOfBoolean;
  }
  
  private static String getCharacter(Table paramTable, int paramInt) {
    switch (paramTable) {
      default:
        throw new IllegalStateException("Bad table");
      case DIGIT:
        return DIGIT_TABLE[paramInt];
      case PUNCT:
        return PUNCT_TABLE[paramInt];
      case MIXED:
        return MIXED_TABLE[paramInt];
      case LOWER:
        return LOWER_TABLE[paramInt];
      case UPPER:
        break;
    } 
    return UPPER_TABLE[paramInt];
  }
  
  private static String getEncodedData(boolean[] paramArrayOfboolean) {
    int i = paramArrayOfboolean.length;
    Table table1 = Table.UPPER;
    Table table2 = Table.UPPER;
    StringBuilder stringBuilder = new StringBuilder(20);
    int j = 0;
    while (j < i) {
      if (table2 == Table.BINARY) {
        if (i - j >= 5) {
          int k = readCode(paramArrayOfboolean, j, 5);
          int m = j + 5;
          j = m;
          int n = k;
          if (k == 0)
            if (i - m >= 11) {
              n = readCode(paramArrayOfboolean, m, 11) + 31;
              j = m + 11;
            } else {
              break;
            }  
          for (k = 0; k < n; k++) {
            if (i - j < 8) {
              j = i;
              break;
            } 
            stringBuilder.append((char)readCode(paramArrayOfboolean, j, 8));
            j += 8;
          } 
        } else {
          break;
        } 
      } else {
        byte b;
        if (table2 == Table.DIGIT) {
          b = 4;
        } else {
          b = 5;
        } 
        if (i - j >= b) {
          Table table;
          int k = readCode(paramArrayOfboolean, j, b);
          j += b;
          String str = getCharacter(table2, k);
          if (str.startsWith("CTRL_")) {
            table1 = getTable(str.charAt(5));
            if (str.charAt(6) != 'L') {
              table = table2;
              table2 = table1;
              table1 = table;
              continue;
            } 
          } else {
            stringBuilder.append((String)table);
          } 
        } else {
          break;
        } 
      } 
      table2 = table1;
    } 
    return stringBuilder.toString();
  }
  
  private static Table getTable(char paramChar) {
    if (paramChar != 'B') {
      if (paramChar != 'D') {
        if (paramChar != 'P') {
          switch (paramChar) {
            default:
              return Table.UPPER;
            case 'M':
              return Table.MIXED;
            case 'L':
              break;
          } 
          return Table.LOWER;
        } 
        return Table.PUNCT;
      } 
      return Table.DIGIT;
    } 
    return Table.BINARY;
  }
  
  public static String highLevelDecode(boolean[] paramArrayOfboolean) {
    return getEncodedData(paramArrayOfboolean);
  }
  
  private static byte readByte(boolean[] paramArrayOfboolean, int paramInt) {
    int i = paramArrayOfboolean.length - paramInt;
    return (i >= 8) ? (byte)readCode(paramArrayOfboolean, paramInt, 8) : (byte)(readCode(paramArrayOfboolean, paramInt, i) << 8 - i);
  }
  
  private static int readCode(boolean[] paramArrayOfboolean, int paramInt1, int paramInt2) {
    int i = paramInt1;
    int j = 0;
    while (i < paramInt1 + paramInt2) {
      int k = j << 1;
      j = k;
      if (paramArrayOfboolean[i])
        j = k | 0x1; 
      i++;
    } 
    return j;
  }
  
  private static int totalBitsInLayer(int paramInt, boolean paramBoolean) {
    byte b;
    if (paramBoolean) {
      b = 88;
    } else {
      b = 112;
    } 
    return (b + (paramInt << 4)) * paramInt;
  }
  
  public DecoderResult decode(AztecDetectorResult paramAztecDetectorResult) throws FormatException {
    this.ddata = paramAztecDetectorResult;
    boolean[] arrayOfBoolean = correctBits(extractBits(paramAztecDetectorResult.getBits()));
    DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(arrayOfBoolean), getEncodedData(arrayOfBoolean), null, null);
    decoderResult.setNumBits(arrayOfBoolean.length);
    return decoderResult;
  }
  
  private enum Table {
    BINARY, DIGIT, LOWER, MIXED, PUNCT, UPPER;
    
    static {
      DIGIT = new Table("DIGIT", 3);
      PUNCT = new Table("PUNCT", 4);
      BINARY = new Table("BINARY", 5);
      $VALUES = new Table[] { UPPER, LOWER, MIXED, DIGIT, PUNCT, BINARY };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */