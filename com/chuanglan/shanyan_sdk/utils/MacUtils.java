package com.chuanglan.shanyan_sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class MacUtils {
  private static String a() {
    String str = "02:00:00:00:00:00";
    try {
      BufferedReader bufferedReader = new BufferedReader();
      FileReader fileReader = new FileReader();
      File file = new File();
      this("/sys/class/net/wlan0/address");
      this(file);
      this(fileReader);
      String str1 = bufferedReader.readLine();
      str = str1;
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return str;
  }
  
  @SuppressLint({"MissingPermission"})
  private static String a(Context paramContext) {
    if (paramContext == null)
      return "02:00:00:00:00:00"; 
    WifiManager wifiManager = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (wifiManager == null)
      return "02:00:00:00:00:00"; 
    try {
      WifiInfo wifiInfo = wifiManager.getConnectionInfo();
      if (wifiInfo == null)
        return null; 
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
      if (exception == null)
        return null; 
    } 
    String str2 = wifiManager.getMacAddress();
    String str1 = str2;
    if (AppStringUtils.isNotEmpty(str2))
      str1 = str2.toUpperCase(Locale.ENGLISH); 
    return str1;
  }
  
  private static String b() {
    // Byte code:
    //   0: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   3: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_0
    //   12: aload_0
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 135
    //   21: aload_0
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast java/net/NetworkInterface
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual getName : ()Ljava/lang/String;
    //   35: ldc 'wlan0'
    //   37: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   40: ifeq -> 12
    //   43: aload_1
    //   44: invokevirtual getHardwareAddress : ()[B
    //   47: astore_0
    //   48: aload_0
    //   49: ifnonnull -> 57
    //   52: ldc ''
    //   54: astore_1
    //   55: aload_1
    //   56: areturn
    //   57: new java/lang/StringBuilder
    //   60: astore_1
    //   61: aload_1
    //   62: invokespecial <init> : ()V
    //   65: aload_0
    //   66: arraylength
    //   67: istore_2
    //   68: iconst_0
    //   69: istore_3
    //   70: iload_3
    //   71: iload_2
    //   72: if_icmpge -> 104
    //   75: aload_1
    //   76: ldc '%02X:'
    //   78: iconst_1
    //   79: anewarray java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: iload_3
    //   86: baload
    //   87: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   90: aastore
    //   91: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: iinc #3, 1
    //   101: goto -> 70
    //   104: aload_1
    //   105: invokevirtual length : ()I
    //   108: ifle -> 122
    //   111: aload_1
    //   112: aload_1
    //   113: invokevirtual length : ()I
    //   116: iconst_1
    //   117: isub
    //   118: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: astore_1
    //   127: goto -> 55
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual printStackTrace : ()V
    //   135: ldc '02:00:00:00:00:00'
    //   137: astore_1
    //   138: goto -> 55
    // Exception table:
    //   from	to	target	type
    //   0	12	130	java/lang/Exception
    //   12	48	130	java/lang/Exception
    //   57	68	130	java/lang/Exception
    //   75	98	130	java/lang/Exception
    //   104	122	130	java/lang/Exception
    //   122	127	130	java/lang/Exception
  }
  
  public static String getMac(Context paramContext) {
    String str1;
    String str2 = "02:00:00:00:00:00";
    try {
      if (Build.VERSION.SDK_INT < 23)
        return a(paramContext); 
      if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 24)
        return a(); 
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 24)
        str1 = b(); 
    } catch (Exception exception) {
      str1 = str2;
    } 
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\MacUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */