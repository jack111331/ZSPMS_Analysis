package com.zz.sdk.floatdlg.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class a implements SensorEventListener {
  private static final int a = 5000;
  
  private static final int b = 50;
  
  private SensorManager c;
  
  private Sensor d;
  
  private b e;
  
  private Context f;
  
  private float g;
  
  private float h;
  
  private float i;
  
  private long j;
  
  public a(Context paramContext) {
    this.f = paramContext;
    try {
      a();
    } catch (Exception exception) {}
  }
  
  public void a() {
    this.c = (SensorManager)this.f.getSystemService("sensor");
    if (this.c != null)
      this.d = this.c.getDefaultSensor(1); 
    if (this.d != null)
      this.c.registerListener(this, this.d, 1); 
  }
  
  public void a(b paramb) {
    this.e = paramb;
  }
  
  public void b() {
    this.c.unregisterListener(this);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.j;
    if (l2 >= 50L) {
      this.j = l1;
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      float f4 = f1 - this.g;
      float f5 = f2 - this.h;
      float f6 = f3 - this.i;
      this.g = f1;
      this.h = f2;
      this.i = f3;
      if (Math.sqrt((f4 * f4 + f5 * f5 + f6 * f6)) / l2 * 10000.0D >= 5000.0D && this.e != null)
        this.e.a(); 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */