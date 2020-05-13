package com.zz.sdk.floatdlg.a;

import com.zz.sdk.floatdlg.FloatDialog;
import com.zz.sdk.h.g;
import com.zz.sdk.i.t;
import com.zz.sdk.i.v;

class m implements Runnable {
  m(h paramh) {}
  
  public void run() {
    if (t.a(h.b(this.a)).c(h.b(this.a)).size() > 0) {
      v.q = true;
    } else {
      v.q = false;
    } 
    if (h.b(this.a) instanceof FloatDialog)
      ((FloatDialog)h.b(this.a)).a(); 
    g.b().l();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */