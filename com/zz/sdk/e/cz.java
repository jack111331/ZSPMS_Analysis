package com.zz.sdk.e;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

class cz implements AdapterView.OnItemClickListener {
  cz(cr paramcr) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    Adapter adapter = paramAdapterView.getAdapter();
    if (adapter instanceof r && cr.e(this.a)) {
      double d = ((r)adapter).b(paramInt);
      this.a.a(dl.f, String.valueOf(d));
    } 
    this.a.f();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */