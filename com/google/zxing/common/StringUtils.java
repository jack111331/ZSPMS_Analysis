package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils {
  static {
    if ("SJIS".equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || "EUC_JP".equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING)) {
      bool = true;
    } else {
      bool = false;
    } 
    ASSUME_SHIFT_JIS = bool;
  }
  
  public static String guessEncoding(byte[] paramArrayOfbyte, Map<DecodeHintType, ?> paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: aload_1
    //   3: ifnull -> 31
    //   6: aload_1
    //   7: getstatic com/google/zxing/DecodeHintType.CHARACTER_SET : Lcom/google/zxing/DecodeHintType;
    //   10: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   15: ifeq -> 31
    //   18: aload_1
    //   19: getstatic com/google/zxing/DecodeHintType.CHARACTER_SET : Lcom/google/zxing/DecodeHintType;
    //   22: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: areturn
    //   31: aload_2
    //   32: arraylength
    //   33: istore_3
    //   34: aload_2
    //   35: arraylength
    //   36: istore #4
    //   38: iconst_0
    //   39: istore #5
    //   41: iload #4
    //   43: iconst_3
    //   44: if_icmple -> 77
    //   47: aload_2
    //   48: iconst_0
    //   49: baload
    //   50: bipush #-17
    //   52: if_icmpne -> 77
    //   55: aload_2
    //   56: iconst_1
    //   57: baload
    //   58: bipush #-69
    //   60: if_icmpne -> 77
    //   63: aload_2
    //   64: iconst_2
    //   65: baload
    //   66: bipush #-65
    //   68: if_icmpne -> 77
    //   71: iconst_1
    //   72: istore #6
    //   74: goto -> 80
    //   77: iconst_0
    //   78: istore #6
    //   80: iconst_0
    //   81: istore #7
    //   83: iconst_0
    //   84: istore #8
    //   86: iconst_1
    //   87: istore #9
    //   89: iconst_1
    //   90: istore #10
    //   92: iconst_1
    //   93: istore #11
    //   95: iconst_0
    //   96: istore #12
    //   98: iconst_0
    //   99: istore #13
    //   101: iconst_0
    //   102: istore #14
    //   104: iconst_0
    //   105: istore #15
    //   107: iconst_0
    //   108: istore #16
    //   110: iconst_0
    //   111: istore #17
    //   113: iconst_0
    //   114: istore #18
    //   116: iconst_0
    //   117: istore #19
    //   119: iconst_0
    //   120: istore #20
    //   122: iload #8
    //   124: iload_3
    //   125: if_icmpge -> 839
    //   128: iload #9
    //   130: ifne -> 143
    //   133: iload #10
    //   135: ifne -> 143
    //   138: iload #11
    //   140: ifeq -> 839
    //   143: aload_0
    //   144: iload #8
    //   146: baload
    //   147: sipush #255
    //   150: iand
    //   151: istore #21
    //   153: iload #11
    //   155: istore #22
    //   157: iload #12
    //   159: istore #4
    //   161: iload #14
    //   163: istore #23
    //   165: iload #15
    //   167: istore #24
    //   169: iload #16
    //   171: istore #25
    //   173: iload #11
    //   175: ifeq -> 387
    //   178: iload #12
    //   180: ifle -> 221
    //   183: iload #12
    //   185: istore #4
    //   187: iload #21
    //   189: sipush #128
    //   192: iand
    //   193: ifeq -> 372
    //   196: iload #12
    //   198: iconst_1
    //   199: isub
    //   200: istore #4
    //   202: iload #11
    //   204: istore #22
    //   206: iload #14
    //   208: istore #23
    //   210: iload #15
    //   212: istore #24
    //   214: iload #16
    //   216: istore #25
    //   218: goto -> 387
    //   221: iload #11
    //   223: istore #22
    //   225: iload #12
    //   227: istore #4
    //   229: iload #14
    //   231: istore #23
    //   233: iload #15
    //   235: istore #24
    //   237: iload #16
    //   239: istore #25
    //   241: iload #21
    //   243: sipush #128
    //   246: iand
    //   247: ifeq -> 387
    //   250: iload #12
    //   252: istore #4
    //   254: iload #21
    //   256: bipush #64
    //   258: iand
    //   259: ifeq -> 372
    //   262: iload #12
    //   264: iconst_1
    //   265: iadd
    //   266: istore #4
    //   268: iload #21
    //   270: bipush #32
    //   272: iand
    //   273: ifne -> 297
    //   276: iload #14
    //   278: iconst_1
    //   279: iadd
    //   280: istore #23
    //   282: iload #11
    //   284: istore #22
    //   286: iload #15
    //   288: istore #24
    //   290: iload #16
    //   292: istore #25
    //   294: goto -> 387
    //   297: iinc #4, 1
    //   300: iload #21
    //   302: bipush #16
    //   304: iand
    //   305: ifne -> 329
    //   308: iload #15
    //   310: iconst_1
    //   311: iadd
    //   312: istore #24
    //   314: iload #11
    //   316: istore #22
    //   318: iload #14
    //   320: istore #23
    //   322: iload #16
    //   324: istore #25
    //   326: goto -> 387
    //   329: iload #4
    //   331: iconst_1
    //   332: iadd
    //   333: istore #12
    //   335: iload #12
    //   337: istore #4
    //   339: iload #21
    //   341: bipush #8
    //   343: iand
    //   344: ifne -> 372
    //   347: iload #16
    //   349: iconst_1
    //   350: iadd
    //   351: istore #25
    //   353: iload #11
    //   355: istore #22
    //   357: iload #12
    //   359: istore #4
    //   361: iload #14
    //   363: istore #23
    //   365: iload #15
    //   367: istore #24
    //   369: goto -> 387
    //   372: iconst_0
    //   373: istore #22
    //   375: iload #16
    //   377: istore #25
    //   379: iload #15
    //   381: istore #24
    //   383: iload #14
    //   385: istore #23
    //   387: iload #9
    //   389: istore #12
    //   391: iload #18
    //   393: istore #26
    //   395: iload #9
    //   397: ifeq -> 483
    //   400: iload #21
    //   402: bipush #127
    //   404: if_icmple -> 425
    //   407: iload #21
    //   409: sipush #160
    //   412: if_icmpge -> 425
    //   415: iconst_0
    //   416: istore #12
    //   418: iload #18
    //   420: istore #26
    //   422: goto -> 483
    //   425: iload #9
    //   427: istore #12
    //   429: iload #18
    //   431: istore #26
    //   433: iload #21
    //   435: sipush #159
    //   438: if_icmple -> 483
    //   441: iload #21
    //   443: sipush #192
    //   446: if_icmplt -> 473
    //   449: iload #21
    //   451: sipush #215
    //   454: if_icmpeq -> 473
    //   457: iload #9
    //   459: istore #12
    //   461: iload #18
    //   463: istore #26
    //   465: iload #21
    //   467: sipush #247
    //   470: if_icmpne -> 483
    //   473: iload #18
    //   475: iconst_1
    //   476: iadd
    //   477: istore #26
    //   479: iload #9
    //   481: istore #12
    //   483: iload #7
    //   485: istore #11
    //   487: iload #5
    //   489: istore #15
    //   491: iload #10
    //   493: istore #16
    //   495: iload #13
    //   497: istore #18
    //   499: iload #17
    //   501: istore #27
    //   503: iload #19
    //   505: istore #28
    //   507: iload #20
    //   509: istore #29
    //   511: iload #10
    //   513: ifeq -> 777
    //   516: iload #13
    //   518: ifle -> 609
    //   521: iload #21
    //   523: bipush #64
    //   525: if_icmplt -> 579
    //   528: iload #21
    //   530: bipush #127
    //   532: if_icmpeq -> 579
    //   535: iload #21
    //   537: sipush #252
    //   540: if_icmple -> 546
    //   543: goto -> 579
    //   546: iload #13
    //   548: iconst_1
    //   549: isub
    //   550: istore #18
    //   552: iload #7
    //   554: istore #11
    //   556: iload #5
    //   558: istore #15
    //   560: iload #10
    //   562: istore #16
    //   564: iload #17
    //   566: istore #27
    //   568: iload #19
    //   570: istore #28
    //   572: iload #20
    //   574: istore #29
    //   576: goto -> 777
    //   579: iconst_0
    //   580: istore #16
    //   582: iload #7
    //   584: istore #11
    //   586: iload #5
    //   588: istore #15
    //   590: iload #13
    //   592: istore #18
    //   594: iload #17
    //   596: istore #27
    //   598: iload #19
    //   600: istore #28
    //   602: iload #20
    //   604: istore #29
    //   606: goto -> 777
    //   609: iload #21
    //   611: sipush #128
    //   614: if_icmpeq -> 579
    //   617: iload #21
    //   619: sipush #160
    //   622: if_icmpeq -> 579
    //   625: iload #21
    //   627: sipush #239
    //   630: if_icmple -> 636
    //   633: goto -> 579
    //   636: iload #21
    //   638: sipush #160
    //   641: if_icmple -> 708
    //   644: iload #21
    //   646: sipush #224
    //   649: if_icmpge -> 708
    //   652: iload #7
    //   654: iconst_1
    //   655: iadd
    //   656: istore #11
    //   658: iload #19
    //   660: iconst_1
    //   661: iadd
    //   662: istore #7
    //   664: iload #7
    //   666: iload #17
    //   668: if_icmple -> 682
    //   671: iload #7
    //   673: istore #17
    //   675: iload #17
    //   677: istore #7
    //   679: goto -> 682
    //   682: iconst_0
    //   683: istore #29
    //   685: iload #5
    //   687: istore #15
    //   689: iload #10
    //   691: istore #16
    //   693: iload #13
    //   695: istore #18
    //   697: iload #17
    //   699: istore #27
    //   701: iload #7
    //   703: istore #28
    //   705: goto -> 777
    //   708: iload #21
    //   710: bipush #127
    //   712: if_icmple -> 763
    //   715: iload #13
    //   717: iconst_1
    //   718: iadd
    //   719: istore #18
    //   721: iload #20
    //   723: iconst_1
    //   724: iadd
    //   725: istore #29
    //   727: iload #29
    //   729: iload #5
    //   731: if_icmple -> 741
    //   734: iload #29
    //   736: istore #5
    //   738: goto -> 741
    //   741: iconst_0
    //   742: istore #28
    //   744: iload #7
    //   746: istore #11
    //   748: iload #5
    //   750: istore #15
    //   752: iload #10
    //   754: istore #16
    //   756: iload #17
    //   758: istore #27
    //   760: goto -> 777
    //   763: iconst_0
    //   764: istore #28
    //   766: iload #7
    //   768: istore #11
    //   770: iload #28
    //   772: istore #7
    //   774: goto -> 682
    //   777: iinc #8, 1
    //   780: iload #11
    //   782: istore #7
    //   784: iload #15
    //   786: istore #5
    //   788: iload #12
    //   790: istore #9
    //   792: iload #16
    //   794: istore #10
    //   796: iload #22
    //   798: istore #11
    //   800: iload #4
    //   802: istore #12
    //   804: iload #18
    //   806: istore #13
    //   808: iload #23
    //   810: istore #14
    //   812: iload #24
    //   814: istore #15
    //   816: iload #25
    //   818: istore #16
    //   820: iload #27
    //   822: istore #17
    //   824: iload #26
    //   826: istore #18
    //   828: iload #28
    //   830: istore #19
    //   832: iload #29
    //   834: istore #20
    //   836: goto -> 122
    //   839: iload #11
    //   841: istore #4
    //   843: iload #11
    //   845: ifeq -> 860
    //   848: iload #11
    //   850: istore #4
    //   852: iload #12
    //   854: ifle -> 860
    //   857: iconst_0
    //   858: istore #4
    //   860: iload #10
    //   862: ifeq -> 876
    //   865: iload #13
    //   867: ifle -> 876
    //   870: iconst_0
    //   871: istore #10
    //   873: goto -> 876
    //   876: iload #4
    //   878: ifeq -> 900
    //   881: iload #6
    //   883: ifne -> 897
    //   886: iload #14
    //   888: iload #15
    //   890: iadd
    //   891: iload #16
    //   893: iadd
    //   894: ifle -> 900
    //   897: ldc 'UTF8'
    //   899: areturn
    //   900: iload #10
    //   902: ifeq -> 926
    //   905: getstatic com/google/zxing/common/StringUtils.ASSUME_SHIFT_JIS : Z
    //   908: ifne -> 923
    //   911: iload #17
    //   913: iconst_3
    //   914: if_icmpge -> 923
    //   917: iload #5
    //   919: iconst_3
    //   920: if_icmplt -> 926
    //   923: ldc 'SJIS'
    //   925: areturn
    //   926: iload #9
    //   928: ifeq -> 963
    //   931: iload #10
    //   933: ifeq -> 963
    //   936: iload #17
    //   938: iconst_2
    //   939: if_icmpne -> 948
    //   942: iload #7
    //   944: iconst_2
    //   945: if_icmpeq -> 957
    //   948: iload #18
    //   950: bipush #10
    //   952: imul
    //   953: iload_3
    //   954: if_icmplt -> 960
    //   957: ldc 'SJIS'
    //   959: areturn
    //   960: ldc 'ISO8859_1'
    //   962: areturn
    //   963: iload #9
    //   965: ifeq -> 971
    //   968: ldc 'ISO8859_1'
    //   970: areturn
    //   971: iload #10
    //   973: ifeq -> 979
    //   976: ldc 'SJIS'
    //   978: areturn
    //   979: iload #4
    //   981: ifeq -> 987
    //   984: ldc 'UTF8'
    //   986: areturn
    //   987: getstatic com/google/zxing/common/StringUtils.PLATFORM_DEFAULT_ENCODING : Ljava/lang/String;
    //   990: areturn
  }
  
  static {
    boolean bool;
  }
  
  private static final boolean ASSUME_SHIFT_JIS;
  
  private static final String EUC_JP = "EUC_JP";
  
  public static final String GB2312 = "GB2312";
  
  private static final String ISO88591 = "ISO8859_1";
  
  private static final String PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
  
  public static final String SHIFT_JIS = "SJIS";
  
  private static final String UTF8 = "UTF8";
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */