package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
  private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
  
  private static final int GB2312_SUBSET = 1;
  
  static DecoderResult decode(byte[] paramArrayOfbyte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap) throws FormatException {
    // Byte code:
    //   0: new com/google/zxing/common/BitSource
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : ([B)V
    //   8: astore #4
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: bipush #50
    //   16: invokespecial <init> : (I)V
    //   19: astore #5
    //   21: new java/util/ArrayList
    //   24: dup
    //   25: iconst_1
    //   26: invokespecial <init> : (I)V
    //   29: astore #6
    //   31: aconst_null
    //   32: astore #7
    //   34: iconst_0
    //   35: istore #8
    //   37: iconst_m1
    //   38: istore #9
    //   40: iconst_m1
    //   41: istore #10
    //   43: aload #4
    //   45: invokevirtual available : ()I
    //   48: iconst_4
    //   49: if_icmpge -> 60
    //   52: getstatic com/google/zxing/qrcode/decoder/Mode.TERMINATOR : Lcom/google/zxing/qrcode/decoder/Mode;
    //   55: astore #11
    //   57: goto -> 74
    //   60: aload #4
    //   62: iconst_4
    //   63: invokevirtual readBits : (I)I
    //   66: invokestatic forBits : (I)Lcom/google/zxing/qrcode/decoder/Mode;
    //   69: astore #11
    //   71: goto -> 57
    //   74: aload #7
    //   76: astore #12
    //   78: iload #9
    //   80: istore #13
    //   82: iload #10
    //   84: istore #14
    //   86: getstatic com/google/zxing/qrcode/decoder/DecodedBitStreamParser$1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode : [I
    //   89: aload #11
    //   91: invokevirtual ordinal : ()I
    //   94: iaload
    //   95: tableswitch default -> 132, 5 -> 229, 6 -> 287, 7 -> 287, 8 -> 248, 9 -> 206, 10 -> 143
    //   132: aload #11
    //   134: aload_1
    //   135: invokevirtual getCharacterCountBits : (Lcom/google/zxing/qrcode/decoder/Version;)I
    //   138: istore #13
    //   140: goto -> 293
    //   143: aload #4
    //   145: iconst_4
    //   146: invokevirtual readBits : (I)I
    //   149: istore #15
    //   151: aload #4
    //   153: aload #11
    //   155: aload_1
    //   156: invokevirtual getCharacterCountBits : (Lcom/google/zxing/qrcode/decoder/Version;)I
    //   159: invokevirtual readBits : (I)I
    //   162: istore #16
    //   164: aload #7
    //   166: astore #12
    //   168: iload #9
    //   170: istore #13
    //   172: iload #10
    //   174: istore #14
    //   176: iload #15
    //   178: iconst_1
    //   179: if_icmpne -> 229
    //   182: aload #4
    //   184: aload #5
    //   186: iload #16
    //   188: invokestatic decodeHanziSegment : (Lcom/google/zxing/common/BitSource;Ljava/lang/StringBuilder;I)V
    //   191: aload #7
    //   193: astore #12
    //   195: iload #9
    //   197: istore #13
    //   199: iload #10
    //   201: istore #14
    //   203: goto -> 229
    //   206: aload #4
    //   208: invokestatic parseECIValue : (Lcom/google/zxing/common/BitSource;)I
    //   211: invokestatic getCharacterSetECIByValue : (I)Lcom/google/zxing/common/CharacterSetECI;
    //   214: astore #12
    //   216: aload #12
    //   218: ifnull -> 244
    //   221: iload #10
    //   223: istore #14
    //   225: iload #9
    //   227: istore #13
    //   229: aload #12
    //   231: astore #7
    //   233: iload #13
    //   235: istore #9
    //   237: iload #14
    //   239: istore #10
    //   241: goto -> 411
    //   244: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   247: athrow
    //   248: aload #4
    //   250: invokevirtual available : ()I
    //   253: bipush #16
    //   255: if_icmplt -> 283
    //   258: aload #4
    //   260: bipush #8
    //   262: invokevirtual readBits : (I)I
    //   265: istore #13
    //   267: aload #4
    //   269: bipush #8
    //   271: invokevirtual readBits : (I)I
    //   274: istore #14
    //   276: aload #7
    //   278: astore #12
    //   280: goto -> 229
    //   283: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   286: athrow
    //   287: iconst_1
    //   288: istore #8
    //   290: goto -> 411
    //   293: aload #4
    //   295: iload #13
    //   297: invokevirtual readBits : (I)I
    //   300: istore #13
    //   302: getstatic com/google/zxing/qrcode/decoder/DecodedBitStreamParser$1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode : [I
    //   305: aload #11
    //   307: invokevirtual ordinal : ()I
    //   310: iaload
    //   311: tableswitch default -> 340, 1 -> 402, 2 -> 388, 3 -> 371, 4 -> 347
    //   340: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   343: astore_0
    //   344: goto -> 480
    //   347: aload #4
    //   349: aload #5
    //   351: iload #13
    //   353: invokestatic decodeKanjiSegment : (Lcom/google/zxing/common/BitSource;Ljava/lang/StringBuilder;I)V
    //   356: aload #7
    //   358: astore #12
    //   360: iload #9
    //   362: istore #13
    //   364: iload #10
    //   366: istore #14
    //   368: goto -> 229
    //   371: aload #4
    //   373: aload #5
    //   375: iload #13
    //   377: aload #7
    //   379: aload #6
    //   381: aload_3
    //   382: invokestatic decodeByteSegment : (Lcom/google/zxing/common/BitSource;Ljava/lang/StringBuilder;ILcom/google/zxing/common/CharacterSetECI;Ljava/util/Collection;Ljava/util/Map;)V
    //   385: goto -> 411
    //   388: aload #4
    //   390: aload #5
    //   392: iload #13
    //   394: iload #8
    //   396: invokestatic decodeAlphanumericSegment : (Lcom/google/zxing/common/BitSource;Ljava/lang/StringBuilder;IZ)V
    //   399: goto -> 411
    //   402: aload #4
    //   404: aload #5
    //   406: iload #13
    //   408: invokestatic decodeNumericSegment : (Lcom/google/zxing/common/BitSource;Ljava/lang/StringBuilder;I)V
    //   411: getstatic com/google/zxing/qrcode/decoder/Mode.TERMINATOR : Lcom/google/zxing/qrcode/decoder/Mode;
    //   414: astore #12
    //   416: aload #11
    //   418: aload #12
    //   420: if_acmpne -> 477
    //   423: aload #5
    //   425: invokevirtual toString : ()Ljava/lang/String;
    //   428: astore_3
    //   429: aload #6
    //   431: invokeinterface isEmpty : ()Z
    //   436: ifeq -> 444
    //   439: aconst_null
    //   440: astore_1
    //   441: goto -> 447
    //   444: aload #6
    //   446: astore_1
    //   447: aload_2
    //   448: ifnonnull -> 456
    //   451: aconst_null
    //   452: astore_2
    //   453: goto -> 461
    //   456: aload_2
    //   457: invokevirtual toString : ()Ljava/lang/String;
    //   460: astore_2
    //   461: new com/google/zxing/common/DecoderResult
    //   464: dup
    //   465: aload_0
    //   466: aload_3
    //   467: aload_1
    //   468: aload_2
    //   469: iload #9
    //   471: iload #10
    //   473: invokespecial <init> : ([BLjava/lang/String;Ljava/util/List;Ljava/lang/String;II)V
    //   476: areturn
    //   477: goto -> 43
    //   480: aload_0
    //   481: athrow
    //   482: astore_0
    //   483: invokestatic getFormatInstance : ()Lcom/google/zxing/FormatException;
    //   486: athrow
    // Exception table:
    //   from	to	target	type
    //   43	57	482	java/lang/IllegalArgumentException
    //   60	71	482	java/lang/IllegalArgumentException
    //   86	132	482	java/lang/IllegalArgumentException
    //   132	140	482	java/lang/IllegalArgumentException
    //   143	164	482	java/lang/IllegalArgumentException
    //   182	191	482	java/lang/IllegalArgumentException
    //   206	216	482	java/lang/IllegalArgumentException
    //   244	248	482	java/lang/IllegalArgumentException
    //   248	276	482	java/lang/IllegalArgumentException
    //   283	287	482	java/lang/IllegalArgumentException
    //   293	340	482	java/lang/IllegalArgumentException
    //   340	344	482	java/lang/IllegalArgumentException
    //   347	356	482	java/lang/IllegalArgumentException
    //   371	385	482	java/lang/IllegalArgumentException
    //   388	399	482	java/lang/IllegalArgumentException
    //   402	411	482	java/lang/IllegalArgumentException
    //   411	416	482	java/lang/IllegalArgumentException
    //   480	482	482	java/lang/IllegalArgumentException
  }
  
  private static void decodeAlphanumericSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean) throws FormatException {
    int i = paramStringBuilder.length();
    while (paramInt > 1) {
      if (paramBitSource.available() >= 11) {
        int j = paramBitSource.readBits(11);
        paramStringBuilder.append(toAlphaNumericChar(j / 45));
        paramStringBuilder.append(toAlphaNumericChar(j % 45));
        paramInt -= 2;
        continue;
      } 
      throw FormatException.getFormatInstance();
    } 
    if (paramInt == 1)
      if (paramBitSource.available() >= 6) {
        paramStringBuilder.append(toAlphaNumericChar(paramBitSource.readBits(6)));
      } else {
        throw FormatException.getFormatInstance();
      }  
    if (paramBoolean)
      for (paramInt = i; paramInt < paramStringBuilder.length(); paramInt++) {
        if (paramStringBuilder.charAt(paramInt) == '%') {
          if (paramInt < paramStringBuilder.length() - 1) {
            i = paramInt + 1;
            if (paramStringBuilder.charAt(i) == '%') {
              paramStringBuilder.deleteCharAt(i);
              continue;
            } 
          } 
          paramStringBuilder.setCharAt(paramInt, '\035');
        } 
        continue;
      }  
  }
  
  private static void decodeByteSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap) throws FormatException {
    if (paramInt << 3 <= paramBitSource.available()) {
      String str;
      byte[] arrayOfByte = new byte[paramInt];
      for (byte b = 0; b < paramInt; b++)
        arrayOfByte[b] = (byte)(byte)paramBitSource.readBits(8); 
      if (paramCharacterSetECI == null) {
        str = StringUtils.guessEncoding(arrayOfByte, paramMap);
      } else {
        str = paramCharacterSetECI.name();
      } 
      try {
        String str1 = new String();
        this(arrayOfByte, str);
        paramStringBuilder.append(str1);
        paramCollection.add(arrayOfByte);
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw FormatException.getFormatInstance();
      } 
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeHanziSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt) throws FormatException {
    if (paramInt * 13 <= paramBitSource.available()) {
      byte[] arrayOfByte = new byte[paramInt * 2];
      byte b = 0;
      while (paramInt > 0) {
        int i = paramBitSource.readBits(13);
        i = i % 96 | i / 96 << 8;
        if (i < 959) {
          i += 41377;
        } else {
          i += 42657;
        } 
        arrayOfByte[b] = (byte)(byte)(i >> 8);
        arrayOfByte[b + 1] = (byte)(byte)i;
        b += 2;
        paramInt--;
      } 
      try {
        String str = new String();
        this(arrayOfByte, "GB2312");
        paramStringBuilder.append(str);
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw FormatException.getFormatInstance();
      } 
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeKanjiSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt) throws FormatException {
    if (paramInt * 13 <= paramBitSource.available()) {
      byte[] arrayOfByte = new byte[paramInt * 2];
      byte b = 0;
      while (paramInt > 0) {
        int i = paramBitSource.readBits(13);
        i = i % 192 | i / 192 << 8;
        if (i < 7936) {
          i += 33088;
        } else {
          i += 49472;
        } 
        arrayOfByte[b] = (byte)(byte)(i >> 8);
        arrayOfByte[b + 1] = (byte)(byte)i;
        b += 2;
        paramInt--;
      } 
      try {
        String str = new String();
        this(arrayOfByte, "SJIS");
        paramStringBuilder.append(str);
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw FormatException.getFormatInstance();
      } 
    } 
    throw FormatException.getFormatInstance();
  }
  
  private static void decodeNumericSegment(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt) throws FormatException {
    while (paramInt >= 3) {
      if (paramBitSource.available() >= 10) {
        int i = paramBitSource.readBits(10);
        if (i < 1000) {
          paramStringBuilder.append(toAlphaNumericChar(i / 100));
          paramStringBuilder.append(toAlphaNumericChar(i / 10 % 10));
          paramStringBuilder.append(toAlphaNumericChar(i % 10));
          paramInt -= 3;
          continue;
        } 
        throw FormatException.getFormatInstance();
      } 
      throw FormatException.getFormatInstance();
    } 
    if (paramInt == 2) {
      if (paramBitSource.available() >= 7) {
        paramInt = paramBitSource.readBits(7);
        if (paramInt < 100) {
          paramStringBuilder.append(toAlphaNumericChar(paramInt / 10));
          paramStringBuilder.append(toAlphaNumericChar(paramInt % 10));
          return;
        } 
        throw FormatException.getFormatInstance();
      } 
      throw FormatException.getFormatInstance();
    } 
    if (paramInt == 1)
      if (paramBitSource.available() >= 4) {
        paramInt = paramBitSource.readBits(4);
        if (paramInt < 10) {
          paramStringBuilder.append(toAlphaNumericChar(paramInt));
        } else {
          throw FormatException.getFormatInstance();
        } 
      } else {
        throw FormatException.getFormatInstance();
      }  
  }
  
  private static int parseECIValue(BitSource paramBitSource) throws FormatException {
    int i = paramBitSource.readBits(8);
    if ((i & 0x80) == 0)
      return i & 0x7F; 
    if ((i & 0xC0) == 128)
      return paramBitSource.readBits(8) | (i & 0x3F) << 8; 
    if ((i & 0xE0) == 192)
      return paramBitSource.readBits(16) | (i & 0x1F) << 16; 
    throw FormatException.getFormatInstance();
  }
  
  private static char toAlphaNumericChar(int paramInt) throws FormatException {
    if (paramInt < ALPHANUMERIC_CHARS.length)
      return ALPHANUMERIC_CHARS[paramInt]; 
    throw FormatException.getFormatInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */