package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.UUID;

public class ac {
  public static String a() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    a(paramContext, "com.cmic.sso.sdk.activity.LoginAuthActivity", paramBundle);
  }
  
  private static void a(Context paramContext, String paramString, Bundle paramBundle) {
    Intent intent = new Intent();
    intent.setClassName(paramContext, paramString);
    intent.putExtras(paramBundle);
    intent.setFlags(268435456);
    paramContext.startActivity(intent);
  }
  
  public static String b() {
    return c().replace("-", "");
  }
  
  public static void b(Context paramContext, Bundle paramBundle) {
    a(paramContext, "com.cmic.sso.sdk.activity.OAuthActivity", paramBundle);
  }
  
  private static String c() {
    return UUID.randomUUID().toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */