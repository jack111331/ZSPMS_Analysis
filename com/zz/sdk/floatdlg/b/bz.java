package com.zz.sdk.floatdlg.b;

import android.support.v4.app.FragmentActivity;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class bz implements Runnable {
  bz(by paramby, a parama) {}
  
  public void run() {
    try {
      String str;
      h.c();
      if (this.a != null && this.a.c()) {
        ((FragmentActivity)bw.a(this.b.b)).getSupportFragmentManager().beginTransaction().replace(2131296257, p.a(this.b.a)).addToBackStack(null).commit();
        return;
      } 
      if (this.a != null) {
        str = this.a.f();
      } else {
        str = this.b.b.getString(ci.a(bw.a(this.b.b), 2131165385));
      } 
      cv.r(str);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */