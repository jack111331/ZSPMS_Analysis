package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

public class b {
  private static final String[] a = new String[] { 
      "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", 
      "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  
  private static final String[] b = new String[] { 
      "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", 
      "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", 
      "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", 
      "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", 
      "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", 
      "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  
  private static final String[] c = new String[] { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  
  private static String d = null;
  
  private static String e = null;
  
  public static String a() {
    try {
      return Build.MODEL;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return "fail";
    } 
  }
  
  public static String a(Context paramContext) {
    String str = "fail";
    if (paramContext == null)
      return "fail"; 
    try {
      String str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (str1 == null) {
        str = "null";
      } else {
        try {
          str = str1.toLowerCase();
        } catch (Throwable throwable) {}
      } 
    } catch (Throwable throwable) {
      String str1 = str;
      str = str1;
      if (!x.a(throwable)) {
        x.a("Failed to get Android ID.", new Object[0]);
        str = str1;
      } 
    } 
    return str;
  }
  
  public static String a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_3
    //   4: iload_1
    //   5: ifeq -> 116
    //   8: aload_0
    //   9: ldc 'ro.product.cpu.abilist'
    //   11: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic a : (Ljava/lang/String;)Z
    //   19: ifne -> 34
    //   22: aload_3
    //   23: astore #4
    //   25: aload_3
    //   26: ldc 'fail'
    //   28: invokevirtual equals : (Ljava/lang/Object;)Z
    //   31: ifeq -> 42
    //   34: aload_0
    //   35: ldc 'ro.product.cpu.abi'
    //   37: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   40: astore #4
    //   42: aload_2
    //   43: astore_3
    //   44: aload #4
    //   46: invokestatic a : (Ljava/lang/String;)Z
    //   49: ifne -> 116
    //   52: aload #4
    //   54: ldc 'fail'
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifeq -> 67
    //   62: aload_2
    //   63: astore_3
    //   64: goto -> 116
    //   67: new java/lang/StringBuilder
    //   70: astore_0
    //   71: aload_0
    //   72: ldc 'ABI list: '
    //   74: invokespecial <init> : (Ljava/lang/String;)V
    //   77: aload_0
    //   78: aload #4
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc com/tencent/bugly/crashreport/common/info/b
    //   86: aload_0
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: iconst_0
    //   91: anewarray java/lang/Object
    //   94: invokestatic b : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Z
    //   97: pop
    //   98: aload #4
    //   100: ldc_w ','
    //   103: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   106: iconst_0
    //   107: aaload
    //   108: astore_3
    //   109: goto -> 116
    //   112: astore_0
    //   113: goto -> 150
    //   116: aload_3
    //   117: astore_0
    //   118: aload_3
    //   119: ifnonnull -> 129
    //   122: ldc_w 'os.arch'
    //   125: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_0
    //   129: new java/lang/StringBuilder
    //   132: astore_3
    //   133: aload_3
    //   134: invokespecial <init> : ()V
    //   137: aload_3
    //   138: aload_0
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_3
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: astore_0
    //   148: aload_0
    //   149: areturn
    //   150: aload_0
    //   151: invokestatic a : (Ljava/lang/Throwable;)Z
    //   154: ifne -> 161
    //   157: aload_0
    //   158: invokevirtual printStackTrace : ()V
    //   161: ldc 'fail'
    //   163: areturn
    // Exception table:
    //   from	to	target	type
    //   8	22	112	java/lang/Throwable
    //   25	34	112	java/lang/Throwable
    //   34	42	112	java/lang/Throwable
    //   44	62	112	java/lang/Throwable
    //   67	109	112	java/lang/Throwable
    //   122	129	112	java/lang/Throwable
    //   129	148	112	java/lang/Throwable
  }
  
  public static String b() {
    try {
      return Build.VERSION.RELEASE;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return "fail";
    } 
  }
  
  public static String b(Context paramContext) {
    String str1;
    String str2 = "fail";
    if (paramContext == null)
      return "fail"; 
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      str1 = str2;
      if (telephonyManager != null) {
        str1 = telephonyManager.getSimSerialNumber();
        if (str1 == null)
          str1 = "null"; 
      } 
    } catch (Throwable throwable) {
      x.a("Failed to get SIM serial number.", new Object[0]);
      str1 = str2;
    } 
    return str1;
  }
  
  public static int c() {
    try {
      return Build.VERSION.SDK_INT;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return -1;
    } 
  }
  
  public static String c(Context paramContext) {
    String str1;
    String str2 = "unknown";
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (networkInfo == null)
        return null; 
      if (networkInfo.getType() == 1) {
        str1 = "WIFI";
      } else {
        String str = str2;
        if (networkInfo.getType() == 0) {
          TelephonyManager telephonyManager = (TelephonyManager)str1.getSystemService("phone");
          str = str2;
          if (telephonyManager != null) {
            StringBuilder stringBuilder;
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
                return "EVDO_B";
              case 11:
                return "iDen";
              case 10:
                return "HSPA";
              case 9:
                return "HSUPA";
              case 8:
                return "HSDPA";
              case 7:
                return "1xRTT";
              case 6:
                return "EVDO_A";
              case 5:
                return "EVDO_0";
              case 4:
                return "CDMA";
              case 3:
                return "UMTS";
              case 2:
                return "EDGE";
              case 1:
                return "GPRS";
            } 
            this("MOBILE(");
            stringBuilder.append(i);
            stringBuilder.append(")");
            str = stringBuilder.toString();
          } 
        } 
        str1 = str;
      } 
    } catch (Exception exception) {
      String str = str2;
      if (!x.a(exception)) {
        exception.printStackTrace();
        str = str2;
      } 
      str1 = str;
    } 
    return str1;
  }
  
  public static String d() {
    return "null";
  }
  
  public static String d(Context paramContext) {
    StringBuilder stringBuilder2;
    String str1;
    StringBuilder stringBuilder1;
    String str2 = z.a(paramContext, "ro.miui.ui.version.name");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder2 = new StringBuilder("XiaoMi/MIUI/");
      stringBuilder2.append(str2);
      return stringBuilder2.toString();
    } 
    str2 = z.a((Context)stringBuilder2, "ro.build.version.emui");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder2 = new StringBuilder("HuaWei/EMOTION/");
      stringBuilder2.append(str2);
      return stringBuilder2.toString();
    } 
    str2 = z.a((Context)stringBuilder2, "ro.lenovo.series");
    if (!z.a(str2) && !str2.equals("fail")) {
      str1 = z.a((Context)stringBuilder2, "ro.build.version.incremental");
      StringBuilder stringBuilder = new StringBuilder("Lenovo/VIBE/");
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    String str3 = z.a((Context)str1, "ro.build.nubia.rom.name");
    if (!z.a(str3) && !str3.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("Zte/NUBIA/");
      stringBuilder.append(str3);
      stringBuilder.append("_");
      stringBuilder.append(z.a((Context)str1, "ro.build.nubia.rom.code"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)str1, "ro.meizu.product.model");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("Meizu/FLYME/");
      stringBuilder.append(z.a((Context)str1, "ro.build.display.id"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)str1, "ro.build.version.opporom");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder1 = new StringBuilder("Oppo/COLOROS/");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.vivo.os.build.display.id");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder1 = new StringBuilder("vivo/FUNTOUCH/");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    str3 = z.a((Context)stringBuilder1, "ro.aa.romver");
    if (!z.a(str3) && !str3.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("htc/");
      stringBuilder.append(str3);
      stringBuilder.append("/");
      stringBuilder.append(z.a((Context)stringBuilder1, "ro.build.description"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.lewa.version");
    if (!z.a(str2) && !str2.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("tcl/");
      stringBuilder.append(str2);
      stringBuilder.append("/");
      stringBuilder.append(z.a((Context)stringBuilder1, "ro.build.display.id"));
      return stringBuilder.toString();
    } 
    str3 = z.a((Context)stringBuilder1, "ro.gn.gnromvernumber");
    if (!z.a(str3) && !str3.equals("fail")) {
      StringBuilder stringBuilder = new StringBuilder("amigo/");
      stringBuilder.append(str3);
      stringBuilder.append("/");
      stringBuilder.append(z.a((Context)stringBuilder1, "ro.build.display.id"));
      return stringBuilder.toString();
    } 
    str2 = z.a((Context)stringBuilder1, "ro.build.tyd.kbstyle_version");
    if (!z.a(str2) && !str2.equals("fail")) {
      stringBuilder1 = new StringBuilder("dido/");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(z.a((Context)stringBuilder1, "ro.build.fingerprint"));
    stringBuilder3.append("/");
    stringBuilder3.append(z.a((Context)stringBuilder1, "ro.build.rom.id"));
    return stringBuilder3.toString();
  }
  
  public static String e() {
    return "null";
  }
  
  public static String e(Context paramContext) {
    return z.a(paramContext, "ro.board.platform");
  }
  
  public static String f() {
    return "null";
  }
  
  public static String f(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    String str2 = z.a(paramContext, "ro.genymotion.version");
    if (str2 != null) {
      stringBuilder.append("ro.genymotion.version");
      stringBuilder.append("|");
      stringBuilder.append(str2);
      stringBuilder.append("\n");
    } 
    str2 = z.a(paramContext, "androVM.vbox_dpi");
    if (str2 != null) {
      stringBuilder.append("androVM.vbox_dpi");
      stringBuilder.append("|");
      stringBuilder.append(str2);
      stringBuilder.append("\n");
    } 
    String str1 = z.a(paramContext, "qemu.sf.fake_camera");
    if (str1 != null) {
      stringBuilder.append("qemu.sf.fake_camera");
      stringBuilder.append("|");
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  public static String g() {
    try {
      return Build.SERIAL;
    } catch (Throwable throwable) {
      x.a("Failed to get hardware serial number.", new Object[0]);
      return "fail";
    } 
  }
  
  public static String g(Context paramContext) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: getstatic com/tencent/bugly/crashreport/common/info/b.d : Ljava/lang/String;
    //   11: ifnonnull -> 24
    //   14: aload_0
    //   15: ldc_w 'ro.secure'
    //   18: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic com/tencent/bugly/crashreport/common/info/b.d : Ljava/lang/String;
    //   24: getstatic com/tencent/bugly/crashreport/common/info/b.d : Ljava/lang/String;
    //   27: ifnull -> 62
    //   30: aload_1
    //   31: ldc_w 'ro.secure'
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: ldc_w '|'
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: getstatic com/tencent/bugly/crashreport/common/info/b.d : Ljava/lang/String;
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: ldc_w '\\n'
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic com/tencent/bugly/crashreport/common/info/b.e : Ljava/lang/String;
    //   65: ifnonnull -> 78
    //   68: aload_0
    //   69: ldc_w 'ro.debuggable'
    //   72: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   75: putstatic com/tencent/bugly/crashreport/common/info/b.e : Ljava/lang/String;
    //   78: getstatic com/tencent/bugly/crashreport/common/info/b.e : Ljava/lang/String;
    //   81: ifnull -> 116
    //   84: aload_1
    //   85: ldc_w 'ro.debuggable'
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_1
    //   93: ldc_w '|'
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: getstatic com/tencent/bugly/crashreport/common/info/b.e : Ljava/lang/String;
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: ldc_w '\\n'
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new java/io/BufferedReader
    //   119: astore_2
    //   120: new java/io/FileReader
    //   123: astore_0
    //   124: aload_0
    //   125: ldc_w '/proc/self/status'
    //   128: invokespecial <init> : (Ljava/lang/String;)V
    //   131: aload_2
    //   132: aload_0
    //   133: invokespecial <init> : (Ljava/io/Reader;)V
    //   136: aload_2
    //   137: astore_0
    //   138: aload_2
    //   139: invokevirtual readLine : ()Ljava/lang/String;
    //   142: astore_3
    //   143: aload_3
    //   144: ifnull -> 159
    //   147: aload_2
    //   148: astore_0
    //   149: aload_3
    //   150: ldc_w 'TracerPid:'
    //   153: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   156: ifeq -> 136
    //   159: aload_3
    //   160: ifnull -> 203
    //   163: aload_2
    //   164: astore_0
    //   165: aload_3
    //   166: bipush #10
    //   168: invokevirtual substring : (I)Ljava/lang/String;
    //   171: invokevirtual trim : ()Ljava/lang/String;
    //   174: astore_3
    //   175: aload_2
    //   176: astore_0
    //   177: aload_1
    //   178: ldc_w 'tracer_pid'
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_2
    //   186: astore_0
    //   187: aload_1
    //   188: ldc_w '|'
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: astore_0
    //   197: aload_1
    //   198: aload_3
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_2
    //   204: astore_0
    //   205: aload_1
    //   206: invokevirtual toString : ()Ljava/lang/String;
    //   209: astore_3
    //   210: aload_2
    //   211: invokevirtual close : ()V
    //   214: goto -> 223
    //   217: astore_0
    //   218: aload_0
    //   219: invokestatic a : (Ljava/lang/Throwable;)Z
    //   222: pop
    //   223: aload_3
    //   224: areturn
    //   225: astore_3
    //   226: goto -> 238
    //   229: astore_2
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -> 268
    //   235: astore_3
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: astore_0
    //   240: aload_3
    //   241: invokestatic a : (Ljava/lang/Throwable;)Z
    //   244: pop
    //   245: aload_2
    //   246: ifnull -> 262
    //   249: aload_2
    //   250: invokevirtual close : ()V
    //   253: goto -> 262
    //   256: astore_0
    //   257: aload_0
    //   258: invokestatic a : (Ljava/lang/Throwable;)Z
    //   261: pop
    //   262: aload_1
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: areturn
    //   267: astore_2
    //   268: aload_0
    //   269: ifnull -> 285
    //   272: aload_0
    //   273: invokevirtual close : ()V
    //   276: goto -> 285
    //   279: astore_0
    //   280: aload_0
    //   281: invokestatic a : (Ljava/lang/Throwable;)Z
    //   284: pop
    //   285: aload_2
    //   286: athrow
    // Exception table:
    //   from	to	target	type
    //   116	136	235	java/lang/Throwable
    //   116	136	229	finally
    //   138	143	225	java/lang/Throwable
    //   138	143	267	finally
    //   149	159	225	java/lang/Throwable
    //   149	159	267	finally
    //   165	175	225	java/lang/Throwable
    //   165	175	267	finally
    //   177	185	225	java/lang/Throwable
    //   177	185	267	finally
    //   187	195	225	java/lang/Throwable
    //   187	195	267	finally
    //   197	203	225	java/lang/Throwable
    //   197	203	267	finally
    //   205	210	225	java/lang/Throwable
    //   205	210	267	finally
    //   210	214	217	java/io/IOException
    //   240	245	267	finally
    //   249	253	256	java/io/IOException
    //   272	276	279	java/io/IOException
  }
  
  public static long h() {
    long l;
    try {
      File file = Environment.getDataDirectory();
      StatFs statFs = new StatFs();
      this(file.getPath());
      l = statFs.getBlockSize();
      int i = statFs.getBlockCount();
      l = i * l;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      l = -1L;
    } 
    return l;
  }
  
  public static String h(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    String str2 = z.a(paramContext, "gsm.sim.state");
    if (str2 != null) {
      stringBuilder.append("gsm.sim.state");
      stringBuilder.append("|");
      stringBuilder.append(str2);
    } 
    stringBuilder.append("\n");
    String str1 = z.a(paramContext, "gsm.sim.state2");
    if (str1 != null) {
      stringBuilder.append("gsm.sim.state2");
      stringBuilder.append("|");
      stringBuilder.append(str1);
    } 
    return stringBuilder.toString();
  }
  
  public static long i() {
    long l;
    try {
      File file = Environment.getDataDirectory();
      StatFs statFs = new StatFs();
      this(file.getPath());
      l = statFs.getBlockSize();
      int i = statFs.getAvailableBlocks();
      l = i * l;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      l = -1L;
    } 
    return l;
  }
  
  public static boolean i(Context paramContext) {
    if (k(paramContext) == null) {
      String str;
      ArrayList<Integer> arrayList = new ArrayList();
      for (byte b1 = 0; b1 < c.length; b1++) {
        if ((b1 == 0) ? !(new File(c[b1])).exists() : (new File(c[b1])).exists())
          arrayList.add(Integer.valueOf(b1)); 
      } 
      if (arrayList.isEmpty()) {
        arrayList = null;
      } else {
        str = arrayList.toString();
      } 
      if (str == null)
        return false; 
    } 
    return true;
  }
  
  public static long j() {
    // Byte code:
    //   0: new java/io/FileReader
    //   3: astore_0
    //   4: aload_0
    //   5: ldc_w '/proc/meminfo'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: new java/io/BufferedReader
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: sipush #2048
    //   20: invokespecial <init> : (Ljava/io/Reader;I)V
    //   23: aload_1
    //   24: astore_2
    //   25: aload_0
    //   26: astore_3
    //   27: aload_1
    //   28: invokevirtual readLine : ()Ljava/lang/String;
    //   31: astore #4
    //   33: aload #4
    //   35: ifnonnull -> 80
    //   38: aload_1
    //   39: invokevirtual close : ()V
    //   42: goto -> 57
    //   45: astore_1
    //   46: aload_1
    //   47: invokestatic a : (Ljava/lang/Throwable;)Z
    //   50: ifne -> 57
    //   53: aload_1
    //   54: invokevirtual printStackTrace : ()V
    //   57: aload_0
    //   58: invokevirtual close : ()V
    //   61: goto -> 76
    //   64: astore_1
    //   65: aload_1
    //   66: invokestatic a : (Ljava/lang/Throwable;)Z
    //   69: ifne -> 76
    //   72: aload_1
    //   73: invokevirtual printStackTrace : ()V
    //   76: ldc2_w -1
    //   79: lreturn
    //   80: aload_1
    //   81: astore_2
    //   82: aload_0
    //   83: astore_3
    //   84: aload #4
    //   86: ldc_w ':\s+'
    //   89: iconst_2
    //   90: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   93: iconst_1
    //   94: aaload
    //   95: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   98: ldc_w 'kb'
    //   101: ldc_w ''
    //   104: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   107: invokevirtual trim : ()Ljava/lang/String;
    //   110: invokestatic parseLong : (Ljava/lang/String;)J
    //   113: lstore #5
    //   115: aload_1
    //   116: invokevirtual close : ()V
    //   119: goto -> 134
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic a : (Ljava/lang/Throwable;)Z
    //   127: ifne -> 134
    //   130: aload_1
    //   131: invokevirtual printStackTrace : ()V
    //   134: aload_0
    //   135: invokevirtual close : ()V
    //   138: goto -> 153
    //   141: astore_1
    //   142: aload_1
    //   143: invokestatic a : (Ljava/lang/Throwable;)Z
    //   146: ifne -> 153
    //   149: aload_1
    //   150: invokevirtual printStackTrace : ()V
    //   153: lload #5
    //   155: bipush #10
    //   157: lshl
    //   158: lreturn
    //   159: astore #4
    //   161: goto -> 191
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_2
    //   167: goto -> 265
    //   170: astore #4
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -> 191
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: astore_2
    //   182: goto -> 265
    //   185: astore #4
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: astore_1
    //   191: aload_1
    //   192: astore_2
    //   193: aload_0
    //   194: astore_3
    //   195: aload #4
    //   197: invokestatic a : (Ljava/lang/Throwable;)Z
    //   200: ifne -> 212
    //   203: aload_1
    //   204: astore_2
    //   205: aload_0
    //   206: astore_3
    //   207: aload #4
    //   209: invokevirtual printStackTrace : ()V
    //   212: aload_1
    //   213: ifnull -> 235
    //   216: aload_1
    //   217: invokevirtual close : ()V
    //   220: goto -> 235
    //   223: astore_1
    //   224: aload_1
    //   225: invokestatic a : (Ljava/lang/Throwable;)Z
    //   228: ifne -> 235
    //   231: aload_1
    //   232: invokevirtual printStackTrace : ()V
    //   235: aload_0
    //   236: ifnull -> 258
    //   239: aload_0
    //   240: invokevirtual close : ()V
    //   243: goto -> 258
    //   246: astore_1
    //   247: aload_1
    //   248: invokestatic a : (Ljava/lang/Throwable;)Z
    //   251: ifne -> 258
    //   254: aload_1
    //   255: invokevirtual printStackTrace : ()V
    //   258: ldc2_w -2
    //   261: lreturn
    //   262: astore_1
    //   263: aload_3
    //   264: astore_0
    //   265: aload_2
    //   266: ifnull -> 288
    //   269: aload_2
    //   270: invokevirtual close : ()V
    //   273: goto -> 288
    //   276: astore_2
    //   277: aload_2
    //   278: invokestatic a : (Ljava/lang/Throwable;)Z
    //   281: ifne -> 288
    //   284: aload_2
    //   285: invokevirtual printStackTrace : ()V
    //   288: aload_0
    //   289: ifnull -> 311
    //   292: aload_0
    //   293: invokevirtual close : ()V
    //   296: goto -> 311
    //   299: astore_0
    //   300: aload_0
    //   301: invokestatic a : (Ljava/lang/Throwable;)Z
    //   304: ifne -> 311
    //   307: aload_0
    //   308: invokevirtual printStackTrace : ()V
    //   311: aload_1
    //   312: athrow
    // Exception table:
    //   from	to	target	type
    //   0	11	185	java/lang/Throwable
    //   0	11	177	finally
    //   11	23	170	java/lang/Throwable
    //   11	23	164	finally
    //   27	33	159	java/lang/Throwable
    //   27	33	262	finally
    //   38	42	45	java/io/IOException
    //   57	61	64	java/io/IOException
    //   84	115	159	java/lang/Throwable
    //   84	115	262	finally
    //   115	119	122	java/io/IOException
    //   134	138	141	java/io/IOException
    //   195	203	262	finally
    //   207	212	262	finally
    //   216	220	223	java/io/IOException
    //   239	243	246	java/io/IOException
    //   269	273	276	java/io/IOException
    //   292	296	299	java/io/IOException
  }
  
  public static boolean j(Context paramContext) {
    return ((l(paramContext) | v() | w() | u()) > 0);
  }
  
  public static long k() {
    // Byte code:
    //   0: new java/io/FileReader
    //   3: astore_0
    //   4: aload_0
    //   5: ldc_w '/proc/meminfo'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: new java/io/BufferedReader
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: sipush #2048
    //   20: invokespecial <init> : (Ljava/io/Reader;I)V
    //   23: aload_1
    //   24: astore_2
    //   25: aload_0
    //   26: astore_3
    //   27: aload_1
    //   28: invokevirtual readLine : ()Ljava/lang/String;
    //   31: pop
    //   32: aload_1
    //   33: astore_2
    //   34: aload_0
    //   35: astore_3
    //   36: aload_1
    //   37: invokevirtual readLine : ()Ljava/lang/String;
    //   40: astore #4
    //   42: aload #4
    //   44: ifnonnull -> 89
    //   47: aload_1
    //   48: invokevirtual close : ()V
    //   51: goto -> 66
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic a : (Ljava/lang/Throwable;)Z
    //   59: ifne -> 66
    //   62: aload_1
    //   63: invokevirtual printStackTrace : ()V
    //   66: aload_0
    //   67: invokevirtual close : ()V
    //   70: goto -> 85
    //   73: astore_1
    //   74: aload_1
    //   75: invokestatic a : (Ljava/lang/Throwable;)Z
    //   78: ifne -> 85
    //   81: aload_1
    //   82: invokevirtual printStackTrace : ()V
    //   85: ldc2_w -1
    //   88: lreturn
    //   89: aload_1
    //   90: astore_2
    //   91: aload_0
    //   92: astore_3
    //   93: aload #4
    //   95: ldc_w ':\s+'
    //   98: iconst_2
    //   99: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   102: iconst_1
    //   103: aaload
    //   104: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   107: ldc_w 'kb'
    //   110: ldc_w ''
    //   113: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   116: invokevirtual trim : ()Ljava/lang/String;
    //   119: invokestatic parseLong : (Ljava/lang/String;)J
    //   122: lstore #5
    //   124: aload_1
    //   125: astore_2
    //   126: aload_0
    //   127: astore_3
    //   128: aload_1
    //   129: invokevirtual readLine : ()Ljava/lang/String;
    //   132: astore #4
    //   134: aload #4
    //   136: ifnonnull -> 181
    //   139: aload_1
    //   140: invokevirtual close : ()V
    //   143: goto -> 158
    //   146: astore_1
    //   147: aload_1
    //   148: invokestatic a : (Ljava/lang/Throwable;)Z
    //   151: ifne -> 158
    //   154: aload_1
    //   155: invokevirtual printStackTrace : ()V
    //   158: aload_0
    //   159: invokevirtual close : ()V
    //   162: goto -> 177
    //   165: astore_1
    //   166: aload_1
    //   167: invokestatic a : (Ljava/lang/Throwable;)Z
    //   170: ifne -> 177
    //   173: aload_1
    //   174: invokevirtual printStackTrace : ()V
    //   177: ldc2_w -1
    //   180: lreturn
    //   181: aload_1
    //   182: astore_2
    //   183: aload_0
    //   184: astore_3
    //   185: aload #4
    //   187: ldc_w ':\s+'
    //   190: iconst_2
    //   191: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   194: iconst_1
    //   195: aaload
    //   196: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   199: ldc_w 'kb'
    //   202: ldc_w ''
    //   205: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   208: invokevirtual trim : ()Ljava/lang/String;
    //   211: invokestatic parseLong : (Ljava/lang/String;)J
    //   214: lstore #7
    //   216: aload_1
    //   217: astore_2
    //   218: aload_0
    //   219: astore_3
    //   220: aload_1
    //   221: invokevirtual readLine : ()Ljava/lang/String;
    //   224: astore #4
    //   226: aload #4
    //   228: ifnonnull -> 273
    //   231: aload_1
    //   232: invokevirtual close : ()V
    //   235: goto -> 250
    //   238: astore_1
    //   239: aload_1
    //   240: invokestatic a : (Ljava/lang/Throwable;)Z
    //   243: ifne -> 250
    //   246: aload_1
    //   247: invokevirtual printStackTrace : ()V
    //   250: aload_0
    //   251: invokevirtual close : ()V
    //   254: goto -> 269
    //   257: astore_1
    //   258: aload_1
    //   259: invokestatic a : (Ljava/lang/Throwable;)Z
    //   262: ifne -> 269
    //   265: aload_1
    //   266: invokevirtual printStackTrace : ()V
    //   269: ldc2_w -1
    //   272: lreturn
    //   273: aload_1
    //   274: astore_2
    //   275: aload_0
    //   276: astore_3
    //   277: aload #4
    //   279: ldc_w ':\s+'
    //   282: iconst_2
    //   283: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   286: iconst_1
    //   287: aaload
    //   288: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   291: ldc_w 'kb'
    //   294: ldc_w ''
    //   297: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   300: invokevirtual trim : ()Ljava/lang/String;
    //   303: invokestatic parseLong : (Ljava/lang/String;)J
    //   306: lstore #9
    //   308: aload_1
    //   309: invokevirtual close : ()V
    //   312: goto -> 327
    //   315: astore_1
    //   316: aload_1
    //   317: invokestatic a : (Ljava/lang/Throwable;)Z
    //   320: ifne -> 327
    //   323: aload_1
    //   324: invokevirtual printStackTrace : ()V
    //   327: aload_0
    //   328: invokevirtual close : ()V
    //   331: goto -> 346
    //   334: astore_1
    //   335: aload_1
    //   336: invokestatic a : (Ljava/lang/Throwable;)Z
    //   339: ifne -> 346
    //   342: aload_1
    //   343: invokevirtual printStackTrace : ()V
    //   346: lload #5
    //   348: bipush #10
    //   350: lshl
    //   351: lconst_0
    //   352: ladd
    //   353: lload #7
    //   355: bipush #10
    //   357: lshl
    //   358: ladd
    //   359: lload #9
    //   361: bipush #10
    //   363: lshl
    //   364: ladd
    //   365: lreturn
    //   366: astore #4
    //   368: goto -> 398
    //   371: astore_1
    //   372: aconst_null
    //   373: astore_2
    //   374: goto -> 472
    //   377: astore #4
    //   379: aconst_null
    //   380: astore_1
    //   381: goto -> 398
    //   384: astore_1
    //   385: aconst_null
    //   386: astore_0
    //   387: aload_0
    //   388: astore_2
    //   389: goto -> 472
    //   392: astore #4
    //   394: aconst_null
    //   395: astore_0
    //   396: aload_0
    //   397: astore_1
    //   398: aload_1
    //   399: astore_2
    //   400: aload_0
    //   401: astore_3
    //   402: aload #4
    //   404: invokestatic a : (Ljava/lang/Throwable;)Z
    //   407: ifne -> 419
    //   410: aload_1
    //   411: astore_2
    //   412: aload_0
    //   413: astore_3
    //   414: aload #4
    //   416: invokevirtual printStackTrace : ()V
    //   419: aload_1
    //   420: ifnull -> 442
    //   423: aload_1
    //   424: invokevirtual close : ()V
    //   427: goto -> 442
    //   430: astore_1
    //   431: aload_1
    //   432: invokestatic a : (Ljava/lang/Throwable;)Z
    //   435: ifne -> 442
    //   438: aload_1
    //   439: invokevirtual printStackTrace : ()V
    //   442: aload_0
    //   443: ifnull -> 465
    //   446: aload_0
    //   447: invokevirtual close : ()V
    //   450: goto -> 465
    //   453: astore_1
    //   454: aload_1
    //   455: invokestatic a : (Ljava/lang/Throwable;)Z
    //   458: ifne -> 465
    //   461: aload_1
    //   462: invokevirtual printStackTrace : ()V
    //   465: ldc2_w -2
    //   468: lreturn
    //   469: astore_1
    //   470: aload_3
    //   471: astore_0
    //   472: aload_2
    //   473: ifnull -> 495
    //   476: aload_2
    //   477: invokevirtual close : ()V
    //   480: goto -> 495
    //   483: astore_2
    //   484: aload_2
    //   485: invokestatic a : (Ljava/lang/Throwable;)Z
    //   488: ifne -> 495
    //   491: aload_2
    //   492: invokevirtual printStackTrace : ()V
    //   495: aload_0
    //   496: ifnull -> 518
    //   499: aload_0
    //   500: invokevirtual close : ()V
    //   503: goto -> 518
    //   506: astore_0
    //   507: aload_0
    //   508: invokestatic a : (Ljava/lang/Throwable;)Z
    //   511: ifne -> 518
    //   514: aload_0
    //   515: invokevirtual printStackTrace : ()V
    //   518: aload_1
    //   519: athrow
    // Exception table:
    //   from	to	target	type
    //   0	11	392	java/lang/Throwable
    //   0	11	384	finally
    //   11	23	377	java/lang/Throwable
    //   11	23	371	finally
    //   27	32	366	java/lang/Throwable
    //   27	32	469	finally
    //   36	42	366	java/lang/Throwable
    //   36	42	469	finally
    //   47	51	54	java/io/IOException
    //   66	70	73	java/io/IOException
    //   93	124	366	java/lang/Throwable
    //   93	124	469	finally
    //   128	134	366	java/lang/Throwable
    //   128	134	469	finally
    //   139	143	146	java/io/IOException
    //   158	162	165	java/io/IOException
    //   185	216	366	java/lang/Throwable
    //   185	216	469	finally
    //   220	226	366	java/lang/Throwable
    //   220	226	469	finally
    //   231	235	238	java/io/IOException
    //   250	254	257	java/io/IOException
    //   277	308	366	java/lang/Throwable
    //   277	308	469	finally
    //   308	312	315	java/io/IOException
    //   327	331	334	java/io/IOException
    //   402	410	469	finally
    //   414	419	469	finally
    //   423	427	430	java/io/IOException
    //   446	450	453	java/io/IOException
    //   476	480	483	java/io/IOException
    //   499	503	506	java/io/IOException
  }
  
  private static String k(Context paramContext) {
    PackageManager packageManager = paramContext.getPackageManager();
    ArrayList<Integer> arrayList = new ArrayList();
    byte b1 = 0;
    while (true) {
      if (b1 < b.length) {
        try {
          packageManager.getPackageInfo(b[b1], 1);
          arrayList.add(Integer.valueOf(b1));
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
        b1++;
        continue;
      } 
      return arrayList.isEmpty() ? null : arrayList.toString();
    } 
  }
  
  private static int l(Context paramContext) {
    int i;
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
      i = 1;
    } catch (Exception exception) {
      i = 0;
    } 
    try {
      packageManager.getInstallerPackageName("com.saurik.substrate");
      i |= 0x2;
    } catch (Exception exception) {}
    return i;
  }
  
  public static long l() {
    if (!t())
      return 0L; 
    try {
      StatFs statFs = new StatFs();
      this(Environment.getExternalStorageDirectory().getPath());
      int i = statFs.getBlockSize();
      int j = statFs.getBlockCount();
      return j * i;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return -2L;
    } 
  }
  
  public static long m() {
    if (!t())
      return 0L; 
    try {
      StatFs statFs = new StatFs();
      this(Environment.getExternalStorageDirectory().getPath());
      int i = statFs.getBlockSize();
      int j = statFs.getAvailableBlocks();
      return j * i;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return -2L;
    } 
  }
  
  public static String n() {
    String str2;
    String str1 = "fail";
    try {
      str2 = Locale.getDefault().getCountry();
    } catch (Throwable throwable) {
      str2 = str1;
      if (!x.a(throwable)) {
        throwable.printStackTrace();
        str2 = str1;
      } 
    } 
    return str2;
  }
  
  public static String o() {
    String str2;
    String str1 = "fail";
    try {
      str2 = Build.BRAND;
    } catch (Throwable throwable) {
      str2 = str1;
      if (!x.a(throwable)) {
        throwable.printStackTrace();
        str2 = str1;
      } 
    } 
    return str2;
  }
  
  public static boolean p() {
    String[] arrayOfString = a;
    int i = arrayOfString.length;
    byte b1 = 0;
    while (true) {
      if (b1 < i) {
        if ((new File(arrayOfString[b1])).exists()) {
          b1 = 1;
          break;
        } 
        b1++;
        continue;
      } 
      b1 = 0;
      break;
    } 
    if (Build.TAGS != null && Build.TAGS.contains("test-keys")) {
      i = 1;
    } else {
      i = 0;
    } 
    return (i != 0 || b1 != 0);
  }
  
  public static String q() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      File file = new File();
    } catch (Throwable throwable) {
    
    } finally {
      BufferedReader bufferedReader = null;
      if (bufferedReader != null)
        try {
          bufferedReader.close();
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
    if (SYNTHETIC_LOCAL_VARIABLE_3 != null)
      try {
        SYNTHETIC_LOCAL_VARIABLE_3.close();
      } catch (IOException iOException) {
        x.a(iOException);
      }  
    return null;
  }
  
  public static String r() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader bufferedReader1 = null;
    BufferedReader bufferedReader2 = null;
    null = null;
    BufferedReader bufferedReader3 = bufferedReader1;
    BufferedReader bufferedReader4 = bufferedReader2;
    try {
      BufferedReader bufferedReader5;
      File file = new File();
      bufferedReader3 = bufferedReader1;
      bufferedReader4 = bufferedReader2;
      this("/sys/class/power_supply/ac/online");
      bufferedReader3 = bufferedReader1;
      bufferedReader4 = bufferedReader2;
      if (file.exists()) {
        bufferedReader3 = bufferedReader1;
        bufferedReader4 = bufferedReader2;
        BufferedReader bufferedReader8 = new BufferedReader();
        bufferedReader3 = bufferedReader1;
        bufferedReader4 = bufferedReader2;
        null = new FileReader();
        bufferedReader3 = bufferedReader1;
        bufferedReader4 = bufferedReader2;
        this("/sys/class/power_supply/ac/online");
        bufferedReader3 = bufferedReader1;
        bufferedReader4 = bufferedReader2;
        this(null);
        BufferedReader bufferedReader7 = bufferedReader8;
        bufferedReader1 = bufferedReader8;
        try {
          str = bufferedReader8.readLine();
          if (str != null) {
            bufferedReader7 = bufferedReader8;
            bufferedReader1 = bufferedReader8;
            stringBuilder.append("ac_online");
            bufferedReader7 = bufferedReader8;
            bufferedReader1 = bufferedReader8;
            stringBuilder.append("|");
            bufferedReader7 = bufferedReader8;
            bufferedReader1 = bufferedReader8;
            stringBuilder.append(str);
          } 
          bufferedReader7 = bufferedReader8;
          bufferedReader1 = bufferedReader8;
        } catch (Throwable throwable) {
        
        } finally {
          bufferedReader3 = null;
          Throwable throwable1 = throwable;
        } 
      } 
      bufferedReader3 = bufferedReader6;
      bufferedReader4 = bufferedReader6;
      stringBuilder.append("\n");
      bufferedReader3 = bufferedReader6;
      bufferedReader4 = bufferedReader6;
      file = new File();
      bufferedReader3 = bufferedReader6;
      bufferedReader4 = bufferedReader6;
      this("/sys/class/power_supply/usb/online");
      bufferedReader1 = bufferedReader6;
      bufferedReader3 = bufferedReader6;
      bufferedReader4 = bufferedReader6;
      if (file.exists()) {
        bufferedReader3 = bufferedReader6;
        bufferedReader4 = bufferedReader6;
        BufferedReader bufferedReader = new BufferedReader();
        bufferedReader3 = bufferedReader6;
        bufferedReader4 = bufferedReader6;
        FileReader fileReader = new FileReader();
        bufferedReader3 = bufferedReader6;
        bufferedReader4 = bufferedReader6;
        this("/sys/class/power_supply/usb/online");
        bufferedReader3 = bufferedReader6;
        bufferedReader4 = bufferedReader6;
        this(fileReader);
        bufferedReader6 = bufferedReader;
        bufferedReader5 = bufferedReader;
        str = bufferedReader.readLine();
        if (str != null) {
          bufferedReader6 = bufferedReader;
          bufferedReader5 = bufferedReader;
          stringBuilder.append("usb_online");
          bufferedReader6 = bufferedReader;
          bufferedReader5 = bufferedReader;
          stringBuilder.append("|");
          bufferedReader6 = bufferedReader;
          bufferedReader5 = bufferedReader;
          stringBuilder.append(str);
        } 
        bufferedReader6 = bufferedReader;
        bufferedReader5 = bufferedReader;
        bufferedReader.close();
        bufferedReader5 = bufferedReader;
      } 
      bufferedReader3 = bufferedReader5;
      bufferedReader4 = bufferedReader5;
      stringBuilder.append("\n");
      bufferedReader3 = bufferedReader5;
      bufferedReader4 = bufferedReader5;
      file = new File();
      bufferedReader3 = bufferedReader5;
      bufferedReader4 = bufferedReader5;
      this("/sys/class/power_supply/battery/capacity");
      BufferedReader bufferedReader6 = bufferedReader5;
      bufferedReader3 = bufferedReader5;
      bufferedReader4 = bufferedReader5;
    } catch (Throwable throwable) {
    
    } finally {
      String str1 = str;
      if (str1 != null)
        try {
          str1.close();
        } catch (IOException iOException) {
          x.a(iOException);
        }  
    } 
    return stringBuilder.toString();
  }
  
  public static long s() {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_0
    //   2: fconst_0
    //   3: fstore_1
    //   4: fconst_0
    //   5: fstore_2
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore #4
    //   11: aload #4
    //   13: astore #5
    //   15: new java/io/BufferedReader
    //   18: astore #6
    //   20: aload #4
    //   22: astore #5
    //   24: new java/io/FileReader
    //   27: astore #7
    //   29: aload #4
    //   31: astore #5
    //   33: aload #7
    //   35: ldc_w '/proc/uptime'
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: aload #4
    //   43: astore #5
    //   45: aload #6
    //   47: aload #7
    //   49: invokespecial <init> : (Ljava/io/Reader;)V
    //   52: aload #6
    //   54: invokevirtual readLine : ()Ljava/lang/String;
    //   57: astore #5
    //   59: aload #5
    //   61: ifnull -> 97
    //   64: aload #5
    //   66: ldc_w ' '
    //   69: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   72: iconst_0
    //   73: aaload
    //   74: astore #5
    //   76: invokestatic currentTimeMillis : ()J
    //   79: ldc2_w 1000
    //   82: ldiv
    //   83: l2f
    //   84: fstore #8
    //   86: aload #5
    //   88: invokestatic parseFloat : (Ljava/lang/String;)F
    //   91: fstore_2
    //   92: fload #8
    //   94: fload_2
    //   95: fsub
    //   96: fstore_2
    //   97: fload_2
    //   98: fstore_0
    //   99: aload #6
    //   101: invokevirtual close : ()V
    //   104: goto -> 174
    //   107: astore #5
    //   109: aload #5
    //   111: invokestatic a : (Ljava/lang/Throwable;)Z
    //   114: pop
    //   115: fload_0
    //   116: fstore_2
    //   117: goto -> 174
    //   120: astore #5
    //   122: aload #6
    //   124: astore_3
    //   125: aload #5
    //   127: astore #6
    //   129: aload_3
    //   130: astore #5
    //   132: goto -> 177
    //   135: astore #5
    //   137: goto -> 145
    //   140: astore #6
    //   142: goto -> 177
    //   145: aload #6
    //   147: astore #5
    //   149: ldc_w 'Failed to get boot time of device.'
    //   152: iconst_0
    //   153: anewarray java/lang/Object
    //   156: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   159: pop
    //   160: fload_1
    //   161: fstore_2
    //   162: aload #6
    //   164: ifnull -> 174
    //   167: aload #6
    //   169: invokevirtual close : ()V
    //   172: fload_1
    //   173: fstore_2
    //   174: fload_2
    //   175: f2l
    //   176: lreturn
    //   177: aload #5
    //   179: ifnull -> 198
    //   182: aload #5
    //   184: invokevirtual close : ()V
    //   187: goto -> 198
    //   190: astore #5
    //   192: aload #5
    //   194: invokestatic a : (Ljava/lang/Throwable;)Z
    //   197: pop
    //   198: aload #6
    //   200: athrow
    //   201: astore #5
    //   203: aload_3
    //   204: astore #6
    //   206: goto -> 145
    // Exception table:
    //   from	to	target	type
    //   15	20	201	java/lang/Throwable
    //   15	20	140	finally
    //   24	29	201	java/lang/Throwable
    //   24	29	140	finally
    //   33	41	201	java/lang/Throwable
    //   33	41	140	finally
    //   45	52	201	java/lang/Throwable
    //   45	52	140	finally
    //   52	59	135	java/lang/Throwable
    //   52	59	120	finally
    //   64	92	135	java/lang/Throwable
    //   64	92	120	finally
    //   99	104	107	java/io/IOException
    //   149	160	140	finally
    //   167	172	107	java/io/IOException
    //   182	187	190	java/io/IOException
  }
  
  private static boolean t() {
    try {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      if (bool)
        return true; 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
    } 
    return false;
  }
  
  private static int u() {
    char c = 'Ā';
    try {
      Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
      method.setAccessible(true);
      boolean bool = method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy");
      if (!bool)
        c = Character.MIN_VALUE; 
    } catch (Exception exception) {}
    return c;
  }
  
  private static int v() {
    try {
      Exception exception = new Exception();
      this("detect hook");
      throw exception;
    } catch (Exception exception) {
      StackTraceElement[] arrayOfStackTraceElement = exception.getStackTrace();
      int i = arrayOfStackTraceElement.length;
      byte b1 = 0;
      int j = 0;
      byte b2;
      for (b2 = 0; b1 < i; b2 = b3) {
        StackTraceElement stackTraceElement = arrayOfStackTraceElement[b1];
        int k = j;
        if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge")) {
          k = j;
          if (stackTraceElement.getMethodName().equals("main"))
            k = j | 0x4; 
        } 
        j = k;
        if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge")) {
          j = k;
          if (stackTraceElement.getMethodName().equals("handleHookedMethod"))
            j = k | 0x8; 
        } 
        k = j;
        if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2")) {
          k = j;
          if (stackTraceElement.getMethodName().equals("invoked"))
            k = j | 0x10; 
        } 
        j = k;
        byte b3 = b2;
        if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit")) {
          b2++;
          j = k;
          b3 = b2;
          if (b2 == 2) {
            j = k | 0x20;
            b3 = b2;
          } 
        } 
        b1++;
      } 
      return j;
    } 
  }
  
  private static int w() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: iconst_0
    //   3: istore_1
    //   4: iconst_0
    //   5: istore_2
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore #4
    //   11: iconst_0
    //   12: istore #5
    //   14: iconst_0
    //   15: istore #6
    //   17: new java/util/HashSet
    //   20: astore #7
    //   22: aload #7
    //   24: invokespecial <init> : ()V
    //   27: new java/io/BufferedReader
    //   30: astore #8
    //   32: new java/io/InputStreamReader
    //   35: astore #9
    //   37: new java/io/FileInputStream
    //   40: astore #10
    //   42: new java/lang/StringBuilder
    //   45: astore #11
    //   47: aload #11
    //   49: ldc_w '/proc/'
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: aload #11
    //   57: invokestatic myPid : ()I
    //   60: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #11
    //   66: ldc_w '/maps'
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload #10
    //   75: aload #11
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: aload #9
    //   85: aload #10
    //   87: ldc_w 'utf-8'
    //   90: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   93: aload #8
    //   95: aload #9
    //   97: invokespecial <init> : (Ljava/io/Reader;)V
    //   100: iload_0
    //   101: istore_3
    //   102: iload_1
    //   103: istore #4
    //   105: iload_2
    //   106: istore #5
    //   108: aload #8
    //   110: astore #11
    //   112: aload #8
    //   114: invokevirtual readLine : ()Ljava/lang/String;
    //   117: astore #9
    //   119: aload #9
    //   121: ifnull -> 206
    //   124: iload_0
    //   125: istore_3
    //   126: iload_1
    //   127: istore #4
    //   129: iload_2
    //   130: istore #5
    //   132: aload #8
    //   134: astore #11
    //   136: aload #9
    //   138: ldc_w '.so'
    //   141: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   144: ifne -> 170
    //   147: iload_0
    //   148: istore_3
    //   149: iload_1
    //   150: istore #4
    //   152: iload_2
    //   153: istore #5
    //   155: aload #8
    //   157: astore #11
    //   159: aload #9
    //   161: ldc_w '.jar'
    //   164: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   167: ifeq -> 100
    //   170: iload_0
    //   171: istore_3
    //   172: iload_1
    //   173: istore #4
    //   175: iload_2
    //   176: istore #5
    //   178: aload #8
    //   180: astore #11
    //   182: aload #7
    //   184: aload #9
    //   186: aload #9
    //   188: ldc_w ' '
    //   191: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   194: iconst_1
    //   195: iadd
    //   196: invokevirtual substring : (I)Ljava/lang/String;
    //   199: invokevirtual add : (Ljava/lang/Object;)Z
    //   202: pop
    //   203: goto -> 100
    //   206: iload_0
    //   207: istore_3
    //   208: iload_1
    //   209: istore #4
    //   211: iload_2
    //   212: istore #5
    //   214: aload #8
    //   216: astore #11
    //   218: aload #7
    //   220: invokevirtual iterator : ()Ljava/util/Iterator;
    //   223: astore #9
    //   225: iload #6
    //   227: istore_3
    //   228: iload #6
    //   230: istore #4
    //   232: iload #6
    //   234: istore #5
    //   236: aload #8
    //   238: astore #11
    //   240: aload #9
    //   242: invokeinterface hasNext : ()Z
    //   247: ifeq -> 358
    //   250: iload #6
    //   252: istore_3
    //   253: iload #6
    //   255: istore #4
    //   257: iload #6
    //   259: istore #5
    //   261: aload #8
    //   263: astore #11
    //   265: aload #9
    //   267: invokeinterface next : ()Ljava/lang/Object;
    //   272: astore #7
    //   274: iload #6
    //   276: istore_0
    //   277: iload #6
    //   279: istore_3
    //   280: iload #6
    //   282: istore #4
    //   284: iload #6
    //   286: istore #5
    //   288: aload #8
    //   290: astore #11
    //   292: aload #7
    //   294: checkcast java/lang/String
    //   297: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   300: ldc_w 'xposed'
    //   303: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   306: ifeq -> 315
    //   309: iload #6
    //   311: bipush #64
    //   313: ior
    //   314: istore_0
    //   315: iload_0
    //   316: istore_3
    //   317: iload_0
    //   318: istore #4
    //   320: iload_0
    //   321: istore #5
    //   323: aload #8
    //   325: astore #11
    //   327: aload #7
    //   329: checkcast java/lang/String
    //   332: ldc_w 'com.saurik.substrate'
    //   335: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   338: istore #12
    //   340: iload_0
    //   341: istore #6
    //   343: iload #12
    //   345: ifeq -> 225
    //   348: iload_0
    //   349: sipush #128
    //   352: ior
    //   353: istore #6
    //   355: goto -> 225
    //   358: iload #6
    //   360: istore_0
    //   361: aload #8
    //   363: invokevirtual close : ()V
    //   366: goto -> 513
    //   369: astore #11
    //   371: aload #11
    //   373: invokevirtual printStackTrace : ()V
    //   376: iload_0
    //   377: istore #6
    //   379: goto -> 513
    //   382: astore #7
    //   384: goto -> 410
    //   387: astore #7
    //   389: goto -> 445
    //   392: astore #7
    //   394: goto -> 483
    //   397: astore #11
    //   399: aconst_null
    //   400: astore #8
    //   402: goto -> 526
    //   405: astore #7
    //   407: aconst_null
    //   408: astore #8
    //   410: aload #8
    //   412: astore #11
    //   414: aload #7
    //   416: invokevirtual printStackTrace : ()V
    //   419: iload_3
    //   420: istore #6
    //   422: aload #8
    //   424: ifnull -> 513
    //   427: iload_3
    //   428: istore_0
    //   429: aload #8
    //   431: invokevirtual close : ()V
    //   434: iload_3
    //   435: istore #6
    //   437: goto -> 513
    //   440: astore #7
    //   442: aconst_null
    //   443: astore #8
    //   445: aload #8
    //   447: astore #11
    //   449: aload #7
    //   451: invokevirtual printStackTrace : ()V
    //   454: iload #4
    //   456: istore #6
    //   458: aload #8
    //   460: ifnull -> 513
    //   463: iload #4
    //   465: istore_0
    //   466: aload #8
    //   468: invokevirtual close : ()V
    //   471: iload #4
    //   473: istore #6
    //   475: goto -> 513
    //   478: astore #7
    //   480: aconst_null
    //   481: astore #8
    //   483: aload #8
    //   485: astore #11
    //   487: aload #7
    //   489: invokevirtual printStackTrace : ()V
    //   492: iload #5
    //   494: istore #6
    //   496: aload #8
    //   498: ifnull -> 513
    //   501: iload #5
    //   503: istore_0
    //   504: aload #8
    //   506: invokevirtual close : ()V
    //   509: iload #5
    //   511: istore #6
    //   513: iload #6
    //   515: ireturn
    //   516: astore #7
    //   518: aload #11
    //   520: astore #8
    //   522: aload #7
    //   524: astore #11
    //   526: aload #8
    //   528: ifnull -> 546
    //   531: aload #8
    //   533: invokevirtual close : ()V
    //   536: goto -> 546
    //   539: astore #8
    //   541: aload #8
    //   543: invokevirtual printStackTrace : ()V
    //   546: aload #11
    //   548: athrow
    // Exception table:
    //   from	to	target	type
    //   17	100	478	java/io/UnsupportedEncodingException
    //   17	100	440	java/io/FileNotFoundException
    //   17	100	405	java/io/IOException
    //   17	100	397	finally
    //   112	119	392	java/io/UnsupportedEncodingException
    //   112	119	387	java/io/FileNotFoundException
    //   112	119	382	java/io/IOException
    //   112	119	516	finally
    //   136	147	392	java/io/UnsupportedEncodingException
    //   136	147	387	java/io/FileNotFoundException
    //   136	147	382	java/io/IOException
    //   136	147	516	finally
    //   159	170	392	java/io/UnsupportedEncodingException
    //   159	170	387	java/io/FileNotFoundException
    //   159	170	382	java/io/IOException
    //   159	170	516	finally
    //   182	203	392	java/io/UnsupportedEncodingException
    //   182	203	387	java/io/FileNotFoundException
    //   182	203	382	java/io/IOException
    //   182	203	516	finally
    //   218	225	392	java/io/UnsupportedEncodingException
    //   218	225	387	java/io/FileNotFoundException
    //   218	225	382	java/io/IOException
    //   218	225	516	finally
    //   240	250	392	java/io/UnsupportedEncodingException
    //   240	250	387	java/io/FileNotFoundException
    //   240	250	382	java/io/IOException
    //   240	250	516	finally
    //   265	274	392	java/io/UnsupportedEncodingException
    //   265	274	387	java/io/FileNotFoundException
    //   265	274	382	java/io/IOException
    //   265	274	516	finally
    //   292	309	392	java/io/UnsupportedEncodingException
    //   292	309	387	java/io/FileNotFoundException
    //   292	309	382	java/io/IOException
    //   292	309	516	finally
    //   327	340	392	java/io/UnsupportedEncodingException
    //   327	340	387	java/io/FileNotFoundException
    //   327	340	382	java/io/IOException
    //   327	340	516	finally
    //   361	366	369	java/io/IOException
    //   414	419	516	finally
    //   429	434	369	java/io/IOException
    //   449	454	516	finally
    //   466	471	369	java/io/IOException
    //   487	492	516	finally
    //   504	509	369	java/io/IOException
    //   531	536	539	java/io/IOException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */