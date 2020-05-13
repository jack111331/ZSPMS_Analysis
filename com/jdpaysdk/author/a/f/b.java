package com.jdpaysdk.author.a.f;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b {
  private static final b a = c();
  
  public static b a() {
    return a;
  }
  
  private static b c() {
    try {
      Class.forName("android.os.Build");
      if (Build.VERSION.SDK_INT != 0) {
        c c = new c();
        this();
        return c;
      } 
    } catch (ClassNotFoundException classNotFoundException) {}
    return new b();
  }
  
  public void a(Runnable paramRunnable) {
    b().execute(paramRunnable);
  }
  
  public Executor b() {
    return Executors.newCachedThreadPool();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\a\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */