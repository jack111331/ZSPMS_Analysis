package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public final class h implements e {
  private static boolean a(PackageItemInfo paramPackageItemInfo) {
    try {
      return paramPackageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public final void a(Activity paramActivity, String paramString) {
    if (paramActivity != null && paramString != null) {
      FragmentManager fragmentManager = paramActivity.getFragmentManager();
      if (fragmentManager.findFragmentByTag("96489") == null) {
        i i = new i();
        Bundle bundle = new Bundle();
        bundle.putString("PermissionNames", paramString);
        i.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(0, i, "96489");
        fragmentTransaction.commit();
      } 
    } 
  }
  
  public final boolean a(Activity paramActivity) {
    try {
      PackageManager packageManager = paramActivity.getPackageManager();
      ActivityInfo activityInfo = packageManager.getActivityInfo(paramActivity.getComponentName(), 128);
      ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramActivity.getPackageName(), 128);
      if (!a((PackageItemInfo)activityInfo)) {
        boolean bool = a((PackageItemInfo)applicationInfo);
        if (bool)
          return true; 
      } else {
        return true;
      } 
    } catch (Exception exception) {}
    return false;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */