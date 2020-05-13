package com.chuanglan.shanyan_sdk.utils;

import android.content.Context;
import android.content.Intent;
import com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity;
import org.json.JSONObject;

public class AbActivityUtils {
  public static String getCMCCPreResMsg(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      String str;
      try {
        if (paramJSONObject.has("resultDesc"))
          return paramJSONObject.optString("resultDesc"); 
        if (paramJSONObject.has("desc"))
          return paramJSONObject.optString("desc"); 
        String str1 = paramJSONObject.toString();
        str = str1;
      } catch (Exception exception) {
        exception.printStackTrace();
        str = str.toString();
      } 
      return str;
    } 
    return "";
  }
  
  public static String getCMCCResMsg(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      String str;
      try {
        if (paramJSONObject.has("resultDesc"))
          return paramJSONObject.optString("resultDesc"); 
        String str1 = paramJSONObject.toString();
        str = str1;
      } catch (Exception exception) {
        exception.printStackTrace();
        str = str.toString();
      } 
      return str;
    } 
    return "";
  }
  
  public static String getCTCCResMsg(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      String str = jSONObject.optString("msg");
      paramString = str;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return paramString;
  }
  
  public static void startShanYanOneKeyActivity(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    Intent intent = new Intent(paramContext, ShanYanOneKeyActivity.class);
    intent.putExtra("accessCode", paramString1);
    intent.putExtra("number", paramString2);
    intent.putExtra("operatorAppId", paramString3);
    intent.putExtra("operatorAppKey", paramString4);
    intent.putExtra("isFinish", paramBoolean);
    intent.setFlags(268435456);
    paramContext.startActivity(intent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sd\\utils\AbActivityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */