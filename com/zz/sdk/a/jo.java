package com.zz.sdk.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.zz.sdk.i.h;

class jo implements View.OnFocusChangeListener {
  jo(jl paramjl) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    byte b;
    h.a((Context)this.a.b, null, paramBoolean, null, null, jl.d(this.a));
    ImageView imageView = jl.f(this.a);
    if (paramBoolean && jl.e(this.a).getText().length() > 0) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
    jl.a(this.a, h.a(paramBoolean, jl.g(this.a)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\jo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */