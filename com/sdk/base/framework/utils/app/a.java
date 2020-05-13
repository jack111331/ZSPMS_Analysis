package com.sdk.base.framework.utils.app;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a {
  private static final String a = a.class.getCanonicalName();
  
  public static void a(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 19 && !a(paramActivity, true) && !a(paramActivity.getWindow(), true)) {
      if (Build.VERSION.SDK_INT >= 23) {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        return;
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        paramActivity.getWindow().addFlags(-2147483648);
        paramActivity.getWindow().setFlags(67108864, 67108864);
      } 
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(256);
    } 
  }
  
  private static boolean a(Activity paramActivity, boolean paramBoolean) {
    boolean bool = true;
    Window window = paramActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21)
      window.setStatusBarColor(0); 
    if (window != null) {
      boolean bool1;
      Class<?> clazz = window.getClass();
      try {
        Class<?> clazz1 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = clazz1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(clazz1);
        Method method = clazz.getMethod("setExtraFlags", new Class[] { int.class, int.class });
        if (paramBoolean) {
          method.invoke(window, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
        } else {
          method.invoke(window, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        } 
        bool1 = bool;
        try {
          if (Build.VERSION.SDK_INT >= 23) {
            if (paramBoolean) {
              paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
              return bool;
            } 
          } else {
            return bool1;
          } 
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(0);
          bool1 = bool;
        } catch (Exception exception) {
          bool1 = bool;
        } 
      } catch (Exception exception) {
        bool1 = false;
      } 
      return bool1;
    } 
    return false;
  }
  
  private static boolean a(Window paramWindow, boolean paramBoolean) {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 21)
      paramWindow.setStatusBarColor(0); 
    if (paramWindow != null) {
      try {
        WindowManager.LayoutParams layoutParams = paramWindow.getAttributes();
        Field field1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field field2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        field1.setAccessible(true);
        field2.setAccessible(true);
        int i = field1.getInt(null);
        int j = field2.getInt(layoutParams);
        if (paramBoolean) {
          j = i | j;
        } else {
          j = (i ^ 0xFFFFFFFF) & j;
        } 
        field2.setInt(layoutParams, j);
        paramWindow.setAttributes(layoutParams);
        paramBoolean = bool;
      } catch (Exception exception) {
        paramBoolean = false;
      } 
      return paramBoolean;
    } 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\app\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */