package com.zz.sdk.a;

import android.content.Context;
import android.view.View;
import com.zz.sdk.i.h;

class kd implements View.OnFocusChangeListener {
  kd(kc paramkc) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    h.a((Context)this.a.b, null, paramBoolean, null, null, kc.a(this.a));
    kc.a(this.a, h.a(paramBoolean, kc.b(this.a)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\kd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */