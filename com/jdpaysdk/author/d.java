package com.jdpaysdk.author;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.jdpaysdk.author.c.b;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class d {
  public static final String a = e();
  
  public static Context b;
  
  public static int c;
  
  public static int d;
  
  public static int e;
  
  public static String f = null;
  
  public static String g = Build.PRODUCT;
  
  public static String a() {
    String str;
    try {
      str = ((TelephonyManager)b.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static void a(Application paramApplication) {
    if (b == null)
      b = paramApplication.getApplicationContext(); 
  }
  
  public static String b() {
    return Build.VERSION.RELEASE;
  }
  
  public static String c() {
    return b.getPackageName();
  }
  
  public static String d() {
    String str = "";
    try {
      String str1 = (b.getPackageManager().getPackageInfo(c(), 0)).versionName;
      str = str1;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return str;
  }
  
  private static String e() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      while (enumeration.hasMoreElements()) {
        Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        while (enumeration1.hasMoreElements()) {
          InetAddress inetAddress = enumeration1.nextElement();
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
            return inetAddress.getHostAddress(); 
        } 
      } 
    } catch (SocketException socketException) {
      System.err.print("error");
    } catch (Exception exception) {
      b.a(b.f, exception.getMessage());
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */