package com.chuanglan.shanyan_sdk.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.chuanglan.shanyan_sdk.utils.AppNetworkMgr;
import com.chuanglan.shanyan_sdk.utils.L;

public class i {
  private static i a = null;
  
  private Context b;
  
  private String c = "-1";
  
  private int d = 0;
  
  private String e = "";
  
  private String f = "0";
  
  private TelephonyManager g;
  
  private PhoneStateListener h = new PhoneStateListener(this) {
      public void onSignalStrengthsChanged(SignalStrength param1SignalStrength) {
        super.onSignalStrengthsChanged(param1SignalStrength);
        switch (i.a(this.a).getNetworkType()) {
          default:
            i.a(this.a, param1SignalStrength.getGsmSignalStrength());
            switch (i.a(this.a).getNetworkType()) {
              default:
                i.a(this.a, "UNKNOWN");
              case 1:
                i.a(this.a, "GPRS");
              case 2:
                i.a(this.a, "EDGE");
              case 4:
                i.a(this.a, "CDMA");
              case 16:
                i.a(this.a, "GMS");
              case 18:
                i.a(this.a, "IWLAN");
              case 7:
                i.a(this.a, "1xRTT");
              case 11:
                break;
            } 
            break;
          case 13:
          case 18:
          case 19:
            try {
              i.a(this.a, ((Integer)param1SignalStrength.getClass().getMethod("getDbm", new Class[0]).invoke(param1SignalStrength, new Object[0])).intValue());
              switch (i.a(this.a).getNetworkType()) {
                default:
                
                case 13:
                  i.a(this.a, "LTE");
                case 18:
                  i.a(this.a, "IWLAN");
                case 19:
                  break;
              } 
            } catch (Exception null) {
              i.a(this.a, -1000);
              switch (i.a(this.a).getNetworkType()) {
                default:
                
                case 13:
                  i.a(this.a, "LTE");
                case 18:
                  i.a(this.a, "IWLAN");
                case 19:
                  break;
              } 
            } 
            i.a(this.a, "LTE_CA");
          case 3:
          case 5:
          case 6:
          case 8:
          case 9:
          case 10:
          case 12:
          case 14:
          case 15:
            try {
              i.a(this.a, ((Integer)exception.getClass().getMethod("getGsmDbm", new Class[0]).invoke(exception, new Object[0])).intValue());
              switch (i.a(this.a).getNetworkType()) {
                default:
                  return;
                case 3:
                  i.a(this.a, "UMTS");
                case 8:
                  i.a(this.a, "HSDPA");
                case 10:
                  i.a(this.a, "HSPA");
                case 9:
                  i.a(this.a, "HSUPA");
                case 5:
                  i.a(this.a, "EVDO0");
                case 6:
                  i.a(this.a, "EVDOA");
                case 12:
                  i.a(this.a, "EVDOB");
                case 15:
                  i.a(this.a, "HSPAP");
                case 14:
                  break;
              } 
            } catch (Exception exception) {
              i.a(this.a, -1000);
              switch (i.a(this.a).getNetworkType()) {
                default:
                  return;
                case 3:
                  i.a(this.a, "UMTS");
                case 8:
                  i.a(this.a, "HSDPA");
                case 10:
                  i.a(this.a, "HSPA");
                case 9:
                  i.a(this.a, "HSUPA");
                case 5:
                  i.a(this.a, "EVDO0");
                case 6:
                  i.a(this.a, "EVDOA");
                case 12:
                  i.a(this.a, "EVDOB");
                case 15:
                  i.a(this.a, "HSPAP");
                case 14:
                  break;
              } 
            } 
            i.a(this.a, "EHRPD");
          case 17:
            try {
              i.a(this.a, ((Integer)exception.getClass().getMethod("getTdScdmaDbm", new Class[0]).invoke(exception, new Object[0])).intValue());
            } catch (Exception exception1) {
              exception1.printStackTrace();
            } 
            i.a(this.a, "TD_SCDMA");
        } 
        i.a(this.a, "IDEN");
      }
    };
  
  public static i a() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/i.a : Lcom/chuanglan/shanyan_sdk/tool/i;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/tool/i
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/i.a : Lcom/chuanglan/shanyan_sdk/tool/i;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/tool/i
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/tool/i.a : Lcom/chuanglan/shanyan_sdk/tool/i;
    //   27: ldc com/chuanglan/shanyan_sdk/tool/i
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/tool/i.a : Lcom/chuanglan/shanyan_sdk/tool/i;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/tool/i
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public static String a(Context paramContext, int paramInt) {
    String str;
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      str = (String)telephonyManager.getClass().getMethod("getImei", new Class[] { int.class }).invoke(telephonyManager, new Object[] { Integer.valueOf(paramInt) });
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private String f() {
    String str;
    try {
      if (this.b != null) {
        WifiManager wifiManager = (WifiManager)this.b.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
          WifiInfo wifiInfo = wifiManager.getConnectionInfo();
          if (wifiInfo != null && wifiInfo.getBSSID() != null)
            this.f = String.valueOf(WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 100)); 
        } 
      } 
      str = this.f;
    } catch (Exception exception) {
      exception.printStackTrace();
      this.f = "-1000";
      str = this.f;
    } 
    return str;
  }
  
  public void a(Context paramContext) {
    try {
      this.b = paramContext;
      if (this.g == null) {
        this.g = (TelephonyManager)paramContext.getSystemService("phone");
        this.g.listen(this.h, 256);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "Networkinit()Exception == " + exception.toString());
    } 
  }
  
  public String b() {
    return this.e;
  }
  
  public String c() {
    String str;
    try {
      if (AppNetworkMgr.isWifiByType(this.b)) {
        this.f = f();
      } else {
        this.f = "-1";
      } 
      str = this.f;
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "-1000";
    } 
    return str;
  }
  
  public int d() {
    short s;
    try {
      if (AppNetworkMgr.getMobileDataState(this.b, null)) {
        if (this.d > 0)
          this.d = 0; 
      } else {
        this.d = -1;
      } 
      s = this.d;
    } catch (Exception exception) {
      exception.printStackTrace();
      L.d("ExceptionLogger", "getItedbm()Exception == " + exception.toString());
      s = -1000;
    } 
    return s;
  }
  
  @SuppressLint({"MissingPermission", "HardwareIds"})
  public String e() {
    String str;
    try {
      if (this.g != null)
        if (Build.VERSION.SDK_INT >= 26) {
          this.c = this.g.getImei();
        } else {
          this.c = a(this.b, 0);
        }  
      str = this.c;
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */