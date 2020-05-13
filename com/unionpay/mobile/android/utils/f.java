package com.unionpay.mobile.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Locale;
import java.util.TimeZone;

public final class f {
  public static String a() {
    return Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US";
  }
  
  public static String a(Context paramContext) {
    Activity activity = (Activity)paramContext;
    PackageManager packageManager = activity.getPackageManager();
    try {
      String str = (packageManager.getPackageInfo(activity.getPackageName(), 4160)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
    } 
    return c.bD.a;
  }
  
  private static String a(String paramString) {
    String str;
    byte b = 0;
    try {
      byte[] arrayOfByte = NetworkInterface.getByName(paramString).getHardwareAddress();
      if (arrayOfByte == null)
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      int i = arrayOfByte.length;
      while (b < i) {
        stringBuilder.append(String.format("%02x:", new Object[] { Byte.valueOf(arrayOfByte[b]) }));
        b++;
      } 
      if (stringBuilder.length() > 0)
        stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
      str = stringBuilder.toString();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String b() {
    return (new File("/system/bin/su")).exists() ? "1" : "0";
  }
  
  public static String b(Context paramContext) {
    if (paramContext != null && paramContext instanceof Activity) {
      String str = ((Activity)paramContext).getPackageName();
      if (str == null)
        str = ""; 
      return str;
    } 
    return "";
  }
  
  public static String c() {
    String str = Build.MODEL.trim();
    if (str != null)
      str.replace(" ", ""); 
    return str;
  }
  
  public static final String c(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmpge -> 78
    //   8: aload_0
    //   9: ldc 'wifi'
    //   11: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast android/net/wifi/WifiManager
    //   17: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull -> 93
    //   25: aload_0
    //   26: invokevirtual getMacAddress : ()Ljava/lang/String;
    //   29: ifnull -> 93
    //   32: aload_0
    //   33: invokevirtual getMacAddress : ()Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull -> 50
    //   41: aload_0
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual length : ()I
    //   47: ifne -> 56
    //   50: ldc 'wlan0'
    //   52: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull -> 87
    //   60: aload_1
    //   61: ldc ''
    //   63: if_acmpeq -> 87
    //   66: aload_1
    //   67: ldc ':'
    //   69: ldc ''
    //   71: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_0
    //   75: aload_0
    //   76: areturn
    //   77: astore_0
    //   78: ldc 'wlan0'
    //   80: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_1
    //   84: goto -> 56
    //   87: ldc ''
    //   89: astore_0
    //   90: goto -> 75
    //   93: ldc ''
    //   95: astore_0
    //   96: goto -> 37
    // Exception table:
    //   from	to	target	type
    //   8	21	77	java/lang/Exception
    //   25	37	77	java/lang/Exception
    //   43	50	77	java/lang/Exception
    //   50	56	77	java/lang/Exception
  }
  
  public static String d() {
    return (a.I + "*" + a.t).trim();
  }
  
  public static String d(Context paramContext) {
    String str1;
    try {
      boolean bool;
      File file = new File();
      this("/system/bin/su");
      if (file.exists()) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        str1 = c(paramContext);
      } else {
        str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      } 
    } catch (Exception exception) {
      str1 = "";
    } 
    if (str1 != null) {
      String str = str1;
      if (str1.length() == 0) {
        str = PreferenceUtils.a(paramContext);
        k.a("uppay", "user=" + str);
        return str;
      } 
      k.a("uppay", "user=" + str);
      return str;
    } 
    String str2 = PreferenceUtils.a(paramContext);
    k.a("uppay", "user=" + str2);
    return str2;
  }
  
  public static String e() {
    String str;
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      Object object = clazz.newInstance();
      str = (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(object, new Object[] { "gsm.version.baseband", "no message" });
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String e(Context paramContext) {
    String str;
    try {
      String str1 = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      str = str1;
      if (str1 == null)
        str = ""; 
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String f() {
    return TimeZone.getDefault().getDisplayName(false, 0);
  }
  
  public static String f(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo == null) ? "disConnect" : (networkInfo.isAvailable() ? ((networkInfo.getType() == 0) ? ((networkInfo.getState() == NetworkInfo.State.CONNECTED) ? ("mobile:" + networkInfo.getExtraInfo()) : "mobile") : ((networkInfo.getType() == 1) ? "wifi" : "other")) : "disConnect");
  }
  
  public static Location g(Context paramContext) {
    LocationManager locationManager = (LocationManager)paramContext.getSystemService("location");
    try {
      if (locationManager.isProviderEnabled("gps")) {
        Location location = locationManager.getLastKnownLocation("gps");
        if (location == null)
          try {
            if (locationManager.isProviderEnabled("network")) {
              Location location1 = locationManager.getLastKnownLocation("network");
              location = location1;
            } 
          } catch (Exception exception) {} 
        return location;
      } 
      if (exception.isProviderEnabled("network"))
        return exception.getLastKnownLocation("network"); 
    } catch (Exception null) {
      return null;
    } 
    return null;
  }
  
  public static String h(Context paramContext) {
    String str;
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    try {
      str = telephonyManager.getLine1Number();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */