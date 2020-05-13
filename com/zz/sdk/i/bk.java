package com.zz.sdk.i;

import com.zz.sdk.b.i;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bk {
  public static i a(Class<i> paramClass, String paramString) {
    if (paramString == null)
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      i i = paramClass.newInstance();
      i.a(jSONObject);
      return i;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InstantiationException instantiationException) {
      instantiationException.printStackTrace();
    } 
    return null;
  }
  
  public static i[] b(Class<?> paramClass, String paramString) {
    if (paramString == null)
      return null; 
    try {
      JSONArray jSONArray = new JSONArray();
      this(paramString);
      i[] arrayOfI = (i[])Array.newInstance(paramClass, jSONArray.length());
      byte b = 0;
      while (true) {
        i i;
        i[] arrayOfI1 = arrayOfI;
        if (b < jSONArray.length()) {
          i = (i)paramClass.newInstance();
          i.a(jSONArray.getJSONObject(b));
          arrayOfI[b] = i;
          b++;
          continue;
        } 
        return (i[])i;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InstantiationException instantiationException) {
      instantiationException.printStackTrace();
    } 
    return null;
  }
  
  public static i c(Class<i> paramClass, String paramString) {
    if (paramString == null)
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      i i = paramClass.newInstance();
      i.a(jSONObject);
      return i;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InstantiationException instantiationException) {
      instantiationException.printStackTrace();
    } 
    return null;
  }
  
  public static i[] d(Class<i> paramClass, String paramString) {
    if (paramString == null)
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      i i = paramClass.newInstance();
      if (!jSONObject.isNull(i.b())) {
        JSONArray jSONArray = jSONObject.getJSONArray(i.b());
        if (jSONArray != null) {
          i[] arrayOfI = (i[])Array.newInstance(paramClass, jSONArray.length());
          byte b = 0;
          while (true) {
            i i1;
            i[] arrayOfI1 = arrayOfI;
            if (b < jSONArray.length()) {
              i1 = paramClass.newInstance();
              i1.a(jSONArray.getJSONObject(b));
              arrayOfI[b] = i1;
              b++;
              continue;
            } 
            return (i[])i1;
          } 
        } 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } catch (InstantiationException instantiationException) {
      instantiationException.printStackTrace();
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */