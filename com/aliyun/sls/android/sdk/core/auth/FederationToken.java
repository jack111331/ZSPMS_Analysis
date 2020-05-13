package com.aliyun.sls.android.sdk.core.auth;

import com.aliyun.sls.android.sdk.SLSLog;
import com.aliyun.sls.android.sdk.utils.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class FederationToken {
  private long expiration;
  
  private String securityToken;
  
  private String tempAk;
  
  private String tempSk;
  
  public FederationToken(String paramString1, String paramString2, String paramString3, long paramLong) {
    setTempAk(paramString1);
    setTempSk(paramString2);
    setSecurityToken(paramString3);
    setExpiration(paramLong);
  }
  
  public FederationToken(String paramString1, String paramString2, String paramString3, String paramString4) {
    setTempAk(paramString1);
    setTempSk(paramString2);
    setSecurityToken(paramString3);
    setExpirationInGMTFormat(paramString4);
  }
  
  public long getExpiration() {
    return this.expiration;
  }
  
  public String getSecurityToken() {
    return this.securityToken;
  }
  
  public String getTempAK() {
    return this.tempAk;
  }
  
  public String getTempSK() {
    return this.tempSk;
  }
  
  public void setExpiration(long paramLong) {
    this.expiration = paramLong;
  }
  
  public void setExpirationInGMTFormat(String paramString) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy-MM-dd'T'HH:mm:ss");
      simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      this.expiration = simpleDateFormat.parse(paramString).getTime() / 1000L;
    } catch (ParseException parseException) {
      if (SLSLog.isEnableLog())
        parseException.printStackTrace(); 
      this.expiration = DateUtil.getFixedSkewedTimeMillis() / 1000L + 30L;
    } 
  }
  
  public void setSecurityToken(String paramString) {
    this.securityToken = paramString;
  }
  
  public void setTempAk(String paramString) {
    this.tempAk = paramString;
  }
  
  public void setTempSk(String paramString) {
    this.tempSk = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FederationToken [tempAk=");
    stringBuilder.append(this.tempAk);
    stringBuilder.append(", tempSk=");
    stringBuilder.append(this.tempSk);
    stringBuilder.append(", securityToken=");
    stringBuilder.append(this.securityToken);
    stringBuilder.append(", expiration=");
    stringBuilder.append(this.expiration);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\auth\FederationToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */