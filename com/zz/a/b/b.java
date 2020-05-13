package com.zz.a.b;

import org.json.JSONObject;

abstract class b {
  private static boolean a(String paramString) {
    return (paramString == null || paramString.length() == 0);
  }
  
  protected int a(JSONObject paramJSONObject, String paramString) {
    byte b1 = 0;
    int i = b1;
    if (!a(paramString)) {
      i = b1;
      if (paramJSONObject.has(paramString))
        i = paramJSONObject.getInt(paramString); 
    } 
    return i;
  }
  
  public abstract JSONObject a();
  
  public abstract void a(JSONObject paramJSONObject);
  
  protected void a(JSONObject paramJSONObject, String paramString, double paramDouble) {
    if (!a(paramString) && 0.0D != paramDouble)
      paramJSONObject.put(paramString, paramDouble); 
  }
  
  protected void a(JSONObject paramJSONObject, String paramString, int paramInt) {
    if (!a(paramString))
      paramJSONObject.put(paramString, paramInt); 
  }
  
  protected void a(JSONObject paramJSONObject, String paramString1, String paramString2) {
    if (!a(paramString1) && !a(paramString2))
      paramJSONObject.put(paramString1, paramString2); 
  }
  
  protected double b(JSONObject paramJSONObject, String paramString) {
    double d1 = 0.0D;
    double d2 = d1;
    if (!a(paramString)) {
      d2 = d1;
      if (paramJSONObject.has(paramString))
        d2 = paramJSONObject.getDouble(paramString); 
    } 
    return d2;
  }
  
  public abstract String b();
  
  public int c() {
    return 0;
  }
  
  protected String c(JSONObject paramJSONObject, String paramString) {
    String str1 = null;
    String str2 = str1;
    if (!a(paramString)) {
      str2 = str1;
      if (paramJSONObject.has(paramString))
        str2 = paramJSONObject.getString(paramString); 
    } 
    return str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */