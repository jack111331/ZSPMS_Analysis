package com.zz.sdk.floatdlg;

import com.zz.sdk.i.v;

class b implements Runnable {
  b(FloatDialog paramFloatDialog) {}
  
  public void run() {
    if (v.q) {
      FloatDialog.a(this.a).setVisibility(0);
      return;
    } 
    FloatDialog.a(this.a).setVisibility(8);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */