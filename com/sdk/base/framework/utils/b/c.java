package com.sdk.base.framework.utils.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.sdk.base.framework.utils.k.a;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class c {
  private static String a() {
    Exception exception1 = null;
    try {
      byte[] arrayOfByte = NetworkInterface.getByInetAddress(b()).getHardwareAddress();
      StringBuffer stringBuffer = new StringBuffer();
      this();
      for (byte b = 0; b < arrayOfByte.length; b++) {
        if (b != 0)
          stringBuffer.append(':'); 
        String str1 = Integer.toHexString(arrayOfByte[b] & 0xFF);
        String str2 = str1;
        if (str1.length() == 1) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          str2 = stringBuilder.append(0).append(str1).toString();
        } 
        stringBuffer.append(str2);
      } 
      String str = stringBuffer.toString().toUpperCase();
    } catch (Exception exception2) {
      exception2 = exception1;
    } 
    return (String)exception2;
  }
  
  public static String a(Context paramContext) {
    return (Build.VERSION.SDK_INT < 23) ? b(paramContext) : ((Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT >= 23) ? c(paramContext) : ((Build.VERSION.SDK_INT >= 24) ? (a.b(a()).booleanValue() ? a() : (a.b(c()).booleanValue() ? c() : d())) : "02:00:00:00:00:00"));
  }
  
  private static String a(Reader paramReader) {
    StringBuilder stringBuilder = new StringBuilder();
    char[] arrayOfChar = new char[4096];
    try {
      for (int i = paramReader.read(arrayOfChar); i >= 0; i = paramReader.read(arrayOfChar))
        stringBuilder.append(arrayOfChar, 0, i); 
    } catch (IOException iOException) {}
    return stringBuilder.toString();
  }
  
  private static String a(String paramString) {
    String str1;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = str4;
    String str6 = str2;
    String str7 = str3;
    try {
      FileReader fileReader = new FileReader();
      str5 = str4;
      str6 = str2;
      str7 = str3;
      this(paramString);
      str5 = str4;
      str6 = str2;
      str7 = str3;
      paramString = a(fileReader);
      str5 = paramString;
      str6 = paramString;
      str7 = paramString;
      fileReader.close();
    } catch (FileNotFoundException fileNotFoundException) {
      str1 = str7;
    } catch (IOException iOException) {
      str1 = str6;
    } catch (Exception exception) {
      str1 = str5;
    } 
    return str1;
  }
  
  private static String a(String paramString1, String paramString2) {
    String str = "";
    try {
      Process process = Runtime.getRuntime().exec(paramString1);
      InputStreamReader inputStreamReader = new InputStreamReader();
      this(process.getInputStream());
      BufferedReader bufferedReader = new BufferedReader();
      this(inputStreamReader);
      String str1 = "";
      try {
        while (true) {
          String str2 = bufferedReader.readLine();
          str = str2;
          if (str2 != null) {
            str = str2;
            if (!str2.contains(paramString2)) {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              String str3 = stringBuilder.append(str1).append(str2).toString();
              str1 = str3;
              continue;
            } 
          } 
          break;
        } 
      } catch (Exception exception) {
        str = str1;
      } 
    } catch (Exception exception) {}
    return str;
  }
  
  private static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramArrayOfbyte.length;
    for (byte b = 0; b < i; b++) {
      stringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfbyte[b]) }));
    } 
    if (stringBuilder.length() > 0)
      stringBuilder.deleteCharAt(stringBuilder.length() - 1); 
    return stringBuilder.toString();
  }
  
  private static String b(Context paramContext) {
    return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
  }
  
  private static InetAddress b() {
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
      socketException = null;
      while (true) {
        SocketException socketException1 = socketException;
        try {
          if (enumeration.hasMoreElements()) {
            socketException1 = socketException;
            Enumeration<InetAddress> enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
            while (true) {
              socketException1 = socketException;
              socketException = null;
            } 
            break;
          } 
          continue;
        } catch (SocketException socketException2) {
          socketException2 = socketException1;
          continue;
        } 
      } 
    } catch (SocketException socketException) {
      socketException = null;
    } 
    return (InetAddress)socketException;
  }
  
  private static String c() {
    String str = null;
    try {
      Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
    } catch (SocketException socketException) {
      socketException = null;
    } 
    if (socketException != null) {
      str = null;
      while (true) {
        if (socketException.hasMoreElements()) {
          NetworkInterface networkInterface = socketException.nextElement();
          try {
            String str1 = a(networkInterface.getHardwareAddress());
            str = str1;
            if (str != null)
              return str; 
          } catch (SocketException socketException1) {}
          continue;
        } 
        return str;
      } 
    } 
    return str;
  }
  
  private static String c(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmpge -> 25
    //   8: aload_0
    //   9: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   12: astore_1
    //   13: aload_1
    //   14: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   17: invokevirtual booleanValue : ()Z
    //   20: ifeq -> 25
    //   23: aload_1
    //   24: areturn
    //   25: ldc ''
    //   27: astore_1
    //   28: ldc ''
    //   30: astore_2
    //   31: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   34: ldc 'cat /sys/class/net/wlan0/address'
    //   36: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   39: astore_3
    //   40: new java/io/InputStreamReader
    //   43: astore_0
    //   44: aload_0
    //   45: aload_3
    //   46: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   49: invokespecial <init> : (Ljava/io/InputStream;)V
    //   52: new java/io/LineNumberReader
    //   55: astore_3
    //   56: aload_3
    //   57: aload_0
    //   58: invokespecial <init> : (Ljava/io/Reader;)V
    //   61: aload_2
    //   62: astore_0
    //   63: aload_1
    //   64: ifnull -> 83
    //   67: aload_3
    //   68: invokevirtual readLine : ()Ljava/lang/String;
    //   71: astore_0
    //   72: aload_0
    //   73: astore_1
    //   74: aload_0
    //   75: ifnull -> 61
    //   78: aload_0
    //   79: invokevirtual trim : ()Ljava/lang/String;
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull -> 98
    //   87: aload_0
    //   88: astore_1
    //   89: ldc ''
    //   91: aload_0
    //   92: invokevirtual equals : (Ljava/lang/Object;)Z
    //   95: ifeq -> 23
    //   98: ldc '/sys/class/net/eth0/address'
    //   100: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   110: invokevirtual booleanValue : ()Z
    //   113: ifeq -> 23
    //   116: aload_2
    //   117: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   120: iconst_0
    //   121: bipush #17
    //   123: invokevirtual substring : (II)Ljava/lang/String;
    //   126: astore_1
    //   127: goto -> 23
    //   130: astore_0
    //   131: aload_2
    //   132: astore_0
    //   133: goto -> 83
    // Exception table:
    //   from	to	target	type
    //   31	61	130	java/lang/Exception
    //   67	72	130	java/lang/Exception
    //   78	83	130	java/lang/Exception
  }
  
  private static String d() {
    String str1 = a("busybox ifconfig", "HWaddr");
    if (str1 == null)
      return ""; 
    String str2 = str1;
    if (str1.length() > 0) {
      str2 = str1;
      if (str1.contains("HWaddr") == true)
        str2 = str1.substring(str1.indexOf("HWaddr") + 6, str1.length() - 1); 
    } 
    return str2;
  }
  
  private static String d(Context paramContext) {
    if (e(paramContext)) {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      try {
        return wifiManager.getConnectionInfo().getMacAddress();
      } catch (Exception exception) {}
    } 
    return "";
  }
  
  private static boolean e(Context paramContext) {
    return (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */