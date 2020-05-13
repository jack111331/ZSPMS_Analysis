package com.xy.whf.entity;

import android.support.annotation.NonNull;
import java.io.Serializable;
import java.util.HashMap;

public class UrlEntity implements Serializable {
  private static final long serialVersionUID = 8197172867988662351L;
  
  public String baseUrl;
  
  public HashMap<String, Object> params;
  
  public String getBaseUrl() {
    return this.baseUrl;
  }
  
  public HashMap<String, Object> getParams() {
    return this.params;
  }
  
  public void setBaseUrl(String paramString) {
    this.baseUrl = paramString;
  }
  
  public void setParams(HashMap<String, Object> paramHashMap) {
    this.params = paramHashMap;
  }
  
  @NonNull
  public String toString() {
    return "UrlEntity{baseUrl='" + this.baseUrl + '\'' + ", params=" + this.params + '}';
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\entity\UrlEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */