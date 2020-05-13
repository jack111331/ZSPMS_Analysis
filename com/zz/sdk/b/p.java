package com.zz.sdk.b;

import org.json.JSONException;
import org.json.JSONObject;

public class p implements i {
  static final String g = "codes";
  
  static final String h = "status";
  
  public String a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("a", this.a);
      jSONObject.put("b", this.b);
      jSONObject.put("c", this.c);
      jSONObject.put("d", this.d);
      jSONObject.put("e", this.e);
      jSONObject.put("f", this.f);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    return (JSONObject)jSONException;
  }
  
  public void a(JSONObject paramJSONObject) {
    JSONObject jSONObject = null;
    if (paramJSONObject != null)
      try {
        String str1;
        String str2;
        if (paramJSONObject.isNull("status")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("status");
        } 
        this.c = str2;
        if (paramJSONObject.isNull("codes")) {
          paramJSONObject = jSONObject;
        } else {
          str1 = paramJSONObject.getJSONArray("codes").getString(0);
        } 
        this.d = str1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public String b() {
    return null;
  }
  
  public String toString() {
    return "PayResult [paymentId=" + this.a + ", orderId=" + this.b + ", statusCode=" + this.c + ", resultCode=" + this.d + ", desc=" + this.e + ", attach=" + this.f + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */