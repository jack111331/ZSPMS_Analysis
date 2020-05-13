package com.aliyun.sls.android.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientConfiguration {
  private static final int DEFAULT_MAX_RETRIES = 2;
  
  private int connectionTimeout = 15000;
  
  private List<String> customCnameExcludeList = new ArrayList<String>();
  
  private int maxConcurrentRequest = 5;
  
  private int maxErrorRetry = 2;
  
  private String proxyHost;
  
  private int proxyPort;
  
  private int socketTimeout = 15000;
  
  public static ClientConfiguration getDefaultConf() {
    return new ClientConfiguration();
  }
  
  public int getConnectionTimeout() {
    return this.connectionTimeout;
  }
  
  public List<String> getCustomCnameExcludeList() {
    return Collections.unmodifiableList(this.customCnameExcludeList);
  }
  
  public int getMaxConcurrentRequest() {
    return this.maxConcurrentRequest;
  }
  
  public int getMaxErrorRetry() {
    return this.maxErrorRetry;
  }
  
  public String getProxyHost() {
    return this.proxyHost;
  }
  
  public int getProxyPort() {
    return this.proxyPort;
  }
  
  public int getSocketTimeout() {
    return this.socketTimeout;
  }
  
  public void setConnectionTimeout(int paramInt) {
    this.connectionTimeout = paramInt;
  }
  
  public void setCustomCnameExcludeList(List<String> paramList) {
    if (paramList != null && paramList.size() != 0) {
      this.customCnameExcludeList.clear();
      for (String str : paramList) {
        if (str.contains("://")) {
          this.customCnameExcludeList.add(str.substring(str.indexOf("://") + 3));
          continue;
        } 
        this.customCnameExcludeList.add(str);
      } 
      return;
    } 
    throw new IllegalArgumentException("cname exclude list should not be null.");
  }
  
  public void setMaxConcurrentRequest(int paramInt) {
    this.maxConcurrentRequest = paramInt;
  }
  
  public void setMaxErrorRetry(int paramInt) {
    this.maxErrorRetry = paramInt;
  }
  
  public void setProxyHost(String paramString) {
    this.proxyHost = paramString;
  }
  
  public void setProxyPort(int paramInt) {
    this.proxyPort = paramInt;
  }
  
  public void setSocketTimeout(int paramInt) {
    this.socketTimeout = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\ClientConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */