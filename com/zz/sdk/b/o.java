package com.zz.sdk.b;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class o implements i, Serializable {
  public static final String A = "loginName";
  
  public static final String B = "projectId";
  
  public static final String C = "requestId";
  
  public static final String D = "serverId";
  
  public static final String E = "type";
  
  public static final String F = "cardNo";
  
  public static final String G = "cardPwd";
  
  public static final String H = "way";
  
  public static final String I = "cardAmount";
  
  public static final String J = "access_token";
  
  public static final String K = "cpOrder";
  
  public static final String L = "pType";
  
  private static final long M = 5L;
  
  public static final String v = "amount";
  
  public static final String w = "cardNo";
  
  public static final String x = "cardPwd";
  
  public static final String y = "gameRole";
  
  public static final String z = "imsi";
  
  public String a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  public String e;
  
  public String f;
  
  public String g;
  
  public String h;
  
  public String i;
  
  public String j;
  
  public String k;
  
  public String l;
  
  public String m;
  
  public String n;
  
  public String o;
  
  public String p;
  
  public String q;
  
  public String r;
  
  public String s;
  
  public String t;
  
  public HashMap u;
  
  public HashMap a(int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.q != null)
      hashMap.put("access_token", this.q); 
    if (this.s != null)
      hashMap.put("propName", this.s); 
    if (this.r != null)
      hashMap.put("propId", this.r); 
    if (this.p != null)
      hashMap.put("cpOrder", this.p); 
    switch (paramInt) {
      default:
        switch (paramInt) {
          default:
            if (this.u != null)
              for (Map.Entry entry : this.u.entrySet())
                hashMap.put(entry.getKey(), entry.getValue());  
            break;
          case 0:
            this.l = "ppali.lg";
          case 1:
          case 100:
            this.l = "pup/order_app.lg";
          case 2:
            this.l = "pten.lg";
          case 3:
          case 4:
          case 6:
          case 78:
          case 79:
            this.l = "pyee.lg";
          case 5:
            this.l = "pkkfun0.lg";
          case 1002:
            this.l = "pkfmm0.lg";
          case 1001:
            this.l = "pkkfunnt0.lg";
          case 7:
            this.l = "pzy.lg";
          case 9:
            this.l = "psin.lg";
          case 10:
            this.l = "pm9.lg";
          case 15:
            this.l = "pwc.lg";
          case 81:
            this.l = "wx/wapOrder.lg";
          case 17:
            this.l = "yybpo.lg";
          case 80:
            break;
        } 
        this.l = "jdpay.lg";
      case 10:
      case 15:
        if (paramInt == 15);
      case 81:
        if (paramInt == 81)
          hashMap.put("pType", String.valueOf(3)); 
      case 0:
      case 1:
      case 2:
      case 9:
      case 17:
      case 100:
        hashMap.put("loginName", this.a);
        hashMap.put("gameRole", this.b);
        hashMap.put("serverId", this.c);
        hashMap.put("projectId", this.e);
        hashMap.put("amount", this.d);
        hashMap.put("requestId", this.f);
      case 3:
      case 4:
      case 6:
      case 78:
      case 79:
        hashMap.put("loginName", this.a);
        hashMap.put("gameRole", this.b);
        hashMap.put("serverId", this.c);
        hashMap.put("projectId", this.e);
        hashMap.put("type", this.j);
        hashMap.put("amount", this.d);
        hashMap.put("requestId", this.f);
        hashMap.put("cardNo", this.h);
        hashMap.put("cardPwd", this.i);
        hashMap.put("cardAmount", this.o);
      case 5:
        hashMap.put("loginName", this.a);
        hashMap.put("gameRole", this.b);
        hashMap.put("serverId", this.c);
        hashMap.put("projectId", this.e);
        hashMap.put("requestId", this.f);
        hashMap.put("imsi", this.n);
        hashMap.put("amount", this.d);
      case 1002:
        hashMap.put("loginName", this.a);
        hashMap.put("imsi", this.n);
        hashMap.put("projectId", this.e);
      case 1001:
        hashMap.put("loginName", this.a);
        hashMap.put("imsi", this.n);
      case 7:
        hashMap.put("loginName", this.a);
        hashMap.put("gameRole", this.b);
        hashMap.put("serverId", this.c);
        hashMap.put("projectId", this.e);
        hashMap.put("amount", this.d);
        hashMap.put("requestId", this.f);
      case 80:
        hashMap.put("type", this.j);
        hashMap.put("gameRole", this.b);
        hashMap.put("loginName", this.a);
        hashMap.put("serverId", this.c);
        hashMap.put("projectId", this.e);
        hashMap.put("requestId", this.f);
        hashMap.put("amount", this.d);
    } 
    if (this.t != null)
      hashMap.put("way", this.t); 
    return hashMap;
  }
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("loginName", this.a);
      jSONObject.put("gameRole", this.b);
      jSONObject.put("serverId", this.c);
      jSONObject.put("amount", this.d);
      jSONObject.put("projectId", this.e);
      jSONObject.put("requestId", this.f);
      jSONObject.put("channelId", this.g);
      jSONObject.put("cardNo", this.h);
      jSONObject.put("cardPassword", this.i);
      jSONObject.put("type", this.j);
      jSONObject.put("callBackInfo", this.k);
      jSONObject.put("smsActionType", this.m);
      jSONObject.put("smsImsi", this.n);
      jSONObject.put("cardAmount", this.o);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    return (JSONObject)jSONException;
  }
  
  public void a(JSONObject paramJSONObject) {
    JSONObject jSONObject = null;
    if (paramJSONObject != null)
      try {
        String str1;
        String str2;
        if (paramJSONObject.isNull("loginName")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("loginName");
        } 
        this.a = str2;
        if (paramJSONObject.isNull("gameRole")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("gameRole");
        } 
        this.b = str2;
        if (paramJSONObject.isNull("serverId")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("serverId");
        } 
        this.c = str2;
        if (paramJSONObject.isNull("amount")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("amount");
        } 
        this.d = str2;
        if (paramJSONObject.isNull("projectId")) {
          str2 = "-1";
        } else {
          str2 = paramJSONObject.getString("projectId");
        } 
        this.e = str2;
        if (paramJSONObject.isNull("requestId")) {
          str2 = "-1";
        } else {
          str2 = paramJSONObject.getString("requestId");
        } 
        this.f = str2;
        if (paramJSONObject.isNull("channelId")) {
          str2 = "-1";
        } else {
          str2 = paramJSONObject.getString("channelId");
        } 
        this.g = str2;
        if (paramJSONObject.isNull("cardNo")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("cardNo");
        } 
        this.h = str2;
        if (paramJSONObject.isNull("cardPassword")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("cardPassword");
        } 
        this.i = str2;
        if (paramJSONObject.isNull("type")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("type");
        } 
        this.j = str2;
        if (paramJSONObject.isNull("callBackInfo")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("callBackInfo");
        } 
        this.k = str2;
        if (paramJSONObject.isNull("smsActionType")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("smsActionType");
        } 
        this.m = str2;
        if (paramJSONObject.isNull("smsImsi")) {
          str2 = null;
        } else {
          str2 = paramJSONObject.getString("smsImsi");
        } 
        this.n = str2;
        if (paramJSONObject.isNull("cardAmount")) {
          paramJSONObject = jSONObject;
        } else {
          str1 = paramJSONObject.getString("cardAmount");
        } 
        this.o = str1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public String b() {
    return "c";
  }
  
  public String toString() {
    return "Charge [gameRole=" + this.b + ", serverId=" + this.c + ", amount=" + this.d + ", projectId=" + this.e + ", cardNo=" + this.h + ", cardPassword=" + this.i + ", callBackInfo=" + this.k + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */