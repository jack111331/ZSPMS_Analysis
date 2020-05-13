package com.hu.scan.permission.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.a.aa;
import com.hu.scan.permission.c.d;
import com.hu.scan.permission.p;

public class a implements p {
  private static final String a = Build.MANUFACTURER.toLowerCase();
  
  private d b;
  
  public a(@aa d paramd) {
    this.b = paramd;
  }
  
  private static Intent a(Context paramContext) {
    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    intent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    return intent;
  }
  
  private static Intent b(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 23)
      return a(paramContext); 
    Intent intent = new Intent();
    intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
    return intent;
  }
  
  private Intent c() {
    return a.contains("huawei") ? b(this.b.a()) : (a.contains("xiaomi") ? c(this.b.a()) : (a.contains("oppo") ? e(this.b.a()) : (a.contains("vivo") ? d(this.b.a()) : (a.contains("samsung") ? h(this.b.a()) : (a.contains("meizu") ? f(this.b.a()) : (a.contains("smartisan") ? g(this.b.a()) : a(this.b.a())))))));
  }
  
  private static Intent c(Context paramContext) {
    Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    intent.putExtra("extra_pkgname", paramContext.getPackageName());
    return intent;
  }
  
  private static Intent d(Context paramContext) {
    ComponentName componentName;
    Intent intent = new Intent();
    intent.putExtra("packagename", paramContext.getPackageName());
    if (Build.VERSION.SDK_INT >= 25) {
      componentName = new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
    } else {
      componentName = new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
    } 
    intent.setComponent(componentName);
    return intent;
  }
  
  private static Intent e(Context paramContext) {
    return a(paramContext);
  }
  
  private static Intent f(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 25)
      return a(paramContext); 
    Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    intent.putExtra("packageName", paramContext.getPackageName());
    intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
    return intent;
  }
  
  private static Intent g(Context paramContext) {
    return a(paramContext);
  }
  
  private static Intent h(Context paramContext) {
    return a(paramContext);
  }
  
  public void a() {
    Intent intent = c();
    try {
      this.b.a(intent);
    } catch (Exception exception) {
      this.b.a(a(this.b.a()));
    } 
  }
  
  public void a(int paramInt) {
    Intent intent = c();
    try {
      this.b.a(intent, paramInt);
    } catch (Exception exception) {
      this.b.a(a(this.b.a()), paramInt);
    } 
  }
  
  public void b() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */