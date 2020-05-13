package com.hu.zxlib.b;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.util.Log;

public final class f {
  private static final String a = "com.hu.zxlib.b.f";
  
  public static Camera a() {
    return a(-1);
  }
  
  @SuppressLint({"NewApi"})
  public static Camera a(int paramInt) {
    Camera camera;
    boolean bool;
    int i = Camera.getNumberOfCameras();
    StringBuilder stringBuilder = null;
    if (i == 0) {
      Log.w(a, "No cameras!");
      return null;
    } 
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    int j = paramInt;
    if (!bool) {
      paramInt = 0;
      while (true) {
        j = paramInt;
        if (paramInt < i) {
          Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(paramInt, cameraInfo);
          if (cameraInfo.facing == 0) {
            j = paramInt;
            break;
          } 
          paramInt++;
          continue;
        } 
        break;
      } 
    } 
    if (j < i) {
      String str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Opening camera #");
      stringBuilder.append(j);
      Log.i(str, stringBuilder.toString());
      camera = Camera.open(j);
    } else if (bool) {
      String str = a;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Requested camera does not exist: ");
      stringBuilder1.append(j);
      Log.w(str, stringBuilder1.toString());
    } else {
      Log.i(a, "No camera facing back; returning camera #0");
      camera = Camera.open(0);
    } 
    return camera;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */