package com.hu.scan.permission.a;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class f implements o {
  private static final Camera.PreviewCallback b = new g();
  
  private static final SurfaceHolder.Callback c = new h();
  
  private SurfaceHolder a;
  
  f(Context paramContext) {
    this.a = (new SurfaceView(paramContext)).getHolder();
    this.a.addCallback(c);
  }
  
  public boolean a() {
    Camera camera;
    Exception exception;
    try {
      camera = Camera.open();
    } finally {
      exception = null;
    } 
    if (camera != null) {
      camera.stopPreview();
      camera.setPreviewDisplay(null);
      camera.setPreviewCallback(null);
      camera.release();
    } 
    throw exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */