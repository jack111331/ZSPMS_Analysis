package com.herosdk.b;

import android.content.Context;
import android.util.Log;
import com.herosdk.d.az;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import org.json.JSONObject;

class m implements Runnable {
  m(a parama, Context paramContext, String paramString) {}
  
  public void run() {
    try {
      ar ar = a.a(this.c).h(this.a, this.b);
      if (ar != null && ar.b()) {
        int i;
        JSONObject jSONObject = ar.e();
        if (jSONObject != null) {
          i = jSONObject.optInt("code", -9999);
          if (i == 0) {
            String str3 = a.b();
            StringBuilder stringBuilder2 = new StringBuilder();
            this();
            Log.d(str3, stringBuilder2.append("kc success:").append(jSONObject.toString()).toString());
            if (this.b.trim().equals("1"))
              az.b = Boolean.valueOf(true); 
            return;
          } 
        } else {
          return;
        } 
        if (i == 1001) {
          Log.d(a.b(), "kc aki");
          this.c.a(this.a);
          az.b = Boolean.valueOf(false);
          return;
        } 
        if (i == 1002) {
          Log.d(a.b(), "kc ate");
          x.a().Q();
          az.b = Boolean.valueOf(false);
          return;
        } 
        String str = jSONObject.optString("msg");
        str1 = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.d(str1, stringBuilder1.append("kc failed code:").append(i).append(",msg:").append(str).toString());
        az.b = Boolean.valueOf(false);
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
    Log.e(str2, stringBuilder.append("do kc but error:").append(str1.a()).toString());
    az.b = Boolean.valueOf(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */