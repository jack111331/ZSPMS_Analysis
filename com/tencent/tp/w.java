package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class w {
  private static List a;
  
  public static boolean a(Context paramContext, String paramString) {
    if (a == null) {
      ArrayList<String> arrayList = new ArrayList();
      PackageManager packageManager = paramContext.getPackageManager();
      try {
        String[] arrayOfString = (packageManager.getPackageInfo(paramContext.getPackageName(), 4096)).requestedPermissions;
        if (arrayOfString == null)
          return false; 
        for (byte b = 0; b < arrayOfString.length; b++)
          arrayList.add(arrayOfString[b]); 
      } catch (Throwable throwable) {
        arrayList.clear();
      } 
      a = arrayList;
    } 
    Iterator<String> iterator = a.iterator();
    while (iterator.hasNext()) {
      if (((String)iterator.next()).compareTo(paramString) == 0)
        return true; 
    } 
    return false;
  }
  
  public static boolean b(Context paramContext, String paramString) {
    Method method2;
    if (Build.VERSION.SDK_INT < 23)
      return true; 
    Method[] arrayOfMethod = paramContext.getClass().getMethods();
    Method method1 = null;
    int i = 0;
    while (true) {
      method2 = method1;
      if (i < arrayOfMethod.length) {
        if (arrayOfMethod[i].getName().equals("checkSelfPermission")) {
          method2 = arrayOfMethod[i];
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (method2 != null)
      try {
        Object object = method2.invoke(paramContext, new Object[] { paramString });
        if (object instanceof Integer) {
          i = ((Integer)object).intValue();
          if (i == 0)
            return true; 
        } 
      } catch (Throwable throwable) {} 
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */