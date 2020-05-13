package com.herosdk.d;

import android.util.Log;
import com.herosdk.bean.d;
import com.herosdk.error.ErrorUtils;
import java.util.Iterator;
import java.util.List;

class f implements Runnable {
  f(e parame, d paramd) {}
  
  public void run() {
    List<d> list;
    try {
      String str1 = x.a().i().getRoleId();
      String str2 = this.a.b();
      list = this.b.c();
      if (list != null) {
        Iterator<d> iterator = list.iterator();
        while (iterator.hasNext()) {
          d d1 = iterator.next();
          if (d1.a().equals(str1) && d1.b().equals(str2))
            iterator.remove(); 
        } 
      } else {
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    Log.d("frameLib.cspus", "ssci...add");
    list.add(this.a);
    this.b.a(list);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */