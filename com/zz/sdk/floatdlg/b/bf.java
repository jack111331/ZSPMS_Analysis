package com.zz.sdk.floatdlg.b;

import android.view.View;
import com.zz.sdk.b.a.y;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class bf implements Runnable {
  bf(be parambe, View paramView) {}
  
  public void run() {
    try {
      y y = be.a(this.b).j("2");
      if (y.c()) {
        be.a(this.b, y.n);
        be.a(this.b, this.a);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        cv.r(stringBuilder.append("实名认证礼包数据请求失败：").append(y.f()).toString());
      } 
      h.c();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */