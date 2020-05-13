package com.chuanglan.shanyan_sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

public class AppSysMgr {
  private static String a() {
    String str = "";
    try {
      Iterator<NetworkInterface> iterator = Collections.<NetworkInterface>list(NetworkInterface.getNetworkInterfaces()).iterator();
      label19: while (iterator.hasNext()) {
        Iterator<InetAddress> iterator1 = Collections.<InetAddress>list(((NetworkInterface)iterator.next()).getInetAddresses()).iterator();
        String str1 = str;
        while (true) {
          str = str1;
          if (iterator1.hasNext()) {
            InetAddress inetAddress = iterator1.next();
            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address)
              str1 = inetAddress.getHostAddress(); 
            continue;
          } 
          continue label19;
        } 
      } 
    } catch (SocketException socketException) {
      str = "";
    } 
    return str;
  }
  
  private static String a(int paramInt) {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  private static String a(WifiManager paramWifiManager) {
    String str;
    try {
      WifiInfo wifiInfo = paramWifiManager.getConnectionInfo();
      if (wifiInfo != null) {
        String str1 = a(wifiInfo.getIpAddress());
        if (str1 == null)
          str1 = ""; 
        return str1;
      } 
      str = "";
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String getAppName(Context paramContext) {
    // Byte code:
    //   0: ldc com/chuanglan/shanyan_sdk/utils/AppSysMgr
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   7: aload_0
    //   8: invokevirtual getPackageName : ()Ljava/lang/String;
    //   11: iconst_0
    //   12: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   15: getfield applicationInfo : Landroid/content/pm/ApplicationInfo;
    //   18: getfield labelRes : I
    //   21: istore_1
    //   22: aload_0
    //   23: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   26: iload_1
    //   27: invokevirtual getString : (I)Ljava/lang/String;
    //   30: astore_0
    //   31: ldc com/chuanglan/shanyan_sdk/utils/AppSysMgr
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual printStackTrace : ()V
    //   41: new java/lang/StringBuilder
    //   44: astore_0
    //   45: aload_0
    //   46: invokespecial <init> : ()V
    //   49: ldc 'ExceptionLogger'
    //   51: aload_0
    //   52: ldc 'getAppName()Exception == '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual toString : ()Ljava/lang/String;
    //   67: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: astore_0
    //   72: goto -> 31
    //   75: astore_0
    //   76: ldc com/chuanglan/shanyan_sdk/utils/AppSysMgr
    //   78: monitorexit
    //   79: aload_0
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   3	31	36	java/lang/Exception
    //   3	31	75	finally
    //   37	70	75	finally
  }
  
  public static String getDevice() {
    return Build.DEVICE;
  }
  
  public static String getDisplayVersion() {
    String str;
    try {
      if (AppStringUtils.isNotEmpty(Build.DISPLAY))
        return Build.DISPLAY; 
      str = "";
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "getDisplayVersion()Exception == " + exception.toString());
      str = "";
    } 
    return str;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getIMSI(Context paramContext) {
    String str;
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null) {
        String str1 = telephonyManager.getSubscriberId();
      } else {
        paramContext = null;
      } 
      if (paramContext != null)
        return telephonyManager.getSubscriberId(); 
      str = "";
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String getIP(Context paramContext) {
    String str;
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager != null)
        return wifiManager.isWifiEnabled() ? a(wifiManager) : a(); 
      str = "";
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String getMNC(Context paramContext) {
    String str3;
    String str2 = "-2";
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    String str1 = str2;
    if (telephonyManager != null) {
      str1 = str2;
      if (telephonyManager.getSimState() == 5) {
        str1 = telephonyManager.getSimOperator();
        str2 = str1;
        if (str1 == null)
          str2 = "-1"; 
        str1 = str2;
        if (str2 != null) {
          str1 = str2;
          if (str2.equals("-1")) {
            str3 = telephonyManager.getSubscriberId();
            str1 = str2;
            if (str3 != null) {
              str1 = str2;
              if (!str3.equals("")) {
                if (str3.startsWith("46000"))
                  return "46000"; 
              } else {
                return str1;
              } 
            } else {
              return str1;
            } 
          } else {
            return str1;
          } 
        } else {
          return str1;
        } 
      } else {
        return str1;
      } 
    } else {
      return str1;
    } 
    if (str3.startsWith("46002"))
      return "46002"; 
    if (str3.startsWith("46004"))
      return "46004"; 
    if (str3.startsWith("46007"))
      return "46007"; 
    if (str3.startsWith("46001"))
      return "46001"; 
    if (str3.startsWith("46006"))
      return "46006"; 
    if (str3.startsWith("46009"))
      return "46009"; 
    if (str3.startsWith("46003"))
      return "46003"; 
    if (str3.startsWith("46005"))
      return "46005"; 
    str1 = str2;
    if (str3.startsWith("46011"))
      str1 = "46011"; 
    return str1;
  }
  
  public static String getManufacturer() {
    return Build.MANUFACTURER;
  }
  
  public static String getOperatorType(Context paramContext) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic getInstance : (Landroid/content/Context;)Lcom/cmic/sso/sdk/auth/AuthnHelper;
    //   6: aload_0
    //   7: invokevirtual getNetworkType : (Landroid/content/Context;)Lorg/json/JSONObject;
    //   10: ldc 'operatorType'
    //   12: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_2
    //   16: aload_0
    //   17: ldc 'cmccfn'
    //   19: ldc '0'
    //   21: invokestatic get : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast java/lang/String
    //   27: astore_3
    //   28: aload_2
    //   29: invokestatic isNotEmpty : (Ljava/lang/String;)Z
    //   32: ifeq -> 176
    //   35: ldc_w '1'
    //   38: aload_3
    //   39: invokevirtual contentEquals : (Ljava/lang/CharSequence;)Z
    //   42: ifeq -> 176
    //   45: aload_2
    //   46: invokevirtual hashCode : ()I
    //   49: tableswitch default -> 76, 49 -> 110, 50 -> 125, 51 -> 140
    //   76: iload_1
    //   77: tableswitch default -> 104, 0 -> 155, 1 -> 162, 2 -> 169
    //   104: ldc_w 'Unknown_Operator'
    //   107: astore_0
    //   108: aload_0
    //   109: areturn
    //   110: aload_2
    //   111: ldc_w '1'
    //   114: invokevirtual equals : (Ljava/lang/Object;)Z
    //   117: ifeq -> 76
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -> 76
    //   125: aload_2
    //   126: ldc_w '2'
    //   129: invokevirtual equals : (Ljava/lang/Object;)Z
    //   132: ifeq -> 76
    //   135: iconst_1
    //   136: istore_1
    //   137: goto -> 76
    //   140: aload_2
    //   141: ldc_w '3'
    //   144: invokevirtual equals : (Ljava/lang/Object;)Z
    //   147: ifeq -> 76
    //   150: iconst_2
    //   151: istore_1
    //   152: goto -> 76
    //   155: ldc_w 'CMCC'
    //   158: astore_0
    //   159: goto -> 108
    //   162: ldc_w 'CUCC'
    //   165: astore_0
    //   166: goto -> 108
    //   169: ldc_w 'CTCC'
    //   172: astore_0
    //   173: goto -> 108
    //   176: aload_0
    //   177: invokestatic getMNC : (Landroid/content/Context;)Ljava/lang/String;
    //   180: astore_0
    //   181: aload_0
    //   182: ifnull -> 508
    //   185: aload_0
    //   186: invokevirtual hashCode : ()I
    //   189: lookupswitch default -> 280, 49679470 -> 343, 49679471 -> 399, 49679472 -> 357, 49679473 -> 442, 49679474 -> 371, 49679475 -> 457, 49679476 -> 413, 49679477 -> 385, 49679479 -> 427, 49679502 -> 472
    //   280: iconst_m1
    //   281: istore_1
    //   282: iload_1
    //   283: tableswitch default -> 336, 0 -> 487, 1 -> 487, 2 -> 487, 3 -> 487, 4 -> 494, 5 -> 494, 6 -> 494, 7 -> 501, 8 -> 501, 9 -> 501
    //   336: ldc_w 'Unknown_Operator'
    //   339: astore_0
    //   340: goto -> 108
    //   343: aload_0
    //   344: ldc '46000'
    //   346: invokevirtual equals : (Ljava/lang/Object;)Z
    //   349: ifeq -> 280
    //   352: iconst_0
    //   353: istore_1
    //   354: goto -> 282
    //   357: aload_0
    //   358: ldc '46002'
    //   360: invokevirtual equals : (Ljava/lang/Object;)Z
    //   363: ifeq -> 280
    //   366: iconst_1
    //   367: istore_1
    //   368: goto -> 282
    //   371: aload_0
    //   372: ldc '46004'
    //   374: invokevirtual equals : (Ljava/lang/Object;)Z
    //   377: ifeq -> 280
    //   380: iconst_2
    //   381: istore_1
    //   382: goto -> 282
    //   385: aload_0
    //   386: ldc '46007'
    //   388: invokevirtual equals : (Ljava/lang/Object;)Z
    //   391: ifeq -> 280
    //   394: iconst_3
    //   395: istore_1
    //   396: goto -> 282
    //   399: aload_0
    //   400: ldc '46001'
    //   402: invokevirtual equals : (Ljava/lang/Object;)Z
    //   405: ifeq -> 280
    //   408: iconst_4
    //   409: istore_1
    //   410: goto -> 282
    //   413: aload_0
    //   414: ldc '46006'
    //   416: invokevirtual equals : (Ljava/lang/Object;)Z
    //   419: ifeq -> 280
    //   422: iconst_5
    //   423: istore_1
    //   424: goto -> 282
    //   427: aload_0
    //   428: ldc '46009'
    //   430: invokevirtual equals : (Ljava/lang/Object;)Z
    //   433: ifeq -> 280
    //   436: bipush #6
    //   438: istore_1
    //   439: goto -> 282
    //   442: aload_0
    //   443: ldc '46003'
    //   445: invokevirtual equals : (Ljava/lang/Object;)Z
    //   448: ifeq -> 280
    //   451: bipush #7
    //   453: istore_1
    //   454: goto -> 282
    //   457: aload_0
    //   458: ldc '46005'
    //   460: invokevirtual equals : (Ljava/lang/Object;)Z
    //   463: ifeq -> 280
    //   466: bipush #8
    //   468: istore_1
    //   469: goto -> 282
    //   472: aload_0
    //   473: ldc '46011'
    //   475: invokevirtual equals : (Ljava/lang/Object;)Z
    //   478: ifeq -> 280
    //   481: bipush #9
    //   483: istore_1
    //   484: goto -> 282
    //   487: ldc_w 'CMCC'
    //   490: astore_0
    //   491: goto -> 108
    //   494: ldc_w 'CUCC'
    //   497: astore_0
    //   498: goto -> 108
    //   501: ldc_w 'CTCC'
    //   504: astore_0
    //   505: goto -> 108
    //   508: ldc_w 'Unknown_Operator'
    //   511: astore_0
    //   512: goto -> 108
    //   515: astore_0
    //   516: aload_0
    //   517: invokevirtual printStackTrace : ()V
    //   520: ldc 'ExceptionLogger'
    //   522: new java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial <init> : ()V
    //   529: ldc_w 'getMNC()Exception == '
    //   532: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_0
    //   536: invokevirtual toString : ()Ljava/lang/String;
    //   539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual toString : ()Ljava/lang/String;
    //   545: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   548: ldc_w 'Unknown_Operator'
    //   551: astore_0
    //   552: goto -> 108
    // Exception table:
    //   from	to	target	type
    //   2	76	515	java/lang/Exception
    //   110	120	515	java/lang/Exception
    //   125	135	515	java/lang/Exception
    //   140	150	515	java/lang/Exception
    //   176	181	515	java/lang/Exception
    //   185	280	515	java/lang/Exception
    //   343	352	515	java/lang/Exception
    //   357	366	515	java/lang/Exception
    //   371	380	515	java/lang/Exception
    //   385	394	515	java/lang/Exception
    //   399	408	515	java/lang/Exception
    //   413	422	515	java/lang/Exception
    //   427	436	515	java/lang/Exception
    //   442	451	515	java/lang/Exception
    //   457	466	515	java/lang/Exception
    //   472	481	515	java/lang/Exception
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getSIMSerial(Context paramContext) {
    String str;
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager != null) {
        String str1 = telephonyManager.getSimSerialNumber();
      } else {
        paramContext = null;
      } 
      if (paramContext != null)
        return telephonyManager.getSimSerialNumber(); 
      str = "1";
    } catch (Exception exception) {
      L.d("ExceptionLogger", "getSIMSerial()Exception == " + exception.toString());
      str = "1";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AppSysMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */