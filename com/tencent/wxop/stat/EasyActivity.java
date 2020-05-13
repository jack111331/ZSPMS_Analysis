package com.tencent.wxop.stat;

import android.app.Activity;
import android.content.Context;

public class EasyActivity extends Activity {
  protected void onPause() {
    super.onPause();
    e.m((Context)this);
  }
  
  protected void onResume() {
    super.onResume();
    e.l((Context)this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\EasyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */