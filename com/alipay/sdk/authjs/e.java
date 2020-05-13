package com.alipay.sdk.authjs;

import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

final class e implements Runnable {
  e(d paramd, a parama) {}
  
  public final void run() {
    d d1 = this.b;
    a a1 = this.a;
    if (a1 != null && "toast".equals(a1.k)) {
      JSONObject jSONObject = a1.m;
      String str = jSONObject.optString("content");
      int j = jSONObject.optInt("duration");
      boolean bool = true;
      if (j < 2500)
        bool = false; 
      Toast.makeText(d1.b, str, bool).show();
      (new Timer()).schedule(new f(d1, a1), bool);
    } 
    int i = a.a.a;
    if (i != a.a.a)
      try {
        this.b.a(this.a.i, i);
      } catch (JSONException jSONException) {} 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\authjs\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */