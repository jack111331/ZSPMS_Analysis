package com.zz.sdk.floatdlg.b;

import android.content.Context;
import com.zz.sdk.b.a.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class aj implements Runnable {
  aj(ae paramae, String paramString) {}
  
  public void run() {
    String str = "1";
    if (ae.g(this.b))
      str = "2"; 
    a a = ae.b(this.b).n(this.a, str);
    if (a.c()) {
      bp.a("上传通讯录成功");
      this.b.a();
      cm.c((Context)this.b.getActivity(), cq.a(ae.a(this.b)).s(), true);
      cm.a((Context)this.b.getActivity(), System.currentTimeMillis());
      ae.h(this.b);
    } else {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        bp.a(stringBuilder.append("上传通讯录失败：").append(a.f()).toString());
        stringBuilder = new StringBuilder();
        this();
        cv.r(stringBuilder.append("上传通讯录失败：").append(a.f()).toString());
      } catch (Exception exception) {}
    } 
    h.c();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */