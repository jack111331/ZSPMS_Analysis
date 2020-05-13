package com.herosdk.bean;

import java.io.Serializable;
import java.util.HashMap;

public class UserInfo implements Serializable {
  private static final long a = -4909705012770540281L;
  
  private String b = "";
  
  private String c = "";
  
  private String d = "";
  
  private String e = "";
  
  private String f = "";
  
  private Boolean g = Boolean.valueOf(false);
  
  private HashMap<String, String> h;
  
  public String getChannelToken() {
    return this.e;
  }
  
  public HashMap<String, String> getExtendParams() {
    return this.h;
  }
  
  public Boolean getIsFirstLogin() {
    return this.g;
  }
  
  public String getServerMessage() {
    return this.f;
  }
  
  public String getToken() {
    return this.d;
  }
  
  public String getUid() {
    return this.b;
  }
  
  public String getUsername() {
    return this.c;
  }
  
  public void setChannelToken(String paramString) {
    this.e = paramString;
  }
  
  public void setExtendParams(HashMap<String, String> paramHashMap) {
    this.h = paramHashMap;
  }
  
  public void setIsFirstLogin(Boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setServerMessage(String paramString) {
    this.f = paramString;
  }
  
  public void setToken(String paramString) {
    this.d = paramString;
  }
  
  public void setUid(String paramString) {
    this.b = paramString;
  }
  
  public void setUsername(String paramString) {
    this.c = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\bean\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */