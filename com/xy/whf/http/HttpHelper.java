package com.xy.whf.http;

import android.content.Context;
import com.xy.whf.a.a.a;
import com.xy.whf.helper.EnvironmentHelper;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.a;
import com.xy.whf.helper.g;
import com.xy.whf.helper.k;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class HttpHelper {
  private static HttpHelper INSTANCE;
  
  private Context context;
  
  private HttpHelper(Context paramContext) {
    this.context = paramContext;
  }
  
  public static HttpHelper getInstance(Context paramContext) {
    if (INSTANCE == null)
      INSTANCE = new HttpHelper(paramContext); 
    return INSTANCE;
  }
  
  public void appStart() {
    try {
      String str = g.a();
      JSONObject jSONObject3 = a.a(this.context);
      jSONObject1 = k.a(this.context);
      jSONObject2 = a.a(this.context);
      JSONObject jSONObject4 = new JSONObject();
      this();
      jSONObject4.put("whfToken", str);
      if (jSONObject3 != null && jSONObject3.length() > 0) {
        Iterator<String> iterator = jSONObject3.keys();
        while (iterator.hasNext()) {
          String str1 = iterator.next();
          jSONObject4.put(str1, jSONObject3.get(str1));
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
    if (jSONObject1 != null && jSONObject1.length() > 0) {
      Iterator<String> iterator = jSONObject1.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        exception.put(str, jSONObject1.get(str));
      } 
    } 
    if (jSONObject2 != null && jSONObject2.length() > 0) {
      Iterator<String> iterator = jSONObject2.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        exception.put(str, jSONObject2.get(str));
      } 
    } 
    HttpRequest httpRequest = HttpRequest.getInstance(this.context);
    StringBuilder stringBuilder = new StringBuilder();
    this();
    JSONObject jSONObject1;
    JSONObject jSONObject2;
    httpRequest.post(stringBuilder.append(EnvironmentHelper.getBaseUrl()).append("/log/appStart").toString(), (JSONObject)exception, (ResponseListener)null);
  }
  
  public void queryOrderStatus(String paramString, ResponseListener paramResponseListener) {
    try {
      HttpRequest httpRequest = HttpRequest.getInstance(this.context);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      httpRequest.get(stringBuilder.append(EnvironmentHelper.getBaseUrl()).append("/sdkParameters").append(paramString).toString(), paramResponseListener);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void whfPay(String paramString1, String paramString2, ResponseListener paramResponseListener) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      hashMap.put("sdkParameters", paramString2);
      if (LangHelper.isNullOrEmpty(paramString1)) {
        hashMap.put("appno", a.e(this.context));
      } else {
        hashMap.put("appno", paramString1);
      } 
      hashMap.put("deviceid", a.d(this.context));
      HttpRequest httpRequest = HttpRequest.getInstance(this.context);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      httpRequest.post(stringBuilder.append(EnvironmentHelper.getBaseUrl()).append("/gateway/init").toString(), (HashMap)hashMap, paramResponseListener);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\http\HttpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */