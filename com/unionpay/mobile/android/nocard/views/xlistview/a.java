package com.unionpay.mobile.android.nocard.views.xlistview;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.resource.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  public static List<Map<String, Object>> a(Context paramContext, List<c> paramList, boolean paramBoolean) {
    if (paramList == null)
      return null; 
    ArrayList<HashMap<Object, Object>> arrayList = new ArrayList(paramList.size());
    for (byte b = 0; b < paramList.size(); b++) {
      c c = paramList.get(b);
      if (c != null) {
        String str;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("text1", c.e());
        if (c.c() == 0) {
          str = c.b();
        } else if (!TextUtils.isEmpty(c.b())) {
          str = c.b().substring(0, 4) + " **** **** " + c.b().substring(c.b().length() - 4);
        } else {
          continue;
        } 
        hashMap.put("text2", str);
        if (paramBoolean)
          if (c.c() == 0) {
            hashMap.put("editable", Boolean.TRUE);
            hashMap.put("icon", c.a(paramContext).a(1016));
          } else {
            hashMap.put("editable", Boolean.FALSE);
            hashMap.put("icon", null);
          }  
        arrayList.add(hashMap);
      } 
      continue;
    } 
    return (List)arrayList;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("href_label", paramJSONObject.get("label"));
      jSONObject.put("name", "");
      jSONObject.put("value", "");
      jSONObject.put("href_title", paramString);
      jSONObject.put("label", c.bD.z);
      jSONObject.put("required", "0");
      jSONObject.put("href_url", paramJSONObject.get("href"));
      jSONObject.put("error_info", c.bD.aF);
      jSONObject.put("checked", "0");
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return jSONObject;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\xlistview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */