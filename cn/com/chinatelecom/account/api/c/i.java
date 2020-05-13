package cn.com.chinatelecom.account.api.c;

import org.json.JSONException;
import org.json.JSONObject;

public class i {
  public static String a(int paramInt, String paramString) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("result", paramInt);
      jSONObject.put("msg", paramString);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */