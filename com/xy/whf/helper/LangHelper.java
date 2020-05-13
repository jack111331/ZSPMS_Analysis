package com.xy.whf.helper;

import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LangHelper {
  public static boolean isNullOrEmpty(Object paramObject) {
    boolean bool = true;
    if (paramObject != null) {
      if (paramObject instanceof String) {
        if (((String)paramObject).length() != 0)
          bool = false; 
        return bool;
      } 
      if (paramObject instanceof List) {
        if (((List)paramObject).size() != 0)
          bool = false; 
        return bool;
      } 
      if (paramObject instanceof HashMap) {
        if (((HashMap)paramObject).size() != 0)
          bool = false; 
        return bool;
      } 
      if (paramObject instanceof JSONArray) {
        if (((JSONArray)paramObject).length() != 0)
          bool = false; 
        return bool;
      } 
      if (paramObject instanceof JSONObject) {
        if (((JSONObject)paramObject).length() != 0)
          bool = false; 
        return bool;
      } 
      bool = false;
    } 
    return bool;
  }
  
  public static boolean isNullOrEmpty(Object[] paramArrayOfObject) {
    return (paramArrayOfObject == null || paramArrayOfObject.length == 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\LangHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */