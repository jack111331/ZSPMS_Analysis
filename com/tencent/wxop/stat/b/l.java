package com.tencent.wxop.stat.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class l {
  private static int U;
  
  private static String W;
  
  private static String a = null;
  
  private static String aR;
  
  private static String b = null;
  
  private static int bG;
  
  private static volatile int bn;
  
  private static String bq;
  
  private static String br;
  
  private static String bs;
  
  private static String c = null;
  
  private static String cC;
  
  private static String cE;
  
  private static Random cR;
  
  private static DisplayMetrics cS;
  
  private static b cT;
  
  private static String cU;
  
  private static String cV;
  
  private static long cW;
  
  private static o cX;
  
  private static String cY;
  
  private static long cZ;
  
  private static String da;
  
  private static int w;
  
  static {
    W = null;
    cR = null;
    cS = null;
    bq = null;
    br = "";
    bs = "";
    bG = -1;
    cT = null;
    cU = null;
    aR = null;
    bn = -1;
    cV = null;
    cC = null;
    cW = -1L;
    cE = "";
    cX = null;
    cY = "__MTA_FIRST_ACTIVATE__";
    U = -1;
    cZ = -1L;
    w = 0;
    da = "";
  }
  
  public static String A(Context paramContext) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null) {
        Object object = applicationInfo.metaData.get("InstallChannel");
        if (object != null)
          return object.toString(); 
        cT.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
      } 
    } catch (Throwable throwable) {
      cT.d("Could not read InstallChannel meta-data from AndroidManifest.xml");
    } 
    return null;
  }
  
  public static String B(Context paramContext) {
    return (paramContext == null) ? null : paramContext.getClass().getName();
  }
  
  public static String C(Context paramContext) {
    if (bq != null)
      return bq; 
    try {
      if (r.a(paramContext, "android.permission.READ_PHONE_STATE")) {
        boolean bool;
        if (paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) != 0) {
          bool = false;
        } else {
          bool = true;
        } 
        if (bool) {
          TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
          if (telephonyManager != null)
            bq = telephonyManager.getSimOperator(); 
        } 
      } else {
        cT.d("Could not get permission of android.permission.READ_PHONE_STATE");
      } 
    } catch (Throwable throwable) {
      cT.b(throwable);
    } 
    return bq;
  }
  
  public static String D(Context paramContext) {
    if (e(br))
      return br; 
    try {
      String str = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
      br = str;
      if (str == null)
        return ""; 
    } catch (Throwable throwable) {
      cT.b(throwable);
    } 
    return br;
  }
  
  public static String E(Context paramContext) {
    String str1;
    String str2 = "";
    try {
      if (r.a(paramContext, "android.permission.INTERNET") && r.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
          String str3 = networkInfo.getTypeName();
          String str4 = networkInfo.getExtraInfo();
          if (str3 != null) {
            if (str3.equalsIgnoreCase("WIFI"))
              return "WIFI"; 
            if (str3.equalsIgnoreCase("MOBILE"))
              return (str4 != null) ? str4 : "MOBILE"; 
            if (str4 != null)
              str3 = str4; 
            return str3;
          } 
        } 
        return "";
      } 
      cT.d("can not get the permission of android.permission.ACCESS_WIFI_STATE");
      str1 = str2;
    } catch (Throwable throwable) {
      cT.b(throwable);
      str1 = str2;
    } 
    return str1;
  }
  
  public static Integer F(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null) {
        int i = telephonyManager.getNetworkType();
        return Integer.valueOf(i);
      } 
    } catch (Throwable throwable) {}
    return null;
  }
  
  public static String G(Context paramContext) {
    if (e(bs))
      return bs; 
    try {
      String str = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
      bs = str;
      if (str == null || bs.length() == 0)
        return "unknown"; 
    } catch (Throwable throwable) {
      cT.b(throwable);
    } 
    return bs;
  }
  
  public static String H(Context paramContext) {
    if (e(cU))
      return cU; 
    try {
      if (r.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        String str = Environment.getExternalStorageState();
        if (str != null && str.equals("mounted")) {
          String str1 = Environment.getExternalStorageDirectory().getPath();
          if (str1 != null) {
            StatFs statFs = new StatFs();
            this(str1);
            long l1 = statFs.getBlockCount() * statFs.getBlockSize() / 1000000L;
            long l2 = statFs.getAvailableBlocks();
            l2 = statFs.getBlockSize() * l2 / 1000000L;
            StringBuilder stringBuilder = new StringBuilder();
            this();
            String str2 = stringBuilder.append(String.valueOf(l2)).append("/").append(String.valueOf(l1)).toString();
            cU = str2;
            return str2;
          } 
        } 
      } else {
        cT.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        return null;
      } 
    } catch (Throwable throwable) {
      cT.b(throwable);
    } 
    return null;
  }
  
  static String I(Context paramContext) {
    try {
      if (aR != null)
        return aR; 
      int i = Process.myPid();
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses()) {
        if (runningAppProcessInfo.pid == i) {
          aR = runningAppProcessInfo.processName;
          break;
        } 
      } 
    } catch (Throwable throwable) {}
    return aR;
  }
  
  public static String J(Context paramContext) {
    return e(paramContext, a.ct);
  }
  
  public static Integer K(Context paramContext) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc com/tencent/wxop/stat/b/l
    //   4: monitorenter
    //   5: getstatic com/tencent/wxop/stat/b/l.bn : I
    //   8: ifle -> 79
    //   11: getstatic com/tencent/wxop/stat/b/l.bn : I
    //   14: istore_2
    //   15: iload_2
    //   16: sipush #1000
    //   19: irem
    //   20: ifne -> 44
    //   23: getstatic com/tencent/wxop/stat/b/l.bn : I
    //   26: istore_2
    //   27: getstatic com/tencent/wxop/stat/b/l.bn : I
    //   30: ldc_w 2147383647
    //   33: if_icmplt -> 107
    //   36: aload_0
    //   37: ldc_w 'MTA_EVENT_INDEX'
    //   40: iload_1
    //   41: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)V
    //   44: getstatic com/tencent/wxop/stat/b/l.bn : I
    //   47: iconst_1
    //   48: iadd
    //   49: istore_1
    //   50: iload_1
    //   51: putstatic com/tencent/wxop/stat/b/l.bn : I
    //   54: ldc com/tencent/wxop/stat/b/l
    //   56: monitorexit
    //   57: iload_1
    //   58: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   61: areturn
    //   62: astore_0
    //   63: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   66: aload_0
    //   67: invokevirtual c : (Ljava/lang/Object;)V
    //   70: goto -> 44
    //   73: astore_0
    //   74: ldc com/tencent/wxop/stat/b/l
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: aload_0
    //   80: ldc_w 'MTA_EVENT_INDEX'
    //   83: iconst_0
    //   84: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)I
    //   87: putstatic com/tencent/wxop/stat/b/l.bn : I
    //   90: aload_0
    //   91: ldc_w 'MTA_EVENT_INDEX'
    //   94: getstatic com/tencent/wxop/stat/b/l.bn : I
    //   97: sipush #1000
    //   100: iadd
    //   101: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)V
    //   104: goto -> 44
    //   107: iload_2
    //   108: sipush #1000
    //   111: iadd
    //   112: istore_1
    //   113: goto -> 36
    // Exception table:
    //   from	to	target	type
    //   5	15	73	finally
    //   23	36	62	java/lang/Throwable
    //   23	36	73	finally
    //   36	44	62	java/lang/Throwable
    //   36	44	73	finally
    //   44	54	73	finally
    //   63	70	73	finally
    //   79	104	73	finally
  }
  
  public static String L(Context paramContext) {
    try {
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
      this();
      activityManager.getMemoryInfo(memoryInfo);
      long l1 = memoryInfo.availMem / 1000000L;
      long l2 = ay() / 1000000L;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      String str = stringBuilder.append(String.valueOf(l1)).append("/").append(String.valueOf(l2)).toString();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static String M(Context paramContext) {
    if (e(cE))
      return cE; 
    try {
      SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
      if (sensorManager != null) {
        List<Sensor> list = sensorManager.getSensorList(-1);
        if (list != null) {
          StringBuilder stringBuilder = new StringBuilder();
          this(list.size() * 10);
          for (byte b1 = 0; b1 < list.size(); b1++) {
            stringBuilder.append(((Sensor)list.get(b1)).getType());
            if (b1 != list.size() - 1)
              stringBuilder.append(","); 
          } 
          cE = stringBuilder.toString();
        } 
      } 
    } catch (Throwable throwable) {
      cT.b(throwable);
    } 
    return cE;
  }
  
  public static int N(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/l
    //   2: monitorenter
    //   3: getstatic com/tencent/wxop/stat/b/l.U : I
    //   6: iconst_m1
    //   7: if_icmpeq -> 19
    //   10: getstatic com/tencent/wxop/stat/b/l.U : I
    //   13: istore_1
    //   14: ldc com/tencent/wxop/stat/b/l
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: invokestatic O : (Landroid/content/Context;)V
    //   23: getstatic com/tencent/wxop/stat/b/l.U : I
    //   26: istore_1
    //   27: goto -> 14
    //   30: astore_0
    //   31: ldc com/tencent/wxop/stat/b/l
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	14	30	finally
    //   19	27	30	finally
  }
  
  public static void O(Context paramContext) {
    int i = q.a(paramContext, cY, 1);
    U = i;
    if (i == 1)
      q.b(paramContext, cY, 0); 
  }
  
  public static boolean P(Context paramContext) {
    if (cZ < 0L)
      cZ = q.f(paramContext, "mta.qq.com.checktime"); 
    return (Math.abs(System.currentTimeMillis() - cZ) > 86400000L);
  }
  
  public static void Q(Context paramContext) {
    cZ = System.currentTimeMillis();
    q.a(paramContext, "mta.qq.com.checktime", cZ);
  }
  
  public static String R(Context paramContext) {
    String str;
    Context context = null;
    if (paramContext == null)
      return (String)context; 
    Intent intent = new Intent("android.intent.action.MAIN");
    intent.addCategory("android.intent.category.HOME");
    ResolveInfo resolveInfo = paramContext.getPackageManager().resolveActivity(intent, 0);
    paramContext = context;
    if (resolveInfo.activityInfo != null) {
      paramContext = context;
      if (!resolveInfo.activityInfo.packageName.equals("android"))
        str = resolveInfo.activityInfo.packageName; 
    } 
    return str;
  }
  
  public static int a(Context paramContext, boolean paramBoolean) {
    if (paramBoolean)
      w = q.a(paramContext, "mta.qq.com.difftime", 0); 
    return w;
  }
  
  private static Long a(String paramString1, String paramString2, Long paramLong) {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_0
    //   3: ifnull -> 12
    //   6: aload_1
    //   7: ifnonnull -> 14
    //   10: aload_2
    //   11: astore_3
    //   12: aload_3
    //   13: areturn
    //   14: aload_1
    //   15: ldc_w '.'
    //   18: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   21: ifne -> 36
    //   24: aload_1
    //   25: astore_3
    //   26: aload_1
    //   27: ldc_w '|'
    //   30: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   33: ifeq -> 54
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w '\'
    //   43: invokespecial <init> : (Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: astore_3
    //   54: aload_0
    //   55: aload_3
    //   56: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore_1
    //   60: aload_2
    //   61: astore_3
    //   62: aload_1
    //   63: arraylength
    //   64: iconst_3
    //   65: if_icmpne -> 12
    //   68: lconst_0
    //   69: invokestatic valueOf : (J)Ljava/lang/Long;
    //   72: astore_0
    //   73: iconst_0
    //   74: istore #4
    //   76: iload #4
    //   78: aload_1
    //   79: arraylength
    //   80: if_icmpge -> 120
    //   83: aload_0
    //   84: invokevirtual longValue : ()J
    //   87: lstore #5
    //   89: aload_1
    //   90: iload #4
    //   92: aaload
    //   93: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   96: invokevirtual longValue : ()J
    //   99: lstore #7
    //   101: iinc #4, 1
    //   104: ldc2_w 100
    //   107: lload #5
    //   109: lload #7
    //   111: ladd
    //   112: lmul
    //   113: invokestatic valueOf : (J)Ljava/lang/Long;
    //   116: astore_0
    //   117: goto -> 76
    //   120: aload_0
    //   121: astore_3
    //   122: goto -> 12
    //   125: astore_0
    //   126: aload_2
    //   127: astore_3
    //   128: goto -> 12
    // Exception table:
    //   from	to	target	type
    //   68	73	125	java/lang/NumberFormatException
    //   76	101	125	java/lang/NumberFormatException
  }
  
  public static void a(Context paramContext, int paramInt) {
    w = paramInt;
    q.b(paramContext, "mta.qq.com.difftime", paramInt);
  }
  
  public static boolean a(f paramf) {
    return (paramf == null) ? false : e(paramf.S());
  }
  
  public static long ad() {
    long l1;
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.set(11, 0);
      calendar.set(12, 0);
      calendar.set(13, 0);
      calendar.set(14, 0);
      l1 = calendar.getTimeInMillis();
      l1 += 86400000L;
    } catch (Throwable throwable) {
      cT.b(throwable);
      l1 = System.currentTimeMillis() + 86400000L;
    } 
    return l1;
  }
  
  private static Random at() {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/l
    //   2: monitorenter
    //   3: getstatic com/tencent/wxop/stat/b/l.cR : Ljava/util/Random;
    //   6: ifnonnull -> 21
    //   9: new java/util/Random
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/tencent/wxop/stat/b/l.cR : Ljava/util/Random;
    //   21: getstatic com/tencent/wxop/stat/b/l.cR : Ljava/util/Random;
    //   24: astore_0
    //   25: ldc com/tencent/wxop/stat/b/l
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/wxop/stat/b/l
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public static int au() {
    if (bG != -1)
      return bG; 
    try {
      if (p.a())
        bG = 1; 
    } catch (Throwable throwable) {
      cT.b(throwable);
    } 
    boolean bool = false;
    bG = 0;
    return bool;
  }
  
  public static b av() {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/l
    //   2: monitorenter
    //   3: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   6: ifnonnull -> 28
    //   9: new com/tencent/wxop/stat/b/b
    //   12: astore_0
    //   13: aload_0
    //   14: ldc_w 'MtaSDK'
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: aload_0
    //   21: putstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   24: aload_0
    //   25: invokevirtual ap : ()V
    //   28: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   31: astore_0
    //   32: ldc com/tencent/wxop/stat/b/l
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc com/tencent/wxop/stat/b/l
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	28	37	finally
    //   28	32	37	finally
  }
  
  public static String aw() {
    Calendar calendar = Calendar.getInstance();
    calendar.roll(6, 0);
    return (new SimpleDateFormat("yyyyMMdd")).format(calendar.getTime());
  }
  
  public static String ax() {
    if (e(cC))
      return cC; 
    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = statFs.getBlockSize();
    l1 = statFs.getBlockCount() * l1 / 1000000L;
    statFs = new StatFs(Environment.getDataDirectory().getPath());
    long l2 = statFs.getBlockSize();
    l2 = statFs.getAvailableBlocks() * l2 / 1000000L;
    String str = String.valueOf(l2) + "/" + String.valueOf(l1);
    cC = str;
    return str;
  }
  
  private static long ay() {
    if (cW > 0L)
      return cW; 
    long l2 = 1L;
    long l1 = l2;
    try {
      FileReader fileReader = new FileReader();
      l1 = l2;
      this("/proc/meminfo");
      l1 = l2;
      BufferedReader bufferedReader = new BufferedReader();
      l1 = l2;
      this(fileReader, 8192);
      l1 = l2;
      l2 = (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
      l1 = l2;
      bufferedReader.close();
      l1 = l2;
      cW = l1;
    } catch (Exception exception) {}
    return l1;
  }
  
  public static JSONObject az() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("n", m.r());
      String str = m.ax();
      if (str != null && str.length() > 0)
        jSONObject.put("na", str); 
      int i = m.aA();
      if (i > 0)
        jSONObject.put("fx", i / 1000000); 
      i = m.D();
      if (i > 0)
        jSONObject.put("fn", i / 1000000); 
    } catch (Throwable throwable) {
      Log.w("MtaSDK", "get cpu error", throwable);
    } 
    return jSONObject;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
    byte[] arrayOfByte = new byte[4096];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfbyte.length * 2);
    while (true) {
      int i = gZIPInputStream.read(arrayOfByte);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      arrayOfByte = byteArrayOutputStream.toByteArray();
      byteArrayInputStream.close();
      gZIPInputStream.close();
      byteArrayOutputStream.close();
      return arrayOfByte;
    } 
  }
  
  public static String c(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/l
    //   2: monitorenter
    //   3: getstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   6: ifnull -> 30
    //   9: getstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   12: invokevirtual trim : ()Ljava/lang/String;
    //   15: invokevirtual length : ()I
    //   18: ifeq -> 30
    //   21: getstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   24: astore_0
    //   25: ldc com/tencent/wxop/stat/b/l
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   34: astore_0
    //   35: aload_0
    //   36: putstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   39: aload_0
    //   40: ifnull -> 55
    //   43: getstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   46: invokevirtual trim : ()Ljava/lang/String;
    //   49: invokevirtual length : ()I
    //   52: ifne -> 70
    //   55: invokestatic at : ()Ljava/util/Random;
    //   58: ldc_w 2147483647
    //   61: invokevirtual nextInt : (I)I
    //   64: invokestatic toString : (I)Ljava/lang/String;
    //   67: putstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   70: getstatic com/tencent/wxop/stat/b/l.a : Ljava/lang/String;
    //   73: astore_0
    //   74: goto -> 25
    //   77: astore_0
    //   78: ldc com/tencent/wxop/stat/b/l
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   3	25	77	finally
    //   30	39	77	finally
    //   43	55	77	finally
    //   55	70	77	finally
    //   70	74	77	finally
  }
  
  public static String d(long paramLong) {
    return (new SimpleDateFormat("yyyyMMdd")).format(new Date(paramLong));
  }
  
  public static String e(Context paramContext, String paramString) {
    String str = paramString;
    if (c.E() == true) {
      if (aR == null)
        aR = I(paramContext); 
      str = paramString;
      if (aR != null)
        str = paramString + "_" + aR; 
    } 
    return str;
  }
  
  public static boolean e(String paramString) {
    return !(paramString == null || paramString.trim().length() == 0);
  }
  
  public static int r() {
    return at().nextInt(2147483647);
  }
  
  public static String t(String paramString) {
    String str;
    if (paramString == null)
      return "0"; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = messageDigest.digest();
      StringBuffer stringBuffer = new StringBuffer();
      this();
      for (byte b1 = 0; b1 < arrayOfByte.length; b1++) {
        int i = arrayOfByte[b1] & 0xFF;
        if (i < 16)
          stringBuffer.append("0"); 
        stringBuffer.append(Integer.toHexString(i));
      } 
      str = stringBuffer.toString();
    } catch (Throwable throwable) {
      str = "0";
    } 
    return str;
  }
  
  public static long u(String paramString) {
    return a(paramString, ".", Long.valueOf(0L)).longValue();
  }
  
  public static HttpHost v(Context paramContext) {
    if (paramContext == null)
      return null; 
    try {
      if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
        return null; 
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo == null)
        return null; 
      if (networkInfo.getTypeName() != null && networkInfo.getTypeName().equalsIgnoreCase("WIFI"))
        return null; 
      String str = networkInfo.getExtraInfo();
      if (str == null)
        return null; 
      if (str.equals("cmwap") || str.equals("3gwap") || str.equals("uniwap")) {
        HttpHost httpHost = new HttpHost();
        this("10.0.0.172", 80);
        return httpHost;
      } 
    } catch (Throwable null) {
      cT.b(null);
      return null;
    } 
    if (paramContext.equals("ctwap"))
      return new HttpHost("10.0.0.200", 80); 
    null = Proxy.getDefaultHost();
    return (null != null && null.trim().length() > 0) ? new HttpHost(null, Proxy.getDefaultPort()) : null;
  }
  
  public static String w(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/wxop/stat/b/l
    //   2: monitorenter
    //   3: getstatic com/tencent/wxop/stat/b/l.c : Ljava/lang/String;
    //   6: ifnull -> 21
    //   9: getstatic com/tencent/wxop/stat/b/l.c : Ljava/lang/String;
    //   12: invokevirtual trim : ()Ljava/lang/String;
    //   15: invokevirtual length : ()I
    //   18: ifne -> 28
    //   21: aload_0
    //   22: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   25: putstatic com/tencent/wxop/stat/b/l.c : Ljava/lang/String;
    //   28: getstatic com/tencent/wxop/stat/b/l.c : Ljava/lang/String;
    //   31: astore_0
    //   32: ldc com/tencent/wxop/stat/b/l
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: ldc com/tencent/wxop/stat/b/l
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	37	finally
    //   21	28	37	finally
    //   28	32	37	finally
  }
  
  public static DisplayMetrics x(Context paramContext) {
    if (cS == null) {
      cS = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(cS);
    } 
    return cS;
  }
  
  public static boolean y(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'android.permission.ACCESS_WIFI_STATE'
    //   4: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   7: ifeq -> 82
    //   10: aload_0
    //   11: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   14: ldc 'connectivity'
    //   16: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast android/net/ConnectivityManager
    //   22: astore_0
    //   23: aload_0
    //   24: ifnull -> 77
    //   27: aload_0
    //   28: invokevirtual getAllNetworkInfo : ()[Landroid/net/NetworkInfo;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull -> 77
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: aload_0
    //   40: arraylength
    //   41: if_icmpge -> 77
    //   44: aload_0
    //   45: iload_1
    //   46: aaload
    //   47: invokevirtual getTypeName : ()Ljava/lang/String;
    //   50: ldc 'WIFI'
    //   52: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   55: ifeq -> 71
    //   58: aload_0
    //   59: iload_1
    //   60: aaload
    //   61: invokevirtual isConnected : ()Z
    //   64: ifeq -> 71
    //   67: iconst_1
    //   68: istore_2
    //   69: iload_2
    //   70: ireturn
    //   71: iinc #1, 1
    //   74: goto -> 38
    //   77: iconst_0
    //   78: istore_2
    //   79: goto -> 69
    //   82: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   85: ldc 'can not get the permission of android.permission.ACCESS_WIFI_STATE'
    //   87: invokevirtual warn : (Ljava/lang/Object;)V
    //   90: iconst_0
    //   91: istore_2
    //   92: goto -> 69
    //   95: astore_0
    //   96: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   99: aload_0
    //   100: invokevirtual b : (Ljava/lang/Throwable;)V
    //   103: goto -> 90
    // Exception table:
    //   from	to	target	type
    //   0	23	95	java/lang/Throwable
    //   27	32	95	java/lang/Throwable
    //   38	67	95	java/lang/Throwable
    //   82	90	95	java/lang/Throwable
  }
  
  public static String z(Context paramContext) {
    // Byte code:
    //   0: getstatic com/tencent/wxop/stat/b/l.b : Ljava/lang/String;
    //   3: ifnull -> 12
    //   6: getstatic com/tencent/wxop/stat/b/l.b : Ljava/lang/String;
    //   9: astore_0
    //   10: aload_0
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   16: aload_0
    //   17: invokevirtual getPackageName : ()Ljava/lang/String;
    //   20: sipush #128
    //   23: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull -> 63
    //   31: aload_0
    //   32: getfield metaData : Landroid/os/Bundle;
    //   35: ldc_w 'TA_APPKEY'
    //   38: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull -> 68
    //   46: aload_0
    //   47: putstatic com/tencent/wxop/stat/b/l.b : Ljava/lang/String;
    //   50: goto -> 10
    //   53: astore_0
    //   54: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   57: ldc_w 'Could not read APPKEY meta-data from AndroidManifest.xml'
    //   60: invokevirtual b : (Ljava/lang/Object;)V
    //   63: aconst_null
    //   64: astore_0
    //   65: goto -> 10
    //   68: getstatic com/tencent/wxop/stat/b/l.cT : Lcom/tencent/wxop/stat/b/b;
    //   71: ldc_w 'Could not read APPKEY meta-data from AndroidManifest.xml'
    //   74: invokevirtual b : (Ljava/lang/Object;)V
    //   77: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   12	27	53	java/lang/Throwable
    //   31	42	53	java/lang/Throwable
    //   46	50	53	java/lang/Throwable
    //   68	77	53	java/lang/Throwable
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */