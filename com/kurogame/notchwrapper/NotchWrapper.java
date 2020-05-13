package com.kurogame.notchwrapper;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class NotchWrapper {
  private static final int NOTCH_IN_SCREEN_VIVO = 32;
  
  private static final int ROUNDED_IN_SCREEN_VIVO = 8;
  
  private static boolean isGetNotchSize;
  
  private static boolean isInitWrapper;
  
  private static int notchSize;
  
  private static XNotchType notchType = XNotchType.None;
  
  private boolean isLogNotchSize = false;
  
  private boolean isLogStatusBarHeight = false;
  
  static {
    isGetNotchSize = false;
    notchSize = 0;
  }
  
  private void closeAndroidPDialog() {
    try {
      Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(new Class[] { String.class }).setAccessible(true);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    try {
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      Method method = clazz.getDeclaredMethod("currentActivityThread", new Class[0]);
      method.setAccessible(true);
      Object object = method.invoke(null, new Object[0]);
      Field field = clazz.getDeclaredField("mHiddenApiWarningShown");
      field.setAccessible(true);
      field.setBoolean(object, true);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private int getHuaWeiNotchSize(Activity paramActivity) {
    if (isGetNotchSize)
      return notchSize; 
    try {
      Class<?> clazz = paramActivity.getApplicationContext().getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      int[] arrayOfInt = (int[])clazz.getMethod("getNotchSize", new Class[0]).invoke(clazz, new Object[0]);
      notchSize = arrayOfInt[1];
      isGetNotchSize = true;
      if (!this.isLogStatusBarHeight) {
        this.isLogStatusBarHeight = true;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("HuaWei: notch width = ");
        stringBuilder.append(arrayOfInt[0]);
        stringBuilder.append(", notch height = ");
        stringBuilder.append(arrayOfInt[1]);
        Log.i("NotchWrapper", stringBuilder.toString());
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return notchSize;
  }
  
  private int getLenovoNotchHeight(Activity paramActivity) {
    if (isGetNotchSize)
      return notchSize; 
    int i = paramActivity.getApplicationContext().getResources().getIdentifier("notch_h", "integer", "android");
    if (i > 0) {
      notchSize = paramActivity.getApplicationContext().getResources().getInteger(i);
      isGetNotchSize = true;
    } 
    if (!this.isLogStatusBarHeight) {
      this.isLogStatusBarHeight = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("====== getLenovoNotchHeight = ");
      stringBuilder.append(notchSize);
      Log.i("NotchWrapper", stringBuilder.toString());
    } 
    return notchSize;
  }
  
  private int getStatusBarHeight(Activity paramActivity) {
    if (isGetNotchSize)
      return notchSize; 
    int i = paramActivity.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      notchSize = paramActivity.getApplicationContext().getResources().getDimensionPixelSize(i);
      isGetNotchSize = true;
    } 
    if (!this.isLogStatusBarHeight) {
      this.isLogStatusBarHeight = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("====== getStatusBarHeight = ");
      stringBuilder.append(notchSize);
      Log.i("NotchWrapper", stringBuilder.toString());
    } 
    return notchSize;
  }
  
  private int getXiaoMiNotchHeight(Activity paramActivity) {
    if (isGetNotchSize)
      return notchSize; 
    int i = paramActivity.getApplicationContext().getResources().getIdentifier("notch_height", "dimen", "android");
    if (i > 0) {
      notchSize = paramActivity.getApplicationContext().getResources().getDimensionPixelSize(i);
      isGetNotchSize = true;
    } 
    if (!this.isLogStatusBarHeight) {
      this.isLogStatusBarHeight = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("====== getXiaoMiNotchHeight = ");
      stringBuilder.append(notchSize);
      Log.i("NotchWrapper", stringBuilder.toString());
    } 
    return notchSize;
  }
  
  private void initNotchWrapper(Activity paramActivity) {
    if (isInitWrapper)
      return; 
    if (Build.VERSION.SDK_INT >= 28) {
      Log.i("NotchWrapper", "Sdk version >= 28, To Check Google NotchWrapper");
      try {
        View view = paramActivity.getWindow().getDecorView();
        if (view != null) {
          WindowInsets windowInsets = view.getRootWindowInsets();
          if (windowInsets != null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
              List list = displayCutout.getBoundingRects();
              if (list != null && list.size() > 0) {
                Log.i("NotchWrapper", "全面屏方案：Goolge P.");
                StringBuilder stringBuilder = new StringBuilder();
                this();
                stringBuilder.append("rect size:");
                stringBuilder.append(list.size());
                Log.i("NotchWrapper", stringBuilder.toString());
                for (Rect rect : list) {
                  int m;
                  int j = displayCutout.getSafeInsetLeft();
                  int k = displayCutout.getSafeInsetRight();
                  if (notchSize >= j) {
                    m = notchSize;
                  } else {
                    m = j;
                  } 
                  notchSize = m;
                  if (notchSize >= k) {
                    m = notchSize;
                  } else {
                    m = k;
                  } 
                  notchSize = m;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this();
                  stringBuilder1.append("cutout.getSafeInsetTop():");
                  stringBuilder1.append(displayCutout.getSafeInsetTop());
                  stringBuilder1.append(", cutout.getSafeInsetBottom():");
                  stringBuilder1.append(displayCutout.getSafeInsetBottom());
                  stringBuilder1.append(", cutout.getSafeInsetLeft():");
                  stringBuilder1.append(j);
                  stringBuilder1.append(", cutout.getSafeInsetRight():");
                  stringBuilder1.append(k);
                  stringBuilder1.append(", cutout.rects:");
                  stringBuilder1.append(rect);
                  Log.i("NotchWrapper", stringBuilder1.toString());
                } 
                notchType = XNotchType.Google;
                isInitWrapper = true;
                return;
              } 
              Log.i("NotchWrapper", "刘海区不绘制，或刘海数量为0");
            } else {
              Log.i("NotchWrapper", "Google P api: getDisplayCutout() return null");
            } 
          } else {
            Log.i("NotchWrapper", "Google P api: getRootWindowInsets() return null");
          } 
        } else {
          Log.i("NotchWrapper", "Google P api: getDecorView() return null");
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    ClassLoader classLoader = paramActivity.getApplicationContext().getClassLoader();
    Log.i("NotchWrapper", "To Check HuaWei NotchWrapper");
    boolean bool = false;
    try {
      Class<?> clazz = classLoader.loadClass("com.huawei.android.util.HwNotchSizeUtil");
      if (clazz != null) {
        Method method = clazz.getMethod("hasNotchInScreen", new Class[0]);
        if (method != null && ((Boolean)method.invoke(clazz, new Object[0])).booleanValue()) {
          Log.i("NotchWrapper", "全面屏方案：HuaWei.");
          notchType = XNotchType.HuaWei;
          isInitWrapper = true;
          return;
        } 
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    Log.i("NotchWrapper", "To Check Vivo NotchWrapper");
    try {
      Class<?> clazz = classLoader.loadClass("android.util.FtFeature");
      if (clazz != null) {
        Method method = clazz.getMethod("isFeatureSupport", new Class[] { int.class });
        if (method != null && ((Boolean)method.invoke(clazz, new Object[] { Integer.valueOf(32) })).booleanValue()) {
          Log.i("NotchWrapper", "全面屏方案：Vivo.");
          notchType = XNotchType.Vivo;
          isInitWrapper = true;
          return;
        } 
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    Log.i("NotchWrapper", "To Check XiaoMi NotchWrapper");
    try {
      Class<?> clazz = classLoader.loadClass("android.os.SystemProperties");
      if (((Integer)clazz.getMethod("getInt", new Class[] { String.class, int.class }).invoke(clazz, new Object[] { "ro.miui.notch", Integer.valueOf(0) })).intValue() == 1) {
        Log.i("NotchWrapper", "全面屏方案：XiaoMi.");
        notchType = XNotchType.XiaoMi;
        isInitWrapper = true;
        return;
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InvocationTargetException invocationTargetException) {
      invocationTargetException.printStackTrace();
    } 
    Log.i("NotchWrapper", "To Check Oppo NotchWrapper");
    if (paramActivity.getApplicationContext().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) {
      Log.i("NotchWrapper", "全面屏方案：Oppo.");
      notchType = XNotchType.Oppo;
      isInitWrapper = true;
      return;
    } 
    Log.i("NotchWrapper", "To Check Lenovo NotchWrapper");
    int i = paramActivity.getApplicationContext().getResources().getIdentifier("config_screen_has_notch", "bool", "android");
    if (i > 0 && paramActivity.getApplication().getResources().getBoolean(i)) {
      notchType = XNotchType.Lenovo;
      isInitWrapper = true;
      return;
    } 
    i = paramActivity.getApplicationContext().getResources().getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
    if (i > 0) {
      String str = paramActivity.getApplication().getResources().getString(i);
    } else {
      paramActivity = null;
    } 
    i = bool;
    if (paramActivity != null) {
      i = bool;
      if (!TextUtils.isEmpty((CharSequence)paramActivity))
        i = 1; 
    } 
    if (i != 0) {
      notchType = XNotchType.Samsung;
      isInitWrapper = true;
      return;
    } 
    Log.i("NotchWrapper", "全面屏方案：Unkown.");
    notchType = XNotchType.Unkown;
    isInitWrapper = true;
  }
  
  private boolean openGoogleFullScreenModel(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 28)
      try {
        paramActivity.requestWindowFeature(1);
        WindowManager.LayoutParams layoutParams = paramActivity.getWindow().getAttributes();
        layoutParams.layoutInDisplayCutoutMode = 1;
        paramActivity.getWindow().setAttributes(layoutParams);
        int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(i | 0x406);
        return true;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  private boolean setImmersionStatusBar(Activity paramActivity) {
    Window window;
    if (Build.VERSION.SDK_INT >= 21) {
      window = paramActivity.getWindow();
      window.getDecorView().setSystemUiVisibility(1280);
      window.addFlags(-2147483648);
      window.setStatusBarColor(0);
      return true;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      Window window1 = window.getWindow();
      WindowManager.LayoutParams layoutParams = window1.getAttributes();
      layoutParams.flags |= 0x4000000;
      window1.setAttributes(layoutParams);
      return true;
    } 
    return false;
  }
  
  public int getNotchSize(Activity paramActivity) {
    WindowManager windowManager;
    Display display;
    Point point;
    DisplayMetrics displayMetrics;
    StringBuilder stringBuilder;
    int j;
    int k;
    int m;
    int n;
    if (notchType == XNotchType.None)
      initNotchWrapper(paramActivity); 
    int i = null.$SwitchMap$com$kurogame$notchwrapper$NotchWrapper$XNotchType[notchType.ordinal()];
    boolean bool = false;
    switch (i) {
      default:
        i = bool;
        break;
      case 7:
        i = getLenovoNotchHeight(paramActivity);
        break;
      case 6:
        windowManager = paramActivity.getWindowManager();
        point = new Point();
        display = windowManager.getDefaultDisplay();
        display.getRealSize(point);
        j = point.x;
        k = point.y;
        displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        m = displayMetrics.widthPixels;
        n = displayMetrics.heightPixels;
        i = bool;
        if (j == m) {
          i = bool;
          if (k == n)
            i = getStatusBarHeight(paramActivity); 
        } 
        break;
      case 5:
        i = getHuaWeiNotchSize(paramActivity);
        break;
      case 4:
        m = Settings.Global.getInt(paramActivity.getApplicationContext().getContentResolver(), "force_black", 0);
        stringBuilder = new StringBuilder();
        stringBuilder.append("XiaoMi force_black = ");
        stringBuilder.append(m);
        Log.i("NotchWrapper", stringBuilder.toString());
        i = bool;
        if (m != 1)
          i = getXiaoMiNotchHeight(paramActivity); 
        break;
      case 2:
      case 3:
        i = getStatusBarHeight(paramActivity);
        break;
      case 1:
        i = notchSize;
        break;
    } 
    if (!this.isLogNotchSize) {
      this.isLogNotchSize = true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("return notch size = ");
      stringBuilder1.append(i);
      Log.i("NotchWrapper", stringBuilder1.toString());
    } 
    return i;
  }
  
  public void setNotchFullScreen(Activity paramActivity) {
    closeAndroidPDialog();
    if (openGoogleFullScreenModel(paramActivity)) {
      Log.i("NotchWrapper", "开启 google P 刘海全屏模式");
      return;
    } 
    ClassLoader classLoader = paramActivity.getApplication().getClassLoader();
    try {
      Class<?> clazz = classLoader.loadClass("android.util.FtFeature");
      if (clazz != null) {
        Method method = clazz.getMethod("isFeatureSupport", new Class[] { int.class });
        if (method != null && ((Boolean)method.invoke(clazz, new Object[] { Integer.valueOf(32) })).booleanValue() && setImmersionStatusBar(paramActivity)) {
          Log.i("NotchWrapper", "开启 Vivo 刘海全屏模式");
          return;
        } 
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      classNotFoundException.printStackTrace();
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private enum XNotchType {
    Google, HuaWei, Lenovo, None, Oppo, Samsung, Unkown, Vivo, XiaoMi;
    
    static {
      Vivo = new XNotchType("Vivo", 3);
      Oppo = new XNotchType("Oppo", 4);
      Lenovo = new XNotchType("Lenovo", 5);
      Samsung = new XNotchType("Samsung", 6);
      Google = new XNotchType("Google", 7);
      Unkown = new XNotchType("Unkown", 8);
      $VALUES = new XNotchType[] { None, HuaWei, XiaoMi, Vivo, Oppo, Lenovo, Samsung, Google, Unkown };
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\notchwrapper\NotchWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */