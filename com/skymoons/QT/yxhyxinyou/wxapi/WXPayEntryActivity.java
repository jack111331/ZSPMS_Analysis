package com.skymoons.QT.yxhyxinyou.wxapi;

import android.os.Bundle;
import android.os.Handler;
import com.zz.sdk.SampleWXPayEntryActivity;

public class WXPayEntryActivity extends SampleWXPayEntryActivity {
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    (new Handler()).postDelayed(new Runnable() {
          public void run() {
            WXPayEntryActivity.this.finish();
          }
        },  5000L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\skymoons\QT\yxhyxinyou\wxapi\WXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */