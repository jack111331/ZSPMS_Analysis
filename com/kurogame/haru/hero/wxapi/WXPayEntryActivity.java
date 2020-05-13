package com.kurogame.haru.hero.wxapi;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.zz.sdk.SampleWXPayEntryActivity;

public class WXPayEntryActivity extends SampleWXPayEntryActivity {
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    TextView textView = new TextView(getBaseContext());
    textView.setText("即将退出微信支付，请稍等...");
    textView.setTextSize(20.0F);
    textView.setGravity(17);
    setTheme(16973834);
    setContentView((View)textView);
    (new Handler()).postDelayed(new Runnable() {
          public void run() {
            WXPayEntryActivity.this.finish();
          }
        },  2000L);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\kurogame\haru\hero\wxapi\WXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */