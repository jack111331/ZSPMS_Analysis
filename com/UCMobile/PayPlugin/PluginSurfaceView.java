package com.UCMobile.PayPlugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.unionpay.mobile.android.resource.a;

public class PluginSurfaceView extends SurfaceView {
  SurfaceHolder a = null;
  
  Paint b = null;
  
  Bitmap c = null;
  
  int[] d = null;
  
  private final int e;
  
  private boolean f = true;
  
  private Object g = new Object();
  
  static {
    System.loadLibrary("ucpayplugin");
  }
  
  public PluginSurfaceView(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
    super(paramContext);
    this.a = getHolder();
    this.a.setFormat(1);
    this.b = new Paint();
    this.e = paramInt1;
    this.c = (new BitmapDrawable(a.class.getClassLoader().getResourceAsStream("res/drawable/mobilepayplugin.bin"))).getBitmap().copy(Bitmap.Config.ARGB_8888, false);
    getHolder().setFormat(-3);
    getHolder().setFormat(1);
    getHolder().addCallback(new a(this));
    getHolder().setSizeFromLayout();
    setWillNotDraw(false);
  }
  
  private native void nativeSurfaceChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeSurfaceCreated(int paramInt);
  
  private native void nativeSurfaceDestroyed(int paramInt);
  
  public int getIconHeight() {
    return (this.c != null) ? this.c.getHeight() : 0;
  }
  
  public int[] getIconPixels() {
    int i = 0;
    if (this.d != null)
      return this.d; 
    int j = this.c.getWidth();
    int k = this.c.getHeight();
    int m = this.c.getRowBytes() * k;
    int n = i;
    if (this.c != null) {
      this.d = new int[m];
      this.c.getPixels(this.d, 0, j, 0, 0, j, k);
      n = i;
    } 
    while (n < m) {
      j = this.d[n];
      i = this.d[n];
      this.d[n] = j >> 16 & 0xFF | i << 16 & 0xFF0000 | this.d[n] & 0xFF00FF00;
      n++;
    } 
    return this.d;
  }
  
  public int getIconRowBytes() {
    return (this.c != null) ? this.c.getRowBytes() : 0;
  }
  
  public int getIconWidth() {
    return (this.c != null) ? this.c.getWidth() : 0;
  }
  
  public void invalidateNPP() {
    synchronized (this.g) {
      this.f = false;
      return;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\UCMobile\PayPlugin\PluginSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */