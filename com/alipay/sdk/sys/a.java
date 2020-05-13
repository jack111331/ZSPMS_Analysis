package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.l;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  public static final String a = "\"&";
  
  public static final String b = "&";
  
  public static final String c = "bizcontext=\"";
  
  public static final String d = "bizcontext=";
  
  public static final String e = "\"";
  
  public static final String f = "appkey";
  
  public static final String g = "ty";
  
  public static final String h = "sv";
  
  public static final String i = "an";
  
  public static final String j = "setting";
  
  public static final String k = "av";
  
  public static final String l = "sdk_start_time";
  
  public static final String m = "UTF-8";
  
  private String n = "";
  
  private String o = "";
  
  private Context p = null;
  
  public a(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.n = packageInfo.versionName;
      this.o = packageInfo.packageName;
      this.p = paramContext.getApplicationContext();
    } catch (Exception exception) {}
  }
  
  private static String a(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 13
    //   9: aload_3
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   18: astore_0
    //   19: iconst_0
    //   20: istore #4
    //   22: iload #4
    //   24: aload_0
    //   25: arraylength
    //   26: if_icmpge -> 64
    //   29: aload_0
    //   30: iload #4
    //   32: aaload
    //   33: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   36: ifne -> 58
    //   39: aload_0
    //   40: iload #4
    //   42: aaload
    //   43: aload_2
    //   44: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   47: ifeq -> 58
    //   50: aload_0
    //   51: iload #4
    //   53: aaload
    //   54: astore_0
    //   55: goto -> 11
    //   58: iinc #4, 1
    //   61: goto -> 22
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -> 55
  }
  
  private String b(String paramString1, String paramString2) throws JSONException, UnsupportedEncodingException {
    String str = a("", "");
    return paramString1 + str + paramString2;
  }
  
  private String b(String paramString1, String paramString2, String paramString3) throws JSONException, UnsupportedEncodingException {
    paramString1 = paramString1.substring(paramString2.length());
    JSONObject jSONObject = new JSONObject(paramString1.substring(0, paramString1.length() - paramString3.length()));
    if (!jSONObject.has("appkey"))
      jSONObject.put("appkey", "2014052600006128"); 
    if (!jSONObject.has("ty"))
      jSONObject.put("ty", "and_lite"); 
    if (!jSONObject.has("sv"))
      jSONObject.put("sv", "h.a.3.5.2"); 
    if (!jSONObject.has("an") && (!this.o.contains("setting") || !l.d(this.p)))
      jSONObject.put("an", this.o); 
    if (!jSONObject.has("av"))
      jSONObject.put("av", this.n); 
    if (!jSONObject.has("sdk_start_time"))
      jSONObject.put("sdk_start_time", System.currentTimeMillis()); 
    String str = jSONObject.toString();
    return paramString2 + str + paramString3;
  }
  
  private static boolean b(String paramString) {
    return !paramString.contains("\"&");
  }
  
  private String c(String paramString) {
    try {
      String str1 = a(paramString, "&", "bizcontext=");
      if (TextUtils.isEmpty(str1)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        return stringBuilder1.append(paramString).append("&").append(b("bizcontext=", "")).toString();
      } 
      int i = paramString.indexOf(str1);
      String str2 = paramString.substring(0, i);
      String str3 = paramString.substring(i + str1.length());
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str2 = stringBuilder.append(str2).append(b(str1, "bizcontext=", "")).append(str3).toString();
      paramString = str2;
    } catch (Throwable throwable) {}
    return paramString;
  }
  
  private String d(String paramString) {
    try {
      String str1 = a(paramString, "\"&", "bizcontext=\"");
      if (TextUtils.isEmpty(str1)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        return stringBuilder1.append(paramString).append("&").append(b("bizcontext=\"", "\"")).toString();
      } 
      String str2 = str1;
      if (!str1.endsWith("\"")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        str2 = stringBuilder1.append(str1).append("\"").toString();
      } 
      int i = paramString.indexOf(str2);
      String str3 = paramString.substring(0, i);
      str1 = paramString.substring(i + str2.length());
      StringBuilder stringBuilder = new StringBuilder();
      this();
      str2 = stringBuilder.append(str3).append(b(str2, "bizcontext=\"", "\"")).append(str1).toString();
      paramString = str2;
    } catch (Throwable throwable) {}
    return paramString;
  }
  
  public final String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    String str = paramString;
    if (!paramString.startsWith("new_external_info==")) {
      boolean bool;
      if (!paramString.contains("\"&")) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        return c(paramString); 
      str = d(paramString);
    } 
    return str;
  }
  
  public final String a(String paramString1, String paramString2) {
    String str;
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("appkey", "2014052600006128");
      jSONObject.put("ty", "and_lite");
      jSONObject.put("sv", "h.a.3.5.2");
      if (!this.o.contains("setting") || !l.d(this.p))
        jSONObject.put("an", this.o); 
      jSONObject.put("av", this.n);
      jSONObject.put("sdk_start_time", System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString1))
        jSONObject.put(paramString1, paramString2); 
      paramString1 = jSONObject.toString();
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\sys\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */