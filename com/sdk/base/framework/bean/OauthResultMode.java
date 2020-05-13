package com.sdk.base.framework.bean;

import java.io.Serializable;

public class OauthResultMode implements Serializable {
  private int code;
  
  private String msg;
  
  private Object object;
  
  private String seq;
  
  private int status;
  
  public OauthResultMode() {}
  
  public OauthResultMode(int paramInt1, String paramString, int paramInt2) {
    this.code = paramInt1;
    this.msg = paramString;
    this.status = paramInt2;
  }
  
  public OauthResultMode(int paramInt1, String paramString1, int paramInt2, Object paramObject, String paramString2) {
    this.code = paramInt1;
    this.msg = paramString1;
    this.status = paramInt2;
    this.object = paramObject;
    this.seq = paramString2;
  }
  
  public int getCode() {
    return this.code;
  }
  
  public String getMsg() {
    return this.msg;
  }
  
  public Object getObject() {
    return this.object;
  }
  
  public String getSeq() {
    return this.seq;
  }
  
  public int getStatus() {
    return this.status;
  }
  
  public void setCode(int paramInt) {
    this.code = paramInt;
  }
  
  public void setMsg(String paramString) {
    this.msg = paramString;
  }
  
  public void setObject(Object paramObject) {
    this.object = paramObject;
  }
  
  public void setSeq(String paramString) {
    this.seq = paramString;
  }
  
  public void setStatus(int paramInt) {
    this.status = paramInt;
  }
  
  public String toString() {
    return "OauthResultMode{code=" + this.code + ", msg='" + this.msg + '\'' + ", status=" + this.status + ", object=" + this.object + ", seq='" + this.seq + '\'' + '}';
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\bean\OauthResultMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */