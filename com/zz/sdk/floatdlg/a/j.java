package com.zz.sdk.floatdlg.a;

import com.zz.sdk.b.a.f;
import com.zz.sdk.b.h;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

class j implements Runnable {
  j(h paramh, h paramh1, o paramo) {}
  
  public void run() {
    f f = h.a(this.c).c(this.a.g);
    if (f.c()) {
      h.a(this.c, new k(this, f));
      return;
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      cv.r(stringBuilder.append(h.b(this.c).getString(ci.a(h.b(this.c), 2131165444))).append("：").append(f.f()).toString());
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */