package com.sdk.mobile.config;

import com.sdk.base.framework.c.b;
import com.sdk.base.framework.utils.c.a;
import com.sdk.base.module.config.BaseConfig;

public class MobileConfig implements b {
  String apk = BaseConfig.apk;
  
  int c = 1;
  
  String cm = BaseConfig.cm;
  
  String n = "ZzxOAuth";
  
  long r = System.currentTimeMillis();
  
  String v = "1.0";
  
  public String getApiKey() {
    return this.apk;
  }
  
  public String getCM() {
    return this.cm;
  }
  
  public String toJsonString() {
    return a.a(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\config\MobileConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */