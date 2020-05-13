package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.d.r;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ISinglePayListener;
import org.json.JSONObject;

class ac implements Runnable {
  ac(a parama, ISinglePayListener paramISinglePayListener, String paramString1, Context paramContext, String paramString2) {}
  
  public void run() {
    try {
      StringBuilder stringBuilder;
      if (this.a == null) {
        Log.e(a.b(), "cpr listener is null");
        return;
      } 
      if (TextUtils.isEmpty(this.b)) {
        Log.e(a.b(), "cpr soid is empty");
        return;
      } 
      ar ar = a.a(this.e).a(this.c, this.b);
      if (ar != null && ar.b()) {
        String str;
        JSONObject jSONObject = ar.e();
        int i = jSONObject.optInt("code", -9999);
        if (i == 0) {
          str = jSONObject.optString("key");
          Log.d(a.b(), "cpr success");
          this.a.onSuccess(this.b, this.d, str);
        } else if (i == 1001) {
          Log.d(a.b(), "cpr rak");
          this.e.a(this.c);
        } else if (i == 1002) {
          Log.d(a.b(), "cpr ate");
          x.a().Q();
        } else if (i == 2) {
          Log.d(a.b(), "cpr rak");
          this.a.onFailed(this.b, this.d, 2);
        } else {
          String str1 = str.optString("msg");
          this.a.onFailed(this.b, this.d, 1);
          str = a.b();
          stringBuilder = new StringBuilder();
          this();
          Log.d(str, stringBuilder.append("cpr failed code:").append(i).append(",msg:").append(str1).toString());
        } 
      } else {
        String str = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.e(str, stringBuilder1.append("do cpr but error:").append(stringBuilder.a()).toString());
        this.a.onFailed(this.b, this.d, 1);
      } 
      return;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      this.a.onFailed(this.b, this.d, 1);
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */