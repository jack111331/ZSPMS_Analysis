package com.xy.whf.helper;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.ActivityCompat;
import com.xy.whf.base.RootActivity;

public class PermissionHelper {
  public static void a(RootActivity paramRootActivity, PermissionCallBack paramPermissionCallBack) {
    paramRootActivity.applySinglePermission(60003, "android.permission.ACCESS_FINE_LOCATION", paramPermissionCallBack);
  }
  
  @TargetApi(23)
  public static void a(RootActivity paramRootActivity, PermissionCallBack paramPermissionCallBack, String... paramVarArgs) {
    paramRootActivity.applyMultiplyPermissions(60001, paramVarArgs, paramPermissionCallBack);
  }
  
  public static boolean a(Context paramContext) {
    boolean bool;
    try {
      bool = ((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps");
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool = true;
    null = bool;
    if (Build.VERSION.SDK_INT >= 23) {
      if (ActivityCompat.checkSelfPermission(paramContext, paramString) == 0)
        return bool; 
    } else {
      return null;
    } 
    return false;
  }
  
  @TargetApi(23)
  public static void b(RootActivity paramRootActivity, PermissionCallBack paramPermissionCallBack) {
    paramRootActivity.applySinglePermission(60004, "android.permission.READ_CONTACTS", paramPermissionCallBack);
  }
  
  public static boolean b(Context paramContext) {
    boolean bool1 = true;
    boolean bool2 = bool1;
    try {
      if (Build.VERSION.SDK_INT >= 23) {
        boolean bool3 = Build.MANUFACTURER.equalsIgnoreCase("Xiaomi");
        boolean bool4 = b(paramContext, "android:read_sms");
        bool2 = a(paramContext, "android.permission.READ_SMS");
        if (bool3) {
          if (bool4 && bool2)
            return bool1; 
        } else {
          return bool2;
        } 
      } else {
        return bool2;
      } 
      bool2 = false;
    } catch (Exception exception) {
      exception.printStackTrace();
      bool2 = false;
    } 
    return bool2;
  }
  
  public static boolean b(Context paramContext, String paramString) {
    if (Build.VERSION.SDK_INT >= 23) {
      boolean bool;
      try {
        AppOpsManager appOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
        if (AppOpsManager.permissionToOp(paramString) == null) {
          boolean bool1 = true;
        } else {
          boolean bool1 = false;
        } 
        if (appOpsManager != null) {
          int i = appOpsManager.checkOp(paramString, Process.myUid(), paramContext.getPackageName());
          if (i == 0)
            return true; 
        } else {
          return SYNTHETIC_LOCAL_VARIABLE_3;
        } 
        bool = false;
      } catch (Exception exception) {
        exception.printStackTrace();
        bool = false;
      } 
      return bool;
    } 
    return true;
  }
  
  @TargetApi(23)
  public static void c(RootActivity paramRootActivity, PermissionCallBack paramPermissionCallBack) {
    paramRootActivity.applySinglePermission(60005, "android.permission.READ_CALL_LOG", paramPermissionCallBack);
  }
  
  @TargetApi(23)
  public static void d(RootActivity paramRootActivity, PermissionCallBack paramPermissionCallBack) {
    paramRootActivity.applySinglePermission(60006, "android.permission.READ_SMS", paramPermissionCallBack);
  }
  
  public static void e(RootActivity paramRootActivity, PermissionCallBack paramPermissionCallBack) {
    paramRootActivity.openGps(50001, paramPermissionCallBack);
  }
  
  public static interface PermissionCallBack {
    void result(int param1Int1, int param1Int2, String param1String);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\PermissionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */