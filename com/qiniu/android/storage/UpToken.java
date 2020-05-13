package com.qiniu.android.storage;

import com.qiniu.android.utils.UrlSafeBase64;
import org.json.JSONException;
import org.json.JSONObject;

public final class UpToken {
  public static UpToken NULL = new UpToken("", "", "");
  
  public final String accessKey;
  
  private String returnUrl = null;
  
  public final String token;
  
  private UpToken(String paramString1, String paramString2, String paramString3) {
    this.returnUrl = paramString1;
    this.token = paramString2;
    this.accessKey = paramString3;
  }
  
  public static UpToken parse(String paramString) {
    try {
      String[] arrayOfString = paramString.split(":");
      if (arrayOfString.length != 3)
        return NULL; 
      byte[] arrayOfByte = UrlSafeBase64.decode(arrayOfString[2]);
      try {
        String str = new String();
        this(arrayOfByte);
        JSONObject jSONObject = new JSONObject(str);
        return jSONObject.optString("scope").equals("") ? NULL : ((jSONObject.optInt("deadline") == 0) ? NULL : new UpToken(jSONObject.optString("returnUrl"), paramString, arrayOfString[0]));
      } catch (JSONException jSONException) {
        return NULL;
      } 
    } catch (Exception exception) {
      return NULL;
    } 
  }
  
  public boolean hasReturnUrl() {
    return this.returnUrl.equals("") ^ true;
  }
  
  public String toString() {
    return this.token;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\storage\UpToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */