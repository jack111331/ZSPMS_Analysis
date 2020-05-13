package com.UCMobile.PayPlugin;

import android.view.SurfaceHolder;

final class a implements SurfaceHolder.Callback {
  a(PluginSurfaceView paramPluginSurfaceView) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {
    synchronized (PluginSurfaceView.a(this.a)) {
      if (PluginSurfaceView.b(this.a))
        PluginSurfaceView.a(this.a, PluginSurfaceView.c(this.a), paramInt1, paramInt2, paramInt3); 
      return;
    } 
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    synchronized (PluginSurfaceView.a(this.a)) {
      if (PluginSurfaceView.b(this.a))
        PluginSurfaceView.a(this.a, PluginSurfaceView.c(this.a)); 
      return;
    } 
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    synchronized (PluginSurfaceView.a(this.a)) {
      if (PluginSurfaceView.b(this.a))
        PluginSurfaceView.b(this.a, PluginSurfaceView.c(this.a)); 
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\UCMobile\PayPlugin\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */