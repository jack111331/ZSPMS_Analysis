package com.tencent.tp;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.tp.a.a;
import com.tencent.tp.a.b;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collection;
import java.util.Enumeration;

public class TssSdkRuntime {
  private static Context m_context;
  
  private static PackageInfo m_packageInfo;
  
  private static void SendLocalIps() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      if (enumeration == null)
        return; 
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        if (enumeration1 == null)
          continue; 
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress())
            continue; 
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("ip:");
          stringBuilder.append(inetAddress.getHostAddress());
          u.b(stringBuilder.toString());
        } 
      } 
    } catch (Throwable throwable) {}
  }
  
  public static boolean detectDebugger() {
    return Debug.isDebuggerConnected();
  }
  
  private static void doAsyncInitializeTask(Context paramContext) {
    (new a(paramContext)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
  }
  
  public static void doSyncInitalizeTask2(Context paramContext) {
    k k = k.a();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("apk_name:");
    stringBuilder3.append(getPackageName());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("app_name:");
    stringBuilder3.append(getAppName());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("ver:");
    stringBuilder3.append(getAppVer());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("vercode:");
    stringBuilder3.append(getAppVersionCode());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("imei:");
    stringBuilder3.append(k.a(paramContext));
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("model:");
    stringBuilder3.append(z.j());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("api_level:");
    stringBuilder3.append(z.c());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("sys_ver:");
    stringBuilder3.append(z.r());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("wifi:");
    stringBuilder3.append(k.b(paramContext));
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("sdcard:");
    stringBuilder3.append(getSdCardPath(paramContext));
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("sd_package:");
    stringBuilder3.append(getExternalPackageDir(paramContext));
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("net_type:");
    stringBuilder3.append(getNetWorkType());
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("net_provider:");
    stringBuilder3.append(getNetProviderType(paramContext));
    u.a(stringBuilder3.toString());
    u.a("ip_beg");
    SendLocalIps();
    u.a("ip_end");
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("dev_macaddress:");
    stringBuilder3.append(k.c(m_context));
    u.a(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("dev_imsi:");
    stringBuilder3.append(k.e(m_context));
    u.a(stringBuilder3.toString());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("dev_resolution:");
    stringBuilder2.append(z.l(m_context));
    u.a(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("dev_cpuname:");
    stringBuilder2.append(z.t());
    u.a(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("dev_romsize:");
    stringBuilder2.append(z.q());
    u.a(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("debugger:");
    stringBuilder2.append(detectDebugger());
    u.a(stringBuilder2.toString());
    a a = new a(paramContext, null);
    String str2 = a.a();
    if (str2 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cert:");
      stringBuilder.append(str2);
      u.a(stringBuilder.toString());
    } 
    String str1 = a.c();
    if (str1 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cert_author:");
      stringBuilder.append(str1);
      u.a(stringBuilder.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("certenv:");
    if (f.a()) {
      str1 = "true";
    } else {
      str1 = "false";
    } 
    stringBuilder1.append(str1);
    u.a(stringBuilder1.toString());
  }
  
  private static void doSyncInitializeTask(Context paramContext) {
    u.a("jar_ver:4.2.20(2019/11/28)-jar-version");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("files_dir:");
    stringBuilder.append(getFilesDirPath(paramContext));
    u.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("apk_path:");
    stringBuilder.append(getApkPath(paramContext));
    u.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("lib_dir:");
    stringBuilder.append(getNativeLibraryDir(paramContext));
    u.a(stringBuilder.toString());
  }
  
  private static boolean getAdbEnabled(Context paramContext) {
    boolean bool = false;
    try {
      int i = Settings.Secure.getInt(paramContext.getContentResolver(), "adb_enabled", 0);
      if (i != 0)
        bool = true; 
    } catch (Throwable throwable) {}
    return bool;
  }
  
  public static boolean getAdbEnabledOverUsb(Context paramContext) {
    boolean bool;
    if (getAdbEnabled(paramContext) && getUsbConnected(paramContext)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static String getApkPath(Context paramContext) {
    try {
      String str = paramContext.getPackageResourcePath();
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static Context getAppContext() {
    if (m_context == null)
      try {
        m_context = (Context)j.a("android.app.ActivityThread", j.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mInitialApplication");
      } catch (Exception exception) {
        m_context = null;
      }  
    return m_context;
  }
  
  public static String getAppName() {
    Context context = getAppContext();
    return (context != null) ? z.i(context) : null;
  }
  
  public static String getAppVer() {
    PackageInfo packageInfo = getPackageInfo();
    return (packageInfo != null) ? packageInfo.versionName : null;
  }
  
  public static int getAppVersionCode() {
    PackageInfo packageInfo = getPackageInfo();
    return (packageInfo != null) ? packageInfo.versionCode : 0;
  }
  
  public static Activity getCurrentActivity() {
    Activity activity1 = getUnity3dCurrentActivity();
    Activity activity2 = activity1;
    if (activity1 == null)
      activity2 = getFirstActivity(); 
    return activity2;
  }
  
  private static String getExternalPackageDir(Context paramContext) {
    try {
      String str = b.d(paramContext);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  private static String getFilesDirPath(Context paramContext) {
    try {
      String str = b.a(paramContext);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  private static Activity getFirstActivity() {
    Activity activity2;
    Activity activity1 = null;
    byte b = 0;
    try {
      Object[] arrayOfObject = ((Collection)j.a("java.util.Map", "values", j.a("android.app.ActivityThread", j.a("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]), "mActivities"), new Class[0], new Object[0])).toArray();
      while (true) {
        activity2 = activity1;
        if (b < arrayOfObject.length) {
          activity2 = (Activity)arrayOfObject[b];
          if (activity2 != null) {
            activity2 = (Activity)j.a("android.app.ActivityThread$ActivityClientRecord", activity2, "activity");
            if (activity2 != null) {
              activity2 = activity2;
              break;
            } 
          } 
          b++;
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      activity2 = activity1;
      if (u.c() == 1) {
        exception.printStackTrace();
        activity2 = activity1;
      } 
    } 
    return activity2;
  }
  
  private static String getNativeLibraryDir(Context paramContext) {
    Throwable throwable2 = null;
    try {
      ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
      int i = Build.VERSION.SDK_INT;
      if (i >= 9)
        try {
          String str = (String)c.a("android.content.pm.ApplicationInfo", applicationInfo, "nativeLibraryDir");
          if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(applicationInfo.dataDir);
            stringBuilder.append(File.separator);
            stringBuilder.append("lib");
            String str1 = stringBuilder.toString();
          } 
        } catch (Exception null) {} 
      paramContext = null;
      if (paramContext == null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(applicationInfo.dataDir);
        stringBuilder.append(File.separator);
        stringBuilder.append("lib");
        String str = stringBuilder.toString();
      } 
    } catch (Throwable throwable1) {
      throwable1 = throwable2;
    } 
    return (String)throwable1;
  }
  
  public static int getNetProviderType(Context paramContext) {
    byte b = -1;
    int i = b;
    if (paramContext != null)
      try {
        NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        i = b;
        if (networkInfo != null) {
          i = b;
          if (networkInfo.getType() == 0) {
            TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
            i = b;
            if (telephonyManager != null) {
              i = telephonyManager.getNetworkType();
              switch (i) {
                default:
                  return b;
                case 13:
                  return 5;
                case 4:
                case 5:
                case 6:
                case 7:
                case 12:
                  return 3;
                case 2:
                  return 1;
                case 1:
                case 3:
                case 8:
                  break;
              } 
              i = 2;
            } 
          } 
        } 
      } catch (Throwable throwable) {
        i = b;
      }  
    return i;
  }
  
  public static int getNetWorkType() {
    Context context = getAppContext();
    byte b = -1;
    int i = b;
    if (context != null)
      try {
        NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        i = b;
        if (networkInfo != null) {
          i = networkInfo.getType();
          switch (i) {
            default:
              return b;
            case 1:
              return 2;
            case 0:
              break;
          } 
          i = 1;
        } 
      } catch (Throwable throwable) {
        i = b;
      }  
    return i;
  }
  
  public static PackageInfo getPackageInfo() {
    if (m_packageInfo == null)
      try {
        Context context = getAppContext();
        String str = getPackageName();
        if (context != null && str != null) {
          PackageManager packageManager = context.getPackageManager();
          if (packageManager != null)
            try {
              m_packageInfo = packageManager.getPackageInfo(str, 0);
            } catch (Exception exception) {
              m_packageInfo = null;
            }  
        } 
      } catch (Exception exception) {
        m_packageInfo = null;
      }  
    return m_packageInfo;
  }
  
  public static String getPackageName() {
    try {
      Context context = getAppContext();
      if (context != null)
        return context.getPackageName(); 
    } catch (Exception exception) {}
    return null;
  }
  
  private static String getSdCardPath(Context paramContext) {
    try {
      String str = b.c(paramContext);
    } catch (Throwable throwable) {
      throwable = null;
    } 
    return (String)throwable;
  }
  
  public static Activity getUnity3dCurrentActivity() {
    try {
      Activity activity = (Activity)j.a("com.unity3d.player.UnityPlayer", "currentActivity");
    } catch (Exception exception) {
      exception = null;
    } 
    return (Activity)exception;
  }
  
  private static boolean getUsbConnected(Context paramContext) {
    boolean bool = false;
    try {
      IntentFilter intentFilter = new IntentFilter();
      this("android.intent.action.BATTERY_CHANGED");
      int i = paramContext.registerReceiver(null, intentFilter).getIntExtra("plugged", -1);
      if (i == 2)
        bool = true; 
    } catch (Throwable throwable) {}
    return bool;
  }
  
  public static void initialize2() {
    Context context = getAppContext();
    if (context != null) {
      try {
        doSyncInitializeTask(context);
      } catch (Throwable throwable) {}
      doAsyncInitializeTask(context);
      u.a("info:main initialize done");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\TssSdkRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */