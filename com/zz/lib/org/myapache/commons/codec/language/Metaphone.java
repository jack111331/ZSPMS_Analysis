package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;

public class Metaphone implements StringEncoder {
  private static final String FRONTV = "EIY";
  
  private static final String VARSON = "CSPTG";
  
  private static final String VOWELS = "AEIOU";
  
  private int maxCodeLen = 4;
  
  private boolean isLastChar(int paramInt1, int paramInt2) {
    return (paramInt2 + 1 == paramInt1);
  }
  
  private boolean isNextChar(StringBuffer paramStringBuffer, int paramInt, char paramChar) {
    boolean bool = false;
    null = bool;
    if (paramInt >= 0) {
      null = bool;
      if (paramInt < paramStringBuffer.length() - 1) {
        if (paramStringBuffer.charAt(paramInt + 1) == paramChar)
          return true; 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return false;
  }
  
  private boolean isPreviousChar(StringBuffer paramStringBuffer, int paramInt, char paramChar) {
    boolean bool = false;
    null = bool;
    if (paramInt > 0) {
      null = bool;
      if (paramInt < paramStringBuffer.length()) {
        if (paramStringBuffer.charAt(paramInt - 1) == paramChar)
          return true; 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return false;
  }
  
  private boolean isVowel(StringBuffer paramStringBuffer, int paramInt) {
    return ("AEIOU".indexOf(paramStringBuffer.charAt(paramInt)) >= 0);
  }
  
  private boolean regionMatch(StringBuffer paramStringBuffer, int paramInt, String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramInt >= 0) {
      bool2 = bool1;
      if (paramString.length() + paramInt - 1 < paramStringBuffer.length())
        bool2 = paramStringBuffer.substring(paramInt, paramString.length() + paramInt).equals(paramString); 
    } 
    return bool2;
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String"); 
    return metaphone((String)paramObject);
  }
  
  public String encode(String paramString) {
    return metaphone(paramString);
  }
  
  public int getMaxCodeLen() {
    return this.maxCodeLen;
  }
  
  public boolean isMetaphoneEqual(String paramString1, String paramString2) {
    return metaphone(paramString1).equals(metaphone(paramString2));
  }
  
  public String metaphone(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 11
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifne -> 16
    //   11: ldc ''
    //   13: astore_1
    //   14: aload_1
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual length : ()I
    //   20: iconst_1
    //   21: if_icmpne -> 35
    //   24: aload_1
    //   25: getstatic java/util/Locale.ENGLISH : Ljava/util/Locale;
    //   28: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   31: astore_1
    //   32: goto -> 14
    //   35: aload_1
    //   36: getstatic java/util/Locale.ENGLISH : Ljava/util/Locale;
    //   39: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   42: invokevirtual toCharArray : ()[C
    //   45: astore_1
    //   46: new java/lang/StringBuffer
    //   49: dup
    //   50: bipush #40
    //   52: invokespecial <init> : (I)V
    //   55: astore_2
    //   56: new java/lang/StringBuffer
    //   59: dup
    //   60: bipush #10
    //   62: invokespecial <init> : (I)V
    //   65: astore_3
    //   66: aload_1
    //   67: iconst_0
    //   68: caload
    //   69: lookupswitch default -> 128, 65 -> 200, 71 -> 169, 75 -> 169, 80 -> 169, 87 -> 231, 88 -> 291
    //   128: aload_2
    //   129: aload_1
    //   130: invokevirtual append : ([C)Ljava/lang/StringBuffer;
    //   133: pop
    //   134: aload_2
    //   135: invokevirtual length : ()I
    //   138: istore #4
    //   140: iconst_0
    //   141: istore #5
    //   143: aload_3
    //   144: invokevirtual length : ()I
    //   147: aload_0
    //   148: invokevirtual getMaxCodeLen : ()I
    //   151: if_icmpge -> 161
    //   154: iload #5
    //   156: iload #4
    //   158: if_icmplt -> 306
    //   161: aload_3
    //   162: invokevirtual toString : ()Ljava/lang/String;
    //   165: astore_1
    //   166: goto -> 14
    //   169: aload_1
    //   170: iconst_1
    //   171: caload
    //   172: bipush #78
    //   174: if_icmpne -> 191
    //   177: aload_2
    //   178: aload_1
    //   179: iconst_1
    //   180: aload_1
    //   181: arraylength
    //   182: iconst_1
    //   183: isub
    //   184: invokevirtual append : ([CII)Ljava/lang/StringBuffer;
    //   187: pop
    //   188: goto -> 134
    //   191: aload_2
    //   192: aload_1
    //   193: invokevirtual append : ([C)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: goto -> 134
    //   200: aload_1
    //   201: iconst_1
    //   202: caload
    //   203: bipush #69
    //   205: if_icmpne -> 222
    //   208: aload_2
    //   209: aload_1
    //   210: iconst_1
    //   211: aload_1
    //   212: arraylength
    //   213: iconst_1
    //   214: isub
    //   215: invokevirtual append : ([CII)Ljava/lang/StringBuffer;
    //   218: pop
    //   219: goto -> 134
    //   222: aload_2
    //   223: aload_1
    //   224: invokevirtual append : ([C)Ljava/lang/StringBuffer;
    //   227: pop
    //   228: goto -> 134
    //   231: aload_1
    //   232: iconst_1
    //   233: caload
    //   234: bipush #82
    //   236: if_icmpne -> 253
    //   239: aload_2
    //   240: aload_1
    //   241: iconst_1
    //   242: aload_1
    //   243: arraylength
    //   244: iconst_1
    //   245: isub
    //   246: invokevirtual append : ([CII)Ljava/lang/StringBuffer;
    //   249: pop
    //   250: goto -> 134
    //   253: aload_1
    //   254: iconst_1
    //   255: caload
    //   256: bipush #72
    //   258: if_icmpne -> 282
    //   261: aload_2
    //   262: aload_1
    //   263: iconst_1
    //   264: aload_1
    //   265: arraylength
    //   266: iconst_1
    //   267: isub
    //   268: invokevirtual append : ([CII)Ljava/lang/StringBuffer;
    //   271: pop
    //   272: aload_2
    //   273: iconst_0
    //   274: bipush #87
    //   276: invokevirtual setCharAt : (IC)V
    //   279: goto -> 134
    //   282: aload_2
    //   283: aload_1
    //   284: invokevirtual append : ([C)Ljava/lang/StringBuffer;
    //   287: pop
    //   288: goto -> 134
    //   291: aload_1
    //   292: iconst_0
    //   293: bipush #83
    //   295: i2c
    //   296: castore
    //   297: aload_2
    //   298: aload_1
    //   299: invokevirtual append : ([C)Ljava/lang/StringBuffer;
    //   302: pop
    //   303: goto -> 134
    //   306: aload_2
    //   307: iload #5
    //   309: invokevirtual charAt : (I)C
    //   312: istore #6
    //   314: iload #6
    //   316: bipush #67
    //   318: if_icmpeq -> 369
    //   321: aload_0
    //   322: aload_2
    //   323: iload #5
    //   325: iload #6
    //   327: invokespecial isPreviousChar : (Ljava/lang/StringBuffer;IC)Z
    //   330: ifeq -> 369
    //   333: iload #5
    //   335: iconst_1
    //   336: iadd
    //   337: istore #7
    //   339: iload #7
    //   341: istore #5
    //   343: aload_3
    //   344: invokevirtual length : ()I
    //   347: aload_0
    //   348: invokevirtual getMaxCodeLen : ()I
    //   351: if_icmple -> 143
    //   354: aload_3
    //   355: aload_0
    //   356: invokevirtual getMaxCodeLen : ()I
    //   359: invokevirtual setLength : (I)V
    //   362: iload #7
    //   364: istore #5
    //   366: goto -> 143
    //   369: iload #6
    //   371: tableswitch default -> 488, 65 -> 498, 66 -> 521, 67 -> 562, 68 -> 784, 69 -> 498, 70 -> 1113, 71 -> 855, 72 -> 1043, 73 -> 498, 74 -> 1113, 75 -> 1127, 76 -> 1113, 77 -> 1113, 78 -> 1113, 79 -> 498, 80 -> 1176, 81 -> 1216, 82 -> 1113, 83 -> 1230, 84 -> 1294, 85 -> 498, 86 -> 1388, 87 -> 1402, 88 -> 1447, 89 -> 1402, 90 -> 1468
    //   488: iload #5
    //   490: istore #7
    //   492: iinc #7, 1
    //   495: goto -> 339
    //   498: iload #5
    //   500: istore #7
    //   502: iload #5
    //   504: ifne -> 492
    //   507: aload_3
    //   508: iload #6
    //   510: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   513: pop
    //   514: iload #5
    //   516: istore #7
    //   518: goto -> 492
    //   521: aload_0
    //   522: aload_2
    //   523: iload #5
    //   525: bipush #77
    //   527: invokespecial isPreviousChar : (Ljava/lang/StringBuffer;IC)Z
    //   530: ifeq -> 548
    //   533: iload #5
    //   535: istore #7
    //   537: aload_0
    //   538: iload #4
    //   540: iload #5
    //   542: invokespecial isLastChar : (II)Z
    //   545: ifne -> 492
    //   548: aload_3
    //   549: iload #6
    //   551: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   554: pop
    //   555: iload #5
    //   557: istore #7
    //   559: goto -> 492
    //   562: aload_0
    //   563: aload_2
    //   564: iload #5
    //   566: bipush #83
    //   568: invokespecial isPreviousChar : (Ljava/lang/StringBuffer;IC)Z
    //   571: ifeq -> 605
    //   574: aload_0
    //   575: iload #4
    //   577: iload #5
    //   579: invokespecial isLastChar : (II)Z
    //   582: ifne -> 605
    //   585: iload #5
    //   587: istore #7
    //   589: ldc 'EIY'
    //   591: aload_2
    //   592: iload #5
    //   594: iconst_1
    //   595: iadd
    //   596: invokevirtual charAt : (I)C
    //   599: invokevirtual indexOf : (I)I
    //   602: ifge -> 492
    //   605: aload_0
    //   606: aload_2
    //   607: iload #5
    //   609: ldc 'CIA'
    //   611: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   614: ifeq -> 631
    //   617: aload_3
    //   618: bipush #88
    //   620: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   623: pop
    //   624: iload #5
    //   626: istore #7
    //   628: goto -> 492
    //   631: aload_0
    //   632: iload #4
    //   634: iload #5
    //   636: invokespecial isLastChar : (II)Z
    //   639: ifne -> 672
    //   642: ldc 'EIY'
    //   644: aload_2
    //   645: iload #5
    //   647: iconst_1
    //   648: iadd
    //   649: invokevirtual charAt : (I)C
    //   652: invokevirtual indexOf : (I)I
    //   655: iflt -> 672
    //   658: aload_3
    //   659: bipush #83
    //   661: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   664: pop
    //   665: iload #5
    //   667: istore #7
    //   669: goto -> 492
    //   672: aload_0
    //   673: aload_2
    //   674: iload #5
    //   676: bipush #83
    //   678: invokespecial isPreviousChar : (Ljava/lang/StringBuffer;IC)Z
    //   681: ifeq -> 710
    //   684: aload_0
    //   685: aload_2
    //   686: iload #5
    //   688: bipush #72
    //   690: invokespecial isNextChar : (Ljava/lang/StringBuffer;IC)Z
    //   693: ifeq -> 710
    //   696: aload_3
    //   697: bipush #75
    //   699: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   702: pop
    //   703: iload #5
    //   705: istore #7
    //   707: goto -> 492
    //   710: aload_0
    //   711: aload_2
    //   712: iload #5
    //   714: bipush #72
    //   716: invokespecial isNextChar : (Ljava/lang/StringBuffer;IC)Z
    //   719: ifeq -> 770
    //   722: iload #5
    //   724: ifne -> 756
    //   727: iload #4
    //   729: iconst_3
    //   730: if_icmplt -> 756
    //   733: aload_0
    //   734: aload_2
    //   735: iconst_2
    //   736: invokespecial isVowel : (Ljava/lang/StringBuffer;I)Z
    //   739: ifeq -> 756
    //   742: aload_3
    //   743: bipush #75
    //   745: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   748: pop
    //   749: iload #5
    //   751: istore #7
    //   753: goto -> 492
    //   756: aload_3
    //   757: bipush #88
    //   759: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   762: pop
    //   763: iload #5
    //   765: istore #7
    //   767: goto -> 492
    //   770: aload_3
    //   771: bipush #75
    //   773: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   776: pop
    //   777: iload #5
    //   779: istore #7
    //   781: goto -> 492
    //   784: aload_0
    //   785: iload #4
    //   787: iload #5
    //   789: iconst_1
    //   790: iadd
    //   791: invokespecial isLastChar : (II)Z
    //   794: ifne -> 841
    //   797: aload_0
    //   798: aload_2
    //   799: iload #5
    //   801: bipush #71
    //   803: invokespecial isNextChar : (Ljava/lang/StringBuffer;IC)Z
    //   806: ifeq -> 841
    //   809: ldc 'EIY'
    //   811: aload_2
    //   812: iload #5
    //   814: iconst_2
    //   815: iadd
    //   816: invokevirtual charAt : (I)C
    //   819: invokevirtual indexOf : (I)I
    //   822: iflt -> 841
    //   825: aload_3
    //   826: bipush #74
    //   828: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   831: pop
    //   832: iload #5
    //   834: iconst_2
    //   835: iadd
    //   836: istore #7
    //   838: goto -> 492
    //   841: aload_3
    //   842: bipush #84
    //   844: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   847: pop
    //   848: iload #5
    //   850: istore #7
    //   852: goto -> 492
    //   855: aload_0
    //   856: iload #4
    //   858: iload #5
    //   860: iconst_1
    //   861: iadd
    //   862: invokespecial isLastChar : (II)Z
    //   865: ifeq -> 884
    //   868: iload #5
    //   870: istore #7
    //   872: aload_0
    //   873: aload_2
    //   874: iload #5
    //   876: bipush #72
    //   878: invokespecial isNextChar : (Ljava/lang/StringBuffer;IC)Z
    //   881: ifne -> 492
    //   884: aload_0
    //   885: iload #4
    //   887: iload #5
    //   889: iconst_1
    //   890: iadd
    //   891: invokespecial isLastChar : (II)Z
    //   894: ifne -> 925
    //   897: aload_0
    //   898: aload_2
    //   899: iload #5
    //   901: bipush #72
    //   903: invokespecial isNextChar : (Ljava/lang/StringBuffer;IC)Z
    //   906: ifeq -> 925
    //   909: iload #5
    //   911: istore #7
    //   913: aload_0
    //   914: aload_2
    //   915: iload #5
    //   917: iconst_2
    //   918: iadd
    //   919: invokespecial isVowel : (Ljava/lang/StringBuffer;I)Z
    //   922: ifeq -> 492
    //   925: iload #5
    //   927: ifle -> 962
    //   930: iload #5
    //   932: istore #7
    //   934: aload_0
    //   935: aload_2
    //   936: iload #5
    //   938: ldc 'GN'
    //   940: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   943: ifne -> 492
    //   946: iload #5
    //   948: istore #7
    //   950: aload_0
    //   951: aload_2
    //   952: iload #5
    //   954: ldc 'GNED'
    //   956: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   959: ifne -> 492
    //   962: aload_0
    //   963: aload_2
    //   964: iload #5
    //   966: bipush #71
    //   968: invokespecial isPreviousChar : (Ljava/lang/StringBuffer;IC)Z
    //   971: ifeq -> 1023
    //   974: iconst_1
    //   975: istore #7
    //   977: aload_0
    //   978: iload #4
    //   980: iload #5
    //   982: invokespecial isLastChar : (II)Z
    //   985: ifne -> 1029
    //   988: ldc 'EIY'
    //   990: aload_2
    //   991: iload #5
    //   993: iconst_1
    //   994: iadd
    //   995: invokevirtual charAt : (I)C
    //   998: invokevirtual indexOf : (I)I
    //   1001: iflt -> 1029
    //   1004: iload #7
    //   1006: ifne -> 1029
    //   1009: aload_3
    //   1010: bipush #74
    //   1012: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1015: pop
    //   1016: iload #5
    //   1018: istore #7
    //   1020: goto -> 492
    //   1023: iconst_0
    //   1024: istore #7
    //   1026: goto -> 977
    //   1029: aload_3
    //   1030: bipush #75
    //   1032: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1035: pop
    //   1036: iload #5
    //   1038: istore #7
    //   1040: goto -> 492
    //   1043: iload #5
    //   1045: istore #7
    //   1047: aload_0
    //   1048: iload #4
    //   1050: iload #5
    //   1052: invokespecial isLastChar : (II)Z
    //   1055: ifne -> 492
    //   1058: iload #5
    //   1060: ifle -> 1083
    //   1063: iload #5
    //   1065: istore #7
    //   1067: ldc 'CSPTG'
    //   1069: aload_2
    //   1070: iload #5
    //   1072: iconst_1
    //   1073: isub
    //   1074: invokevirtual charAt : (I)C
    //   1077: invokevirtual indexOf : (I)I
    //   1080: ifge -> 492
    //   1083: iload #5
    //   1085: istore #7
    //   1087: aload_0
    //   1088: aload_2
    //   1089: iload #5
    //   1091: iconst_1
    //   1092: iadd
    //   1093: invokespecial isVowel : (Ljava/lang/StringBuffer;I)Z
    //   1096: ifeq -> 492
    //   1099: aload_3
    //   1100: bipush #72
    //   1102: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1105: pop
    //   1106: iload #5
    //   1108: istore #7
    //   1110: goto -> 492
    //   1113: aload_3
    //   1114: iload #6
    //   1116: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1119: pop
    //   1120: iload #5
    //   1122: istore #7
    //   1124: goto -> 492
    //   1127: iload #5
    //   1129: ifle -> 1162
    //   1132: iload #5
    //   1134: istore #7
    //   1136: aload_0
    //   1137: aload_2
    //   1138: iload #5
    //   1140: bipush #67
    //   1142: invokespecial isPreviousChar : (Ljava/lang/StringBuffer;IC)Z
    //   1145: ifne -> 492
    //   1148: aload_3
    //   1149: iload #6
    //   1151: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1154: pop
    //   1155: iload #5
    //   1157: istore #7
    //   1159: goto -> 492
    //   1162: aload_3
    //   1163: iload #6
    //   1165: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1168: pop
    //   1169: iload #5
    //   1171: istore #7
    //   1173: goto -> 492
    //   1176: aload_0
    //   1177: aload_2
    //   1178: iload #5
    //   1180: bipush #72
    //   1182: invokespecial isNextChar : (Ljava/lang/StringBuffer;IC)Z
    //   1185: ifeq -> 1202
    //   1188: aload_3
    //   1189: bipush #70
    //   1191: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1194: pop
    //   1195: iload #5
    //   1197: istore #7
    //   1199: goto -> 492
    //   1202: aload_3
    //   1203: iload #6
    //   1205: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1208: pop
    //   1209: iload #5
    //   1211: istore #7
    //   1213: goto -> 492
    //   1216: aload_3
    //   1217: bipush #75
    //   1219: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1222: pop
    //   1223: iload #5
    //   1225: istore #7
    //   1227: goto -> 492
    //   1230: aload_0
    //   1231: aload_2
    //   1232: iload #5
    //   1234: ldc 'SH'
    //   1236: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1239: ifne -> 1266
    //   1242: aload_0
    //   1243: aload_2
    //   1244: iload #5
    //   1246: ldc 'SIO'
    //   1248: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1251: ifne -> 1266
    //   1254: aload_0
    //   1255: aload_2
    //   1256: iload #5
    //   1258: ldc 'SIA'
    //   1260: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1263: ifeq -> 1280
    //   1266: aload_3
    //   1267: bipush #88
    //   1269: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1272: pop
    //   1273: iload #5
    //   1275: istore #7
    //   1277: goto -> 492
    //   1280: aload_3
    //   1281: bipush #83
    //   1283: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1286: pop
    //   1287: iload #5
    //   1289: istore #7
    //   1291: goto -> 492
    //   1294: aload_0
    //   1295: aload_2
    //   1296: iload #5
    //   1298: ldc 'TIA'
    //   1300: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1303: ifne -> 1318
    //   1306: aload_0
    //   1307: aload_2
    //   1308: iload #5
    //   1310: ldc 'TIO'
    //   1312: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1315: ifeq -> 1332
    //   1318: aload_3
    //   1319: bipush #88
    //   1321: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1324: pop
    //   1325: iload #5
    //   1327: istore #7
    //   1329: goto -> 492
    //   1332: iload #5
    //   1334: istore #7
    //   1336: aload_0
    //   1337: aload_2
    //   1338: iload #5
    //   1340: ldc 'TCH'
    //   1342: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1345: ifne -> 492
    //   1348: aload_0
    //   1349: aload_2
    //   1350: iload #5
    //   1352: ldc 'TH'
    //   1354: invokespecial regionMatch : (Ljava/lang/StringBuffer;ILjava/lang/String;)Z
    //   1357: ifeq -> 1374
    //   1360: aload_3
    //   1361: bipush #48
    //   1363: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1366: pop
    //   1367: iload #5
    //   1369: istore #7
    //   1371: goto -> 492
    //   1374: aload_3
    //   1375: bipush #84
    //   1377: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1380: pop
    //   1381: iload #5
    //   1383: istore #7
    //   1385: goto -> 492
    //   1388: aload_3
    //   1389: bipush #70
    //   1391: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1394: pop
    //   1395: iload #5
    //   1397: istore #7
    //   1399: goto -> 492
    //   1402: iload #5
    //   1404: istore #7
    //   1406: aload_0
    //   1407: iload #4
    //   1409: iload #5
    //   1411: invokespecial isLastChar : (II)Z
    //   1414: ifne -> 492
    //   1417: iload #5
    //   1419: istore #7
    //   1421: aload_0
    //   1422: aload_2
    //   1423: iload #5
    //   1425: iconst_1
    //   1426: iadd
    //   1427: invokespecial isVowel : (Ljava/lang/StringBuffer;I)Z
    //   1430: ifeq -> 492
    //   1433: aload_3
    //   1434: iload #6
    //   1436: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1439: pop
    //   1440: iload #5
    //   1442: istore #7
    //   1444: goto -> 492
    //   1447: aload_3
    //   1448: bipush #75
    //   1450: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1453: pop
    //   1454: aload_3
    //   1455: bipush #83
    //   1457: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1460: pop
    //   1461: iload #5
    //   1463: istore #7
    //   1465: goto -> 492
    //   1468: aload_3
    //   1469: bipush #83
    //   1471: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   1474: pop
    //   1475: iload #5
    //   1477: istore #7
    //   1479: goto -> 492
  }
  
  public void setMaxCodeLen(int paramInt) {
    this.maxCodeLen = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\Metaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */