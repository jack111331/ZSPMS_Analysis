package com.zz.sdk.e;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

class gt implements AdapterView.OnItemClickListener {
  gt(go paramgo) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramAdapterView.getAdapter() instanceof p) {
      go.a(this.a, (go.i(this.a)[paramInt]).B);
      go.b(this.a, paramInt);
    } 
    Log.v("zz_sdk", "type=" + go.j(this.a));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */