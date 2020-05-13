package com.sdk.base.framework.utils.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import com.sdk.base.framework.utils.a.a;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.k.a;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;

@Keep
public class AppUtils extends a {
  private static final String TAG = AppUtils.class.getName();
  
  private static Stack<Activity> activityStack;
  
  private static boolean isDebug = c.h;
  
  private static int targetSdkVersion;
  
  static {
    activityStack = new Stack<Activity>();
    targetSdkVersion = -1;
  }
  
  private static String doFingerprint(byte[] paramArrayOfbyte, String paramString) {
    MessageDigest messageDigest = MessageDigest.getInstance(paramString);
    messageDigest.update(paramArrayOfbyte);
    byte[] arrayOfByte = messageDigest.digest();
    String str = "";
    for (byte b = 0; b < arrayOfByte.length; b++) {
      String str1 = str;
      if (b != 0)
        str1 = str + ":"; 
      String str2 = Integer.toHexString(arrayOfByte[b] & 0xFF);
      str = str1;
      if (str2.length() == 1)
        str = str1 + "0"; 
      str = str + str2;
    } 
    return str;
  }
  
  @SuppressLint({"NewApi"})
  public static int getAndroidSDKVersion(Context paramContext) {
    int i = -1;
    try {
      int j = Build.VERSION.SDK_INT;
      i = j;
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
    } 
    return i;
  }
  
  public static String getApiKey(Context paramContext, String paramString) {
    String str = getMetaData(paramContext, paramString);
    paramString = str;
    if (a.a(str).booleanValue())
      paramString = a.a(paramContext, "api_key"); 
    return paramString;
  }
  
  public static Drawable getAppIcon(Context paramContext) {
    Drawable drawable2;
    Drawable drawable1 = null;
    if (paramContext == null) {
      logError(TAG, "getAppIcon", "mContext 为空", isDebug);
      return drawable1;
    } 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      drawable2 = drawable1;
      if (packageInfo != null) {
        int i = packageInfo.applicationInfo.icon;
        drawable2 = paramContext.getResources().getDrawable(i);
      } 
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      drawable2 = drawable1;
    } 
    return drawable2;
  }
  
  public static String getAppLable(Context paramContext) {
    Context context1;
    Context context2 = null;
    if (paramContext == null) {
      logError(TAG, "getAppLable", "mContext 为空", isDebug);
      return (String)context2;
    } 
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      String str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(paramContext.getPackageName(), 128)).toString();
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      context1 = context2;
    } 
    return (String)context1;
  }
  
  public static String getAppMd5(Context paramContext) {
    PackageManager packageManager1 = null;
    PackageManager packageManager2 = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager2.getPackageInfo(paramContext.getPackageName(), 64);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      b.c(TAG, nameNotFoundException.getMessage(), Boolean.valueOf(isDebug));
      nameNotFoundException = null;
    } 
    packageManager2 = packageManager1;
    if (nameNotFoundException != null) {
      if ((((PackageInfo)nameNotFoundException).applicationInfo.flags & 0x2) != 0);
      try {
        String str = doFingerprint(((PackageInfo)nameNotFoundException).signatures[0].toByteArray(), "MD5");
      } catch (Exception exception) {
        b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
        packageManager2 = packageManager1;
      } 
    } 
    return (String)packageManager2;
  }
  
  public static long getInstallDate(Context paramContext) {
    Long long_1 = a.c(paramContext, c.d);
    Long long_2 = long_1;
    if (long_1.longValue() == 0L) {
      long_2 = Long.valueOf(System.currentTimeMillis());
      a.a(paramContext, c.d, long_2);
    } 
    return long_2.longValue();
  }
  
  public static String getLocalIPAddress() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
            return inetAddress.getHostAddress().toString(); 
        } 
      } 
    } catch (SocketException socketException) {}
    return "null";
  }
  
  public static <T> T getMetaData(Context paramContext, String paramString) {
    T t2;
    T t1 = null;
    T t3 = t1;
    if (paramContext != null) {
      if (a.a(paramString).booleanValue())
        return t1; 
    } else {
      return t3;
    } 
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(getPackageName(paramContext), 128);
      T t = t1;
      if (applicationInfo != null) {
        Bundle bundle = applicationInfo.metaData;
        T t4 = t1;
        if (bundle != null)
          t4 = (T)bundle.get(paramString); 
      } 
    } catch (Exception exception) {
      b.a(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      t2 = t1;
    } 
    return t2;
  }
  
  public static String getPackageName() {
    try {
      Method method = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentPackageName", new Class[0]);
      method.setAccessible(true);
      String str = (String)method.invoke(null, new Object[0]);
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      exception = null;
    } 
    return (String)exception;
  }
  
  public static String getPackageName(Context paramContext) {
    Context context1;
    Context context2 = null;
    if (paramContext == null) {
      b.d(TAG, "mContext 为空", Boolean.valueOf(isDebug));
      return (String)context2;
    } 
    try {
      String str = paramContext.getPackageName();
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      context1 = context2;
    } 
    return (String)context1;
  }
  
  @SuppressLint({"NewApi"})
  public static int getTargetSdkVersion(Context paramContext) {
    if (paramContext == null)
      return targetSdkVersion; 
    if (targetSdkVersion == -1) {
      int j;
      try {
        PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(getPackageName(paramContext), 1);
        if (packageInfo != null)
          targetSdkVersion = packageInfo.applicationInfo.targetSdkVersion; 
        j = targetSdkVersion;
      } catch (Exception exception) {
        b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      } 
      return j;
    } 
    int i = targetSdkVersion;
  }
  
  public static int getVersionCode(Context paramContext) {
    byte b2;
    byte b1 = -1;
    if (paramContext == null)
      return b1; 
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(getPackageName(paramContext), 1);
      b2 = b1;
      if (packageInfo != null)
        b2 = packageInfo.versionCode; 
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      b2 = b1;
    } 
    return b2;
  }
  
  public static String getVersionName(Context paramContext) {
    Context context1;
    Context context2 = null;
    if (paramContext == null)
      return (String)context2; 
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      PackageInfo packageInfo = packageManager.getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = context2;
      if (packageInfo != null)
        String str = packageInfo.versionName; 
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      context1 = context2;
    } 
    return (String)context1;
  }
  
  public static boolean isFirstLogin(Context paramContext) {
    return false;
  }
  
  public static boolean isServiceRunning(Context paramContext, String paramString) {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramContext == null) {
      b.d(TAG, "isServiceRunning: mContext 为空", Boolean.valueOf(isDebug));
      return bool3;
    } 
    try {
      Iterator iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
      while (true) {
        bool3 = bool1;
        bool2 = bool1;
        if (iterator.hasNext()) {
          bool2 = bool1;
          bool3 = paramString.equals(((ActivityManager.RunningServiceInfo)iterator.next()).service.getClassName());
          if (bool3)
            bool1 = true; 
          continue;
        } 
        return bool3;
      } 
    } catch (Exception exception) {
      b.c(TAG, exception.getMessage(), Boolean.valueOf(isDebug));
      bool3 = bool2;
    } 
    return bool3;
  }
  
  public void addActivity(Activity paramActivity) {
    activityStack.add(paramActivity);
  }
  
  public Activity currentActivity() {
    return activityStack.lastElement();
  }
  
  public void finishActivity() {
    finishActivity(activityStack.lastElement());
  }
  
  public void finishActivity(Activity paramActivity) {
    if (paramActivity != null) {
      activityStack.remove(paramActivity);
      paramActivity.finish();
    } 
  }
  
  public void finishActivity(Class<?> paramClass) {
    for (Activity activity : activityStack) {
      if (activity.getClass().equals(paramClass))
        finishActivity(activity); 
    } 
  }
  
  public void finishAllActivity() {
    for (byte b = 0; b < activityStack.size(); b++) {
      if (activityStack.get(b) != null)
        ((Activity)activityStack.get(b)).finish(); 
    } 
    activityStack.clear();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\app\AppUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */