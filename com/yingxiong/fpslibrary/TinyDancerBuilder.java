package com.yingxiong.fpslibrary;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;

public class TinyDancerBuilder {
  private static Foreground.Listener foregroundListener = new Foreground.Listener() {
      public void onBecameBackground() {}
      
      public void onBecameForeground() {}
    };
  
  private static FPSConfig fpsConfig;
  
  private static FPSFrameCallback fpsFrameCallback;
  
  private static TinyCoach tinyCoach;
  
  protected TinyDancerBuilder() {
    fpsConfig = new FPSConfig();
  }
  
  protected static void hide(Context paramContext) {
    try {
      fpsFrameCallback.setEnabled(false);
      Foreground.get(paramContext).removeListener(foregroundListener);
      tinyCoach = null;
      fpsFrameCallback = null;
      fpsConfig = null;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private boolean overlayPermRequest(Context paramContext) {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(paramContext)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("package:");
      stringBuilder.append(paramContext.getPackageName());
      Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString()));
      intent.setFlags(268435456);
      paramContext.startActivity(intent);
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void setFrameRate(Context paramContext) {
    Display display = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    fpsConfig.deviceRefreshRateInMs = 1000.0F / display.getRefreshRate();
    fpsConfig.refreshRate = display.getRefreshRate();
  }
  
  public TinyDancerBuilder addFrameDataCallback(FrameDataCallback paramFrameDataCallback) {
    fpsConfig.frameDataCallback = paramFrameDataCallback;
    return this;
  }
  
  public TinyDancerBuilder redFlagPercentage(float paramFloat) {
    fpsConfig.redFlagPercentage = paramFloat;
    return this;
  }
  
  public void show(Context paramContext) {
    try {
      if (overlayPermRequest(paramContext))
        return; 
      if (tinyCoach != null)
        return; 
      setFrameRate(paramContext);
      TinyCoach tinyCoach = new TinyCoach();
      this();
      tinyCoach = tinyCoach;
      FPSFrameCallback fPSFrameCallback = new FPSFrameCallback();
      this(fpsConfig, tinyCoach);
      fpsFrameCallback = fPSFrameCallback;
      Choreographer.getInstance().postFrameCallback(fpsFrameCallback);
      Foreground.init((Application)paramContext.getApplicationContext()).addListener(foregroundListener);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public TinyDancerBuilder startingGravity(int paramInt) {
    fpsConfig.startingGravity = paramInt;
    fpsConfig.gravitySpecified = true;
    return this;
  }
  
  public TinyDancerBuilder startingXPosition(int paramInt) {
    fpsConfig.startingXPosition = paramInt;
    fpsConfig.xOrYSpecified = true;
    return this;
  }
  
  public TinyDancerBuilder startingYPosition(int paramInt) {
    fpsConfig.startingYPosition = paramInt;
    fpsConfig.xOrYSpecified = true;
    return this;
  }
  
  public TinyDancerBuilder yellowFlagPercentage(float paramFloat) {
    fpsConfig.yellowFlagPercentage = paramFloat;
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\fpslibrary\TinyDancerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */