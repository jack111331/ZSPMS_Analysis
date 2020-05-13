package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.utils.p;

final class bg implements View.OnClickListener {
  bg(bd.a parama, int paramInt, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView) {
    bd bd = this.d.a;
    bd.a(this.d.a.d, "pay_success_click_activity", p.i, new Object[] { Integer.valueOf(this.a), this.b });
    this.d.a.a("", this.c);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */