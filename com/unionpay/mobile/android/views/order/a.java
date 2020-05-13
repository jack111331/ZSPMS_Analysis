package com.unionpay.mobile.android.views.order;

import android.view.View;

final class a implements View.OnClickListener {
  a(AbstractMethod paramAbstractMethod) {}
  
  public final void onClick(View paramView) {
    if (this.a.f != null) {
      boolean bool;
      if (this.a.c() == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.a.f.a(this.a.b(), bool, this.a.d(), this.a.c());
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */