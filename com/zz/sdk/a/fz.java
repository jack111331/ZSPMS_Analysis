package com.zz.sdk.a;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

class fz extends PopupWindow {
  fz(fr paramfr, View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    super(paramView, paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(View paramView) {
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView) {
    if (Build.VERSION.SDK_INT >= 24) {
      Rect rect = new Rect();
      if (paramView.getGlobalVisibleRect(rect)) {
        View view = getContentView();
        if (view.getMeasuredHeight() >= rect.bottom) {
          setHeight(rect.bottom);
        } else {
          setHeight(-2);
          ga ga = new ga(this, view, rect);
          view.getViewTreeObserver().addOnGlobalLayoutListener(ga);
        } 
      } else {
        setHeight(-2);
      } 
    } 
    a(paramView);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */