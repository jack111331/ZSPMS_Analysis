package com.unionpay.mobile.android.utils;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
  public static String a(JSONArray paramJSONArray, int paramInt) {
    String str1 = "";
    String str2 = str1;
    if (paramJSONArray != null) {
      str2 = str1;
      if (paramInt >= 0) {
        str2 = str1;
        if (paramInt < paramJSONArray.length())
          try {
            str2 = paramJSONArray.getString(paramInt);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            str2 = str1;
          }  
      } 
    } 
    return str2;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString) {
    String str1 = "";
    String str2 = str1;
    if (f(paramJSONObject, paramString))
      try {
        str2 = paramJSONObject.getString(paramString);
      } catch (JSONException jSONException) {
        k.c("uppay", j.class.toString() + " get " + paramString + " failed!!");
        str2 = str1;
      }  
    return str2;
  }
  
  public static int b(JSONObject paramJSONObject, String paramString) {
    byte b = 0;
    int i = b;
    if (f(paramJSONObject, paramString))
      try {
        i = paramJSONObject.getInt(paramString);
      } catch (JSONException jSONException) {
        k.c("uppay", j.class.toString() + " get " + paramString + " failed!!");
        i = b;
      }  
    return i;
  }
  
  public static Object b(JSONArray paramJSONArray, int paramInt) {
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
  
  public static JSONObject c(JSONObject paramJSONObject, String paramString) {
    JSONObject jSONObject1 = null;
    JSONObject jSONObject2 = jSONObject1;
    if (f(paramJSONObject, paramString))
      try {
        jSONObject2 = paramJSONObject.getJSONObject(paramString);
      } catch (JSONException jSONException) {
        k.c("uppay", j.class.toString() + " get " + paramString + " failed!!");
        jSONObject2 = jSONObject1;
      }  
    return jSONObject2;
  }
  
  public static JSONArray d(JSONObject paramJSONObject, String paramString) {
    JSONArray jSONArray1 = null;
    JSONArray jSONArray2 = jSONArray1;
    if (f(paramJSONObject, paramString))
      try {
        jSONArray2 = paramJSONObject.getJSONArray(paramString);
      } catch (JSONException jSONException) {
        k.c("uppay", j.class.toString() + " get " + paramString + " failed!!");
        jSONArray2 = jSONArray1;
      }  
    return jSONArray2;
  }
  
  public static List<JSONArray> e(JSONObject paramJSONObject, String paramString) {
    ArrayList<JSONArray> arrayList = new ArrayList(1);
    JSONArray jSONArray = d(paramJSONObject, paramString);
    for (byte b = 0; jSONArray != null && b < jSONArray.length(); b++)
      arrayList.add((JSONArray)b(jSONArray, b)); 
    return arrayList;
  }
  
  private static boolean f(JSONObject paramJSONObject, String paramString) {
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */