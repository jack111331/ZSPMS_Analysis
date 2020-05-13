package com.zz.sdk.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.zz.sdk.ParamChain;
import com.zz.sdk.e;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class ba {
  private static final String a = "devicesyn";
  
  private static final String b = "device_id";
  
  private static final Object c = new Object();
  
  private static boolean d = false;
  
  private ba(Context paramContext) {}
  
  public static String a(Context paramContext) {
    synchronized (c) {
      UUID uUID;
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("devicesyn", 0);
      String str = sharedPreferences.getString("device_id", null);
      if (str != null) {
        uUID = UUID.fromString(str);
        return uUID.toString();
      } 
      str = Settings.Secure.getString(uUID.getContentResolver(), "android_id");
      try {
        UUID uUID1;
        if (!"9774d56d682e549c".equals(str)) {
          uUID = UUID.nameUUIDFromBytes(str.getBytes("utf8"));
        } else {
          String str1 = ((TelephonyManager)uUID.getSystemService("phone")).getDeviceId();
          if (str1 != null) {
            uUID1 = UUID.nameUUIDFromBytes(str1.getBytes("utf8"));
          } else {
            uUID1 = UUID.randomUUID();
          } 
        } 
        sharedPreferences.edit().putString("device_id", uUID1.toString()).commit();
      } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    } 
  }
  
  public static void a(Context paramContext, ParamChain paramParamChain) {
    ParamChain paramChain = paramParamChain.grow(e.class.getName());
    String str2 = cv.n(paramContext);
    bp.a("DeviceUtil genTempDeviceProp, imei:" + str2);
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    paramChain.add("global.device.imei", str1);
    paramChain.add("global.device.imsi", "");
    paramChain.add("global.device.phone_model", "android");
  }
  
  public static void a(Context paramContext, String paramString, ParamChain paramParamChain) {
    synchronized (c) {
      String str = paramContext.getSharedPreferences("devicesyn", 0).getString("devicesyn", null);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      bp.a(stringBuilder.append("DeviceUtil_checkAndSyn: res=").append(str).toString());
      if ("-1".equals(str)) {
        bp.a("D: unnecessary synchronize device-information");
        return;
      } 
      if (b(true))
        (new bb("device-sync", paramContext, paramString, paramParamChain)).start(); 
      return;
    } 
  }
  
  public static String b(Context paramContext) {
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager != null) {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return TextUtils.isEmpty(wifiInfo.getMacAddress()) ? "" : wifiInfo.getMacAddress();
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  private static boolean b(boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc com/zz/sdk/i/ba
    //   4: monitorenter
    //   5: iload_0
    //   6: ifeq -> 33
    //   9: getstatic com/zz/sdk/i/ba.d : Z
    //   12: istore_0
    //   13: iload_0
    //   14: ifeq -> 24
    //   17: iload_1
    //   18: istore_0
    //   19: ldc com/zz/sdk/i/ba
    //   21: monitorexit
    //   22: iload_0
    //   23: ireturn
    //   24: iconst_1
    //   25: putstatic com/zz/sdk/i/ba.d : Z
    //   28: iconst_1
    //   29: istore_0
    //   30: goto -> 19
    //   33: iload_1
    //   34: istore_0
    //   35: getstatic com/zz/sdk/i/ba.d : Z
    //   38: ifeq -> 19
    //   41: iconst_0
    //   42: putstatic com/zz/sdk/i/ba.d : Z
    //   45: iconst_1
    //   46: istore_0
    //   47: goto -> 19
    //   50: astore_2
    //   51: ldc com/zz/sdk/i/ba
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   9	13	50	finally
    //   24	28	50	finally
    //   35	45	50	finally
  }
  
  public static String c(Context paramContext) {
    String str;
    try {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String d(Context paramContext) {
    String str;
    try {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private static Pair e(Context paramContext) {
    try {
      Pair pair;
      String str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (!"9774d56d682e549c".equals(str2)) {
        pair = new Pair();
        this(Integer.valueOf(0), str2);
        return pair;
      } 
      String str1 = ((TelephonyManager)pair.getSystemService("phone")).getDeviceId();
      if (str1 != null)
        return new Pair(Integer.valueOf(1), str1); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */