package com.tencent.tp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;

public final class z {
  public static final String a = "android.permission.READ_PHONE_STATE";
  
  private static String b;
  
  private static String c;
  
  public static String a(Context paramContext) {
    if (b != null && b.length() > 0)
      return b; 
    String str = o(paramContext);
    if (str.toUpperCase(Locale.getDefault()).indexOf("CPUNAME") != -1)
      return str.substring(8); 
    try {
      String str1;
      File file = new File();
      this("/proc/cpuinfo");
      InputStreamReader inputStreamReader = new InputStreamReader();
      FileInputStream fileInputStream = new FileInputStream();
      this(file);
      this(fileInputStream);
      BufferedReader bufferedReader = new BufferedReader();
      this(inputStreamReader);
      while (true) {
        String str2 = bufferedReader.readLine();
        str1 = str;
        if (str2 != null) {
          StringBuilder stringBuilder;
          if (str2.indexOf("Processor") != -1) {
            str = str2.substring(str2.indexOf(":") + 1);
          } else if (str2.indexOf("vendor_id") != -1) {
            str = str2.substring(str2.indexOf(":") + 1);
          } else {
            if (str2.indexOf("Hardware") != -1) {
              int i = str2.indexOf(":");
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append(str);
              stringBuilder1.append("(");
              stringBuilder1.append(str2.substring(i + 1).trim());
              stringBuilder = stringBuilder1;
            } else if (str2.indexOf("model name") != -1) {
              int i = str2.indexOf(":");
              StringBuilder stringBuilder1 = new StringBuilder();
              this();
              stringBuilder1.append((String)stringBuilder);
              stringBuilder1.append("(");
              stringBuilder1.append(str2.substring(i + 1).trim());
              stringBuilder = stringBuilder1;
            } else {
              continue;
            } 
            stringBuilder.append(")");
            str1 = stringBuilder.toString();
            break;
          } 
          String str3 = stringBuilder.trim();
          continue;
        } 
        break;
      } 
      bufferedReader.close();
      if (str1 == null || str1.length() == 0) {
        b = "Unknown";
        return "Unknown";
      } 
      b = str1;
      return str1;
    } catch (Throwable throwable) {
      b = "Unknown";
      return "Unknown";
    } 
  }
  
  private static String a(String paramString) {
    File file = new File(paramString);
    if (file.exists())
      try {
        BufferedReader bufferedReader = new BufferedReader();
        FileReader fileReader = new FileReader();
        this(file);
        this(fileReader);
        String str = bufferedReader.readLine();
        bufferedReader.close();
        return str;
      } catch (Throwable throwable) {
        return "";
      }  
    return "";
  }
  
  public static boolean a() {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    for (byte b = 0; b < paramArrayOfbyte.length; b++)
      paramArrayOfbyte[b] = (byte)(byte)(paramArrayOfbyte[b] ^ 0x2A); 
    return paramArrayOfbyte;
  }
  
  public static String b() {
    return String.valueOf(SystemClock.elapsedRealtime());
  }
  
  public static String b(Context paramContext) {
    String str = o(paramContext);
    if (str.toUpperCase(Locale.getDefault()).indexOf("CPUNAME:") != -1) {
      StringBuilder stringBuilder2;
      if (str.toUpperCase(Locale.getDefault()).indexOf("ATOM") == -1) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(i());
        stringBuilder2.append("(");
        stringBuilder2.append(k.a().i(paramContext));
        stringBuilder2.append(")");
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("REAL_DEVICE(");
      stringBuilder1.append(stringBuilder2.substring(8));
      stringBuilder1.append(")");
      return stringBuilder1.toString();
    } 
    return "REAL_DEVICE(arm)";
  }
  
  private static String b(String paramString) {
    try {
      Process process = Runtime.getRuntime().exec(paramString);
      BufferedReader bufferedReader1 = new BufferedReader();
      InputStreamReader inputStreamReader1 = new InputStreamReader();
      this(process.getInputStream());
      this(inputStreamReader1);
      BufferedReader bufferedReader2 = new BufferedReader();
      InputStreamReader inputStreamReader2 = new InputStreamReader();
      this(process.getErrorStream());
      this(inputStreamReader2);
      char[] arrayOfChar = new char[4096];
      StringBuffer stringBuffer = new StringBuffer();
      this();
      while (true) {
        int i = bufferedReader1.read(arrayOfChar);
        if (i > 0) {
          stringBuffer.append(arrayOfChar, 0, i);
          continue;
        } 
        bufferedReader1.close();
        StringBuffer stringBuffer1 = new StringBuffer();
        this();
        while (true) {
          i = bufferedReader2.read(arrayOfChar);
          if (i > 0) {
            stringBuffer1.append(arrayOfChar, 0, i);
            continue;
          } 
          bufferedReader2.close();
          process.waitFor();
          return (stringBuffer.toString().trim().length() > 0) ? stringBuffer.toString() : ((stringBuffer1.toString().trim().length() > 0) ? stringBuffer1.toString() : "");
        } 
        break;
      } 
    } catch (Throwable throwable) {
      return "";
    } 
  }
  
  public static DisplayMetrics c(Context paramContext) {
    Context context1;
    Context context2 = null;
    if (paramContext == null) {
      paramContext = context2;
    } else {
      try {
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        this();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
        DisplayMetrics displayMetrics1 = displayMetrics2;
      } catch (Throwable throwable) {
        context1 = context2;
      } 
    } 
    return (DisplayMetrics)context1;
  }
  
  public static String c() {
    String str;
    try {
      str = String.valueOf(Build.VERSION.SDK_INT);
    } catch (Throwable throwable) {
      str = "null";
    } 
    return str;
  }
  
  public static int d() {
    return Integer.parseInt(c());
  }
  
  public static long d(Context paramContext) {
    long l1 = -1L;
    long l2 = l1;
    if (paramContext != null)
      try {
        ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this();
        activityManager.getMemoryInfo(memoryInfo);
        l2 = memoryInfo.availMem;
      } catch (Throwable throwable) {
        l2 = l1;
      }  
    return l2;
  }
  
  public static String e() {
    try {
      String str = Locale.getDefault().getCountry();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String e(Context paramContext) {
    String str;
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo != null) {
        if (networkInfo.getType() != 1) {
          StringBuilder stringBuilder;
          if (networkInfo.getType() != 0)
            return "unknown"; 
          TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
          if (telephonyManager == null)
            return "unknown"; 
          int i = telephonyManager.getNetworkType();
          switch (i) {
            default:
              stringBuilder = new StringBuilder();
              break;
            case 15:
              return "HSPA+";
            case 14:
              return "eHRPD";
            case 13:
              return "LTE";
            case 12:
              return "CDMA - EVDO rev. B";
            case 11:
              return "iDen";
            case 10:
              return "HSPA";
            case 9:
              return "HSUPA";
            case 8:
              return "HSDPA";
            case 7:
              return "CDMA - 1xRTT";
            case 6:
              return "CDMA - EVDO rev. A";
            case 5:
              return "CDMA - EVDO rev. 0";
            case 4:
              return "CDMA";
            case 3:
              return "UMTS";
            case 2:
              return "EDGE";
            case 1:
              return "GPRS";
            case 0:
              return "unknown";
          } 
          this();
          stringBuilder.append("unknown(");
          stringBuilder.append(String.valueOf(i));
          stringBuilder.append(")");
          str = stringBuilder.toString();
        } else {
          return "wifi";
        } 
      } else {
        return "unknown";
      } 
    } catch (Throwable throwable) {
      str = "unknown";
    } 
    return str;
  }
  
  public static String f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.CPU_ABI);
    stringBuilder.append("|");
    stringBuilder.append(Build.CPU_ABI2);
    return stringBuilder.toString();
  }
  
  public static String f(Context paramContext) {
    NetworkInfo networkInfo1;
    NetworkInfo networkInfo2 = null;
    try {
      networkInfo1 = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo1 == null) {
        networkInfo1 = networkInfo2;
      } else {
        String str;
        if (networkInfo1.getType() == 1) {
          str = "wifi";
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("");
          stringBuilder.append(str.getExtraInfo());
          str = stringBuilder.toString();
        } 
      } 
    } catch (Throwable throwable) {
      networkInfo1 = networkInfo2;
    } 
    return (String)networkInfo1;
  }
  
  public static String g() {
    String str2;
    String str1 = "";
    if (Build.VERSION.SDK_INT >= 21) {
      Field field2;
      Field field1 = null;
      Field[] arrayOfField = Build.class.getFields();
      boolean bool = false;
      byte b = 0;
      while (true) {
        field2 = field1;
        if (b < arrayOfField.length) {
          if (arrayOfField[b].getName().equals("SUPPORTED_ABIS")) {
            field2 = arrayOfField[b];
            break;
          } 
          b++;
          continue;
        } 
        break;
      } 
      if (field2 != null) {
        try {
          Object object = field2.get(Build.class);
          str2 = str1;
          if (object.getClass().isArray()) {
            b = bool;
            while (true) {
              str2 = str1;
              if (b < Array.getLength(object)) {
                Object object1 = Array.get(object, b);
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append(str1);
                stringBuilder.append(object1.toString());
                String str = stringBuilder.toString();
                str1 = str;
                if (b != Array.getLength(object) - 1) {
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this();
                  stringBuilder1.append(str);
                  stringBuilder1.append("|");
                  String str3 = stringBuilder1.toString();
                } 
                b++;
                continue;
              } 
              break;
            } 
          } 
        } catch (Throwable throwable) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Build.CPU_ABI);
          stringBuilder.append("|");
          stringBuilder.append(Build.CPU_ABI2);
          str2 = stringBuilder.toString();
        } 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.CPU_ABI);
        stringBuilder.append("|");
        stringBuilder.append(Build.CPU_ABI2);
        str2 = stringBuilder.toString();
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Build.CPU_ABI);
      stringBuilder.append("|");
      stringBuilder.append(Build.CPU_ABI2);
      str2 = stringBuilder.toString();
    } 
    return str2;
  }
  
  public static String g(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        return ac.a((packageManager.getPackageInfo(paramContext.getPackageName(), 64)).signatures[0].toByteArray());
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public static String h() {
    return System.getProperty("os.arch");
  }
  
  public static String h(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 0);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(packageInfo.versionName);
        stringBuilder.append("(");
        stringBuilder.append(String.valueOf(packageInfo.versionCode));
        stringBuilder.append(")");
        return stringBuilder.toString();
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public static String i() {
    if (Build.VERSION.SDK_INT >= 8)
      try {
        return Build.HARDWARE;
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public static String i(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager != null)
      try {
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramContext.getPackageName(), 0);
        if (applicationInfo != null)
          return packageManager.getApplicationLabel(applicationInfo).toString(); 
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public static long j(Context paramContext) {
    long l;
    try {
      int i = (((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() })[0])dalvikPss / 1024;
      l = i;
    } catch (Throwable throwable) {
      l = 0L;
    } 
    return l;
  }
  
  public static String j() {
    try {
      String str = Build.MODEL;
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static float k(Context paramContext) {
    float f;
    try {
      IntentFilter intentFilter = new IntentFilter();
      this("android.intent.action.BATTERY_CHANGED");
      Intent intent = paramContext.registerReceiver(null, intentFilter);
      int i = intent.getIntExtra("level", -1);
      int j = intent.getIntExtra("scale", -1);
      if (i == -1 || j == -1)
        return 50.0F; 
      f = i / j * 100.0F;
    } catch (Throwable throwable) {
      f = 0.0F;
    } 
    return f;
  }
  
  public static long k() {
    long l2;
    long l1 = 0L;
    try {
      File file = Environment.getExternalStorageDirectory();
      StatFs statFs = new StatFs();
      this(file.getPath());
      long l = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
      l2 = i;
      l1 = l;
    } catch (Throwable throwable) {
      l2 = 0L;
    } 
    return l1 * l2;
  }
  
  public static long l() {
    long l2;
    long l1 = 0L;
    try {
      StatFs statFs = new StatFs();
      this("/data");
      l2 = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
      long l = i;
      l1 = l2;
      l2 = l;
    } catch (Throwable throwable) {
      l2 = 0L;
    } 
    return l1 * l2;
  }
  
  public static String l(Context paramContext) {
    String str;
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      int i = displayMetrics.heightPixels;
      int j = displayMetrics.widthPixels;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(j);
      stringBuilder.append("x");
      stringBuilder.append(i);
      str = stringBuilder.toString();
    } catch (Throwable throwable) {
      str = "UNKNOWN";
    } 
    return str;
  }
  
  public static long m(Context paramContext) {
    return 0L;
  }
  
  public static String m() {
    try {
      String str = Locale.getDefault().getLanguage();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static long n(Context paramContext) {
    long l;
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
      this();
      activityManager.getMemoryInfo(memoryInfo);
      l = memoryInfo.availMem;
      l >>= 20L;
    } catch (Throwable throwable) {
      l = 0L;
    } 
    return l;
  }
  
  public static String n() {
    try {
      String str = a("/proc/version");
      Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(str);
      if (!matcher.matches())
        return "Unavailable"; 
      if (matcher.groupCount() < 4)
        return "Unavailable"; 
      StringBuilder stringBuilder = new StringBuilder();
      this(matcher.group(1));
      stringBuilder.append(" ");
      stringBuilder.append(matcher.group(3));
      return stringBuilder.toString();
    } catch (Throwable throwable) {
      return "Unavailable";
    } 
  }
  
  public static String o() {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(j());
    stringBuffer.append(";Android ");
    stringBuffer.append(r());
    stringBuffer.append(",level ");
    stringBuffer.append(c());
    return stringBuffer.toString();
  }
  
  private static String o(Context paramContext) {
    if (c != null && c.length() > 0)
      return c; 
    byte[] arrayOfByte = a(new byte[] { 
          122, 97, 41, 46, 62, 42, 42, 42, 34, 42, 
          93, 101, -125, 98, -37, -91, -124, 36, -112, 44, 
          42, 42, -74, 62, 42, 42, 35, 42, 42, 42, 
          71, 83, 73, 90, 95, 67, 68, 76, 69, -57, 
          114, 115, -90, 97, 123, 50, 20, -35, -36, 100, 
          119, -90, Byte.MIN_VALUE, 87, 65, 2, -96, -101, -1, 56, 
          -18, 48, 44, -97, -59, 38, 59, 97, 119, -105, 
          31, -7, -62, -98, -71, -36, 56, -82, 10, -97, 
          -9, 126, 57, 104, -56, 111, 104, 70, 37, -94, 
          34, 8, 87, 58, 107, -121, -93, 46, -93, 10, 
          -53, -85, 114, 120, -101, -82, 10, 59, -84, -48, 
          -28, 72, -52, Byte.MIN_VALUE, 96, 82, -40, 24, 77, -40, 
          -9, -43, -42, -43, -43, -73, -43, -42, 77, -63, 
          -10, 89, -3, -47, -116, -90, -71, 14, -93, -42, 
          6, 28, -42, 123, 71, -83, -89, -70, 43, -70, 
          96, 57, 64, -113, 95, 29, 123, 99, 35, 67, 
          111, 112, 56, 17, -7, 65, -85, 44, 38, 32, 
          -53, -102, 123, -111, 126, -95, 76, -82, 105, -125, 
          -117, -44, 112, -48, Byte.MIN_VALUE, 54, 111, 126, 91, 88, 
          -43, 99, 45, -6, -76, 73, 44, 38, 89, 42, 
          -111, -38, -31, 58, -3, 55, 106, 81, 36, Byte.MAX_VALUE, 
          -56, -102, -95, 20, 76, 22, 29, -34, -79, -33, 
          34, -45, 35, -73, 122, -2, -52, 29, 57, 84, 
          120, -118, -14, -81, -74, 47, 85, 84, -43, 25, 
          6, -37, -47, -18, 125, -19, -89, 74, 79, -75, 
          -113, -117, 98, -75, 90, 2, -104, 22, 50, -31, 
          33, -66, 29, -20, -116, 106, -119, 22, -105, 71, 
          -76, -12, -7, -120, -7, 3, 53, -69, -51, 53, 
          -79, -115, 101, -29, -7, -51, -6, -96, 49, 74, 
          121, -34, 20, -99, 10, 101, 5, -115, -109, 113, 
          94, -56, -35, -83, 105, 97, 41, -44, 122, 14, 
          78, -118, 52, 114, -113, -45, 31, 9, -110, -96, 
          3, 91, 105, 33, 6, -35, 45, 0, -68, -47, 
          -67, 67, -117, -38, 5, -84, -40, 63, 112, 102, 
          13, Byte.MAX_VALUE, -101, 122, -18, 114, 44, 109, 26, 60, 
          -95, 110, 35, -116, 9, -118, -81, 107, 38, -64, 
          -80, -117, -21, -106, 30, 52, -115, 71, 72, 44, 
          102, 59, -73, -118, -119, 90, -98, -10, 49, -91, 
          -8, 112, -10, -6, 41, 23, 81, 32, -113, 120, 
          -30, -86, -70, 80, 50, 63, -100, 85, 48, 40, 
          0, -6, 42, -126, 117, 74, -121, 78, 27, -19, 
          28, -101, 68, -33, -86, 8, -101, 20, -99, 17, 
          -38, -100, 93, -81, 86, 10, -50, 9, 11, 53, 
          105, -16, 107, 86, 45, 115, 37, 107, 20, 120, 
          -93, -86, -75, -125, 110, -22, 64, 0, -95, 82, 
          21, -109, -7, 32, 87, 52, 126, -125, -24, 64, 
          -17, 82, 124, -6, -64, -31, -19, 19, -66, -87, 
          100, Byte.MIN_VALUE, -127, 126, -107, -25, -34, -52, 126, 93, 
          120, -41, 40, -7, 113, 121, -73, 20, 116, -76, 
          -82, -80, -8, 23, 53, -71, 73, 23, -28, -25, 
          61, 38, 19, 93, 49, 112, 91, 12, 95, -68, 
          108, 97, -73, -63, 108, 111, -77, -45, 86, 92, 
          -36, 62, 0, 49, 25, -71, 119, -82, 14, -76, 
          -105, 41, -51, 91, 24, -37, 48, 71, -123, -89, 
          -33, 2, -66, 73, -92, -33, 30, 101, 12, -12, 
          -21, -88, 112, -63, 78, -56, 9, -123, -109, 120, 
          -102, 105, 60, 13, 57, -75, -109, 111, 103, -45, 
          62, 121, -37, 78, -19, -7, -92, -27, 94, -113, 
          71, 77, 77, -31, 114, -38, -99, -57, 34, 107, 
          -50, 70, 0, -53, -56, 59, Byte.MAX_VALUE, 78, -49, -84, 
          126, 120, -93, -57, 101, -5, 48, -25, -10, 22, 
          -11, -4, 33, 24, -125, -65, 30, 21, -12, -108, 
          47, 65, 85, -88, -99, -43, -74, 71, -30, 99, 
          -64, -88, 102, -8, -49, -29, 10, 87, 2, -59, 
          -124, -45, Byte.MIN_VALUE, -13, -78, -32, Byte.MIN_VALUE, -67, -78, -35, 
          -7, -126, 71, 66, 86, -22, -122, -115, 15, 87, 
          -1, 29, 2, 79, -12, 118, 100, -48, -30, 99, 
          53, -71, 121, -1, 15, -52, 23, -39, 124, -107, 
          33, -118, 95, 26, -51, 3, -52, 94, -1, -98, 
          -87, -44, 59, 22, -51, 72, -43, 8, -4, 2, 
          115, -116, -8, 66, -104, -94, 76, -48, 51, 71, 
          116, 91, -16, -20, 7, -55, -73, -116, -107, -109, 
          19, -105, -97, 19, -27, -65, 124, -82, -29, 71, 
          -48, 23, -52, -34, 56, 89, 116, 5, 103, 110, 
          -77, 17, 49, 27, 93, 77, -115, 9, -57, -89, 
          -77, 6, -92, 75, 24, 123, -89, 80, -72, -78, 
          -108, 77, -3, 86, 109, 66, 108, -3, 86, 109, 
          -109, 18, 107, -17, Byte.MAX_VALUE, -11, 3, -50, 82, -48, 
          86, 21, -2, -7, 70, -48, -59, 14, -76, 98, 
          -79, 69, 50, -64, 28, 19, 91, 99, 96, -106, 
          -65, -126, 107, -84, -117, -44, 24, 57, 60, 19, 
          -37, 124, 28, -11, 117, 86, 3, -79, -35, 21, 
          54, 25, -107, -78, -59, -109, -7, 4, -74, 5, 
          14, -39, 23, -2, 8, -4, 18, -49, 17, 104, 
          13, -48, -49, -35, 118, 4, 81, 59, 37, -7, 
          -99, 85, -55, -112, -41, 94, 22, 1, -111, -115, 
          86, -115, -125, 101, 108, 88, -126, -40, -1, 22, 
          -24, 61, 66, -46, 33, -108, 106, -47, -108, -49, 
          88, -123, 112, -2, -78, -115, 34, -39, 28, -78, 
          -17, -126, -32, -76, 15, -29, -70, 97, 108, 123, 
          92, -58, 93, -100, 102, -53, 47, 72, 28, -101, 
          -101, -104, 69, 74, 97, -7, 105, 94, 9, 105, 
          126, -31, -59, 89, 67, 110, -91, 111, 105, 16, 
          17, 93, 73, Byte.MIN_VALUE, 124, 102, -7, 0, -87, 105, 
          97, -112, -18, -111, 93, -93, 29, -46, 111, -75, 
          60, -113, Byte.MAX_VALUE, 114, 90, 98, -79, -43, -42, -9, 
          113, 25, -95, 98, 65, Byte.MAX_VALUE, -125, 119, -101, -120, 
          70, -71, -110, -9, 111, -27, 24, 88, 64, 108, 
          35, 73, 55, -28, 67, 36, -81, -98, 60, -43, 
          17, -74, -102, -27, -115, -36, 120, -83, -112, 115, 
          52, -9, -126, -126, 30, 75, -119, -42, 51, -22, 
          54, -46, 44, 35, 117, 104, -76, -60, 90, -63, 
          36, -97, 30, -55, 122, -126, -107, 32, 26, -54, 
          69, 77, -37, 17, 13, 88, 21, 23, 86, 17, 
          -86, 2, -42, -58, -22, -94, 54, 36, 43, 84, 
          -14, 16, 113, -47, -39, 117, 3, 124, 106, -40, 
          -22, 94, 51, 114, 32, -43, 106, -127, 85, -10, 
          124, -15, 60, 15, 94, -97, -34, 112, 3, 15, 
          -104, -75, -2, -3, 8, -36, -110, 117, -40, -12, 
          64, -71, 109, 91, 120, 35, 55, 61, -20, -108, 
          57, 54, Byte.MAX_VALUE, -104, 90, -20, -7, 114, -93, 8, 
          -45, 97, -116, 126, 46, 78, 73, 51, 36, 100, 
          15, -4, -120, -125, 31, -12, -98, -16, -106, 60, 
          -24, -107, -64, 65, 4, 29, -87, -48, 55, -64, 
          18, 109, -37, -114, -20, 39, 39, 79, 63, 51, 
          -13, 92, 114, -91, -44, -76, 100, 31, -43, 89, 
          -16, -13, -84, -121, 104, -74, -84, 94, -60, -22, 
          -107, -95, 55, 90, 34, 88, 29, 70, -67, 11, 
          -91, 105, 80, -102, 7, -124, 105, -64, -70, 115, 
          -30, -33, -70, 0, 82, 94, -111, -110, 10, -91, 
          106, 36, -83, 86, 34, -125, 105, 92, -18, 50, 
          -100, 107, 92, 45, -35, 38, 14, -125, 1, 95, 
          -113, -124, -2, -65, -112, 120, 125, -44, 105, -29, 
          -117, 62, -72, 28, -54, 115, 45, 84, 5, 90, 
          41, -121, -86, 64, -77, -107, 85, 30, 59, -110, 
          1, -39, -111, 120, 35, -6, 102, -10, 5, -108, 
          -50, 88, 123, 47, -104, -81, -49, 36, 18, 107, 
          -56, -35, 37, -115, -110, 121, 86, -68, -46, 23, 
          78, -123, 82, 109, -16, 7, -39, -35, -114, 26, 
          -53, 88, -113, -70, 35, 11, -71, 104, -60, 72, 
          -35, 22, 84, -83, 94, -93, -44, -16, 42, 67, 
          -62, -57, -126, 4, 88, -105, 42, -105, -119, -6, 
          -15, 33, -45, 63, 83, 99, -50, -11, 33, -89, 
          -65, 60, -35, -4, 101, -56, 36, 89, -105, 87, 
          -121, 85, 58, 12, 64, 54, 26, 61, 114, 108, 
          13, 71, -42, -78, 27, 105, -9, 15, -55, -115, 
          -65, 95, 93, 37, -38, 36, 76, -55, -127, 5, 
          -20, 35, 9, 3, -91, -84, 95, 93, 21, 69, 
          -107, 84, -98, -101, 29, 116, 59, 29, 72, -84, 
          -100, -66, 82, 91, 43, 38, -20, Byte.MIN_VALUE, -94, 125, 
          117, 55, -93, -123, -124, 78, 56, 4, -56, -121, 
          -6, -56, 63, -18, 49, 33, -84, -125, -81, 125, 
          Byte.MIN_VALUE, -24, 44, -37, -56, 68, -93, 77, 14, 64, 
          46, -105, 48, 85, -105, -34, -84, -34, 74, 46, 
          -100, 114, -66, -9, 48, -105, -21, 32, -43, -104, 
          50, -12, 13, 65, 65, -44, 32, 55, 59, -67, 
          -53, -96, -64, -3, 72, 27, 71, 31, -57, 31, 
          78, -42, -122, 125, -17, -88, -97, 0, 97, 106, 
          -127, 38, 47, -94, -99, 22, 64, -102, 45, -59, 
          61, 125, 123, -56, 39, 110, 1, 1, -5, -67, 
          -62, -107, 22, -104, -24, 97, -83, -1, 81, 79, 
          26, 60, 37, 111, 9, -50, 69, 97, 105, -101, 
          -124, 24, -101, 84, -15, -46, -41, -28, -11, 102, 
          90, 79, -100, -67, 18, 100, -8, 23, 0, 18, 
          -96, -14, 113, -57, -82, 103, 76, 81, -90, 73, 
          69, -85, 82, -73, -17, 20, -66, -13, -12, -55, 
          50, -17, 94, 116, 62, -85, -60, 72, -57, 78, 
          -100, -3, 19, 96, -122, 22, -101, -99, -48, 33, 
          -12, 66, 92, 108, 18, -10, -88, 125, -27, -24, 
          49, 14, 88, -102, -7, 87, 64, -55, -78, 75, 
          -29, -27, 3, -110, -23, 6, -106, 0, 49, -19, 
          52, -13, -32, -55, -113, -2, 24, 85, Byte.MIN_VALUE, -73, 
          -119, -97, 15, -76, 8, 78, -77, -81, -51, -100, 
          89, 94, 1, 26, 5, -95, 6, -106, 35, 92, 
          -92, 103, -8, -59, -37, -32, 65, 82, -4, 69, 
          104, -107, -39, 124, 42, -89, -13, -80, -94, 69, 
          21, 36, -50, 114, -86, -99, 59, 90, 34, 116, 
          -80, -76, -99, 21, -38, 120, 72, -58, 28, 91, 
          4, 5, -42, -85, -99, 125, -26, -73, 103, -74, 
          -1, -63, -66, 13, 107, -27, 113, -99, -23, -68, 
          69, 52, -99, 17, 42, 98, -100, 83, -85, 82, 
          109, 7, -106, 77, 55, 42, -38, 118, 47, 82, 
          -115, 115, 118, -5, -91, -79, 13, -127, 62, -54, 
          -113, 111, -106, -108, -68, 47, 95, 112, -3, 105, 
          -54, -120, -14, 21, 31, 30, 77, -85, 84, 65, 
          88, -127, 7, -105, -22, 81, 122, 74, 87, 85, 
          42, 122, 97, 43, 40, 21, 42, 62, 42, 42, 
          42, 34, 42, 93, 101, -125, 98, -37, -91, -124, 
          36, -112, 44, 42, 42, -74, 62, 42, 42, 35, 
          42, 14, 42, 42, 42, 42, 42, 42, 42, 10, 
          42, 42, 42, 42, 42, 42, 42, 71, 83, 73, 
          90, 95, 67, 68, 76, 69, 32, 42, 10, 42, 
          42, 42, 42, 42, 43, 42, 50, 42, -28, 84, 
          -36, 94, -68, -125, -5, 43, -13, 119, -33, 94, 
          -68, -125, -5, 43, 20, 118, -65, -86, -11, -113, 
          -5, 43, 122, 97, 47, 44, 42, 42, 42, 42, 
          43, 42, 43, 42, 113, 42, 42, 42, -53, 44, 
          42, 42, 42, 42 });
    if (arrayOfByte == null)
      return c; 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
    try {
      while (zipInputStream.getNextEntry() != null) {
        byte[] arrayOfByte1 = new byte[2048];
        FileOutputStream fileOutputStream = new FileOutputStream();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append(paramContext.getFilesDir().getAbsolutePath());
        stringBuilder1.append("/mycpuinfo");
        this(stringBuilder1.toString());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream();
        this(fileOutputStream);
        while (true) {
          int i = zipInputStream.read(arrayOfByte1, 0, 2048);
          if (i != -1) {
            bufferedOutputStream.write(arrayOfByte1, 0, i);
            continue;
          } 
          bufferedOutputStream.flush();
          bufferedOutputStream.close();
        } 
      } 
      zipInputStream.close();
      byteArrayInputStream.close();
    } catch (Throwable throwable) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("chmod 755 ");
    stringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    stringBuilder.append("/mycpuinfo\n");
    b(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    stringBuilder.append("/mycpuinfo\n");
    String str = b(stringBuilder.toString());
    c = str.trim();
    return str.trim();
  }
  
  public static String p() {
    Throwable throwable2;
    Throwable throwable1 = null;
    try {
      FileReader fileReader = new FileReader();
      this("/proc/meminfo");
      try {
        BufferedReader bufferedReader = new BufferedReader();
        this(fileReader, 8192);
        try {
          long l = Long.parseLong(bufferedReader.readLine().split(":\\s+", 2)[1].toLowerCase(Locale.US).replace("kb", "").trim()) / 1024L;
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append(l);
          String str = stringBuilder.toString();
          bufferedReader.close();
          fileReader.close();
          return str;
        } catch (Throwable throwable) {}
      } catch (Throwable null) {
        throwable3 = null;
      } 
    } catch (Throwable null) {
      throwable2 = null;
      throwable3 = throwable2;
    } 
    if (throwable3 != null)
      try {
        throwable3.close();
      } catch (Throwable throwable) {} 
    throwable3 = throwable1;
    if (throwable2 != null)
      try {
        throwable2.close();
        throwable3 = throwable1;
      } catch (Throwable throwable3) {
        throwable3 = throwable1;
      }  
    return (String)throwable3;
  }
  
  public static String q() {
    try {
      StatFs statFs = new StatFs();
      this(Environment.getDataDirectory().getPath());
      long l1 = statFs.getBlockSize();
      long l2 = statFs.getBlockCount();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(l2 * l1 / 1024L / 1024L);
      stringBuilder.append("");
      String str = stringBuilder.toString();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String r() {
    String str;
    try {
      str = Build.VERSION.RELEASE;
    } catch (Throwable throwable) {
      str = "null";
    } 
    return str;
  }
  
  public static String s() {
    String str;
    try {
      str = Build.HARDWARE;
    } catch (Throwable throwable) {
      str = "UNKNOWN";
    } 
    return str;
  }
  
  public static String t() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(s());
      stringBuilder.append("(");
      stringBuilder.append(f());
      stringBuilder.append(")");
      String str = stringBuilder.toString();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String u() {
    return "UNKNOWN";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */