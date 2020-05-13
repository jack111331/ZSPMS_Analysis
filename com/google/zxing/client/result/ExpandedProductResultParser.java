package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class ExpandedProductResultParser extends ResultParser {
  private static String findAIvalue(int paramInt, String paramString) {
    if (paramString.charAt(paramInt) != '(')
      return null; 
    paramString = paramString.substring(paramInt + 1);
    StringBuilder stringBuilder = new StringBuilder();
    for (paramInt = 0; paramInt < paramString.length(); paramInt++) {
      char c = paramString.charAt(paramInt);
      if (c == ')')
        return stringBuilder.toString(); 
      if (c < '0' || c > '9')
        return null; 
      stringBuilder.append(c);
    } 
    return stringBuilder.toString();
  }
  
  private static String findValue(int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    paramString = paramString.substring(paramInt);
    for (paramInt = 0; paramInt < paramString.length(); paramInt++) {
      char c = paramString.charAt(paramInt);
      if (c == '(') {
        if (findAIvalue(paramInt, paramString) == null) {
          stringBuilder.append('(');
        } else {
          break;
        } 
      } else {
        stringBuilder.append(c);
      } 
    } 
    return stringBuilder.toString();
  }
  
  public ExpandedProductParsedResult parse(Result paramResult) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getBarcodeFormat : ()Lcom/google/zxing/BarcodeFormat;
    //   4: getstatic com/google/zxing/BarcodeFormat.RSS_EXPANDED : Lcom/google/zxing/BarcodeFormat;
    //   7: if_acmpeq -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_1
    //   13: invokestatic getMassagedText : (Lcom/google/zxing/Result;)Ljava/lang/String;
    //   16: astore_2
    //   17: new java/util/HashMap
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore_3
    //   25: aconst_null
    //   26: astore #4
    //   28: aload #4
    //   30: astore #5
    //   32: aload #5
    //   34: astore #6
    //   36: aload #6
    //   38: astore #7
    //   40: aload #7
    //   42: astore #8
    //   44: aload #8
    //   46: astore #9
    //   48: aload #9
    //   50: astore #10
    //   52: aload #10
    //   54: astore_1
    //   55: aload_1
    //   56: astore #11
    //   58: aload #11
    //   60: astore #12
    //   62: aload #12
    //   64: astore #13
    //   66: aload #13
    //   68: astore #14
    //   70: aload #14
    //   72: astore #15
    //   74: iconst_0
    //   75: istore #16
    //   77: aload #11
    //   79: astore #17
    //   81: aload_1
    //   82: astore #18
    //   84: aload #4
    //   86: astore #11
    //   88: iload #16
    //   90: aload_2
    //   91: invokevirtual length : ()I
    //   94: if_icmpge -> 1297
    //   97: iload #16
    //   99: aload_2
    //   100: invokestatic findAIvalue : (ILjava/lang/String;)Ljava/lang/String;
    //   103: astore #4
    //   105: aload #4
    //   107: ifnonnull -> 112
    //   110: aconst_null
    //   111: areturn
    //   112: iload #16
    //   114: aload #4
    //   116: invokevirtual length : ()I
    //   119: iconst_2
    //   120: iadd
    //   121: iadd
    //   122: istore #16
    //   124: iload #16
    //   126: aload_2
    //   127: invokestatic findValue : (ILjava/lang/String;)Ljava/lang/String;
    //   130: astore_1
    //   131: iload #16
    //   133: aload_1
    //   134: invokevirtual length : ()I
    //   137: iadd
    //   138: istore #19
    //   140: aload #4
    //   142: invokevirtual hashCode : ()I
    //   145: istore #16
    //   147: iload #16
    //   149: sipush #1570
    //   152: if_icmpeq -> 972
    //   155: iload #16
    //   157: sipush #1572
    //   160: if_icmpeq -> 956
    //   163: iload #16
    //   165: sipush #1574
    //   168: if_icmpeq -> 939
    //   171: iload #16
    //   173: tableswitch default -> 196, 1536 -> 923, 1537 -> 907
    //   196: iload #16
    //   198: tableswitch default -> 220, 1567 -> 891, 1568 -> 875
    //   220: iload #16
    //   222: tableswitch default -> 276, 1567966 -> 858, 1567967 -> 841, 1567968 -> 824, 1567969 -> 807, 1567970 -> 790, 1567971 -> 773, 1567972 -> 756, 1567973 -> 739, 1567974 -> 722, 1567975 -> 705
    //   276: iload #16
    //   278: tableswitch default -> 332, 1568927 -> 688, 1568928 -> 671, 1568929 -> 654, 1568930 -> 637, 1568931 -> 620, 1568932 -> 603, 1568933 -> 586, 1568934 -> 569, 1568935 -> 552, 1568936 -> 535
    //   332: iload #16
    //   334: tableswitch default -> 364, 1575716 -> 518, 1575717 -> 501, 1575718 -> 484, 1575719 -> 467
    //   364: iload #16
    //   366: tableswitch default -> 396, 1575747 -> 450, 1575748 -> 433, 1575749 -> 416, 1575750 -> 399
    //   396: goto -> 988
    //   399: aload #4
    //   401: ldc '3933'
    //   403: invokevirtual equals : (Ljava/lang/Object;)Z
    //   406: ifeq -> 988
    //   409: bipush #34
    //   411: istore #16
    //   413: goto -> 991
    //   416: aload #4
    //   418: ldc '3932'
    //   420: invokevirtual equals : (Ljava/lang/Object;)Z
    //   423: ifeq -> 988
    //   426: bipush #33
    //   428: istore #16
    //   430: goto -> 991
    //   433: aload #4
    //   435: ldc '3931'
    //   437: invokevirtual equals : (Ljava/lang/Object;)Z
    //   440: ifeq -> 988
    //   443: bipush #32
    //   445: istore #16
    //   447: goto -> 991
    //   450: aload #4
    //   452: ldc '3930'
    //   454: invokevirtual equals : (Ljava/lang/Object;)Z
    //   457: ifeq -> 988
    //   460: bipush #31
    //   462: istore #16
    //   464: goto -> 991
    //   467: aload #4
    //   469: ldc '3923'
    //   471: invokevirtual equals : (Ljava/lang/Object;)Z
    //   474: ifeq -> 988
    //   477: bipush #30
    //   479: istore #16
    //   481: goto -> 991
    //   484: aload #4
    //   486: ldc '3922'
    //   488: invokevirtual equals : (Ljava/lang/Object;)Z
    //   491: ifeq -> 988
    //   494: bipush #29
    //   496: istore #16
    //   498: goto -> 991
    //   501: aload #4
    //   503: ldc '3921'
    //   505: invokevirtual equals : (Ljava/lang/Object;)Z
    //   508: ifeq -> 988
    //   511: bipush #28
    //   513: istore #16
    //   515: goto -> 991
    //   518: aload #4
    //   520: ldc '3920'
    //   522: invokevirtual equals : (Ljava/lang/Object;)Z
    //   525: ifeq -> 988
    //   528: bipush #27
    //   530: istore #16
    //   532: goto -> 991
    //   535: aload #4
    //   537: ldc '3209'
    //   539: invokevirtual equals : (Ljava/lang/Object;)Z
    //   542: ifeq -> 988
    //   545: bipush #26
    //   547: istore #16
    //   549: goto -> 991
    //   552: aload #4
    //   554: ldc '3208'
    //   556: invokevirtual equals : (Ljava/lang/Object;)Z
    //   559: ifeq -> 988
    //   562: bipush #25
    //   564: istore #16
    //   566: goto -> 991
    //   569: aload #4
    //   571: ldc '3207'
    //   573: invokevirtual equals : (Ljava/lang/Object;)Z
    //   576: ifeq -> 988
    //   579: bipush #24
    //   581: istore #16
    //   583: goto -> 991
    //   586: aload #4
    //   588: ldc '3206'
    //   590: invokevirtual equals : (Ljava/lang/Object;)Z
    //   593: ifeq -> 988
    //   596: bipush #23
    //   598: istore #16
    //   600: goto -> 991
    //   603: aload #4
    //   605: ldc '3205'
    //   607: invokevirtual equals : (Ljava/lang/Object;)Z
    //   610: ifeq -> 988
    //   613: bipush #22
    //   615: istore #16
    //   617: goto -> 991
    //   620: aload #4
    //   622: ldc '3204'
    //   624: invokevirtual equals : (Ljava/lang/Object;)Z
    //   627: ifeq -> 988
    //   630: bipush #21
    //   632: istore #16
    //   634: goto -> 991
    //   637: aload #4
    //   639: ldc '3203'
    //   641: invokevirtual equals : (Ljava/lang/Object;)Z
    //   644: ifeq -> 988
    //   647: bipush #20
    //   649: istore #16
    //   651: goto -> 991
    //   654: aload #4
    //   656: ldc '3202'
    //   658: invokevirtual equals : (Ljava/lang/Object;)Z
    //   661: ifeq -> 988
    //   664: bipush #19
    //   666: istore #16
    //   668: goto -> 991
    //   671: aload #4
    //   673: ldc '3201'
    //   675: invokevirtual equals : (Ljava/lang/Object;)Z
    //   678: ifeq -> 988
    //   681: bipush #18
    //   683: istore #16
    //   685: goto -> 991
    //   688: aload #4
    //   690: ldc '3200'
    //   692: invokevirtual equals : (Ljava/lang/Object;)Z
    //   695: ifeq -> 988
    //   698: bipush #17
    //   700: istore #16
    //   702: goto -> 991
    //   705: aload #4
    //   707: ldc '3109'
    //   709: invokevirtual equals : (Ljava/lang/Object;)Z
    //   712: ifeq -> 988
    //   715: bipush #16
    //   717: istore #16
    //   719: goto -> 991
    //   722: aload #4
    //   724: ldc '3108'
    //   726: invokevirtual equals : (Ljava/lang/Object;)Z
    //   729: ifeq -> 988
    //   732: bipush #15
    //   734: istore #16
    //   736: goto -> 991
    //   739: aload #4
    //   741: ldc '3107'
    //   743: invokevirtual equals : (Ljava/lang/Object;)Z
    //   746: ifeq -> 988
    //   749: bipush #14
    //   751: istore #16
    //   753: goto -> 991
    //   756: aload #4
    //   758: ldc '3106'
    //   760: invokevirtual equals : (Ljava/lang/Object;)Z
    //   763: ifeq -> 988
    //   766: bipush #13
    //   768: istore #16
    //   770: goto -> 991
    //   773: aload #4
    //   775: ldc '3105'
    //   777: invokevirtual equals : (Ljava/lang/Object;)Z
    //   780: ifeq -> 988
    //   783: bipush #12
    //   785: istore #16
    //   787: goto -> 991
    //   790: aload #4
    //   792: ldc '3104'
    //   794: invokevirtual equals : (Ljava/lang/Object;)Z
    //   797: ifeq -> 988
    //   800: bipush #11
    //   802: istore #16
    //   804: goto -> 991
    //   807: aload #4
    //   809: ldc '3103'
    //   811: invokevirtual equals : (Ljava/lang/Object;)Z
    //   814: ifeq -> 988
    //   817: bipush #10
    //   819: istore #16
    //   821: goto -> 991
    //   824: aload #4
    //   826: ldc '3102'
    //   828: invokevirtual equals : (Ljava/lang/Object;)Z
    //   831: ifeq -> 988
    //   834: bipush #9
    //   836: istore #16
    //   838: goto -> 991
    //   841: aload #4
    //   843: ldc '3101'
    //   845: invokevirtual equals : (Ljava/lang/Object;)Z
    //   848: ifeq -> 988
    //   851: bipush #8
    //   853: istore #16
    //   855: goto -> 991
    //   858: aload #4
    //   860: ldc '3100'
    //   862: invokevirtual equals : (Ljava/lang/Object;)Z
    //   865: ifeq -> 988
    //   868: bipush #7
    //   870: istore #16
    //   872: goto -> 991
    //   875: aload #4
    //   877: ldc '11'
    //   879: invokevirtual equals : (Ljava/lang/Object;)Z
    //   882: ifeq -> 988
    //   885: iconst_3
    //   886: istore #16
    //   888: goto -> 991
    //   891: aload #4
    //   893: ldc '10'
    //   895: invokevirtual equals : (Ljava/lang/Object;)Z
    //   898: ifeq -> 988
    //   901: iconst_2
    //   902: istore #16
    //   904: goto -> 991
    //   907: aload #4
    //   909: ldc '01'
    //   911: invokevirtual equals : (Ljava/lang/Object;)Z
    //   914: ifeq -> 988
    //   917: iconst_1
    //   918: istore #16
    //   920: goto -> 991
    //   923: aload #4
    //   925: ldc '00'
    //   927: invokevirtual equals : (Ljava/lang/Object;)Z
    //   930: ifeq -> 988
    //   933: iconst_0
    //   934: istore #16
    //   936: goto -> 991
    //   939: aload #4
    //   941: ldc '17'
    //   943: invokevirtual equals : (Ljava/lang/Object;)Z
    //   946: ifeq -> 988
    //   949: bipush #6
    //   951: istore #16
    //   953: goto -> 991
    //   956: aload #4
    //   958: ldc '15'
    //   960: invokevirtual equals : (Ljava/lang/Object;)Z
    //   963: ifeq -> 988
    //   966: iconst_5
    //   967: istore #16
    //   969: goto -> 991
    //   972: aload #4
    //   974: ldc '13'
    //   976: invokevirtual equals : (Ljava/lang/Object;)Z
    //   979: ifeq -> 988
    //   982: iconst_4
    //   983: istore #16
    //   985: goto -> 991
    //   988: iconst_m1
    //   989: istore #16
    //   991: iload #16
    //   993: tableswitch default -> 1148, 0 -> 1291, 1 -> 1285, 2 -> 1279, 3 -> 1273, 4 -> 1267, 5 -> 1261, 6 -> 1255, 7 -> 1236, 8 -> 1236, 9 -> 1236, 10 -> 1236, 11 -> 1236, 12 -> 1236, 13 -> 1236, 14 -> 1236, 15 -> 1236, 16 -> 1236, 17 -> 1221, 18 -> 1221, 19 -> 1221, 20 -> 1221, 21 -> 1221, 22 -> 1221, 23 -> 1221, 24 -> 1221, 25 -> 1221, 26 -> 1221, 27 -> 1207, 28 -> 1207, 29 -> 1207, 30 -> 1207, 31 -> 1171, 32 -> 1171, 33 -> 1171, 34 -> 1171
    //   1148: aload_3
    //   1149: aload #4
    //   1151: aload_1
    //   1152: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1157: pop
    //   1158: aload #18
    //   1160: astore_1
    //   1161: iload #19
    //   1163: istore #16
    //   1165: aload_1
    //   1166: astore #18
    //   1168: goto -> 88
    //   1171: aload_1
    //   1172: invokevirtual length : ()I
    //   1175: iconst_4
    //   1176: if_icmpge -> 1181
    //   1179: aconst_null
    //   1180: areturn
    //   1181: aload_1
    //   1182: iconst_3
    //   1183: invokevirtual substring : (I)Ljava/lang/String;
    //   1186: astore #13
    //   1188: aload_1
    //   1189: iconst_0
    //   1190: iconst_3
    //   1191: invokevirtual substring : (II)Ljava/lang/String;
    //   1194: astore #15
    //   1196: aload #4
    //   1198: iconst_3
    //   1199: invokevirtual substring : (I)Ljava/lang/String;
    //   1202: astore #14
    //   1204: goto -> 1218
    //   1207: aload #4
    //   1209: iconst_3
    //   1210: invokevirtual substring : (I)Ljava/lang/String;
    //   1213: astore #14
    //   1215: aload_1
    //   1216: astore #13
    //   1218: goto -> 1158
    //   1221: ldc 'LB'
    //   1223: astore #18
    //   1225: aload #4
    //   1227: iconst_3
    //   1228: invokevirtual substring : (I)Ljava/lang/String;
    //   1231: astore #12
    //   1233: goto -> 1248
    //   1236: ldc 'KG'
    //   1238: astore #18
    //   1240: aload #4
    //   1242: iconst_3
    //   1243: invokevirtual substring : (I)Ljava/lang/String;
    //   1246: astore #12
    //   1248: aload #18
    //   1250: astore #17
    //   1252: goto -> 1161
    //   1255: aload_1
    //   1256: astore #10
    //   1258: goto -> 1158
    //   1261: aload_1
    //   1262: astore #9
    //   1264: goto -> 1158
    //   1267: aload_1
    //   1268: astore #8
    //   1270: goto -> 1158
    //   1273: aload_1
    //   1274: astore #7
    //   1276: goto -> 1158
    //   1279: aload_1
    //   1280: astore #6
    //   1282: goto -> 1158
    //   1285: aload_1
    //   1286: astore #11
    //   1288: goto -> 1158
    //   1291: aload_1
    //   1292: astore #5
    //   1294: goto -> 1158
    //   1297: new com/google/zxing/client/result/ExpandedProductParsedResult
    //   1300: dup
    //   1301: aload_2
    //   1302: aload #11
    //   1304: aload #5
    //   1306: aload #6
    //   1308: aload #7
    //   1310: aload #8
    //   1312: aload #9
    //   1314: aload #10
    //   1316: aload #18
    //   1318: aload #17
    //   1320: aload #12
    //   1322: aload #13
    //   1324: aload #14
    //   1326: aload #15
    //   1328: aload_3
    //   1329: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   1332: areturn
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ExpandedProductResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */