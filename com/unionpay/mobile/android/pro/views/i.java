package com.unionpay.mobile.android.pro.views;

import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pro.pboc.engine.a;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;

final class i implements a {
  i(h paramh) {}
  
  public final void a(ArrayList<c> paramArrayList) {
    k.a("uppay", "deviceReady +++");
    if (paramArrayList != null && paramArrayList.size() > 0) {
      if (this.a.s == null)
        this.a.s = new ArrayList(paramArrayList.size()); 
      this.a.s.addAll(paramArrayList);
    } 
    h.a(this.a);
    k.a("uppay", "deviceReady ---");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */