package com.unionpay.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
  private static int a(String paramString) {
    boolean bool2;
    boolean bool1 = false;
    String str = "";
    try {
      Matcher matcher = Pattern.compile("([0-9]+)").matcher(paramString);
      paramString = str;
      if (matcher.find())
        paramString = matcher.toMatchResult().group(0); 
      bool2 = Integer.valueOf(paramString).intValue();
    } catch (Exception exception) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public static String a() {
    return "Android+" + Build.VERSION.RELEASE;
  }
  
  private static String a(String paramString1, String paramString2) {
    try {
      String str = paramString1.toLowerCase();
      if (!str.startsWith("unknown") && !str.startsWith("alps") && !str.startsWith("android") && !str.startsWith("sprd") && !str.startsWith("spreadtrum") && !str.startsWith("rockchip") && !str.startsWith("wondermedia") && !str.startsWith("mtk") && !str.startsWith("mt65") && !str.startsWith("nvidia") && !str.startsWith("brcm") && !str.startsWith("marvell")) {
        boolean bool = paramString2.toLowerCase().contains(str);
        if (bool)
          paramString1 = null; 
        return paramString1;
      } 
      paramString1 = null;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static JSONObject a(Context paramContext) {
    try {
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("nfc-status", b(paramContext));
      jSONObject2.put("appsRegistedHCE", d(paramContext));
      jSONObject2.put("ssMode", f(paramContext));
      JSONObject jSONObject1 = jSONObject2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (JSONObject)throwable;
  }
  
  public static int b(Context paramContext) {
    byte b = 0;
    if (paramContext != null) {
      NfcAdapter nfcAdapter = ((NfcManager)paramContext.getSystemService("nfc")).getDefaultAdapter();
      if (nfcAdapter != null)
        return !nfcAdapter.isEnabled() ? 1 : ((k.a(19) && paramContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce")) ? 3 : 2); 
      b = 0;
    } 
    return b;
  }
  
  public static String b() {
    return Build.MANUFACTURER.trim();
  }
  
  private static String b(String paramString) {
    String str1;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = str2;
    try {
      FileReader fileReader = new FileReader();
      str5 = str2;
      this(paramString);
      str5 = str2;
      String str = str3;
      try {
        char[] arrayOfChar = new char[1024];
        str5 = str2;
        str = str3;
        BufferedReader bufferedReader = new BufferedReader();
        str5 = str2;
        str = str3;
        this(fileReader, 1024);
        paramString = str4;
        while (true) {
          str5 = paramString;
          str = paramString;
          int i = bufferedReader.read(arrayOfChar, 0, 1024);
          if (-1 != i) {
            str5 = paramString;
            str = paramString;
            StringBuilder stringBuilder = new StringBuilder();
            str5 = paramString;
            str = paramString;
            this();
            str5 = paramString;
            str = paramString;
            stringBuilder = stringBuilder.append(paramString);
            str5 = paramString;
            str = paramString;
            str2 = new String();
            str5 = paramString;
            str = paramString;
            this(arrayOfChar, 0, i);
            str5 = paramString;
            str = paramString;
            paramString = stringBuilder.append(str2).toString();
            continue;
          } 
          str5 = paramString;
          str = paramString;
          bufferedReader.close();
          str5 = paramString;
          str = paramString;
          fileReader.close();
          return paramString;
        } 
      } catch (IOException iOException) {
        str1 = str;
      } 
    } catch (Throwable throwable) {
      str1 = str5;
    } 
    return str1;
  }
  
  public static String c() {
    return Build.BRAND.trim();
  }
  
  public static String c(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      if (displayMetrics != null) {
        int i = displayMetrics.widthPixels;
        int j = displayMetrics.heightPixels;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        return stringBuilder.append(Math.min(i, j)).append("*").append(Math.max(i, j)).append("*").append(displayMetrics.densityDpi).toString();
      } 
    } catch (Throwable throwable) {}
    return "";
  }
  
  public static String d() {
    return Build.MODEL.trim();
  }
  
  private static JSONArray d(Context paramContext) {
    if (!k.a(19))
      return null; 
    try {
      JSONArray jSONArray2 = new JSONArray();
      this();
      for (PackageInfo packageInfo : e(paramContext)) {
        ServiceInfo[] arrayOfServiceInfo = packageInfo.services;
        if (arrayOfServiceInfo != null) {
          int i = arrayOfServiceInfo.length;
          for (byte b = 0; b < i; b++) {
            Bundle bundle = (arrayOfServiceInfo[b]).metaData;
            if (bundle != null && bundle.containsKey("android.nfc.cardemulation.host_apdu_service"))
              jSONArray2.put(packageInfo.packageName); 
          } 
        } 
      } 
      JSONArray jSONArray1 = jSONArray2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (JSONArray)throwable;
  }
  
  public static int e() {
    return TimeZone.getDefault().getRawOffset() / 3600000;
  }
  
  private static List e(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   4: astore_1
    //   5: aload_1
    //   6: iconst_4
    //   7: invokevirtual getInstalledPackages : (I)Ljava/util/List;
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: astore_0
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore_2
    //   22: aconst_null
    //   23: astore_3
    //   24: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   27: ldc_w 'pm list packages'
    //   30: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   33: astore #4
    //   35: new java/io/BufferedReader
    //   38: astore #5
    //   40: new java/io/InputStreamReader
    //   43: astore_0
    //   44: aload_0
    //   45: aload #4
    //   47: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   50: invokespecial <init> : (Ljava/io/InputStream;)V
    //   53: aload #5
    //   55: aload_0
    //   56: invokespecial <init> : (Ljava/io/Reader;)V
    //   59: aload #5
    //   61: astore_0
    //   62: aload #5
    //   64: invokevirtual readLine : ()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull -> 137
    //   72: aload #5
    //   74: astore_0
    //   75: aload_2
    //   76: aload_1
    //   77: aload_3
    //   78: aload_3
    //   79: bipush #58
    //   81: invokevirtual indexOf : (I)I
    //   84: iconst_1
    //   85: iadd
    //   86: invokevirtual substring : (I)Ljava/lang/String;
    //   89: iconst_4
    //   90: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   93: invokeinterface add : (Ljava/lang/Object;)Z
    //   98: pop
    //   99: goto -> 59
    //   102: astore_3
    //   103: aload #5
    //   105: astore_0
    //   106: aload_3
    //   107: invokevirtual printStackTrace : ()V
    //   110: aload_2
    //   111: astore_0
    //   112: aload #5
    //   114: ifnull -> 11
    //   117: aload #5
    //   119: invokevirtual close : ()V
    //   122: aload_2
    //   123: astore_0
    //   124: goto -> 11
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual printStackTrace : ()V
    //   132: aload_2
    //   133: astore_0
    //   134: goto -> 11
    //   137: aload #5
    //   139: astore_0
    //   140: aload #4
    //   142: invokevirtual waitFor : ()I
    //   145: pop
    //   146: aload #5
    //   148: invokevirtual close : ()V
    //   151: aload_2
    //   152: astore_0
    //   153: goto -> 11
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual printStackTrace : ()V
    //   161: aload_2
    //   162: astore_0
    //   163: goto -> 11
    //   166: astore_0
    //   167: aload_3
    //   168: astore #5
    //   170: aload #5
    //   172: ifnull -> 180
    //   175: aload #5
    //   177: invokevirtual close : ()V
    //   180: aload_0
    //   181: athrow
    //   182: astore #5
    //   184: aload #5
    //   186: invokevirtual printStackTrace : ()V
    //   189: goto -> 180
    //   192: astore_3
    //   193: aload_0
    //   194: astore #5
    //   196: aload_3
    //   197: astore_0
    //   198: goto -> 170
    //   201: astore_3
    //   202: aconst_null
    //   203: astore #5
    //   205: goto -> 103
    // Exception table:
    //   from	to	target	type
    //   5	11	13	java/lang/Throwable
    //   24	59	201	java/lang/Throwable
    //   24	59	166	finally
    //   62	68	102	java/lang/Throwable
    //   62	68	192	finally
    //   75	99	102	java/lang/Throwable
    //   75	99	192	finally
    //   106	110	192	finally
    //   117	122	127	java/lang/Throwable
    //   140	146	102	java/lang/Throwable
    //   140	146	192	finally
    //   146	151	156	java/lang/Throwable
    //   175	180	182	java/lang/Throwable
  }
  
  private static int f(Context paramContext) {
    try {
      if (k.a(19))
        return CardEmulation.getInstance(((NfcManager)paramContext.getSystemService("nfc")).getDefaultAdapter()).getSelectionModeForCategory("payment"); 
    } catch (Throwable throwable) {}
    return -1;
  }
  
  public static String f() {
    String str;
    try {
      String str1 = Build.MODEL.trim();
      String str2 = a(Build.MANUFACTURER.trim(), str1);
      str = str2;
      if (TextUtils.isEmpty(str2))
        str = a(Build.BRAND.trim(), str1); 
      StringBuilder stringBuilder = new StringBuilder();
      str2 = str;
      if (str == null)
        str2 = ""; 
      this(str2);
      str = stringBuilder.append(":").append(str1).toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public static int g() {
    return Build.VERSION.SDK_INT;
  }
  
  public static String h() {
    return Build.VERSION.RELEASE;
  }
  
  public static String i() {
    return Locale.getDefault().getLanguage();
  }
  
  public static String j() {
    return Locale.getDefault().getCountry();
  }
  
  public static String[] k() {
    // Byte code:
    //   0: iconst_4
    //   1: anewarray java/lang/String
    //   4: astore_0
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_4
    //   9: if_icmpge -> 23
    //   12: aload_0
    //   13: iload_1
    //   14: ldc ''
    //   16: aastore
    //   17: iinc #1, 1
    //   20: goto -> 7
    //   23: new java/util/ArrayList
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore_2
    //   31: new java/io/FileReader
    //   34: astore_3
    //   35: aload_3
    //   36: ldc_w '/proc/cpuinfo'
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: new java/io/BufferedReader
    //   45: astore #4
    //   47: aload #4
    //   49: aload_3
    //   50: sipush #1024
    //   53: invokespecial <init> : (Ljava/io/Reader;I)V
    //   56: aload #4
    //   58: invokevirtual readLine : ()Ljava/lang/String;
    //   61: astore #5
    //   63: aload #5
    //   65: ifnull -> 195
    //   68: aload_2
    //   69: aload #5
    //   71: invokeinterface add : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -> 56
    //   80: astore #5
    //   82: aload #4
    //   84: invokevirtual close : ()V
    //   87: aload_3
    //   88: invokevirtual close : ()V
    //   91: iconst_0
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq -> 247
    //   97: aload_2
    //   98: invokeinterface size : ()I
    //   103: istore #6
    //   105: iconst_0
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_3
    //   109: if_icmpge -> 247
    //   112: iconst_3
    //   113: anewarray java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc_w 'Processor\s*:\s*(.*)'
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: ldc_w 'CPU\s*variant\s*:\s*0x(.*)'
    //   127: aastore
    //   128: dup
    //   129: iconst_2
    //   130: ldc_w 'Hardware\s*:\s*(.*)'
    //   133: aastore
    //   134: iload_1
    //   135: aaload
    //   136: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   139: astore_3
    //   140: iconst_0
    //   141: istore #7
    //   143: iload #7
    //   145: iload #6
    //   147: if_icmpge -> 241
    //   150: aload_3
    //   151: aload_2
    //   152: iload #7
    //   154: invokeinterface get : (I)Ljava/lang/Object;
    //   159: checkcast java/lang/String
    //   162: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   165: astore #4
    //   167: aload #4
    //   169: invokevirtual find : ()Z
    //   172: ifeq -> 189
    //   175: aload_0
    //   176: iload_1
    //   177: aload #4
    //   179: invokevirtual toMatchResult : ()Ljava/util/regex/MatchResult;
    //   182: iconst_1
    //   183: invokeinterface group : (I)Ljava/lang/String;
    //   188: aastore
    //   189: iinc #7, 1
    //   192: goto -> 143
    //   195: aload #4
    //   197: invokevirtual close : ()V
    //   200: aload_3
    //   201: invokevirtual close : ()V
    //   204: iconst_1
    //   205: istore_1
    //   206: goto -> 93
    //   209: astore_3
    //   210: iconst_1
    //   211: istore_1
    //   212: goto -> 93
    //   215: astore_3
    //   216: iconst_0
    //   217: istore_1
    //   218: goto -> 93
    //   221: astore #5
    //   223: aload #4
    //   225: invokevirtual close : ()V
    //   228: aload_3
    //   229: invokevirtual close : ()V
    //   232: aload #5
    //   234: athrow
    //   235: astore_3
    //   236: iconst_0
    //   237: istore_1
    //   238: goto -> 93
    //   241: iinc #1, 1
    //   244: goto -> 107
    //   247: aload_0
    //   248: iconst_3
    //   249: ldc_w '/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq'
    //   252: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   255: aastore
    //   256: aload_0
    //   257: areturn
    //   258: astore_3
    //   259: iconst_1
    //   260: istore_1
    //   261: goto -> 93
    //   264: astore_3
    //   265: goto -> 232
    // Exception table:
    //   from	to	target	type
    //   31	56	235	java/lang/Throwable
    //   56	63	80	java/lang/Throwable
    //   56	63	221	finally
    //   68	77	80	java/lang/Throwable
    //   68	77	221	finally
    //   82	91	215	java/io/IOException
    //   82	91	235	java/lang/Throwable
    //   195	204	209	java/io/IOException
    //   195	204	258	java/lang/Throwable
    //   223	232	264	java/io/IOException
    //   223	232	235	java/lang/Throwable
    //   232	235	235	java/lang/Throwable
  }
  
  public static String[] l() {
    return null;
  }
  
  public static int[] m() {
    int i = 0;
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    int[] arrayOfInt2 = new int[4];
    int j;
    for (j = 0; j < 4; j++)
      arrayOfInt2[j] = 0; 
    try {
      FileReader fileReader = new FileReader();
      this("/proc/meminfo");
      BufferedReader bufferedReader = new BufferedReader();
      this(fileReader, 1024);
      j = i;
      while (true) {
        if (j < 4)
          try {
            arrayOfInt2[j] = a(bufferedReader.readLine());
            continue;
          } catch (IOException iOException1) {
            return arrayOfInt1;
          } finally {
            try {
              iOException.close();
              fileReader.close();
            } catch (IOException iOException) {}
          }  
        arrayOfInt1[0] = arrayOfInt2[0];
        j = arrayOfInt2[1];
        i = arrayOfInt2[2];
        arrayOfInt1[1] = arrayOfInt2[3] + j + i;
        try {
          iOException.close();
          fileReader.close();
        } catch (IOException iOException1) {}
        return arrayOfInt1;
      } 
    } catch (Throwable throwable) {}
    return arrayOfInt1;
  }
  
  public static int[] n() {
    try {
      int[] arrayOfInt = new int[4];
      StatFs statFs = new StatFs();
      this(Environment.getDataDirectory().getAbsolutePath());
      arrayOfInt[0] = statFs.getBlockCount() * statFs.getBlockSize() / 512 / 2;
      int i = statFs.getAvailableBlocks();
      arrayOfInt[1] = statFs.getBlockSize() / 512 * i / 2;
      statFs = new StatFs();
      this(Environment.getExternalStorageDirectory().getAbsolutePath());
      arrayOfInt[2] = statFs.getBlockCount() * statFs.getBlockSize() / 512 / 2;
      i = statFs.getAvailableBlocks();
      arrayOfInt[3] = statFs.getBlockSize() / 512 * i / 2;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (int[])throwable;
  }
  
  public static int o() {
    byte b2;
    byte b1 = 0;
    try {
      String str = b("/sys/class/power_supply/battery/full_bat");
      Matcher matcher = Pattern.compile("\\s*([0-9]+)").matcher(str);
      b2 = b1;
      if (matcher.find())
        b2 = Integer.valueOf(matcher.toMatchResult().group(0)).intValue(); 
    } catch (Exception exception) {
      b2 = b1;
    } 
    return b2;
  }
  
  public static class a {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */