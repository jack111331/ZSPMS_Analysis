package com.zz.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.zz.sdk.b.a.z;
import com.zz.sdk.i.cq;

class dd implements Runnable {
  dd(db paramdb) {}
  
  public void run() {
    String str1 = cq.a((Context)this.a.b).q();
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = cq.a((Context)this.a.b).v(); 
    z z = db.e(this.a).a(str2, db.a(this.a), db.b(this.a), db.c(this.a), db.d(this.a), "");
    if (z.c()) {
      db.l(this.a).post(new de(this, z));
      return;
    } 
    db.l(this.a).post(new dg(this, z));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */