package com.zz.sdk.i;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

final class cw implements Runnable {
  cw(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run() {
    Rect rect = new Rect();
    this.a.setEnabled(true);
    this.a.getHitRect(rect);
    rect.top -= this.b;
    rect.bottom += this.c;
    rect.left -= this.d;
    rect.right += this.e;
    TouchDelegate touchDelegate = new TouchDelegate(rect, this.a);
    if (View.class.isInstance(this.a.getParent()))
      ((View)this.a.getParent()).setTouchDelegate(touchDelegate); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */