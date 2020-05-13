package com.zz.sdk.b;

import org.json.JSONException;
import org.json.JSONObject;

public class r implements i {
  public String a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    JSONObject jSONObject = null;
    try {
      String str1;
      String str2;
      if (paramJSONObject.isNull("codes")) {
        str2 = null;
      } else {
        str2 = paramJSONObject.getJSONArray("codes").getString(0);
      } 
      this.a = str2;
      if (paramJSONObject.isNull("id")) {
        str2 = null;
      } else {
        str2 = paramJSONObject.getString("id");
      } 
      this.b = str2;
      if (paramJSONObject.isNull("name")) {
        str2 = null;
      } else {
        str2 = paramJSONObject.getString("name");
      } 
      this.c = str2;
      if (paramJSONObject.isNull("nick")) {
        paramJSONObject = jSONObject;
      } else {
        str1 = paramJSONObject.getString("nick");
      } 
      this.d = str1;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  public String b() {
    return null;
  }
  
  public String[] c() {
    return new String[0];
  }
  
  public String toString() {
    return "codes" + this.a + "id" + this.b + "name" + this.c + "nick" + this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */