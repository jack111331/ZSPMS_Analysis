package com.bun.miitmdid.core;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.Log;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Keep
public class MdidSdkHelper {
  public static String TAG = "MdidSdkHelper";
  
  @Keep
  public static boolean _OuterIsOk = true;
  
  @Keep
  private String sdk_date = "2020011018";
  
  @Keep
  public static int InitSdk(Context paramContext, boolean paramBoolean, IIdentifierListener paramIIdentifierListener) {
    int j;
    int i = 1008615;
    try {
      if (!_OuterIsOk) {
        j = i;
        if (paramIIdentifierListener != null) {
          a a = new a();
          this();
          paramIIdentifierListener.OnSupport(false, (IdSupplier)a);
          j = i;
        } 
      } else {
        StringBuilder stringBuilder;
        Class<?> clazz = Class.forName("com.bun.miitmdid.core.MdidSdk");
        if (clazz == null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("not found class:");
          stringBuilder1.append("com.bun.miitmdid.core.MdidSdk");
          String str = stringBuilder1.toString();
        } else {
          Constructor<?> constructor = clazz.getConstructor(new Class[] { boolean.class });
          if (constructor == null) {
            String str = "not found MdidSdk Constructor";
          } else {
            constructor = (Constructor<?>)constructor.newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
            if (constructor == null) {
              String str = "Create MdidSdk Instance failed";
            } else {
              String str;
              Method method = clazz.getDeclaredMethod("InitSdk", new Class[] { Context.class, IIdentifierListener.class });
              if (method == null) {
                stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("not found MdidSdk ");
                stringBuilder.append("InitSdk");
                stringBuilder.append(" function");
                str = stringBuilder.toString();
              } else {
                int k = ((Integer)method.invoke(constructor, new Object[] { str, paramIIdentifierListener })).intValue();
                stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("call and retvalue:");
                stringBuilder.append(k);
                logd(paramBoolean, stringBuilder.toString());
                return k;
              } 
            } 
          } 
        } 
        logd(paramBoolean, (String)stringBuilder);
        j = i;
      } 
    } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|InstantiationException|java.lang.reflect.InvocationTargetException classNotFoundException) {
      loge(paramBoolean, classNotFoundException);
      logd(paramBoolean, "exception exit");
      j = i;
    } 
    return j;
  }
  
  public static void logd(boolean paramBoolean, String paramString) {
    if (paramBoolean)
      Log.d(TAG, paramString); 
  }
  
  public static void loge(boolean paramBoolean, Exception paramException) {
    if (paramBoolean)
      Log.e(TAG, paramException.getClass().getSimpleName(), paramException); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\core\MdidSdkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */