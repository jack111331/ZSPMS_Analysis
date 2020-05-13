package com.unionpay;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.unionpay.utils.i;

final class n implements View.OnClickListener {
  n(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void onClick(View paramView) {
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.a);
    UPPayWapActivity.a(this.a, builder.create());
    builder.setMessage((i.a()).a);
    builder.setTitle((i.a()).d);
    builder.setPositiveButton((i.a()).b, new o(this));
    builder.setNegativeButton((i.a()).c, new p(this));
    builder.create().show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */