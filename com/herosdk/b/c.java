package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;

class c implements Runnable {
  c(a parama, Context paramContext, String paramString) {}
  
  public void run() {
    try {
      ar = a.a(this.c).b(this.a, this.b);
      if (ar != null && ar.b()) {
        int i = ar.e().optInt("code", -9999);
        if (i == 0) {
          Log.d(a.b(), "re success");
          return;
        } 
        if (i == 1001) {
          Log.d(a.b(), "re rak");
          this.c.a(this.a);
          return;
        } 
        if (i == 1002) {
          Log.d(a.b(), "re ate");
          x.a().Q();
          return;
        } 
        String str1 = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.d(str1, stringBuilder1.append("re failed code:").append(i).toString());
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    String str = a.b();
    StringBuilder stringBuilder = new StringBuilder();
    this();
    ar ar;
    Log.e(str, stringBuilder.append("do re but error:").append(ar.a()).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */