package com.xy.whf.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.ut.device.UTDevice;
import com.xy.whf.helper.PermissionHelper;
import com.xy.whf.helper.e;
import org.json.JSONObject;

public class a {
  public static int a() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: iconst_5
    //   3: anewarray java/lang/String
    //   6: astore_1
    //   7: aload_1
    //   8: iconst_0
    //   9: ldc '/system/bin/'
    //   11: aastore
    //   12: aload_1
    //   13: iconst_1
    //   14: ldc '/system/xbin/'
    //   16: aastore
    //   17: aload_1
    //   18: iconst_2
    //   19: ldc '/system/sbin/'
    //   21: aastore
    //   22: aload_1
    //   23: iconst_3
    //   24: ldc '/sbin/'
    //   26: aastore
    //   27: aload_1
    //   28: iconst_4
    //   29: ldc '/vendor/bin/'
    //   31: aastore
    //   32: aload_1
    //   33: arraylength
    //   34: istore_2
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: iload_2
    //   39: if_icmpge -> 111
    //   42: aload_1
    //   43: iload_3
    //   44: aaload
    //   45: astore #4
    //   47: new java/io/File
    //   50: astore #5
    //   52: new java/lang/StringBuilder
    //   55: astore #6
    //   57: aload #6
    //   59: invokespecial <init> : ()V
    //   62: aload #5
    //   64: aload #6
    //   66: aload #4
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 'su'
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: invokespecial <init> : (Ljava/lang/String;)V
    //   82: aload #5
    //   84: invokevirtual exists : ()Z
    //   87: istore #7
    //   89: iload #7
    //   91: ifeq -> 98
    //   94: iload_0
    //   95: istore_3
    //   96: iload_3
    //   97: ireturn
    //   98: iinc #3, 1
    //   101: goto -> 37
    //   104: astore #4
    //   106: aload #4
    //   108: invokevirtual printStackTrace : ()V
    //   111: iconst_0
    //   112: istore_3
    //   113: goto -> 96
    // Exception table:
    //   from	to	target	type
    //   32	35	104	java/lang/Exception
    //   47	89	104	java/lang/Exception
  }
  
  public static JSONObject a(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    e.a(paramContext);
    try {
      jSONObject.put("device_id", d(paramContext));
      jSONObject.put("device_name", Build.PRODUCT);
      jSONObject.put("os_version", Build.VERSION.RELEASE);
      jSONObject.put("mac", c(paramContext));
      jSONObject.put("pixel", e.c(paramContext));
      jSONObject.put("system", "ANDROID");
      jSONObject.put("crack_type", a());
      jSONObject.put("brand", Build.BRAND);
      jSONObject.put("manufacturer", Build.MANUFACTURER);
      jSONObject.put("model", Build.MODEL);
      jSONObject.put("zmid", UTDevice.getUtdid(paramContext));
      jSONObject.put("imei", b(paramContext));
      jSONObject.put("is_simulated_position", e(paramContext));
      jSONObject.put("is_mobile_phone", f(paramContext));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONObject;
  }
  
  private static String b() {
    // Byte code:
    //   0: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   3: astore_0
    //   4: aload_0
    //   5: invokeinterface hasMoreElements : ()Z
    //   10: ifeq -> 135
    //   13: aload_0
    //   14: invokeinterface nextElement : ()Ljava/lang/Object;
    //   19: checkcast java/net/NetworkInterface
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual getHardwareAddress : ()[B
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull -> 4
    //   32: aload_2
    //   33: arraylength
    //   34: ifeq -> 4
    //   37: new java/lang/StringBuilder
    //   40: astore_3
    //   41: aload_3
    //   42: invokespecial <init> : ()V
    //   45: aload_2
    //   46: arraylength
    //   47: istore #4
    //   49: iconst_0
    //   50: istore #5
    //   52: iload #5
    //   54: iload #4
    //   56: if_icmpge -> 89
    //   59: aload_3
    //   60: ldc '%02X:'
    //   62: iconst_1
    //   63: anewarray java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_2
    //   69: iload #5
    //   71: baload
    //   72: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   75: aastore
    //   76: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: iinc #5, 1
    //   86: goto -> 52
    //   89: aload_3
    //   90: invokevirtual length : ()I
    //   93: ifle -> 107
    //   96: aload_3
    //   97: aload_3
    //   98: invokevirtual length : ()I
    //   101: iconst_1
    //   102: isub
    //   103: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: astore_2
    //   112: aload_1
    //   113: invokevirtual getName : ()Ljava/lang/String;
    //   116: ldc 'wlan0'
    //   118: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   121: istore #6
    //   123: iload #6
    //   125: ifeq -> 4
    //   128: aload_2
    //   129: areturn
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual printStackTrace : ()V
    //   135: ldc '02:00:00:00:00:00'
    //   137: astore_2
    //   138: goto -> 128
    // Exception table:
    //   from	to	target	type
    //   0	4	130	java/lang/Exception
    //   4	28	130	java/lang/Exception
    //   32	49	130	java/lang/Exception
    //   59	83	130	java/lang/Exception
    //   89	107	130	java/lang/Exception
    //   107	123	130	java/lang/Exception
  }
  
  public static String b(Context paramContext) {
    try {
      if (PermissionHelper.a(paramContext, "android.permission.READ_PHONE_STATE")) {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        return (Build.VERSION.SDK_INT > 25) ? telephonyManager.getImei() : telephonyManager.getDeviceId();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "none";
  }
  
  public static String c(Context paramContext) {
    String str1;
    String str2 = "";
    try {
      if (Build.VERSION.SDK_INT >= 23)
        return b(); 
      str1 = h(paramContext);
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = str2;
    } 
    return str1;
  }
  
  public static String d(Context paramContext) {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static int e(Context paramContext) {
    byte b1 = 0;
    byte b2 = 1;
    byte b3 = b1;
    if (Build.VERSION.SDK_INT > 22) {
      LocationManager locationManager = (LocationManager)paramContext.getSystemService("location");
      if (locationManager != null) {
        try {
          LocationProvider locationProvider = locationManager.getProvider("gps");
          if (locationProvider != null) {
            locationManager.addTestProvider(locationProvider.getName(), locationProvider.requiresNetwork(), locationProvider.requiresSatellite(), locationProvider.requiresCell(), locationProvider.hasMonetaryCost(), locationProvider.supportsAltitude(), locationProvider.supportsSpeed(), locationProvider.supportsBearing(), locationProvider.getPowerRequirement(), locationProvider.getAccuracy());
          } else {
            locationManager.addTestProvider("gps", true, true, false, false, true, true, true, 3, 1);
          } 
          locationManager.setTestProviderEnabled("gps", true);
          locationManager.setTestProviderStatus("gps", 2, null, System.currentTimeMillis());
          b3 = 1;
          if (b3)
            return b2; 
        } catch (SecurityException securityException) {
          b3 = b1;
          if (b3)
            return b2; 
        } 
      } else {
        if (Settings.Secure.getInt(securityException.getContentResolver(), "mock_location", 0) != 0) {
          b3 = 1;
        } else {
          b3 = 0;
        } 
        if (b3)
          return b2; 
      } 
      return 2;
    } 
    if (b3 != 0)
      return b2; 
  }
  
  public static int f(Context paramContext) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic android/os/Build.FINGERPRINT : Ljava/lang/String;
    //   5: ldc_w 'generic'
    //   8: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   11: ifne -> 175
    //   14: getstatic android/os/Build.FINGERPRINT : Ljava/lang/String;
    //   17: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   20: ldc_w 'vbox'
    //   23: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   26: ifne -> 175
    //   29: getstatic android/os/Build.FINGERPRINT : Ljava/lang/String;
    //   32: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   35: ldc_w 'test-keys'
    //   38: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   41: ifne -> 175
    //   44: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   47: ldc_w 'google_sdk'
    //   50: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   53: ifne -> 175
    //   56: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   59: ldc_w 'Emulator'
    //   62: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   65: ifne -> 175
    //   68: ldc_w 'unknown'
    //   71: getstatic android/os/Build.SERIAL : Ljava/lang/String;
    //   74: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   77: ifne -> 175
    //   80: ldc_w 'android'
    //   83: getstatic android/os/Build.SERIAL : Ljava/lang/String;
    //   86: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   89: ifne -> 175
    //   92: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   95: ldc_w 'Android SDK built for x86'
    //   98: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   101: ifne -> 175
    //   104: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   107: ldc_w 'Genymotion'
    //   110: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   113: ifne -> 175
    //   116: getstatic android/os/Build.BRAND : Ljava/lang/String;
    //   119: ldc_w 'generic'
    //   122: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   125: ifeq -> 140
    //   128: getstatic android/os/Build.DEVICE : Ljava/lang/String;
    //   131: ldc_w 'generic'
    //   134: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   137: ifne -> 175
    //   140: ldc_w 'google_sdk'
    //   143: getstatic android/os/Build.PRODUCT : Ljava/lang/String;
    //   146: invokevirtual equals : (Ljava/lang/Object;)Z
    //   149: ifne -> 175
    //   152: ldc_w 'android'
    //   155: aload_0
    //   156: ldc 'phone'
    //   158: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   161: checkcast android/telephony/TelephonyManager
    //   164: invokevirtual getNetworkOperatorName : ()Ljava/lang/String;
    //   167: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   170: istore_2
    //   171: iload_2
    //   172: ifeq -> 185
    //   175: iconst_1
    //   176: istore_3
    //   177: iload_3
    //   178: ifeq -> 200
    //   181: iload_1
    //   182: istore_3
    //   183: iload_3
    //   184: ireturn
    //   185: iconst_0
    //   186: istore_3
    //   187: goto -> 177
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual printStackTrace : ()V
    //   195: iconst_0
    //   196: istore_3
    //   197: goto -> 177
    //   200: iconst_2
    //   201: istore_3
    //   202: goto -> 183
    // Exception table:
    //   from	to	target	type
    //   2	140	190	java/lang/Exception
    //   140	171	190	java/lang/Exception
  }
  
  public static String g(Context paramContext) {
    return UTDevice.getUtdid(paramContext);
  }
  
  @SuppressLint({"HardwareIds"})
  private static String h(Context paramContext) {
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (PermissionHelper.a(paramContext, "android.permission.ACCESS_WIFI_STATE") && wifiManager != null && wifiManager.getConnectionInfo() != null && wifiManager.getConnectionInfo().getMacAddress() != null)
        return wifiManager.getConnectionInfo().getMacAddress(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */