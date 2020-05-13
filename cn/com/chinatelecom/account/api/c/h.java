package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.ArrayList;

public class h {
  public static String[] a = new String[] { "android.permission.READ_PHONE_STATE" };
  
  public static boolean a(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 23)
      try {
        boolean bool = a(paramContext, a);
        if (bool)
          return false; 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return true;
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null) {
      bool2 = bool1;
      if (paramArrayOfString != null) {
        if (paramArrayOfString.length <= 0)
          return bool1; 
      } else {
        return bool2;
      } 
    } else {
      return bool2;
    } 
    PackageManager packageManager = paramContext.getPackageManager();
    ArrayList<String> arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayOfString.length; b++) {
      if (-1 == packageManager.checkPermission(paramArrayOfString[b], paramContext.getPackageName()))
        arrayList.add(paramArrayOfString[b]); 
    } 
    bool2 = bool1;
    if (!arrayList.isEmpty())
      bool2 = true; 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */