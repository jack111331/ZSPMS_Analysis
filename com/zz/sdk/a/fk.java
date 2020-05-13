package com.zz.sdk.a;

import android.content.Context;
import com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener;
import com.zz.sdk.c.a;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;

class fk implements OneKeyLoginListener {
  fk(fi paramfi) {}
  
  public void getOneKeyLoginStatus(int paramInt, String paramString) {
    bp.a("getOneKeyLoginStatus code:" + paramInt + ",result:" + paramString);
    if (paramInt == 1000) {
      this.a.a.c(2131165244);
      a.a().a((Context)this.a.a.b, paramString, new fl(this));
      return;
    } 
    if (paramInt != 1011) {
      cv.r(this.a.a.b.getString(ci.a((Context)this.a.a.b, 2131165270)));
      fe.a(this.a.a).setVisibility(0);
      fe.b(this.a.a).setVisibility(8);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */