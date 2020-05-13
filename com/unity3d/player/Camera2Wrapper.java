package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;

public class Camera2Wrapper implements d {
  private Context a;
  
  private a b = null;
  
  private final int c = 100;
  
  public Camera2Wrapper(Context paramContext) {
    this.a = paramContext;
    initCamera2Jni();
  }
  
  private static int a(float paramFloat) {
    return (int)Math.min(Math.max(paramFloat * 2000.0F - 1000.0F, -900.0F), 900.0F);
  }
  
  private final native void initCamera2Jni();
  
  private final native void nativeFrameReady(Object paramObject1, Object paramObject2, Object paramObject3, int paramInt1, int paramInt2, int paramInt3);
  
  private final native void nativeSurfaceTextureReady(Object paramObject);
  
  public final void a() {
    closeCamera2();
  }
  
  public final void a(Object paramObject) {
    nativeSurfaceTextureReady(paramObject);
  }
  
  public final void a(Object paramObject1, Object paramObject2, Object paramObject3, int paramInt1, int paramInt2, int paramInt3) {
    nativeFrameReady(paramObject1, paramObject2, paramObject3, paramInt1, paramInt2, paramInt3);
  }
  
  protected void closeCamera2() {
    if (this.b != null)
      this.b.b(); 
    this.b = null;
  }
  
  protected int getCamera2Count() {
    return j.b ? a.a(this.a) : 0;
  }
  
  protected int[] getCamera2Resolutions(int paramInt) {
    return j.b ? a.d(this.a, paramInt) : null;
  }
  
  protected int getCamera2SensorOrientation(int paramInt) {
    return j.b ? a.a(this.a, paramInt) : 0;
  }
  
  protected Object getCameraFocusArea(float paramFloat1, float paramFloat2) {
    int i = a(paramFloat1);
    int j = a(1.0F - paramFloat2);
    return new Camera.Area(new Rect(i - 100, j - 100, i + 100, j + 100), 1000);
  }
  
  protected Rect getFrameSizeCamera2() {
    return (this.b != null) ? this.b.a() : new Rect();
  }
  
  protected boolean initializeCamera2(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (j.b && this.b == null && UnityPlayer.currentActivity != null) {
      this.b = new a(this);
      return this.b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    } 
    return false;
  }
  
  protected boolean isCamera2AutoFocusPointSupported(int paramInt) {
    return j.b ? a.c(this.a, paramInt) : false;
  }
  
  protected boolean isCamera2FrontFacing(int paramInt) {
    return j.b ? a.b(this.a, paramInt) : false;
  }
  
  protected void pauseCamera2() {
    if (this.b != null)
      this.b.d(); 
  }
  
  protected boolean setAutoFocusPoint(float paramFloat1, float paramFloat2) {
    return (j.b && this.b != null) ? this.b.a(paramFloat1, paramFloat2) : false;
  }
  
  protected void startCamera2() {
    if (this.b != null)
      this.b.c(); 
  }
  
  protected void stopCamera2() {
    if (this.b != null)
      this.b.e(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\Camera2Wrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */