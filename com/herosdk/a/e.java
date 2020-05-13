package com.herosdk.a;

import android.content.DialogInterface;
import android.view.View;

class e implements View.OnClickListener {
  e(d paramd, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView) {
    if (this.a != null) {
      this.a.onClick((DialogInterface)this.b, 0);
      return;
    } 
    this.b.dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */