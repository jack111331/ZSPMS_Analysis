package com.ta.utdid2.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

public class d {
  private static String a() {
    String str1 = g.get("ro.aliyun.clouduuid", "");
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = g.get("ro.sys.aliyun.clouduuid", ""); 
    str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = b(); 
    return str1;
  }
  
  private static String b() {
    String str;
    try {
      str = (String)Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public static String getImei(Context paramContext) {
    String str1;
    TelephonyManager telephonyManager2 = null;
    TelephonyManager telephonyManager3 = telephonyManager2;
    if (paramContext != null)
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (telephonyManager != null) {
          str1 = telephonyManager.getDeviceId();
        } else {
          telephonyManager = null;
        } 
        telephonyManager3 = telephonyManager;
      } catch (Exception exception) {
        telephonyManager3 = telephonyManager2;
      }  
    TelephonyManager telephonyManager1 = telephonyManager3;
    if (f.isEmpty((String)telephonyManager3))
      str1 = a(); 
    String str2 = str1;
    if (f.isEmpty(str1))
      str2 = getUniqueID(); 
    return str2;
  }
  
  public static String getImsi(Context paramContext) {
    String str;
    TelephonyManager telephonyManager2 = null;
    TelephonyManager telephonyManager3 = telephonyManager2;
    if (paramContext != null)
      try {
        TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (telephonyManager != null) {
          str = telephonyManager.getSubscriberId();
        } else {
          telephonyManager = null;
        } 
        telephonyManager3 = telephonyManager;
      } catch (Exception exception) {
        telephonyManager3 = telephonyManager2;
      }  
    TelephonyManager telephonyManager1 = telephonyManager3;
    if (f.isEmpty((String)telephonyManager3))
      str = getUniqueID(); 
    return str;
  }
  
  public static String getUniqueID() {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int k = (new Random()).nextInt();
    int m = (new Random()).nextInt();
    byte[] arrayOfByte1 = c.getBytes(i);
    byte[] arrayOfByte2 = c.getBytes(j);
    byte[] arrayOfByte3 = c.getBytes(k);
    byte[] arrayOfByte4 = c.getBytes(m);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return b.encodeToString(arrayOfByte5, 2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */