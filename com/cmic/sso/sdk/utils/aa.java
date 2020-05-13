package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Bundle;
import com.cmic.sso.sdk.b.b.a;
import com.cmic.sso.sdk.b.b.b;
import org.json.JSONObject;

public class aa {
  public static String a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: ldc ''
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_0
    //   11: ldc com/cmic/sso/sdk/utils/aa
    //   13: monitorexit
    //   14: aload_0
    //   15: areturn
    //   16: astore_0
    //   17: ldc ''
    //   19: astore_0
    //   20: ldc com/cmic/sso/sdk/utils/aa
    //   22: monitorexit
    //   23: goto -> 14
    //   26: astore_0
    //   27: ldc com/cmic/sso/sdk/utils/aa
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	16	java/lang/Exception
    //   3	11	26	finally
    //   11	14	26	finally
    //   20	23	26	finally
    //   27	30	26	finally
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    String str = r.b(paramContext, "isGetCert", "1");
    a.a(paramContext).a("1".equals(str), paramBundle, new b(paramContext) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            try {
              if (param1JSONObject.has("resultcode") && "103000".equals(param1JSONObject.getString("resultcode"))) {
                StringBuilder stringBuilder = new StringBuilder();
                this();
                h.a("UmcConfigUtil", stringBuilder.append("uniConfig resultCode").append(param1JSONObject.getString("resultcode")).toString());
                r.a(this.a, "isGetCert", "0");
                aa.a(this.a, param1JSONObject);
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        });
  }
  
  public static boolean a(Context paramContext) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc com/cmic/sso/sdk/utils/aa
    //   6: monitorenter
    //   7: invokestatic b : ()Ljava/lang/String;
    //   10: aload_0
    //   11: ldc 'getConfigDate'
    //   13: ldc ''
    //   15: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifne -> 29
    //   24: ldc com/cmic/sso/sdk/utils/aa
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: invokestatic currentTimeMillis : ()J
    //   32: aload_0
    //   33: ldc 'client_valid'
    //   35: lconst_0
    //   36: invokestatic b : (Landroid/content/Context;Ljava/lang/String;J)J
    //   39: lcmp
    //   40: iflt -> 57
    //   43: iload_1
    //   44: istore_2
    //   45: ldc com/cmic/sso/sdk/utils/aa
    //   47: monitorexit
    //   48: goto -> 27
    //   51: astore_0
    //   52: ldc com/cmic/sso/sdk/utils/aa
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -> 45
    // Exception table:
    //   from	to	target	type
    //   7	27	51	finally
    //   29	43	51	finally
    //   45	48	51	finally
    //   52	55	51	finally
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore #4
    //   7: aconst_null
    //   8: astore #5
    //   10: aconst_null
    //   11: astore #6
    //   13: aconst_null
    //   14: astore #7
    //   16: aconst_null
    //   17: astore #8
    //   19: aconst_null
    //   20: astore #9
    //   22: ldc com/cmic/sso/sdk/utils/aa
    //   24: monitorenter
    //   25: aload_0
    //   26: ldc 'getConfigDate'
    //   28: invokestatic b : ()Ljava/lang/String;
    //   31: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_1
    //   35: ldc 'client_valid'
    //   37: invokevirtual has : (Ljava/lang/String;)Z
    //   40: ifeq -> 78
    //   43: aload_0
    //   44: ldc 'client_valid'
    //   46: aload_1
    //   47: ldc 'client_valid'
    //   49: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   55: invokevirtual intValue : ()I
    //   58: i2l
    //   59: ldc2_w 60
    //   62: lmul
    //   63: ldc2_w 60
    //   66: lmul
    //   67: ldc2_w 1000
    //   70: lmul
    //   71: invokestatic currentTimeMillis : ()J
    //   74: ladd
    //   75: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)V
    //   78: aload_1
    //   79: ldc 'Configlist'
    //   81: invokevirtual has : (Ljava/lang/String;)Z
    //   84: ifeq -> 1852
    //   87: aload_1
    //   88: ldc 'Configlist'
    //   90: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   93: astore #10
    //   95: aload #10
    //   97: ldc 'CHANGE_HOST'
    //   99: invokevirtual has : (Ljava/lang/String;)Z
    //   102: ifeq -> 1963
    //   105: aload #10
    //   107: ldc 'CHANGE_HOST'
    //   109: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   112: astore #11
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_2
    //   117: astore_1
    //   118: aload #11
    //   120: ldc 'M005'
    //   122: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   125: ifeq -> 274
    //   128: aload #11
    //   130: ldc '&'
    //   132: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: arraylength
    //   138: istore #12
    //   140: iconst_0
    //   141: istore #13
    //   143: iload #13
    //   145: iload #12
    //   147: if_icmpge -> 2221
    //   150: aload_1
    //   151: iload #13
    //   153: aaload
    //   154: astore_2
    //   155: aload_2
    //   156: ldc 'M005'
    //   158: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   161: ifeq -> 1856
    //   164: aload_3
    //   165: astore #6
    //   167: aload #4
    //   169: astore_1
    //   170: aload_2
    //   171: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   174: ifne -> 223
    //   177: aload_2
    //   178: ldc ','
    //   180: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   183: ifeq -> 1862
    //   186: aload_2
    //   187: aload_2
    //   188: ldc '='
    //   190: invokevirtual indexOf : (Ljava/lang/String;)I
    //   193: iconst_1
    //   194: iadd
    //   195: aload_2
    //   196: ldc ','
    //   198: invokevirtual indexOf : (Ljava/lang/String;)I
    //   201: invokevirtual substring : (II)Ljava/lang/String;
    //   204: astore #6
    //   206: aload_2
    //   207: aload_2
    //   208: ldc '='
    //   210: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   213: iconst_1
    //   214: iadd
    //   215: aload_2
    //   216: invokevirtual length : ()I
    //   219: invokevirtual substring : (II)Ljava/lang/String;
    //   222: astore_1
    //   223: new java/lang/StringBuilder
    //   226: astore_2
    //   227: aload_2
    //   228: invokespecial <init> : ()V
    //   231: ldc 'UmcConfigUtil'
    //   233: aload_2
    //   234: ldc 'HTTP:'
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload #6
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc '||||||||HTTPS:'
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual toString : ()Ljava/lang/String;
    //   256: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_0
    //   260: ldc 'httpHost'
    //   262: aload #6
    //   264: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_0
    //   268: ldc 'httpsHost'
    //   270: aload_1
    //   271: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload #11
    //   276: ldc 'M007'
    //   278: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   281: ifeq -> 397
    //   284: aload #11
    //   286: ldc '&'
    //   288: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   291: astore_2
    //   292: aload_2
    //   293: arraylength
    //   294: istore #12
    //   296: iconst_0
    //   297: istore #13
    //   299: aload #7
    //   301: astore #6
    //   303: iload #13
    //   305: iload #12
    //   307: if_icmpge -> 326
    //   310: aload_2
    //   311: iload #13
    //   313: aaload
    //   314: astore #6
    //   316: aload #6
    //   318: ldc 'M007'
    //   320: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   323: ifeq -> 1951
    //   326: aload #6
    //   328: astore #5
    //   330: aload #6
    //   332: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   335: ifne -> 359
    //   338: aload #6
    //   340: aload #6
    //   342: ldc '='
    //   344: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   347: iconst_1
    //   348: iadd
    //   349: aload #6
    //   351: invokevirtual length : ()I
    //   354: invokevirtual substring : (II)Ljava/lang/String;
    //   357: astore #5
    //   359: new java/lang/StringBuilder
    //   362: astore #6
    //   364: aload #6
    //   366: invokespecial <init> : ()V
    //   369: ldc 'UmcConfigUtil'
    //   371: aload #6
    //   373: ldc 'HTTPS:'
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload #5
    //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual toString : ()Ljava/lang/String;
    //   386: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_0
    //   390: ldc 'logHost'
    //   392: aload #5
    //   394: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload #8
    //   399: astore_2
    //   400: aload #11
    //   402: ldc 'M003'
    //   404: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   407: ifeq -> 519
    //   410: aload #11
    //   412: ldc '&'
    //   414: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   417: astore_2
    //   418: aload_2
    //   419: arraylength
    //   420: istore #12
    //   422: iconst_0
    //   423: istore #13
    //   425: aload #9
    //   427: astore #6
    //   429: iload #13
    //   431: iload #12
    //   433: if_icmpge -> 452
    //   436: aload_2
    //   437: iload #13
    //   439: aaload
    //   440: astore #6
    //   442: aload #6
    //   444: ldc 'M003'
    //   446: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   449: ifeq -> 1957
    //   452: aload #6
    //   454: astore_2
    //   455: aload #6
    //   457: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   460: ifne -> 483
    //   463: aload #6
    //   465: aload #6
    //   467: ldc '='
    //   469: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   472: iconst_1
    //   473: iadd
    //   474: aload #6
    //   476: invokevirtual length : ()I
    //   479: invokevirtual substring : (II)Ljava/lang/String;
    //   482: astore_2
    //   483: new java/lang/StringBuilder
    //   486: astore #6
    //   488: aload #6
    //   490: invokespecial <init> : ()V
    //   493: ldc 'UmcConfigUtil'
    //   495: aload #6
    //   497: ldc 'HTTPS:'
    //   499: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_2
    //   503: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual toString : ()Ljava/lang/String;
    //   509: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload_0
    //   513: ldc 'smsHost'
    //   515: aload_2
    //   516: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   519: aload_1
    //   520: astore #9
    //   522: aload #10
    //   524: ldc 'HOST_CERT_INFO'
    //   526: invokevirtual has : (Ljava/lang/String;)Z
    //   529: ifeq -> 1534
    //   532: aload #10
    //   534: ldc 'HOST_CERT_INFO'
    //   536: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   539: astore_3
    //   540: aconst_null
    //   541: astore_1
    //   542: aconst_null
    //   543: astore #7
    //   545: aload_3
    //   546: ldc '&'
    //   548: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   551: astore #4
    //   553: aload #5
    //   555: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   558: ifne -> 2214
    //   561: aload #5
    //   563: ldc ':'
    //   565: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   568: ifeq -> 2214
    //   571: aload #5
    //   573: iconst_0
    //   574: aload #5
    //   576: ldc ':'
    //   578: invokevirtual indexOf : (Ljava/lang/String;)I
    //   581: invokevirtual substring : (II)Ljava/lang/String;
    //   584: astore #8
    //   586: new java/lang/StringBuilder
    //   589: astore #6
    //   591: aload #6
    //   593: invokespecial <init> : ()V
    //   596: ldc 'UmcConfigUtil'
    //   598: aload #6
    //   600: ldc 'logHostWithoutHost:'
    //   602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload #8
    //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual toString : ()Ljava/lang/String;
    //   613: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload_1
    //   617: astore #6
    //   619: aload #5
    //   621: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   624: ifne -> 768
    //   627: aload_1
    //   628: astore #6
    //   630: aload_3
    //   631: aload #8
    //   633: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   636: ifeq -> 768
    //   639: aload #4
    //   641: arraylength
    //   642: istore #12
    //   644: iconst_0
    //   645: istore #13
    //   647: aload #7
    //   649: astore_1
    //   650: iload #13
    //   652: iload #12
    //   654: if_icmpge -> 680
    //   657: aload #4
    //   659: iload #13
    //   661: aaload
    //   662: astore_1
    //   663: aload #5
    //   665: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   668: ifne -> 2007
    //   671: aload_1
    //   672: aload #8
    //   674: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   677: ifeq -> 2007
    //   680: aload_1
    //   681: astore #6
    //   683: aload_1
    //   684: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   687: ifne -> 708
    //   690: aload_1
    //   691: aload_1
    //   692: ldc ':'
    //   694: invokevirtual indexOf : (Ljava/lang/String;)I
    //   697: aload_1
    //   698: ldc ','
    //   700: invokevirtual indexOf : (Ljava/lang/String;)I
    //   703: invokevirtual substring : (II)Ljava/lang/String;
    //   706: astore #6
    //   708: new java/lang/StringBuilder
    //   711: astore_1
    //   712: aload_1
    //   713: invokespecial <init> : ()V
    //   716: ldc 'UmcConfigUtil'
    //   718: aload_1
    //   719: ldc 'CERT:'
    //   721: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload #6
    //   726: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual toString : ()Ljava/lang/String;
    //   732: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   735: new java/lang/StringBuilder
    //   738: astore_1
    //   739: aload_1
    //   740: invokespecial <init> : ()V
    //   743: aload_0
    //   744: aload_1
    //   745: ldc 'https://'
    //   747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload #5
    //   752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc '/log/logReport'
    //   757: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: invokevirtual toString : ()Ljava/lang/String;
    //   763: aload #6
    //   765: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload #6
    //   770: astore_1
    //   771: aload_3
    //   772: ldc 'log1.cmpassport.com'
    //   774: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   777: ifeq -> 879
    //   780: aload #4
    //   782: arraylength
    //   783: istore #12
    //   785: iconst_0
    //   786: istore #13
    //   788: aload #6
    //   790: astore_1
    //   791: iload #13
    //   793: iload #12
    //   795: if_icmpge -> 813
    //   798: aload #4
    //   800: iload #13
    //   802: aaload
    //   803: astore_1
    //   804: aload_1
    //   805: ldc 'log1.cmpassport.com'
    //   807: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   810: ifeq -> 2013
    //   813: aload_1
    //   814: astore #6
    //   816: aload_1
    //   817: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   820: ifne -> 841
    //   823: aload_1
    //   824: aload_1
    //   825: ldc ':'
    //   827: invokevirtual indexOf : (Ljava/lang/String;)I
    //   830: aload_1
    //   831: ldc ','
    //   833: invokevirtual indexOf : (Ljava/lang/String;)I
    //   836: invokevirtual substring : (II)Ljava/lang/String;
    //   839: astore #6
    //   841: new java/lang/StringBuilder
    //   844: astore_1
    //   845: aload_1
    //   846: invokespecial <init> : ()V
    //   849: ldc 'UmcConfigUtil'
    //   851: aload_1
    //   852: ldc 'CERT:'
    //   854: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload #6
    //   859: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual toString : ()Ljava/lang/String;
    //   865: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload_0
    //   869: ldc 'https://log1.cmpassport.com:9443/log/logReport'
    //   871: aload #6
    //   873: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   876: aload #6
    //   878: astore_1
    //   879: aload #9
    //   881: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   884: ifne -> 2207
    //   887: aload #9
    //   889: ldc ':'
    //   891: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   894: ifeq -> 2207
    //   897: aload #9
    //   899: iconst_0
    //   900: aload #9
    //   902: ldc ':'
    //   904: invokevirtual indexOf : (Ljava/lang/String;)I
    //   907: invokevirtual substring : (II)Ljava/lang/String;
    //   910: astore #8
    //   912: new java/lang/StringBuilder
    //   915: astore #6
    //   917: aload #6
    //   919: invokespecial <init> : ()V
    //   922: ldc 'UmcConfigUtil'
    //   924: aload #6
    //   926: ldc 'httpsHostWithoutPort:'
    //   928: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: aload #8
    //   933: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokevirtual toString : ()Ljava/lang/String;
    //   939: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   942: aload_1
    //   943: astore #6
    //   945: aload #9
    //   947: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   950: ifne -> 1101
    //   953: aload_1
    //   954: astore #6
    //   956: aload_3
    //   957: aload #8
    //   959: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   962: ifeq -> 1101
    //   965: aload #4
    //   967: arraylength
    //   968: istore #12
    //   970: iconst_0
    //   971: istore #13
    //   973: aload_1
    //   974: astore #5
    //   976: iload #13
    //   978: iload #12
    //   980: if_icmpge -> 1008
    //   983: aload #4
    //   985: iload #13
    //   987: aaload
    //   988: astore #5
    //   990: aload #9
    //   992: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   995: ifne -> 2019
    //   998: aload #5
    //   1000: aload #8
    //   1002: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1005: ifeq -> 2019
    //   1008: aload #5
    //   1010: astore #6
    //   1012: aload #5
    //   1014: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1017: ifne -> 1041
    //   1020: aload #5
    //   1022: aload #5
    //   1024: ldc ':'
    //   1026: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1029: aload #5
    //   1031: ldc ','
    //   1033: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1036: invokevirtual substring : (II)Ljava/lang/String;
    //   1039: astore #6
    //   1041: new java/lang/StringBuilder
    //   1044: astore_1
    //   1045: aload_1
    //   1046: invokespecial <init> : ()V
    //   1049: ldc 'UmcConfigUtil'
    //   1051: aload_1
    //   1052: ldc 'CERT:'
    //   1054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload #6
    //   1059: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: invokevirtual toString : ()Ljava/lang/String;
    //   1065: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1068: new java/lang/StringBuilder
    //   1071: astore_1
    //   1072: aload_1
    //   1073: invokespecial <init> : ()V
    //   1076: aload_0
    //   1077: aload_1
    //   1078: ldc 'https://'
    //   1080: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload #9
    //   1085: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: ldc '/unisdk/'
    //   1090: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokevirtual toString : ()Ljava/lang/String;
    //   1096: aload #6
    //   1098: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1101: aload #6
    //   1103: astore_1
    //   1104: aload_3
    //   1105: ldc 'onekey1.cmpassport.com'
    //   1107: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1110: ifeq -> 1212
    //   1113: aload #4
    //   1115: arraylength
    //   1116: istore #12
    //   1118: iconst_0
    //   1119: istore #13
    //   1121: aload #6
    //   1123: astore_1
    //   1124: iload #13
    //   1126: iload #12
    //   1128: if_icmpge -> 1146
    //   1131: aload #4
    //   1133: iload #13
    //   1135: aaload
    //   1136: astore_1
    //   1137: aload_1
    //   1138: ldc 'onekey1.cmpassport.com'
    //   1140: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1143: ifeq -> 2025
    //   1146: aload_1
    //   1147: astore #6
    //   1149: aload_1
    //   1150: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1153: ifne -> 1174
    //   1156: aload_1
    //   1157: aload_1
    //   1158: ldc ':'
    //   1160: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1163: aload_1
    //   1164: ldc ','
    //   1166: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1169: invokevirtual substring : (II)Ljava/lang/String;
    //   1172: astore #6
    //   1174: new java/lang/StringBuilder
    //   1177: astore_1
    //   1178: aload_1
    //   1179: invokespecial <init> : ()V
    //   1182: ldc 'UmcConfigUtil'
    //   1184: aload_1
    //   1185: ldc 'CERT:'
    //   1187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: aload #6
    //   1192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: invokevirtual toString : ()Ljava/lang/String;
    //   1198: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1201: aload_0
    //   1202: ldc 'https://onekey1.cmpassport.com:443/unisdk/'
    //   1204: aload #6
    //   1206: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1209: aload #6
    //   1211: astore_1
    //   1212: aload_2
    //   1213: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1216: ifne -> 2201
    //   1219: aload_2
    //   1220: ldc ':'
    //   1222: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1225: ifeq -> 2201
    //   1228: aload_2
    //   1229: iconst_0
    //   1230: aload_2
    //   1231: ldc ':'
    //   1233: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1236: invokevirtual substring : (II)Ljava/lang/String;
    //   1239: astore #9
    //   1241: new java/lang/StringBuilder
    //   1244: astore #6
    //   1246: aload #6
    //   1248: invokespecial <init> : ()V
    //   1251: ldc 'UmcConfigUtil'
    //   1253: aload #6
    //   1255: ldc 'smsHttpsHostWithoutPort:'
    //   1257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: aload #9
    //   1262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: invokevirtual toString : ()Ljava/lang/String;
    //   1268: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1271: aload_1
    //   1272: astore #6
    //   1274: aload_2
    //   1275: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1278: ifne -> 1432
    //   1281: aload_1
    //   1282: astore #6
    //   1284: aload_3
    //   1285: aload #9
    //   1287: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1290: ifeq -> 1432
    //   1293: aload #4
    //   1295: arraylength
    //   1296: istore #12
    //   1298: iconst_0
    //   1299: istore #13
    //   1301: aload_1
    //   1302: astore #6
    //   1304: iload #13
    //   1306: iload #12
    //   1308: if_icmpge -> 1335
    //   1311: aload #4
    //   1313: iload #13
    //   1315: aaload
    //   1316: astore #6
    //   1318: aload_2
    //   1319: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1322: ifne -> 2031
    //   1325: aload #6
    //   1327: aload #9
    //   1329: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1332: ifeq -> 2031
    //   1335: aload #6
    //   1337: astore_1
    //   1338: aload #6
    //   1340: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1343: ifne -> 1366
    //   1346: aload #6
    //   1348: aload #6
    //   1350: ldc ':'
    //   1352: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1355: aload #6
    //   1357: ldc ','
    //   1359: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1362: invokevirtual substring : (II)Ljava/lang/String;
    //   1365: astore_1
    //   1366: new java/lang/StringBuilder
    //   1369: astore #6
    //   1371: aload #6
    //   1373: invokespecial <init> : ()V
    //   1376: ldc 'UmcConfigUtil'
    //   1378: aload #6
    //   1380: ldc 'CERT:'
    //   1382: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload_1
    //   1386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: invokevirtual toString : ()Ljava/lang/String;
    //   1392: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1395: new java/lang/StringBuilder
    //   1398: astore #6
    //   1400: aload #6
    //   1402: invokespecial <init> : ()V
    //   1405: aload_0
    //   1406: aload #6
    //   1408: ldc 'https://'
    //   1410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload_2
    //   1414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: ldc '/unisdk/'
    //   1419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: invokevirtual toString : ()Ljava/lang/String;
    //   1425: aload_1
    //   1426: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1429: aload_1
    //   1430: astore #6
    //   1432: aload_3
    //   1433: ldc 'smsks1.cmpassport.com'
    //   1435: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1438: ifeq -> 1534
    //   1441: aload #4
    //   1443: arraylength
    //   1444: istore #12
    //   1446: iconst_0
    //   1447: istore #13
    //   1449: iload #13
    //   1451: iload #12
    //   1453: if_icmpge -> 2195
    //   1456: aload #4
    //   1458: iload #13
    //   1460: aaload
    //   1461: astore_1
    //   1462: aload_1
    //   1463: ldc 'smsks1.cmpassport.com'
    //   1465: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1468: ifeq -> 2037
    //   1471: aload_1
    //   1472: astore #6
    //   1474: aload_1
    //   1475: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1478: ifne -> 1499
    //   1481: aload_1
    //   1482: aload_1
    //   1483: ldc ':'
    //   1485: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1488: aload_1
    //   1489: ldc ','
    //   1491: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1494: invokevirtual substring : (II)Ljava/lang/String;
    //   1497: astore #6
    //   1499: new java/lang/StringBuilder
    //   1502: astore_1
    //   1503: aload_1
    //   1504: invokespecial <init> : ()V
    //   1507: ldc 'UmcConfigUtil'
    //   1509: aload_1
    //   1510: ldc 'CERT:'
    //   1512: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: aload #6
    //   1517: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: invokevirtual toString : ()Ljava/lang/String;
    //   1523: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1526: aload_0
    //   1527: ldc 'https://smsks1.cmpassport.com:443/unisdk/'
    //   1529: aload #6
    //   1531: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1534: aload #10
    //   1536: ldc 'CLOSE_CERT_VERIFY'
    //   1538: invokevirtual has : (Ljava/lang/String;)Z
    //   1541: ifeq -> 2043
    //   1544: aload_0
    //   1545: ldc 'CLOSE_CERT_VERIFY'
    //   1547: aload #10
    //   1549: ldc 'CLOSE_CERT_VERIFY'
    //   1551: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1554: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1557: aload #10
    //   1559: ldc 'CLOSE_FRIEND_WAPKS'
    //   1561: invokevirtual has : (Ljava/lang/String;)Z
    //   1564: ifeq -> 2068
    //   1567: aload_0
    //   1568: ldc 'CLOSE_FRIEND_WAPKS'
    //   1570: aload #10
    //   1572: ldc 'CLOSE_FRIEND_WAPKS'
    //   1574: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1577: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1580: aload #10
    //   1582: ldc 'CLOSE_LOGS_VERSION'
    //   1584: invokevirtual has : (Ljava/lang/String;)Z
    //   1587: ifeq -> 2079
    //   1590: aload_0
    //   1591: ldc 'CLOSE_LOGS_VERSION'
    //   1593: aload #10
    //   1595: ldc 'CLOSE_LOGS_VERSION'
    //   1597: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1600: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1603: aload #10
    //   1605: ldc 'LOGS_CONTROL'
    //   1607: invokevirtual has : (Ljava/lang/String;)Z
    //   1610: ifeq -> 2090
    //   1613: aload #10
    //   1615: ldc 'LOGS_CONTROL'
    //   1617: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1620: ldc 'h'
    //   1622: ldc ''
    //   1624: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1627: ldc '&'
    //   1629: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1632: astore_1
    //   1633: aload_1
    //   1634: arraylength
    //   1635: ifle -> 1650
    //   1638: aload_0
    //   1639: ldc 'maxFailedLogTimes'
    //   1641: aload_1
    //   1642: iconst_0
    //   1643: aaload
    //   1644: invokestatic parseInt : (Ljava/lang/String;)I
    //   1647: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)V
    //   1650: iconst_1
    //   1651: aload_1
    //   1652: arraylength
    //   1653: if_icmpge -> 1668
    //   1656: aload_0
    //   1657: ldc 'pauseTime'
    //   1659: aload_1
    //   1660: iconst_1
    //   1661: aaload
    //   1662: invokestatic parseInt : (Ljava/lang/String;)I
    //   1665: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)V
    //   1668: aload #10
    //   1670: ldc 'CLOSE_IPV4_LIST'
    //   1672: invokevirtual has : (Ljava/lang/String;)Z
    //   1675: ifeq -> 2107
    //   1678: aload_0
    //   1679: ldc 'CLOSE_IPV4_LIST'
    //   1681: aload #10
    //   1683: ldc 'CLOSE_IPV4_LIST'
    //   1685: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1688: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1691: aload #10
    //   1693: ldc 'CLOSE_IPV6_LIST'
    //   1695: invokevirtual has : (Ljava/lang/String;)Z
    //   1698: ifeq -> 2118
    //   1701: aload_0
    //   1702: ldc 'CLOSE_IPV6_LIST'
    //   1704: aload #10
    //   1706: ldc 'CLOSE_IPV6_LIST'
    //   1708: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1711: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1714: aload #10
    //   1716: ldc 'CLOSE_M001_SDKVERSION_LIST'
    //   1718: invokevirtual has : (Ljava/lang/String;)Z
    //   1721: ifeq -> 2129
    //   1724: aload_0
    //   1725: ldc 'CLOSE_M001_SDKVERSION_LIST'
    //   1727: aload #10
    //   1729: ldc 'CLOSE_M001_SDKVERSION_LIST'
    //   1731: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1734: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1737: aload #10
    //   1739: ldc 'CLOSE_M001_APPID_LIST'
    //   1741: invokevirtual has : (Ljava/lang/String;)Z
    //   1744: ifeq -> 2140
    //   1747: aload_0
    //   1748: ldc 'CLOSE_M001_APPID_LIST'
    //   1750: aload #10
    //   1752: ldc 'CLOSE_M001_APPID_LIST'
    //   1754: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1757: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1760: aload #10
    //   1762: ldc 'CLOSE_M003_SDKVERSION_LIST'
    //   1764: invokevirtual has : (Ljava/lang/String;)Z
    //   1767: ifeq -> 2151
    //   1770: aload_0
    //   1771: ldc 'CLOSE_M003_SDKVERSION_LIST'
    //   1773: aload #10
    //   1775: ldc 'CLOSE_M003_SDKVERSION_LIST'
    //   1777: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1780: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1783: aload #10
    //   1785: ldc 'CLOSE_M003_APPID_LIST'
    //   1787: invokevirtual has : (Ljava/lang/String;)Z
    //   1790: ifeq -> 2162
    //   1793: aload_0
    //   1794: ldc 'CLOSE_M003_APPID_LIST'
    //   1796: aload #10
    //   1798: ldc 'CLOSE_M003_APPID_LIST'
    //   1800: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1803: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1806: aload #10
    //   1808: ldc 'CLOSE_M005_SDKVERSION_LIST'
    //   1810: invokevirtual has : (Ljava/lang/String;)Z
    //   1813: ifeq -> 2173
    //   1816: aload_0
    //   1817: ldc 'CLOSE_M005_SDKVERSION_LIST'
    //   1819: aload #10
    //   1821: ldc 'CLOSE_M005_SDKVERSION_LIST'
    //   1823: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1826: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1829: aload #10
    //   1831: ldc 'CLOSE_M005_APPID_LIST'
    //   1833: invokevirtual has : (Ljava/lang/String;)Z
    //   1836: ifeq -> 2184
    //   1839: aload_0
    //   1840: ldc 'CLOSE_M005_APPID_LIST'
    //   1842: aload #10
    //   1844: ldc 'CLOSE_M005_APPID_LIST'
    //   1846: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1849: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1852: ldc com/cmic/sso/sdk/utils/aa
    //   1854: monitorexit
    //   1855: return
    //   1856: iinc #13, 1
    //   1859: goto -> 143
    //   1862: aload_2
    //   1863: ldc 'https'
    //   1865: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1868: ifne -> 1880
    //   1871: aload_2
    //   1872: ldc 'HTTPS'
    //   1874: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1877: ifeq -> 1903
    //   1880: aload_2
    //   1881: aload_2
    //   1882: ldc '='
    //   1884: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   1887: iconst_1
    //   1888: iadd
    //   1889: aload_2
    //   1890: invokevirtual length : ()I
    //   1893: invokevirtual substring : (II)Ljava/lang/String;
    //   1896: astore_1
    //   1897: aload_3
    //   1898: astore #6
    //   1900: goto -> 223
    //   1903: aload_2
    //   1904: ldc 'http'
    //   1906: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1909: ifne -> 1927
    //   1912: aload_3
    //   1913: astore #6
    //   1915: aload #4
    //   1917: astore_1
    //   1918: aload_2
    //   1919: ldc 'HTTP'
    //   1921: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1924: ifeq -> 223
    //   1927: aload_2
    //   1928: aload_2
    //   1929: ldc '='
    //   1931: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   1934: iconst_1
    //   1935: iadd
    //   1936: aload_2
    //   1937: invokevirtual length : ()I
    //   1940: invokevirtual substring : (II)Ljava/lang/String;
    //   1943: astore #6
    //   1945: aload #4
    //   1947: astore_1
    //   1948: goto -> 223
    //   1951: iinc #13, 1
    //   1954: goto -> 299
    //   1957: iinc #13, 1
    //   1960: goto -> 425
    //   1963: aload_0
    //   1964: ldc 'httpHost'
    //   1966: ldc ''
    //   1968: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1971: aload_0
    //   1972: ldc 'httpsHost'
    //   1974: ldc ''
    //   1976: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1979: aload_0
    //   1980: ldc 'logHost'
    //   1982: ldc ''
    //   1984: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1987: aload_0
    //   1988: ldc 'smsHost'
    //   1990: ldc ''
    //   1992: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1995: aconst_null
    //   1996: astore_2
    //   1997: aload_3
    //   1998: astore #9
    //   2000: aload #6
    //   2002: astore #5
    //   2004: goto -> 522
    //   2007: iinc #13, 1
    //   2010: goto -> 647
    //   2013: iinc #13, 1
    //   2016: goto -> 788
    //   2019: iinc #13, 1
    //   2022: goto -> 973
    //   2025: iinc #13, 1
    //   2028: goto -> 1121
    //   2031: iinc #13, 1
    //   2034: goto -> 1301
    //   2037: iinc #13, 1
    //   2040: goto -> 1449
    //   2043: aload_0
    //   2044: ldc 'CLOSE_CERT_VERIFY'
    //   2046: ldc '0'
    //   2048: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2051: goto -> 1557
    //   2054: astore_0
    //   2055: ldc com/cmic/sso/sdk/utils/aa
    //   2057: monitorexit
    //   2058: aload_0
    //   2059: athrow
    //   2060: astore_0
    //   2061: aload_0
    //   2062: invokevirtual printStackTrace : ()V
    //   2065: goto -> 1855
    //   2068: aload_0
    //   2069: ldc 'CLOSE_FRIEND_WAPKS'
    //   2071: ldc '0'
    //   2073: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2076: goto -> 1580
    //   2079: aload_0
    //   2080: ldc 'CLOSE_LOGS_VERSION'
    //   2082: ldc '0'
    //   2084: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2087: goto -> 1603
    //   2090: aload_0
    //   2091: ldc 'maxFailedLogTimes'
    //   2093: iconst_0
    //   2094: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)V
    //   2097: aload_0
    //   2098: ldc 'pauseTime'
    //   2100: iconst_0
    //   2101: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)V
    //   2104: goto -> 1668
    //   2107: aload_0
    //   2108: ldc 'CLOSE_IPV4_LIST'
    //   2110: ldc '0'
    //   2112: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2115: goto -> 1691
    //   2118: aload_0
    //   2119: ldc 'CLOSE_IPV6_LIST'
    //   2121: ldc '1'
    //   2123: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2126: goto -> 1714
    //   2129: aload_0
    //   2130: ldc 'CLOSE_M001_SDKVERSION_LIST'
    //   2132: ldc '0'
    //   2134: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2137: goto -> 1737
    //   2140: aload_0
    //   2141: ldc 'CLOSE_M001_APPID_LIST'
    //   2143: ldc '0'
    //   2145: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2148: goto -> 1760
    //   2151: aload_0
    //   2152: ldc 'CLOSE_M003_SDKVERSION_LIST'
    //   2154: ldc '0'
    //   2156: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2159: goto -> 1783
    //   2162: aload_0
    //   2163: ldc 'CLOSE_M003_APPID_LIST'
    //   2165: ldc '0'
    //   2167: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2170: goto -> 1806
    //   2173: aload_0
    //   2174: ldc 'CLOSE_M005_SDKVERSION_LIST'
    //   2176: ldc '0'
    //   2178: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2181: goto -> 1829
    //   2184: aload_0
    //   2185: ldc 'CLOSE_M005_APPID_LIST'
    //   2187: ldc '0'
    //   2189: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   2192: goto -> 1852
    //   2195: aload #6
    //   2197: astore_1
    //   2198: goto -> 1471
    //   2201: aload_2
    //   2202: astore #9
    //   2204: goto -> 1271
    //   2207: aload #9
    //   2209: astore #8
    //   2211: goto -> 942
    //   2214: aload #5
    //   2216: astore #8
    //   2218: goto -> 616
    //   2221: aconst_null
    //   2222: astore_2
    //   2223: goto -> 164
    // Exception table:
    //   from	to	target	type
    //   22	25	2060	java/lang/Exception
    //   25	78	2054	finally
    //   78	114	2054	finally
    //   118	140	2054	finally
    //   155	164	2054	finally
    //   170	223	2054	finally
    //   223	274	2054	finally
    //   274	296	2054	finally
    //   316	326	2054	finally
    //   330	359	2054	finally
    //   359	397	2054	finally
    //   400	422	2054	finally
    //   442	452	2054	finally
    //   455	483	2054	finally
    //   483	519	2054	finally
    //   522	540	2054	finally
    //   545	616	2054	finally
    //   619	627	2054	finally
    //   630	644	2054	finally
    //   663	680	2054	finally
    //   683	708	2054	finally
    //   708	768	2054	finally
    //   771	785	2054	finally
    //   804	813	2054	finally
    //   816	841	2054	finally
    //   841	876	2054	finally
    //   879	942	2054	finally
    //   945	953	2054	finally
    //   956	970	2054	finally
    //   990	1008	2054	finally
    //   1012	1041	2054	finally
    //   1041	1101	2054	finally
    //   1104	1118	2054	finally
    //   1137	1146	2054	finally
    //   1149	1174	2054	finally
    //   1174	1209	2054	finally
    //   1212	1271	2054	finally
    //   1274	1281	2054	finally
    //   1284	1298	2054	finally
    //   1318	1335	2054	finally
    //   1338	1366	2054	finally
    //   1366	1429	2054	finally
    //   1432	1446	2054	finally
    //   1462	1471	2054	finally
    //   1474	1499	2054	finally
    //   1499	1534	2054	finally
    //   1534	1557	2054	finally
    //   1557	1580	2054	finally
    //   1580	1603	2054	finally
    //   1603	1650	2054	finally
    //   1650	1668	2054	finally
    //   1668	1691	2054	finally
    //   1691	1714	2054	finally
    //   1714	1737	2054	finally
    //   1737	1760	2054	finally
    //   1760	1783	2054	finally
    //   1783	1806	2054	finally
    //   1806	1829	2054	finally
    //   1829	1852	2054	finally
    //   1852	1855	2054	finally
    //   1862	1880	2054	finally
    //   1880	1897	2054	finally
    //   1903	1912	2054	finally
    //   1918	1927	2054	finally
    //   1927	1945	2054	finally
    //   1963	1995	2054	finally
    //   2043	2051	2054	finally
    //   2055	2058	2054	finally
    //   2058	2060	2060	java/lang/Exception
    //   2068	2076	2054	finally
    //   2079	2087	2054	finally
    //   2090	2104	2054	finally
    //   2107	2115	2054	finally
    //   2118	2126	2054	finally
    //   2129	2137	2054	finally
    //   2140	2148	2054	finally
    //   2151	2159	2054	finally
    //   2162	2170	2054	finally
    //   2173	2181	2054	finally
    //   2184	2192	2054	finally
  }
  
  public static boolean b(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: ldc '1'
    //   5: aload_0
    //   6: ldc 'CLOSE_IPV4_LIST'
    //   8: ldc '0'
    //   10: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: invokevirtual equals : (Ljava/lang/Object;)Z
    //   16: istore_1
    //   17: ldc com/cmic/sso/sdk/utils/aa
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: astore_0
    //   23: iconst_0
    //   24: istore_1
    //   25: ldc com/cmic/sso/sdk/utils/aa
    //   27: monitorexit
    //   28: goto -> 20
    //   31: astore_0
    //   32: ldc com/cmic/sso/sdk/utils/aa
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	22	java/lang/Exception
    //   3	17	31	finally
    //   17	20	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static boolean c(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: ldc '1'
    //   5: aload_0
    //   6: ldc 'CLOSE_IPV6_LIST'
    //   8: ldc '1'
    //   10: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: invokevirtual equals : (Ljava/lang/Object;)Z
    //   16: istore_1
    //   17: ldc com/cmic/sso/sdk/utils/aa
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: astore_0
    //   23: iconst_1
    //   24: istore_1
    //   25: ldc com/cmic/sso/sdk/utils/aa
    //   27: monitorexit
    //   28: goto -> 20
    //   31: astore_0
    //   32: ldc com/cmic/sso/sdk/utils/aa
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	22	java/lang/Exception
    //   3	17	31	finally
    //   17	20	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static boolean d(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc com/cmic/sso/sdk/utils/aa
    //   6: monitorenter
    //   7: ldc '1'
    //   9: aload_0
    //   10: ldc 'CLOSE_M001_SDKVERSION_LIST'
    //   12: ldc '0'
    //   14: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual equals : (Ljava/lang/Object;)Z
    //   20: ifne -> 41
    //   23: ldc '1'
    //   25: aload_0
    //   26: ldc 'CLOSE_M001_APPID_LIST'
    //   28: ldc '0'
    //   30: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifeq -> 43
    //   41: iconst_1
    //   42: istore_2
    //   43: ldc com/cmic/sso/sdk/utils/aa
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual printStackTrace : ()V
    //   53: ldc com/cmic/sso/sdk/utils/aa
    //   55: monitorexit
    //   56: iload_1
    //   57: istore_2
    //   58: goto -> 46
    //   61: astore_0
    //   62: ldc com/cmic/sso/sdk/utils/aa
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   7	37	48	java/lang/Exception
    //   7	37	61	finally
    //   43	46	61	finally
    //   49	56	61	finally
    //   62	65	61	finally
  }
  
  public static boolean e(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc com/cmic/sso/sdk/utils/aa
    //   6: monitorenter
    //   7: ldc '1'
    //   9: aload_0
    //   10: ldc 'CLOSE_M003_SDKVERSION_LIST'
    //   12: ldc '0'
    //   14: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual equals : (Ljava/lang/Object;)Z
    //   20: ifne -> 41
    //   23: ldc '1'
    //   25: aload_0
    //   26: ldc 'CLOSE_M003_APPID_LIST'
    //   28: ldc '0'
    //   30: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifeq -> 43
    //   41: iconst_1
    //   42: istore_2
    //   43: ldc com/cmic/sso/sdk/utils/aa
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual printStackTrace : ()V
    //   53: ldc com/cmic/sso/sdk/utils/aa
    //   55: monitorexit
    //   56: iload_1
    //   57: istore_2
    //   58: goto -> 46
    //   61: astore_0
    //   62: ldc com/cmic/sso/sdk/utils/aa
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   7	37	48	java/lang/Exception
    //   7	37	61	finally
    //   43	46	61	finally
    //   49	56	61	finally
    //   62	65	61	finally
  }
  
  public static boolean f(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc com/cmic/sso/sdk/utils/aa
    //   6: monitorenter
    //   7: ldc '1'
    //   9: aload_0
    //   10: ldc 'CLOSE_M005_SDKVERSION_LIST'
    //   12: ldc '0'
    //   14: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: invokevirtual equals : (Ljava/lang/Object;)Z
    //   20: ifne -> 41
    //   23: ldc '1'
    //   25: aload_0
    //   26: ldc 'CLOSE_M005_APPID_LIST'
    //   28: ldc '0'
    //   30: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifeq -> 43
    //   41: iconst_1
    //   42: istore_2
    //   43: ldc com/cmic/sso/sdk/utils/aa
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual printStackTrace : ()V
    //   53: ldc com/cmic/sso/sdk/utils/aa
    //   55: monitorexit
    //   56: iload_1
    //   57: istore_2
    //   58: goto -> 46
    //   61: astore_0
    //   62: ldc com/cmic/sso/sdk/utils/aa
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   7	37	48	java/lang/Exception
    //   7	37	61	finally
    //   43	46	61	finally
    //   49	56	61	finally
    //   62	65	61	finally
  }
  
  public static String g(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'httpHost'
    //   6: aconst_null
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifeq -> 27
    //   18: ldc_w 'http://www.cmpassport.com/unisdk/'
    //   21: astore_0
    //   22: ldc com/cmic/sso/sdk/utils/aa
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: new java/lang/StringBuilder
    //   30: astore_0
    //   31: aload_0
    //   32: invokespecial <init> : ()V
    //   35: aload_0
    //   36: ldc_w 'http://'
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc '/unisdk/'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: astore_0
    //   55: goto -> 22
    //   58: astore_1
    //   59: new java/lang/StringBuilder
    //   62: astore_0
    //   63: aload_0
    //   64: invokespecial <init> : ()V
    //   67: ldc 'UmcConfigUtil'
    //   69: aload_0
    //   70: ldc_w 'http:'
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc_w 'http://www.cmpassport.com/unisdk/'
    //   92: astore_0
    //   93: ldc com/cmic/sso/sdk/utils/aa
    //   95: monitorexit
    //   96: goto -> 25
    //   99: astore_0
    //   100: ldc com/cmic/sso/sdk/utils/aa
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	58	java/lang/Exception
    //   3	18	99	finally
    //   22	25	99	finally
    //   27	55	58	java/lang/Exception
    //   27	55	99	finally
    //   59	89	99	finally
    //   93	96	99	finally
    //   100	103	99	finally
  }
  
  public static String h(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'httpsHost'
    //   6: aconst_null
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifeq -> 26
    //   18: ldc 'https://onekey1.cmpassport.com:443/unisdk/'
    //   20: astore_0
    //   21: ldc com/cmic/sso/sdk/utils/aa
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: new java/lang/StringBuilder
    //   29: astore_0
    //   30: aload_0
    //   31: invokespecial <init> : ()V
    //   34: aload_0
    //   35: ldc 'https://'
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc '/unisdk/'
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: astore_0
    //   53: goto -> 21
    //   56: astore_0
    //   57: new java/lang/StringBuilder
    //   60: astore_1
    //   61: aload_1
    //   62: invokespecial <init> : ()V
    //   65: ldc 'UmcConfigUtil'
    //   67: aload_1
    //   68: ldc_w 'https:'
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   87: ldc 'https://onekey1.cmpassport.com:443/unisdk/'
    //   89: astore_0
    //   90: ldc com/cmic/sso/sdk/utils/aa
    //   92: monitorexit
    //   93: goto -> 24
    //   96: astore_0
    //   97: ldc com/cmic/sso/sdk/utils/aa
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	56	java/lang/Exception
    //   3	18	96	finally
    //   21	24	96	finally
    //   26	53	56	java/lang/Exception
    //   26	53	96	finally
    //   57	87	96	finally
    //   90	93	96	finally
    //   97	100	96	finally
  }
  
  public static String i(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'logHost'
    //   6: ldc ''
    //   8: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   16: ifeq -> 27
    //   19: ldc 'https://log1.cmpassport.com:9443/log/logReport'
    //   21: astore_0
    //   22: ldc com/cmic/sso/sdk/utils/aa
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: new java/lang/StringBuilder
    //   30: astore_1
    //   31: aload_1
    //   32: invokespecial <init> : ()V
    //   35: aload_1
    //   36: ldc 'https://'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc '/log/logReport'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: astore_0
    //   54: goto -> 22
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual printStackTrace : ()V
    //   62: ldc 'https://log1.cmpassport.com:9443/log/logReport'
    //   64: astore_0
    //   65: ldc com/cmic/sso/sdk/utils/aa
    //   67: monitorexit
    //   68: goto -> 25
    //   71: astore_0
    //   72: ldc com/cmic/sso/sdk/utils/aa
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	57	java/lang/Exception
    //   3	19	71	finally
    //   22	25	71	finally
    //   27	54	57	java/lang/Exception
    //   27	54	71	finally
    //   58	62	71	finally
    //   65	68	71	finally
    //   72	75	71	finally
  }
  
  public static String j(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'smsHost'
    //   6: ldc ''
    //   8: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   16: ifeq -> 27
    //   19: ldc 'https://smsks1.cmpassport.com:443/unisdk/'
    //   21: astore_0
    //   22: ldc com/cmic/sso/sdk/utils/aa
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: new java/lang/StringBuilder
    //   30: astore_1
    //   31: aload_1
    //   32: invokespecial <init> : ()V
    //   35: aload_1
    //   36: ldc 'https://'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc '/unisdk/'
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: astore_0
    //   54: goto -> 22
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual printStackTrace : ()V
    //   62: ldc 'https://smsks1.cmpassport.com:443/unisdk/'
    //   64: astore_0
    //   65: ldc com/cmic/sso/sdk/utils/aa
    //   67: monitorexit
    //   68: goto -> 25
    //   71: astore_0
    //   72: ldc com/cmic/sso/sdk/utils/aa
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	57	java/lang/Exception
    //   3	19	71	finally
    //   22	25	71	finally
    //   27	54	57	java/lang/Exception
    //   27	54	71	finally
    //   58	62	71	finally
    //   65	68	71	finally
    //   72	75	71	finally
  }
  
  public static boolean k(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: ldc '1'
    //   5: aload_0
    //   6: ldc 'CLOSE_CERT_VERIFY'
    //   8: ldc '1'
    //   10: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: invokevirtual equals : (Ljava/lang/Object;)Z
    //   16: istore_1
    //   17: ldc com/cmic/sso/sdk/utils/aa
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: astore_2
    //   23: new java/lang/StringBuilder
    //   26: astore_0
    //   27: aload_0
    //   28: invokespecial <init> : ()V
    //   31: ldc 'UmcConfigUtil'
    //   33: aload_0
    //   34: ldc_w 'isCloseCert:'
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_2
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   53: iconst_1
    //   54: istore_1
    //   55: ldc com/cmic/sso/sdk/utils/aa
    //   57: monitorexit
    //   58: goto -> 20
    //   61: astore_0
    //   62: ldc com/cmic/sso/sdk/utils/aa
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	22	java/lang/Exception
    //   3	17	61	finally
    //   17	20	61	finally
    //   23	53	61	finally
    //   55	58	61	finally
    //   62	65	61	finally
  }
  
  public static boolean l(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'CLOSE_FRIEND_WAPKS'
    //   6: ldc ''
    //   8: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: ldc_w 'CU'
    //   14: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   17: istore_1
    //   18: ldc com/cmic/sso/sdk/utils/aa
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: astore_2
    //   24: new java/lang/StringBuilder
    //   27: astore_0
    //   28: aload_0
    //   29: invokespecial <init> : ()V
    //   32: ldc 'UmcConfigUtil'
    //   34: aload_0
    //   35: ldc_w 'isCloseCUCCWork:'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual toString : ()Ljava/lang/String;
    //   51: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: iconst_0
    //   55: istore_1
    //   56: ldc com/cmic/sso/sdk/utils/aa
    //   58: monitorexit
    //   59: goto -> 21
    //   62: astore_0
    //   63: ldc com/cmic/sso/sdk/utils/aa
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	23	java/lang/Exception
    //   3	18	62	finally
    //   18	21	62	finally
    //   24	54	62	finally
    //   56	59	62	finally
    //   63	66	62	finally
  }
  
  public static boolean m(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'CLOSE_FRIEND_WAPKS'
    //   6: ldc ''
    //   8: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: ldc_w 'CT'
    //   14: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   17: istore_1
    //   18: ldc com/cmic/sso/sdk/utils/aa
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: astore_0
    //   24: iconst_0
    //   25: istore_1
    //   26: ldc com/cmic/sso/sdk/utils/aa
    //   28: monitorexit
    //   29: goto -> 21
    //   32: astore_0
    //   33: ldc com/cmic/sso/sdk/utils/aa
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	23	java/lang/Exception
    //   3	18	32	finally
    //   18	21	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public static boolean n(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: ldc '1'
    //   5: aload_0
    //   6: ldc 'CLOSE_LOGS_VERSION'
    //   8: ldc '0'
    //   10: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   13: invokevirtual equals : (Ljava/lang/Object;)Z
    //   16: istore_1
    //   17: ldc com/cmic/sso/sdk/utils/aa
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: astore_0
    //   23: iconst_0
    //   24: istore_1
    //   25: ldc com/cmic/sso/sdk/utils/aa
    //   27: monitorexit
    //   28: goto -> 20
    //   31: astore_0
    //   32: ldc com/cmic/sso/sdk/utils/aa
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	17	22	java/lang/Exception
    //   3	17	31	finally
    //   17	20	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static int o(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'maxFailedLogTimes'
    //   6: iconst_0
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)I
    //   10: istore_1
    //   11: ldc com/cmic/sso/sdk/utils/aa
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_0
    //   17: ldc com/cmic/sso/sdk/utils/aa
    //   19: monitorexit
    //   20: aload_0
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	16	finally
    //   17	20	16	finally
  }
  
  public static int p(Context paramContext) {
    // Byte code:
    //   0: ldc com/cmic/sso/sdk/utils/aa
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 'pauseTime'
    //   6: iconst_0
    //   7: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)I
    //   10: istore_1
    //   11: ldc com/cmic/sso/sdk/utils/aa
    //   13: monitorexit
    //   14: iload_1
    //   15: bipush #60
    //   17: imul
    //   18: bipush #60
    //   20: imul
    //   21: sipush #1000
    //   24: imul
    //   25: ireturn
    //   26: astore_0
    //   27: ldc com/cmic/sso/sdk/utils/aa
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	26	finally
    //   27	30	26	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */