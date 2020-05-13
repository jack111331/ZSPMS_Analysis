package com.zz.sdk.floatdlg.b;

import android.text.TextUtils;
import com.zz.sdk.b.a.n;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class bt implements Runnable {
  bt(bs parambs, n paramn) {}
  
  public void run() {
    try {
      h.c();
      if (this.a != null && this.a.c()) {
        br.a(this.b.a).setText(this.a.Z);
        br.b(this.b.a).setText(this.a.aa);
        if (!TextUtils.isEmpty(cv.q(this.a.j()))) {
          br.c(this.b.a).setText(cv.q(this.a.j()));
          return;
        } 
        br.c(this.b.a).setText(this.b.a.getString(ci.a(br.d(this.b.a), 2131165383)));
        return;
      } 
    } catch (Exception exception) {
      return;
    } 
    cv.r(this.b.a.getString(ci.a(br.d(this.b.a), 2131165373)));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */