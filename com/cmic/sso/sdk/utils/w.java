package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;

public class w {
  public static int a(Context paramContext) {
    // Byte code:
    //   0: invokestatic a : ()Lcom/cmic/sso/sdk/a/b;
    //   3: aload_0
    //   4: invokevirtual a : (Landroid/content/Context;)Lcom/cmic/sso/sdk/a/b$b;
    //   7: astore_1
    //   8: aload_1
    //   9: aload_1
    //   10: invokevirtual f : ()I
    //   13: invokevirtual h : (I)Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_2
    //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   23: ifeq -> 427
    //   26: aload_0
    //   27: ldc 'phone'
    //   29: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast android/telephony/TelephonyManager
    //   35: invokevirtual getSimOperator : ()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   45: ifeq -> 427
    //   48: aload_0
    //   49: invokestatic a : (Landroid/content/Context;)Lcom/cmic/sso/sdk/utils/q;
    //   52: invokevirtual a : ()Ljava/lang/String;
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: ifne -> 427
    //   65: aload_0
    //   66: iconst_0
    //   67: iconst_5
    //   68: invokevirtual substring : (II)Ljava/lang/String;
    //   71: astore_0
    //   72: aload_0
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifne -> 232
    //   79: iconst_m1
    //   80: istore_3
    //   81: aload_0
    //   82: invokevirtual hashCode : ()I
    //   85: lookupswitch default -> 176, 49679470 -> 236, 49679471 -> 292, 49679472 -> 250, 49679473 -> 335, 49679474 -> 278, 49679475 -> 350, 49679476 -> 306, 49679477 -> 264, 49679479 -> 320, 49679502 -> 365
    //   176: iload_3
    //   177: tableswitch default -> 232, 0 -> 380, 1 -> 380, 2 -> 380, 3 -> 380, 4 -> 392, 5 -> 392, 6 -> 392, 7 -> 404, 8 -> 404, 9 -> 404
    //   232: iconst_0
    //   233: istore_3
    //   234: iload_3
    //   235: ireturn
    //   236: aload_0
    //   237: ldc '46000'
    //   239: invokevirtual equals : (Ljava/lang/Object;)Z
    //   242: ifeq -> 176
    //   245: iconst_0
    //   246: istore_3
    //   247: goto -> 176
    //   250: aload_0
    //   251: ldc '46002'
    //   253: invokevirtual equals : (Ljava/lang/Object;)Z
    //   256: ifeq -> 176
    //   259: iconst_1
    //   260: istore_3
    //   261: goto -> 176
    //   264: aload_0
    //   265: ldc '46007'
    //   267: invokevirtual equals : (Ljava/lang/Object;)Z
    //   270: ifeq -> 176
    //   273: iconst_2
    //   274: istore_3
    //   275: goto -> 176
    //   278: aload_0
    //   279: ldc '46004'
    //   281: invokevirtual equals : (Ljava/lang/Object;)Z
    //   284: ifeq -> 176
    //   287: iconst_3
    //   288: istore_3
    //   289: goto -> 176
    //   292: aload_0
    //   293: ldc '46001'
    //   295: invokevirtual equals : (Ljava/lang/Object;)Z
    //   298: ifeq -> 176
    //   301: iconst_4
    //   302: istore_3
    //   303: goto -> 176
    //   306: aload_0
    //   307: ldc '46006'
    //   309: invokevirtual equals : (Ljava/lang/Object;)Z
    //   312: ifeq -> 176
    //   315: iconst_5
    //   316: istore_3
    //   317: goto -> 176
    //   320: aload_0
    //   321: ldc '46009'
    //   323: invokevirtual equals : (Ljava/lang/Object;)Z
    //   326: ifeq -> 176
    //   329: bipush #6
    //   331: istore_3
    //   332: goto -> 176
    //   335: aload_0
    //   336: ldc '46003'
    //   338: invokevirtual equals : (Ljava/lang/Object;)Z
    //   341: ifeq -> 176
    //   344: bipush #7
    //   346: istore_3
    //   347: goto -> 176
    //   350: aload_0
    //   351: ldc '46005'
    //   353: invokevirtual equals : (Ljava/lang/Object;)Z
    //   356: ifeq -> 176
    //   359: bipush #8
    //   361: istore_3
    //   362: goto -> 176
    //   365: aload_0
    //   366: ldc '46011'
    //   368: invokevirtual equals : (Ljava/lang/Object;)Z
    //   371: ifeq -> 176
    //   374: bipush #9
    //   376: istore_3
    //   377: goto -> 176
    //   380: ldc 'TelephonyUtils'
    //   382: ldc '中国移动'
    //   384: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   387: iconst_1
    //   388: istore_3
    //   389: goto -> 234
    //   392: ldc 'TelephonyUtils'
    //   394: ldc '中国联通'
    //   396: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   399: iconst_2
    //   400: istore_3
    //   401: goto -> 234
    //   404: ldc 'TelephonyUtils'
    //   406: ldc '中国电信'
    //   408: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   411: iconst_3
    //   412: istore_3
    //   413: goto -> 234
    //   416: astore_0
    //   417: ldc 'TelephonyUtils'
    //   419: ldc '获取运营商信息异常'
    //   421: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   424: goto -> 232
    //   427: aload_1
    //   428: astore_0
    //   429: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   0	17	416	java/lang/Exception
    //   19	39	416	java/lang/Exception
    //   41	56	416	java/lang/Exception
    //   58	72	416	java/lang/Exception
    //   72	79	416	java/lang/Exception
    //   81	176	416	java/lang/Exception
    //   236	245	416	java/lang/Exception
    //   250	259	416	java/lang/Exception
    //   264	273	416	java/lang/Exception
    //   278	287	416	java/lang/Exception
    //   292	301	416	java/lang/Exception
    //   306	315	416	java/lang/Exception
    //   320	329	416	java/lang/Exception
    //   335	344	416	java/lang/Exception
    //   350	359	416	java/lang/Exception
    //   365	374	416	java/lang/Exception
    //   380	387	416	java/lang/Exception
    //   392	399	416	java/lang/Exception
    //   404	411	416	java/lang/Exception
  }
  
  public static String a() {
    return Build.BRAND;
  }
  
  public static boolean a(Context paramContext, ConnectivityManager paramConnectivityManager) {
    boolean bool;
    try {
      if (TextUtils.isEmpty(q.a(paramContext).a()))
        return false; 
      Method method = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      method.setAccessible(true);
      bool = ((Boolean)method.invoke(paramConnectivityManager, new Object[0])).booleanValue();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      h.b("TelephonyUtils", stringBuilder.append("data is on ---------").append(bool).toString());
    } catch (Exception exception) {
      h.a("TelephonyUtils", "data is on ----反射出错-----");
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  public static int b(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo == null || !networkInfo.isAvailable())
        return 0; 
      int i = networkInfo.getType();
      if (i == 1) {
        h.b("TelephonyUtils", "WIFI");
        boolean bool = m.a(paramContext, "android.permission.CHANGE_NETWORK_STATE");
        StringBuilder stringBuilder = new StringBuilder();
        this();
        h.a("TelephonyUtils", stringBuilder.append("CHANGE_NETWORK_STATE=").append(bool).toString());
        if (bool && a(paramContext, connectivityManager)) {
          h.b("TelephonyUtils", "流量数据 WIFI 同开");
          return 3;
        } 
        return 2;
      } 
      if (i == 0) {
        h.b("TelephonyUtils", "流量");
        return 1;
      } 
    } catch (Exception exception) {}
    return 0;
  }
  
  public static String b() {
    return Build.MODEL;
  }
  
  public static String c() {
    return "android" + Build.VERSION.RELEASE;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */