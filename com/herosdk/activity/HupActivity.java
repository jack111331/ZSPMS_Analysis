package com.herosdk.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.herosdk.d.bb;
import com.herosdk.d.m;
import java.util.HashMap;

public class HupActivity extends HuwActivity {
  private void c() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Referer", this.c);
    this.e.loadUrl(this.c, hashMap);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    int i = m.a((Context)this).p();
    int j = m.a((Context)this).q();
    ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
    if (i > j) {
      layoutParams.width = j;
      layoutParams.height = i - bb.e((Context)this);
    } 
    this.e.setLayoutParams(layoutParams);
    c();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\activity\HupActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */