package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Map;
import java.util.TreeMap;

public final class aa {
  Map a = new TreeMap<Object, Object>();
  
  Context b = null;
  
  String c;
  
  int d;
  
  private void a(String paramString) {
    try {
      u.c(paramString);
    } catch (Throwable throwable) {}
  }
  
  public boolean a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: ifnonnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield a : Ljava/util/Map;
    //   13: ifnonnull -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic a : ()Lcom/tencent/tp/k;
    //   21: astore_1
    //   22: aload_0
    //   23: getfield a : Ljava/util/Map;
    //   26: ldc 'AndroidId'
    //   28: aload_1
    //   29: aload_0
    //   30: getfield b : Landroid/content/Context;
    //   33: invokevirtual g : (Landroid/content/Context;)Ljava/lang/String;
    //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: getfield a : Ljava/util/Map;
    //   46: ldc 'ApiLevel'
    //   48: invokestatic c : ()Ljava/lang/String;
    //   51: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: getfield a : Ljava/util/Map;
    //   61: ldc 'Serial'
    //   63: aload_1
    //   64: aload_0
    //   65: getfield b : Landroid/content/Context;
    //   68: invokevirtual f : (Landroid/content/Context;)Ljava/lang/String;
    //   71: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload_0
    //   78: getfield a : Ljava/util/Map;
    //   81: ldc 'AppName'
    //   83: aload_0
    //   84: getfield b : Landroid/content/Context;
    //   87: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   90: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_0
    //   97: getfield a : Ljava/util/Map;
    //   100: ldc 'PackageName'
    //   102: aload_0
    //   103: getfield b : Landroid/content/Context;
    //   106: invokevirtual getPackageName : ()Ljava/lang/String;
    //   109: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: aload_0
    //   116: getfield a : Ljava/util/Map;
    //   119: ldc 'AppVer'
    //   121: aload_0
    //   122: getfield b : Landroid/content/Context;
    //   125: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   128: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: aload_0
    //   135: getfield a : Ljava/util/Map;
    //   138: ldc 'AppPubkeySha1'
    //   140: aload_0
    //   141: getfield b : Landroid/content/Context;
    //   144: invokestatic g : (Landroid/content/Context;)Ljava/lang/String;
    //   147: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload_0
    //   154: getfield a : Ljava/util/Map;
    //   157: ldc 'LauncherPubkeySha1'
    //   159: aload_1
    //   160: aload_0
    //   161: getfield b : Landroid/content/Context;
    //   164: invokevirtual l : (Landroid/content/Context;)Ljava/lang/String;
    //   167: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload_0
    //   174: getfield a : Ljava/util/Map;
    //   177: ldc 'BootTime'
    //   179: invokestatic b : ()Ljava/lang/String;
    //   182: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: aload_0
    //   189: getfield a : Ljava/util/Map;
    //   192: ldc 'Brand'
    //   194: aload_1
    //   195: aload_0
    //   196: getfield b : Landroid/content/Context;
    //   199: invokevirtual i : (Landroid/content/Context;)Ljava/lang/String;
    //   202: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   207: pop
    //   208: aload_0
    //   209: getfield a : Ljava/util/Map;
    //   212: ldc 'Fp'
    //   214: aload_1
    //   215: aload_0
    //   216: getfield b : Landroid/content/Context;
    //   219: invokevirtual h : (Landroid/content/Context;)Ljava/lang/String;
    //   222: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   227: pop
    //   228: aload_0
    //   229: getfield a : Ljava/util/Map;
    //   232: ldc 'Country'
    //   234: invokestatic e : ()Ljava/lang/String;
    //   237: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   242: pop
    //   243: aload_0
    //   244: getfield a : Ljava/util/Map;
    //   247: ldc 'CpuProductor'
    //   249: invokestatic i : ()Ljava/lang/String;
    //   252: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: aload_0
    //   259: getfield a : Ljava/util/Map;
    //   262: ldc 'CpuAbi'
    //   264: invokestatic f : ()Ljava/lang/String;
    //   267: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: aload_0
    //   274: getfield a : Ljava/util/Map;
    //   277: ldc 'CpuAbis'
    //   279: invokestatic g : ()Ljava/lang/String;
    //   282: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: aload_0
    //   289: getfield b : Landroid/content/Context;
    //   292: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   295: astore_2
    //   296: aload_2
    //   297: ifnull -> 309
    //   300: aload_2
    //   301: astore_3
    //   302: aload_2
    //   303: invokevirtual length : ()I
    //   306: ifne -> 312
    //   309: ldc 'Unknown'
    //   311: astore_3
    //   312: aload_0
    //   313: getfield a : Ljava/util/Map;
    //   316: ldc 'CpuModel'
    //   318: aload_3
    //   319: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: pop
    //   325: new java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial <init> : ()V
    //   332: astore_2
    //   333: aload_2
    //   334: ldc 'cpu_model:'
    //   336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_2
    //   341: aload_3
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_2
    //   347: invokevirtual toString : ()Ljava/lang/String;
    //   350: invokestatic a : (Ljava/lang/String;)V
    //   353: aload_0
    //   354: getfield a : Ljava/util/Map;
    //   357: ldc 'OsArch'
    //   359: invokestatic h : ()Ljava/lang/String;
    //   362: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   367: pop
    //   368: aload_0
    //   369: getfield a : Ljava/util/Map;
    //   372: ldc 'DeviceName'
    //   374: invokestatic j : ()Ljava/lang/String;
    //   377: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload_0
    //   384: getfield a : Ljava/util/Map;
    //   387: astore_3
    //   388: new java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial <init> : ()V
    //   395: astore_2
    //   396: aload_2
    //   397: aload_0
    //   398: getfield b : Landroid/content/Context;
    //   401: invokestatic c : (Landroid/content/Context;)Landroid/util/DisplayMetrics;
    //   404: getfield heightPixels : I
    //   407: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_2
    //   412: ldc 'X'
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_2
    //   419: aload_0
    //   420: getfield b : Landroid/content/Context;
    //   423: invokestatic c : (Landroid/content/Context;)Landroid/util/DisplayMetrics;
    //   426: getfield widthPixels : I
    //   429: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_3
    //   434: ldc 'DisplayMetrics'
    //   436: aload_2
    //   437: invokevirtual toString : ()Ljava/lang/String;
    //   440: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   445: pop
    //   446: aload_0
    //   447: getfield a : Ljava/util/Map;
    //   450: ldc 'FreeMemory'
    //   452: aload_0
    //   453: getfield b : Landroid/content/Context;
    //   456: invokestatic d : (Landroid/content/Context;)J
    //   459: invokestatic valueOf : (J)Ljava/lang/String;
    //   462: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: pop
    //   468: aload_0
    //   469: getfield a : Ljava/util/Map;
    //   472: ldc 'FreeStorage'
    //   474: invokestatic l : ()J
    //   477: invokestatic valueOf : (J)Ljava/lang/String;
    //   480: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload_0
    //   487: getfield a : Ljava/util/Map;
    //   490: ldc 'IMEI'
    //   492: aload_1
    //   493: aload_0
    //   494: getfield b : Landroid/content/Context;
    //   497: invokevirtual a : (Landroid/content/Context;)Ljava/lang/String;
    //   500: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: aload_0
    //   507: getfield a : Ljava/util/Map;
    //   510: ldc 'IMSI'
    //   512: aload_1
    //   513: aload_0
    //   514: getfield b : Landroid/content/Context;
    //   517: invokevirtual e : (Landroid/content/Context;)Ljava/lang/String;
    //   520: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: pop
    //   526: aload_0
    //   527: getfield a : Ljava/util/Map;
    //   530: ldc 'Language'
    //   532: invokestatic m : ()Ljava/lang/String;
    //   535: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   540: pop
    //   541: aload_0
    //   542: getfield a : Ljava/util/Map;
    //   545: ldc 'MacAddress'
    //   547: aload_1
    //   548: aload_0
    //   549: getfield b : Landroid/content/Context;
    //   552: invokevirtual c : (Landroid/content/Context;)Ljava/lang/String;
    //   555: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: aload_0
    //   562: getfield a : Ljava/util/Map;
    //   565: ldc 'NetworkName'
    //   567: aload_0
    //   568: getfield b : Landroid/content/Context;
    //   571: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   574: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: aload_0
    //   581: getfield a : Ljava/util/Map;
    //   584: ldc 'NetworkType'
    //   586: aload_0
    //   587: getfield b : Landroid/content/Context;
    //   590: invokestatic e : (Landroid/content/Context;)Ljava/lang/String;
    //   593: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: aload_0
    //   600: getfield a : Ljava/util/Map;
    //   603: ldc 'Platform'
    //   605: invokestatic o : ()Ljava/lang/String;
    //   608: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   613: pop
    //   614: aload_0
    //   615: getfield a : Ljava/util/Map;
    //   618: ldc 'RamSize'
    //   620: invokestatic p : ()Ljava/lang/String;
    //   623: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   628: pop
    //   629: aload_0
    //   630: getfield a : Ljava/util/Map;
    //   633: ldc 'RomSize'
    //   635: invokestatic q : ()Ljava/lang/String;
    //   638: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   643: pop
    //   644: aload_0
    //   645: getfield a : Ljava/util/Map;
    //   648: ldc 'SensorStates'
    //   650: aload_1
    //   651: aload_0
    //   652: getfield b : Landroid/content/Context;
    //   655: invokevirtual k : (Landroid/content/Context;)Ljava/lang/String;
    //   658: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   663: pop
    //   664: aload_0
    //   665: getfield a : Ljava/util/Map;
    //   668: ldc 'Version'
    //   670: invokestatic r : ()Ljava/lang/String;
    //   673: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   678: pop
    //   679: aload_0
    //   680: getfield a : Ljava/util/Map;
    //   683: ldc 'WifiHotspotMacAddress'
    //   685: aload_1
    //   686: aload_0
    //   687: getfield b : Landroid/content/Context;
    //   690: invokevirtual d : (Landroid/content/Context;)Ljava/lang/String;
    //   693: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: aload_0
    //   700: getfield a : Ljava/util/Map;
    //   703: ldc 'WifiHotspotSSID'
    //   705: aload_1
    //   706: aload_0
    //   707: getfield b : Landroid/content/Context;
    //   710: invokevirtual b : (Landroid/content/Context;)Ljava/lang/String;
    //   713: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: pop
    //   719: aload_0
    //   720: getfield a : Ljava/util/Map;
    //   723: ldc 'SDCardState'
    //   725: invokestatic a : ()Z
    //   728: invokestatic valueOf : (Z)Ljava/lang/String;
    //   731: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   736: pop
    //   737: aload_0
    //   738: getfield a : Ljava/util/Map;
    //   741: ldc 'KernelVer'
    //   743: invokestatic n : ()Ljava/lang/String;
    //   746: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   751: pop
    //   752: aload_0
    //   753: getfield a : Ljava/util/Map;
    //   756: ldc 'SimulatorName'
    //   758: aload_0
    //   759: getfield b : Landroid/content/Context;
    //   762: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   765: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   770: pop
    //   771: aload_0
    //   772: getfield a : Ljava/util/Map;
    //   775: astore_2
    //   776: new java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial <init> : ()V
    //   783: astore_3
    //   784: aload_3
    //   785: ldc ''
    //   787: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload_3
    //   792: aload_0
    //   793: getfield b : Landroid/content/Context;
    //   796: invokestatic k : (Landroid/content/Context;)F
    //   799: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload_2
    //   804: ldc_w 'Battery'
    //   807: aload_3
    //   808: invokevirtual toString : ()Ljava/lang/String;
    //   811: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   816: pop
    //   817: aload_0
    //   818: getfield a : Ljava/util/Map;
    //   821: astore_3
    //   822: new java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial <init> : ()V
    //   829: astore_2
    //   830: aload_2
    //   831: ldc ''
    //   833: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload_2
    //   838: aload_0
    //   839: getfield b : Landroid/content/Context;
    //   842: invokestatic m : (Landroid/content/Context;)J
    //   845: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload_3
    //   850: ldc_w 'TotalMemory'
    //   853: aload_2
    //   854: invokevirtual toString : ()Ljava/lang/String;
    //   857: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   862: pop
    //   863: invokestatic a : ()Z
    //   866: ifeq -> 895
    //   869: aload_0
    //   870: getfield a : Ljava/util/Map;
    //   873: astore_3
    //   874: invokestatic k : ()J
    //   877: invokestatic valueOf : (J)Ljava/lang/String;
    //   880: astore_2
    //   881: aload_3
    //   882: ldc_w 'SDCARDFreeSpace'
    //   885: aload_2
    //   886: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   891: pop
    //   892: goto -> 908
    //   895: aload_0
    //   896: getfield a : Ljava/util/Map;
    //   899: astore_3
    //   900: iconst_m1
    //   901: invokestatic valueOf : (I)Ljava/lang/String;
    //   904: astore_2
    //   905: goto -> 881
    //   908: aload_1
    //   909: aload_0
    //   910: getfield b : Landroid/content/Context;
    //   913: invokevirtual o : (Landroid/content/Context;)Ljava/util/List;
    //   916: astore_1
    //   917: iconst_0
    //   918: istore #4
    //   920: iload #4
    //   922: aload_1
    //   923: invokeinterface size : ()I
    //   928: if_icmpge -> 1101
    //   931: aload_1
    //   932: iload #4
    //   934: invokeinterface get : (I)Ljava/lang/Object;
    //   939: checkcast android/net/wifi/ScanResult
    //   942: astore #5
    //   944: aload #5
    //   946: ifnull -> 1095
    //   949: aload #5
    //   951: getfield BSSID : Ljava/lang/String;
    //   954: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   957: astore_2
    //   958: aload_2
    //   959: astore_3
    //   960: aload_2
    //   961: ifnull -> 975
    //   964: aload_2
    //   965: ldc_w ':'
    //   968: ldc_w ' '
    //   971: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   974: astore_3
    //   975: new java/lang/StringBuilder
    //   978: dup
    //   979: invokespecial <init> : ()V
    //   982: astore_2
    //   983: aload_2
    //   984: aload_3
    //   985: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload_2
    //   990: ldc_w '('
    //   993: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload_2
    //   998: invokevirtual toString : ()Ljava/lang/String;
    //   1001: astore_2
    //   1002: new java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial <init> : ()V
    //   1009: astore_3
    //   1010: aload_3
    //   1011: aload_2
    //   1012: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload_3
    //   1017: aload #5
    //   1019: getfield SSID : Ljava/lang/String;
    //   1022: ldc_w '"'
    //   1025: ldc ''
    //   1027: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1030: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload_3
    //   1035: invokevirtual toString : ()Ljava/lang/String;
    //   1038: astore_2
    //   1039: new java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial <init> : ()V
    //   1046: astore_3
    //   1047: aload_3
    //   1048: aload_2
    //   1049: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: pop
    //   1053: aload_3
    //   1054: ldc_w ')'
    //   1057: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: aload_3
    //   1062: invokevirtual toString : ()Ljava/lang/String;
    //   1065: astore_3
    //   1066: aload_0
    //   1067: getfield a : Ljava/util/Map;
    //   1070: ldc_w 'NearWifi%d'
    //   1073: iconst_1
    //   1074: anewarray java/lang/Object
    //   1077: dup
    //   1078: iconst_0
    //   1079: iload #4
    //   1081: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1084: aastore
    //   1085: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1088: aload_3
    //   1089: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1094: pop
    //   1095: iinc #4, 1
    //   1098: goto -> 920
    //   1101: aload_0
    //   1102: getfield a : Ljava/util/Map;
    //   1105: invokeinterface keySet : ()Ljava/util/Set;
    //   1110: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1115: astore_1
    //   1116: aload_1
    //   1117: invokeinterface hasNext : ()Z
    //   1122: ifeq -> 1228
    //   1125: aload_1
    //   1126: invokeinterface next : ()Ljava/lang/Object;
    //   1131: checkcast java/lang/String
    //   1134: astore #5
    //   1136: aload #5
    //   1138: ifnull -> 1116
    //   1141: aload_0
    //   1142: getfield a : Ljava/util/Map;
    //   1145: aload #5
    //   1147: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1152: checkcast java/lang/String
    //   1155: astore_2
    //   1156: aload_2
    //   1157: astore_3
    //   1158: aload_2
    //   1159: ifnonnull -> 1167
    //   1162: aload_2
    //   1163: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1166: astore_3
    //   1167: new java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial <init> : ()V
    //   1174: astore_2
    //   1175: aload_2
    //   1176: aload #5
    //   1178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: aload_2
    //   1183: ldc_w ':'
    //   1186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: aload_2
    //   1191: aload_3
    //   1192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload_2
    //   1197: invokevirtual toString : ()Ljava/lang/String;
    //   1200: astore_2
    //   1201: aload_2
    //   1202: astore_3
    //   1203: aload_2
    //   1204: invokevirtual length : ()I
    //   1207: bipush #63
    //   1209: if_icmple -> 1220
    //   1212: aload_2
    //   1213: iconst_0
    //   1214: bipush #63
    //   1216: invokevirtual substring : (II)Ljava/lang/String;
    //   1219: astore_3
    //   1220: aload_0
    //   1221: aload_3
    //   1222: invokespecial a : (Ljava/lang/String;)V
    //   1225: goto -> 1116
    //   1228: iconst_1
    //   1229: ireturn
  }
  
  public boolean a(Context paramContext) {
    if (paramContext == null)
      return false; 
    if (this.b != null)
      return false; 
    this.b = paramContext;
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 0);
        this.c = packageInfo.versionName;
        this.d = packageInfo.versionCode;
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      }  
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */