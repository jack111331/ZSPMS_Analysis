package com.zz.sdk.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

class ga implements ViewTreeObserver.OnGlobalLayoutListener {
  ga(fz paramfz, View paramView, Rect paramRect) {}
  
  public void onGlobalLayout() {
    int i = this.a.getHeight();
    if (i > 0) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (i >= this.b.bottom) {
        this.c.setHeight(this.b.bottom);
        this.c.update();
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */