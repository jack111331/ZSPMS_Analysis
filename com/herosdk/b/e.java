package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;

class e implements Runnable {
  e(a parama, Context paramContext, String paramString) {}
  
  public void run() {
    try {
      ar ar = a.a(this.c).d(this.a, this.b);
      if (ar != null && ar.b()) {
        int i = ar.e().optInt("code", -9999);
        if (i == 0) {
          Log.d(a.b(), "rnfs success");
          return;
        } 
        if (i == 1001) {
          Log.d(a.b(), "rnfs rak");
          this.c.a(this.a);
          return;
        } 
        if (i == 1002) {
          Log.d(a.b(), "rnfs ate");
          x.a().Q();
          return;
        } 
        String str1 = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.d(str1, stringBuilder1.append("rnfs failed code:").append(i).toString());
        return;
      } 
    } catch (Exception exception) {
      Log.e(a.b(), "rnfs...exception");
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    String str = a.b();
    StringBuilder stringBuilder = new StringBuilder();
    this();
    Log.e(str, stringBuilder.append("do rnfs but error:").append(exception.a()).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */