package com.tencent.tp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Set;
import java.util.TreeSet;

public class l implements SensorEventListener {
  private static volatile l a;
  
  private SensorManager b;
  
  private boolean c;
  
  private int d;
  
  private Set e = new TreeSet();
  
  public static l a() {
    // Byte code:
    //   0: getstatic com/tencent/tp/l.a : Lcom/tencent/tp/l;
    //   3: ifnonnull -> 39
    //   6: ldc com/tencent/tp/l
    //   8: monitorenter
    //   9: getstatic com/tencent/tp/l.a : Lcom/tencent/tp/l;
    //   12: ifnonnull -> 27
    //   15: new com/tencent/tp/l
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/tencent/tp/l.a : Lcom/tencent/tp/l;
    //   27: ldc com/tencent/tp/l
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/tencent/tp/l
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/tencent/tp/l.a : Lcom/tencent/tp/l;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  public void a(Context paramContext) {
    if (this.c)
      return; 
    this.c = true;
    try {
      SensorManager sensorManager = (SensorManager)paramContext.getSystemService("sensor");
      if (sensorManager == null)
        return; 
      this.b = sensorManager;
      this.d = 0;
      sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
    } catch (Throwable throwable) {
      u.a("Init SensorManager failed");
    } 
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    float[] arrayOfFloat = paramSensorEvent.values;
    if (arrayOfFloat == null || arrayOfFloat.length < 3) {
      this.b.unregisterListener(this);
      return;
    } 
    int i = (int)(arrayOfFloat[2] * 10.0F);
    this.e.add(Integer.valueOf(i));
    i = this.d;
    this.d = i + 1;
    if (i > 1024 || (this.d > 64 && this.e.size() > 12)) {
      this.b.unregisterListener(this);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SensorCnt:");
      stringBuilder.append(this.e.size());
      stringBuilder.append(" ChangeCnt:");
      stringBuilder.append(this.d);
      if (this.d > 1000)
        u.a("SensorChangeTooMuch"); 
      try {
        u.c(stringBuilder.toString());
      } catch (Throwable throwable) {}
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */