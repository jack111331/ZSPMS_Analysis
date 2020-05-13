package com.herosdk.d;

import com.herosdk.bean.d;
import com.herosdk.error.ErrorUtils;
import java.util.List;

class ah implements Runnable {
  ah(x paramx) {}
  
  public void run() {
    try {
      List<d> list = e.a().c();
      if (list != null && list.size() > 0) {
        List<d> list1;
        Boolean bool = Boolean.valueOf(false);
        long l = bb.a();
        for (byte b = 0; b < list.size(); b++) {
          d d = list.get(b);
          if (l - d.d() > 259200L) {
            bool = Boolean.valueOf(true);
            e.a().a(d.b());
          } 
        } 
        if (bool.booleanValue()) {
          list1 = e.a().c();
        } else {
          list1 = list;
        } 
        if (list1 != null && list1.size() > 0) {
          x.a(this.a, 0);
          this.a.a(list1);
        } 
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */