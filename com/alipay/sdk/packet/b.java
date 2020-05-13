package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;

public final class b {
  String a;
  
  public String b;
  
  public b(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private void a(String paramString) {
    this.a = paramString;
  }
  
  private String b() {
    return this.a;
  }
  
  private void b(String paramString) {
    this.b = paramString;
  }
  
  private String c() {
    return this.b;
  }
  
  public final JSONObject a() {
    JSONObject jSONObject = null;
    if (!TextUtils.isEmpty(this.b))
      try {
        jSONObject = new JSONObject();
        this(this.b);
      } catch (Exception exception) {
        exception = null;
      }  
    return (JSONObject)exception;
  }
  
  public final String toString() {
    return "\nenvelop:" + this.a + "\nbody:" + this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\packet\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */