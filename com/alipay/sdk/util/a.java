package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class a {
  private static final String b = "00:00:00:00:00:00";
  
  private static a e = null;
  
  public String a;
  
  private String c;
  
  private String d;
  
  private a(Context paramContext) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
      b(telephonyManager.getDeviceId());
      String str2 = telephonyManager.getSubscriberId();
      String str1 = str2;
      if (str2 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        str1 = stringBuilder.append(str2).append("000000000000000").toString().substring(0, 15);
      } 
      this.c = str1;
      this.a = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } finally {
      if (TextUtils.isEmpty(this.a))
        this.a = "00:00:00:00:00:00"; 
    } 
  }
  
  public static a a(Context paramContext) {
    if (e == null)
      e = new a(paramContext); 
    return e;
  }
  
  private void a(String paramString) {
    String str = paramString;
    if (paramString != null)
      str = (paramString + "000000000000000").substring(0, 15); 
    this.c = str;
  }
  
  public static d b(Context paramContext) {
    d d;
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    try {
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.getType() == 0)
        return d.a(networkInfo.getSubtype()); 
      if (networkInfo != null && networkInfo.getType() == 1)
        return d.a; 
      d = d.o;
    } catch (Exception exception) {
      d = d.o;
    } 
    return d;
  }
  
  private void b(String paramString) {
    String str = paramString;
    if (paramString != null) {
      byte[] arrayOfByte = paramString.getBytes();
      for (byte b = 0; b < arrayOfByte.length; b++) {
        if (arrayOfByte[b] < 48 || arrayOfByte[b] > 57)
          arrayOfByte[b] = (byte)48; 
      } 
      String str1 = new String(arrayOfByte);
      str = (str1 + "000000000000000").substring(0, 15);
    } 
    this.d = str;
  }
  
  private String c() {
    null = b();
    null = null + "|";
    String str = a();
    return TextUtils.isEmpty(str) ? (null + "000000000000000") : (null + str);
  }
  
  public static String c(Context paramContext) {
    a a1 = a(paramContext);
    String str2 = a1.b();
    str2 = str2 + "|";
    String str1 = a1.a();
    if (TextUtils.isEmpty(str1)) {
      str1 = str2 + "000000000000000";
      return str1.substring(0, 8);
    } 
    str1 = str2 + str1;
    return str1.substring(0, 8);
  }
  
  private String d() {
    return this.a;
  }
  
  public static String d(Context paramContext) {
    String str;
    if (paramContext == null)
      return ""; 
    try {
      str = (paramContext.getResources().getConfiguration()).locale.toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  public final String a() {
    if (TextUtils.isEmpty(this.c))
      this.c = "000000000000000"; 
    return this.c;
  }
  
  public final String b() {
    if (TextUtils.isEmpty(this.d))
      this.d = "000000000000000"; 
    return this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */