package com.zz.sdk.floatdlg.b;

import com.zz.sdk.b.a.s;
import com.zz.sdk.i.bp;

class ak implements Runnable {
  ak(ae paramae) {}
  
  public void run() {
    String str = "1";
    if (ae.g(this.a))
      str = "2"; 
    s s = ae.b(this.a).k(str);
    if (s.c()) {
      ae.a(this.a, s.n);
      ae.i(this.a);
      return;
    } 
    bp.a("获取好友游戏列表失败：" + s.f());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */