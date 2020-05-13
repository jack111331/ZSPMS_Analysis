package com.sdk.base.framework.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import java.lang.reflect.Method;

public class a {
  private static final String TAG = a.class.getSimpleName();
  
  private static final boolean isDebug = c.h;
  
  protected static Object invokeOnSubscriptionManager(Context paramContext, String paramString, Boolean paramBoolean, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    Exception exception = null;
    try {
      Class<?> clazz = Class.forName("android.telephony.SubscriptionManager");
      paramContext = clazz.getConstructor(new Class[] { Class.forName("android.content.Context") }).newInstance(new Object[] { paramContext });
      Method method = clazz.getDeclaredMethod(paramString, paramArrayOfClass);
      method.setAccessible(true);
      if (paramBoolean.booleanValue())
        return method.invoke(null, paramArrayOfObject); 
      object = method.invoke(paramContext, paramArrayOfObject);
    } catch (Exception object) {
      object = exception;
    } 
    return object;
  }
  
  protected static Object invokeOnTelephonyManager(Context paramContext, String paramString, Boolean paramBoolean, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Method method = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod(paramString, paramArrayOfClass);
      method.setAccessible(true);
      if (paramBoolean.booleanValue())
        return method.invoke(null, paramArrayOfObject); 
      object = method.invoke(telephonyManager, paramArrayOfObject);
    } catch (Exception object) {
      b.c(TAG, object.getMessage(), Boolean.valueOf(isDebug));
      object = null;
    } 
    return object;
  }
  
  protected static void logError(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
    if (paramBoolean)
      Log.e(paramString1, "==>" + paramString2 + "\n==>" + paramObject); 
  }
  
  protected static void logInfo(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
    if (paramBoolean)
      Log.i(paramString1, "==>" + paramString2 + "\n==>" + paramObject); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */