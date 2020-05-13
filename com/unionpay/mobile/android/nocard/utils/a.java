package com.unionpay.mobile.android.nocard.utils;

import android.content.Intent;
import android.os.Bundle;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a {
  private static String a(Bundle paramBundle) {
    String str2 = null;
    String str3 = str2;
    if (paramBundle != null)
      if (paramBundle.containsKey("paydata")) {
        str3 = paramBundle.getString("paydata");
      } else {
        str3 = str2;
        if (paramBundle.containsKey("tn"))
          str3 = paramBundle.getString("tn"); 
      }  
    String str1 = str3;
    if (str3 == null)
      str1 = ""; 
    return str1;
  }
  
  private static String a(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 'uppay'
    //   4: ldc 'decodePayInfo +++ \\n'
    //   6: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: ifnull -> 124
    //   14: aload_0
    //   15: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 'uppay'
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: ldc 'url deocode result:'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: ifnull -> 109
    //   45: aload_0
    //   46: invokestatic a : (Ljava/lang/String;)[B
    //   49: astore_0
    //   50: aload_1
    //   51: astore_2
    //   52: aload_0
    //   53: ifnull -> 67
    //   56: new java/lang/String
    //   59: astore_2
    //   60: aload_2
    //   61: aload_0
    //   62: ldc 'UTF-8'
    //   64: invokespecial <init> : ([BLjava/lang/String;)V
    //   67: ldc 'uppay'
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: ldc 'order info:'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: aload_2
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc '\\n'
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: ldc 'uppay'
    //   96: ldc 'decodePayInfo --- \\n'
    //   98: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: aload_2
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual printStackTrace : ()V
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -> 50
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual printStackTrace : ()V
    //   119: aload_1
    //   120: astore_2
    //   121: goto -> 67
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   45	50	104	java/io/IOException
    //   56	67	114	java/io/UnsupportedEncodingException
  }
  
  public static boolean a(Intent paramIntent, b paramb) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore #4
    //   7: aload_0
    //   8: ifnonnull -> 18
    //   11: iload #4
    //   13: istore #5
    //   15: iload #5
    //   17: ireturn
    //   18: ldc 'uppay'
    //   20: new java/lang/StringBuilder
    //   23: dup
    //   24: ldc ' ===>'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: aload_0
    //   44: invokevirtual getDataString : ()Ljava/lang/String;
    //   47: astore #6
    //   49: aload_0
    //   50: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull -> 402
    //   58: aload_0
    //   59: ldc 'reqOriginalId'
    //   61: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   64: ifeq -> 402
    //   67: ldc 'uppay'
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: ldc ' bundle===>'
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   91: pop
    //   92: aload_1
    //   93: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   96: aload_0
    //   97: ldc 'reqOriginalId'
    //   99: invokevirtual getInt : (Ljava/lang/String;)I
    //   102: putfield a : I
    //   105: ldc 'uppay'
    //   107: new java/lang/StringBuilder
    //   110: dup
    //   111: ldc 'reqID:'
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: aload_1
    //   117: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   120: getfield a : I
    //   123: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload_1
    //   134: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   137: aload_0
    //   138: ldc 'invokedbyplugin'
    //   140: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   143: putfield e : Z
    //   146: aload_0
    //   147: ifnull -> 459
    //   150: aload_1
    //   151: aload_0
    //   152: ldc 'dlgstyle'
    //   154: iconst_0
    //   155: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   158: putfield aM : Z
    //   161: aload_0
    //   162: ldc 'url_index'
    //   164: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   167: astore #7
    //   169: aload #7
    //   171: ifnull -> 191
    //   174: aload #7
    //   176: invokestatic c : (Ljava/lang/String;)Z
    //   179: ifeq -> 191
    //   182: aload_1
    //   183: aload #7
    //   185: invokestatic parseInt : (Ljava/lang/String;)I
    //   188: putfield aO : I
    //   191: aload_0
    //   192: ldc 'server'
    //   194: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   197: astore #7
    //   199: aload #7
    //   201: ifnull -> 218
    //   204: aload #7
    //   206: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   209: ifne -> 218
    //   212: aload_1
    //   213: aload #7
    //   215: putfield bk : Ljava/lang/String;
    //   218: aload_0
    //   219: ldc 'navbargb'
    //   221: ldc -10705958
    //   223: invokevirtual getInt : (Ljava/lang/String;I)I
    //   226: putstatic com/unionpay/mobile/android/global/a.M : I
    //   229: aload_0
    //   230: ldc 'divlinecolor'
    //   232: ldc -13268007
    //   234: invokevirtual getInt : (Ljava/lang/String;I)I
    //   237: putstatic com/unionpay/mobile/android/global/a.N : I
    //   240: aload_1
    //   241: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   244: getfield a : I
    //   247: lookupswitch default -> 312, 0 -> 477, 1 -> 741, 2 -> 477, 3 -> 804, 4 -> 917, 5 -> 972, 1000 -> 961
    //   312: iload_2
    //   313: istore #5
    //   315: aload_1
    //   316: getfield aM : Z
    //   319: ifeq -> 343
    //   322: getstatic com/unionpay/mobile/android/model/b.bm : Z
    //   325: ifne -> 343
    //   328: iconst_m1
    //   329: putstatic com/unionpay/mobile/android/global/b.b : I
    //   332: ldc -2513882
    //   334: putstatic com/unionpay/mobile/android/global/b.c : I
    //   337: sipush #-6745
    //   340: putstatic com/unionpay/mobile/android/global/b.d : I
    //   343: aload_1
    //   344: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   347: getfield a : I
    //   350: iconst_2
    //   351: if_icmpeq -> 376
    //   354: aload_1
    //   355: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   358: getfield a : I
    //   361: iconst_5
    //   362: if_icmpeq -> 376
    //   365: aload_1
    //   366: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   369: getfield a : I
    //   372: iconst_3
    //   373: if_icmpne -> 384
    //   376: aload_1
    //   377: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   380: iconst_1
    //   381: putfield d : Z
    //   384: aload_1
    //   385: getfield c : Z
    //   388: ifeq -> 1100
    //   391: ldc '1.9'
    //   393: astore_0
    //   394: aload_1
    //   395: aload_0
    //   396: putfield a : Ljava/lang/String;
    //   399: goto -> 15
    //   402: iload #4
    //   404: istore #5
    //   406: aload #6
    //   408: ifnull -> 15
    //   411: iload #4
    //   413: istore #5
    //   415: aload #6
    //   417: invokevirtual length : ()I
    //   420: ifle -> 15
    //   423: aload_1
    //   424: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   427: sipush #1000
    //   430: putfield a : I
    //   433: ldc 'uppay'
    //   435: new java/lang/StringBuilder
    //   438: dup
    //   439: ldc 'nativeBrowser data:'
    //   441: invokespecial <init> : (Ljava/lang/String;)V
    //   444: aload #6
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual toString : ()Ljava/lang/String;
    //   452: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   455: pop
    //   456: goto -> 146
    //   459: aload_1
    //   460: iconst_0
    //   461: putfield aM : Z
    //   464: ldc -10705958
    //   466: putstatic com/unionpay/mobile/android/global/a.M : I
    //   469: ldc -13268007
    //   471: putstatic com/unionpay/mobile/android/global/a.N : I
    //   474: goto -> 240
    //   477: aload_1
    //   478: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   481: aload_0
    //   482: ldc 'ex_mode'
    //   484: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   487: putfield c : Ljava/lang/String;
    //   490: ldc 'uppay'
    //   492: new java/lang/StringBuilder
    //   495: dup
    //   496: ldc 'mServerIdentifier = '
    //   498: invokespecial <init> : (Ljava/lang/String;)V
    //   501: aload_1
    //   502: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   505: getfield c : Ljava/lang/String;
    //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual toString : ()Ljava/lang/String;
    //   514: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   517: pop
    //   518: aload_1
    //   519: aload_0
    //   520: invokestatic a : (Landroid/os/Bundle;)Ljava/lang/String;
    //   523: putfield b : Ljava/lang/String;
    //   526: aload_1
    //   527: aload_0
    //   528: ldc 'appID'
    //   530: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   533: putfield g : Ljava/lang/String;
    //   536: aload_1
    //   537: getfield g : Ljava/lang/String;
    //   540: ifnonnull -> 549
    //   543: aload_1
    //   544: ldc ''
    //   546: putfield g : Ljava/lang/String;
    //   549: aload_0
    //   550: ldc 'source'
    //   552: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   555: astore #6
    //   557: aload #6
    //   559: ifnull -> 572
    //   562: aload #6
    //   564: ldc 'samsung_out'
    //   566: invokevirtual equals : (Ljava/lang/Object;)Z
    //   569: putstatic com/unionpay/mobile/android/model/b.bm : Z
    //   572: aload_0
    //   573: ldc 'frontNotifyByPlugin'
    //   575: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   578: astore #6
    //   580: aload #6
    //   582: ifnull -> 593
    //   585: aload #6
    //   587: invokevirtual length : ()I
    //   590: ifne -> 735
    //   593: iconst_1
    //   594: istore #5
    //   596: aload_1
    //   597: iload #5
    //   599: putfield U : Z
    //   602: iload_3
    //   603: istore #5
    //   605: aload_1
    //   606: getfield f : Z
    //   609: ifne -> 696
    //   612: iload_3
    //   613: istore #5
    //   615: aload_1
    //   616: getfield b : Ljava/lang/String;
    //   619: ifnull -> 696
    //   622: iload_3
    //   623: istore #5
    //   625: aload_1
    //   626: getfield b : Ljava/lang/String;
    //   629: invokevirtual trim : ()Ljava/lang/String;
    //   632: invokevirtual length : ()I
    //   635: ifle -> 696
    //   638: ldc 'uppay'
    //   640: new java/lang/StringBuilder
    //   643: dup
    //   644: ldc 'tn from bundle:'
    //   646: invokespecial <init> : (Ljava/lang/String;)V
    //   649: aload_1
    //   650: getfield b : Ljava/lang/String;
    //   653: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual toString : ()Ljava/lang/String;
    //   659: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   662: pop
    //   663: aload_1
    //   664: iconst_1
    //   665: putfield c : Z
    //   668: ldc 'uppay'
    //   670: new java/lang/StringBuilder
    //   673: dup
    //   674: ldc 'dw.isNewTypeTn='
    //   676: invokespecial <init> : (Ljava/lang/String;)V
    //   679: aload_1
    //   680: getfield c : Z
    //   683: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   686: invokevirtual toString : ()Ljava/lang/String;
    //   689: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   692: pop
    //   693: iconst_1
    //   694: istore #5
    //   696: aload_1
    //   697: aload_0
    //   698: ldc 'ResultURL'
    //   700: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   703: putfield r : Ljava/lang/String;
    //   706: ldc 'uppay'
    //   708: new java/lang/StringBuilder
    //   711: dup
    //   712: ldc_w 'result URL:'
    //   715: invokespecial <init> : (Ljava/lang/String;)V
    //   718: aload_1
    //   719: getfield r : Ljava/lang/String;
    //   722: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual toString : ()Ljava/lang/String;
    //   728: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   731: pop
    //   732: goto -> 315
    //   735: iconst_0
    //   736: istore #5
    //   738: goto -> 596
    //   741: aload_0
    //   742: ldc_w 'uppayuri'
    //   745: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   748: astore #6
    //   750: aload_1
    //   751: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   754: aload_0
    //   755: ldc_w 'resultIntentAction'
    //   758: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   761: putfield b : Ljava/lang/String;
    //   764: ldc 'uppay'
    //   766: new java/lang/StringBuilder
    //   769: dup
    //   770: ldc_w ' result Action='
    //   773: invokespecial <init> : (Ljava/lang/String;)V
    //   776: aload_1
    //   777: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   780: getfield b : Ljava/lang/String;
    //   783: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: invokevirtual toString : ()Ljava/lang/String;
    //   789: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   792: pop
    //   793: aload #6
    //   795: aload_1
    //   796: invokestatic a : (Ljava/lang/String;Lcom/unionpay/mobile/android/model/b;)Z
    //   799: istore #5
    //   801: goto -> 315
    //   804: aload_1
    //   805: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   808: aload_0
    //   809: ldc 'ex_mode'
    //   811: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   814: putfield c : Ljava/lang/String;
    //   817: aload_1
    //   818: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   821: aload_0
    //   822: ldc_w 'tencentUID'
    //   825: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   828: putfield g : Ljava/lang/String;
    //   831: aload_1
    //   832: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   835: aload_0
    //   836: ldc_w 'tencentWID'
    //   839: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   842: putfield h : Ljava/lang/String;
    //   845: aload_1
    //   846: aload_0
    //   847: invokestatic a : (Landroid/os/Bundle;)Ljava/lang/String;
    //   850: putfield b : Ljava/lang/String;
    //   853: iload_2
    //   854: istore #5
    //   856: aload_1
    //   857: getfield b : Ljava/lang/String;
    //   860: ifnull -> 315
    //   863: iload_2
    //   864: istore #5
    //   866: aload_1
    //   867: getfield b : Ljava/lang/String;
    //   870: invokevirtual trim : ()Ljava/lang/String;
    //   873: invokevirtual length : ()I
    //   876: ifle -> 315
    //   879: iload_2
    //   880: istore #5
    //   882: aload_1
    //   883: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   886: getfield h : Ljava/lang/String;
    //   889: ifnull -> 315
    //   892: iload_2
    //   893: istore #5
    //   895: aload_1
    //   896: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   899: getfield h : Ljava/lang/String;
    //   902: invokevirtual trim : ()Ljava/lang/String;
    //   905: invokevirtual length : ()I
    //   908: ifle -> 315
    //   911: iconst_1
    //   912: istore #5
    //   914: goto -> 315
    //   917: aload_0
    //   918: ldc 'paydata'
    //   920: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   923: astore_0
    //   924: ldc_w 'PluginEx'
    //   927: new java/lang/StringBuilder
    //   930: dup
    //   931: ldc_w ' paydata='
    //   934: invokespecial <init> : (Ljava/lang/String;)V
    //   937: aload_0
    //   938: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual toString : ()Ljava/lang/String;
    //   944: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   947: pop
    //   948: aload_0
    //   949: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   952: aload_1
    //   953: invokestatic b : (Ljava/lang/String;Lcom/unionpay/mobile/android/model/b;)Z
    //   956: istore #5
    //   958: goto -> 315
    //   961: aload #6
    //   963: aload_1
    //   964: invokestatic a : (Ljava/lang/String;Lcom/unionpay/mobile/android/model/b;)Z
    //   967: istore #5
    //   969: goto -> 315
    //   972: aload_1
    //   973: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   976: aload_0
    //   977: ldc 'ex_mode'
    //   979: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   982: putfield c : Ljava/lang/String;
    //   985: ldc 'uppay'
    //   987: new java/lang/StringBuilder
    //   990: dup
    //   991: ldc 'mServerIdentifier = '
    //   993: invokespecial <init> : (Ljava/lang/String;)V
    //   996: aload_1
    //   997: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   1000: getfield c : Ljava/lang/String;
    //   1003: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual toString : ()Ljava/lang/String;
    //   1009: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   1012: pop
    //   1013: aload_1
    //   1014: aload_0
    //   1015: ldc 'appID'
    //   1017: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1020: putfield g : Ljava/lang/String;
    //   1023: aload_1
    //   1024: getfield g : Ljava/lang/String;
    //   1027: ifnonnull -> 1036
    //   1030: aload_1
    //   1031: ldc ''
    //   1033: putfield g : Ljava/lang/String;
    //   1036: aload_1
    //   1037: aload_0
    //   1038: ldc_w 'amt'
    //   1041: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1044: putfield e : Ljava/lang/String;
    //   1047: aload_1
    //   1048: aload_0
    //   1049: ldc_w 'aid'
    //   1052: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   1055: putfield d : Ljava/lang/String;
    //   1058: aload_1
    //   1059: iconst_1
    //   1060: putfield f : Z
    //   1063: aload_1
    //   1064: iconst_1
    //   1065: putfield c : Z
    //   1068: iload_2
    //   1069: istore #5
    //   1071: aload_1
    //   1072: getfield e : Ljava/lang/String;
    //   1075: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1078: ifne -> 315
    //   1081: iload_2
    //   1082: istore #5
    //   1084: aload_1
    //   1085: getfield d : Ljava/lang/String;
    //   1088: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1091: ifne -> 315
    //   1094: iconst_1
    //   1095: istore #5
    //   1097: goto -> 315
    //   1100: ldc_w '1.4'
    //   1103: astore_0
    //   1104: goto -> 394
  }
  
  private static boolean a(String paramString, b paramb) {
    String[] arrayOfString1;
    String str2 = null;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      arrayOfString1 = paramString.split("\\?");
      if (arrayOfString1.length < 2) {
        k.c("uppay", "uppay protocol params error!");
        return bool1;
      } 
    } else {
      return bool2;
    } 
    String str1 = arrayOfString1[1];
    k.a("uppay", "parseUPPayURIParams() +++ ");
    k.a("uppay", str1);
    String[] arrayOfString2 = str1.split("&");
    int i = arrayOfString2.length;
    byte b1 = 0;
    for (str1 = null; b1 < i; str1 = str4) {
      String[] arrayOfString = arrayOfString2[b1].split("=");
      String str3 = str2;
      String str4 = str1;
      if (arrayOfString.length >= 2)
        if (arrayOfString[0].equalsIgnoreCase("style")) {
          str4 = arrayOfString[1];
          str3 = str2;
        } else {
          str3 = str2;
          str4 = str1;
          if (arrayOfString[0].equalsIgnoreCase("paydata")) {
            str3 = arrayOfString[1];
            str4 = str1;
          } 
        }  
      b1++;
      str2 = str3;
    } 
    if (str1 != null && str1.equalsIgnoreCase("token") && str2 != null) {
      k.a("uppay", "paydata=" + str2);
      bool2 = b(a(str2), paramb);
    } else {
      bool2 = false;
    } 
    k.a("uppay", "parseUPPayURIParams() ---");
    return bool2;
  }
  
  private static boolean b(String paramString, b paramb) {
    boolean bool = true;
    if (paramString == null || paramString.length() == 0)
      return false; 
    paramb.I.c = "00";
    String[] arrayOfString = paramString.split(",");
    int i = arrayOfString.length;
    for (byte b1 = 0; b1 < i; b1++) {
      String[] arrayOfString1 = arrayOfString[b1].trim().split("=");
      if (arrayOfString1.length >= 2)
        if (arrayOfString1[0].trim().equalsIgnoreCase("tn")) {
          paramb.b = arrayOfString1[1].trim();
        } else if (arrayOfString1[0].trim().equalsIgnoreCase("usetestmode")) {
          if (arrayOfString1[1].trim().equalsIgnoreCase("true")) {
            paramb.I.c = "01";
          } else if (arrayOfString1[1].trim().equalsIgnoreCase("test")) {
            paramb.I.c = "02";
          } else if (arrayOfString1[1].trim().equalsIgnoreCase("inner")) {
            paramb.I.c = "98";
          } 
        } else if (arrayOfString1[0].trim().equalsIgnoreCase("ResultURL")) {
          try {
            paramb.r = URLDecoder.decode(arrayOfString1[1].trim(), "UTF-8");
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
          } 
        }  
    } 
    if (paramb.b == null || paramb.b.length() <= 0)
      bool = false; 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocar\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */