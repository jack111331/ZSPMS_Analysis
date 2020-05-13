package com.zz.sdk.floatdlg.b;

import com.zz.sdk.b.a.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;

class bd implements Runnable {
  bd(bc parambc) {}
  
  public void run() {
    a a = bc.b(this.a).d(bc.a(this.a));
    if (a.c()) {
      bp.a("修改成功");
      cm.c(bc.c(this.a), cq.a(bc.c(this.a)).s(), bc.a(this.a));
      return;
    } 
    bp.a("修改失败：" + a.f());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */