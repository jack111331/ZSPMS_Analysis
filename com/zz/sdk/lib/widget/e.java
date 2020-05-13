package com.zz.sdk.lib.widget;

import android.view.ViewTreeObserver;

class e implements ViewTreeObserver.OnGlobalLayoutListener {
  e(c paramc) {}
  
  public void onGlobalLayout() {
    c.b(this.a, c.e(this.a).getContentView().getHeight());
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (c.f(this.a))
      c.e(this.a).setBottomMargin(c.g(this.a)); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */