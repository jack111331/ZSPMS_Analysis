package com.tencent.a.a.a.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
  String a = null;
  
  String b = null;
  
  String c = "0";
  
  long d = 0L;
  
  static c c(String paramString) {
    c c1 = new c();
    if (h.d(paramString))
      try {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        if (!jSONObject.isNull("ui"))
          c1.a = jSONObject.getString("ui"); 
        if (!jSONObject.isNull("mc"))
          c1.b = jSONObject.getString("mc"); 
        if (!jSONObject.isNull("mid"))
          c1.c = jSONObject.getString("mid"); 
        if (!jSONObject.isNull("ts"))
          c1.d = jSONObject.getLong("ts"); 
      } catch (JSONException jSONException) {
        Log.w("MID", (Throwable)jSONException);
      }  
    return c1;
  }
  
  private JSONObject d() {
    JSONObject jSONObject = new JSONObject();
    try {
      h.a(jSONObject, "ui", this.a);
      h.a(jSONObject, "mc", this.b);
      h.a(jSONObject, "mid", this.c);
      jSONObject.put("ts", this.d);
    } catch (JSONException jSONException) {
      Log.w("MID", (Throwable)jSONException);
    } 
    return jSONObject;
  }
  
  public final String c() {
    return this.c;
  }
  
  public final String toString() {
    return d().toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\a\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */