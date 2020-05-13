package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.c;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.security.mobile.module.http.d;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import java.io.File;
import java.util.Map;

public final class a {
  private Context a;
  
  private com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
  
  private int c = 4;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  public static String a(Context paramContext) {
    String str1 = b(paramContext);
    String str2 = str1;
    if (com.alipay.security.mobile.module.a.a.a(str1))
      str2 = h.f(paramContext); 
    return str2;
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      b();
      String str2 = i.a(paramString);
      if (!com.alipay.security.mobile.module.a.a.a(str2))
        return str2; 
      String str1 = g.a(paramContext, paramString);
      i.a(paramString, str1);
      boolean bool = com.alipay.security.mobile.module.a.a.a(str1);
      return bool ? "" : str1;
    } catch (Throwable throwable) {}
    return "";
  }
  
  private static boolean a() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: new java/text/SimpleDateFormat
    //   5: dup
    //   6: ldc 'yyyy-MM-dd HH:mm:ss'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: astore_1
    //   12: invokestatic random : ()D
    //   15: ldc2_w 24.0
    //   18: dmul
    //   19: ldc2_w 60.0
    //   22: dmul
    //   23: ldc2_w 60.0
    //   26: dmul
    //   27: d2i
    //   28: istore_2
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: iconst_3
    //   33: if_icmpge -> 214
    //   36: iconst_3
    //   37: anewarray java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc '2017-01-27 2017-01-28'
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc '2017-11-10 2017-11-11'
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc '2017-12-11 2017-12-12'
    //   54: aastore
    //   55: iload_3
    //   56: aaload
    //   57: ldc ' '
    //   59: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore #4
    //   64: aload #4
    //   66: ifnull -> 207
    //   69: aload #4
    //   71: arraylength
    //   72: iconst_2
    //   73: if_icmpne -> 207
    //   76: new java/util/Date
    //   79: astore #5
    //   81: aload #5
    //   83: invokespecial <init> : ()V
    //   86: new java/lang/StringBuilder
    //   89: astore #6
    //   91: aload #6
    //   93: invokespecial <init> : ()V
    //   96: aload_1
    //   97: aload #6
    //   99: aload #4
    //   101: iconst_0
    //   102: aaload
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc ' 00:00:00'
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   117: astore #6
    //   119: new java/lang/StringBuilder
    //   122: astore #7
    //   124: aload #7
    //   126: invokespecial <init> : ()V
    //   129: aload_1
    //   130: aload #7
    //   132: aload #4
    //   134: iconst_1
    //   135: aaload
    //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc ' 23:59:59'
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   150: astore #7
    //   152: invokestatic getInstance : ()Ljava/util/Calendar;
    //   155: astore #4
    //   157: aload #4
    //   159: aload #7
    //   161: invokevirtual setTime : (Ljava/util/Date;)V
    //   164: aload #4
    //   166: bipush #13
    //   168: iload_2
    //   169: iconst_1
    //   170: imul
    //   171: invokevirtual add : (II)V
    //   174: aload #4
    //   176: invokevirtual getTime : ()Ljava/util/Date;
    //   179: astore #4
    //   181: aload #5
    //   183: aload #6
    //   185: invokevirtual after : (Ljava/util/Date;)Z
    //   188: ifeq -> 207
    //   191: aload #5
    //   193: aload #4
    //   195: invokevirtual before : (Ljava/util/Date;)Z
    //   198: istore #8
    //   200: iload #8
    //   202: ifeq -> 207
    //   205: iload_0
    //   206: ireturn
    //   207: iinc #3, 1
    //   210: goto -> 31
    //   213: astore_1
    //   214: iconst_0
    //   215: istore_0
    //   216: goto -> 205
    // Exception table:
    //   from	to	target	type
    //   36	64	213	java/lang/Exception
    //   69	200	213	java/lang/Exception
  }
  
  private c b(Map<String, String> paramMap) {
    try {
      Context context = this.a;
      d d = new d();
      this();
      String str1 = com.alipay.security.mobile.module.a.a.a(paramMap, "appName", "");
      String str2 = com.alipay.security.mobile.module.a.a.a(paramMap, "sessionId", "");
      String str3 = com.alipay.security.mobile.module.a.a.a(paramMap, "rpcVersion", "");
      String str4 = a(context, str1);
      String str6 = UmidSdkWrapper.getSecurityToken(context);
      str1 = h.d(context);
      if (com.alipay.security.mobile.module.a.a.b(str2)) {
        d.c = str2;
      } else {
        d.c = str4;
      } 
      d.d = str6;
      d.e = str1;
      d.a = "android";
      String str7 = "";
      str1 = "";
      str2 = "";
      String str8 = "";
      c c1 = d.c(context);
      if (c1 != null) {
        str1 = c1.a();
        str2 = c1.c();
      } 
      str4 = str2;
      String str5 = str1;
      if (com.alipay.security.mobile.module.a.a.a(str1)) {
        b b = com.alipay.apmobilesecuritysdk.e.a.c(context);
        str4 = str2;
        str5 = str1;
        if (b != null) {
          str5 = b.a();
          str4 = b.c();
        } 
      } 
      c c2 = d.b();
      str2 = str8;
      str1 = str7;
      if (c2 != null) {
        str1 = c2.a();
        str2 = c2.c();
      } 
      str8 = str2;
      str7 = str1;
      if (com.alipay.security.mobile.module.a.a.a(str1)) {
        b b = com.alipay.apmobilesecuritysdk.e.a.b();
        str8 = str2;
        str7 = str1;
        if (b != null) {
          str7 = b.a();
          str8 = b.c();
        } 
      } 
      d.h = str5;
      d.g = str7;
      d.j = str3;
      if (com.alipay.security.mobile.module.a.a.a(str5)) {
        d.b = str7;
        d.i = str8;
      } else {
        d.b = str5;
        d.i = str4;
      } 
      d.f = e.a(context, paramMap);
      c c = d.a(this.a, this.b.c()).a(d);
    } catch (Throwable throwable) {
      com.alipay.apmobilesecuritysdk.c.a.a(throwable);
      throwable = null;
    } 
    return (c)throwable;
  }
  
  private static String b(Context paramContext) {
    // Byte code:
    //   0: invokestatic b : ()Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: invokestatic a : (Ljava/lang/String;)Z
    //   8: ifne -> 13
    //   11: aload_1
    //   12: areturn
    //   13: aload_0
    //   14: invokestatic b : (Landroid/content/Context;)Lcom/alipay/apmobilesecuritysdk/e/c;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull -> 40
    //   22: aload_1
    //   23: invokestatic a : (Lcom/alipay/apmobilesecuritysdk/e/c;)V
    //   26: aload_1
    //   27: invokevirtual a : ()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokestatic b : (Ljava/lang/String;)Z
    //   37: ifne -> 11
    //   40: aload_0
    //   41: invokestatic b : (Landroid/content/Context;)Lcom/alipay/apmobilesecuritysdk/e/b;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull -> 67
    //   49: aload_0
    //   50: invokestatic a : (Lcom/alipay/apmobilesecuritysdk/e/b;)V
    //   53: aload_0
    //   54: invokevirtual a : ()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_1
    //   59: invokestatic b : (Ljava/lang/String;)Z
    //   62: istore_3
    //   63: iload_3
    //   64: ifne -> 11
    //   67: ldc ''
    //   69: astore_1
    //   70: goto -> 11
    //   73: astore_0
    //   74: goto -> 67
    // Exception table:
    //   from	to	target	type
    //   0	11	73	java/lang/Throwable
    //   13	18	73	java/lang/Throwable
    //   22	31	73	java/lang/Throwable
    //   33	40	73	java/lang/Throwable
    //   40	45	73	java/lang/Throwable
    //   49	63	73	java/lang/Throwable
  }
  
  private static void b() {
    byte b = 0;
    while (b < 5) {
      try {
        (new String[5])[0] = "device_feature_file_name";
        (new String[5])[1] = "wallet_times";
        (new String[5])[2] = "wxcasxx_v3";
        (new String[5])[3] = "wxcasxx_v4";
        (new String[5])[4] = "wxxzyy_v1";
        String str = (new String[5])[b];
        File file1 = new File();
        File file2 = Environment.getExternalStorageDirectory();
        StringBuilder stringBuilder = new StringBuilder();
        this(".SystemConfig/");
        this(file2, stringBuilder.append(str).toString());
        if (file1.exists() && file1.canWrite())
          file1.delete(); 
        b++;
      } catch (Throwable throwable) {
        break;
      } 
    } 
  }
  
  public final int a(Map<String, String> paramMap) {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: aload_0
    //   5: getfield a : Landroid/content/Context;
    //   8: aload_1
    //   9: ldc_w 'tid'
    //   12: ldc ''
    //   14: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: aload_1
    //   18: ldc_w 'utdid'
    //   21: ldc ''
    //   23: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: aload_0
    //   27: getfield a : Landroid/content/Context;
    //   30: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   33: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_1
    //   37: ldc 'appName'
    //   39: ldc ''
    //   41: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore #4
    //   46: invokestatic b : ()V
    //   49: aload_0
    //   50: getfield a : Landroid/content/Context;
    //   53: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   56: pop
    //   57: aload_0
    //   58: getfield a : Landroid/content/Context;
    //   61: aload #4
    //   63: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   66: pop
    //   67: invokestatic a : ()V
    //   70: invokestatic a : ()Z
    //   73: ifne -> 86
    //   76: aload_0
    //   77: getfield a : Landroid/content/Context;
    //   80: invokestatic a : (Landroid/content/Context;)Z
    //   83: ifeq -> 318
    //   86: aload_0
    //   87: getfield a : Landroid/content/Context;
    //   90: aload #4
    //   92: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   95: invokestatic a : (Ljava/lang/String;)Z
    //   98: ifeq -> 293
    //   101: iconst_1
    //   102: istore #5
    //   104: aload_0
    //   105: getfield a : Landroid/content/Context;
    //   108: astore #6
    //   110: invokestatic a : ()Lcom/alipay/security/mobile/module/b/b;
    //   113: pop
    //   114: aload #6
    //   116: invokestatic p : ()Ljava/lang/String;
    //   119: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   122: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   125: iload #5
    //   127: ifne -> 494
    //   130: iconst_0
    //   131: istore #5
    //   133: aload_0
    //   134: iload #5
    //   136: putfield c : I
    //   139: aload_0
    //   140: getfield a : Landroid/content/Context;
    //   143: aload_0
    //   144: getfield b : Lcom/alipay/apmobilesecuritysdk/b/a;
    //   147: invokevirtual c : ()Ljava/lang/String;
    //   150: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Lcom/alipay/security/mobile/module/http/v2/a;
    //   153: astore #6
    //   155: aload_0
    //   156: getfield a : Landroid/content/Context;
    //   159: astore #4
    //   161: aload #4
    //   163: ldc_w 'connectivity'
    //   166: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   169: checkcast android/net/ConnectivityManager
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull -> 1005
    //   177: aload_1
    //   178: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   181: astore_1
    //   182: aload_1
    //   183: ifnull -> 999
    //   186: aload_1
    //   187: invokevirtual isConnected : ()Z
    //   190: ifeq -> 999
    //   193: aload_1
    //   194: invokevirtual getType : ()I
    //   197: iconst_1
    //   198: if_icmpne -> 999
    //   201: iload_3
    //   202: istore #5
    //   204: iload #5
    //   206: ifeq -> 288
    //   209: aload #4
    //   211: invokestatic c : (Landroid/content/Context;)Z
    //   214: ifeq -> 288
    //   217: new java/lang/StringBuilder
    //   220: astore_1
    //   221: aload_1
    //   222: invokespecial <init> : ()V
    //   225: aload_1
    //   226: aload #4
    //   228: invokevirtual getFilesDir : ()Ljava/io/File;
    //   231: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w '/log/ap'
    //   240: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual toString : ()Ljava/lang/String;
    //   246: astore #4
    //   248: new com/alipay/security/mobile/module/d/b
    //   251: astore_1
    //   252: aload_1
    //   253: aload #4
    //   255: aload #6
    //   257: invokespecial <init> : (Ljava/lang/String;Lcom/alipay/security/mobile/module/http/v2/a;)V
    //   260: new java/lang/Thread
    //   263: astore #4
    //   265: new com/alipay/security/mobile/module/d/c
    //   268: astore #6
    //   270: aload #6
    //   272: aload_1
    //   273: invokespecial <init> : (Lcom/alipay/security/mobile/module/d/b;)V
    //   276: aload #4
    //   278: aload #6
    //   280: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   283: aload #4
    //   285: invokevirtual start : ()V
    //   288: aload_0
    //   289: getfield c : I
    //   292: ireturn
    //   293: aload_0
    //   294: getfield a : Landroid/content/Context;
    //   297: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   300: invokestatic a : (Ljava/lang/String;)Z
    //   303: ifeq -> 312
    //   306: iconst_1
    //   307: istore #5
    //   309: goto -> 104
    //   312: iconst_0
    //   313: istore #5
    //   315: goto -> 104
    //   318: invokestatic a : ()V
    //   321: aload_0
    //   322: getfield a : Landroid/content/Context;
    //   325: aload_1
    //   326: invokestatic b : (Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;
    //   329: invokestatic c : ()Ljava/lang/String;
    //   332: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   335: ifne -> 352
    //   338: iconst_1
    //   339: istore #5
    //   341: iload #5
    //   343: ifeq -> 358
    //   346: iconst_1
    //   347: istore #5
    //   349: goto -> 104
    //   352: iconst_0
    //   353: istore #5
    //   355: goto -> 341
    //   358: aload_1
    //   359: ldc_w 'tid'
    //   362: ldc ''
    //   364: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   367: astore #6
    //   369: aload_1
    //   370: ldc_w 'utdid'
    //   373: ldc ''
    //   375: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   378: astore #7
    //   380: aload #6
    //   382: invokestatic b : (Ljava/lang/String;)Z
    //   385: ifeq -> 405
    //   388: aload #6
    //   390: invokestatic d : ()Ljava/lang/String;
    //   393: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   396: ifne -> 405
    //   399: iconst_1
    //   400: istore #5
    //   402: goto -> 104
    //   405: aload #7
    //   407: invokestatic b : (Ljava/lang/String;)Z
    //   410: ifeq -> 430
    //   413: aload #7
    //   415: invokestatic e : ()Ljava/lang/String;
    //   418: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   421: ifne -> 430
    //   424: iconst_1
    //   425: istore #5
    //   427: goto -> 104
    //   430: aload_0
    //   431: getfield a : Landroid/content/Context;
    //   434: aload #4
    //   436: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   439: ifne -> 448
    //   442: iconst_1
    //   443: istore #5
    //   445: goto -> 104
    //   448: aload_0
    //   449: getfield a : Landroid/content/Context;
    //   452: aload #4
    //   454: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   457: invokestatic a : (Ljava/lang/String;)Z
    //   460: ifeq -> 469
    //   463: iconst_1
    //   464: istore #5
    //   466: goto -> 104
    //   469: aload_0
    //   470: getfield a : Landroid/content/Context;
    //   473: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   476: invokestatic a : (Ljava/lang/String;)Z
    //   479: ifeq -> 488
    //   482: iconst_1
    //   483: istore #5
    //   485: goto -> 104
    //   488: iconst_0
    //   489: istore #5
    //   491: goto -> 104
    //   494: new com/alipay/apmobilesecuritysdk/c/b
    //   497: invokespecial <init> : ()V
    //   500: aload_0
    //   501: getfield a : Landroid/content/Context;
    //   504: invokestatic a : ()Lcom/alipay/apmobilesecuritysdk/b/a;
    //   507: invokevirtual b : ()I
    //   510: invokestatic startUmidTaskSync : (Landroid/content/Context;I)Ljava/lang/String;
    //   513: pop
    //   514: aload_0
    //   515: aload_1
    //   516: invokespecial b : (Ljava/util/Map;)Lcom/alipay/security/mobile/module/http/model/c;
    //   519: astore #7
    //   521: iload_2
    //   522: istore #5
    //   524: aload #7
    //   526: ifnull -> 554
    //   529: aload #7
    //   531: getfield a : Z
    //   534: ifeq -> 636
    //   537: iload_2
    //   538: istore #5
    //   540: aload #7
    //   542: getfield h : Ljava/lang/String;
    //   545: invokestatic a : (Ljava/lang/String;)Z
    //   548: ifne -> 554
    //   551: iconst_1
    //   552: istore #5
    //   554: iload #5
    //   556: tableswitch default -> 584, 1 -> 659, 2 -> 584, 3 -> 976
    //   584: aload #7
    //   586: ifnull -> 982
    //   589: new java/lang/StringBuilder
    //   592: astore_1
    //   593: aload_1
    //   594: ldc_w 'Server error, result:'
    //   597: invokespecial <init> : (Ljava/lang/String;)V
    //   600: aload_1
    //   601: aload #7
    //   603: getfield b : Ljava/lang/String;
    //   606: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual toString : ()Ljava/lang/String;
    //   612: invokestatic a : (Ljava/lang/String;)V
    //   615: aload_0
    //   616: getfield a : Landroid/content/Context;
    //   619: aload #4
    //   621: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   624: invokestatic a : (Ljava/lang/String;)Z
    //   627: ifeq -> 945
    //   630: iconst_4
    //   631: istore #5
    //   633: goto -> 133
    //   636: iload_2
    //   637: istore #5
    //   639: ldc_w 'APPKEY_ERROR'
    //   642: aload #7
    //   644: getfield b : Ljava/lang/String;
    //   647: invokevirtual equals : (Ljava/lang/Object;)Z
    //   650: ifeq -> 554
    //   653: iconst_3
    //   654: istore #5
    //   656: goto -> 554
    //   659: aload_0
    //   660: getfield a : Landroid/content/Context;
    //   663: ldc_w '1'
    //   666: aload #7
    //   668: getfield j : Ljava/lang/String;
    //   671: invokevirtual equals : (Ljava/lang/Object;)Z
    //   674: invokestatic a : (Landroid/content/Context;Z)V
    //   677: aload_0
    //   678: getfield a : Landroid/content/Context;
    //   681: astore #8
    //   683: aload #7
    //   685: getfield k : Ljava/lang/String;
    //   688: ifnonnull -> 951
    //   691: ldc_w '0'
    //   694: astore #6
    //   696: aload #8
    //   698: aload #6
    //   700: invokestatic d : (Landroid/content/Context;Ljava/lang/String;)V
    //   703: aload_0
    //   704: getfield a : Landroid/content/Context;
    //   707: aload #7
    //   709: getfield l : Ljava/lang/String;
    //   712: invokestatic e : (Landroid/content/Context;Ljava/lang/String;)V
    //   715: aload_0
    //   716: getfield a : Landroid/content/Context;
    //   719: aload #7
    //   721: getfield m : Ljava/lang/String;
    //   724: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   727: aload_0
    //   728: getfield a : Landroid/content/Context;
    //   731: aload #7
    //   733: getfield n : Ljava/lang/String;
    //   736: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)V
    //   739: aload_0
    //   740: getfield a : Landroid/content/Context;
    //   743: aload #7
    //   745: getfield p : Ljava/lang/String;
    //   748: invokestatic g : (Landroid/content/Context;Ljava/lang/String;)V
    //   751: aload_0
    //   752: getfield a : Landroid/content/Context;
    //   755: aload_1
    //   756: invokestatic b : (Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;
    //   759: invokestatic c : (Ljava/lang/String;)V
    //   762: aload #4
    //   764: aload #7
    //   766: getfield i : Ljava/lang/String;
    //   769: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   772: aload #7
    //   774: getfield h : Ljava/lang/String;
    //   777: invokestatic b : (Ljava/lang/String;)V
    //   780: aload #7
    //   782: getfield o : Ljava/lang/String;
    //   785: invokestatic d : (Ljava/lang/String;)V
    //   788: aload_1
    //   789: ldc_w 'tid'
    //   792: ldc ''
    //   794: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   797: astore #6
    //   799: aload #6
    //   801: invokestatic b : (Ljava/lang/String;)Z
    //   804: ifeq -> 961
    //   807: aload #6
    //   809: invokestatic d : ()Ljava/lang/String;
    //   812: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   815: ifne -> 961
    //   818: aload #6
    //   820: invokestatic e : (Ljava/lang/String;)V
    //   823: aload #6
    //   825: invokestatic e : (Ljava/lang/String;)V
    //   828: aload_1
    //   829: ldc_w 'utdid'
    //   832: ldc ''
    //   834: invokestatic a : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   837: astore_1
    //   838: aload_1
    //   839: invokestatic b : (Ljava/lang/String;)Z
    //   842: ifeq -> 969
    //   845: aload_1
    //   846: invokestatic e : ()Ljava/lang/String;
    //   849: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   852: ifne -> 969
    //   855: aload_1
    //   856: invokestatic f : (Ljava/lang/String;)V
    //   859: aload_1
    //   860: invokestatic f : (Ljava/lang/String;)V
    //   863: invokestatic a : ()V
    //   866: invokestatic g : ()Lcom/alipay/apmobilesecuritysdk/e/c;
    //   869: astore_1
    //   870: aload_0
    //   871: getfield a : Landroid/content/Context;
    //   874: aload_1
    //   875: invokestatic a : (Landroid/content/Context;Lcom/alipay/apmobilesecuritysdk/e/c;)V
    //   878: invokestatic a : ()V
    //   881: aload_0
    //   882: getfield a : Landroid/content/Context;
    //   885: astore_1
    //   886: new com/alipay/apmobilesecuritysdk/e/b
    //   889: astore #6
    //   891: aload #6
    //   893: invokestatic b : ()Ljava/lang/String;
    //   896: invokestatic c : ()Ljava/lang/String;
    //   899: invokestatic f : ()Ljava/lang/String;
    //   902: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload_1
    //   906: aload #6
    //   908: invokestatic a : (Landroid/content/Context;Lcom/alipay/apmobilesecuritysdk/e/b;)V
    //   911: invokestatic a : ()V
    //   914: aload #4
    //   916: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   919: astore_1
    //   920: aload_0
    //   921: getfield a : Landroid/content/Context;
    //   924: aload #4
    //   926: aload_1
    //   927: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   930: invokestatic a : ()V
    //   933: aload_0
    //   934: getfield a : Landroid/content/Context;
    //   937: aload #4
    //   939: invokestatic currentTimeMillis : ()J
    //   942: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)V
    //   945: iconst_0
    //   946: istore #5
    //   948: goto -> 133
    //   951: aload #7
    //   953: getfield k : Ljava/lang/String;
    //   956: astore #6
    //   958: goto -> 696
    //   961: invokestatic d : ()Ljava/lang/String;
    //   964: astore #6
    //   966: goto -> 823
    //   969: invokestatic e : ()Ljava/lang/String;
    //   972: astore_1
    //   973: goto -> 859
    //   976: iconst_1
    //   977: istore #5
    //   979: goto -> 133
    //   982: ldc_w 'Server error, returned null'
    //   985: invokestatic a : (Ljava/lang/String;)V
    //   988: goto -> 615
    //   991: astore_1
    //   992: aload_1
    //   993: invokestatic a : (Ljava/lang/Throwable;)V
    //   996: goto -> 288
    //   999: iconst_0
    //   1000: istore #5
    //   1002: goto -> 204
    //   1005: aconst_null
    //   1006: astore_1
    //   1007: goto -> 182
    // Exception table:
    //   from	to	target	type
    //   4	86	991	java/lang/Exception
    //   86	101	991	java/lang/Exception
    //   104	125	991	java/lang/Exception
    //   133	173	991	java/lang/Exception
    //   177	182	991	java/lang/Exception
    //   186	201	991	java/lang/Exception
    //   209	288	991	java/lang/Exception
    //   293	306	991	java/lang/Exception
    //   318	338	991	java/lang/Exception
    //   358	399	991	java/lang/Exception
    //   405	424	991	java/lang/Exception
    //   430	442	991	java/lang/Exception
    //   448	463	991	java/lang/Exception
    //   469	482	991	java/lang/Exception
    //   494	521	991	java/lang/Exception
    //   529	537	991	java/lang/Exception
    //   540	551	991	java/lang/Exception
    //   589	615	991	java/lang/Exception
    //   615	630	991	java/lang/Exception
    //   639	653	991	java/lang/Exception
    //   659	691	991	java/lang/Exception
    //   696	823	991	java/lang/Exception
    //   823	859	991	java/lang/Exception
    //   859	945	991	java/lang/Exception
    //   951	958	991	java/lang/Exception
    //   961	966	991	java/lang/Exception
    //   969	973	991	java/lang/Exception
    //   982	988	991	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */