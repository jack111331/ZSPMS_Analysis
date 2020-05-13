package com.unionpay.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.regex.Pattern;

public class d {
  static TelephonyManager a;
  
  static String b;
  
  private static final Pattern c = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");
  
  private static final Pattern d = Pattern.compile("[0-3][0-9a-f]{24,32}");
  
  private static final Pattern e = Pattern.compile("[0-3][0-9a-f]{32}");
  
  private static String f = null;
  
  public static final String a() {
    try {
      if (k.a(9))
        return Build.SERIAL; 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static String a(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc com/unionpay/sdk/d
    //   4: monitorenter
    //   5: getstatic com/unionpay/sdk/d.b : Ljava/lang/String;
    //   8: ifnonnull -> 430
    //   11: aload_0
    //   12: ldc 'tdid'
    //   14: ldc 'pref.deviceid.key'
    //   16: aconst_null
    //   17: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic b : (Ljava/lang/String;)Z
    //   25: ifeq -> 824
    //   28: aload_0
    //   29: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   32: ldc 'pref.deviceid.key'
    //   34: aconst_null
    //   35: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_2
    //   41: new java/io/File
    //   44: astore_3
    //   45: aload_3
    //   46: ldc '/'
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: aload_3
    //   52: invokevirtual listFiles : ()[Ljava/io/File;
    //   55: astore #4
    //   57: aload #4
    //   59: ifnull -> 68
    //   62: aload #4
    //   64: arraylength
    //   65: ifne -> 439
    //   68: aconst_null
    //   69: astore #4
    //   71: invokestatic b : ()Z
    //   74: istore #5
    //   76: bipush #23
    //   78: invokestatic a : (I)Z
    //   81: ifeq -> 632
    //   84: aload_0
    //   85: ldc 'android.permission.READ_EXTERNAL_STORAGE'
    //   87: invokevirtual checkSelfPermission : (Ljava/lang/String;)I
    //   90: ifeq -> 632
    //   93: aconst_null
    //   94: astore_3
    //   95: iconst_3
    //   96: anewarray java/lang/String
    //   99: astore #6
    //   101: aload #6
    //   103: iconst_0
    //   104: aload_2
    //   105: aastore
    //   106: aload #6
    //   108: iconst_1
    //   109: aload #4
    //   111: aastore
    //   112: aload #6
    //   114: iconst_2
    //   115: aload_3
    //   116: aastore
    //   117: aload #6
    //   119: arraylength
    //   120: istore #7
    //   122: iconst_0
    //   123: istore #8
    //   125: iload #8
    //   127: iload #7
    //   129: if_icmpge -> 818
    //   132: aload #6
    //   134: iload #8
    //   136: aaload
    //   137: astore #9
    //   139: aload #9
    //   141: invokestatic b : (Ljava/lang/String;)Z
    //   144: ifne -> 765
    //   147: getstatic com/unionpay/sdk/d.e : Ljava/util/regex/Pattern;
    //   150: aload #9
    //   152: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   155: invokevirtual matches : ()Z
    //   158: ifeq -> 765
    //   161: aload #9
    //   163: invokestatic b : (Ljava/lang/String;)Z
    //   166: ifeq -> 815
    //   169: aload_2
    //   170: invokestatic b : (Ljava/lang/String;)Z
    //   173: ifne -> 815
    //   176: invokestatic random : ()D
    //   179: ldc2_w 0.99
    //   182: dcmpg
    //   183: ifge -> 815
    //   186: aload #6
    //   188: arraylength
    //   189: istore #7
    //   191: iload_1
    //   192: istore #8
    //   194: iload #8
    //   196: iload #7
    //   198: if_icmpge -> 815
    //   201: aload #6
    //   203: iload #8
    //   205: aaload
    //   206: astore #10
    //   208: aload #10
    //   210: invokestatic b : (Ljava/lang/String;)Z
    //   213: ifne -> 771
    //   216: getstatic com/unionpay/sdk/d.d : Ljava/util/regex/Pattern;
    //   219: aload #10
    //   221: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   224: invokevirtual matches : ()Z
    //   227: ifeq -> 771
    //   230: aload #10
    //   232: astore #9
    //   234: aload #9
    //   236: invokestatic b : (Ljava/lang/String;)Z
    //   239: ifeq -> 812
    //   242: new java/lang/StringBuilder
    //   245: astore #9
    //   247: aload #9
    //   249: invokespecial <init> : ()V
    //   252: aload #9
    //   254: aload_0
    //   255: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: bipush #45
    //   263: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: bipush #45
    //   275: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   278: aload_0
    //   279: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload #9
    //   288: invokevirtual toString : ()Ljava/lang/String;
    //   291: astore #9
    //   293: new java/lang/StringBuilder
    //   296: astore #10
    //   298: aload #10
    //   300: ldc '3'
    //   302: invokespecial <init> : (Ljava/lang/String;)V
    //   305: aload #10
    //   307: aload #9
    //   309: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual toString : ()Ljava/lang/String;
    //   318: astore #9
    //   320: aload #9
    //   322: aload_2
    //   323: invokevirtual equals : (Ljava/lang/Object;)Z
    //   326: istore #11
    //   328: iload #11
    //   330: ifne -> 370
    //   333: aload_0
    //   334: ldc 'tdid'
    //   336: iconst_0
    //   337: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   340: astore_2
    //   341: aload_2
    //   342: ifnull -> 370
    //   345: aload_2
    //   346: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   351: astore_2
    //   352: aload_2
    //   353: ldc 'pref.deviceid.key'
    //   355: aload #9
    //   357: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   362: pop
    //   363: aload_2
    //   364: invokeinterface commit : ()Z
    //   369: pop
    //   370: aload #9
    //   372: aload_3
    //   373: invokevirtual equals : (Ljava/lang/Object;)Z
    //   376: ifne -> 409
    //   379: new java/io/File
    //   382: astore_2
    //   383: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   386: astore #10
    //   388: iload #5
    //   390: ifeq -> 777
    //   393: ldc '.tcookieid'
    //   395: astore_3
    //   396: aload_2
    //   397: aload #10
    //   399: aload_3
    //   400: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   403: aload_2
    //   404: aload #9
    //   406: invokestatic a : (Ljava/io/File;Ljava/lang/String;)V
    //   409: aload #9
    //   411: aload #4
    //   413: invokevirtual equals : (Ljava/lang/Object;)Z
    //   416: ifne -> 425
    //   419: aload_0
    //   420: aload #9
    //   422: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   425: aload #9
    //   427: putstatic com/unionpay/sdk/d.b : Ljava/lang/String;
    //   430: getstatic com/unionpay/sdk/d.b : Ljava/lang/String;
    //   433: astore_0
    //   434: ldc com/unionpay/sdk/d
    //   436: monitorexit
    //   437: aload_0
    //   438: areturn
    //   439: aload #4
    //   441: arraylength
    //   442: istore #12
    //   444: aconst_null
    //   445: astore #9
    //   447: iconst_0
    //   448: istore #8
    //   450: aload #9
    //   452: astore_3
    //   453: iload #8
    //   455: iload #12
    //   457: if_icmpge -> 626
    //   460: aload #4
    //   462: iload #8
    //   464: aaload
    //   465: astore #10
    //   467: aload #9
    //   469: astore_3
    //   470: aload #10
    //   472: invokevirtual isDirectory : ()Z
    //   475: ifeq -> 617
    //   478: aload #9
    //   480: astore_3
    //   481: ldc '/sdcard'
    //   483: aload #10
    //   485: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   488: invokevirtual equals : (Ljava/lang/Object;)Z
    //   491: ifne -> 617
    //   494: aload #10
    //   496: invokevirtual canWrite : ()Z
    //   499: ifeq -> 531
    //   502: new java/io/File
    //   505: astore_3
    //   506: aload_3
    //   507: aload #10
    //   509: ldc '.tcookieid'
    //   511: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   514: aload_3
    //   515: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   518: astore #9
    //   520: aload #9
    //   522: astore_3
    //   523: aload #9
    //   525: invokestatic b : (Ljava/lang/String;)Z
    //   528: ifeq -> 626
    //   531: aload #9
    //   533: astore_3
    //   534: aload #10
    //   536: invokevirtual listFiles : ()[Ljava/io/File;
    //   539: ifnull -> 617
    //   542: aload #10
    //   544: invokevirtual listFiles : ()[Ljava/io/File;
    //   547: astore #10
    //   549: aload #10
    //   551: arraylength
    //   552: istore #13
    //   554: iconst_0
    //   555: istore #7
    //   557: aload #9
    //   559: astore_3
    //   560: iload #7
    //   562: iload #13
    //   564: if_icmpge -> 617
    //   567: aload #10
    //   569: iload #7
    //   571: aaload
    //   572: astore_3
    //   573: aload_3
    //   574: invokevirtual isDirectory : ()Z
    //   577: ifeq -> 611
    //   580: new java/io/File
    //   583: astore #9
    //   585: aload #9
    //   587: aload_3
    //   588: ldc '.tcookieid'
    //   590: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   593: aload #9
    //   595: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   598: astore #9
    //   600: aload #9
    //   602: astore_3
    //   603: aload #9
    //   605: invokestatic b : (Ljava/lang/String;)Z
    //   608: ifeq -> 626
    //   611: iinc #7, 1
    //   614: goto -> 557
    //   617: iinc #8, 1
    //   620: aload_3
    //   621: astore #9
    //   623: goto -> 450
    //   626: aload_3
    //   627: astore #4
    //   629: goto -> 71
    //   632: ldc 'mounted'
    //   634: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   637: invokevirtual equals : (Ljava/lang/Object;)Z
    //   640: ifeq -> 759
    //   643: new java/io/File
    //   646: astore #9
    //   648: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   651: astore #10
    //   653: iload #5
    //   655: ifeq -> 734
    //   658: ldc '.tcookieid'
    //   660: astore_3
    //   661: aload #9
    //   663: aload #10
    //   665: aload_3
    //   666: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   669: aload #9
    //   671: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   674: astore #9
    //   676: aload #9
    //   678: astore_3
    //   679: aload #9
    //   681: invokestatic b : (Ljava/lang/String;)Z
    //   684: ifeq -> 731
    //   687: new java/io/File
    //   690: astore_3
    //   691: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   694: astore #9
    //   696: new java/lang/StringBuilder
    //   699: astore #10
    //   701: aload #10
    //   703: ldc '.tid'
    //   705: invokespecial <init> : (Ljava/lang/String;)V
    //   708: aload_3
    //   709: aload #9
    //   711: aload #10
    //   713: aload_0
    //   714: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual toString : ()Ljava/lang/String;
    //   723: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   726: aload_3
    //   727: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   730: astore_3
    //   731: goto -> 95
    //   734: new java/lang/StringBuilder
    //   737: astore_3
    //   738: aload_3
    //   739: ldc '.tcookieid'
    //   741: invokespecial <init> : (Ljava/lang/String;)V
    //   744: aload_3
    //   745: aload_0
    //   746: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   749: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual toString : ()Ljava/lang/String;
    //   755: astore_3
    //   756: goto -> 661
    //   759: ldc ''
    //   761: astore_3
    //   762: goto -> 95
    //   765: iinc #8, 1
    //   768: goto -> 125
    //   771: iinc #8, 1
    //   774: goto -> 194
    //   777: new java/lang/StringBuilder
    //   780: astore_3
    //   781: aload_3
    //   782: ldc '.tcookieid'
    //   784: invokespecial <init> : (Ljava/lang/String;)V
    //   787: aload_3
    //   788: aload_0
    //   789: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   792: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual toString : ()Ljava/lang/String;
    //   798: astore_3
    //   799: goto -> 396
    //   802: astore_0
    //   803: ldc com/unionpay/sdk/d
    //   805: monitorexit
    //   806: aload_0
    //   807: athrow
    //   808: astore_2
    //   809: goto -> 370
    //   812: goto -> 320
    //   815: goto -> 234
    //   818: aconst_null
    //   819: astore #9
    //   821: goto -> 161
    //   824: goto -> 41
    // Exception table:
    //   from	to	target	type
    //   5	41	802	finally
    //   41	57	802	finally
    //   62	68	802	finally
    //   71	93	802	finally
    //   95	101	802	finally
    //   117	122	802	finally
    //   139	161	802	finally
    //   161	191	802	finally
    //   208	230	802	finally
    //   234	320	802	finally
    //   320	328	802	finally
    //   333	341	808	java/lang/Throwable
    //   333	341	802	finally
    //   345	370	808	java/lang/Throwable
    //   345	370	802	finally
    //   370	388	802	finally
    //   396	409	802	finally
    //   409	425	802	finally
    //   425	430	802	finally
    //   430	434	802	finally
    //   439	444	802	finally
    //   470	478	802	finally
    //   481	494	802	finally
    //   494	520	802	finally
    //   523	531	802	finally
    //   534	554	802	finally
    //   573	600	802	finally
    //   603	611	802	finally
    //   632	653	802	finally
    //   661	676	802	finally
    //   679	731	802	finally
    //   734	756	802	finally
    //   777	799	802	finally
  }
  
  private static String a(File paramFile) {
    try {
      if (paramFile.exists() && paramFile.canRead()) {
        FileInputStream fileInputStream = new FileInputStream();
        this(paramFile);
        byte[] arrayOfByte = new byte[128];
        int i = fileInputStream.read(arrayOfByte);
        fileInputStream.close();
        String str = new String();
        this(arrayOfByte, 0, i);
        return str;
      } 
    } catch (Throwable throwable) {}
    return null;
  }
  
  private static void a(Context paramContext, String paramString) {
    File[] arrayOfFile = (new File("/")).listFiles();
    if (arrayOfFile != null && arrayOfFile.length != 0) {
      int i = arrayOfFile.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          file = arrayOfFile[b];
          if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
            if (file.canWrite() && !(new File(file, ".tcookieid" + i(paramContext))).exists())
              a(new File(file, ".tcookieid"), paramString); 
            if (file.listFiles() != null)
              for (File file : file.listFiles()) {
                if (file.isDirectory() && file.canWrite() && !(new File(file, ".tcookieid" + i(paramContext))).exists())
                  a(new File(file, ".tcookieid"), paramString); 
              }  
          } 
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private static void a(File paramFile, String paramString) {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(paramFile);
      fileOutputStream.write(paramString.getBytes());
      fileOutputStream.close();
      if (k.a(9)) {
        paramFile.getClass().getMethod("setReadable", new Class[] { boolean.class, boolean.class }).invoke(paramFile, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
        return;
      } 
      Runtime runtime = Runtime.getRuntime();
      StringBuilder stringBuilder = new StringBuilder();
      this("chmod 444 ");
      runtime.exec(stringBuilder.append(paramFile.getAbsolutePath()).toString());
    } catch (Throwable throwable) {}
  }
  
  public static String b(Context paramContext) {
    try {
      String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  private static boolean b() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: bipush #9
    //   4: invokestatic a : (I)Z
    //   7: ifeq -> 46
    //   10: ldc android/os/Environment
    //   12: ldc_w 'isExternalStorageRemovable'
    //   15: iconst_0
    //   16: anewarray java/lang/Class
    //   19: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   22: aconst_null
    //   23: iconst_0
    //   24: anewarray java/lang/Object
    //   27: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast java/lang/Boolean
    //   33: invokevirtual booleanValue : ()Z
    //   36: istore_1
    //   37: iload_1
    //   38: ifne -> 51
    //   41: iload_0
    //   42: istore_1
    //   43: iload_1
    //   44: ireturn
    //   45: astore_2
    //   46: iconst_1
    //   47: istore_1
    //   48: goto -> 37
    //   51: iconst_0
    //   52: istore_1
    //   53: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   2	37	45	java/lang/Throwable
  }
  
  public static String c(Context paramContext) {
    // Byte code:
    //   0: bipush #23
    //   2: invokestatic a : (I)Z
    //   5: ifeq -> 22
    //   8: aload_0
    //   9: ldc_w 'android.permission.READ_PHONE_STATE'
    //   12: invokevirtual checkSelfPermission : (Ljava/lang/String;)I
    //   15: ifeq -> 22
    //   18: aconst_null
    //   19: astore_0
    //   20: aload_0
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 'android.permission.READ_PHONE_STATE'
    //   26: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   29: ifeq -> 96
    //   32: getstatic com/unionpay/sdk/d.a : Landroid/telephony/TelephonyManager;
    //   35: ifnonnull -> 42
    //   38: aload_0
    //   39: invokestatic init : (Landroid/content/Context;)V
    //   42: aload_0
    //   43: invokestatic y : (Landroid/content/Context;)Lorg/json/JSONArray;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull -> 90
    //   51: aload_0
    //   52: invokevirtual length : ()I
    //   55: istore_1
    //   56: iload_1
    //   57: iconst_2
    //   58: if_icmpne -> 90
    //   61: aload_0
    //   62: iconst_1
    //   63: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   66: ldc_w 'imei'
    //   69: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_2
    //   76: ifnonnull -> 20
    //   79: getstatic com/unionpay/sdk/d.a : Landroid/telephony/TelephonyManager;
    //   82: invokevirtual getDeviceId : ()Ljava/lang/String;
    //   85: astore_0
    //   86: goto -> 20
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_2
    //   92: goto -> 73
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_0
    //   98: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   0	18	95	java/lang/Throwable
    //   22	42	95	java/lang/Throwable
    //   42	47	95	java/lang/Throwable
    //   51	56	95	java/lang/Throwable
    //   61	73	89	java/lang/Exception
    //   61	73	95	java/lang/Throwable
    //   79	86	95	java/lang/Throwable
  }
  
  public static String d(Context paramContext) {
    String str2;
    String str1 = null;
    try {
      if (k.a(23) && paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        return str1; 
      str2 = str1;
      if (k.b(paramContext, "android.permission.READ_PHONE_STATE")) {
        if (a == null)
          init(paramContext); 
        str2 = a.getSimSerialNumber();
      } 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
  
  public static String e(Context paramContext) {
    String str2;
    String str1 = null;
    try {
      if (k.a(23) && paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0)
        return str1; 
      str2 = str1;
      if (k.b(paramContext, "android.permission.READ_PHONE_STATE")) {
        if (a == null)
          init(paramContext); 
        str2 = a.getSubscriberId();
      } 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
  
  public static String f(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: getstatic com/unionpay/sdk/k.b : Z
    //   9: ifne -> 16
    //   12: aload_3
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: bipush #23
    //   18: invokestatic a : (I)Z
    //   21: istore #4
    //   23: iload #4
    //   25: ifeq -> 256
    //   28: aload_2
    //   29: astore_3
    //   30: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   33: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull -> 52
    //   41: aload_2
    //   42: astore_3
    //   43: aload_0
    //   44: invokeinterface size : ()I
    //   49: ifgt -> 59
    //   52: ldc_w '02:00:00:00:00:00'
    //   55: astore_0
    //   56: goto -> 14
    //   59: aload_2
    //   60: astore_3
    //   61: aload_0
    //   62: invokeinterface iterator : ()Ljava/util/Iterator;
    //   67: astore_2
    //   68: aload_1
    //   69: astore_0
    //   70: aload_0
    //   71: astore_3
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: invokeinterface hasNext : ()Z
    //   80: ifeq -> 236
    //   83: aload_0
    //   84: astore_3
    //   85: aload_2
    //   86: invokeinterface next : ()Ljava/lang/Object;
    //   91: checkcast java/net/NetworkInterface
    //   94: astore_1
    //   95: aload_0
    //   96: astore_3
    //   97: aload_1
    //   98: invokevirtual getName : ()Ljava/lang/String;
    //   101: ldc_w 'wlan0'
    //   104: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   107: ifeq -> 70
    //   110: aload_0
    //   111: astore_3
    //   112: aload_1
    //   113: invokevirtual getHardwareAddress : ()[B
    //   116: astore_1
    //   117: aload_1
    //   118: ifnonnull -> 127
    //   121: ldc ''
    //   123: astore_0
    //   124: goto -> 14
    //   127: aload_0
    //   128: astore_3
    //   129: new java/lang/StringBuilder
    //   132: astore #5
    //   134: aload_0
    //   135: astore_3
    //   136: aload #5
    //   138: invokespecial <init> : ()V
    //   141: aload_0
    //   142: astore_3
    //   143: aload_1
    //   144: arraylength
    //   145: istore #6
    //   147: iconst_0
    //   148: istore #7
    //   150: iload #7
    //   152: iload #6
    //   154: if_icmpge -> 191
    //   157: aload_0
    //   158: astore_3
    //   159: aload #5
    //   161: ldc_w '%02X:'
    //   164: iconst_1
    //   165: anewarray java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: iload #7
    //   173: baload
    //   174: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   177: aastore
    //   178: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: iinc #7, 1
    //   188: goto -> 150
    //   191: aload_0
    //   192: astore_3
    //   193: aload #5
    //   195: invokevirtual length : ()I
    //   198: ifle -> 216
    //   201: aload_0
    //   202: astore_3
    //   203: aload #5
    //   205: aload #5
    //   207: invokevirtual length : ()I
    //   210: iconst_1
    //   211: isub
    //   212: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_0
    //   217: astore_3
    //   218: aload #5
    //   220: invokevirtual toString : ()Ljava/lang/String;
    //   223: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   226: invokevirtual trim : ()Ljava/lang/String;
    //   229: astore_0
    //   230: goto -> 70
    //   233: astore_0
    //   234: aload_3
    //   235: astore_1
    //   236: aload_1
    //   237: invokestatic b : (Ljava/lang/String;)Z
    //   240: istore #4
    //   242: aload_1
    //   243: astore_0
    //   244: iload #4
    //   246: ifeq -> 14
    //   249: ldc_w '02:00:00:00:00:00'
    //   252: astore_0
    //   253: goto -> 14
    //   256: aload_0
    //   257: ldc_w 'android.permission.ACCESS_WIFI_STATE'
    //   260: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Z
    //   263: ifeq -> 368
    //   266: aload_0
    //   267: ldc_w 'wifi'
    //   270: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   273: checkcast android/net/wifi/WifiManager
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual isWifiEnabled : ()Z
    //   281: ifeq -> 368
    //   284: aload_0
    //   285: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   288: astore_0
    //   289: aload_0
    //   290: ifnull -> 368
    //   293: aload_0
    //   294: invokevirtual getMacAddress : ()Ljava/lang/String;
    //   297: astore_1
    //   298: aload_1
    //   299: astore_0
    //   300: aload_1
    //   301: ifnull -> 349
    //   304: aload_1
    //   305: astore_0
    //   306: aload_1
    //   307: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   310: invokevirtual trim : ()Ljava/lang/String;
    //   313: astore_1
    //   314: aload_1
    //   315: astore_0
    //   316: ldc_w '00:00:00:00:00:00'
    //   319: aload_1
    //   320: invokevirtual equals : (Ljava/lang/Object;)Z
    //   323: ifne -> 347
    //   326: aload_1
    //   327: astore_0
    //   328: getstatic com/unionpay/sdk/d.c : Ljava/util/regex/Pattern;
    //   331: aload_1
    //   332: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   335: invokevirtual matches : ()Z
    //   338: istore #4
    //   340: aload_1
    //   341: astore_0
    //   342: iload #4
    //   344: ifne -> 349
    //   347: aconst_null
    //   348: astore_0
    //   349: goto -> 14
    //   352: astore_0
    //   353: aconst_null
    //   354: astore_0
    //   355: goto -> 349
    //   358: astore_0
    //   359: aload_1
    //   360: astore_0
    //   361: goto -> 349
    //   364: astore_1
    //   365: goto -> 349
    //   368: aconst_null
    //   369: astore_0
    //   370: goto -> 349
    // Exception table:
    //   from	to	target	type
    //   16	23	352	java/lang/Throwable
    //   30	37	233	java/lang/Throwable
    //   43	52	233	java/lang/Throwable
    //   61	68	233	java/lang/Throwable
    //   74	83	233	java/lang/Throwable
    //   85	95	233	java/lang/Throwable
    //   97	110	233	java/lang/Throwable
    //   112	117	233	java/lang/Throwable
    //   129	134	233	java/lang/Throwable
    //   136	141	233	java/lang/Throwable
    //   143	147	233	java/lang/Throwable
    //   159	185	233	java/lang/Throwable
    //   193	201	233	java/lang/Throwable
    //   203	216	233	java/lang/Throwable
    //   218	230	233	java/lang/Throwable
    //   236	242	358	java/lang/Throwable
    //   256	289	352	java/lang/Throwable
    //   293	298	352	java/lang/Throwable
    //   306	314	364	java/lang/Throwable
    //   316	326	364	java/lang/Throwable
    //   328	340	364	java/lang/Throwable
  }
  
  public static final String g(Context paramContext) {
    try {
      object = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      object = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(object, new Object[0]);
    } catch (Throwable object) {
      object = null;
    } 
    return (String)object;
  }
  
  public static final String h(Context paramContext) {
    String str2 = f(paramContext);
    String str3 = str2;
    if (!TextUtils.isEmpty(str2))
      str3 = String.valueOf(Long.parseLong(str2.replaceAll(":", ""), 16)); 
    str2 = b(paramContext);
    String str4 = c(paramContext);
    String str5 = e(paramContext);
    String str6 = d(paramContext);
    String str7 = a(paramContext);
    String str1 = g(paramContext);
    String str8 = a();
    return "2|" + str3 + "|" + str2 + "|" + str4 + "|" + str5 + "|" + str6 + "|" + str7 + "|" + str1 + "|" + str8;
  }
  
  private static String i(Context paramContext) {
    if (f == null) {
      try {
        List list = ((SensorManager)paramContext.getSystemService("sensor")).getSensorList(-1);
        Sensor[] arrayOfSensor = new Sensor[64];
        for (Sensor sensor : list) {
          if (sensor.getType() < arrayOfSensor.length && sensor.getType() >= 0)
            arrayOfSensor[sensor.getType()] = sensor; 
        } 
      } catch (Throwable throwable) {
        return f;
      } 
    } else {
      return f;
    } 
    StringBuffer stringBuffer = new StringBuffer();
    this();
    for (byte b = 0; b < throwable.length; b++) {
      if (throwable[b] != null)
        stringBuffer.append(b).append('.').append(throwable[b].getVendor()).append('-').append(throwable[b].getName()).append('-').append(throwable[b].getVersion()).append('\n'); 
    } 
    f = String.valueOf(stringBuffer.toString().hashCode());
    return f;
  }
  
  public static void init(Context paramContext) {
    a = (TelephonyManager)paramContext.getSystemService("phone");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */