package com.unionpay.mobile.android.widgets;

import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.global.a;

final class bc implements PopupWindow.OnDismissListener {
  bc(bb parambb) {}
  
  public final void onDismiss() {
    if (bb.a(this.a) != null) {
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)bb.a(this.a).getLayoutParams();
      marginLayoutParams.bottomMargin = a.b;
      marginLayoutParams.height = bb.b(this.a);
      bb.a(this.a).setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */