package com.zz.sdk.i;

import com.zz.sdk.a.bv;
import com.zz.sdk.a.ha;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ay;
import java.util.Map;

class ct implements Runnable {
  ct(cs paramcs, a parama) {}
  
  public void run() {
    int i;
    ay ay = (ay)this.a;
    if (ay.c()) {
      cq.a(this.b.a.a, 0L);
      i = ay.g();
      if (i == 1) {
        if (!v.B) {
          bv.a(false);
          bv.a(cv.i(), ha.class, (Map)bv.a().a("key_show_back", Boolean.valueOf(false)).a("forbid_back", Boolean.valueOf(true)));
        } 
        return;
      } 
    } else {
      return;
    } 
    if (i == -1) {
      String str = ay.j();
      v.D = str;
      v.C.onKickOff(0, str);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */