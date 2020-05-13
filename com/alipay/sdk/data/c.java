package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.tid.b;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.k;
import com.alipay.sdk.util.l;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class c {
  private static final String d = "virtualImeiAndImsi";
  
  private static final String e = "virtual_imei";
  
  private static final String f = "virtual_imsi";
  
  private static c g;
  
  public String a;
  
  public String b = "sdk-and-lite";
  
  public String c;
  
  public static c a() {
    // Byte code:
    //   0: ldc com/alipay/sdk/data/c
    //   2: monitorenter
    //   3: getstatic com/alipay/sdk/data/c.g : Lcom/alipay/sdk/data/c;
    //   6: ifnonnull -> 21
    //   9: new com/alipay/sdk/data/c
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/alipay/sdk/data/c.g : Lcom/alipay/sdk/data/c;
    //   21: getstatic com/alipay/sdk/data/c.g : Lcom/alipay/sdk/data/c;
    //   24: astore_0
    //   25: ldc com/alipay/sdk/data/c
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/alipay/sdk/data/c
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public static String a(Context paramContext) {
    if (paramContext != null)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        String str = paramContext.getPackageName();
        PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str, 0);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(";");
        stringBuilder.append(packageInfo.versionCode);
        stringBuilder.append(")");
        return stringBuilder.toString();
      } catch (Exception exception) {} 
    return "";
  }
  
  static String a(Context paramContext, HashMap<String, String> paramHashMap) {
    String str1;
    String str2 = "";
    try {
      str1 = SecurityClientMobile.GetApdid(paramContext, paramHashMap);
    } catch (Throwable throwable) {
      a.a("third", "GetApdidEx", throwable);
      str1 = str2;
    } 
    if (TextUtils.isEmpty(str1))
      a.a("third", "GetApdidNull", "apdid == null"); 
    return str1;
  }
  
  private String a(b paramb) {
    String str1;
    String str4;
    Context context1 = (b.a()).a;
    a a = a.a(context1);
    if (TextUtils.isEmpty(this.a)) {
      String str12 = l.b();
      String str13 = l.c();
      str4 = l.f(context1);
      String str14 = k.a(context1);
      String str15 = str14.substring(0, str14.indexOf("://"));
      String str16 = l.g(context1);
      str14 = Float.toString((new TextView(context1)).getTextSize());
      this.a = "Msp/15.5.2" + " (" + str12 + ";" + str13 + ";" + str4 + ";" + str15 + ";" + str16 + ";" + str14;
    } 
    String str7 = (a.b(context1)).p;
    String str8 = a.a();
    String str6 = a.b();
    Context context2 = (b.a()).a;
    SharedPreferences sharedPreferences1 = context2.getSharedPreferences("virtualImeiAndImsi", 0);
    String str3 = sharedPreferences1.getString("virtual_imsi", null);
    String str2 = str3;
    if (TextUtils.isEmpty(str3)) {
      if (TextUtils.isEmpty((b.a()).a)) {
        str3 = b.a().c();
        if (TextUtils.isEmpty(str3)) {
          str3 = b();
        } else {
          str3 = str3.substring(3, 18);
        } 
      } else {
        str3 = a.a(context2).a();
      } 
      sharedPreferences1.edit().putString("virtual_imsi", str3).commit();
      str2 = str3;
    } 
    Context context3 = (b.a()).a;
    SharedPreferences sharedPreferences2 = context3.getSharedPreferences("virtualImeiAndImsi", 0);
    String str5 = sharedPreferences2.getString("virtual_imei", null);
    str3 = str5;
    if (TextUtils.isEmpty(str5)) {
      if (TextUtils.isEmpty((b.a()).a)) {
        str3 = b();
      } else {
        str3 = a.a(context3).b();
      } 
      sharedPreferences2.edit().putString("virtual_imei", str3).commit();
    } 
    if (paramb != null)
      this.c = paramb.b; 
    String str10 = Build.MANUFACTURER.replace(";", " ");
    String str9 = Build.MODEL.replace(";", " ");
    boolean bool = b.b();
    String str11 = a.a;
    WifiInfo wifiInfo2 = ((WifiManager)context1.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    if (wifiInfo2 != null) {
      str4 = wifiInfo2.getSSID();
    } else {
      str4 = "-1";
    } 
    WifiInfo wifiInfo1 = ((WifiManager)context1.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    if (wifiInfo1 != null) {
      str1 = wifiInfo1.getBSSID();
    } else {
      str1 = "00";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a).append(";").append(str7).append(";").append("-1;-1").append(";").append("1").append(";").append(str8).append(";").append(str6).append(";").append(this.c).append(";").append(str10).append(";").append(str9).append(";").append(bool).append(";").append(str11).append(";-1;-1;").append(this.b).append(";").append(str2).append(";").append(str3).append(";").append(str4).append(";").append(str1);
    if (paramb != null) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("tid", paramb.a);
      hashMap.put("utdid", b.a().c());
      String str = b(context1, (HashMap)hashMap);
      if (!TextUtils.isEmpty(str))
        stringBuilder.append(";").append(str); 
    } 
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public static String b() {
    String str = Long.toHexString(System.currentTimeMillis());
    Random random = new Random();
    return str + (random.nextInt(9000) + 1000);
  }
  
  private static String b(Context paramContext) {
    return Float.toString((new TextView(paramContext)).getTextSize());
  }
  
  private String c() {
    return this.c;
  }
  
  private static String c(Context paramContext) {
    WifiInfo wifiInfo = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    return (wifiInfo != null) ? wifiInfo.getSSID() : "-1";
  }
  
  private static String d() {
    return "1";
  }
  
  private static String d(Context paramContext) {
    WifiInfo wifiInfo = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    return (wifiInfo != null) ? wifiInfo.getBSSID() : "00";
  }
  
  private static String e() {
    return "-1;-1";
  }
  
  private static String f() {
    Context context = (b.a()).a;
    SharedPreferences sharedPreferences = context.getSharedPreferences("virtualImeiAndImsi", 0);
    String str1 = sharedPreferences.getString("virtual_imei", null);
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      if (TextUtils.isEmpty((b.a()).a)) {
        str2 = b();
      } else {
        str2 = a.a(context).b();
      } 
      sharedPreferences.edit().putString("virtual_imei", str2).commit();
    } 
    return str2;
  }
  
  private static String g() {
    Context context = (b.a()).a;
    SharedPreferences sharedPreferences = context.getSharedPreferences("virtualImeiAndImsi", 0);
    String str1 = sharedPreferences.getString("virtual_imsi", null);
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      if (TextUtils.isEmpty((b.a()).a)) {
        str2 = b.a().c();
        if (TextUtils.isEmpty(str2)) {
          str2 = b();
        } else {
          str2 = str2.substring(3, 18);
        } 
      } else {
        str2 = a.a(context).a();
      } 
      sharedPreferences.edit().putString("virtual_imsi", str2).commit();
    } 
    return str2;
  }
  
  public final void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic a : ()Lcom/alipay/sdk/sys/b;
    //   17: getfield a : Landroid/content/Context;
    //   20: invokestatic getDefaultSharedPreferences : (Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   23: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   28: ldc_w 'trideskey'
    //   31: aload_1
    //   32: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   37: invokeinterface commit : ()Z
    //   42: pop
    //   43: aload_1
    //   44: putstatic com/alipay/sdk/cons/a.c : Ljava/lang/String;
    //   47: goto -> 11
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	47	50	finally
  }
  
  public final String b(Context paramContext, HashMap<String, String> paramHashMap) {
    String str;
    Future<?> future = Executors.newFixedThreadPool(2).submit(new d(this, paramContext, paramHashMap));
    try {
      str = (String)future.get(3000L, TimeUnit.MILLISECONDS);
    } catch (Throwable throwable) {
      a.a("third", "GetApdidTimeout", throwable);
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\data\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */