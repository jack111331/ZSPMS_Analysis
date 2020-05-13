package com.bun.miitmdid.c.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Keep;
import com.zui.deviceidservice.IDeviceidInterface;

@Keep
public class a {
  @Keep
  private static String e = "OpenDeviceId library";
  
  @Keep
  private static boolean f;
  
  @Keep
  private Context a = null;
  
  @Keep
  private IDeviceidInterface b;
  
  @Keep
  private ServiceConnection c;
  
  @Keep
  private com.bun.miitmdid.c.e.a d;
  
  @Keep
  public a(Context paramContext, com.bun.miitmdid.c.e.a parama) {
    if (paramContext != null) {
      this.a = paramContext;
      this.d = parama;
      this.c = new a(this);
      Intent intent = new Intent();
      intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
      if (this.a.bindService(intent, this.c, 1)) {
        b("bindService Successful!");
      } else {
        b("bindService Failed!");
        com.bun.miitmdid.c.e.a a1 = this.d;
        if (a1 != null)
          a1.b(); 
      } 
      return;
    } 
    throw new NullPointerException("Context can not be null.");
  }
  
  @Keep
  private native void a(String paramString);
  
  @Keep
  private native void b(String paramString);
  
  @Keep
  public native String a();
  
  @Keep
  public native String b();
  
  @Keep
  public native String c();
  
  @Keep
  public native String d();
  
  @Keep
  public native boolean e();
  
  @Keep
  public native void f();
  
  @Keep
  class a implements ServiceConnection {
    @Keep
    a(a this$0) {}
    
    @Keep
    public synchronized native void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder);
    
    @Keep
    public native void onServiceDisconnected(ComponentName param1ComponentName);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\miitmdid\c\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */