package com.unionpay.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import java.net.NetworkInterface;

public final class e {
  public static String a() {
    Object object;
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      object = clazz.newInstance();
      object = clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(object, new Object[] { "gsm.version.baseband", "no message" });
    } catch (Exception exception) {
      object = "";
    } 
    return (String)object;
  }
  
  public static final String a(Context paramContext) {
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
  
  @SuppressLint({"NewApi"})
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
  
  public static String b(Context paramContext) {
    String str;
    try {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String c(Context paramContext) {
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
  
  public static Location d(Context paramContext) {
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
  
  public static String e(Context paramContext) {
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */