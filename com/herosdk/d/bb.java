package com.herosdk.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.activity.HulActivity;
import com.herosdk.activity.HupActivity;
import com.herosdk.activity.HuslActivity;
import com.herosdk.activity.HuspActivity;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ICommonListener;

public class bb {
  private static Handler a = new Handler(Looper.getMainLooper());
  
  private static final String b = "iatvd";
  
  public static int a(Context paramContext) {
    int i = 0;
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      int j = (packageManager.getPackageInfo(paramContext.getPackageName(), 0)).versionCode;
      i = j;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      ErrorUtils.printExceptionInfo((Throwable)nameNotFoundException);
    } 
    return i;
  }
  
  public static int a(Context paramContext, float paramFloat) {
    return (int)((paramContext.getResources().getDisplayMetrics()).density * paramFloat + 0.5F);
  }
  
  public static long a() {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static String a(String paramString) {
    String str = paramString;
    if (!paramString.contains("https:")) {
      str = paramString;
      if (paramString.contains("http:"))
        str = paramString.replace("http:", "https:"); 
    } 
    return str;
  }
  
  public static void a(int paramInt, ICommonListener paramICommonListener) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d("frameLib", stringBuilder.append("idSH:").append(paramInt).toString());
      bg bg = new bg();
      this(paramInt, paramICommonListener);
      a(bg);
    } catch (Exception exception) {
      Log.e("frameLib", "idSH e:" + exception.getMessage());
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void a(Activity paramActivity, String paramString, Boolean paramBoolean) {
    try {
      bc bc = new bc();
      this(paramActivity, paramString, paramBoolean);
      a(bc);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2) {
    try {
      be be = new be();
      this(paramActivity, paramString1, paramString2);
      a(be);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void a(Context paramContext, Boolean paramBoolean) {
    ax.a(paramContext, "iatvd", paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        Log.e("frameLib", "to hu login activity but url is empty");
        return;
      } 
      Intent intent = new Intent();
      this(paramContext, HuslActivity.class);
      if (!(paramContext instanceof Activity))
        intent.addFlags(268435456); 
      intent.putExtra("HU_WEB_URL", paramString);
      paramContext.startActivity(intent);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void a(Context paramContext, String paramString, Boolean paramBoolean) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        Log.e("frameLib", "to hu login activity but url is empty");
        return;
      } 
      Intent intent = new Intent();
      this(paramContext, HulActivity.class);
      if (!(paramContext instanceof Activity))
        intent.addFlags(268435456); 
      intent.putExtra("HU_WEB_URL", paramString);
      intent.putExtra("HU_WEB_FORCE", paramBoolean);
      paramContext.startActivity(intent);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static void a(Runnable paramRunnable) {
    try {
      if (b()) {
        paramRunnable.run();
        return;
      } 
      if (x.a().x() != null) {
        x.a().x().runOnUiThread(paramRunnable);
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    if (a != null)
      a.post((Runnable)exception); 
  }
  
  public static String b(Context paramContext) {
    String str;
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      str = (packageManager.getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      ErrorUtils.printExceptionInfo((Throwable)nameNotFoundException);
      str = "";
    } 
    return str;
  }
  
  public static void b(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        Log.e("frameLib", "to sdk web but url is empty");
        return;
      } 
      Intent intent = new Intent();
      this(paramContext, HupActivity.class);
      if (!(paramContext instanceof Activity))
        intent.addFlags(268435456); 
      intent.putExtra("HU_WEB_URL", paramString);
      paramContext.startActivity(intent);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  private static boolean b() {
    return (Thread.currentThread() == Looper.getMainLooper().getThread());
  }
  
  public static String c(Context paramContext) {
    String str;
    try {
      str = o.a((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64)).signatures[0].toByteArray());
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      ErrorUtils.printExceptionInfo((Throwable)nameNotFoundException);
      str = "";
    } 
    return str;
  }
  
  public static void c(Context paramContext, String paramString) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        Log.e("frameLib", "to sdk web but url is empty");
        return;
      } 
      Intent intent = new Intent();
      this(paramContext, HuspActivity.class);
      if (!(paramContext instanceof Activity))
        intent.addFlags(268435456); 
      intent.putExtra("HU_WEB_URL", paramString);
      paramContext.startActivity(intent);
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static String d(Context paramContext) {
    if (!((Boolean)ax.b(paramContext, "iatvd", Boolean.valueOf(false))).booleanValue()) {
      a(paramContext, Boolean.valueOf(true));
      return "1";
    } 
    return "0";
  }
  
  public static int e(Context paramContext) {
    boolean bool;
    try {
      Rect rect = new Rect();
      this();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
      int i = rect.top;
      bool = i;
      if (i == 0)
        try {
          Class<?> clazz = Class.forName("com.android.internal.R$dimen");
          Object object = clazz.newInstance();
          bool = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
          bool = paramContext.getResources().getDimensionPixelSize(bool);
        } catch (Exception exception) {} 
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */