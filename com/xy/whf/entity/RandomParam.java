package com.xy.whf.entity;

import android.content.Context;
import com.xy.whf.helper.LangHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RandomParam {
  public String classType;
  
  public String fieldName = "";
  
  public int invokeType = 0;
  
  public String key = "";
  
  public String methodName = "";
  
  public String packageClassName = "";
  
  public List<Object> paramList = new ArrayList();
  
  public RandomParam(JSONObject paramJSONObject) {
    if (!LangHelper.isNullOrEmpty(paramJSONObject))
      try {
        this.packageClassName = paramJSONObject.optString("package_class_name", "");
        this.fieldName = paramJSONObject.optString("field_name", "");
        this.invokeType = paramJSONObject.optInt("invoke_type", 0);
        this.methodName = paramJSONObject.optString("method_name", "");
        this.key = paramJSONObject.optString("key", "");
        this.invokeType = paramJSONObject.optInt("invoke_type", 0);
        JSONArray jSONArray = paramJSONObject.optJSONArray("param_array");
        if (!LangHelper.isNullOrEmpty(jSONArray))
          while (b < jSONArray.length()) {
            this.paramList.add(jSONArray.opt(b));
            b++;
          }  
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public Class[] getClasss() {
    if (!LangHelper.isNullOrEmpty(this.classType)) {
      String[] arrayOfString = this.classType.split(",");
      Class[] arrayOfClass = new Class[arrayOfString.length];
      byte b = 0;
      while (b < arrayOfString.length) {
        switch (Integer.parseInt(arrayOfString[b])) {
          case 0:
            arrayOfClass[b] = Context.class;
            b++;
            break;
          case 1:
            arrayOfClass[b] = String.class;
            b++;
            break;
          case 2:
            arrayOfClass[b] = Integer.class;
            b++;
            break;
          case 3:
            arrayOfClass[b] = Long.class;
            b++;
            break;
          case 4:
            arrayOfClass[b] = Boolean.class;
            b++;
            break;
        } 
      } 
      return arrayOfClass;
    } 
    return null;
  }
  
  public Object[] getValues(Context paramContext) {
    Object[] arrayOfObject;
    if (!LangHelper.isNullOrEmpty(this.paramList)) {
      int i = this.paramList.size();
      Object[] arrayOfObject1 = new Object[i];
      arrayOfObject = arrayOfObject1;
      if (!LangHelper.isNullOrEmpty(this.paramList)) {
        byte b = 0;
        while (true) {
          arrayOfObject = arrayOfObject1;
          if (b < i) {
            if ("Context".equals(this.paramList.get(b))) {
              arrayOfObject1[b] = paramContext;
            } else {
              arrayOfObject1[b] = this.paramList.get(b);
            } 
            b++;
            continue;
          } 
          break;
        } 
      } 
    } else {
      arrayOfObject = null;
    } 
    return arrayOfObject;
  }
  
  public boolean isNeedContext() {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!LangHelper.isNullOrEmpty(this.classType)) {
      bool2 = bool1;
      if ("0".equals(this.classType.split(",")[0]))
        bool2 = true; 
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\entity\RandomParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */