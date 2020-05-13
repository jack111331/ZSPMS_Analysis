package com.zz.sdk.floatdlg.b;

import android.content.Context;
import android.view.View;
import com.zz.sdk.b.a.y;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class at implements Runnable {
  at(as paramas, int paramInt, View paramView) {}
  
  public void run() {
    boolean bool = false;
    try {
      au au;
      if (cm.b((Context)this.c.getActivity(), (cq.a((Context)this.c.getActivity())).a.o))
        bool = true; 
      y y = as.a(this.c).b(this.a, bool);
      if (y.c()) {
        bp.a("getGift...success");
        as.a(this.c, y.n[0]);
        au = new au();
        this(this);
        cv.a(au);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        bp.a(stringBuilder.append("getGift...failed: ").append(au.f()).toString());
        stringBuilder = new StringBuilder();
        this();
        cv.r(stringBuilder.append("获取礼包详情失败：").append(au.f()).toString());
      } 
      h.c();
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */