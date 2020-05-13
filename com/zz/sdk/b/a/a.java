package com.zz.sdk.b.a;

import com.zz.sdk.b.i;
import com.zz.sdk.i.cg;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements i, Serializable {
  protected static final String a = "codes";
  
  protected static final String b = "error_code";
  
  protected static final String c = "error_description";
  
  protected static final String d = "bindPhoneUid";
  
  protected static final String k = "未知错误";
  
  protected static final String[] l = new String[] { "成功", "失败" };
  
  private static final long m = -2171978081057037176L;
  
  public Integer e;
  
  public String f;
  
  public String g;
  
  public int h;
  
  public String i;
  
  public String j;
  
  private boolean n = false;
  
  protected static String a(String[] paramArrayOfString, String paramString, int paramInt, Integer paramInteger) {
    null = paramString;
    if (paramInteger != null) {
      null = paramString;
      if (paramInteger.intValue() >= paramInt) {
        null = paramString;
        if (paramInteger.intValue() < paramArrayOfString.length + paramInt) {
          if (paramArrayOfString[paramInteger.intValue() - paramInt] == null)
            return paramString; 
        } else {
          return null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return paramArrayOfString[paramInteger.intValue() - paramInt];
  }
  
  protected String a(String[] paramArrayOfString, int paramInt) {
    return (this.g != null) ? this.g : ((this.i != null) ? this.i : a(paramArrayOfString, "未知错误", paramInt, this.e));
  }
  
  public JSONObject a() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("codes", this.f);
    return jSONObject;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      if (paramJSONObject.has("codes")) {
        Integer integer;
        JSONArray jSONArray = paramJSONObject.optJSONArray("codes");
        if (jSONArray == null || jSONArray.length() == 0) {
          this.f = paramJSONObject.optString("codes", null);
          int j = paramJSONObject.optInt("codes", -2147483648);
          if (j == Integer.MIN_VALUE) {
            jSONArray = null;
          } else {
            integer = Integer.valueOf(j);
          } 
          this.e = integer;
        } else {
          this.f = integer.optString(0);
          int j = integer.optInt(0, -2147483648);
          if (j == Integer.MIN_VALUE) {
            integer = null;
          } else {
            integer = Integer.valueOf(j);
          } 
          this.e = integer;
        } 
      } 
      this.h = paramJSONObject.optInt("error_code", 0);
      this.i = paramJSONObject.optString("error_description", null);
      this.j = paramJSONObject.optString("bindPhoneUid", null);
      this.n = true;
    } 
  }
  
  public String b() {
    return getClass().getName();
  }
  
  public boolean c() {
    return (this.e != null && this.e.intValue() == 0);
  }
  
  public int d() {
    return (this.e == null) ? Integer.MIN_VALUE : this.e.intValue();
  }
  
  public boolean e() {
    return this.n;
  }
  
  public String f() {
    return this.n ? a(l, 0) : cg.am.a();
  }
  
  public String toString() {
    String str;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append(b()).append(" : ").append(a().toString()).toString();
    } catch (JSONException jSONException) {
      str = b();
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */