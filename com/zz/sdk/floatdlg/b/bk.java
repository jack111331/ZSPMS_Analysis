package com.zz.sdk.floatdlg.b;

import com.zz.sdk.b.a.f;
import com.zz.sdk.b.h;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cv;

class bk implements Runnable {
  bk(be parambe) {}
  
  public void run() {
    try {
      for (h h : be.b(this.a)) {
        StringBuilder stringBuilder;
        f f = be.a(this.a).c(h.g);
        if (f.c()) {
          stringBuilder = new StringBuilder();
          this();
          bp.a(stringBuilder.append(h.f).append("礼包领取成功").toString());
          stringBuilder = new StringBuilder();
          this();
          cv.r(stringBuilder.append(h.f).append("礼包领取成功").toString());
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          bp.a(stringBuilder1.append(h.f).append("礼包领取失败：").append(stringBuilder.f()).toString());
          stringBuilder1 = new StringBuilder();
          this();
          cv.r(stringBuilder1.append(h.f).append("礼包领取失败：").append(stringBuilder.f()).toString());
        } 
      } 
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */