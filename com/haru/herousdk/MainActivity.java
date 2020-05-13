package com.haru.herousdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.herosdk.HeroSdk;
import com.kurogame.herobdc.BdcActivity;
import com.kurogame.notchwrapper.NotchWrapper;

public class MainActivity extends BdcActivity {
  private static MainActivity mainActivity;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    HeroSdk.getInstance().onActivityResult((Activity)this, paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle) {
    (new NotchWrapper()).setNotchFullScreen((Activity)this);
    super.onCreate(paramBundle);
    mainActivity = this;
    HeroSdk.getInstance().onCreate((Activity)this);
    HeroSdKAgent.Init((Activity)this);
  }
  
  public void onDestroy() {
    super.onDestroy();
    HeroSdk.getInstance().onDestroy((Activity)this);
  }
  
  public void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    HeroSdk.getInstance().onNewIntent((Activity)this, paramIntent);
  }
  
  public void onPause() {
    super.onPause();
    HeroSdk.getInstance().onPause((Activity)this);
  }
  
  public void onRestart() {
    super.onRestart();
    HeroSdk.getInstance().onRestart((Activity)this);
  }
  
  public void onResume() {
    super.onResume();
    HeroSdk.getInstance().onResume((Activity)this);
  }
  
  public void onStart() {
    super.onStart();
    HeroSdk.getInstance().onStart((Activity)this);
  }
  
  public void onStop() {
    super.onStop();
    HeroSdk.getInstance().onStop((Activity)this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\haru\herousdk\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */