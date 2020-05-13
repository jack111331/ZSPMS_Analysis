package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
  private static List<File> a = new ArrayList<File>();
  
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 302
    //   4: aload_1
    //   5: ifnull -> 302
    //   8: aload_2
    //   9: ifnonnull -> 15
    //   12: goto -> 302
    //   15: new java/io/File
    //   18: dup
    //   19: aload_1
    //   20: ldc 'rqd_record.eup'
    //   22: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual exists : ()Z
    //   30: ifeq -> 300
    //   33: aload_1
    //   34: invokevirtual canRead : ()Z
    //   37: ifne -> 43
    //   40: goto -> 300
    //   43: new java/io/BufferedInputStream
    //   46: astore_3
    //   47: new java/io/FileInputStream
    //   50: astore #4
    //   52: aload #4
    //   54: aload_1
    //   55: invokespecial <init> : (Ljava/io/File;)V
    //   58: aload_3
    //   59: aload #4
    //   61: invokespecial <init> : (Ljava/io/InputStream;)V
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: invokestatic a : (Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   70: astore #4
    //   72: aload #4
    //   74: ifnull -> 211
    //   77: aload_3
    //   78: astore_1
    //   79: aload #4
    //   81: ldc 'NATIVE_RQD_REPORT'
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifne -> 92
    //   89: goto -> 211
    //   92: aload_3
    //   93: astore_1
    //   94: new java/util/HashMap
    //   97: astore #5
    //   99: aload_3
    //   100: astore_1
    //   101: aload #5
    //   103: invokespecial <init> : ()V
    //   106: aconst_null
    //   107: astore #4
    //   109: aload_3
    //   110: astore_1
    //   111: aload_3
    //   112: invokestatic a : (Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   115: astore #6
    //   117: aload #6
    //   119: ifnull -> 151
    //   122: aload #4
    //   124: ifnonnull -> 134
    //   127: aload #6
    //   129: astore #4
    //   131: goto -> 109
    //   134: aload_3
    //   135: astore_1
    //   136: aload #5
    //   138: aload #4
    //   140: aload #6
    //   142: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: goto -> 106
    //   151: aload #4
    //   153: ifnull -> 187
    //   156: aload_3
    //   157: astore_1
    //   158: ldc 'record not pair! drop! %s'
    //   160: iconst_1
    //   161: anewarray java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload #4
    //   168: aastore
    //   169: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload_3
    //   174: invokevirtual close : ()V
    //   177: goto -> 185
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual printStackTrace : ()V
    //   185: aconst_null
    //   186: areturn
    //   187: aload_3
    //   188: astore_1
    //   189: aload_0
    //   190: aload #5
    //   192: aload_2
    //   193: invokestatic a : (Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   196: astore_0
    //   197: aload_3
    //   198: invokevirtual close : ()V
    //   201: goto -> 209
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual printStackTrace : ()V
    //   209: aload_0
    //   210: areturn
    //   211: aload_3
    //   212: astore_1
    //   213: ldc 'record read fail! %s'
    //   215: iconst_1
    //   216: anewarray java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload #4
    //   223: aastore
    //   224: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   227: pop
    //   228: aload_3
    //   229: invokevirtual close : ()V
    //   232: goto -> 240
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual printStackTrace : ()V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_2
    //   243: aload_3
    //   244: astore_0
    //   245: goto -> 257
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -> 282
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_0
    //   258: astore_1
    //   259: aload_2
    //   260: invokevirtual printStackTrace : ()V
    //   263: aload_0
    //   264: ifnull -> 279
    //   267: aload_0
    //   268: invokevirtual close : ()V
    //   271: goto -> 279
    //   274: astore_0
    //   275: aload_0
    //   276: invokevirtual printStackTrace : ()V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_0
    //   282: aload_1
    //   283: ifnull -> 298
    //   286: aload_1
    //   287: invokevirtual close : ()V
    //   290: goto -> 298
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual printStackTrace : ()V
    //   298: aload_0
    //   299: athrow
    //   300: aconst_null
    //   301: areturn
    //   302: ldc 'get eup record file args error'
    //   304: iconst_0
    //   305: anewarray java/lang/Object
    //   308: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   311: pop
    //   312: aconst_null
    //   313: areturn
    // Exception table:
    //   from	to	target	type
    //   43	64	254	java/io/IOException
    //   43	64	248	finally
    //   66	72	242	java/io/IOException
    //   66	72	281	finally
    //   79	89	242	java/io/IOException
    //   79	89	281	finally
    //   94	99	242	java/io/IOException
    //   94	99	281	finally
    //   101	106	242	java/io/IOException
    //   101	106	281	finally
    //   111	117	242	java/io/IOException
    //   111	117	281	finally
    //   136	148	242	java/io/IOException
    //   136	148	281	finally
    //   158	173	242	java/io/IOException
    //   158	173	281	finally
    //   173	177	180	java/io/IOException
    //   189	197	242	java/io/IOException
    //   189	197	281	finally
    //   197	201	204	java/io/IOException
    //   213	228	242	java/io/IOException
    //   213	228	281	finally
    //   228	232	235	java/io/IOException
    //   259	263	281	finally
    //   267	271	274	java/io/IOException
    //   286	290	293	java/io/IOException
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler) {
    if (paramMap == null)
      return null; 
    if (a.a(paramContext) == null) {
      x.e("abnormal com info not created", new Object[0]);
      return null;
    } 
    String str = paramMap.get("intStateStr");
    if (str == null || str.trim().length() <= 0) {
      x.e("no intStateStr", new Object[0]);
      return null;
    } 
    Map<String, Integer> map = d(str);
    if (map == null) {
      x.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
      return null;
    } 
    try {
      String str5;
      ((Integer)map.get("sino")).intValue();
      ((Integer)map.get("sud")).intValue();
      String str1 = paramMap.get("soVersion");
      if (str1 == null) {
        x.e("error format at version", new Object[0]);
        return null;
      } 
      str = paramMap.get("errorAddr");
      String str2 = str;
      if (str == null)
        str2 = "unknown"; 
      String str3 = paramMap.get("codeMsg");
      str = str3;
      if (str3 == null)
        str = "unknown"; 
      str3 = paramMap.get("tombPath");
      String str4 = str3;
      if (str3 == null)
        str4 = "unknown"; 
      String str6 = paramMap.get("signalName");
      str3 = str6;
      if (str6 == null)
        str3 = "unknown"; 
      paramMap.get("errnoMsg");
      String str7 = paramMap.get("stack");
      str6 = str7;
      if (str7 == null)
        str6 = "unknown"; 
      String str8 = paramMap.get("jstack");
      str7 = str6;
      if (str8 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str6);
        stringBuilder.append("java:\n");
        stringBuilder.append(str8);
        str7 = stringBuilder.toString();
      } 
      Integer integer1 = map.get("sico");
      if (integer1 != null && integer1.intValue() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str3);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        str3 = stringBuilder.toString();
        str5 = "KERNEL";
      } else {
        str5 = str;
      } 
      str = paramMap.get("nativeLog");
      if (str != null && !str.isEmpty()) {
        byte[] arrayOfByte = z.a(null, str, "BuglyNativeLog.txt");
      } else {
        str8 = null;
      } 
      String str9 = paramMap.get("sendingProcess");
      str = str9;
      if (str9 == null)
        str = "unknown"; 
      Integer integer2 = map.get("spd");
      str9 = str;
      if (integer2 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(integer2);
        stringBuilder.append(")");
        str9 = stringBuilder.toString();
      } 
      String str10 = paramMap.get("threadName");
      str = str10;
      if (str10 == null)
        str = "unknown"; 
      Integer integer3 = map.get("et");
      str10 = str;
      if (integer3 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(integer3);
        stringBuilder.append(")");
        str10 = stringBuilder.toString();
      } 
      String str11 = paramMap.get("processName");
      str = str11;
      if (str11 == null)
        str = "unknown"; 
      Integer integer4 = map.get("ep");
      str11 = str;
      if (integer4 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(integer4);
        stringBuilder.append(")");
        str11 = stringBuilder.toString();
      } 
      str = paramMap.get("key-value");
      if (str != null) {
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        this();
        String[] arrayOfString = str.split("\n");
        int i = arrayOfString.length;
        for (byte b1 = 0; b1 < i; b1++) {
          String[] arrayOfString1 = arrayOfString[b1].split("=");
          if (arrayOfString1.length == 2)
            hashMap2.put(arrayOfString1[0], arrayOfString1[1]); 
        } 
        HashMap<Object, Object> hashMap1 = hashMap2;
      } else {
        str = null;
      } 
      CrashDetailBean crashDetailBean = paramNativeExceptionHandler.packageCrashDatas(str11, str10, ((Integer)map.get("ets")).intValue() * 1000L + ((Integer)map.get("etms")).intValue() / 1000L, str3, str2, a(str7), str5, str9, str4, paramMap.get("sysLogPath"), paramMap.get("jniLogPath"), str1, (byte[])str8, (Map<String, String>)str, false, false);
      if (crashDetailBean != null) {
        String str13 = paramMap.get("userId");
        if (str13 != null) {
          x.c("[Native record info] userId: %s", new Object[] { str13 });
          crashDetailBean.m = str13;
        } 
        str13 = paramMap.get("sysLog");
        if (str13 != null)
          crashDetailBean.w = str13; 
        str13 = paramMap.get("appVersion");
        if (str13 != null) {
          x.c("[Native record info] appVersion: %s", new Object[] { str13 });
          crashDetailBean.f = str13;
        } 
        str13 = paramMap.get("isAppForeground");
        if (str13 != null) {
          x.c("[Native record info] isAppForeground: %s", new Object[] { str13 });
          crashDetailBean.N = str13.equalsIgnoreCase("true");
        } 
        String str12 = paramMap.get("launchTime");
        if (str12 != null) {
          x.c("[Native record info] launchTime: %s", new Object[] { str12 });
          try {
            crashDetailBean.M = Long.parseLong(str12);
          } catch (NumberFormatException numberFormatException) {
            if (!x.a(numberFormatException))
              numberFormatException.printStackTrace(); 
          } 
        } 
        crashDetailBean.z = null;
        crashDetailBean.k = true;
      } 
      return crashDetailBean;
    } catch (Throwable throwable) {
      x.e("error format", new Object[0]);
      throwable.printStackTrace();
      return null;
    } 
  }
  
  private static String a(BufferedInputStream paramBufferedInputStream) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new java/io/ByteArrayOutputStream
    //   9: astore_1
    //   10: aload_1
    //   11: sipush #1024
    //   14: invokespecial <init> : (I)V
    //   17: aload_1
    //   18: astore_2
    //   19: aload_0
    //   20: invokevirtual read : ()I
    //   23: istore_3
    //   24: iload_3
    //   25: iconst_m1
    //   26: if_icmpeq -> 66
    //   29: iload_3
    //   30: ifne -> 56
    //   33: aload_1
    //   34: astore_2
    //   35: new java/lang/String
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual toByteArray : ()[B
    //   43: ldc_w 'UTf-8'
    //   46: invokespecial <init> : ([BLjava/lang/String;)V
    //   49: astore_0
    //   50: aload_1
    //   51: invokevirtual close : ()V
    //   54: aload_0
    //   55: areturn
    //   56: aload_1
    //   57: astore_2
    //   58: aload_1
    //   59: iload_3
    //   60: invokevirtual write : (I)V
    //   63: goto -> 17
    //   66: aload_1
    //   67: invokevirtual close : ()V
    //   70: goto -> 105
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: astore_1
    //   78: goto -> 90
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_2
    //   84: goto -> 108
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_2
    //   92: aload_1
    //   93: invokestatic a : (Ljava/lang/Throwable;)Z
    //   96: pop
    //   97: aload_0
    //   98: ifnull -> 105
    //   101: aload_0
    //   102: invokevirtual close : ()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_2
    //   109: ifnull -> 116
    //   112: aload_2
    //   113: invokevirtual close : ()V
    //   116: aload_0
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   6	17	87	java/lang/Throwable
    //   6	17	81	finally
    //   19	24	73	java/lang/Throwable
    //   19	24	107	finally
    //   35	50	73	java/lang/Throwable
    //   35	50	107	finally
    //   58	63	73	java/lang/Throwable
    //   58	63	107	finally
    //   92	97	107	finally
  }
  
  protected static String a(String paramString) {
    if (paramString == null)
      return ""; 
    String[] arrayOfString = paramString.split("\n");
    if (arrayOfString == null || arrayOfString.length == 0)
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder();
    int i = arrayOfString.length;
    for (byte b1 = 0; b1 < i; b1++) {
      paramString = arrayOfString[b1];
      if (!paramString.contains("java.lang.Thread.getStackTrace(")) {
        stringBuilder.append(paramString);
        stringBuilder.append("\n");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
    String str1;
    String str2 = null;
    String str3 = null;
    if (paramString1 == null || paramInt <= 0)
      return null; 
    File file = new File(paramString1);
    if (!file.exists() || !file.canRead())
      return null; 
    x.a("Read system log from native record file(length: %s bytes): %s", new Object[] { Long.valueOf(file.length()), file.getAbsolutePath() });
    a.add(file);
    x.c("Add this record file to list for cleaning lastly.", new Object[0]);
    if (paramString2 == null) {
      paramString1 = z.a(new File(paramString1), paramInt, paramBoolean);
    } else {
      BufferedReader bufferedReader;
      StringBuilder stringBuilder = new StringBuilder();
      paramString1 = str3;
      try {
        BufferedReader bufferedReader1 = new BufferedReader();
        paramString1 = str3;
        InputStreamReader inputStreamReader = new InputStreamReader();
        paramString1 = str3;
        FileInputStream fileInputStream = new FileInputStream();
        paramString1 = str3;
        this(file);
        paramString1 = str3;
        this(fileInputStream, "utf-8");
        paramString1 = str3;
        this(inputStreamReader);
      } catch (Throwable throwable) {
      
      } finally {
        BufferedReader bufferedReader1;
        paramString2 = null;
      } 
      str1 = paramString2;
    } 
    return str1;
  }
  
  public static String a(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    String str = b(paramString1, paramString2);
    if (str != null && !str.isEmpty()) {
      stringBuilder.append("Register infos:\n");
      stringBuilder.append(str);
    } 
    paramString1 = c(paramString1, paramString2);
    if (paramString1 != null && !paramString1.isEmpty()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("\n"); 
      stringBuilder.append("System SO infos:\n");
      stringBuilder.append(paramString1);
    } 
    return stringBuilder.toString();
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    if (paramString != null) {
      a.add(new File(paramString, "rqd_record.eup"));
      a.add(new File(paramString, "reg_record.txt"));
      a.add(new File(paramString, "map_record.txt"));
      a.add(new File(paramString, "backup_record.txt"));
      if (paramBoolean)
        c(paramString); 
    } 
    if (a != null && a.size() > 0)
      for (File file : a) {
        if (file.exists() && file.canWrite()) {
          file.delete();
          x.c("Delete record file %s", new Object[] { file.getAbsoluteFile() });
        } 
      }  
  }
  
  public static String b(String paramString) {
    if (paramString == null)
      return null; 
    File file = new File(paramString, "backup_record.txt");
    return file.exists() ? file.getAbsolutePath() : null;
  }
  
  private static String b(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'reg_record.txt'
    //   4: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new java/lang/StringBuilder
    //   17: astore_2
    //   18: aload_2
    //   19: invokespecial <init> : ()V
    //   22: aload_0
    //   23: invokevirtual readLine : ()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -> 170
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   36: ifne -> 42
    //   39: goto -> 170
    //   42: iconst_0
    //   43: istore #4
    //   45: bipush #18
    //   47: istore #5
    //   49: iconst_0
    //   50: istore #6
    //   52: aload_0
    //   53: invokevirtual readLine : ()Ljava/lang/String;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull -> 139
    //   61: iload #4
    //   63: iconst_4
    //   64: irem
    //   65: ifne -> 91
    //   68: iload #4
    //   70: ifle -> 80
    //   73: aload_2
    //   74: ldc '\\n'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: ldc_w '  '
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: goto -> 121
    //   91: aload_1
    //   92: invokevirtual length : ()I
    //   95: bipush #16
    //   97: if_icmple -> 104
    //   100: bipush #28
    //   102: istore #5
    //   104: aload_2
    //   105: ldc_w '                '
    //   108: iconst_0
    //   109: iload #5
    //   111: iload #6
    //   113: isub
    //   114: invokevirtual substring : (II)Ljava/lang/String;
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: invokevirtual length : ()I
    //   125: istore #6
    //   127: aload_2
    //   128: aload_1
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iinc #4, 1
    //   136: goto -> 52
    //   139: aload_2
    //   140: ldc '\\n'
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_2
    //   147: invokevirtual toString : ()Ljava/lang/String;
    //   150: astore_1
    //   151: aload_0
    //   152: ifnull -> 168
    //   155: aload_0
    //   156: invokevirtual close : ()V
    //   159: goto -> 168
    //   162: astore_0
    //   163: aload_0
    //   164: invokestatic a : (Ljava/lang/Throwable;)Z
    //   167: pop
    //   168: aload_1
    //   169: areturn
    //   170: aload_0
    //   171: ifnull -> 187
    //   174: aload_0
    //   175: invokevirtual close : ()V
    //   178: goto -> 187
    //   181: astore_0
    //   182: aload_0
    //   183: invokestatic a : (Ljava/lang/Throwable;)Z
    //   186: pop
    //   187: aconst_null
    //   188: areturn
    //   189: astore_1
    //   190: goto -> 218
    //   193: astore_1
    //   194: aload_1
    //   195: invokestatic a : (Ljava/lang/Throwable;)Z
    //   198: pop
    //   199: aload_0
    //   200: ifnull -> 216
    //   203: aload_0
    //   204: invokevirtual close : ()V
    //   207: goto -> 216
    //   210: astore_0
    //   211: aload_0
    //   212: invokestatic a : (Ljava/lang/Throwable;)Z
    //   215: pop
    //   216: aconst_null
    //   217: areturn
    //   218: aload_0
    //   219: ifnull -> 235
    //   222: aload_0
    //   223: invokevirtual close : ()V
    //   226: goto -> 235
    //   229: astore_0
    //   230: aload_0
    //   231: invokestatic a : (Ljava/lang/Throwable;)Z
    //   234: pop
    //   235: aload_1
    //   236: athrow
    // Exception table:
    //   from	to	target	type
    //   14	27	193	java/lang/Throwable
    //   14	27	189	finally
    //   31	39	193	java/lang/Throwable
    //   31	39	189	finally
    //   52	57	193	java/lang/Throwable
    //   52	57	189	finally
    //   73	80	193	java/lang/Throwable
    //   73	80	189	finally
    //   80	88	193	java/lang/Throwable
    //   80	88	189	finally
    //   91	100	193	java/lang/Throwable
    //   91	100	189	finally
    //   104	121	193	java/lang/Throwable
    //   104	121	189	finally
    //   121	133	193	java/lang/Throwable
    //   121	133	189	finally
    //   139	151	193	java/lang/Throwable
    //   139	151	189	finally
    //   155	159	162	java/lang/Exception
    //   174	178	181	java/lang/Exception
    //   194	199	189	finally
    //   203	207	210	java/lang/Exception
    //   222	226	229	java/lang/Exception
  }
  
  private static String c(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'map_record.txt'
    //   4: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new java/lang/StringBuilder
    //   17: astore_2
    //   18: aload_2
    //   19: invokespecial <init> : ()V
    //   22: aload_0
    //   23: invokevirtual readLine : ()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -> 99
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   36: ifne -> 42
    //   39: goto -> 99
    //   42: aload_0
    //   43: invokevirtual readLine : ()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull -> 75
    //   51: aload_2
    //   52: ldc_w '  '
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc '\\n'
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: goto -> 42
    //   75: aload_2
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull -> 97
    //   84: aload_0
    //   85: invokevirtual close : ()V
    //   88: goto -> 97
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic a : (Ljava/lang/Throwable;)Z
    //   96: pop
    //   97: aload_1
    //   98: areturn
    //   99: aload_0
    //   100: ifnull -> 116
    //   103: aload_0
    //   104: invokevirtual close : ()V
    //   107: goto -> 116
    //   110: astore_0
    //   111: aload_0
    //   112: invokestatic a : (Ljava/lang/Throwable;)Z
    //   115: pop
    //   116: aconst_null
    //   117: areturn
    //   118: astore_1
    //   119: goto -> 147
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic a : (Ljava/lang/Throwable;)Z
    //   127: pop
    //   128: aload_0
    //   129: ifnull -> 145
    //   132: aload_0
    //   133: invokevirtual close : ()V
    //   136: goto -> 145
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic a : (Ljava/lang/Throwable;)Z
    //   144: pop
    //   145: aconst_null
    //   146: areturn
    //   147: aload_0
    //   148: ifnull -> 164
    //   151: aload_0
    //   152: invokevirtual close : ()V
    //   155: goto -> 164
    //   158: astore_0
    //   159: aload_0
    //   160: invokestatic a : (Ljava/lang/Throwable;)Z
    //   163: pop
    //   164: aload_1
    //   165: athrow
    // Exception table:
    //   from	to	target	type
    //   14	27	122	java/lang/Throwable
    //   14	27	118	finally
    //   31	39	122	java/lang/Throwable
    //   31	39	118	finally
    //   42	47	122	java/lang/Throwable
    //   42	47	118	finally
    //   51	72	122	java/lang/Throwable
    //   51	72	118	finally
    //   75	80	122	java/lang/Throwable
    //   75	80	118	finally
    //   84	88	91	java/lang/Exception
    //   103	107	110	java/lang/Exception
    //   123	128	118	finally
    //   132	136	139	java/lang/Exception
    //   151	155	158	java/lang/Exception
  }
  
  public static void c(String paramString) {
    if (paramString == null)
      return; 
    try {
      File file = new File();
      this(paramString);
      if (file.canRead() && file.isDirectory()) {
        File[] arrayOfFile = file.listFiles();
        if (arrayOfFile != null) {
          int i = arrayOfFile.length;
          for (byte b1 = 0; b1 < i; b1++) {
            File file1 = arrayOfFile[b1];
            if (file1.canRead() && file1.canWrite() && file1.length() == 0L) {
              file1.delete();
              x.c("Delete empty record file %s", new Object[] { file1.getAbsoluteFile() });
            } 
          } 
        } 
      } 
      return;
    } catch (Throwable throwable) {
      x.a(throwable);
      return;
    } 
  }
  
  private static Map<String, Integer> d(String paramString) {
    if (paramString == null)
      return null; 
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      for (String str : paramString.split(",")) {
        String[] arrayOfString = str.split(":");
        if (arrayOfString.length != 2) {
          x.e("error format at %s", new Object[] { str });
          return null;
        } 
        int i = Integer.parseInt(arrayOfString[1]);
        hashMap.put(arrayOfString[0], Integer.valueOf(i));
      } 
      return (Map)hashMap;
    } catch (Exception exception) {
      x.e("error format intStateStr %s", new Object[] { paramString });
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */