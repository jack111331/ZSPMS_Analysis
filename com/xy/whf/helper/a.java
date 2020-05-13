package com.xy.whf.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xy.whf.pay.b;
import org.json.JSONObject;

public class a {
  public static JSONObject a(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("app_version", b(paramContext));
      jSONObject.put("app_package_name", c(paramContext));
      jSONObject.put("app_name", d(paramContext));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONObject;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    boolean bool = false;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (packageInfo != null)
        bool = true; 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return bool;
  }
  
  public static String b(Context paramContext) {
    String str;
    try {
      str = (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String c(Context paramContext) {
    return paramContext.getPackageName();
  }
  
  public static String d(Context paramContext) {
    return paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo()).toString();
  }
  
  public static String e(Context paramContext) {
    String str = j.a(paramContext, "WHF_APP_ID");
    if (LangHelper.isNullOrEmpty(str))
      throw new b("whfAppId不存在"); 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */