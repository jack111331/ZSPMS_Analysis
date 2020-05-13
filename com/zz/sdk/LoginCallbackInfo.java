package com.zz.sdk;

import org.json.JSONObject;

public class LoginCallbackInfo {
  public static final String K_ACCESS_TOKEN = "accessToken";
  
  public static final String K_ANTIADDICITION = "antiAddicition";
  
  public static final String K_AUTH_CODE = "authCode";
  
  public static final String K_LOGIN_NAME = "loginName";
  
  public static final String K_SDK_USER_ID = "sdkUserId";
  
  public static final String K_STATUS_CODE = "statusCode";
  
  public static final int STATUS_AA_ADULT = 2;
  
  public static final int STATUS_AA_NONAGE = 1;
  
  public static final int STATUS_AA_UNKNOWN = 0;
  
  public static final int STATUS_CLOSE_VIEW = -2;
  
  public static final int STATUS_FAILURE = -1;
  
  public static final int STATUS_SUCCESS = 0;
  
  public static final int STATUS_SWITCH_ACCOUNT = 1;
  
  public String accessToken;
  
  public String authCode;
  
  public String loginName;
  
  public int mAntiAddiciton;
  
  public String sdkuserid;
  
  public int statusCode;
  
  public JSONObject genJSON() {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("statusCode", this.statusCode);
    jSONObject.put("loginName", this.loginName);
    jSONObject.put("sdkUserId", this.sdkuserid);
    jSONObject.put("antiAddicition", this.mAntiAddiciton);
    jSONObject.put("authCode", this.authCode);
    jSONObject.put("accessToken", this.accessToken);
    return jSONObject;
  }
  
  public String toString() {
    String str;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str = stringBuilder.append("LoginCallbackInfo ").append(genJSON().toString()).toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "LoginCallbackInfo[error]";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\LoginCallbackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */