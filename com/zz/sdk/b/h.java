package com.zz.sdk.b;

import java.io.Serializable;
import org.json.JSONObject;

public class h implements i, Serializable {
  static final String A = "deviceRecvLimit";
  
  static final String B = "eventType";
  
  static final String C = "giftPkgName";
  
  static final String D = "gpId";
  
  static final String E = "instructions";
  
  static final String F = "isAbl";
  
  static final String G = "productId";
  
  static final String H = "receiveAble";
  
  static final String I = "recvEndTime";
  
  static final String J = "recvStartTime";
  
  static final String K = "status";
  
  static final String L = "surplus";
  
  static final String M = "total";
  
  static final String N = "uidRecvCount";
  
  static final String O = "uidRecvLimit";
  
  static final String P = "validEndTime";
  
  static final String Q = "validStartTime";
  
  static final String R = "worth";
  
  static final String S = "code";
  
  static final String T = "recvTime";
  
  private static final long U = -100409618048928128L;
  
  static final String x = "chargeAmountLimit";
  
  static final String y = "content";
  
  static final String z = "deviceRecvCount";
  
  public int a;
  
  public String b;
  
  public int c;
  
  public int d;
  
  public String e;
  
  public String f;
  
  public int g;
  
  public String h;
  
  public int i;
  
  public String j;
  
  public int k;
  
  public long l;
  
  public long m;
  
  public int n;
  
  public int o;
  
  public int p;
  
  public int q;
  
  public int r;
  
  public long s;
  
  public long t;
  
  public String u;
  
  public String v;
  
  public String w;
  
  public JSONObject a() {
    return null;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.optInt("chargeAmountLimit", -1);
      this.b = paramJSONObject.optString("content");
      this.c = paramJSONObject.optInt("deviceRecvCount", -1);
      this.d = paramJSONObject.optInt("deviceRecvLimit", -1);
      this.e = paramJSONObject.optString("eventType");
      this.f = paramJSONObject.optString("giftPkgName");
      this.g = paramJSONObject.optInt("gpId", -1);
      this.h = paramJSONObject.optString("instructions");
      this.i = paramJSONObject.optInt("isAbl", -1);
      this.j = paramJSONObject.optString("productId");
      this.k = paramJSONObject.optInt("receiveAble", -1);
      this.l = paramJSONObject.optLong("recvEndTime", -1L);
      this.m = paramJSONObject.optLong("recvStartTime", -1L);
      this.n = paramJSONObject.optInt("status", -1);
      this.o = paramJSONObject.optInt("surplus", -1);
      this.p = paramJSONObject.optInt("total", -1);
      this.q = paramJSONObject.optInt("uidRecvCount", -1);
      this.r = paramJSONObject.optInt("uidRecvLimit", -1);
      this.s = paramJSONObject.optLong("validEndTime", -1L);
      this.t = paramJSONObject.optLong("validStartTime", -1L);
      this.u = paramJSONObject.optString("worth");
      this.v = paramJSONObject.optString("code");
      this.w = paramJSONObject.optString("recvTime");
    } 
  }
  
  public String b() {
    return "giftInfo";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */