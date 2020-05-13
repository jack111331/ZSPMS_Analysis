package com.hu.scan.permission.a;

import android.content.Context;
import android.location.LocationManager;
import android.support.a.ag;
import java.util.List;

class l implements o {
  private LocationManager a;
  
  l(Context paramContext) {
    this.a = (LocationManager)paramContext.getSystemService("location");
  }
  
  @ag(c = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"})
  public boolean a() {
    List list = this.a.getProviders(true);
    if (list.contains("gps"))
      return true; 
    if (list.contains("network"))
      return true; 
    this.a.requestLocationUpdates("gps", 0L, 0.0F, new m(this.a));
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */