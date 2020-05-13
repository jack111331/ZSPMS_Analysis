package com.zz.a.b;

import com.zz.a.c.e;
import java.io.Serializable;
import org.json.JSONObject;

class k extends b implements Serializable {
  private static final long f = 5729382919128511084L;
  
  private static final String g = "a";
  
  private static final String h = "b";
  
  private static final String i = "c";
  
  private static final String j = "y";
  
  private static final String k = "z";
  
  public String a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      a(jSONObject, "a", this.a);
      a(jSONObject, "b", this.b);
      a(jSONObject, "c", this.c);
      a(jSONObject, "y", this.d);
      a(jSONObject, "z", this.e);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(String paramString) {
    try {
      this.e = e.a(new String[] { this.a, this.b, this.c, this.d, paramString });
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      try {
        this.a = c(paramJSONObject, "a");
        this.b = c(paramJSONObject, "b");
        this.c = c(paramJSONObject, "c");
        this.d = c(paramJSONObject, "y");
        this.e = c(paramJSONObject, "z");
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public String b() {
    return "d";
  }
  
  public int c() {
    return 4;
  }
  
  public String toString() {
    return "UpdatePwd [account=" + this.a + ", md5pwd=" + this.b + ", newmd5pwd=" + this.c + ", app_secret" + this.d + ", sign" + this.e + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */