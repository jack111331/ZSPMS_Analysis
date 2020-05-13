package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class j implements Runnable {
  j(a parama, Context paramContext, Object paramObject) {}
  
  public void run() {
    try {
      ar ar = a.a(this.c).a(this.a, this.b);
      if (ar != null && ar.b()) {
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0) {
          Log.d(a.b(), "uai success");
          return;
        } 
        if (i == 1001) {
          Log.d(a.b(), "uai aki");
          return;
        } 
        if (i == 1002) {
          Log.d(a.b(), "uai ate");
          x.a().Q();
          return;
        } 
        String str = jSONObject.optString("msg");
        str1 = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.d(str1, stringBuilder1.append("uai failed code:").append(i).append(",msg:").append(str).toString());
        return;
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } 
    String str2 = a.b();
    StringBuilder stringBuilder = new StringBuilder();
    this();
    String str1;
    Log.e(str2, stringBuilder.append("do uai but error:").append(str1.a()).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */