package com.zz.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class SampleWXPayEntryActivity extends Activity {
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    SDKManager.registWXPayHandler(this, getIntent());
  }
  
  protected void onDestroy() {
    super.onDestroy();
    SDKManager.unregistWXPayHandler(this);
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    SDKManager.registWXPayHandler(this, getIntent());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\SampleWXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */