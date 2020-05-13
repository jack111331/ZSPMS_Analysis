package com.zz.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.z;
import com.zz.sdk.i.cq;

class hc implements Runnable {
  hc(ha paramha) {}
  
  public void run() {
    String str1 = cq.a((Context)this.a.b).q();
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = cq.a((Context)this.a.b).v(); 
    z z = ha.e(this.a).a(str2, ha.a(this.a), ha.b(this.a), ha.c(this.a), ha.d(this.a), "");
    if (z.c()) {
      ha.l(this.a).post(new hd(this, (a)z));
      return;
    } 
    ha.l(this.a).post(new he(this, (a)z));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */