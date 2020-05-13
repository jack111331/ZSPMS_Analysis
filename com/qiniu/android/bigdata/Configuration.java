package com.qiniu.android.bigdata;

import com.qiniu.android.http.ProxyConfiguration;

public final class Configuration implements Cloneable {
  public int connectTimeout = 3;
  
  public String pipelineHost = "https://pipeline.qiniu.com";
  
  public ProxyConfiguration proxy;
  
  public int responseTimeout = 10;
  
  public static Configuration copy(Configuration paramConfiguration) {
    if (paramConfiguration == null)
      return new Configuration(); 
    try {
      return paramConfiguration.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return new Configuration();
    } 
  }
  
  public Configuration clone() throws CloneNotSupportedException {
    return (Configuration)super.clone();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\bigdata\Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */