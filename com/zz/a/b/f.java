package com.zz.a.b;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

class f extends b implements Serializable {
  private static final long m = 2L;
  
  public int a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public double e;
  
  public int f;
  
  public String g;
  
  public String h;
  
  public String i;
  
  public long j;
  
  public String k;
  
  public String l;
  
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
      jSONObject.put("g", this.g);
      jSONObject.put("h", this.h);
      jSONObject.put("i", this.i);
      jSONObject.put("j", this.k);
      jSONObject.put("k", this.l);
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
        Integer integer;
        String str2;
        double d;
        int i;
        if (paramJSONObject.isNull("a")) {
          integer = null;
        } else {
          integer = Integer.valueOf(paramJSONObject.getInt("a"));
        } 
        this.a = integer.intValue();
        if (paramJSONObject.isNull("b")) {
          integer = null;
        } else {
          str2 = paramJSONObject.getString("b");
        } 
        this.b = str2;
        if (paramJSONObject.isNull("c")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("c");
        } 
        this.c = str2;
        if (paramJSONObject.isNull("d")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("d");
        } 
        this.d = str2;
        if (paramJSONObject.isNull("e")) {
          d = 0.0D;
        } else {
          d = paramJSONObject.getDouble("e");
        } 
        this.e = d;
        if (paramJSONObject.isNull("f")) {
          i = 0;
        } else {
          i = paramJSONObject.getInt("f");
        } 
        this.f = i;
        if (paramJSONObject.isNull("g")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("g");
        } 
        this.g = str2;
        if (paramJSONObject.isNull("h")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("h");
        } 
        this.h = str2;
        if (paramJSONObject.isNull("i")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("i");
        } 
        this.i = str2;
        if (paramJSONObject.isNull("j")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("j");
        } 
        this.k = str2;
        if (paramJSONObject.isNull("k")) {
          paramJSONObject = jSONObject;
        } else {
          str1 = paramJSONObject.getString("k");
        } 
        this.l = str1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public String b() {
    return "b";
  }
  
  public String toString() {
    return "Session [sessionId=" + this.a + ", userName=" + this.b + ", password=" + this.c + ", email=" + this.d + ", money=" + this.e + ", autoLogin=" + this.f + ", timestamp=" + this.g + ", key=" + this.h + ", sign=" + this.i + ", lastLoginTime=" + this.j + ", newPassword=" + this.k + ", mobile=" + this.l + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */