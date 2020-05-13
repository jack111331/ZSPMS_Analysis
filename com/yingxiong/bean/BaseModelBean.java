package com.yingxiong.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;
import java.io.Serializable;

public class BaseModelBean implements Serializable {
  private String CID;
  
  private String CommonValue;
  
  private String LAC;
  
  private String MCC;
  
  private String MNC;
  
  private String SID;
  
  private String appkey;
  
  private String channelId;
  
  private String channelName;
  
  private String deviceid;
  
  private String deviceidip;
  
  private String event_uuid;
  
  @PrimaryKey(AssignType.AUTO_INCREMENT)
  public int id;
  
  private String sessionId;
  
  private String time;
  
  private long timestamp;
  
  public String getAppkey() {
    return this.appkey;
  }
  
  public String getCID() {
    return this.CID;
  }
  
  public String getChannelId() {
    return this.channelId;
  }
  
  public String getChannelName() {
    return this.channelName;
  }
  
  public String getCommonValue() {
    return this.CommonValue;
  }
  
  public String getDeviceid() {
    return this.deviceid;
  }
  
  public String getDeviceidip() {
    return this.deviceidip;
  }
  
  public String getEvent_uuid() {
    return this.event_uuid;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getLAC() {
    return this.LAC;
  }
  
  public String getMCC() {
    return this.MCC;
  }
  
  public String getMNC() {
    return this.MNC;
  }
  
  public String getSID() {
    return this.SID;
  }
  
  public String getSessionId() {
    return this.sessionId;
  }
  
  public String getTime() {
    return this.time;
  }
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void setAppkey(String paramString) {
    this.appkey = paramString;
  }
  
  public void setCID(String paramString) {
    this.CID = paramString;
  }
  
  public void setChannelId(String paramString) {
    this.channelId = paramString;
  }
  
  public void setChannelName(String paramString) {
    this.channelName = paramString;
  }
  
  public void setCommonValue(String paramString) {
    this.CommonValue = paramString;
  }
  
  public void setDeviceid(String paramString) {
    this.deviceid = paramString;
  }
  
  public void setDeviceidip(String paramString) {
    this.deviceidip = paramString;
  }
  
  public void setEvent_uuid(String paramString) {
    this.event_uuid = paramString;
  }
  
  public void setId(int paramInt) {
    this.id = paramInt;
  }
  
  public void setLAC(String paramString) {
    this.LAC = paramString;
  }
  
  public void setMCC(String paramString) {
    this.MCC = paramString;
  }
  
  public void setMNC(String paramString) {
    this.MNC = paramString;
  }
  
  public void setSID(String paramString) {
    this.SID = paramString;
  }
  
  public void setSessionId(String paramString) {
    this.sessionId = paramString;
  }
  
  public void setTime(String paramString) {
    this.time = paramString;
  }
  
  public void setTimestamp(long paramLong) {
    this.timestamp = paramLong;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\bean\BaseModelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */