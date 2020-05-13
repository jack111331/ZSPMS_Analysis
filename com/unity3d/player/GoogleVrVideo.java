package com.unity3d.player;

import android.view.Surface;

public interface GoogleVrVideo {
  void deregisterGoogleVrVideoListener(GoogleVrVideoCallbacks paramGoogleVrVideoCallbacks);
  
  void registerGoogleVrVideoListener(GoogleVrVideoCallbacks paramGoogleVrVideoCallbacks);
  
  void setVideoLocationTransform(float[] paramArrayOffloat);
  
  public static interface GoogleVrVideoCallbacks {
    void onFrameAvailable();
    
    void onSurfaceAvailable(Surface param1Surface);
    
    void onSurfaceUnavailable();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\GoogleVrVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */