package com.zz.sdk.lib.widget;

import android.content.DialogInterface;
import android.view.View;

class b implements View.OnClickListener {
  b(a parama, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView) {
    if (this.a != null) {
      this.a.onClick((DialogInterface)this.b, 0);
      return;
    } 
    this.b.dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */