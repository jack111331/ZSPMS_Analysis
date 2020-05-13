package com.zz.sdk.b.a;

import com.zz.sdk.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

public class ap extends al {
  protected static final String o = "channels";
  
  protected static final String p = "enablePayConfirm";
  
  private static final long s = 4556350033914399851L;
  
  public u[] q;
  
  public boolean r;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("enablePayConfirm", String.valueOf(this.r));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return; 
    super.a(paramJSONObject);
    JSONArray jSONArray = paramJSONObject.optJSONArray("channels");
    if (jSONArray == null || jSONArray.length() == 0) {
      this.q = null;
    } else {
      this.q = new u[jSONArray.length()];
      byte b = 0;
      int i = jSONArray.length();
      while (true) {
        if (b < i) {
          this.q[b] = new u();
          this.q[b].a(jSONArray.optJSONObject(b));
          b++;
          continue;
        } 
        this.r = paramJSONObject.optBoolean("enablePayConfirm", true);
        return;
      } 
    } 
    this.r = paramJSONObject.optBoolean("enablePayConfirm", true);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */