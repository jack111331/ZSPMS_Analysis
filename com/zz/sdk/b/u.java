package com.zz.sdk.b;

import org.json.JSONObject;

public class u implements i {
  public static final String j = "command";
  
  public static final String k = "payConfirmText";
  
  public static final String l = "price";
  
  public static final String m = "serviceType";
  
  public static final String n = "spCode";
  
  public static final String o = "isBlockPrompt";
  
  public static final String p = "fetchCommand";
  
  public String a;
  
  public String b;
  
  public String c;
  
  public double d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public String h;
  
  public String i;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.c = paramJSONObject.optString("command", null);
      this.e = paramJSONObject.optString("payConfirmText", null);
      this.d = paramJSONObject.optInt("price", -1);
      this.a = paramJSONObject.optString("serviceType", null);
      this.b = paramJSONObject.optString("spCode", null);
      this.f = paramJSONObject.optString("isBlockPrompt", null);
      this.i = paramJSONObject.optString("fetchCommand");
    } 
  }
  
  public String b() {
    return "channels";
  }
  
  public boolean c() {
    return "1".equals(this.i);
  }
  
  public String toString() {
    return "SMSChannelMessage [serviceType=" + this.a + ", sendToAddress=" + this.b + ", command=" + this.c + ", price=" + this.d + ", prompt=" + this.e + ", isBlockPrompt=" + this.f + ", isBlockSMS=" + this.g + ", ereg=" + this.h + ", " + "fetchCommand" + "=" + this.i + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */