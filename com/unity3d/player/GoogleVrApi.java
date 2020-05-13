package com.unity3d.player;

import java.util.concurrent.atomic.AtomicReference;

public class GoogleVrApi {
  private static AtomicReference a = new AtomicReference();
  
  static void a() {
    a.set(null);
  }
  
  static void a(f paramf) {
    a.compareAndSet(null, new GoogleVrProxy(paramf));
  }
  
  static GoogleVrProxy b() {
    return a.get();
  }
  
  public static GoogleVrVideo getGoogleVrVideo() {
    return a.get();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\GoogleVrApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */