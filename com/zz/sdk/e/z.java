package com.zz.sdk.e;

import android.widget.AbsListView;

class z implements AbsListView.OnScrollListener {
  z(x paramx) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (paramInt == 2) {
      x.a(this.a).c(true);
      return;
    } 
    x.a(this.a).c(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */