package com.zz.sdk.i;

import android.content.Context;
import android.os.Handler;
import com.zz.sdk.SDKManager;
import java.lang.ref.WeakReference;

public class co {
  private static final Object a = new Object();
  
  private static WeakReference f = null;
  
  private Context b = null;
  
  private SDKManager c = null;
  
  private String d = null;
  
  private Handler e;
  
  public static co a() {
    synchronized (a) {
      if (f == null)
        return null; 
      return f.get();
    } 
  }
  
  public static co a(Context paramContext, SDKManager paramSDKManager) {
    synchronized (a) {
      co co1;
      if (f == null) {
        co1 = null;
      } else {
        co1 = f.get();
      } 
      co co2 = co1;
      if (co1 == null) {
        co2 = new co();
        this();
        WeakReference weakReference = new WeakReference();
        this((T)co2);
        f = weakReference;
      } 
      co2.b(paramContext, paramSDKManager);
      return co2;
    } 
  }
  
  private void b(Context paramContext, SDKManager paramSDKManager) {
    this.b = paramContext;
    this.c = paramSDKManager;
    this.e = new Handler(this.b.getMainLooper());
  }
  
  private void c() {}
  
  public void a(String paramString) {
    synchronized (a) {
      this.d = paramString;
      return;
    } 
  }
  
  public void b() {
    synchronized (a) {
      this.b = null;
      this.c = null;
      if (f != null && f.get() == this)
        f = null; 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */