package com.zz.sdk.b.a;

import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import org.json.JSONObject;

public class b extends a {
  private String m;
  
  public void a(String paramString) {
    this.m = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    super.a(paramJSONObject);
    String str = paramJSONObject.optString("code");
    try {
      String str1 = new String();
      this(Base64.decodeBase64(str.getBytes()));
      this.m = str1;
    } catch (Exception exception) {}
  }
  
  public String g() {
    return this.m;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */