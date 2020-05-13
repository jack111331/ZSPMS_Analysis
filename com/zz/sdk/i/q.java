package com.zz.sdk.i;

import android.content.Context;
import com.zz.sdk.a.fc;

final class q implements Runnable {
  q(Context paramContext, int paramInt, boolean paramBoolean) {}
  
  public void run() {
    try {
      CharSequence charSequence = this.a.getText(ci.a(this.a, this.b));
      if (h.h() == null) {
        fc fc = new fc();
        this(this.a, charSequence);
        h.a(fc);
      } else {
        h.h().setTitle(charSequence);
      } 
      h.h().setOnCancelListener(null);
      h.h().setOnDismissListener(null);
      h.h().setOnKeyListener(null);
      h.h().setCancelable(this.c);
      h.h().setCanceledOnTouchOutside(false);
      h.h().show();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */