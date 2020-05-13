package com.herosdk.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.bean.a;
import java.util.List;

class n implements Runnable {
  n(m paramm, Context paramContext) {}
  
  public void run() {
    Log.d("frameLib.diu", "=>cIAL");
    try {
      PackageManager packageManager = this.a.getPackageManager();
      List<PackageInfo> list = packageManager.getInstalledPackages(0);
      for (byte b = 0; b < list.size(); b++) {
        PackageInfo packageInfo = list.get(b);
        if ((packageInfo.applicationInfo.flags & 0x1) == 0) {
          a a = new a();
          this();
          a.a(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
          a.b(packageInfo.packageName);
          this.b.a.add(a);
        } 
      } 
    } catch (Exception exception) {
      Log.d("frameLib.diu", "=>cIAL...e");
      Log.d("frameLib.diu", "<=cIAL");
      return;
    } 
    m.a(this.b, 0);
    if (this.b.a.size() > 0) {
      a a = this.b.a.get(m.a(this.b));
      if (!TextUtils.isEmpty(a.b()))
        this.b.a(this.a, a.b()); 
    } 
    Log.d("frameLib.diu", "<=cIAL");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */