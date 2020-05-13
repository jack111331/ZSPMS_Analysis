package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.error.ErrorUtils;

class o implements Runnable {
  o(a parama, Context paramContext) {}
  
  public void run() {
    try {
      ar ar = a.a(this.b).b(this.a);
      if (ar != null && ar.b()) {
        Log.d(a.b(), "rsee...s");
        return;
      } 
      String str = a.b();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d(str, stringBuilder.append("rsee...err:").append(ar.a()).toString());
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */