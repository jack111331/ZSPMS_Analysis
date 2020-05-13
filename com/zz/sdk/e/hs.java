package com.zz.sdk.e;

import android.view.View;
import android.widget.AdapterView;

class hs implements AdapterView.OnItemClickListener {
  hs(hg paramhg) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    int i = hg.d(this.a).getCheckedItemPosition();
    if (-1 != paramInt) {
      hg.d(this.a, i);
      hg.b(this.a, i);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */