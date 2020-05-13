package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

final class DecodedBitStreamParser {
  private static final char[] C40_BASIC_SET_CHARS = new char[] { 
      '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
      '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
      'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  
  private static final char[] C40_SHIFT2_SET_CHARS = new char[] { 
      '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', 
      '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', 
      '?', '@', '[', '\\', ']', '^', '_' };
  
  private static final char[] TEXT_BASIC_SET_CHARS = new char[] { 
      '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
      '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 
      'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
      'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
  
  private static final char[] TEXT_SHIFT2_SET_CHARS = C40_SHIFT2_SET_CHARS;
  
  private static final char[] TEXT_SHIFT3_SET_CHARS = new char[] { 
      '`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
      'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
      'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', 
      '~', '' };
  
  static DecoderResult decode(byte[] paramArrayOfbyte) throws FormatException {
    BitSource bitSource = new BitSource(paramArrayOfbyte);
    StringBuilder stringBuilder1 = new StringBuilder(100);
    StringBuilder stringBuilder2 = new StringBuilder(0);
    ArrayList<byte[]> arrayList1 = new ArrayList(1);
    Mode mode = Mode.ASCII_ENCODE;
    do {
      if (mode == Mode.ASCII_ENCODE) {
        mode = decodeAsciiSegment(bitSource, stringBuilder1, stringBuilder2);
      } else {
        switch (mode) {
          default:
            throw FormatException.getFormatInstance();
          case BASE256_ENCODE:
            decodeBase256Segment(bitSource, stringBuilder1, (Collection<byte[]>)arrayList1);
            break;
          case EDIFACT_ENCODE:
            decodeEdifactSegment(bitSource, stringBuilder1);
            break;
          case ANSIX12_ENCODE:
            decodeAnsiX12Segment(bitSource, stringBuilder1);
            break;
          case TEXT_ENCODE:
            decodeTextSegment(bitSource, stringBuilder1);
            break;
          case C40_ENCODE:
            decodeC40Segment(bitSource, stringBuilder1);
            break;
        } 
        mode = Mode.ASCII_ENCODE;
      } 
    } while (mode != Mode.PAD_ENCODE && bitSource.available() > 0);
    if (stringBuilder2.length() > 0)
      stringBuilder1.append(stringBuilder2); 
    String str = stringBuilder1.toString();
    ArrayList<byte[]> arrayList2 = arrayList1;
    if (arrayList1.isEmpty())
      arrayList2 = null; 
    return new DecoderResult(paramArrayOfbyte, str, arrayList2, null);
  }
  
  private static void decodeAnsiX12Segment(BitSource paramBitSource, StringBuilder paramStringBuilder) throws FormatException {
    int[] arrayOfInt = new int[3];
    do {
      if (paramBitSource.available() == 8)
        return; 
      int i = paramBitSource.readBits(8);
      if (i == 254)
        return; 
      parseTwoBytes(i, paramBitSource.readBits(8), arrayOfInt);
      for (i = 0;; i++) {
        if (i < 3) {
          int j = arrayOfInt[i];
          switch (j) {
            default:
              if (j < 14) {
                paramStringBuilder.append((char)(j + 44));
                break;
              } 
              if (j < 40) {
                paramStringBuilder.append((char)(j + 51));
                i++;
                continue;
              } 
              throw FormatException.getFormatInstance();
            case 3:
              paramStringBuilder.append(' ');
              break;
            case 2:
              paramStringBuilder.append('>');
              break;
            case 1:
              paramStringBuilder.append('*');
              break;
            case 0:
              paramStringBuilder.append('\r');
              break;
          } 
        } else {
          break;
        } 
      } 
    } while (paramBitSource.available() > 0);
  }
  
  private static Mode decodeAsciiSegment(BitSource paramBitSource, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2) throws FormatException {
    boolean bool = false;
    while (true) {
      int i = paramBitSource.readBits(8);
      if (i != 0) {
        boolean bool1;
        if (i <= 128) {
          bool1 = i;
          if (bool)
            bool1 = i + 128; 
          paramStringBuilder1.append((char)(bool1 - 1));
          return Mode.ASCII_ENCODE;
        } 
        if (i == 129)
          return Mode.PAD_ENCODE; 
        if (i <= 229) {
          bool1 = i - 130;
          if (bool1 < 10)
            paramStringBuilder1.append('0'); 
          paramStringBuilder1.append(bool1);
          bool1 = bool;
        } else {
          bool1 = bool;
          switch (i) {
            default:
              if (i == 254) {
                if (paramBitSource.available() == 0) {
                  bool1 = bool;
                  break;
                } 
                continue;
              } 
              throw FormatException.getFormatInstance();
            case 240:
              return Mode.EDIFACT_ENCODE;
            case 239:
              return Mode.TEXT_ENCODE;
            case 238:
              return Mode.ANSIX12_ENCODE;
            case 237:
              paramStringBuilder1.append("[)>\03606\035");
              paramStringBuilder2.insert(0, "\036\004");
              bool1 = bool;
              break;
            case 236:
              paramStringBuilder1.append("[)>\03605\035");
              paramStringBuilder2.insert(0, "\036\004");
              bool1 = bool;
              break;
            case 235:
              bool1 = true;
              break;
            case 232:
              paramStringBuilder1.append('\035');
              bool1 = bool;
              break;
            case 231:
              return Mode.BASE256_ENCODE;
            case 230:
              return Mode.C40_ENCODE;
            case 233:
            case 234:
            case 241:
              break;
          } 
        } 
        bool = bool1;
        if (paramBitSource.available() <= 0)
          return Mode.ASCII_ENCODE; 
        continue;
      } 
      throw FormatException.getFormatInstance();
    } 
  }
  
  private static void decodeBase256Segment(BitSource paramBitSource, StringBuilder paramStringBuilder, Collection<byte[]> paramCollection) throws FormatException {
    int i = paramBitSource.getByteOffset() + 1;
    int j = paramBitSource.readBits(8);
    int k = i + 1;
    i = unrandomize255State(j, i);
    if (i == 0) {
      i = paramBitSource.available() / 8;
    } else if (i >= 250) {
      i = (i - 249) * 250 + unrandomize255State(paramBitSource.readBits(8), k);
      k++;
    } 
    if (i >= 0) {
      byte[] arrayOfByte = new byte[i];
      j = 0;
      while (j < i) {
        if (paramBitSource.available() >= 8) {
          arrayOfByte[j] = (byte)(byte)unrandomize255State(paramBitSource.readBits(8), k);
          j++;
          k++;
          continue;
        } 
        throw FormatException.getFormatInstance();
      } 
      paramCollection.add(arrayOfByte);
      try {
        String str = new String();
        this(arrayOfByte, "ISO8859_1");
        paramStringBuilder.append(str);
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(unsupportedEncodingException)));
      } 
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeC40Segment(BitSource paramBitSource, StringBuilder paramStringBuilder) throws FormatException {
    // Byte code:
    //   0: iconst_3
    //   1: newarray int
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_3
    //   6: iconst_0
    //   7: istore #4
    //   9: aload_0
    //   10: invokevirtual available : ()I
    //   13: bipush #8
    //   15: if_icmpne -> 19
    //   18: return
    //   19: aload_0
    //   20: bipush #8
    //   22: invokevirtual readBits : (I)I
    //   25: istore #5
    //   27: iload #5
    //   29: sipush #254
    //   32: if_icmpne -> 36
    //   35: return
    //   36: iload #5
    //   38: aload_0
    //   39: bipush #8
    //   41: invokevirtual readBits : (I)I
    //   44: aload_2
    //   45: invokestatic parseTwoBytes : (II[I)V
    //   48: iconst_0
    //   49: istore #5
    //   51: iload #5
    //   53: iconst_3
    //   54: if_icmpge -> 319
    //   57: aload_2
    //   58: iload #5
    //   60: iaload
    //   61: istore #6
    //   63: iload #4
    //   65: tableswitch default -> 96, 0 -> 249, 1 -> 216, 2 -> 135, 3 -> 100
    //   96: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   99: athrow
    //   100: iload_3
    //   101: ifeq -> 121
    //   104: aload_1
    //   105: iload #6
    //   107: sipush #224
    //   110: iadd
    //   111: i2c
    //   112: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iconst_0
    //   117: istore_3
    //   118: goto -> 243
    //   121: aload_1
    //   122: iload #6
    //   124: bipush #96
    //   126: iadd
    //   127: i2c
    //   128: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: goto -> 243
    //   135: iload #6
    //   137: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.C40_SHIFT2_SET_CHARS : [C
    //   140: arraylength
    //   141: if_icmpge -> 183
    //   144: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.C40_SHIFT2_SET_CHARS : [C
    //   147: iload #6
    //   149: caload
    //   150: istore #7
    //   152: iload_3
    //   153: ifeq -> 173
    //   156: aload_1
    //   157: iload #7
    //   159: sipush #128
    //   162: iadd
    //   163: i2c
    //   164: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: iconst_0
    //   169: istore_3
    //   170: goto -> 213
    //   173: aload_1
    //   174: iload #7
    //   176: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: goto -> 213
    //   183: iload #6
    //   185: bipush #27
    //   187: if_icmpeq -> 206
    //   190: iload #6
    //   192: bipush #30
    //   194: if_icmpne -> 202
    //   197: iconst_1
    //   198: istore_3
    //   199: goto -> 213
    //   202: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   205: athrow
    //   206: aload_1
    //   207: bipush #29
    //   209: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: goto -> 243
    //   216: iload_3
    //   217: ifeq -> 235
    //   220: aload_1
    //   221: iload #6
    //   223: sipush #128
    //   226: iadd
    //   227: i2c
    //   228: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: goto -> 116
    //   235: aload_1
    //   236: iload #6
    //   238: i2c
    //   239: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: iconst_0
    //   244: istore #4
    //   246: goto -> 309
    //   249: iload #6
    //   251: iconst_3
    //   252: if_icmpge -> 264
    //   255: iload #6
    //   257: iconst_1
    //   258: iadd
    //   259: istore #4
    //   261: goto -> 309
    //   264: iload #6
    //   266: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.C40_BASIC_SET_CHARS : [C
    //   269: arraylength
    //   270: if_icmpge -> 315
    //   273: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.C40_BASIC_SET_CHARS : [C
    //   276: iload #6
    //   278: caload
    //   279: istore #7
    //   281: iload_3
    //   282: ifeq -> 302
    //   285: aload_1
    //   286: iload #7
    //   288: sipush #128
    //   291: iadd
    //   292: i2c
    //   293: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: iconst_0
    //   298: istore_3
    //   299: goto -> 309
    //   302: aload_1
    //   303: iload #7
    //   305: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: iinc #5, 1
    //   312: goto -> 51
    //   315: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   318: athrow
    //   319: aload_0
    //   320: invokevirtual available : ()I
    //   323: ifgt -> 327
    //   326: return
    //   327: goto -> 9
  }
  
  private static void decodeEdifactSegment(BitSource paramBitSource, StringBuilder paramStringBuilder) {
    do {
      if (paramBitSource.available() <= 16)
        return; 
      for (int i = 0; i < 4; i++) {
        int j = paramBitSource.readBits(6);
        if (j == 31) {
          i = 8 - paramBitSource.getBitOffset();
          if (i != 8)
            paramBitSource.readBits(i); 
          return;
        } 
        int k = j;
        if ((j & 0x20) == 0)
          k = j | 0x40; 
        paramStringBuilder.append((char)k);
      } 
    } while (paramBitSource.available() > 0);
  }
  
  private static void decodeTextSegment(BitSource paramBitSource, StringBuilder paramStringBuilder) throws FormatException {
    // Byte code:
    //   0: iconst_3
    //   1: newarray int
    //   3: astore_2
    //   4: iconst_0
    //   5: istore_3
    //   6: iconst_0
    //   7: istore #4
    //   9: aload_0
    //   10: invokevirtual available : ()I
    //   13: bipush #8
    //   15: if_icmpne -> 19
    //   18: return
    //   19: aload_0
    //   20: bipush #8
    //   22: invokevirtual readBits : (I)I
    //   25: istore #5
    //   27: iload #5
    //   29: sipush #254
    //   32: if_icmpne -> 36
    //   35: return
    //   36: iload #5
    //   38: aload_0
    //   39: bipush #8
    //   41: invokevirtual readBits : (I)I
    //   44: aload_2
    //   45: invokestatic parseTwoBytes : (II[I)V
    //   48: iconst_0
    //   49: istore #5
    //   51: iload #5
    //   53: iconst_3
    //   54: if_icmpge -> 336
    //   57: aload_2
    //   58: iload #5
    //   60: iaload
    //   61: istore #6
    //   63: iload #4
    //   65: tableswitch default -> 96, 0 -> 266, 1 -> 233, 2 -> 152, 3 -> 100
    //   96: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   99: athrow
    //   100: iload #6
    //   102: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.TEXT_SHIFT3_SET_CHARS : [C
    //   105: arraylength
    //   106: if_icmpge -> 148
    //   109: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.TEXT_SHIFT3_SET_CHARS : [C
    //   112: iload #6
    //   114: caload
    //   115: istore #7
    //   117: iload_3
    //   118: ifeq -> 138
    //   121: aload_1
    //   122: iload #7
    //   124: sipush #128
    //   127: iadd
    //   128: i2c
    //   129: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iconst_0
    //   134: istore_3
    //   135: goto -> 260
    //   138: aload_1
    //   139: iload #7
    //   141: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: goto -> 260
    //   148: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   151: athrow
    //   152: iload #6
    //   154: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.TEXT_SHIFT2_SET_CHARS : [C
    //   157: arraylength
    //   158: if_icmpge -> 200
    //   161: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.TEXT_SHIFT2_SET_CHARS : [C
    //   164: iload #6
    //   166: caload
    //   167: istore #7
    //   169: iload_3
    //   170: ifeq -> 190
    //   173: aload_1
    //   174: iload #7
    //   176: sipush #128
    //   179: iadd
    //   180: i2c
    //   181: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: iconst_0
    //   186: istore_3
    //   187: goto -> 230
    //   190: aload_1
    //   191: iload #7
    //   193: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: goto -> 230
    //   200: iload #6
    //   202: bipush #27
    //   204: if_icmpeq -> 223
    //   207: iload #6
    //   209: bipush #30
    //   211: if_icmpne -> 219
    //   214: iconst_1
    //   215: istore_3
    //   216: goto -> 230
    //   219: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   222: athrow
    //   223: aload_1
    //   224: bipush #29
    //   226: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: goto -> 260
    //   233: iload_3
    //   234: ifeq -> 252
    //   237: aload_1
    //   238: iload #6
    //   240: sipush #128
    //   243: iadd
    //   244: i2c
    //   245: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: goto -> 133
    //   252: aload_1
    //   253: iload #6
    //   255: i2c
    //   256: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: iconst_0
    //   261: istore #4
    //   263: goto -> 326
    //   266: iload #6
    //   268: iconst_3
    //   269: if_icmpge -> 281
    //   272: iload #6
    //   274: iconst_1
    //   275: iadd
    //   276: istore #4
    //   278: goto -> 326
    //   281: iload #6
    //   283: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.TEXT_BASIC_SET_CHARS : [C
    //   286: arraylength
    //   287: if_icmpge -> 332
    //   290: getstatic com/google/zxing/datamatrix/decoder/DecodedBitStreamParser.TEXT_BASIC_SET_CHARS : [C
    //   293: iload #6
    //   295: caload
    //   296: istore #7
    //   298: iload_3
    //   299: ifeq -> 319
    //   302: aload_1
    //   303: iload #7
    //   305: sipush #128
    //   308: iadd
    //   309: i2c
    //   310: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: iconst_0
    //   315: istore_3
    //   316: goto -> 326
    //   319: aload_1
    //   320: iload #7
    //   322: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: iinc #5, 1
    //   329: goto -> 51
    //   332: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   335: athrow
    //   336: aload_0
    //   337: invokevirtual available : ()I
    //   340: ifgt -> 344
    //   343: return
    //   344: goto -> 9
  }
  
  private static void parseTwoBytes(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    paramInt1 = (paramInt1 << 8) + paramInt2 - 1;
    paramInt2 = paramInt1 / 1600;
    paramArrayOfint[0] = paramInt2;
    paramInt1 -= paramInt2 * 1600;
    paramInt2 = paramInt1 / 40;
    paramArrayOfint[1] = paramInt2;
    paramArrayOfint[2] = paramInt1 - paramInt2 * 40;
  }
  
  private static int unrandomize255State(int paramInt1, int paramInt2) {
    paramInt1 -= paramInt2 * 149 % 255 + 1;
    return (paramInt1 >= 0) ? paramInt1 : (paramInt1 + 256);
  }
  
  private enum Mode {
    ANSIX12_ENCODE, ASCII_ENCODE, BASE256_ENCODE, C40_ENCODE, EDIFACT_ENCODE, PAD_ENCODE, TEXT_ENCODE;
    
    static {
      ANSIX12_ENCODE = new Mode("ANSIX12_ENCODE", 4);
      EDIFACT_ENCODE = new Mode("EDIFACT_ENCODE", 5);
      BASE256_ENCODE = new Mode("BASE256_ENCODE", 6);
      $VALUES = new Mode[] { PAD_ENCODE, ASCII_ENCODE, C40_ENCODE, TEXT_ENCODE, ANSIX12_ENCODE, EDIFACT_ENCODE, BASE256_ENCODE };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */