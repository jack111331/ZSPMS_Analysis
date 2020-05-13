package com.hu.zxlib.b;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

final class g implements Camera.PreviewCallback {
  private static final String a = "g";
  
  private final d b;
  
  private Handler c;
  
  private int d;
  
  g(d paramd) {
    this.b = paramd;
  }
  
  void a(Handler paramHandler, int paramInt) {
    this.c = paramHandler;
    this.d = paramInt;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfbyte, Camera paramCamera) {
    Point point = this.b.a();
    Handler handler = this.c;
    if (point != null && handler != null) {
      handler.obtainMessage(this.d, point.x, point.y, paramArrayOfbyte).sendToTarget();
      this.c = null;
    } else {
      Log.d(a, "Got preview callback, but no handler or resolution available");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */