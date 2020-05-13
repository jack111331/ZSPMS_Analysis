package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.d.e;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class ad implements Runnable {
  ad(a parama, String paramString1, Context paramContext, String paramString2) {}
  
  public void run() {
    try {
      StringBuilder stringBuilder;
      if (TextUtils.isEmpty(this.a)) {
        Log.e(a.b(), "nps soid is empty");
        return;
      } 
      ar ar = a.a(this.d).a(this.b, this.a, this.c);
      if (ar != null && ar.b()) {
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0) {
          Log.d(a.b(), "nps success");
          e.a().a(this.a);
        } else if (i == 1001) {
          Log.d(a.b(), "nps rak");
          this.d.a(this.b);
        } else if (i == 1002) {
          Log.d(a.b(), "nps ate");
          x.a().Q();
        } else {
          String str1 = jSONObject.optString("msg");
          String str2 = a.b();
          stringBuilder = new StringBuilder();
          this();
          Log.d(str2, stringBuilder.append("nps failed code:").append(i).append(",msg:").append(str1).toString());
        } 
      } else {
        String str = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.e(str, stringBuilder1.append("do nps but error:").append(stringBuilder.a()).toString());
      } 
      return;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */