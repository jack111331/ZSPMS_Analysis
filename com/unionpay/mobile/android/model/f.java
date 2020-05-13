package com.unionpay.mobile.android.model;

import java.util.HashMap;
import org.json.JSONObject;

public final class f implements e {
  private HashMap<String, Object> a = new HashMap<String, Object>();
  
  public final JSONObject a(String paramString) {
    paramString = (String)this.a.get(paramString);
    return (paramString != null && paramString instanceof JSONObject) ? (JSONObject)paramString : null;
  }
  
  public final void a(String paramString, Object paramObject) {
    this.a.put(paramString, paramObject);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */