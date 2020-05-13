package com.sdk.base.framework.bean;

import com.sdk.base.framework.utils.c.a;

public class SmsInfo {
  private String content;
  
  private Long ctime;
  
  private Long ftime;
  
  private String mobile;
  
  private int opt;
  
  private String result;
  
  public SmsInfo() {}
  
  public SmsInfo(String paramString1, String paramString2, int paramInt, Long paramLong1, Long paramLong2, String paramString3) {
    this.content = paramString1;
    this.mobile = paramString2;
    this.opt = paramInt;
    this.ctime = paramLong1;
    this.ftime = paramLong2;
    this.result = paramString3;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public Long getCtime() {
    return this.ctime;
  }
  
  public Long getFtime() {
    return this.ftime;
  }
  
  public String getMobile() {
    return this.mobile;
  }
  
  public int getOpt() {
    return this.opt;
  }
  
  public String getResult() {
    return this.result;
  }
  
  public void setContent(String paramString) {
    this.content = paramString;
  }
  
  public void setCtime(Long paramLong) {
    this.ctime = paramLong;
  }
  
  public void setFtime(Long paramLong) {
    this.ftime = paramLong;
  }
  
  public void setMobile(String paramString) {
    this.mobile = paramString;
  }
  
  public void setOpt(int paramInt) {
    this.opt = paramInt;
  }
  
  public void setResult(String paramString) {
    this.result = paramString;
  }
  
  public String toJsonString() {
    return a.a(this);
  }
  
  public String toString() {
    return "{'content':'" + this.content + "', 'mobile':'" + this.mobile + "', 'opt':'" + this.opt + "', 'ctime':'" + this.ctime + "', 'ftime':'" + this.ftime + "', 'result':'" + this.result + "'}";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\bean\SmsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */