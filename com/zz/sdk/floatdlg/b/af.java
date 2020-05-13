package com.zz.sdk.floatdlg.b;

import com.zz.sdk.b.a.y;
import com.zz.sdk.b.h;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.t;
import java.util.ArrayList;

class af implements Runnable {
  af(ae paramae) {}
  
  public void run() {
    byte b2;
    h h;
    byte b1 = 0;
    ae.a(this.a, t.a(ae.a(this.a)));
    if (cm.b(ae.a(this.a), (cq.a(ae.a(this.a))).a.o)) {
      b2 = 1;
    } else {
      b2 = 0;
    } 
    y y = ae.b(this.a).b(b2);
    if (y.c()) {
      ArrayList<h> arrayList = new ArrayList();
      h[] arrayOfH = y.n;
      int i = arrayOfH.length;
      for (b2 = b1; b2 < i; b2++) {
        h = arrayOfH[b2];
        if (h.o > 0 && h.q < h.r)
          arrayList.add(h); 
      } 
      ae.a(this.a, arrayList);
      cv.a(new ag(this, arrayList));
      return;
    } 
    bp.a("获取通讯录礼包列表失败：" + h.f());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */