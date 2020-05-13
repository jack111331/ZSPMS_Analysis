package com.zz.sdk.b;

import android.util.Pair;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s implements i {
  public static final String p = "platformOrderNum";
  
  public static final String q = "url";
  
  public static final String r = "tn";
  
  public static final String s = "enablePayConfirm";
  
  public static final String t = "sdkuserid";
  
  public String a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public String h = "";
  
  public String i;
  
  public String j;
  
  public boolean k;
  
  public String l;
  
  public ArrayList m = null;
  
  public String n;
  
  public String o;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("codes", this.a);
      jSONObject.put("username", this.b);
      jSONObject.put("password", this.c);
      jSONObject.put("platformOrderNum", this.d);
      jSONObject.put("smsChannels", this.e);
      jSONObject.put("smsMoGap", this.f);
      jSONObject.put("cardAmount", this.n);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    boolean bool = false;
    JSONException jSONException = null;
    if (paramJSONObject != null) {
      String str1;
      String str2;
      try {
        String str;
        JSONArray jSONArray;
        if (paramJSONObject.optJSONArray("codes") != null) {
          if (paramJSONObject.isNull("codes")) {
            str = null;
          } else {
            str = paramJSONObject.getJSONArray("codes").getString(0);
          } 
          this.a = str;
        } else {
          if (paramJSONObject.isNull("codes")) {
            str = null;
          } else {
            str = paramJSONObject.getString("codes");
          } 
          this.a = str;
        } 
        if (paramJSONObject.isNull("username")) {
          str = null;
        } else {
          str = paramJSONObject.getString("username");
        } 
        this.b = str;
        if (paramJSONObject.isNull("password")) {
          str = null;
        } else {
          str = paramJSONObject.getString("password");
        } 
        this.c = str;
        if (paramJSONObject.isNull("platformOrderNum")) {
          str = null;
        } else {
          str = paramJSONObject.getString("platformOrderNum");
        } 
        this.d = str;
        if (paramJSONObject.isNull("smsChannels")) {
          str = null;
        } else {
          str = paramJSONObject.getString("smsChannels");
        } 
        this.e = str;
        if (paramJSONObject.isNull("smsMoGap")) {
          str = null;
        } else {
          str = paramJSONObject.getString("smsMoGap");
        } 
        this.f = str;
        if (paramJSONObject.isNull("payServerDesc")) {
          str = null;
        } else {
          str = paramJSONObject.getString("payServerDesc");
        } 
        this.g = str;
        if (paramJSONObject.isNull("cardAmount")) {
          str = null;
        } else {
          str = paramJSONObject.getString("cardAmount");
        } 
        this.n = str;
        if (paramJSONObject.isNull("payMessages")) {
          str = null;
        } else {
          jSONArray = paramJSONObject.getJSONArray("payMessages");
        } 
        if (jSONArray != null) {
          ArrayList arrayList = new ArrayList();
          this();
          this.m = arrayList;
          for (byte b = 0; b < jSONArray.length(); b++) {
            JSONObject jSONObject = jSONArray.getJSONObject(b);
            String str3 = jSONObject.getString("url");
            String str4 = jSONObject.getString("message");
            Pair pair = new Pair();
            this(str3, str4);
            this.m.add(pair);
          } 
        } 
      } catch (JSONException jSONException1) {
        jSONException1.printStackTrace();
        return;
      } 
      if (jSONException1.isNull("url")) {
        str2 = null;
      } else {
        str2 = jSONException1.getString("url");
      } 
      this.h = str2;
      if (jSONException1.isNull("tn")) {
        str2 = null;
      } else {
        str2 = jSONException1.getString("tn");
      } 
      this.i = str2;
      if (!jSONException1.isNull("enablePayConfirm"))
        bool = jSONException1.getBoolean("enablePayConfirm"); 
      this.k = bool;
      if (jSONException1.isNull("sdkuserid")) {
        jSONException1 = jSONException;
      } else {
        str1 = jSONException1.getString("sdkuserid");
      } 
      this.o = str1;
    } 
  }
  
  public String b() {
    return null;
  }
  
  public boolean c() {
    return "0".equals(this.a);
  }
  
  public String d() {
    return "支付失败！服务器出错！";
  }
  
  public String toString() {
    return "Result [codes=" + this.a + "&username=" + this.b + "&password=" + this.c + "&orderNumber=" + this.d + "&smsChannels=" + this.e + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */