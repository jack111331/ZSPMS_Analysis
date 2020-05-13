package com.yingxiong.bean;

import com.litesuits.orm.db.annotation.Table;

@Table("record")
public class RecordBean extends BaseModelBean {
  private int actionType;
  
  private String error;
  
  private String eventId;
  
  private String eventName;
  
  private String extra;
  
  private String userinfo;
  
  public int getActionType() {
    return this.actionType;
  }
  
  public String getError() {
    return this.error;
  }
  
  public String getEventId() {
    return this.eventId;
  }
  
  public String getEventName() {
    return this.eventName;
  }
  
  public String getExtra() {
    return this.extra;
  }
  
  public String getUserinfo() {
    return this.userinfo;
  }
  
  public void setActionType(int paramInt) {
    this.actionType = paramInt;
  }
  
  public void setError(String paramString) {
    this.error = paramString;
  }
  
  public void setEventId(String paramString) {
    this.eventId = paramString;
  }
  
  public void setEventName(String paramString) {
    this.eventName = paramString;
  }
  
  public void setExtra(String paramString) {
    this.extra = paramString;
  }
  
  public void setUserinfo(String paramString) {
    this.userinfo = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\bean\RecordBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */