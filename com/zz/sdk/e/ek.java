package com.zz.sdk.e;

import android.view.View;
import android.widget.AdapterView;

class ek implements AdapterView.OnItemClickListener {
  ek(ej paramej, en paramen) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    ej.a(this.b, paramInt - 1);
    this.a.notifyDataSetChanged();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */