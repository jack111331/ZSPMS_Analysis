package com.sdk.base.framework.bean;

import com.sdk.base.framework.utils.c.a;

public class KInfo {
  private String cn;
  
  private String ic;
  
  private boolean idfd;
  
  private boolean idfs;
  
  private String ie;
  
  private String is;
  
  private String m;
  
  private int sid;
  
  public String getCn() {
    return this.cn;
  }
  
  public String getIc() {
    return this.ic;
  }
  
  public String getIe() {
    return this.ie;
  }
  
  public String getIs() {
    return this.is;
  }
  
  public String getM() {
    return this.m;
  }
  
  public int getSid() {
    return this.sid;
  }
  
  public boolean isIdfd() {
    return this.idfd;
  }
  
  public boolean isIdfs() {
    return this.idfs;
  }
  
  public void setCn(String paramString) {
    this.cn = paramString;
  }
  
  public void setIc(String paramString) {
    this.ic = paramString;
  }
  
  public void setIdfd(boolean paramBoolean) {
    this.idfd = paramBoolean;
  }
  
  public void setIdfs(boolean paramBoolean) {
    this.idfs = paramBoolean;
  }
  
  public void setIe(String paramString) {
    this.ie = paramString;
  }
  
  public void setIs(String paramString) {
    this.is = paramString;
  }
  
  public void setM(String paramString) {
    this.m = paramString;
  }
  
  public void setSid(int paramInt) {
    this.sid = paramInt;
  }
  
  public String toString() {
    return a.a(this);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\bean\KInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */