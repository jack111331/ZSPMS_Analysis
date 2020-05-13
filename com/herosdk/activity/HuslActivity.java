package com.herosdk.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.herosdk.d.m;

public class HuslActivity extends HuwActivity {
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
    layoutParams.width = m.a((Context)this).p();
    layoutParams.height = m.a((Context)this).q();
    this.e.setLayoutParams(layoutParams);
    this.e.loadUrl(this.c);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\activity\HuslActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */