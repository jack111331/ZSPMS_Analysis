package com.haru.herousdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.herosdk.SdkSplashActivity;

public class SplashActivity extends SdkSplashActivity {
  private long StartTime = 0L;
  
  public void doSplashInit(Activity paramActivity) {
    super.doSplashInit(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle) {
    this.StartTime = System.currentTimeMillis();
    super.onCreate(paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onSplashStop() {
    startActivity(new Intent((Context)this, MainActivity.class));
    finish();
    System.currentTimeMillis();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\haru\herousdk\SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */