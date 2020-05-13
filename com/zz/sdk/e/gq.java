package com.zz.sdk.e;

import android.os.AsyncTask;
import android.util.Log;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.al;
import com.zz.sdk.i.cg;

class gq implements g {
  gq(go paramgo) {}
  
  public void a(AsyncTask paramAsyncTask, Object paramObject, a parama) {
    if (this.a.a(paramAsyncTask)) {
      if (parama == null || !parama.e()) {
        this.a.a(cg.al);
        return;
      } 
    } else {
      return;
    } 
    if (parama.c()) {
      al al1 = (al)parama;
      this.a.getEnv().add("global.paymentlist.pay_order_number", al1.n);
      go.a(this.a, this.a.getEnv(), 0);
      go.b(this.a, this.a.getEnv(), 0);
      return;
    } 
    al al = (al)parama;
    if (al.h == 1011) {
      Log.e("zz_sdk", "cpOrder repeat");
      this.a.b(parama.f());
      this.a.a(true);
      return;
    } 
    this.a.a(al.f());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */