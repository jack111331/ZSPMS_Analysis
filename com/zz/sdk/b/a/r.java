package com.zz.sdk.b.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class r extends a {
  private static final long m = 5940092051421273963L;
  
  private String A;
  
  private String B;
  
  private String C;
  
  private d D = new d();
  
  private int n;
  
  private ai o = new ai();
  
  private Map p = new HashMap<Object, Object>();
  
  private aw q = new aw();
  
  private int r;
  
  private int s;
  
  private int t;
  
  private String u;
  
  private String v;
  
  private String w;
  
  private int x;
  
  private int y;
  
  private String z;
  
  public String a(String paramString1, String paramString2, String paramString3) {
    Map map = (Map)this.p.get(paramString1);
    if (map != null) {
      String str = (String)map.get(paramString2);
      if (str != null)
        paramString3 = str; 
    } 
    return paramString3;
  }
  
  public void a(int paramInt) {
    this.n = paramInt;
  }
  
  public void a(String paramString) {
    this.w = paramString;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null)
      this.v = paramJSONObject.toString(); 
    super.a(paramJSONObject);
    this.n = paramJSONObject.optInt("buoy", 0);
    this.w = paramJSONObject.optString("noticeUrl");
    this.o.a(paramJSONObject.optJSONObject("realName"));
    this.p.clear();
    JSONObject jSONObject = paramJSONObject.optJSONObject("thirdLogin");
    if (jSONObject != null) {
      Iterator<String> iterator = jSONObject.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        JSONObject jSONObject1 = jSONObject.optJSONObject(str);
        if (jSONObject1 != null) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          Iterator<String> iterator1 = jSONObject1.keys();
          while (iterator1.hasNext()) {
            String str1 = iterator1.next();
            hashMap.put(str1, jSONObject1.optString(str1));
          } 
          this.p.put(str, hashMap);
        } 
      } 
    } 
    this.q.a(paramJSONObject.optJSONObject("reward"));
    this.r = paramJSONObject.optInt("payIcValidate", 0);
    this.s = paramJSONObject.optInt("payAdultNeed", 0);
    this.t = paramJSONObject.optInt("loginAdultNeed", 0);
    this.u = paramJSONObject.optString("findPwdURL", null);
    this.x = paramJSONObject.optInt("heartFreq", 10);
    this.y = paramJSONObject.optInt("agrEnabled", 0);
    this.z = paramJSONObject.optString("uagr", null);
    this.A = paramJSONObject.optString("pubuagr", null);
    this.B = paramJSONObject.optString("pagr", null);
    this.C = paramJSONObject.optString("pubpagr", null);
    this.D.a(paramJSONObject.optJSONObject("buoyConf"));
  }
  
  public String g() {
    return this.v;
  }
  
  public String h() {
    return this.w;
  }
  
  public int i() {
    return this.n;
  }
  
  public aw j() {
    return this.q;
  }
  
  public int k() {
    return this.r;
  }
  
  public int l() {
    return this.s;
  }
  
  public int m() {
    return this.t;
  }
  
  public String n() {
    return this.u;
  }
  
  public int o() {
    return this.x;
  }
  
  public int p() {
    return this.y;
  }
  
  public String q() {
    return this.z;
  }
  
  public String r() {
    return this.A;
  }
  
  public String s() {
    return this.B;
  }
  
  public String t() {
    return this.C;
  }
  
  public d u() {
    return this.D;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */