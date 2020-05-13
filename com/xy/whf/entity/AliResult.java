package com.xy.whf.entity;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Map;

public class AliResult {
  private String alipayOpenId;
  
  private String authCode;
  
  private String memo;
  
  private String result;
  
  private String resultCode;
  
  private String resultStatus;
  
  public AliResult(Map<String, String> paramMap, boolean paramBoolean) {
    if (paramMap != null) {
      for (String str : paramMap.keySet()) {
        if (TextUtils.equals(str, "resultStatus")) {
          this.resultStatus = paramMap.get(str);
          continue;
        } 
        if (TextUtils.equals(str, "result")) {
          this.result = paramMap.get(str);
          continue;
        } 
        if (TextUtils.equals(str, "memo"))
          this.memo = paramMap.get(str); 
      } 
      String[] arrayOfString = this.result.split("&");
      int i = arrayOfString.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          String str = arrayOfString[b];
          if (str.startsWith("alipay_open_id")) {
            this.alipayOpenId = removeBrackets(getValue("alipay_open_id=", str), paramBoolean);
          } else if (str.startsWith("auth_code")) {
            this.authCode = removeBrackets(getValue("auth_code=", str), paramBoolean);
          } else if (str.startsWith("result_code")) {
            this.resultCode = removeBrackets(getValue("result_code=", str), paramBoolean);
          } 
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  private String getValue(String paramString1, String paramString2) {
    return paramString2.substring(paramString1.length(), paramString2.length());
  }
  
  private String removeBrackets(String paramString, boolean paramBoolean) {
    String str = paramString;
    if (paramBoolean) {
      str = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        String str1 = paramString;
        if (paramString.startsWith("\""))
          str1 = paramString.replaceFirst("\"", ""); 
        str = str1;
        if (str1.endsWith("\""))
          str = str1.substring(0, str1.length() - 1); 
      } 
    } 
    return str;
  }
  
  public String getAlipayOpenId() {
    return this.alipayOpenId;
  }
  
  public String getAuthCode() {
    return this.authCode;
  }
  
  public String getMemo() {
    return this.memo;
  }
  
  public String getResult() {
    return this.result;
  }
  
  public String getResultCode() {
    return this.resultCode;
  }
  
  public String getResultStatus() {
    return this.resultStatus;
  }
  
  public void setAlipayOpenId(String paramString) {
    this.alipayOpenId = paramString;
  }
  
  public void setAuthCode(String paramString) {
    this.authCode = paramString;
  }
  
  public void setMemo(String paramString) {
    this.memo = paramString;
  }
  
  public void setResult(String paramString) {
    this.result = paramString;
  }
  
  public void setResultCode(String paramString) {
    this.resultCode = paramString;
  }
  
  public void setResultStatus(String paramString) {
    this.resultStatus = paramString;
  }
  
  @NonNull
  public String toString() {
    return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + "}";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\entity\AliResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */