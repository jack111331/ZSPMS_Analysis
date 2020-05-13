package com.hu.scan.permission.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.a.af;

class s implements o {
  private static final SensorEventListener b = new t();
  
  private Context a;
  
  s(Context paramContext) {
    this.a = paramContext;
  }
  
  @af(b = 20)
  public boolean a() {
    SensorManager sensorManager = (SensorManager)this.a.getSystemService("sensor");
    Sensor sensor = sensorManager.getDefaultSensor(21);
    if (sensor != null) {
      sensorManager.registerListener(b, sensor, 3);
      sensorManager.unregisterListener(b);
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */