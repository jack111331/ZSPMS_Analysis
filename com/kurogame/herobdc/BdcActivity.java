package com.kurogame.herobdc;

import android.app.Activity;
import android.os.Bundle;
import com.unity3d.player.UnityPlayerActivity;
import com.yingxiong.recordsdk.RecordSDK;

public class BdcActivity extends UnityPlayerActivity {
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    BdcAgent.init((Activity)this);
  }
  
  public void onPause() {
    super.onPause();
    RecordSDK.getInstance().onPause();
  }
  
  public void onResume() {
    super.onResume();
    RecordSDK.getInstance().onResume();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\herobdc\BdcActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */