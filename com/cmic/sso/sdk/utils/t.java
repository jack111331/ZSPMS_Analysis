package com.cmic.sso.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;

public class t {
  public static String a() {
    return Build.ID;
  }
  
  public static String a(double paramDouble1, double paramDouble2, Context paramContext) {
    Geocoder geocoder = new Geocoder(paramContext, Locale.getDefault());
    try {
      List<Address> list = geocoder.getFromLocation(paramDouble1, paramDouble2, 1);
      if (list.size() > 0) {
        null = ((Address)list.get(0)).toString();
        int i = null.indexOf("0:\"") + "0:\"".length();
        return null.substring(i, null.indexOf("\"", i));
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return "获取失败";
  }
  
  private static String a(int paramInt) {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static String a(Context paramContext) {
    String str;
    try {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String b(Context paramContext) {
    return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getSSID();
  }
  
  public static String c(Context paramContext) {
    if (!m.a(paramContext, "android.permission.ACCESS_FINE_LOCATION") || !m.a(paramContext, "android.permission.ACCESS_COARSE_LOCATION"))
      return ""; 
    Location location = ((LocationManager)paramContext.getSystemService("location")).getLastKnownLocation("gps");
    return (location == null) ? "" : a(location.getLatitude(), location.getLongitude(), paramContext);
  }
  
  public static String d(Context paramContext) {
    WifiManager wifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (wifiManager == null || !wifiManager.isWifiEnabled())
      return ""; 
    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
    h.a("SimCollection", "getWifiIp() wi=" + wifiInfo);
    if (wifiInfo == null)
      return ""; 
    int i = wifiInfo.getIpAddress();
    h.a("SimCollection", "getWifiIp() ipAdd=" + i);
    if (i == 0)
      return ""; 
    String str = a(i);
    h.a("SimCollection", "getWifiIp() ip=" + str);
    if (str != null) {
      String str1 = str;
      return str.startsWith("0") ? "" : str1;
    } 
    return "";
  }
  
  @SuppressLint({"HardwareIds"})
  public static String e(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmpge -> 74
    //   8: aload_0
    //   9: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   12: ldc 'wifi'
    //   14: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast android/net/wifi/WifiManager
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull -> 30
    //   25: ldc ''
    //   27: astore_0
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual getMacAddress : ()Ljava/lang/String;
    //   39: astore_1
    //   40: aload_0
    //   41: ifnull -> 51
    //   44: aload_1
    //   45: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   48: ifeq -> 57
    //   51: ldc ''
    //   53: astore_0
    //   54: goto -> 28
    //   57: aload_1
    //   58: astore_0
    //   59: ldc '02:00:00:00:00:00'
    //   61: aload_1
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifeq -> 28
    //   68: ldc ''
    //   70: astore_0
    //   71: goto -> 28
    //   74: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   77: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   80: invokeinterface iterator : ()Ljava/util/Iterator;
    //   85: astore_0
    //   86: aload_0
    //   87: invokeinterface hasNext : ()Z
    //   92: ifeq -> 210
    //   95: aload_0
    //   96: invokeinterface next : ()Ljava/lang/Object;
    //   101: checkcast java/net/NetworkInterface
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual getName : ()Ljava/lang/String;
    //   109: ldc 'wlan0'
    //   111: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   114: ifeq -> 86
    //   117: aload_1
    //   118: invokevirtual getHardwareAddress : ()[B
    //   121: astore_1
    //   122: aload_1
    //   123: ifnonnull -> 132
    //   126: ldc ''
    //   128: astore_0
    //   129: goto -> 28
    //   132: new java/lang/StringBuilder
    //   135: astore_0
    //   136: aload_0
    //   137: invokespecial <init> : ()V
    //   140: aload_1
    //   141: arraylength
    //   142: istore_2
    //   143: iconst_0
    //   144: istore_3
    //   145: iload_3
    //   146: iload_2
    //   147: if_icmpge -> 179
    //   150: aload_0
    //   151: ldc '%02X:'
    //   153: iconst_1
    //   154: anewarray java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: iload_3
    //   161: baload
    //   162: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   165: aastore
    //   166: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: iinc #3, 1
    //   176: goto -> 145
    //   179: aload_0
    //   180: invokevirtual length : ()I
    //   183: ifle -> 197
    //   186: aload_0
    //   187: aload_0
    //   188: invokevirtual length : ()I
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_0
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: astore_0
    //   202: goto -> 28
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual printStackTrace : ()V
    //   210: ldc ''
    //   212: astore_0
    //   213: goto -> 28
    // Exception table:
    //   from	to	target	type
    //   0	21	205	java/lang/Exception
    //   30	40	205	java/lang/Exception
    //   44	51	205	java/lang/Exception
    //   59	68	205	java/lang/Exception
    //   74	86	205	java/lang/Exception
    //   86	122	205	java/lang/Exception
    //   132	143	205	java/lang/Exception
    //   150	173	205	java/lang/Exception
    //   179	197	205	java/lang/Exception
    //   197	202	205	java/lang/Exception
  }
  
  @SuppressLint({"MissingPermission"})
  public static String f(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (Build.VERSION.SDK_INT >= 23) {
      String str;
      try {
        str = telephonyManager.getDeviceId(1);
      } catch (Exception exception) {
        str = "";
        exception.printStackTrace();
      } 
      return str;
    } 
    return "";
  }
  
  @SuppressLint({"MissingPermission"})
  public static String g(Context paramContext) {
    try {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
    } catch (Exception exception) {
      h.d("SimCollection", "getIccid() failed...");
      exception = null;
    } 
    return (String)exception;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String h(Context paramContext) {
    String str;
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    try {
      str = (String)Class.forName("android.telephony.TelephonyManager").getMethod("getSimSerialNumber", new Class[] { int.class }).invoke(telephonyManager, new Object[] { Integer.valueOf(1) });
    } catch (ClassNotFoundException classNotFoundException) {
      h.a("SimCollection", "subiccId reflect error");
      classNotFoundException.printStackTrace();
      str = "";
    } catch (NoSuchMethodException noSuchMethodException) {
      h.a("SimCollection", "subiccId reflect error");
      noSuchMethodException.printStackTrace();
      str = "";
    } catch (IllegalAccessException illegalAccessException) {
      h.a("SimCollection", "subiccId reflect error");
      illegalAccessException.printStackTrace();
      str = "";
    } catch (InvocationTargetException invocationTargetException) {
      h.a("SimCollection", "subiccId reflect error");
      invocationTargetException.printStackTrace();
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */