package com.zz.sdk.floatdlg.b;

import android.text.TextUtils;
import com.zz.sdk.b.a.z;
import com.zz.sdk.i.cq;

class bh implements Runnable {
  bh(be parambe) {}
  
  public void run() {
    String str1 = "1";
    if (be.g(this.a))
      str1 = "2"; 
    String str2 = cq.a(be.c(this.a)).q();
    String str3 = str2;
    if (TextUtils.isEmpty(str2))
      str3 = cq.a(be.c(this.a)).v(); 
    z z = be.a(this.a).a(str3, be.h(this.a), be.i(this.a), be.j(this.a), be.k(this.a), str1);
    if (z.c()) {
      be.m(this.a).post(new bi(this, z));
      return;
    } 
    be.m(this.a).post(new bj(this, z));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */