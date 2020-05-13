package com.zz.sdk.floatdlg.b;

import android.widget.ListAdapter;
import com.zz.sdk.floatdlg.a.p;

class ao implements Runnable {
  ao(am paramam) {}
  
  public void run() {
    p p = new p(am.c(this.a), am.d(this.a));
    am.e(this.a).setAdapter((ListAdapter)p);
    p.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */