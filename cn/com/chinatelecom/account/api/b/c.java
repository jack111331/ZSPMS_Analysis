package cn.com.chinatelecom.account.api.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import java.net.HttpURLConnection;

public class c {
  private static final String a = c.class.getSimpleName();
  
  public static e a(Context paramContext, String paramString, Network paramNetwork) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: aconst_null
    //   9: astore #6
    //   11: aconst_null
    //   12: astore #7
    //   14: aconst_null
    //   15: astore #8
    //   17: new cn/com/chinatelecom/account/api/b/e
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #9
    //   26: aconst_null
    //   27: invokestatic getConnTimeout : (Lcn/com/chinatelecom/account/api/CtSetting;)I
    //   30: istore #10
    //   32: aconst_null
    //   33: invokestatic getReadTimeout : (Lcn/com/chinatelecom/account/api/CtSetting;)I
    //   36: istore #11
    //   38: new java/net/URL
    //   41: astore #12
    //   43: aload #12
    //   45: aload_1
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: aload_2
    //   50: ifnull -> 365
    //   53: getstatic android/os/Build$VERSION.SDK_INT : I
    //   56: bipush #21
    //   58: if_icmplt -> 365
    //   61: aload_2
    //   62: aload #12
    //   64: invokevirtual openConnection : (Ljava/net/URL;)Ljava/net/URLConnection;
    //   67: checkcast java/net/HttpURLConnection
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 'accept'
    //   74: ldc '*/*'
    //   76: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_1
    //   80: ldc 'connection'
    //   82: ldc 'Keep-Alive'
    //   84: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_1
    //   88: ldc 'GET'
    //   90: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   93: aload_1
    //   94: iconst_0
    //   95: invokevirtual setDoOutput : (Z)V
    //   98: aload_1
    //   99: iconst_1
    //   100: invokevirtual setDoInput : (Z)V
    //   103: aload_1
    //   104: iload #10
    //   106: invokevirtual setConnectTimeout : (I)V
    //   109: aload_1
    //   110: iload #11
    //   112: invokevirtual setReadTimeout : (I)V
    //   115: aload_1
    //   116: iconst_0
    //   117: invokevirtual setUseCaches : (Z)V
    //   120: aload_1
    //   121: ldc 'Accept-Charset'
    //   123: ldc 'UTF-8'
    //   125: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_1
    //   129: aload_0
    //   130: invokestatic a : (Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    //   133: aload_1
    //   134: invokevirtual connect : ()V
    //   137: aload_1
    //   138: astore #13
    //   140: aload_1
    //   141: invokevirtual getResponseCode : ()I
    //   144: sipush #302
    //   147: if_icmpne -> 258
    //   150: aload_1
    //   151: ldc 'Location'
    //   153: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   156: astore #12
    //   158: new java/net/URL
    //   161: astore_1
    //   162: aload_1
    //   163: aload #12
    //   165: invokespecial <init> : (Ljava/lang/String;)V
    //   168: aload_2
    //   169: ifnull -> 377
    //   172: getstatic android/os/Build$VERSION.SDK_INT : I
    //   175: bipush #21
    //   177: if_icmplt -> 377
    //   180: aload_2
    //   181: aload_1
    //   182: invokevirtual openConnection : (Ljava/net/URL;)Ljava/net/URLConnection;
    //   185: checkcast java/net/HttpURLConnection
    //   188: astore_1
    //   189: aload_1
    //   190: ldc 'accept'
    //   192: ldc '*/*'
    //   194: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_1
    //   198: ldc 'connection'
    //   200: ldc 'Keep-Alive'
    //   202: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_1
    //   206: ldc 'GET'
    //   208: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   211: aload_1
    //   212: iconst_0
    //   213: invokevirtual setDoOutput : (Z)V
    //   216: aload_1
    //   217: iconst_1
    //   218: invokevirtual setDoInput : (Z)V
    //   221: aload_1
    //   222: iload #10
    //   224: invokevirtual setConnectTimeout : (I)V
    //   227: aload_1
    //   228: iload #11
    //   230: invokevirtual setReadTimeout : (I)V
    //   233: aload_1
    //   234: iconst_0
    //   235: invokevirtual setUseCaches : (Z)V
    //   238: aload_1
    //   239: ldc 'Accept-Charset'
    //   241: ldc 'UTF-8'
    //   243: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_1
    //   247: aload_0
    //   248: invokestatic a : (Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    //   251: aload_1
    //   252: invokevirtual connect : ()V
    //   255: aload_1
    //   256: astore #13
    //   258: aload #13
    //   260: invokevirtual getResponseCode : ()I
    //   263: istore #11
    //   265: iload #11
    //   267: sipush #200
    //   270: if_icmpne -> 484
    //   273: aload #13
    //   275: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   278: astore_1
    //   279: new java/io/InputStreamReader
    //   282: astore_2
    //   283: aload_2
    //   284: aload_1
    //   285: invokespecial <init> : (Ljava/io/InputStream;)V
    //   288: aload #7
    //   290: astore #6
    //   292: aload_2
    //   293: astore #14
    //   295: aload_1
    //   296: astore #15
    //   298: new java/io/BufferedReader
    //   301: astore #12
    //   303: aload #7
    //   305: astore #6
    //   307: aload_2
    //   308: astore #14
    //   310: aload_1
    //   311: astore #15
    //   313: aload #12
    //   315: aload_2
    //   316: invokespecial <init> : (Ljava/io/Reader;)V
    //   319: ldc ''
    //   321: astore #15
    //   323: aload #12
    //   325: invokevirtual readLine : ()Ljava/lang/String;
    //   328: astore #14
    //   330: aload #14
    //   332: ifnull -> 388
    //   335: new java/lang/StringBuilder
    //   338: astore #6
    //   340: aload #6
    //   342: invokespecial <init> : ()V
    //   345: aload #6
    //   347: aload #15
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload #14
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual toString : ()Ljava/lang/String;
    //   360: astore #15
    //   362: goto -> 323
    //   365: aload #12
    //   367: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   370: checkcast java/net/HttpURLConnection
    //   373: astore_1
    //   374: goto -> 71
    //   377: aload_1
    //   378: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   381: checkcast java/net/HttpURLConnection
    //   384: astore_1
    //   385: goto -> 189
    //   388: aload #9
    //   390: iconst_0
    //   391: putfield a : I
    //   394: aload #9
    //   396: aload #15
    //   398: putfield b : Ljava/lang/String;
    //   401: aload_0
    //   402: aload #13
    //   404: iconst_1
    //   405: invokestatic a : (Landroid/content/Context;Ljava/net/HttpURLConnection;Z)Lcn/com/chinatelecom/account/api/b/b;
    //   408: astore #6
    //   410: aload #12
    //   412: astore_0
    //   413: aload_2
    //   414: astore #15
    //   416: aload_1
    //   417: astore #14
    //   419: aload #6
    //   421: ifnull -> 453
    //   424: aload #9
    //   426: aload #6
    //   428: getfield b : Z
    //   431: putfield c : Z
    //   434: aload #9
    //   436: aload #6
    //   438: getfield a : Ljava/lang/String;
    //   441: putfield d : Ljava/lang/String;
    //   444: aload_1
    //   445: astore #14
    //   447: aload_2
    //   448: astore #15
    //   450: aload #12
    //   452: astore_0
    //   453: aload_0
    //   454: ifnull -> 461
    //   457: aload_0
    //   458: invokevirtual close : ()V
    //   461: aload #15
    //   463: ifnull -> 471
    //   466: aload #15
    //   468: invokevirtual close : ()V
    //   471: aload #14
    //   473: ifnull -> 481
    //   476: aload #14
    //   478: invokevirtual close : ()V
    //   481: aload #9
    //   483: areturn
    //   484: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   487: astore_1
    //   488: new java/lang/StringBuilder
    //   491: astore_0
    //   492: aload_0
    //   493: invokespecial <init> : ()V
    //   496: aload_1
    //   497: aload_0
    //   498: ldc 'redirect 30002 Http response code : '
    //   500: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: iload #11
    //   505: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   508: invokevirtual toString : ()Ljava/lang/String;
    //   511: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   514: aconst_null
    //   515: astore_0
    //   516: aconst_null
    //   517: astore #15
    //   519: aconst_null
    //   520: astore #14
    //   522: goto -> 453
    //   525: astore_0
    //   526: aload_0
    //   527: invokevirtual printStackTrace : ()V
    //   530: goto -> 481
    //   533: astore_2
    //   534: aconst_null
    //   535: astore_0
    //   536: aconst_null
    //   537: astore_1
    //   538: aload #8
    //   540: astore #6
    //   542: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   545: astore #15
    //   547: new java/lang/StringBuilder
    //   550: astore #12
    //   552: aload #12
    //   554: invokespecial <init> : ()V
    //   557: aload #15
    //   559: aload #12
    //   561: ldc 'doGet SocketTimeoutException : '
    //   563: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_2
    //   567: invokevirtual getMessage : ()Ljava/lang/String;
    //   570: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual toString : ()Ljava/lang/String;
    //   576: aload_2
    //   577: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   580: aload #6
    //   582: ifnull -> 590
    //   585: aload #6
    //   587: invokevirtual close : ()V
    //   590: aload_0
    //   591: ifnull -> 598
    //   594: aload_0
    //   595: invokevirtual close : ()V
    //   598: aload_1
    //   599: ifnull -> 481
    //   602: aload_1
    //   603: invokevirtual close : ()V
    //   606: goto -> 481
    //   609: astore_0
    //   610: aload_0
    //   611: invokevirtual printStackTrace : ()V
    //   614: goto -> 481
    //   617: astore_0
    //   618: aconst_null
    //   619: astore_2
    //   620: aconst_null
    //   621: astore_1
    //   622: aload_3
    //   623: astore #12
    //   625: aload #12
    //   627: astore #6
    //   629: aload_2
    //   630: astore #14
    //   632: aload_1
    //   633: astore #15
    //   635: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   638: astore #13
    //   640: aload #12
    //   642: astore #6
    //   644: aload_2
    //   645: astore #14
    //   647: aload_1
    //   648: astore #15
    //   650: new java/lang/StringBuilder
    //   653: astore #8
    //   655: aload #12
    //   657: astore #6
    //   659: aload_2
    //   660: astore #14
    //   662: aload_1
    //   663: astore #15
    //   665: aload #8
    //   667: invokespecial <init> : ()V
    //   670: aload #12
    //   672: astore #6
    //   674: aload_2
    //   675: astore #14
    //   677: aload_1
    //   678: astore #15
    //   680: aload #13
    //   682: aload #8
    //   684: ldc 'doGet UnknownHostException : '
    //   686: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: invokevirtual getMessage : ()Ljava/lang/String;
    //   693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual toString : ()Ljava/lang/String;
    //   699: aload_0
    //   700: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   703: aload #12
    //   705: ifnull -> 713
    //   708: aload #12
    //   710: invokevirtual close : ()V
    //   713: aload_2
    //   714: ifnull -> 721
    //   717: aload_2
    //   718: invokevirtual close : ()V
    //   721: aload_1
    //   722: ifnull -> 481
    //   725: aload_1
    //   726: invokevirtual close : ()V
    //   729: goto -> 481
    //   732: astore_0
    //   733: aload_0
    //   734: invokevirtual printStackTrace : ()V
    //   737: goto -> 481
    //   740: astore_0
    //   741: aconst_null
    //   742: astore_2
    //   743: aconst_null
    //   744: astore_1
    //   745: aload #4
    //   747: astore #12
    //   749: aload #12
    //   751: astore #6
    //   753: aload_2
    //   754: astore #14
    //   756: aload_1
    //   757: astore #15
    //   759: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   762: astore #13
    //   764: aload #12
    //   766: astore #6
    //   768: aload_2
    //   769: astore #14
    //   771: aload_1
    //   772: astore #15
    //   774: new java/lang/StringBuilder
    //   777: astore #8
    //   779: aload #12
    //   781: astore #6
    //   783: aload_2
    //   784: astore #14
    //   786: aload_1
    //   787: astore #15
    //   789: aload #8
    //   791: invokespecial <init> : ()V
    //   794: aload #12
    //   796: astore #6
    //   798: aload_2
    //   799: astore #14
    //   801: aload_1
    //   802: astore #15
    //   804: aload #13
    //   806: aload #8
    //   808: ldc 'doGet IOException : '
    //   810: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_0
    //   814: invokevirtual getMessage : ()Ljava/lang/String;
    //   817: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual toString : ()Ljava/lang/String;
    //   823: aload_0
    //   824: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   827: aload #12
    //   829: ifnull -> 837
    //   832: aload #12
    //   834: invokevirtual close : ()V
    //   837: aload_2
    //   838: ifnull -> 845
    //   841: aload_2
    //   842: invokevirtual close : ()V
    //   845: aload_1
    //   846: ifnull -> 481
    //   849: aload_1
    //   850: invokevirtual close : ()V
    //   853: goto -> 481
    //   856: astore_0
    //   857: aload_0
    //   858: invokevirtual printStackTrace : ()V
    //   861: goto -> 481
    //   864: astore_0
    //   865: aconst_null
    //   866: astore_2
    //   867: aconst_null
    //   868: astore_1
    //   869: aload #5
    //   871: astore #12
    //   873: aload #12
    //   875: astore #6
    //   877: aload_2
    //   878: astore #14
    //   880: aload_1
    //   881: astore #15
    //   883: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   886: astore #13
    //   888: aload #12
    //   890: astore #6
    //   892: aload_2
    //   893: astore #14
    //   895: aload_1
    //   896: astore #15
    //   898: new java/lang/StringBuilder
    //   901: astore #8
    //   903: aload #12
    //   905: astore #6
    //   907: aload_2
    //   908: astore #14
    //   910: aload_1
    //   911: astore #15
    //   913: aload #8
    //   915: invokespecial <init> : ()V
    //   918: aload #12
    //   920: astore #6
    //   922: aload_2
    //   923: astore #14
    //   925: aload_1
    //   926: astore #15
    //   928: aload #13
    //   930: aload #8
    //   932: ldc 'doGet Throwable : '
    //   934: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: aload_0
    //   938: invokevirtual getMessage : ()Ljava/lang/String;
    //   941: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual toString : ()Ljava/lang/String;
    //   947: aload_0
    //   948: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   951: aload #12
    //   953: ifnull -> 961
    //   956: aload #12
    //   958: invokevirtual close : ()V
    //   961: aload_2
    //   962: ifnull -> 969
    //   965: aload_2
    //   966: invokevirtual close : ()V
    //   969: aload_1
    //   970: ifnull -> 481
    //   973: aload_1
    //   974: invokevirtual close : ()V
    //   977: goto -> 481
    //   980: astore_0
    //   981: aload_0
    //   982: invokevirtual printStackTrace : ()V
    //   985: goto -> 481
    //   988: astore_0
    //   989: aconst_null
    //   990: astore_2
    //   991: aconst_null
    //   992: astore_1
    //   993: aload #6
    //   995: ifnull -> 1003
    //   998: aload #6
    //   1000: invokevirtual close : ()V
    //   1003: aload_2
    //   1004: ifnull -> 1011
    //   1007: aload_2
    //   1008: invokevirtual close : ()V
    //   1011: aload_1
    //   1012: ifnull -> 1019
    //   1015: aload_1
    //   1016: invokevirtual close : ()V
    //   1019: aload_0
    //   1020: athrow
    //   1021: astore_1
    //   1022: aload_1
    //   1023: invokevirtual printStackTrace : ()V
    //   1026: goto -> 1019
    //   1029: astore_0
    //   1030: aconst_null
    //   1031: astore_2
    //   1032: goto -> 993
    //   1035: astore_0
    //   1036: aload #14
    //   1038: astore_2
    //   1039: aload #15
    //   1041: astore_1
    //   1042: goto -> 993
    //   1045: astore_0
    //   1046: aload #12
    //   1048: astore #6
    //   1050: goto -> 993
    //   1053: astore_2
    //   1054: aload_0
    //   1055: astore #12
    //   1057: aload_2
    //   1058: astore_0
    //   1059: aload #12
    //   1061: astore_2
    //   1062: goto -> 993
    //   1065: astore_0
    //   1066: aconst_null
    //   1067: astore_2
    //   1068: aload #5
    //   1070: astore #12
    //   1072: goto -> 873
    //   1075: astore_0
    //   1076: aload #5
    //   1078: astore #12
    //   1080: goto -> 873
    //   1083: astore_0
    //   1084: goto -> 873
    //   1087: astore_0
    //   1088: aconst_null
    //   1089: astore_2
    //   1090: aload #4
    //   1092: astore #12
    //   1094: goto -> 749
    //   1097: astore_0
    //   1098: aload #4
    //   1100: astore #12
    //   1102: goto -> 749
    //   1105: astore_0
    //   1106: goto -> 749
    //   1109: astore_0
    //   1110: aconst_null
    //   1111: astore_2
    //   1112: aload_3
    //   1113: astore #12
    //   1115: goto -> 625
    //   1118: astore_0
    //   1119: aload_3
    //   1120: astore #12
    //   1122: goto -> 625
    //   1125: astore_0
    //   1126: goto -> 625
    //   1129: astore_2
    //   1130: aconst_null
    //   1131: astore_0
    //   1132: aload #8
    //   1134: astore #6
    //   1136: goto -> 542
    //   1139: astore #12
    //   1141: aload_2
    //   1142: astore_0
    //   1143: aload #12
    //   1145: astore_2
    //   1146: aload #8
    //   1148: astore #6
    //   1150: goto -> 542
    //   1153: astore_0
    //   1154: aload_2
    //   1155: astore #15
    //   1157: aload_0
    //   1158: astore_2
    //   1159: aload #12
    //   1161: astore #6
    //   1163: aload #15
    //   1165: astore_0
    //   1166: goto -> 542
    // Exception table:
    //   from	to	target	type
    //   38	49	533	java/net/SocketTimeoutException
    //   38	49	617	java/net/UnknownHostException
    //   38	49	740	java/io/IOException
    //   38	49	864	java/lang/Throwable
    //   38	49	988	finally
    //   53	71	533	java/net/SocketTimeoutException
    //   53	71	617	java/net/UnknownHostException
    //   53	71	740	java/io/IOException
    //   53	71	864	java/lang/Throwable
    //   53	71	988	finally
    //   71	137	533	java/net/SocketTimeoutException
    //   71	137	617	java/net/UnknownHostException
    //   71	137	740	java/io/IOException
    //   71	137	864	java/lang/Throwable
    //   71	137	988	finally
    //   140	168	533	java/net/SocketTimeoutException
    //   140	168	617	java/net/UnknownHostException
    //   140	168	740	java/io/IOException
    //   140	168	864	java/lang/Throwable
    //   140	168	988	finally
    //   172	189	533	java/net/SocketTimeoutException
    //   172	189	617	java/net/UnknownHostException
    //   172	189	740	java/io/IOException
    //   172	189	864	java/lang/Throwable
    //   172	189	988	finally
    //   189	255	533	java/net/SocketTimeoutException
    //   189	255	617	java/net/UnknownHostException
    //   189	255	740	java/io/IOException
    //   189	255	864	java/lang/Throwable
    //   189	255	988	finally
    //   258	265	533	java/net/SocketTimeoutException
    //   258	265	617	java/net/UnknownHostException
    //   258	265	740	java/io/IOException
    //   258	265	864	java/lang/Throwable
    //   258	265	988	finally
    //   273	279	533	java/net/SocketTimeoutException
    //   273	279	617	java/net/UnknownHostException
    //   273	279	740	java/io/IOException
    //   273	279	864	java/lang/Throwable
    //   273	279	988	finally
    //   279	288	1129	java/net/SocketTimeoutException
    //   279	288	1109	java/net/UnknownHostException
    //   279	288	1087	java/io/IOException
    //   279	288	1065	java/lang/Throwable
    //   279	288	1029	finally
    //   298	303	1139	java/net/SocketTimeoutException
    //   298	303	1118	java/net/UnknownHostException
    //   298	303	1097	java/io/IOException
    //   298	303	1075	java/lang/Throwable
    //   298	303	1035	finally
    //   313	319	1139	java/net/SocketTimeoutException
    //   313	319	1118	java/net/UnknownHostException
    //   313	319	1097	java/io/IOException
    //   313	319	1075	java/lang/Throwable
    //   313	319	1035	finally
    //   323	330	1153	java/net/SocketTimeoutException
    //   323	330	1125	java/net/UnknownHostException
    //   323	330	1105	java/io/IOException
    //   323	330	1083	java/lang/Throwable
    //   323	330	1045	finally
    //   335	362	1153	java/net/SocketTimeoutException
    //   335	362	1125	java/net/UnknownHostException
    //   335	362	1105	java/io/IOException
    //   335	362	1083	java/lang/Throwable
    //   335	362	1045	finally
    //   365	374	533	java/net/SocketTimeoutException
    //   365	374	617	java/net/UnknownHostException
    //   365	374	740	java/io/IOException
    //   365	374	864	java/lang/Throwable
    //   365	374	988	finally
    //   377	385	533	java/net/SocketTimeoutException
    //   377	385	617	java/net/UnknownHostException
    //   377	385	740	java/io/IOException
    //   377	385	864	java/lang/Throwable
    //   377	385	988	finally
    //   388	410	1153	java/net/SocketTimeoutException
    //   388	410	1125	java/net/UnknownHostException
    //   388	410	1105	java/io/IOException
    //   388	410	1083	java/lang/Throwable
    //   388	410	1045	finally
    //   424	444	1153	java/net/SocketTimeoutException
    //   424	444	1125	java/net/UnknownHostException
    //   424	444	1105	java/io/IOException
    //   424	444	1083	java/lang/Throwable
    //   424	444	1045	finally
    //   457	461	525	java/lang/Exception
    //   466	471	525	java/lang/Exception
    //   476	481	525	java/lang/Exception
    //   484	514	533	java/net/SocketTimeoutException
    //   484	514	617	java/net/UnknownHostException
    //   484	514	740	java/io/IOException
    //   484	514	864	java/lang/Throwable
    //   484	514	988	finally
    //   542	580	1053	finally
    //   585	590	609	java/lang/Exception
    //   594	598	609	java/lang/Exception
    //   602	606	609	java/lang/Exception
    //   635	640	1035	finally
    //   650	655	1035	finally
    //   665	670	1035	finally
    //   680	703	1035	finally
    //   708	713	732	java/lang/Exception
    //   717	721	732	java/lang/Exception
    //   725	729	732	java/lang/Exception
    //   759	764	1035	finally
    //   774	779	1035	finally
    //   789	794	1035	finally
    //   804	827	1035	finally
    //   832	837	856	java/lang/Exception
    //   841	845	856	java/lang/Exception
    //   849	853	856	java/lang/Exception
    //   883	888	1035	finally
    //   898	903	1035	finally
    //   913	918	1035	finally
    //   928	951	1035	finally
    //   956	961	980	java/lang/Exception
    //   965	969	980	java/lang/Exception
    //   973	977	980	java/lang/Exception
    //   998	1003	1021	java/lang/Exception
    //   1007	1011	1021	java/lang/Exception
    //   1015	1019	1021	java/lang/Exception
  }
  
  public static e a(Context paramContext, String paramString1, String paramString2, CtSetting paramCtSetting, Network paramNetwork, boolean paramBoolean, int paramInt, String paramString3) {
    // Byte code:
    //   0: new cn/com/chinatelecom/account/api/b/e
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #8
    //   9: aconst_null
    //   10: astore #9
    //   12: aconst_null
    //   13: astore #10
    //   15: aconst_null
    //   16: astore #11
    //   18: aconst_null
    //   19: astore #12
    //   21: aconst_null
    //   22: astore #13
    //   24: aconst_null
    //   25: astore #14
    //   27: aconst_null
    //   28: astore #15
    //   30: aconst_null
    //   31: astore #16
    //   33: aconst_null
    //   34: astore #17
    //   36: aconst_null
    //   37: astore #18
    //   39: aconst_null
    //   40: astore #19
    //   42: aload #17
    //   44: astore #20
    //   46: aload #12
    //   48: astore #21
    //   50: aload_0
    //   51: invokestatic d : (Landroid/content/Context;)Z
    //   54: istore #22
    //   56: aload #17
    //   58: astore #20
    //   60: aload #12
    //   62: astore #21
    //   64: aload_3
    //   65: invokestatic getConnTimeout : (Lcn/com/chinatelecom/account/api/CtSetting;)I
    //   68: istore #23
    //   70: aload #17
    //   72: astore #20
    //   74: aload #12
    //   76: astore #21
    //   78: aload_3
    //   79: invokestatic getReadTimeout : (Lcn/com/chinatelecom/account/api/CtSetting;)I
    //   82: istore #24
    //   84: iload #6
    //   86: ifle -> 123
    //   89: iload #22
    //   91: ifne -> 123
    //   94: aload #17
    //   96: astore #20
    //   98: aload #12
    //   100: astore #21
    //   102: getstatic android/os/Build$VERSION.SDK_INT : I
    //   105: bipush #21
    //   107: if_icmpge -> 123
    //   110: aload #17
    //   112: astore #20
    //   114: aload #12
    //   116: astore #21
    //   118: aload_0
    //   119: aload_1
    //   120: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   123: aload #17
    //   125: astore #20
    //   127: aload #12
    //   129: astore #21
    //   131: new java/net/URL
    //   134: astore #25
    //   136: aload #17
    //   138: astore #20
    //   140: aload #12
    //   142: astore #21
    //   144: aload #25
    //   146: aload_1
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: aload #4
    //   152: ifnull -> 737
    //   155: aload #17
    //   157: astore #20
    //   159: aload #12
    //   161: astore #21
    //   163: getstatic android/os/Build$VERSION.SDK_INT : I
    //   166: bipush #21
    //   168: if_icmplt -> 737
    //   171: aload #17
    //   173: astore #20
    //   175: aload #12
    //   177: astore #21
    //   179: aload #4
    //   181: aload #25
    //   183: invokevirtual openConnection : (Ljava/net/URL;)Ljava/net/URLConnection;
    //   186: checkcast java/net/HttpURLConnection
    //   189: astore #25
    //   191: aload #17
    //   193: astore #20
    //   195: aload #12
    //   197: astore #21
    //   199: aload #25
    //   201: ldc 'accept'
    //   203: ldc '*/*'
    //   205: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload #17
    //   210: astore #20
    //   212: aload #12
    //   214: astore #21
    //   216: aload #25
    //   218: ldc 'POST'
    //   220: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   223: aload #17
    //   225: astore #20
    //   227: aload #12
    //   229: astore #21
    //   231: aload #25
    //   233: iconst_1
    //   234: invokevirtual setDoOutput : (Z)V
    //   237: aload #17
    //   239: astore #20
    //   241: aload #12
    //   243: astore #21
    //   245: aload #25
    //   247: iconst_1
    //   248: invokevirtual setDoInput : (Z)V
    //   251: aload #17
    //   253: astore #20
    //   255: aload #12
    //   257: astore #21
    //   259: aload #25
    //   261: iload #23
    //   263: invokevirtual setConnectTimeout : (I)V
    //   266: aload #17
    //   268: astore #20
    //   270: aload #12
    //   272: astore #21
    //   274: aload #25
    //   276: iload #24
    //   278: invokevirtual setReadTimeout : (I)V
    //   281: aload #17
    //   283: astore #20
    //   285: aload #12
    //   287: astore #21
    //   289: aload #25
    //   291: iconst_0
    //   292: invokevirtual setUseCaches : (Z)V
    //   295: iload #22
    //   297: ifne -> 330
    //   300: aload #17
    //   302: astore #20
    //   304: aload #12
    //   306: astore #21
    //   308: getstatic android/os/Build$VERSION.SDK_INT : I
    //   311: bipush #21
    //   313: if_icmpge -> 330
    //   316: aload #17
    //   318: astore #20
    //   320: aload #12
    //   322: astore #21
    //   324: aload #25
    //   326: iconst_0
    //   327: invokevirtual setInstanceFollowRedirects : (Z)V
    //   330: aload #17
    //   332: astore #20
    //   334: aload #12
    //   336: astore #21
    //   338: aload #25
    //   340: ldc 'Accept-Charset'
    //   342: ldc 'UTF-8'
    //   344: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload #17
    //   349: astore #20
    //   351: aload #12
    //   353: astore #21
    //   355: aload #25
    //   357: aload_0
    //   358: invokestatic a : (Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    //   361: aload #17
    //   363: astore #20
    //   365: aload #12
    //   367: astore #21
    //   369: aload_2
    //   370: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   373: ifne -> 758
    //   376: aload #17
    //   378: astore #20
    //   380: aload #12
    //   382: astore #21
    //   384: new java/io/DataOutputStream
    //   387: astore #26
    //   389: aload #17
    //   391: astore #20
    //   393: aload #12
    //   395: astore #21
    //   397: new java/io/BufferedOutputStream
    //   400: astore_1
    //   401: aload #17
    //   403: astore #20
    //   405: aload #12
    //   407: astore #21
    //   409: aload_1
    //   410: aload #25
    //   412: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   415: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   418: aload #17
    //   420: astore #20
    //   422: aload #12
    //   424: astore #21
    //   426: aload #26
    //   428: aload_1
    //   429: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   432: aload #17
    //   434: astore #20
    //   436: aload #12
    //   438: astore #21
    //   440: aload #26
    //   442: aload_2
    //   443: ldc 'UTF-8'
    //   445: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   448: invokevirtual write : ([B)V
    //   451: aload #17
    //   453: astore #20
    //   455: aload #12
    //   457: astore #21
    //   459: aload #26
    //   461: invokevirtual flush : ()V
    //   464: aload #17
    //   466: astore #20
    //   468: aload #12
    //   470: astore #21
    //   472: aload #26
    //   474: invokevirtual close : ()V
    //   477: aload #17
    //   479: astore #20
    //   481: aload #12
    //   483: astore #21
    //   485: aload #25
    //   487: invokevirtual getResponseCode : ()I
    //   490: istore #24
    //   492: iload #24
    //   494: sipush #200
    //   497: if_icmpne -> 883
    //   500: aload #17
    //   502: astore #20
    //   504: aload #12
    //   506: astore #21
    //   508: aload #25
    //   510: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   513: astore_1
    //   514: new java/lang/StringBuilder
    //   517: astore #20
    //   519: aload #20
    //   521: invokespecial <init> : ()V
    //   524: new java/io/BufferedReader
    //   527: astore_2
    //   528: new java/io/InputStreamReader
    //   531: astore_3
    //   532: aload_3
    //   533: aload_1
    //   534: invokespecial <init> : (Ljava/io/InputStream;)V
    //   537: aload_2
    //   538: aload_3
    //   539: invokespecial <init> : (Ljava/io/Reader;)V
    //   542: aload_2
    //   543: astore #4
    //   545: aload_1
    //   546: astore_3
    //   547: aload_2
    //   548: invokevirtual readLine : ()Ljava/lang/String;
    //   551: astore #21
    //   553: aload #21
    //   555: ifnull -> 782
    //   558: aload_2
    //   559: astore #4
    //   561: aload_1
    //   562: astore_3
    //   563: aload #20
    //   565: aload #21
    //   567: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w '\\n'
    //   573: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: goto -> 542
    //   580: astore_0
    //   581: aload_2
    //   582: astore #4
    //   584: aload_1
    //   585: astore_3
    //   586: new java/lang/StringBuilder
    //   589: astore #20
    //   591: aload_2
    //   592: astore #4
    //   594: aload_1
    //   595: astore_3
    //   596: aload #20
    //   598: invokespecial <init> : ()V
    //   601: aload_2
    //   602: astore #4
    //   604: aload_1
    //   605: astore_3
    //   606: aload #8
    //   608: sipush #-8102
    //   611: aload #20
    //   613: ldc_w 'Socket超时异常-'
    //   616: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload #7
    //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc_w '-'
    //   627: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_0
    //   631: invokevirtual getMessage : ()Ljava/lang/String;
    //   634: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual toString : ()Ljava/lang/String;
    //   640: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   643: putfield b : Ljava/lang/String;
    //   646: aload_2
    //   647: astore #4
    //   649: aload_1
    //   650: astore_3
    //   651: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   654: astore #20
    //   656: aload_2
    //   657: astore #4
    //   659: aload_1
    //   660: astore_3
    //   661: new java/lang/StringBuilder
    //   664: astore #21
    //   666: aload_2
    //   667: astore #4
    //   669: aload_1
    //   670: astore_3
    //   671: aload #21
    //   673: invokespecial <init> : ()V
    //   676: aload_2
    //   677: astore #4
    //   679: aload_1
    //   680: astore_3
    //   681: aload #20
    //   683: aload #21
    //   685: ldc_w 'doPost SocketTimeoutException-'
    //   688: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload #7
    //   693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w '-'
    //   699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_0
    //   703: invokevirtual getMessage : ()Ljava/lang/String;
    //   706: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual toString : ()Ljava/lang/String;
    //   712: aload_0
    //   713: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   716: aload_2
    //   717: ifnull -> 724
    //   720: aload_2
    //   721: invokevirtual close : ()V
    //   724: aload_1
    //   725: ifnull -> 732
    //   728: aload_1
    //   729: invokevirtual close : ()V
    //   732: aload #8
    //   734: astore_1
    //   735: aload_1
    //   736: areturn
    //   737: aload #17
    //   739: astore #20
    //   741: aload #12
    //   743: astore #21
    //   745: aload #25
    //   747: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   750: checkcast java/net/HttpURLConnection
    //   753: astore #25
    //   755: goto -> 191
    //   758: aload #17
    //   760: astore #20
    //   762: aload #12
    //   764: astore #21
    //   766: aload #25
    //   768: invokevirtual connect : ()V
    //   771: goto -> 477
    //   774: astore_0
    //   775: aconst_null
    //   776: astore_2
    //   777: aconst_null
    //   778: astore_1
    //   779: goto -> 581
    //   782: aload_2
    //   783: astore #4
    //   785: aload_1
    //   786: astore_3
    //   787: aload #8
    //   789: iconst_0
    //   790: putfield a : I
    //   793: aload_2
    //   794: astore #4
    //   796: aload_1
    //   797: astore_3
    //   798: aload #8
    //   800: aload #20
    //   802: invokevirtual toString : ()Ljava/lang/String;
    //   805: putfield b : Ljava/lang/String;
    //   808: aload_2
    //   809: astore #4
    //   811: aload_1
    //   812: astore_3
    //   813: aload_0
    //   814: aload #25
    //   816: iload #5
    //   818: invokestatic a : (Landroid/content/Context;Ljava/net/HttpURLConnection;Z)Lcn/com/chinatelecom/account/api/b/b;
    //   821: astore_0
    //   822: aload_0
    //   823: ifnull -> 854
    //   826: aload_2
    //   827: astore #4
    //   829: aload_1
    //   830: astore_3
    //   831: aload #8
    //   833: aload_0
    //   834: getfield b : Z
    //   837: putfield c : Z
    //   840: aload_2
    //   841: astore #4
    //   843: aload_1
    //   844: astore_3
    //   845: aload #8
    //   847: aload_0
    //   848: getfield a : Ljava/lang/String;
    //   851: putfield d : Ljava/lang/String;
    //   854: aload_1
    //   855: astore_0
    //   856: aload_2
    //   857: ifnull -> 864
    //   860: aload_2
    //   861: invokevirtual close : ()V
    //   864: aload_0
    //   865: ifnull -> 732
    //   868: aload_0
    //   869: invokevirtual close : ()V
    //   872: goto -> 732
    //   875: astore_0
    //   876: aload_0
    //   877: invokevirtual printStackTrace : ()V
    //   880: goto -> 732
    //   883: iload #24
    //   885: sipush #302
    //   888: if_icmpne -> 1168
    //   891: iload #6
    //   893: bipush #10
    //   895: if_icmpge -> 967
    //   898: aload #17
    //   900: astore #20
    //   902: aload #12
    //   904: astore #21
    //   906: aload_0
    //   907: aload #25
    //   909: ldc 'Location'
    //   911: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   914: aconst_null
    //   915: aload_3
    //   916: aload #4
    //   918: iload #5
    //   920: iload #6
    //   922: iconst_1
    //   923: iadd
    //   924: ldc_w 'redirect'
    //   927: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcn/com/chinatelecom/account/api/CtSetting;Landroid/net/Network;ZILjava/lang/String;)Lcn/com/chinatelecom/account/api/b/e;
    //   930: astore_0
    //   931: iconst_0
    //   932: ifeq -> 943
    //   935: new java/lang/NullPointerException
    //   938: dup
    //   939: invokespecial <init> : ()V
    //   942: athrow
    //   943: aload_0
    //   944: astore_1
    //   945: iconst_0
    //   946: ifeq -> 735
    //   949: new java/lang/NullPointerException
    //   952: dup
    //   953: invokespecial <init> : ()V
    //   956: athrow
    //   957: astore_1
    //   958: aload_1
    //   959: invokevirtual printStackTrace : ()V
    //   962: aload_0
    //   963: astore_1
    //   964: goto -> 735
    //   967: aload #17
    //   969: astore #20
    //   971: aload #12
    //   973: astore #21
    //   975: aload #8
    //   977: sipush #-8001
    //   980: ldc_w '请求网络异常-Redirect more than 10 times '
    //   983: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   986: putfield b : Ljava/lang/String;
    //   989: aload #19
    //   991: astore_2
    //   992: aload #13
    //   994: astore_0
    //   995: goto -> 856
    //   998: astore_1
    //   999: aload #9
    //   1001: astore_0
    //   1002: aload #14
    //   1004: astore_2
    //   1005: aload_2
    //   1006: astore #20
    //   1008: aload_0
    //   1009: astore #21
    //   1011: new java/lang/StringBuilder
    //   1014: astore_3
    //   1015: aload_2
    //   1016: astore #20
    //   1018: aload_0
    //   1019: astore #21
    //   1021: aload_3
    //   1022: invokespecial <init> : ()V
    //   1025: aload_2
    //   1026: astore #20
    //   1028: aload_0
    //   1029: astore #21
    //   1031: aload #8
    //   1033: sipush #-8103
    //   1036: aload_3
    //   1037: ldc_w '域名解析异常-'
    //   1040: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload #7
    //   1045: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: ldc_w '-'
    //   1051: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload_1
    //   1055: invokevirtual getMessage : ()Ljava/lang/String;
    //   1058: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual toString : ()Ljava/lang/String;
    //   1064: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1067: putfield b : Ljava/lang/String;
    //   1070: aload_2
    //   1071: astore #20
    //   1073: aload_0
    //   1074: astore #21
    //   1076: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   1079: astore #4
    //   1081: aload_2
    //   1082: astore #20
    //   1084: aload_0
    //   1085: astore #21
    //   1087: new java/lang/StringBuilder
    //   1090: astore_3
    //   1091: aload_2
    //   1092: astore #20
    //   1094: aload_0
    //   1095: astore #21
    //   1097: aload_3
    //   1098: invokespecial <init> : ()V
    //   1101: aload_2
    //   1102: astore #20
    //   1104: aload_0
    //   1105: astore #21
    //   1107: aload #4
    //   1109: aload_3
    //   1110: ldc_w 'doPost UnknownHostException-'
    //   1113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: aload #7
    //   1118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w '-'
    //   1124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_1
    //   1128: invokevirtual getMessage : ()Ljava/lang/String;
    //   1131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: invokevirtual toString : ()Ljava/lang/String;
    //   1137: aload_1
    //   1138: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1141: aload_2
    //   1142: ifnull -> 1149
    //   1145: aload_2
    //   1146: invokevirtual close : ()V
    //   1149: aload_0
    //   1150: ifnull -> 732
    //   1153: aload_0
    //   1154: invokevirtual close : ()V
    //   1157: goto -> 732
    //   1160: astore_0
    //   1161: aload_0
    //   1162: invokevirtual printStackTrace : ()V
    //   1165: goto -> 732
    //   1168: aload #17
    //   1170: astore #20
    //   1172: aload #12
    //   1174: astore #21
    //   1176: new java/lang/StringBuilder
    //   1179: astore_0
    //   1180: aload #17
    //   1182: astore #20
    //   1184: aload #12
    //   1186: astore #21
    //   1188: aload_0
    //   1189: invokespecial <init> : ()V
    //   1192: aload #17
    //   1194: astore #20
    //   1196: aload #12
    //   1198: astore #21
    //   1200: aload #8
    //   1202: sipush #-8101
    //   1205: aload_0
    //   1206: ldc_w '响应码错误-'
    //   1209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload #7
    //   1214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: ldc_w '-code : '
    //   1220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: iload #24
    //   1225: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1228: invokevirtual toString : ()Ljava/lang/String;
    //   1231: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1234: putfield b : Ljava/lang/String;
    //   1237: aload #17
    //   1239: astore #20
    //   1241: aload #12
    //   1243: astore #21
    //   1245: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   1248: astore_1
    //   1249: aload #17
    //   1251: astore #20
    //   1253: aload #12
    //   1255: astore #21
    //   1257: new java/lang/StringBuilder
    //   1260: astore_0
    //   1261: aload #17
    //   1263: astore #20
    //   1265: aload #12
    //   1267: astore #21
    //   1269: aload_0
    //   1270: invokespecial <init> : ()V
    //   1273: aload #17
    //   1275: astore #20
    //   1277: aload #12
    //   1279: astore #21
    //   1281: aload_1
    //   1282: aload_0
    //   1283: ldc_w 'doPost > Http response code :'
    //   1286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: iload #24
    //   1291: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1294: invokevirtual toString : ()Ljava/lang/String;
    //   1297: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   1300: aload #19
    //   1302: astore_2
    //   1303: aload #13
    //   1305: astore_0
    //   1306: goto -> 856
    //   1309: astore_1
    //   1310: aload #10
    //   1312: astore_0
    //   1313: aload #15
    //   1315: astore_2
    //   1316: aload_2
    //   1317: astore #20
    //   1319: aload_0
    //   1320: astore #21
    //   1322: new java/lang/StringBuilder
    //   1325: astore_3
    //   1326: aload_2
    //   1327: astore #20
    //   1329: aload_0
    //   1330: astore #21
    //   1332: aload_3
    //   1333: invokespecial <init> : ()V
    //   1336: aload_2
    //   1337: astore #20
    //   1339: aload_0
    //   1340: astore #21
    //   1342: aload #8
    //   1344: sipush #-8104
    //   1347: aload_3
    //   1348: ldc_w 'IO异常-'
    //   1351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: aload #7
    //   1356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: ldc_w '-'
    //   1362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: aload_1
    //   1366: invokevirtual getMessage : ()Ljava/lang/String;
    //   1369: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: invokevirtual toString : ()Ljava/lang/String;
    //   1375: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1378: putfield b : Ljava/lang/String;
    //   1381: aload_2
    //   1382: astore #20
    //   1384: aload_0
    //   1385: astore #21
    //   1387: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   1390: astore #4
    //   1392: aload_2
    //   1393: astore #20
    //   1395: aload_0
    //   1396: astore #21
    //   1398: new java/lang/StringBuilder
    //   1401: astore_3
    //   1402: aload_2
    //   1403: astore #20
    //   1405: aload_0
    //   1406: astore #21
    //   1408: aload_3
    //   1409: invokespecial <init> : ()V
    //   1412: aload_2
    //   1413: astore #20
    //   1415: aload_0
    //   1416: astore #21
    //   1418: aload #4
    //   1420: aload_3
    //   1421: ldc_w 'doPost IOException-'
    //   1424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: aload #7
    //   1429: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: ldc_w '-'
    //   1435: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload_1
    //   1439: invokevirtual getMessage : ()Ljava/lang/String;
    //   1442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: invokevirtual toString : ()Ljava/lang/String;
    //   1448: aload_1
    //   1449: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1452: aload_2
    //   1453: ifnull -> 1460
    //   1456: aload_2
    //   1457: invokevirtual close : ()V
    //   1460: aload_0
    //   1461: ifnull -> 732
    //   1464: aload_0
    //   1465: invokevirtual close : ()V
    //   1468: goto -> 732
    //   1471: astore_0
    //   1472: aload_0
    //   1473: invokevirtual printStackTrace : ()V
    //   1476: goto -> 732
    //   1479: astore_0
    //   1480: aload_0
    //   1481: invokevirtual printStackTrace : ()V
    //   1484: goto -> 732
    //   1487: astore_1
    //   1488: aload #11
    //   1490: astore_0
    //   1491: aload #16
    //   1493: astore_2
    //   1494: aload_2
    //   1495: astore #20
    //   1497: aload_0
    //   1498: astore #21
    //   1500: new java/lang/StringBuilder
    //   1503: astore_3
    //   1504: aload_2
    //   1505: astore #20
    //   1507: aload_0
    //   1508: astore #21
    //   1510: aload_3
    //   1511: invokespecial <init> : ()V
    //   1514: aload_2
    //   1515: astore #20
    //   1517: aload_0
    //   1518: astore #21
    //   1520: aload #8
    //   1522: sipush #-8001
    //   1525: aload_3
    //   1526: ldc_w '请求网络异常-'
    //   1529: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload #7
    //   1534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: ldc_w '-'
    //   1540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload_1
    //   1544: invokevirtual toString : ()Ljava/lang/String;
    //   1547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: invokevirtual toString : ()Ljava/lang/String;
    //   1553: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
    //   1556: putfield b : Ljava/lang/String;
    //   1559: aload_2
    //   1560: astore #20
    //   1562: aload_0
    //   1563: astore #21
    //   1565: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   1568: astore_3
    //   1569: aload_2
    //   1570: astore #20
    //   1572: aload_0
    //   1573: astore #21
    //   1575: new java/lang/StringBuilder
    //   1578: astore #4
    //   1580: aload_2
    //   1581: astore #20
    //   1583: aload_0
    //   1584: astore #21
    //   1586: aload #4
    //   1588: invokespecial <init> : ()V
    //   1591: aload_2
    //   1592: astore #20
    //   1594: aload_0
    //   1595: astore #21
    //   1597: aload_3
    //   1598: aload #4
    //   1600: ldc_w 'doPost Throwable-'
    //   1603: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: aload #7
    //   1608: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: ldc_w '-'
    //   1614: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: aload_1
    //   1618: invokevirtual getMessage : ()Ljava/lang/String;
    //   1621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: invokevirtual toString : ()Ljava/lang/String;
    //   1627: aload_1
    //   1628: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1631: aload_2
    //   1632: ifnull -> 1639
    //   1635: aload_2
    //   1636: invokevirtual close : ()V
    //   1639: aload_0
    //   1640: ifnull -> 732
    //   1643: aload_0
    //   1644: invokevirtual close : ()V
    //   1647: goto -> 732
    //   1650: astore_0
    //   1651: aload_0
    //   1652: invokevirtual printStackTrace : ()V
    //   1655: goto -> 732
    //   1658: astore_0
    //   1659: aload #20
    //   1661: ifnull -> 1669
    //   1664: aload #20
    //   1666: invokevirtual close : ()V
    //   1669: aload #21
    //   1671: ifnull -> 1679
    //   1674: aload #21
    //   1676: invokevirtual close : ()V
    //   1679: aload_0
    //   1680: athrow
    //   1681: astore_1
    //   1682: aload_1
    //   1683: invokevirtual printStackTrace : ()V
    //   1686: goto -> 1679
    //   1689: astore_0
    //   1690: aload #18
    //   1692: astore #20
    //   1694: aload_1
    //   1695: astore #21
    //   1697: goto -> 1659
    //   1700: astore_0
    //   1701: aload #4
    //   1703: astore #20
    //   1705: aload_3
    //   1706: astore #21
    //   1708: goto -> 1659
    //   1711: astore_2
    //   1712: aload_1
    //   1713: astore_0
    //   1714: aload_2
    //   1715: astore_1
    //   1716: aload #16
    //   1718: astore_2
    //   1719: goto -> 1494
    //   1722: astore_3
    //   1723: aload_1
    //   1724: astore_0
    //   1725: aload_3
    //   1726: astore_1
    //   1727: goto -> 1494
    //   1730: astore_2
    //   1731: aload_1
    //   1732: astore_0
    //   1733: aload_2
    //   1734: astore_1
    //   1735: aload #15
    //   1737: astore_2
    //   1738: goto -> 1316
    //   1741: astore_3
    //   1742: aload_1
    //   1743: astore_0
    //   1744: aload_3
    //   1745: astore_1
    //   1746: goto -> 1316
    //   1749: astore_2
    //   1750: aload_1
    //   1751: astore_0
    //   1752: aload_2
    //   1753: astore_1
    //   1754: aload #14
    //   1756: astore_2
    //   1757: goto -> 1005
    //   1760: astore_0
    //   1761: aload_1
    //   1762: astore_3
    //   1763: aload_0
    //   1764: astore_1
    //   1765: aload_3
    //   1766: astore_0
    //   1767: goto -> 1005
    //   1770: astore_0
    //   1771: aconst_null
    //   1772: astore_2
    //   1773: goto -> 581
    // Exception table:
    //   from	to	target	type
    //   50	56	774	java/net/SocketTimeoutException
    //   50	56	998	java/net/UnknownHostException
    //   50	56	1309	java/io/IOException
    //   50	56	1487	java/lang/Throwable
    //   50	56	1658	finally
    //   64	70	774	java/net/SocketTimeoutException
    //   64	70	998	java/net/UnknownHostException
    //   64	70	1309	java/io/IOException
    //   64	70	1487	java/lang/Throwable
    //   64	70	1658	finally
    //   78	84	774	java/net/SocketTimeoutException
    //   78	84	998	java/net/UnknownHostException
    //   78	84	1309	java/io/IOException
    //   78	84	1487	java/lang/Throwable
    //   78	84	1658	finally
    //   102	110	774	java/net/SocketTimeoutException
    //   102	110	998	java/net/UnknownHostException
    //   102	110	1309	java/io/IOException
    //   102	110	1487	java/lang/Throwable
    //   102	110	1658	finally
    //   118	123	774	java/net/SocketTimeoutException
    //   118	123	998	java/net/UnknownHostException
    //   118	123	1309	java/io/IOException
    //   118	123	1487	java/lang/Throwable
    //   118	123	1658	finally
    //   131	136	774	java/net/SocketTimeoutException
    //   131	136	998	java/net/UnknownHostException
    //   131	136	1309	java/io/IOException
    //   131	136	1487	java/lang/Throwable
    //   131	136	1658	finally
    //   144	150	774	java/net/SocketTimeoutException
    //   144	150	998	java/net/UnknownHostException
    //   144	150	1309	java/io/IOException
    //   144	150	1487	java/lang/Throwable
    //   144	150	1658	finally
    //   163	171	774	java/net/SocketTimeoutException
    //   163	171	998	java/net/UnknownHostException
    //   163	171	1309	java/io/IOException
    //   163	171	1487	java/lang/Throwable
    //   163	171	1658	finally
    //   179	191	774	java/net/SocketTimeoutException
    //   179	191	998	java/net/UnknownHostException
    //   179	191	1309	java/io/IOException
    //   179	191	1487	java/lang/Throwable
    //   179	191	1658	finally
    //   199	208	774	java/net/SocketTimeoutException
    //   199	208	998	java/net/UnknownHostException
    //   199	208	1309	java/io/IOException
    //   199	208	1487	java/lang/Throwable
    //   199	208	1658	finally
    //   216	223	774	java/net/SocketTimeoutException
    //   216	223	998	java/net/UnknownHostException
    //   216	223	1309	java/io/IOException
    //   216	223	1487	java/lang/Throwable
    //   216	223	1658	finally
    //   231	237	774	java/net/SocketTimeoutException
    //   231	237	998	java/net/UnknownHostException
    //   231	237	1309	java/io/IOException
    //   231	237	1487	java/lang/Throwable
    //   231	237	1658	finally
    //   245	251	774	java/net/SocketTimeoutException
    //   245	251	998	java/net/UnknownHostException
    //   245	251	1309	java/io/IOException
    //   245	251	1487	java/lang/Throwable
    //   245	251	1658	finally
    //   259	266	774	java/net/SocketTimeoutException
    //   259	266	998	java/net/UnknownHostException
    //   259	266	1309	java/io/IOException
    //   259	266	1487	java/lang/Throwable
    //   259	266	1658	finally
    //   274	281	774	java/net/SocketTimeoutException
    //   274	281	998	java/net/UnknownHostException
    //   274	281	1309	java/io/IOException
    //   274	281	1487	java/lang/Throwable
    //   274	281	1658	finally
    //   289	295	774	java/net/SocketTimeoutException
    //   289	295	998	java/net/UnknownHostException
    //   289	295	1309	java/io/IOException
    //   289	295	1487	java/lang/Throwable
    //   289	295	1658	finally
    //   308	316	774	java/net/SocketTimeoutException
    //   308	316	998	java/net/UnknownHostException
    //   308	316	1309	java/io/IOException
    //   308	316	1487	java/lang/Throwable
    //   308	316	1658	finally
    //   324	330	774	java/net/SocketTimeoutException
    //   324	330	998	java/net/UnknownHostException
    //   324	330	1309	java/io/IOException
    //   324	330	1487	java/lang/Throwable
    //   324	330	1658	finally
    //   338	347	774	java/net/SocketTimeoutException
    //   338	347	998	java/net/UnknownHostException
    //   338	347	1309	java/io/IOException
    //   338	347	1487	java/lang/Throwable
    //   338	347	1658	finally
    //   355	361	774	java/net/SocketTimeoutException
    //   355	361	998	java/net/UnknownHostException
    //   355	361	1309	java/io/IOException
    //   355	361	1487	java/lang/Throwable
    //   355	361	1658	finally
    //   369	376	774	java/net/SocketTimeoutException
    //   369	376	998	java/net/UnknownHostException
    //   369	376	1309	java/io/IOException
    //   369	376	1487	java/lang/Throwable
    //   369	376	1658	finally
    //   384	389	774	java/net/SocketTimeoutException
    //   384	389	998	java/net/UnknownHostException
    //   384	389	1309	java/io/IOException
    //   384	389	1487	java/lang/Throwable
    //   384	389	1658	finally
    //   397	401	774	java/net/SocketTimeoutException
    //   397	401	998	java/net/UnknownHostException
    //   397	401	1309	java/io/IOException
    //   397	401	1487	java/lang/Throwable
    //   397	401	1658	finally
    //   409	418	774	java/net/SocketTimeoutException
    //   409	418	998	java/net/UnknownHostException
    //   409	418	1309	java/io/IOException
    //   409	418	1487	java/lang/Throwable
    //   409	418	1658	finally
    //   426	432	774	java/net/SocketTimeoutException
    //   426	432	998	java/net/UnknownHostException
    //   426	432	1309	java/io/IOException
    //   426	432	1487	java/lang/Throwable
    //   426	432	1658	finally
    //   440	451	774	java/net/SocketTimeoutException
    //   440	451	998	java/net/UnknownHostException
    //   440	451	1309	java/io/IOException
    //   440	451	1487	java/lang/Throwable
    //   440	451	1658	finally
    //   459	464	774	java/net/SocketTimeoutException
    //   459	464	998	java/net/UnknownHostException
    //   459	464	1309	java/io/IOException
    //   459	464	1487	java/lang/Throwable
    //   459	464	1658	finally
    //   472	477	774	java/net/SocketTimeoutException
    //   472	477	998	java/net/UnknownHostException
    //   472	477	1309	java/io/IOException
    //   472	477	1487	java/lang/Throwable
    //   472	477	1658	finally
    //   485	492	774	java/net/SocketTimeoutException
    //   485	492	998	java/net/UnknownHostException
    //   485	492	1309	java/io/IOException
    //   485	492	1487	java/lang/Throwable
    //   485	492	1658	finally
    //   508	514	774	java/net/SocketTimeoutException
    //   508	514	998	java/net/UnknownHostException
    //   508	514	1309	java/io/IOException
    //   508	514	1487	java/lang/Throwable
    //   508	514	1658	finally
    //   514	542	1770	java/net/SocketTimeoutException
    //   514	542	1749	java/net/UnknownHostException
    //   514	542	1730	java/io/IOException
    //   514	542	1711	java/lang/Throwable
    //   514	542	1689	finally
    //   547	553	580	java/net/SocketTimeoutException
    //   547	553	1760	java/net/UnknownHostException
    //   547	553	1741	java/io/IOException
    //   547	553	1722	java/lang/Throwable
    //   547	553	1700	finally
    //   563	577	580	java/net/SocketTimeoutException
    //   563	577	1760	java/net/UnknownHostException
    //   563	577	1741	java/io/IOException
    //   563	577	1722	java/lang/Throwable
    //   563	577	1700	finally
    //   586	591	1700	finally
    //   596	601	1700	finally
    //   606	646	1700	finally
    //   651	656	1700	finally
    //   661	666	1700	finally
    //   671	676	1700	finally
    //   681	716	1700	finally
    //   720	724	1479	java/io/IOException
    //   728	732	1479	java/io/IOException
    //   745	755	774	java/net/SocketTimeoutException
    //   745	755	998	java/net/UnknownHostException
    //   745	755	1309	java/io/IOException
    //   745	755	1487	java/lang/Throwable
    //   745	755	1658	finally
    //   766	771	774	java/net/SocketTimeoutException
    //   766	771	998	java/net/UnknownHostException
    //   766	771	1309	java/io/IOException
    //   766	771	1487	java/lang/Throwable
    //   766	771	1658	finally
    //   787	793	580	java/net/SocketTimeoutException
    //   787	793	1760	java/net/UnknownHostException
    //   787	793	1741	java/io/IOException
    //   787	793	1722	java/lang/Throwable
    //   787	793	1700	finally
    //   798	808	580	java/net/SocketTimeoutException
    //   798	808	1760	java/net/UnknownHostException
    //   798	808	1741	java/io/IOException
    //   798	808	1722	java/lang/Throwable
    //   798	808	1700	finally
    //   813	822	580	java/net/SocketTimeoutException
    //   813	822	1760	java/net/UnknownHostException
    //   813	822	1741	java/io/IOException
    //   813	822	1722	java/lang/Throwable
    //   813	822	1700	finally
    //   831	840	580	java/net/SocketTimeoutException
    //   831	840	1760	java/net/UnknownHostException
    //   831	840	1741	java/io/IOException
    //   831	840	1722	java/lang/Throwable
    //   831	840	1700	finally
    //   845	854	580	java/net/SocketTimeoutException
    //   845	854	1760	java/net/UnknownHostException
    //   845	854	1741	java/io/IOException
    //   845	854	1722	java/lang/Throwable
    //   845	854	1700	finally
    //   860	864	875	java/io/IOException
    //   868	872	875	java/io/IOException
    //   906	931	774	java/net/SocketTimeoutException
    //   906	931	998	java/net/UnknownHostException
    //   906	931	1309	java/io/IOException
    //   906	931	1487	java/lang/Throwable
    //   906	931	1658	finally
    //   935	943	957	java/io/IOException
    //   949	957	957	java/io/IOException
    //   975	989	774	java/net/SocketTimeoutException
    //   975	989	998	java/net/UnknownHostException
    //   975	989	1309	java/io/IOException
    //   975	989	1487	java/lang/Throwable
    //   975	989	1658	finally
    //   1011	1015	1658	finally
    //   1021	1025	1658	finally
    //   1031	1070	1658	finally
    //   1076	1081	1658	finally
    //   1087	1091	1658	finally
    //   1097	1101	1658	finally
    //   1107	1141	1658	finally
    //   1145	1149	1160	java/io/IOException
    //   1153	1157	1160	java/io/IOException
    //   1176	1180	774	java/net/SocketTimeoutException
    //   1176	1180	998	java/net/UnknownHostException
    //   1176	1180	1309	java/io/IOException
    //   1176	1180	1487	java/lang/Throwable
    //   1176	1180	1658	finally
    //   1188	1192	774	java/net/SocketTimeoutException
    //   1188	1192	998	java/net/UnknownHostException
    //   1188	1192	1309	java/io/IOException
    //   1188	1192	1487	java/lang/Throwable
    //   1188	1192	1658	finally
    //   1200	1237	774	java/net/SocketTimeoutException
    //   1200	1237	998	java/net/UnknownHostException
    //   1200	1237	1309	java/io/IOException
    //   1200	1237	1487	java/lang/Throwable
    //   1200	1237	1658	finally
    //   1245	1249	774	java/net/SocketTimeoutException
    //   1245	1249	998	java/net/UnknownHostException
    //   1245	1249	1309	java/io/IOException
    //   1245	1249	1487	java/lang/Throwable
    //   1245	1249	1658	finally
    //   1257	1261	774	java/net/SocketTimeoutException
    //   1257	1261	998	java/net/UnknownHostException
    //   1257	1261	1309	java/io/IOException
    //   1257	1261	1487	java/lang/Throwable
    //   1257	1261	1658	finally
    //   1269	1273	774	java/net/SocketTimeoutException
    //   1269	1273	998	java/net/UnknownHostException
    //   1269	1273	1309	java/io/IOException
    //   1269	1273	1487	java/lang/Throwable
    //   1269	1273	1658	finally
    //   1281	1300	774	java/net/SocketTimeoutException
    //   1281	1300	998	java/net/UnknownHostException
    //   1281	1300	1309	java/io/IOException
    //   1281	1300	1487	java/lang/Throwable
    //   1281	1300	1658	finally
    //   1322	1326	1658	finally
    //   1332	1336	1658	finally
    //   1342	1381	1658	finally
    //   1387	1392	1658	finally
    //   1398	1402	1658	finally
    //   1408	1412	1658	finally
    //   1418	1452	1658	finally
    //   1456	1460	1471	java/io/IOException
    //   1464	1468	1471	java/io/IOException
    //   1500	1504	1658	finally
    //   1510	1514	1658	finally
    //   1520	1559	1658	finally
    //   1565	1569	1658	finally
    //   1575	1580	1658	finally
    //   1586	1591	1658	finally
    //   1597	1631	1658	finally
    //   1635	1639	1650	java/io/IOException
    //   1643	1647	1650	java/io/IOException
    //   1664	1669	1681	java/io/IOException
    //   1674	1679	1681	java/io/IOException
  }
  
  public static void a(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (connectivityManager.getNetworkInfo(5).getState().compareTo((Enum)NetworkInfo.State.CONNECTED) == 0) {
          int i = d.a(d.b(paramString));
          ((Boolean)Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", new Class[] { int.class, int.class }).invoke(connectivityManager, new Object[] { Integer.valueOf(5), Integer.valueOf(i) })).booleanValue();
        } 
      } catch (Throwable throwable) {
        CtAuth.warn(a, "http doPost > requestUrlToRoute error", throwable);
      }  
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Context paramContext) {
    try {
      String str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      String str1 = str2;
      if (str2 == null)
        str1 = ""; 
      paramHttpURLConnection.setRequestProperty("guid", str1);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */