package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class NetworkHelper {
  public static void clearCookies(Context paramContext) {
    CookieSyncManager.createInstance(paramContext);
    CookieManager.getInstance().removeAllCookie();
    CookieSyncManager.getInstance().sync();
  }
  
  public static String generateUA(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Android");
    stringBuilder.append("__");
    stringBuilder.append("weibo");
    stringBuilder.append("__");
    stringBuilder.append("sdk");
    stringBuilder.append("__");
    try {
      stringBuilder.append((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16)).versionName.replaceAll("\\s+", "_"));
    } catch (Exception exception) {
      stringBuilder.append("unknown");
    } 
    return stringBuilder.toString();
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext) {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext, int paramInt) {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(paramInt);
  }
  
  public static int getNetworkType(Context paramContext) {
    int i = -1;
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      if (networkInfo != null)
        i = networkInfo.getType(); 
      return i;
    } 
    return -1;
  }
  
  public static NetworkInfo.DetailedState getWifiConnectivityState(Context paramContext) {
    NetworkInfo.DetailedState detailedState;
    NetworkInfo networkInfo = getNetworkInfo(paramContext, 1);
    if (networkInfo == null) {
      detailedState = NetworkInfo.DetailedState.FAILED;
    } else {
      detailedState = detailedState.getDetailedState();
    } 
    return detailedState;
  }
  
  public static int getWifiState(Context paramContext) {
    WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
    return (wifiManager == null) ? 4 : wifiManager.getWifiState();
  }
  
  public static boolean hasInternetPermission(Context paramContext) {
    return (paramContext != null) ? ((paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0)) : true;
  }
  
  public static boolean isMobileNetwork(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      return (networkInfo == null) ? false : ((networkInfo != null && networkInfo.getType() == 0 && networkInfo.isConnected()));
    } 
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      return (networkInfo != null && networkInfo.isConnected());
    } 
    return false;
  }
  
  public static boolean isWifiValid(Context paramContext) {
    if (paramContext != null) {
      NetworkInfo networkInfo = getActiveNetworkInfo(paramContext);
      return (networkInfo != null && 1 == networkInfo.getType() && networkInfo.isConnected());
    } 
    return false;
  }
  
  public static boolean wifiConnection(Context paramContext, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'wifi'
    //   3: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast android/net/wifi/WifiManager
    //   9: astore_0
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: ldc '"'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: ldc '"'
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: astore_3
    //   38: aload_0
    //   39: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   42: astore #4
    //   44: iconst_1
    //   45: istore #5
    //   47: aload #4
    //   49: ifnull -> 87
    //   52: iload #5
    //   54: istore #6
    //   56: aload_1
    //   57: aload #4
    //   59: invokevirtual getSSID : ()Ljava/lang/String;
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifne -> 238
    //   68: aload_3
    //   69: aload #4
    //   71: invokevirtual getSSID : ()Ljava/lang/String;
    //   74: invokevirtual equals : (Ljava/lang/Object;)Z
    //   77: ifeq -> 87
    //   80: iload #5
    //   82: istore #6
    //   84: goto -> 238
    //   87: aload_0
    //   88: invokevirtual getScanResults : ()Ljava/util/List;
    //   91: astore #4
    //   93: aload #4
    //   95: ifnull -> 235
    //   98: aload #4
    //   100: invokeinterface size : ()I
    //   105: ifeq -> 235
    //   108: aload #4
    //   110: invokeinterface size : ()I
    //   115: iconst_1
    //   116: isub
    //   117: istore #7
    //   119: iload #7
    //   121: ifge -> 127
    //   124: goto -> 235
    //   127: aload #4
    //   129: iload #7
    //   131: invokeinterface get : (I)Ljava/lang/Object;
    //   136: checkcast android/net/wifi/ScanResult
    //   139: getfield SSID : Ljava/lang/String;
    //   142: astore #8
    //   144: aload_1
    //   145: aload #8
    //   147: invokevirtual equals : (Ljava/lang/Object;)Z
    //   150: ifne -> 171
    //   153: aload_3
    //   154: aload #8
    //   156: invokevirtual equals : (Ljava/lang/Object;)Z
    //   159: ifeq -> 165
    //   162: goto -> 171
    //   165: iinc #7, -1
    //   168: goto -> 119
    //   171: new android/net/wifi/WifiConfiguration
    //   174: dup
    //   175: invokespecial <init> : ()V
    //   178: astore_1
    //   179: aload_1
    //   180: aload_3
    //   181: putfield SSID : Ljava/lang/String;
    //   184: new java/lang/StringBuilder
    //   187: dup
    //   188: ldc '"'
    //   190: invokespecial <init> : (Ljava/lang/String;)V
    //   193: astore_3
    //   194: aload_3
    //   195: aload_2
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_3
    //   201: ldc '"'
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_1
    //   208: aload_3
    //   209: invokevirtual toString : ()Ljava/lang/String;
    //   212: putfield preSharedKey : Ljava/lang/String;
    //   215: aload_1
    //   216: iconst_2
    //   217: putfield status : I
    //   220: aload_0
    //   221: aload_0
    //   222: aload_1
    //   223: invokevirtual addNetwork : (Landroid/net/wifi/WifiConfiguration;)I
    //   226: iconst_0
    //   227: invokevirtual enableNetwork : (IZ)Z
    //   230: istore #6
    //   232: goto -> 238
    //   235: iconst_0
    //   236: istore #6
    //   238: iload #6
    //   240: ireturn
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\NetworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */