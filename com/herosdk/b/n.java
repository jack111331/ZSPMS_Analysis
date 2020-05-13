package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class n implements Runnable {
  n(a parama, Context paramContext) {}
  
  public void run() {
    try {
      x.a().c("");
      x.a().d("");
      ar ar = a.a(this.b).c(this.a);
      if (ar != null && ar.b()) {
        JSONObject jSONObject = ar.e();
        if (jSONObject.optInt("code", -9999) == 0) {
          Log.d(a.b(), "rak success");
          x.a().c(jSONObject.optString("ak"));
          x.a().d(jSONObject.optString("aki"));
          return;
        } 
        String str1 = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.e(str1, stringBuilder1.append("rak failed:").append(jSONObject.optString("msg")).toString());
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    String str = a.b();
    StringBuilder stringBuilder = new StringBuilder();
    this();
    Log.e(str, stringBuilder.append("do rak but error:").append(exception.a()).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */