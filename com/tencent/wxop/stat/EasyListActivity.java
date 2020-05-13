package com.tencent.wxop.stat;

import android.app.ListActivity;
import android.content.Context;

public class EasyListActivity extends ListActivity {
  protected void onPause() {
    super.onPause();
    e.m((Context)this);
  }
  
  protected void onResume() {
    super.onResume();
    e.l((Context)this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\EasyListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */