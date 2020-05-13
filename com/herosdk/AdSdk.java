package com.herosdk;

import android.app.Activity;
import android.util.Log;
import com.herosdk.d.a;

public class AdSdk {
  private static final String a = "frameLib.AdSdk";
  
  private static volatile AdSdk b = null;
  
  public static AdSdk getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/AdSdk.b : Lcom/herosdk/AdSdk;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/AdSdk
    //   8: monitorenter
    //   9: getstatic com/herosdk/AdSdk.b : Lcom/herosdk/AdSdk;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/AdSdk
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/AdSdk.b : Lcom/herosdk/AdSdk;
    //   27: ldc com/herosdk/AdSdk
    //   29: monitorexit
    //   30: getstatic com/herosdk/AdSdk.b : Lcom/herosdk/AdSdk;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/AdSdk
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void hideBanner(Activity paramActivity) {
    Log.d("frameLib.AdSdk", "hideBanner 1p");
    a.a().b(paramActivity);
  }
  
  public void hideBanner(Activity paramActivity, String paramString) {
    Log.d("frameLib.AdSdk", "hideBanner 2p");
    a.a().b(paramActivity, paramString);
  }
  
  public void showAdSplash(Activity paramActivity) {
    Log.d("frameLib.AdSdk", "showAdSplash 1p");
    a.a().d(paramActivity);
  }
  
  public void showAdSplash(Activity paramActivity, String paramString) {
    Log.d("frameLib.AdSdk", "showAdSplash 2p");
    a.a().d(paramActivity, paramString);
  }
  
  public void showAdVideo(Activity paramActivity) {
    Log.d("frameLib.AdSdk", "showAdVideo 1p");
    a.a().e(paramActivity);
  }
  
  public void showAdVideo(Activity paramActivity, String paramString) {
    Log.d("frameLib.AdSdk", "showAdVideo 2p");
    a.a().e(paramActivity, paramString);
  }
  
  public void showBanner(Activity paramActivity) {
    Log.d("frameLib.AdSdk", "showBanner 1p");
    a.a().a(paramActivity);
  }
  
  public void showBanner(Activity paramActivity, String paramString) {
    Log.d("frameLib.AdSdk", "showBanner 2p");
    a.a().a(paramActivity, paramString);
  }
  
  public void showInterstialBanner(Activity paramActivity) {
    Log.d("frameLib.AdSdk", "showInterstialBanner 1p");
    a.a().c(paramActivity);
  }
  
  public void showInterstialBanner(Activity paramActivity, String paramString) {
    Log.d("frameLib.AdSdk", "showInterstialBanner 2p");
    a.a().c(paramActivity, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\AdSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */