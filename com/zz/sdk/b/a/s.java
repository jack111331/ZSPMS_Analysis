package com.zz.sdk.b.a;

import com.zz.sdk.b.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class s extends a {
  protected static final String m = "data";
  
  private static final long o = -7712480196643724338L;
  
  public d[] n;
  
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
      this.n = new d[0];
      JSONArray jSONArray = paramJSONObject.optJSONArray("data");
      if (jSONArray != null && jSONArray.length() > 0) {
        ArrayList<d> arrayList = new ArrayList();
        int i = jSONArray.length();
        while (b < i) {
          d d1 = new d();
          d1.a(jSONArray.optJSONObject(b));
          arrayList.add(d1);
          b++;
        } 
        this.n = arrayList.<d>toArray(this.n);
      } 
    } 
  }
  
  public boolean c() {
    return (super.c() && this.n != null);
  }
  
  public String f() {
    return (super.c() && !c()) ? "数据为空！" : a(l, 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */