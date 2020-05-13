package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class H5JavaScriptInterface {
  private static HashSet<Integer> a = new HashSet<Integer>();
  
  private String b = null;
  
  private Thread c = null;
  
  private String d = null;
  
  private Map<String, String> e = null;
  
  private static a a(String paramString) {
    if (paramString == null || paramString.length() <= 0)
      return null; 
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      a a = new a();
      this();
      a.a = jSONObject.getString("projectRoot");
      if (a.a == null)
        return null; 
      a.b = jSONObject.getString("context");
      if (a.b == null)
        return null; 
      a.c = jSONObject.getString("url");
      if (a.c == null)
        return null; 
      a.d = jSONObject.getString("userAgent");
      if (a.d == null)
        return null; 
      a.e = jSONObject.getString("language");
      if (a.e == null)
        return null; 
      a.f = jSONObject.getString("name");
      if (a.f == null || a.f.equals("null"))
        return null; 
      String str = jSONObject.getString("stacktrace");
      if (str == null)
        return null; 
      int i = str.indexOf("\n");
      if (i < 0) {
        x.d("H5 crash stack's format is wrong!", new Object[0]);
        return null;
      } 
      a.h = str.substring(i + 1);
      a.g = str.substring(0, i);
      i = a.g.indexOf(":");
      if (i > 0)
        a.g = a.g.substring(i + 1); 
      a.i = jSONObject.getString("file");
      if (a.f == null)
        return null; 
      a.j = jSONObject.getLong("lineNumber");
      if (a.j < 0L)
        return null; 
      a.k = jSONObject.getLong("columnNumber");
      if (a.k < 0L)
        return null; 
      x.a("H5 crash information is following: ", new Object[0]);
      StringBuilder stringBuilder = new StringBuilder();
      this("[projectRoot]: ");
      stringBuilder.append(a.a);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[context]: ");
      stringBuilder.append(a.b);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[url]: ");
      stringBuilder.append(a.c);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[userAgent]: ");
      stringBuilder.append(a.d);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[language]: ");
      stringBuilder.append(a.e);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[name]: ");
      stringBuilder.append(a.f);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[message]: ");
      stringBuilder.append(a.g);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[stacktrace]: \n");
      stringBuilder.append(a.h);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[file]: ");
      stringBuilder.append(a.i);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[lineNumber]: ");
      stringBuilder.append(a.j);
      x.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      this("[columnNumber]: ");
      stringBuilder.append(a.k);
      x.a(stringBuilder.toString(), new Object[0]);
      return a;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface paramWebViewInterface) {
    String str;
    StringBuilder stringBuilder2 = null;
    if (paramWebViewInterface == null || a.contains(Integer.valueOf(paramWebViewInterface.hashCode())))
      return null; 
    H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
    a.add(Integer.valueOf(paramWebViewInterface.hashCode()));
    h5JavaScriptInterface.c = Thread.currentThread();
    Thread thread = h5JavaScriptInterface.c;
    if (thread != null) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("\n");
      for (byte b = 2; b < (thread.getStackTrace()).length; b++) {
        StackTraceElement stackTraceElement = thread.getStackTrace()[b];
        if (!stackTraceElement.toString().contains("crashreport")) {
          stringBuilder2.append(stackTraceElement.toString());
          stringBuilder2.append("\n");
        } 
      } 
      str = stringBuilder2.toString();
    } 
    h5JavaScriptInterface.d = str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramWebViewInterface.getContentDescription());
    hashMap.put("[WebView] ContentDescription", stringBuilder1.toString());
    h5JavaScriptInterface.e = (Map)hashMap;
    return h5JavaScriptInterface;
  }
  
  @JavascriptInterface
  public void printLog(String paramString) {
    x.d("Log from js: %s", new Object[] { paramString });
  }
  
  @JavascriptInterface
  public void reportJSException(String paramString) {
    if (paramString == null) {
      x.d("Payload from JS is null.", new Object[0]);
      return;
    } 
    String str = z.b(paramString.getBytes());
    if (this.b != null && this.b.equals(str)) {
      x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
      return;
    } 
    this.b = str;
    x.d("Handling JS exception ...", new Object[0]);
    a a = a(paramString);
    if (a == null) {
      x.d("Failed to parse payload.", new Object[0]);
      return;
    } 
    LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>();
    LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>();
    if (a.a != null)
      linkedHashMap2.put("[JS] projectRoot", a.a); 
    if (a.b != null)
      linkedHashMap2.put("[JS] context", a.b); 
    if (a.c != null)
      linkedHashMap2.put("[JS] url", a.c); 
    if (a.d != null)
      linkedHashMap2.put("[JS] userAgent", a.d); 
    if (a.i != null)
      linkedHashMap2.put("[JS] file", a.i); 
    if (a.j != 0L)
      linkedHashMap2.put("[JS] lineNumber", Long.toString(a.j)); 
    linkedHashMap1.putAll(linkedHashMap2);
    linkedHashMap1.putAll(this.e);
    linkedHashMap1.put("Java Stack", this.d);
    Thread thread = this.c;
    if (a != null)
      InnerApi.postH5CrashAsync(thread, a.f, a.g, a.h, linkedHashMap1); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\h5\H5JavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */