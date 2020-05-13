package com.sdk.base.framework.utils.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.framework.utils.k.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class b extends a {
  private static final String a = b.class.getName();
  
  private static Boolean b = Boolean.valueOf(c.h);
  
  public static ArrayList<String> a(Context paramContext) {
    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2 = new ArrayList();
    try {
      if (AppUtils.getAndroidSDKVersion(paramContext) >= 21)
        return c(paramContext); 
      arrayList1 = d(paramContext);
    } catch (Exception exception) {
      com.sdk.base.framework.utils.f.b.c(a, exception.getMessage(), b);
      arrayList1 = arrayList2;
    } 
    return arrayList1;
  }
  
  public static String b(Context paramContext) {
    try {
      String str = c.a(paramContext);
      if (a.b(str).booleanValue())
        return str.replaceAll(":", ""); 
    } catch (Throwable throwable) {}
    return "020000000000";
  }
  
  private static ArrayList<String> c(Context paramContext) {
    ArrayList<String> arrayList = new ArrayList();
    System.currentTimeMillis();
    try {
      Method method = Class.forName("android.telephony.SubscriptionInfo").getDeclaredMethod("getSimSlotIndex", new Class[0]);
      method.setAccessible(true);
      List list = (List)invokeOnSubscriptionManager(paramContext, "getActiveSubscriptionInfoList", Boolean.valueOf(false), null, null);
      if (list != null)
        for (byte b1 = 0; b1 < list.size(); b1++) {
          int i = ((Integer)method.invoke(list.get(b1), new Object[0])).intValue();
          String str1 = (String)invokeOnTelephonyManager(paramContext, "getDeviceId", Boolean.valueOf(false), new Class[] { int.class }, new Object[] { Integer.valueOf(i) });
          String str2 = str1;
          if (a.a(str1).booleanValue())
            str2 = (String)invokeOnTelephonyManager(paramContext, "getDeviceId", Boolean.valueOf(false), null, null); 
          if (a.b(str2).booleanValue())
            arrayList.add(str2); 
        }  
    } catch (Throwable throwable) {
      com.sdk.base.framework.utils.f.b.c(a, throwable.getMessage(), b);
    } 
    if (b.booleanValue());
    return arrayList;
  }
  
  private static ArrayList<String> d(Context paramContext) {
    long l = System.currentTimeMillis();
    ArrayList<Object> arrayList = new ArrayList();
    try {
      Object object1;
      Object object3;
      boolean bool;
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Class<?> clazz = Class.forName(telephonyManager.getClass().getName());
      Context context = null;
      paramContext = context;
      try {
        Method method = clazz.getDeclaredMethod("getSubscriberInfo", new Class[0]);
        paramContext = context;
        method.setAccessible(true);
        paramContext = context;
        object2 = method.invoke(telephonyManager, new Object[0]);
        object1 = object2;
        method = Class.forName("com.android.internal.telephony.IPhoneSubInfo").getDeclaredMethod("getDeviceId", new Class[0]);
        object1 = object2;
        method.setAccessible(true);
        bool = true;
        object1 = method;
        object3 = object1;
      } catch (Exception object2) {}
      if (bool) {
        object1 = object3.invoke(object2, new Object[0]);
      } else {
        object1 = object3.invoke(telephonyManager, new Object[0]);
      } 
      arrayList.add(object1);
    } catch (Exception exception) {
      com.sdk.base.framework.utils.f.b.c(a, exception.getMessage(), b);
    } 
    if (b.booleanValue())
      com.sdk.base.framework.utils.f.b.a(a, "应用层获取IMEI信息耗时：" + (System.currentTimeMillis() - l), b); 
    return (ArrayList)arrayList;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */