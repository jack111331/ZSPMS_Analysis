package com.herosdk.channel.hero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.herosdk.base.ILifecycleBase;
import com.zz.sdk.SDKManager;

public class Lifecycle implements ILifecycleBase {
  public static String a = Sdk.c + "lifecycle";
  
  private static volatile Lifecycle b;
  
  public static Lifecycle getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/channel/hero/Lifecycle.b : Lcom/herosdk/channel/hero/Lifecycle;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/channel/hero/Lifecycle
    //   8: monitorenter
    //   9: getstatic com/herosdk/channel/hero/Lifecycle.b : Lcom/herosdk/channel/hero/Lifecycle;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/channel/hero/Lifecycle
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/channel/hero/Lifecycle.b : Lcom/herosdk/channel/hero/Lifecycle;
    //   27: ldc com/herosdk/channel/hero/Lifecycle
    //   29: monitorexit
    //   30: getstatic com/herosdk/channel/hero/Lifecycle.b : Lcom/herosdk/channel/hero/Lifecycle;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/channel/hero/Lifecycle
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    Log.d(a, "onActivityResult");
  }
  
  public void onApplicationInit(Context paramContext) {
    Log.d(a, "onApplicationInit");
  }
  
  public void onCreate(Activity paramActivity) {
    Log.d(a, "onCreate");
  }
  
  public void onDestroy(Activity paramActivity) {
    Log.d(a, "onDestroy");
    if (SDKManager.isShowFloat())
      SDKManager.tryDestroyFloat(paramActivity); 
    SDKManager.recycle((Context)paramActivity);
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent) {
    Log.d(a, "onNewIntent");
  }
  
  public void onPause(Activity paramActivity) {
    Log.d(a, "onPause");
  }
  
  public void onRestart(Activity paramActivity) {
    Log.d(a, "onRestart");
  }
  
  public void onResume(Activity paramActivity) {
    Log.d(a, "onResume");
  }
  
  public void onStart(Activity paramActivity) {
    Log.d(a, "onStart");
  }
  
  public void onStop(Activity paramActivity) {
    Log.d(a, "onStop");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Lifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */