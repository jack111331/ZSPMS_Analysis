package com.yingxiong.fpslibrary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Foreground implements Application.ActivityLifecycleCallbacks {
  public static final long CHECK_DELAY = 1000L;
  
  public static final String TAG = "com.yingxiong.fpslibrary.Foreground";
  
  private static Foreground instance;
  
  private Runnable check;
  
  private boolean foreground = true;
  
  private Handler handler = new Handler();
  
  private List<Listener> listeners = new CopyOnWriteArrayList<Listener>();
  
  private boolean paused = true;
  
  public static Foreground get() {
    if (instance != null)
      return instance; 
    throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameterised init/get");
  }
  
  public static Foreground get(Application paramApplication) {
    if (instance == null)
      init(paramApplication); 
    return instance;
  }
  
  public static Foreground get(Context paramContext) {
    if (instance == null) {
      paramContext = paramContext.getApplicationContext();
      if (paramContext instanceof Application)
        init((Application)paramContext); 
      throw new IllegalStateException("Foreground is not initialised and cannot obtain the Application object");
    } 
    return instance;
  }
  
  public static Foreground init(Application paramApplication) {
    if (instance == null) {
      instance = new Foreground();
      paramApplication.registerActivityLifecycleCallbacks(instance);
    } 
    return instance;
  }
  
  public void addListener(Listener paramListener) {
    this.listeners.add(paramListener);
  }
  
  public boolean isBackground() {
    return this.foreground ^ true;
  }
  
  public boolean isForeground() {
    return this.foreground;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {
    this.paused = true;
    if (this.check != null)
      this.handler.removeCallbacks(this.check); 
    Handler handler = this.handler;
    Runnable runnable = new Runnable() {
        public void run() {
          if (Foreground.this.foreground && Foreground.this.paused) {
            Foreground.access$002(Foreground.this, false);
            Log.i(Foreground.TAG, "went background");
            for (Foreground.Listener listener : Foreground.this.listeners) {
              try {
                listener.onBecameBackground();
              } catch (Exception exception) {
                Log.e(Foreground.TAG, "Listener threw exception!", exception);
              } 
            } 
          } else {
            Log.i(Foreground.TAG, "still foreground");
          } 
          Log.e("andly", "still foreground");
        }
      };
    this.check = runnable;
    handler.postDelayed(runnable, 1000L);
  }
  
  public void onActivityResumed(Activity paramActivity) {
    this.paused = false;
    boolean bool = this.foreground;
    this.foreground = true;
    if (this.check != null)
      this.handler.removeCallbacks(this.check); 
    if ((bool ^ true) != 0) {
      Log.i(TAG, "went foreground");
      for (Listener listener : this.listeners) {
        try {
          listener.onBecameForeground();
        } catch (Exception exception) {
          Log.e(TAG, "Listener threw exception!", exception);
        } 
      } 
    } else {
      Log.e(TAG, "still foreground");
    } 
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void removeListener(Listener paramListener) {
    this.listeners.remove(paramListener);
  }
  
  public static interface Listener {
    void onBecameBackground();
    
    void onBecameForeground();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\fpslibrary\Foreground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */