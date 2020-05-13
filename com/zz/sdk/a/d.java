package com.zz.sdk.a;

import android.view.View;
import com.zz.sdk.i.h;

class d implements View.OnFocusChangeListener {
  d(a parama) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    a.a(this.a, h.a(paramBoolean, a.b(this.a)));
    if (paramBoolean)
      a.a(this.a).setText(""); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */