package com.zz.sdk.e;

import android.os.AsyncTask;
import android.util.Log;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.k;

class cv implements g {
  cv(cr paramcr) {}
  
  public void a(AsyncTask paramAsyncTask, Object paramObject, a parama) {
    if (this.a.a(paramAsyncTask)) {
      this.a.y();
      if (!parama.c() && parama.h == 1011) {
        Log.e("zz_sdk", "cpOrder repeat");
        this.a.b(parama.f());
        this.a.a(true);
        return;
      } 
    } else {
      return;
    } 
    cr.a(this.a, this.a.getHost(), (k)paramObject, parama);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */