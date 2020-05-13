package com.hu.scan.permission.a;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

class m implements LocationListener {
  private LocationManager a;
  
  public m(LocationManager paramLocationManager) {
    this.a = paramLocationManager;
  }
  
  public void onLocationChanged(Location paramLocation) {
    this.a.removeUpdates(this);
  }
  
  public void onProviderDisabled(String paramString) {
    this.a.removeUpdates(this);
  }
  
  public void onProviderEnabled(String paramString) {
    this.a.removeUpdates(this);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {
    this.a.removeUpdates(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */