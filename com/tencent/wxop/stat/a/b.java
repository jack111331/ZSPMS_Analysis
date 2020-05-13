package com.tencent.wxop.stat.a;

import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
  public String a;
  
  public JSONArray bl;
  
  public JSONObject bm = null;
  
  public b() {}
  
  public b(String paramString) {
    this.a = paramString;
    this.bm = new JSONObject();
  }
  
  public final boolean equals(Object paramObject) {
    boolean bool = false;
    if (paramObject != null) {
      if (this == paramObject)
        return true; 
      if (paramObject instanceof b) {
        paramObject = paramObject;
        bool = toString().equals(paramObject.toString());
      } 
    } 
    return bool;
  }
  
  public final int hashCode() {
    return toString().hashCode();
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(32);
    stringBuilder.append(this.a).append(",");
    if (this.bl != null)
      stringBuilder.append(this.bl.toString()); 
    if (this.bm != null)
      stringBuilder.append(this.bm.toString()); 
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */