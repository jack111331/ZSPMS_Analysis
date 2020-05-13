package com.zz.sdk.a;

import android.content.Context;
import com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.h;

class fj implements OpenLoginAuthListener {
  fj(fi paramfi) {}
  
  public void getOpenLoginAuthStatus(int paramInt, String paramString) {
    bp.a("getOpenLoginAuthStatus code:" + paramInt + ",result:" + paramString);
    h.c();
    if (paramInt != 1000) {
      cv.r(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165270)));
      fe.a(this.a.a).setVisibility(0);
      fe.b(this.a.a).setVisibility(8);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */