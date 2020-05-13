package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {
  private static Proxy e;
  
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap<String, HashMap<String, byte[]>>();
  
  protected String b;
  
  i c;
  
  private HashMap<String, Object> d;
  
  a() {
    new HashMap<Object, Object>();
    this.d = new HashMap<String, Object>();
    this.b = "GBK";
    this.c = new i();
  }
  
  public static aj a(int paramInt) {
    return (aj)((paramInt == 1) ? new ai() : ((paramInt == 3) ? new ah() : null));
  }
  
  public static ap a(Context paramContext, int paramInt, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: invokestatic b : ()Lcom/tencent/bugly/crashreport/common/info/a;
    //   3: astore_3
    //   4: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   7: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   10: astore #4
    //   12: aload_3
    //   13: ifnull -> 1232
    //   16: aload #4
    //   18: ifnonnull -> 24
    //   21: goto -> 1232
    //   24: new com/tencent/bugly/proguard/ap
    //   27: astore #5
    //   29: aload #5
    //   31: invokespecial <init> : ()V
    //   34: aload_3
    //   35: monitorenter
    //   36: aload #5
    //   38: iconst_1
    //   39: putfield a : I
    //   42: aload #5
    //   44: aload_3
    //   45: invokevirtual f : ()Ljava/lang/String;
    //   48: putfield b : Ljava/lang/String;
    //   51: aload #5
    //   53: aload_3
    //   54: getfield c : Ljava/lang/String;
    //   57: putfield c : Ljava/lang/String;
    //   60: aload #5
    //   62: aload_3
    //   63: getfield j : Ljava/lang/String;
    //   66: putfield d : Ljava/lang/String;
    //   69: aload #5
    //   71: aload_3
    //   72: getfield l : Ljava/lang/String;
    //   75: putfield e : Ljava/lang/String;
    //   78: aload_3
    //   79: invokevirtual getClass : ()Ljava/lang/Class;
    //   82: pop
    //   83: aload #5
    //   85: ldc '3.1.0'
    //   87: putfield f : Ljava/lang/String;
    //   90: aload #5
    //   92: iload_1
    //   93: putfield g : I
    //   96: aload_2
    //   97: ifnonnull -> 110
    //   100: ldc ''
    //   102: invokevirtual getBytes : ()[B
    //   105: astore #6
    //   107: goto -> 113
    //   110: aload_2
    //   111: astore #6
    //   113: aload #5
    //   115: aload #6
    //   117: putfield h : [B
    //   120: aload #5
    //   122: aload_3
    //   123: getfield g : Ljava/lang/String;
    //   126: putfield i : Ljava/lang/String;
    //   129: aload #5
    //   131: aload_3
    //   132: getfield h : Ljava/lang/String;
    //   135: putfield j : Ljava/lang/String;
    //   138: new java/util/HashMap
    //   141: astore #6
    //   143: aload #6
    //   145: invokespecial <init> : ()V
    //   148: aload #5
    //   150: aload #6
    //   152: putfield k : Ljava/util/Map;
    //   155: aload #5
    //   157: aload_3
    //   158: invokevirtual e : ()Ljava/lang/String;
    //   161: putfield l : Ljava/lang/String;
    //   164: aload #5
    //   166: aload #4
    //   168: getfield p : J
    //   171: putfield m : J
    //   174: aload #5
    //   176: aload_3
    //   177: invokevirtual h : ()Ljava/lang/String;
    //   180: putfield o : Ljava/lang/String;
    //   183: aload #5
    //   185: aload_0
    //   186: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   189: putfield p : Ljava/lang/String;
    //   192: aload #5
    //   194: invokestatic currentTimeMillis : ()J
    //   197: putfield q : J
    //   200: new java/lang/StringBuilder
    //   203: astore_0
    //   204: aload_0
    //   205: invokespecial <init> : ()V
    //   208: aload_0
    //   209: aload_3
    //   210: invokevirtual k : ()Ljava/lang/String;
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload #5
    //   219: aload_0
    //   220: invokevirtual toString : ()Ljava/lang/String;
    //   223: putfield r : Ljava/lang/String;
    //   226: aload #5
    //   228: aload_3
    //   229: invokevirtual j : ()Ljava/lang/String;
    //   232: putfield s : Ljava/lang/String;
    //   235: new java/lang/StringBuilder
    //   238: astore_0
    //   239: aload_0
    //   240: invokespecial <init> : ()V
    //   243: aload_0
    //   244: aload_3
    //   245: invokevirtual m : ()Ljava/lang/String;
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #5
    //   254: aload_0
    //   255: invokevirtual toString : ()Ljava/lang/String;
    //   258: putfield t : Ljava/lang/String;
    //   261: aload #5
    //   263: aload_3
    //   264: invokevirtual l : ()Ljava/lang/String;
    //   267: putfield u : Ljava/lang/String;
    //   270: new java/lang/StringBuilder
    //   273: astore_0
    //   274: aload_0
    //   275: invokespecial <init> : ()V
    //   278: aload_0
    //   279: aload_3
    //   280: invokevirtual n : ()Ljava/lang/String;
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #5
    //   289: aload_0
    //   290: invokevirtual toString : ()Ljava/lang/String;
    //   293: putfield v : Ljava/lang/String;
    //   296: aload #5
    //   298: aload #5
    //   300: getfield p : Ljava/lang/String;
    //   303: putfield w : Ljava/lang/String;
    //   306: aload_3
    //   307: invokevirtual getClass : ()Ljava/lang/Class;
    //   310: pop
    //   311: aload #5
    //   313: ldc 'com.tencent.bugly'
    //   315: putfield n : Ljava/lang/String;
    //   318: aload #5
    //   320: getfield k : Ljava/util/Map;
    //   323: astore #6
    //   325: new java/lang/StringBuilder
    //   328: astore_0
    //   329: aload_0
    //   330: invokespecial <init> : ()V
    //   333: aload_0
    //   334: aload_3
    //   335: invokevirtual y : ()Ljava/lang/String;
    //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload #6
    //   344: ldc 'A26'
    //   346: aload_0
    //   347: invokevirtual toString : ()Ljava/lang/String;
    //   350: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   355: pop
    //   356: aload #5
    //   358: getfield k : Ljava/util/Map;
    //   361: astore_0
    //   362: new java/lang/StringBuilder
    //   365: astore #6
    //   367: aload #6
    //   369: invokespecial <init> : ()V
    //   372: aload #6
    //   374: aload_3
    //   375: invokevirtual z : ()Ljava/lang/String;
    //   378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload_0
    //   383: ldc 'A60'
    //   385: aload #6
    //   387: invokevirtual toString : ()Ljava/lang/String;
    //   390: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   395: pop
    //   396: aload #5
    //   398: getfield k : Ljava/util/Map;
    //   401: astore #6
    //   403: new java/lang/StringBuilder
    //   406: astore_0
    //   407: aload_0
    //   408: invokespecial <init> : ()V
    //   411: aload_0
    //   412: aload_3
    //   413: invokevirtual A : ()Ljava/lang/String;
    //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload #6
    //   422: ldc 'A61'
    //   424: aload_0
    //   425: invokevirtual toString : ()Ljava/lang/String;
    //   428: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: aload #5
    //   436: getfield k : Ljava/util/Map;
    //   439: astore_0
    //   440: new java/lang/StringBuilder
    //   443: astore #6
    //   445: aload #6
    //   447: invokespecial <init> : ()V
    //   450: aload #6
    //   452: aload_3
    //   453: invokevirtual R : ()Z
    //   456: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_0
    //   461: ldc 'A62'
    //   463: aload #6
    //   465: invokevirtual toString : ()Ljava/lang/String;
    //   468: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   473: pop
    //   474: aload #5
    //   476: getfield k : Ljava/util/Map;
    //   479: astore_0
    //   480: new java/lang/StringBuilder
    //   483: astore #6
    //   485: aload #6
    //   487: invokespecial <init> : ()V
    //   490: aload #6
    //   492: aload_3
    //   493: invokevirtual S : ()Z
    //   496: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_0
    //   501: ldc 'A63'
    //   503: aload #6
    //   505: invokevirtual toString : ()Ljava/lang/String;
    //   508: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   513: pop
    //   514: aload #5
    //   516: getfield k : Ljava/util/Map;
    //   519: astore_0
    //   520: new java/lang/StringBuilder
    //   523: astore #6
    //   525: aload #6
    //   527: invokespecial <init> : ()V
    //   530: aload #6
    //   532: aload_3
    //   533: getfield z : Z
    //   536: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload_0
    //   541: ldc 'F11'
    //   543: aload #6
    //   545: invokevirtual toString : ()Ljava/lang/String;
    //   548: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   553: pop
    //   554: aload #5
    //   556: getfield k : Ljava/util/Map;
    //   559: astore_0
    //   560: new java/lang/StringBuilder
    //   563: astore #6
    //   565: aload #6
    //   567: invokespecial <init> : ()V
    //   570: aload #6
    //   572: aload_3
    //   573: getfield y : Z
    //   576: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload_0
    //   581: ldc 'F12'
    //   583: aload #6
    //   585: invokevirtual toString : ()Ljava/lang/String;
    //   588: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   593: pop
    //   594: aload #5
    //   596: getfield k : Ljava/util/Map;
    //   599: astore #6
    //   601: new java/lang/StringBuilder
    //   604: astore_0
    //   605: aload_0
    //   606: invokespecial <init> : ()V
    //   609: aload_0
    //   610: aload_3
    //   611: invokevirtual u : ()Ljava/lang/String;
    //   614: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload #6
    //   620: ldc 'G1'
    //   622: aload_0
    //   623: invokevirtual toString : ()Ljava/lang/String;
    //   626: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   631: pop
    //   632: aload #5
    //   634: getfield k : Ljava/util/Map;
    //   637: astore_0
    //   638: new java/lang/StringBuilder
    //   641: astore #6
    //   643: aload #6
    //   645: invokespecial <init> : ()V
    //   648: aload #6
    //   650: aload_3
    //   651: invokevirtual T : ()Ljava/lang/String;
    //   654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload_0
    //   659: ldc 'A64'
    //   661: aload #6
    //   663: invokevirtual toString : ()Ljava/lang/String;
    //   666: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   671: pop
    //   672: aload_3
    //   673: getfield B : Z
    //   676: ifeq -> 921
    //   679: aload #5
    //   681: getfield k : Ljava/util/Map;
    //   684: astore_0
    //   685: new java/lang/StringBuilder
    //   688: astore #6
    //   690: aload #6
    //   692: invokespecial <init> : ()V
    //   695: aload #6
    //   697: aload_3
    //   698: invokevirtual L : ()Ljava/lang/String;
    //   701: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_0
    //   706: ldc 'G2'
    //   708: aload #6
    //   710: invokevirtual toString : ()Ljava/lang/String;
    //   713: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   718: pop
    //   719: aload #5
    //   721: getfield k : Ljava/util/Map;
    //   724: astore_0
    //   725: new java/lang/StringBuilder
    //   728: astore #6
    //   730: aload #6
    //   732: invokespecial <init> : ()V
    //   735: aload #6
    //   737: aload_3
    //   738: invokevirtual M : ()Ljava/lang/String;
    //   741: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload_0
    //   746: ldc_w 'G3'
    //   749: aload #6
    //   751: invokevirtual toString : ()Ljava/lang/String;
    //   754: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   759: pop
    //   760: aload #5
    //   762: getfield k : Ljava/util/Map;
    //   765: astore_0
    //   766: new java/lang/StringBuilder
    //   769: astore #6
    //   771: aload #6
    //   773: invokespecial <init> : ()V
    //   776: aload #6
    //   778: aload_3
    //   779: invokevirtual N : ()Ljava/lang/String;
    //   782: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload_0
    //   787: ldc_w 'G4'
    //   790: aload #6
    //   792: invokevirtual toString : ()Ljava/lang/String;
    //   795: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   800: pop
    //   801: aload #5
    //   803: getfield k : Ljava/util/Map;
    //   806: astore #6
    //   808: new java/lang/StringBuilder
    //   811: astore_0
    //   812: aload_0
    //   813: invokespecial <init> : ()V
    //   816: aload_0
    //   817: aload_3
    //   818: invokevirtual O : ()Ljava/lang/String;
    //   821: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload #6
    //   827: ldc_w 'G5'
    //   830: aload_0
    //   831: invokevirtual toString : ()Ljava/lang/String;
    //   834: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   839: pop
    //   840: aload #5
    //   842: getfield k : Ljava/util/Map;
    //   845: astore #6
    //   847: new java/lang/StringBuilder
    //   850: astore_0
    //   851: aload_0
    //   852: invokespecial <init> : ()V
    //   855: aload_0
    //   856: aload_3
    //   857: invokevirtual P : ()Ljava/lang/String;
    //   860: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload #6
    //   866: ldc_w 'G6'
    //   869: aload_0
    //   870: invokevirtual toString : ()Ljava/lang/String;
    //   873: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   878: pop
    //   879: aload #5
    //   881: getfield k : Ljava/util/Map;
    //   884: astore #6
    //   886: new java/lang/StringBuilder
    //   889: astore_0
    //   890: aload_0
    //   891: invokespecial <init> : ()V
    //   894: aload_0
    //   895: aload_3
    //   896: invokevirtual Q : ()J
    //   899: invokestatic toString : (J)Ljava/lang/String;
    //   902: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload #6
    //   908: ldc_w 'G7'
    //   911: aload_0
    //   912: invokevirtual toString : ()Ljava/lang/String;
    //   915: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   920: pop
    //   921: aload #5
    //   923: getfield k : Ljava/util/Map;
    //   926: astore_0
    //   927: new java/lang/StringBuilder
    //   930: astore #6
    //   932: aload #6
    //   934: invokespecial <init> : ()V
    //   937: aload #6
    //   939: aload_3
    //   940: getfield k : Ljava/lang/String;
    //   943: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload_0
    //   948: ldc_w 'D3'
    //   951: aload #6
    //   953: invokevirtual toString : ()Ljava/lang/String;
    //   956: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   961: pop
    //   962: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   965: ifnull -> 1037
    //   968: getstatic com/tencent/bugly/b.b : Ljava/util/List;
    //   971: invokeinterface iterator : ()Ljava/util/Iterator;
    //   976: astore_0
    //   977: aload_0
    //   978: invokeinterface hasNext : ()Z
    //   983: ifeq -> 1037
    //   986: aload_0
    //   987: invokeinterface next : ()Ljava/lang/Object;
    //   992: checkcast com/tencent/bugly/a
    //   995: astore #6
    //   997: aload #6
    //   999: getfield versionKey : Ljava/lang/String;
    //   1002: ifnull -> 977
    //   1005: aload #6
    //   1007: getfield version : Ljava/lang/String;
    //   1010: ifnull -> 977
    //   1013: aload #5
    //   1015: getfield k : Ljava/util/Map;
    //   1018: aload #6
    //   1020: getfield versionKey : Ljava/lang/String;
    //   1023: aload #6
    //   1025: getfield version : Ljava/lang/String;
    //   1028: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1033: pop
    //   1034: goto -> 977
    //   1037: aload #5
    //   1039: getfield k : Ljava/util/Map;
    //   1042: ldc_w 'G15'
    //   1045: ldc_w 'G15'
    //   1048: ldc ''
    //   1050: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1053: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1058: pop
    //   1059: aload #5
    //   1061: getfield k : Ljava/util/Map;
    //   1064: ldc_w 'D4'
    //   1067: ldc_w 'D4'
    //   1070: ldc_w '0'
    //   1073: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1076: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1081: pop
    //   1082: aload_3
    //   1083: monitorexit
    //   1084: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   1087: astore_0
    //   1088: aload_0
    //   1089: ifnull -> 1144
    //   1092: aload_0
    //   1093: getfield a : Z
    //   1096: ifne -> 1144
    //   1099: aload_2
    //   1100: ifnull -> 1144
    //   1103: aload #5
    //   1105: aload #5
    //   1107: getfield h : [B
    //   1110: iconst_2
    //   1111: iconst_1
    //   1112: aload #4
    //   1114: getfield u : Ljava/lang/String;
    //   1117: invokestatic a : ([BIILjava/lang/String;)[B
    //   1120: putfield h : [B
    //   1123: aload #5
    //   1125: getfield h : [B
    //   1128: ifnonnull -> 1144
    //   1131: ldc_w 'reqPkg sbuffer error!'
    //   1134: iconst_0
    //   1135: anewarray java/lang/Object
    //   1138: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1141: pop
    //   1142: aconst_null
    //   1143: areturn
    //   1144: aload_3
    //   1145: invokevirtual F : ()Ljava/util/Map;
    //   1148: astore_0
    //   1149: aload_0
    //   1150: ifnull -> 1210
    //   1153: aload_0
    //   1154: invokeinterface entrySet : ()Ljava/util/Set;
    //   1159: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1164: astore_2
    //   1165: aload_2
    //   1166: invokeinterface hasNext : ()Z
    //   1171: ifeq -> 1210
    //   1174: aload_2
    //   1175: invokeinterface next : ()Ljava/lang/Object;
    //   1180: checkcast java/util/Map$Entry
    //   1183: astore_0
    //   1184: aload #5
    //   1186: getfield k : Ljava/util/Map;
    //   1189: aload_0
    //   1190: invokeinterface getKey : ()Ljava/lang/Object;
    //   1195: aload_0
    //   1196: invokeinterface getValue : ()Ljava/lang/Object;
    //   1201: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1206: pop
    //   1207: goto -> 1165
    //   1210: aload #5
    //   1212: areturn
    //   1213: astore_0
    //   1214: aload_3
    //   1215: monitorexit
    //   1216: aload_0
    //   1217: athrow
    //   1218: astore_0
    //   1219: aload_0
    //   1220: invokestatic b : (Ljava/lang/Throwable;)Z
    //   1223: ifne -> 1230
    //   1226: aload_0
    //   1227: invokevirtual printStackTrace : ()V
    //   1230: aconst_null
    //   1231: areturn
    //   1232: ldc_w 'Can not create request pkg for parameters is invalid.'
    //   1235: iconst_0
    //   1236: anewarray java/lang/Object
    //   1239: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1242: pop
    //   1243: aconst_null
    //   1244: areturn
    // Exception table:
    //   from	to	target	type
    //   24	36	1218	java/lang/Throwable
    //   36	96	1213	finally
    //   100	107	1213	finally
    //   113	921	1213	finally
    //   921	977	1213	finally
    //   977	1034	1213	finally
    //   1037	1084	1213	finally
    //   1084	1088	1218	java/lang/Throwable
    //   1092	1099	1218	java/lang/Throwable
    //   1103	1142	1218	java/lang/Throwable
    //   1144	1149	1218	java/lang/Throwable
    //   1153	1165	1218	java/lang/Throwable
    //   1165	1207	1218	java/lang/Throwable
    //   1214	1218	1218	java/lang/Throwable
  }
  
  public static aq a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte != null)
      try {
        d d = new d();
        this();
        d.c();
        d.a("utf-8");
        d.a(paramArrayOfbyte);
        aq aq = new aq();
        this();
        aq = d.b("detail", aq);
        if (aq.class.isInstance(aq)) {
          aq = aq.class.cast(aq);
        } else {
          aq = null;
        } 
        if (!paramBoolean && aq != null && aq.c != null && aq.c.length > 0) {
          x.c("resp buf %d", new Object[] { Integer.valueOf(aq.c.length) });
          aq.c = z.b(aq.c, 2, 1, StrategyBean.d);
          if (aq.c == null) {
            x.e("resp sbuffer error!", new Object[0]);
            return null;
          } 
        } 
        return aq;
      } catch (Throwable throwable) {
        if (!x.b(throwable))
          throwable.printStackTrace(); 
      }  
    return null;
  }
  
  public static at a(UserInfoBean paramUserInfoBean) {
    boolean bool;
    if (paramUserInfoBean == null)
      return null; 
    at at = new at();
    at.a = paramUserInfoBean.e;
    at.e = paramUserInfoBean.j;
    at.d = paramUserInfoBean.c;
    at.c = paramUserInfoBean.d;
    at.g = com.tencent.bugly.crashreport.common.info.a.b().i();
    if (paramUserInfoBean.o == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    at.h = bool;
    switch (paramUserInfoBean.b) {
      default:
        if (paramUserInfoBean.b >= 10 && paramUserInfoBean.b < 20) {
          at.b = (byte)(byte)paramUserInfoBean.b;
          break;
        } 
        x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
        return null;
      case 4:
        at.b = (byte)3;
        break;
      case 3:
        at.b = (byte)2;
        break;
      case 2:
        at.b = (byte)4;
        break;
      case 1:
        at.b = (byte)1;
        break;
    } 
    at.f = new HashMap<String, String>();
    if (paramUserInfoBean.p >= 0) {
      Map<String, String> map = at.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramUserInfoBean.p);
      map.put("C01", stringBuilder.toString());
    } 
    if (paramUserInfoBean.q >= 0) {
      Map<String, String> map = at.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramUserInfoBean.q);
      map.put("C02", stringBuilder.toString());
    } 
    if (paramUserInfoBean.r != null && paramUserInfoBean.r.size() > 0)
      for (Map.Entry entry : paramUserInfoBean.r.entrySet()) {
        Map<String, String> map = at.f;
        StringBuilder stringBuilder = new StringBuilder("C03_");
        stringBuilder.append((String)entry.getKey());
        map.put(stringBuilder.toString(), (String)entry.getValue());
      }  
    if (paramUserInfoBean.s != null && paramUserInfoBean.s.size() > 0)
      for (Map.Entry entry : paramUserInfoBean.s.entrySet()) {
        Map<String, String> map = at.f;
        StringBuilder stringBuilder = new StringBuilder("C04_");
        stringBuilder.append((String)entry.getKey());
        map.put(stringBuilder.toString(), (String)entry.getValue());
      }  
    Map<String, String> map2 = at.f;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramUserInfoBean.l ^ true);
    map2.put("A36", stringBuilder1.toString());
    Map<String, String> map1 = at.f;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramUserInfoBean.g);
    map1.put("F02", stringBuilder2.toString());
    map1 = at.f;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramUserInfoBean.h);
    map1.put("F03", stringBuilder2.toString());
    map1 = at.f;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramUserInfoBean.j);
    map1.put("F04", stringBuilder2.toString());
    map1 = at.f;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramUserInfoBean.i);
    map1.put("F05", stringBuilder2.toString());
    map1 = at.f;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramUserInfoBean.m);
    map1.put("F06", stringBuilder2.toString());
    map1 = at.f;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramUserInfoBean.k);
    map1.put("F10", stringBuilder2.toString());
    x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(at.b), Integer.valueOf(at.f.size()) });
    return at;
  }
  
  public static au a(List<UserInfoBean> paramList, int paramInt) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.b();
    if (a1 == null)
      return null; 
    a1.t();
    au au = new au();
    au.b = a1.d;
    au.c = a1.h();
    ArrayList<at> arrayList = new ArrayList();
    Iterator<UserInfoBean> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      at at = a(iterator.next());
      if (at != null)
        arrayList.add(at); 
    } 
    au.d = arrayList;
    au.e = new HashMap<String, String>();
    Map<String, String> map4 = au.e;
    StringBuilder stringBuilder8 = new StringBuilder();
    stringBuilder8.append(a1.f);
    map4.put("A7", stringBuilder8.toString());
    Map<String, String> map8 = au.e;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(a1.s());
    map8.put("A6", stringBuilder4.toString());
    map8 = au.e;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(a1.r());
    map8.put("A5", stringBuilder4.toString());
    map8 = au.e;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(a1.p());
    map8.put("A2", stringBuilder4.toString());
    Map<String, String> map3 = au.e;
    StringBuilder stringBuilder7 = new StringBuilder();
    stringBuilder7.append(a1.p());
    map3.put("A1", stringBuilder7.toString());
    Map<String, String> map7 = au.e;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(a1.h);
    map7.put("A24", stringBuilder3.toString());
    Map<String, String> map2 = au.e;
    StringBuilder stringBuilder6 = new StringBuilder();
    stringBuilder6.append(a1.q());
    map2.put("A17", stringBuilder6.toString());
    map2 = au.e;
    stringBuilder6 = new StringBuilder();
    stringBuilder6.append(a1.w());
    map2.put("A15", stringBuilder6.toString());
    Map<String, String> map6 = au.e;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(a1.x());
    map6.put("A13", stringBuilder2.toString());
    Map<String, String> map1 = au.e;
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append(a1.v);
    map1.put("F08", stringBuilder5.toString());
    Map<String, String> map5 = au.e;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(a1.w);
    map5.put("F09", stringBuilder1.toString());
    Map map = a1.G();
    if (map != null && map.size() > 0)
      for (Map.Entry entry : map.entrySet()) {
        Map<String, String> map9 = au.e;
        StringBuilder stringBuilder = new StringBuilder("C04_");
        stringBuilder.append((String)entry.getKey());
        map9.put(stringBuilder.toString(), (String)entry.getValue());
      }  
    switch (paramInt) {
      default:
        x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
        return null;
      case 2:
        au.a = (byte)2;
        return au;
      case 1:
        break;
    } 
    au.a = (byte)1;
    return au;
  }
  
  public static <T extends k> T a(byte[] paramArrayOfbyte, Class<T> paramClass) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return null; 
    try {
      k k = (k)paramClass.newInstance();
      i i1 = new i();
      this(paramArrayOfbyte);
      i1.a("utf-8");
      k.a(i1);
      return (T)k;
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static String a(ArrayList<String> paramArrayList) {
    StringBuffer stringBuffer = new StringBuffer();
    byte b;
    for (b = 0; b < paramArrayList.size(); b++) {
      String str2;
      String str1 = paramArrayList.get(b);
      if (str1.equals("java.lang.Integer") || str1.equals("int")) {
        str2 = "int32";
      } else if (str1.equals("java.lang.Boolean") || str1.equals("boolean")) {
        str2 = "bool";
      } else if (str1.equals("java.lang.Byte") || str1.equals("byte")) {
        str2 = "char";
      } else if (str1.equals("java.lang.Double") || str1.equals("double")) {
        str2 = "double";
      } else if (str1.equals("java.lang.Float") || str1.equals("float")) {
        str2 = "float";
      } else if (str1.equals("java.lang.Long") || str1.equals("long")) {
        str2 = "int64";
      } else if (str1.equals("java.lang.Short") || str1.equals("short")) {
        str2 = "short";
      } else if (!str1.equals("java.lang.Character")) {
        if (str1.equals("java.lang.String")) {
          str2 = "string";
        } else if (str1.equals("java.util.List")) {
          str2 = "list";
        } else {
          str2 = str1;
          if (str1.equals("java.util.Map"))
            str2 = "map"; 
        } 
      } else {
        throw new IllegalArgumentException("can not support java.lang.Character");
      } 
      paramArrayList.set(b, str2);
    } 
    Collections.reverse(paramArrayList);
    for (b = 0; b < paramArrayList.size(); b++) {
      StringBuilder stringBuilder;
      String str = paramArrayList.get(b);
      if (str.equals("list")) {
        int j = b - 1;
        stringBuilder = new StringBuilder("<");
        stringBuilder.append(paramArrayList.get(j));
        paramArrayList.set(j, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramArrayList.get(0));
        stringBuilder.append(">");
        paramArrayList.set(0, stringBuilder.toString());
      } else if (stringBuilder.equals("map")) {
        int j = b - 1;
        stringBuilder = new StringBuilder("<");
        stringBuilder.append(paramArrayList.get(j));
        stringBuilder.append(",");
        paramArrayList.set(j, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramArrayList.get(0));
        stringBuilder.append(">");
        paramArrayList.set(0, stringBuilder.toString());
      } else if (stringBuilder.equals("Array")) {
        int j = b - 1;
        stringBuilder = new StringBuilder("<");
        stringBuilder.append(paramArrayList.get(j));
        paramArrayList.set(j, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramArrayList.get(0));
        stringBuilder.append(">");
        paramArrayList.set(0, stringBuilder.toString());
      } 
    } 
    Collections.reverse(paramArrayList);
    Iterator<String> iterator = paramArrayList.iterator();
    while (iterator.hasNext())
      stringBuffer.append(iterator.next()); 
    return stringBuffer.toString();
  }
  
  public static void a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString)) {
      e = null;
      return;
    } 
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
  }
  
  public static void a(InetAddress paramInetAddress, int paramInt) {
    if (paramInetAddress == null) {
      e = null;
      return;
    } 
    e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramInetAddress, paramInt));
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject) {
    if (paramObject.getClass().isArray()) {
      if (paramObject.getClass().getComponentType().toString().equals("byte")) {
        if (Array.getLength(paramObject) > 0) {
          paramArrayList.add("java.util.List");
          a(paramArrayList, Array.get(paramObject, 0));
          return;
        } 
        paramArrayList.add("Array");
        paramArrayList.add("?");
        return;
      } 
      throw new IllegalArgumentException("only byte[] is supported");
    } 
    if (!(paramObject instanceof Array)) {
      if (paramObject instanceof List) {
        paramArrayList.add("java.util.List");
        paramObject = paramObject;
        if (paramObject.size() > 0) {
          a(paramArrayList, paramObject.get(0));
        } else {
          paramArrayList.add("?");
          return;
        } 
      } else if (paramObject instanceof Map) {
        paramArrayList.add("java.util.Map");
        Map map = (Map)paramObject;
        if (map.size() > 0) {
          paramObject = map.keySet().iterator().next();
          map = (Map)map.get(paramObject);
          paramArrayList.add(paramObject.getClass().getName());
          a(paramArrayList, map);
        } else {
          paramArrayList.add("?");
          paramArrayList.add("?");
          return;
        } 
      } else {
        paramArrayList.add(paramObject.getClass().getName());
      } 
      return;
    } 
    throw new IllegalArgumentException("can not support Array, please use List");
  }
  
  public static byte[] a(k paramk) {
    try {
      j j = new j();
      this();
      j.a("utf-8");
      paramk.a(j);
      return j.b();
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] a(Object paramObject) {
    try {
      d d = new d();
      this();
      d.c();
      d.a("utf-8");
      d.b(1);
      d.b("RqdServer");
      d.c("sync");
      d.a("detail", paramObject);
      return d.a();
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static Proxy b() {
    return e;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public <T> void a(String paramString, T paramT) {
    if (paramString != null) {
      if (paramT != null) {
        if (!(paramT instanceof java.util.Set)) {
          j j = new j();
          j.a(this.b);
          j.a(paramT, 0);
          byte[] arrayOfByte = l.a(j.a());
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
          ArrayList<String> arrayList = new ArrayList(1);
          a(arrayList, paramT);
          hashMap.put(a(arrayList), arrayOfByte);
          this.d.remove(paramString);
          this.a.put(paramString, hashMap);
          return;
        } 
        throw new IllegalArgumentException("can not support Set");
      } 
      throw new IllegalArgumentException("put value can not is null");
    } 
    throw new IllegalArgumentException("put key can not is null");
  }
  
  public void a(byte[] paramArrayOfbyte) {
    this.c.a(paramArrayOfbyte);
    this.c.a(this.b);
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(1);
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>(1);
    hashMap2.put("", new byte[0]);
    hashMap1.put("", hashMap2);
    this.a = this.c.a(hashMap1, 0, false);
  }
  
  public byte[] a() {
    j j = new j(0);
    j.a(this.b);
    j.a(this.a, 0);
    return l.a(j.a());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */