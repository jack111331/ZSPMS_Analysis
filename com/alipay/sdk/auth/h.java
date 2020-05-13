package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.alipay.sdk.data.c;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.widget.a;

public final class h {
  private static final String a = "com.eg.android.AlipayGphone";
  
  private static final int b = 65;
  
  private static a c = null;
  
  private static String d = null;
  
  public static void a(Activity paramActivity, APAuthInfo paramAPAuthInfo) {
    b b = b.a();
    c.a();
    b.a((Context)paramActivity);
    if (a((Context)paramActivity)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("alipayauth://platformapi/startapp");
      stringBuilder1.append("?appId=20000122");
      stringBuilder1.append("&approveType=005");
      stringBuilder1.append("&scope=kuaijie");
      stringBuilder1.append("&productId=");
      stringBuilder1.append(paramAPAuthInfo.getProductId());
      stringBuilder1.append("&thirdpartyId=");
      stringBuilder1.append(paramAPAuthInfo.getAppId());
      stringBuilder1.append("&redirectUri=");
      stringBuilder1.append(paramAPAuthInfo.getRedirectUri());
      a(paramActivity, stringBuilder1.toString());
      return;
    } 
    if (paramActivity != null)
      try {
        if (!paramActivity.isFinishing()) {
          a a1 = new a();
          this(paramActivity, "正在加载");
          c = a1;
          a1.a();
        } 
      } catch (Exception exception) {
        c = null;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("app_id=");
    stringBuilder.append(paramAPAuthInfo.getAppId());
    stringBuilder.append("&partner=");
    stringBuilder.append(paramAPAuthInfo.getPid());
    stringBuilder.append("&scope=kuaijie");
    stringBuilder.append("&login_goal=auth");
    stringBuilder.append("&redirect_url=");
    stringBuilder.append(paramAPAuthInfo.getRedirectUri());
    stringBuilder.append("&view=wap");
    stringBuilder.append("&prod_code=");
    stringBuilder.append(paramAPAuthInfo.getProductId());
    (new Thread(new i(paramActivity, stringBuilder, paramAPAuthInfo))).start();
  }
  
  public static void a(Activity paramActivity, String paramString) {
    try {
      Intent intent = new Intent();
      this("android.intent.action.VIEW");
      intent.setData(Uri.parse(paramString));
      paramActivity.startActivity(intent);
    } catch (ActivityNotFoundException activityNotFoundException) {}
  }
  
  private static boolean a(Context paramContext) {
    boolean bool = false;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
      if (packageInfo != null) {
        int i = packageInfo.versionCode;
        if (i >= 65)
          bool = true; 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return bool;
  }
  
  private static void b(Activity paramActivity, APAuthInfo paramAPAuthInfo) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("alipayauth://platformapi/startapp");
    stringBuilder.append("?appId=20000122");
    stringBuilder.append("&approveType=005");
    stringBuilder.append("&scope=kuaijie");
    stringBuilder.append("&productId=");
    stringBuilder.append(paramAPAuthInfo.getProductId());
    stringBuilder.append("&thirdpartyId=");
    stringBuilder.append(paramAPAuthInfo.getAppId());
    stringBuilder.append("&redirectUri=");
    stringBuilder.append(paramAPAuthInfo.getRedirectUri());
    a(paramActivity, stringBuilder.toString());
  }
  
  private static void c(Activity paramActivity, APAuthInfo paramAPAuthInfo) {
    if (paramActivity != null)
      try {
        if (!paramActivity.isFinishing()) {
          a a1 = new a();
          this(paramActivity, "正在加载");
          c = a1;
          a1.a();
        } 
      } catch (Exception exception) {
        c = null;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("app_id=");
    stringBuilder.append(paramAPAuthInfo.getAppId());
    stringBuilder.append("&partner=");
    stringBuilder.append(paramAPAuthInfo.getPid());
    stringBuilder.append("&scope=kuaijie");
    stringBuilder.append("&login_goal=auth");
    stringBuilder.append("&redirect_url=");
    stringBuilder.append(paramAPAuthInfo.getRedirectUri());
    stringBuilder.append("&view=wap");
    stringBuilder.append("&prod_code=");
    stringBuilder.append(paramAPAuthInfo.getProductId());
    (new Thread(new i(paramActivity, stringBuilder, paramAPAuthInfo))).start();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */