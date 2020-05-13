package com.zz.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.r;
import com.zz.sdk.b.v;
import com.zz.sdk.i.cm;
import com.zz.sdk.i.cq;
import com.zz.sdk.i.t;
import com.zz.sdk.listener.a;
import org.json.JSONObject;

class dw implements Runnable {
  dw(ds paramds, a parama) {}
  
  public void run() {
    cq cq = cq.a((Context)this.b.b);
    cq.a((Context)this.b.b, ds.a(this.b));
    ds.a(this.b, cq.a);
    if (ds.b(this.b) != null && TextUtils.isEmpty((ds.b(this.b)).b))
      ds.a(this.b, (v)null); 
    r r = t.a((Context)this.b.b).b();
    if (r != null && r.c()) {
      ds.a(this.b, r.g());
      cm.b((Context)this.b.b, ds.F(), r.g());
      r r1 = r;
    } else {
      String str = cm.c((Context)this.b.b, ds.F(), "");
      r r1 = r;
      if (!TextUtils.isEmpty(str))
        try {
          JSONObject jSONObject = new JSONObject();
          this(str);
          r1 = new r();
          this();
          try {
            r1.a(jSONObject);
          } catch (Exception exception1) {}
        } catch (Exception exception) {
          exception = exception1;
        }  
    } 
    this.a.a((a)exception);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */