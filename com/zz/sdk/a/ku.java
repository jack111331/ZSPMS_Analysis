package com.zz.sdk.a;

import android.view.View;
import android.widget.AdapterView;
import com.zz.sdk.b.e;

class ku implements AdapterView.OnItemClickListener {
  ku(kt paramkt) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    e e = kt.a(this.a).get(paramInt);
    switch (kx.a[e.c.ordinal()]) {
      default:
        return;
      case 1:
        bv.a(this.a.b, k.class, this.a.z().a("key_title", kt.b(this.a)));
      case 2:
        bv.a(this.a.b, gu.class, this.a.z());
      case 3:
        break;
    } 
    bv.a(this.a.b, dn.class, this.a.z());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\ku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */