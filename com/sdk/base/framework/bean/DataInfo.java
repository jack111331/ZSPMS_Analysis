package com.sdk.base.framework.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class DataInfo extends JSONObject {
  public DataInfo() {
    try {
      put("r", System.currentTimeMillis());
    } catch (JSONException jSONException) {}
  }
  
  public JSONObject putData(String paramString, Object paramObject) {
    JSONObject jSONObject;
    try {
      jSONObject = put(paramString, paramObject);
    } catch (Exception exception) {
      jSONObject = this;
    } 
    return jSONObject;
  }
  
  public String toAESString() {
    return "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\bean\DataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */