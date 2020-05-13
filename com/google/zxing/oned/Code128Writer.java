package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
  private static final int CODE_CODE_A = 101;
  
  private static final int CODE_CODE_B = 100;
  
  private static final int CODE_CODE_C = 99;
  
  private static final int CODE_FNC_1 = 102;
  
  private static final int CODE_FNC_2 = 97;
  
  private static final int CODE_FNC_3 = 96;
  
  private static final int CODE_FNC_4_A = 101;
  
  private static final int CODE_FNC_4_B = 100;
  
  private static final int CODE_START_A = 103;
  
  private static final int CODE_START_B = 104;
  
  private static final int CODE_START_C = 105;
  
  private static final int CODE_STOP = 106;
  
  private static final char ESCAPE_FNC_1 = 'ñ';
  
  private static final char ESCAPE_FNC_2 = 'ò';
  
  private static final char ESCAPE_FNC_3 = 'ó';
  
  private static final char ESCAPE_FNC_4 = 'ô';
  
  private static int chooseCode(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    CType cType1 = findCType(paramCharSequence, paramInt1);
    if (cType1 == CType.ONE_DIGIT)
      return 100; 
    if (cType1 == CType.UNCODABLE) {
      if (paramInt1 < paramCharSequence.length()) {
        paramInt1 = paramCharSequence.charAt(paramInt1);
        if (paramInt1 < 32 || (paramInt2 == 101 && paramInt1 < 96))
          return 101; 
      } 
      return 100;
    } 
    if (paramInt2 == 99)
      return 99; 
    if (paramInt2 == 100) {
      if (cType1 == CType.FNC_1)
        return 100; 
      CType cType = findCType(paramCharSequence, paramInt1 + 2);
      if (cType == CType.UNCODABLE || cType == CType.ONE_DIGIT)
        return 100; 
      if (cType == CType.FNC_1)
        return (findCType(paramCharSequence, paramInt1 + 3) == CType.TWO_DIGITS) ? 99 : 100; 
      paramInt1 += 4;
      while (true) {
        cType = findCType(paramCharSequence, paramInt1);
        if (cType == CType.TWO_DIGITS) {
          paramInt1 += 2;
          continue;
        } 
        return (cType == CType.ONE_DIGIT) ? 100 : 99;
      } 
    } 
    CType cType2 = cType1;
    if (cType1 == CType.FNC_1)
      cType2 = findCType(paramCharSequence, paramInt1 + 1); 
    return (cType2 == CType.TWO_DIGITS) ? 99 : 100;
  }
  
  private static CType findCType(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    if (paramInt >= i)
      return CType.UNCODABLE; 
    char c = paramCharSequence.charAt(paramInt);
    if (c == 'ñ')
      return CType.FNC_1; 
    if (c < '0' || c > '9')
      return CType.UNCODABLE; 
    if (++paramInt >= i)
      return CType.ONE_DIGIT; 
    paramInt = paramCharSequence.charAt(paramInt);
    return (paramInt < 48 || paramInt > 57) ? CType.ONE_DIGIT : CType.TWO_DIGITS;
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    if (paramBarcodeFormat == BarcodeFormat.CODE_128)
      return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap); 
    throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(paramBarcodeFormat)));
  }
  
  public boolean[] encode(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual length : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: ifle -> 639
    //   9: iload_2
    //   10: bipush #80
    //   12: if_icmpgt -> 639
    //   15: iconst_0
    //   16: istore_3
    //   17: iconst_0
    //   18: istore #4
    //   20: iload #4
    //   22: iload_2
    //   23: if_icmpge -> 99
    //   26: aload_1
    //   27: iload #4
    //   29: invokevirtual charAt : (I)C
    //   32: istore #5
    //   34: iload #5
    //   36: tableswitch default -> 68, 241 -> 75, 242 -> 75, 243 -> 75, 244 -> 75
    //   68: iload #5
    //   70: bipush #127
    //   72: if_icmpgt -> 81
    //   75: iinc #4, 1
    //   78: goto -> 20
    //   81: new java/lang/IllegalArgumentException
    //   84: dup
    //   85: ldc 'Bad character in input: '
    //   87: iload #5
    //   89: invokestatic valueOf : (C)Ljava/lang/String;
    //   92: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: athrow
    //   99: new java/util/ArrayList
    //   102: dup
    //   103: invokespecial <init> : ()V
    //   106: astore #6
    //   108: iconst_0
    //   109: istore #7
    //   111: iconst_0
    //   112: istore #8
    //   114: iconst_0
    //   115: istore #9
    //   117: iconst_1
    //   118: istore #10
    //   120: bipush #103
    //   122: istore #4
    //   124: iload #7
    //   126: iload_2
    //   127: if_icmpge -> 489
    //   130: aload_1
    //   131: iload #7
    //   133: iload #8
    //   135: invokestatic chooseCode : (Ljava/lang/CharSequence;II)I
    //   138: istore #11
    //   140: iload #11
    //   142: iload #8
    //   144: if_icmpne -> 373
    //   147: aload_1
    //   148: iload #7
    //   150: invokevirtual charAt : (I)C
    //   153: istore #11
    //   155: bipush #101
    //   157: istore #4
    //   159: iload #11
    //   161: tableswitch default -> 192, 241 -> 287, 242 -> 276, 243 -> 265, 244 -> 240
    //   192: iload #8
    //   194: tableswitch default -> 216, 100 -> 336, 101 -> 298
    //   216: aload_1
    //   217: iload #7
    //   219: iload #7
    //   221: iconst_2
    //   222: iadd
    //   223: invokevirtual substring : (II)Ljava/lang/String;
    //   226: invokestatic parseInt : (Ljava/lang/String;)I
    //   229: istore #4
    //   231: iload #7
    //   233: iconst_1
    //   234: iadd
    //   235: istore #11
    //   237: goto -> 351
    //   240: iload #8
    //   242: bipush #101
    //   244: if_icmpne -> 254
    //   247: iload #7
    //   249: istore #11
    //   251: goto -> 351
    //   254: bipush #100
    //   256: istore #4
    //   258: iload #7
    //   260: istore #11
    //   262: goto -> 351
    //   265: bipush #96
    //   267: istore #4
    //   269: iload #7
    //   271: istore #11
    //   273: goto -> 351
    //   276: bipush #97
    //   278: istore #4
    //   280: iload #7
    //   282: istore #11
    //   284: goto -> 351
    //   287: bipush #102
    //   289: istore #4
    //   291: iload #7
    //   293: istore #11
    //   295: goto -> 351
    //   298: aload_1
    //   299: iload #7
    //   301: invokevirtual charAt : (I)C
    //   304: bipush #32
    //   306: isub
    //   307: istore #12
    //   309: iload #7
    //   311: istore #11
    //   313: iload #12
    //   315: istore #4
    //   317: iload #12
    //   319: ifge -> 351
    //   322: iload #12
    //   324: bipush #96
    //   326: iadd
    //   327: istore #4
    //   329: iload #7
    //   331: istore #11
    //   333: goto -> 351
    //   336: aload_1
    //   337: iload #7
    //   339: invokevirtual charAt : (I)C
    //   342: bipush #32
    //   344: isub
    //   345: istore #4
    //   347: iload #7
    //   349: istore #11
    //   351: iinc #11, 1
    //   354: iload #4
    //   356: istore #7
    //   358: iload #11
    //   360: istore #4
    //   362: iload #8
    //   364: istore #11
    //   366: iload #7
    //   368: istore #8
    //   370: goto -> 430
    //   373: iload #8
    //   375: ifne -> 418
    //   378: iload #11
    //   380: tableswitch default -> 404, 100 -> 411, 101 -> 422
    //   404: bipush #105
    //   406: istore #4
    //   408: goto -> 422
    //   411: bipush #104
    //   413: istore #4
    //   415: goto -> 422
    //   418: iload #11
    //   420: istore #4
    //   422: iload #4
    //   424: istore #8
    //   426: iload #7
    //   428: istore #4
    //   430: aload #6
    //   432: getstatic com/google/zxing/oned/Code128Reader.CODE_PATTERNS : [[I
    //   435: iload #8
    //   437: aaload
    //   438: invokeinterface add : (Ljava/lang/Object;)Z
    //   443: pop
    //   444: iload #9
    //   446: iload #8
    //   448: iload #10
    //   450: imul
    //   451: iadd
    //   452: istore #12
    //   454: iload #4
    //   456: istore #7
    //   458: iload #11
    //   460: istore #8
    //   462: iload #12
    //   464: istore #9
    //   466: iload #4
    //   468: ifeq -> 120
    //   471: iinc #10, 1
    //   474: iload #4
    //   476: istore #7
    //   478: iload #11
    //   480: istore #8
    //   482: iload #12
    //   484: istore #9
    //   486: goto -> 120
    //   489: aload #6
    //   491: getstatic com/google/zxing/oned/Code128Reader.CODE_PATTERNS : [[I
    //   494: iload #9
    //   496: bipush #103
    //   498: irem
    //   499: aaload
    //   500: invokeinterface add : (Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload #6
    //   508: getstatic com/google/zxing/oned/Code128Reader.CODE_PATTERNS : [[I
    //   511: bipush #106
    //   513: aaload
    //   514: invokeinterface add : (Ljava/lang/Object;)Z
    //   519: pop
    //   520: aload #6
    //   522: invokeinterface iterator : ()Ljava/util/Iterator;
    //   527: astore_1
    //   528: iconst_0
    //   529: istore #4
    //   531: aload_1
    //   532: invokeinterface hasNext : ()Z
    //   537: ifeq -> 585
    //   540: aload_1
    //   541: invokeinterface next : ()Ljava/lang/Object;
    //   546: checkcast [I
    //   549: astore #13
    //   551: aload #13
    //   553: arraylength
    //   554: istore #10
    //   556: iconst_0
    //   557: istore #7
    //   559: iload #7
    //   561: iload #10
    //   563: if_icmpge -> 582
    //   566: iload #4
    //   568: aload #13
    //   570: iload #7
    //   572: iaload
    //   573: iadd
    //   574: istore #4
    //   576: iinc #7, 1
    //   579: goto -> 559
    //   582: goto -> 531
    //   585: iload #4
    //   587: newarray boolean
    //   589: astore_1
    //   590: aload #6
    //   592: invokeinterface iterator : ()Ljava/util/Iterator;
    //   597: astore #6
    //   599: iload_3
    //   600: istore #4
    //   602: aload #6
    //   604: invokeinterface hasNext : ()Z
    //   609: ifeq -> 637
    //   612: iload #4
    //   614: aload_1
    //   615: iload #4
    //   617: aload #6
    //   619: invokeinterface next : ()Ljava/lang/Object;
    //   624: checkcast [I
    //   627: iconst_1
    //   628: invokestatic appendPattern : ([ZI[IZ)I
    //   631: iadd
    //   632: istore #4
    //   634: goto -> 602
    //   637: aload_1
    //   638: areturn
    //   639: new java/lang/IllegalArgumentException
    //   642: dup
    //   643: ldc 'Contents length should be between 1 and 80 characters, but got '
    //   645: iload_2
    //   646: invokestatic valueOf : (I)Ljava/lang/String;
    //   649: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   652: invokespecial <init> : (Ljava/lang/String;)V
    //   655: athrow
  }
  
  private enum CType {
    FNC_1, ONE_DIGIT, TWO_DIGITS, UNCODABLE;
    
    static {
      FNC_1 = new CType("FNC_1", 3);
      $VALUES = new CType[] { UNCODABLE, ONE_DIGIT, TWO_DIGITS, FNC_1 };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\Code128Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */