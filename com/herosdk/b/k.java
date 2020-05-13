package com.herosdk.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.d.bb;
import com.herosdk.d.x;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ICommonListener;
import org.json.JSONObject;

class k implements Runnable {
  k(a parama, Context paramContext, String paramString1, String paramString2, ICommonListener paramICommonListener) {}
  
  public void run() {
    try {
      ar ar = a.a(this.e).b(this.a, this.b, this.c);
      if (ar != null && ar.b()) {
        int i;
        JSONObject jSONObject = ar.e();
        if (jSONObject != null) {
          i = jSONObject.optInt("code", -9999);
          if (i == 0) {
            String str3 = a.b();
            StringBuilder stringBuilder2 = new StringBuilder();
            this();
            Log.d(str3, stringBuilder2.append("idfs success:").append(jSONObject.toString()).toString());
            str = jSONObject.optString("msg");
            if (!TextUtils.isEmpty(str)) {
              l l = new l();
              this(this, str);
              bb.a(l);
            } 
            this.d.onSuccess(i, str);
            return;
          } 
        } else {
          return;
        } 
        if (i == 1001) {
          Log.d(a.b(), "idfs aki");
          this.e.a(this.a);
          return;
        } 
        if (i == 1002) {
          Log.d(a.b(), "idfs ate");
          x.a().Q();
          return;
        } 
        str1 = str.optString("msg");
        String str = a.b();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        Log.d(str, stringBuilder1.append("idfs failed code:").append(i).append(",msg:").append(str1).toString());
        this.d.onFailed(i, str1);
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
    Log.e(str2, stringBuilder.append("do idfs but error:").append(str1.a()).toString());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */