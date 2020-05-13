package com.hu.scan.permission.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

public abstract class d {
  public abstract Context a();
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Intent paramIntent, int paramInt);
  
  public final boolean a(String paramString) {
    if (Build.VERSION.SDK_INT < 23)
      return false; 
    PackageManager packageManager = a().getPackageManager();
    Class<?> clazz = packageManager.getClass();
    try {
      Method method = clazz.getMethod("shouldShowRequestPermissionRationale", new Class[] { String.class });
      if (!method.isAccessible())
        method.setAccessible(true); 
      return ((Boolean)method.invoke(packageManager, new Object[] { paramString })).booleanValue();
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */