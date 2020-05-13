package com.sdk.base.module.config;

import com.sdk.base.framework.c.b;
import com.sdk.base.framework.utils.c.a;

public class BaseConfig implements b {
  public static String apk = "com.cucc.sdk.api_key";
  
  public static int c;
  
  public static String cm = "CUCC";
  
  public static String n;
  
  public static String v;
  
  long r = System.currentTimeMillis();
  
  static {
    c = 24;
    v = "6.6";
    n = "SDKFactory";
  }
  
  public String getApiKey() {
    return apk;
  }
  
  public String getCM() {
    return cm;
  }
  
  public String toJsonString() {
    return a.a(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\module\config\BaseConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */