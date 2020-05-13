package com.unionpay.mobile.android.nocard.views;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.l;
import java.util.HashMap;
import java.util.Map;

final class ap implements Handler.Callback {
  ap(ao paramao) {}
  
  public final boolean handleMessage(Message paramMessage) {
    boolean bool;
    k.c("uppay", "mHceHandler. handleMessage");
    ao.a(this.a);
    b.bl = true;
    if (this.a.a.aP == l.e.intValue()) {
      this.a.r.clear();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this.a.r.remove(hashMap);
      if (b.bb != null && b.bb.size() > 0) {
        int j = b.bb.size();
        for (byte b = 0; b < j; b++) {
          d d = b.bb.get(b);
          ao ao2 = this.a;
          Map<String, Object> map = ao.a(d);
          this.a.r.add(map);
          if (b == 0)
            ao.b(this.a).b(d.b() + d.c() + " " + map.get("text2")); 
        } 
        ao.b(this.a).setVisibility(0);
        if (ao.c(this.a) != null)
          ao.c(this.a).setVisibility(8); 
        return true;
      } 
    } else {
      return true;
    } 
    this.a.n();
    this.a.a.aP = l.a.intValue();
    if (this.a.a.aE) {
      bool = true;
    } else {
      bool = false;
    } 
    ao ao1 = this.a;
    String str2 = c.bD.bq;
    String str1 = this.a.a.bh;
    int i = a.t;
    i = a.k;
    i = a.s;
    ao1.a(str2, str1, bool, true);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */