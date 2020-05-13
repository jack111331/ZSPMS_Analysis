package com.unionpay.mobile.android.widgets;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;

final class n extends Dialog {
  n(m paramm, Context paramContext) {
    super(paramContext);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    return (paramInt == 4) ? true : super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */