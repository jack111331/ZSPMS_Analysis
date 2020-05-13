package com.zz.sdk.floatdlg.b;

import android.content.Context;
import com.zz.sdk.SDKManager;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.fr;
import com.zz.sdk.activity.f;
import com.zz.sdk.b.a.a;
import com.zz.sdk.e.bd;
import com.zz.sdk.e.bg;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;
import java.util.Map;

class u implements Runnable {
  u(t paramt, a parama) {}
  
  public void run() {
    try {
      String str;
      h.c();
      if (this.a != null && this.a.c()) {
        cv.r(this.b.b.getString(ci.a(p.a(this.b.b)).a(2131165381)));
        cq.a(p.a(this.b.b)).a(this.b.a);
        this.b.b.getActivity().finish();
        this.b.b.getActivity().overridePendingTransition(0, 0);
        bg bg = bd.a((Context)cv.i(), f.a, SDKManager.getRootEnv());
        bv.a(false);
        bv.a(cv.i(), fr.class, (Map)bv.a().a("key_user", (cq.a(p.a(this.b.b))).a).a("key_layout_main", bg), true);
        return;
      } 
      if (this.a != null) {
        str = this.a.f();
      } else {
        str = this.b.b.getString(ci.a(p.a(this.b.b)).a(2131165382));
      } 
      cv.r(str);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */