package com.unionpay.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
  public static Object a(JSONArray paramJSONArray, int paramInt) {
    Object object = null;
    Object object1 = object;
    if (paramJSONArray != null) {
      object1 = object;
      if (paramInt < paramJSONArray.length()) {
        object1 = object;
        if (paramInt >= 0)
          try {
            object1 = paramJSONArray.get(paramInt);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            object1 = object;
          }  
      } 
    } 
    return object1;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString) {
    String str1 = "";
    String str2 = str1;
    if (d(paramJSONObject, paramString))
      try {
        str2 = paramJSONObject.getString(paramString);
      } catch (JSONException jSONException) {
        h.b("uppay", g.class.toString() + " get " + paramString + " failed!!");
        str2 = str1;
      }  
    return str2;
  }
  
  public static boolean b(JSONObject paramJSONObject, String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (d(paramJSONObject, paramString))
      try {
        bool2 = paramJSONObject.getBoolean(paramString);
      } catch (JSONException jSONException) {
        h.b("uppay", g.class.toString() + " get " + paramString + " failed!!");
        bool2 = bool1;
      }  
    return bool2;
  }
  
  public static JSONArray c(JSONObject paramJSONObject, String paramString) {
    JSONArray jSONArray1 = null;
    JSONArray jSONArray2 = jSONArray1;
    if (d(paramJSONObject, paramString))
      try {
        jSONArray2 = paramJSONObject.getJSONArray(paramString);
      } catch (JSONException jSONException) {
        h.b("uppay", g.class.toString() + " get " + paramString + " failed!!");
        jSONArray2 = jSONArray1;
      }  
    return jSONArray2;
  }
  
  private static boolean d(JSONObject paramJSONObject, String paramString) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramJSONObject != null) {
      bool2 = bool1;
      if (paramJSONObject.has(paramString))
        bool2 = true; 
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpa\\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */