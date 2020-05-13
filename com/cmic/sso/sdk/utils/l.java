package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class l {
  public static PackageInfo a(Context paramContext) {
    try {
      PackageInfo packageInfo = e(paramContext).getPackageInfo(paramContext.getPackageName(), 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      nameNotFoundException = null;
    } 
    return (PackageInfo)nameNotFoundException;
  }
  
  public static String b(Context paramContext) {
    null = a(paramContext);
    return (null != null) ? null.packageName : null;
  }
  
  public static String c(Context paramContext) {
    try {
      PackageManager packageManager = e(paramContext);
      String str3 = (String)packageManager.getApplicationLabel(packageManager.getApplicationInfo(b(paramContext), 0));
      if (str3 != null)
        return str3; 
      PackageInfo packageInfo = a(paramContext);
      if (packageInfo == null)
        return null; 
      int i = packageInfo.applicationInfo.labelRes;
      String str2 = paramContext.getResources().getString(i);
      String str1 = str2;
      return (str2 == null) ? null : str1;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String d(Context paramContext) {
    PackageInfo packageInfo = a(paramContext);
    return (packageInfo != null) ? (b(paramContext) + "&" + packageInfo.versionName) : null;
  }
  
  private static PackageManager e(Context paramContext) {
    return paramContext.getPackageManager();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */