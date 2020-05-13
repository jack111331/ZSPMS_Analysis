package com.zz.sdk.floatdlg.a;

import com.zz.sdk.b.a.f;
import com.zz.sdk.b.h;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;

class e implements Runnable {
  e(c paramc, t paramt, h paramh) {}
  
  public void run() {
    try {
      f f = this.a.c(this.b.g);
      if (f.c()) {
        c.a(this.c, f.g(), this.b);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      cv.r(stringBuilder.append(this.b.f).append("领取失败：").append(f.f()).toString());
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */