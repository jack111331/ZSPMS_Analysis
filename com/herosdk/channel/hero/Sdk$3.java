package com.herosdk.channel.hero;

import android.util.Log;
import com.zz.sdk.FloatSoundCallback;

class Sdk$3 implements FloatSoundCallback {
  Sdk$3(Sdk paramSdk) {}
  
  public void onExitFloat() {
    Log.d(this.a.g, "exit float, turn sound on");
  }
  
  public void onStartFloat() {
    Log.d(this.a.g, "start float, turn sound off");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Sdk$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */