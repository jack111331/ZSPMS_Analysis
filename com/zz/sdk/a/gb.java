package com.zz.sdk.a;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.zz.sdk.b.v;
import com.zz.sdk.i.t;

class gb implements AdapterView.OnItemClickListener {
  gb(fr paramfr) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    v v = fr.c(this.a).a(paramInt);
    fr.d(this.a).dismiss();
    if (v == null) {
      t.a((Context)this.a.b).b("History_platform", "History_add", 1);
      bv.a(this.a.b, fe.class, this.a.z());
      return;
    } 
    fr.b(this.a, v);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */