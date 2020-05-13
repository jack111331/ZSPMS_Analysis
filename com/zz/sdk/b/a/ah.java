package com.zz.sdk.b.a;

import com.zz.sdk.b.q;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ah extends a {
  protected static final String m = "props";
  
  protected static final String n = "count";
  
  private static final long q = -8456103310324367514L;
  
  public int o;
  
  public q[] p;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    byte b = 0;
    if (paramJSONObject != null) {
      super.a(paramJSONObject);
      this.o = paramJSONObject.optInt("count");
      this.p = new q[0];
      JSONArray jSONArray = paramJSONObject.optJSONArray("props");
      if (jSONArray != null && jSONArray.length() > 0) {
        ArrayList<q> arrayList = new ArrayList(this.o);
        int i = jSONArray.length();
        while (b < i) {
          q q1 = new q();
          q1.a(jSONArray.optJSONObject(b));
          if (q1.c())
            arrayList.add(q1); 
          b++;
        } 
        this.p = arrayList.<q>toArray(this.p);
      } 
    } 
  }
  
  public boolean c() {
    return (super.c() && this.o > 0 && this.p != null && this.o == this.p.length);
  }
  
  public String f() {
    return (super.c() && !c()) ? "数据为空！" : a(l, 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */