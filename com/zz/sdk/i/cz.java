package com.zz.sdk.i;

import android.app.Activity;
import android.content.Context;
import com.zz.sdk.SDKManager;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.kr;
import com.zz.sdk.floatdlg.c.b;
import com.zz.sdk.h.f;
import java.util.Map;

class cz implements b {
  cz(cy paramcy, Activity paramActivity) {}
  
  public void a() {
    v.r = false;
    long l = System.currentTimeMillis();
    if (l - cv.m() >= 600L) {
      cv.b(l);
      if (SDKManager.isShowFloat()) {
        if (f.b(this.a).c()) {
          SDKManager.tryShowFloat(this.a, new da(this));
          return;
        } 
        String str = cq.a((Context)this.a).w();
        if (!Boolean.valueOf(cm.b((Context)this.a, bg.c + str, false)).booleanValue()) {
          if (bg.b) {
            bv.a(false);
            bv.a(this.a, kr.class, (Map)bv.a().a("key_show_back", Boolean.valueOf(true)), true);
          } 
          return;
        } 
        if (f.b(this.a).c()) {
          SDKManager.tryShowFloat(this.a, new db(this));
          return;
        } 
        SDKManager.tryHideFloat(this.a);
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */