package com.zz.sdk.b;

import com.zz.sdk.third.a.a;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class v implements i, Serializable {
  private static final long r = 2L;
  
  public int a;
  
  public String b;
  
  public String c;
  
  public int d;
  
  public String e;
  
  public long f;
  
  public String g;
  
  public int h = 0;
  
  public int i = 0;
  
  public int j;
  
  public int k;
  
  public int l;
  
  public int m;
  
  public String n;
  
  public String o;
  
  public int p;
  
  public boolean q;
  
  private a s;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("a", this.a);
      jSONObject.put("b", this.b);
      jSONObject.put("c", this.c);
      jSONObject.put("f", this.d);
      jSONObject.put("g", this.e);
      jSONObject.put("j", this.g);
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
        int j;
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
        if (paramJSONObject.isNull("f")) {
          j = 0;
        } else {
          j = paramJSONObject.getInt("f");
        } 
        this.d = j;
        if (paramJSONObject.isNull("g")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("g");
        } 
        this.e = str2;
        if (paramJSONObject.isNull("j")) {
          paramJSONObject = jSONObject;
        } else {
          str1 = paramJSONObject.getString("j");
        } 
        this.g = str1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public String b() {
    return null;
  }
  
  public a c() {
    if (this.s != null)
      return this.s; 
    this.s = new a();
    this.s.d(this.c);
    return this.s;
  }
  
  public String toString() {
    return "SdkUser{sdkUserId=" + this.a + ", loginName='" + this.b + '\'' + ", password='" + this.c + '\'' + ", newPassword='" + this.g + '\'' + ", loginType=" + this.h + ", mSdkUserId='" + this.o + '\'' + '}';
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */