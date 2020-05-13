package com.herosdk.bean;

import java.util.HashMap;
import java.util.Map;

public class ShareInfo {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private final Map<String, Object> e = new HashMap<String, Object>();
  
  public ShareInfo() {}
  
  public ShareInfo(String paramString1, String paramString2) {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public Map<String, Object> getExtra() {
    return this.e;
  }
  
  public String getImagePath() {
    return this.c;
  }
  
  public String getText() {
    return this.b;
  }
  
  public String getTitle() {
    return this.a;
  }
  
  public String getUrl() {
    return this.d;
  }
  
  public void putExtra(String paramString, Object paramObject) {
    this.e.put(paramString, paramObject);
  }
  
  public void removeExtra(String paramString) {
    this.e.remove(paramString);
  }
  
  public void setImagePath(String paramString) {
    this.c = paramString;
  }
  
  public void setText(String paramString) {
    this.b = paramString;
  }
  
  public void setTitle(String paramString) {
    this.a = paramString;
  }
  
  public void setUrl(String paramString) {
    this.d = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\bean\ShareInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */