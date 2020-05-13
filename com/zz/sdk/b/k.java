package com.zz.sdk.b;

import com.zz.sdk.i.bp;
import org.json.JSONException;
import org.json.JSONObject;

public class k implements i {
  static final String E = "id";
  
  static final String F = "serverId";
  
  static final String G = "type";
  
  static final String H = "desc";
  
  static final String I = "name";
  
  static final String J = "hot";
  
  static final String K = "notifyUrl";
  
  static final String L = "cardAmount";
  
  private static final String M = "1000,3000,5000,10000,50000,500000";
  
  private static final int N = 1000;
  
  public static final int a = 0;
  
  public static final int b = 1;
  
  public static final int c = 2;
  
  public static final int d = 3;
  
  public static final int e = 4;
  
  public static final int f = 5;
  
  public static final int g = 6;
  
  public static final int h = 7;
  
  public static final int i = 9;
  
  public static final int j = 10;
  
  public static final int k = 15;
  
  public static final int l = 17;
  
  public static final int m = 80;
  
  public static final int n = 78;
  
  public static final int o = 79;
  
  public static final int p = 81;
  
  public static final int q = 82;
  
  public static final int r = 100;
  
  public static final int s = 101;
  
  public static final int t = 1001;
  
  public static final int u = 1002;
  
  public static final String[] v = new String[82];
  
  public String A;
  
  public int B;
  
  public String C;
  
  public int D;
  
  public String w;
  
  public String x;
  
  public String y;
  
  public String z;
  
  static {
    v[0] = "支付宝";
    v[80] = "京东支付";
    v[1] = "银联卡";
    v[2] = "财付通";
    v[3] = "联通卡";
    v[4] = "移动卡";
    v[5] = "短信";
    v[6] = "电信卡";
    v[7] = "卓越币";
    v[9] = "微博";
    v[10] = "mo9";
    v[15] = "微信";
    v[78] = "盛大卡";
    v[79] = "骏网卡";
    v[17] = "游娱玩后付";
    v[81] = "微信";
  }
  
  public static String a(int paramInt) {
    if (paramInt >= 0 && paramInt < 82)
      return v[paramInt]; 
    if (paramInt == 100)
      return "大额支付"; 
    if (paramInt == 101)
      return "充值卡"; 
    bp.a("unknown paytype=" + paramInt);
    return "充值";
  }
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("id", this.w);
      jSONObject.put("name", this.x);
      jSONObject.put("desc", this.z);
      jSONObject.put("type", this.B);
      jSONObject.put("hot", this.D);
      jSONObject.put("notifyUrl", this.A);
      jSONObject.put("cardAmount", this.C);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      jSONException = null;
    } 
    return (JSONObject)jSONException;
  }
  
  public void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      this.w = paramJSONObject.optString("id", "-1");
      this.x = paramJSONObject.optString("name", null);
      this.y = paramJSONObject.optString("serverId", null);
      this.z = paramJSONObject.optString("desc", null);
      this.B = paramJSONObject.optInt("type", -1);
      this.D = paramJSONObject.optInt("hot", 0);
      this.A = paramJSONObject.optString("notifyUrl", null);
      this.C = paramJSONObject.optString("cardAmount", null);
      if (this.x == null)
        this.x = a(this.B); 
      if (this.C == null)
        this.C = "1000,3000,5000,10000,50000,500000"; 
    } 
  }
  
  public String b() {
    return "paies";
  }
  
  public boolean c() {
    boolean bool = true;
    switch (this.B) {
      default:
        bool = false;
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 9:
      case 10:
      case 15:
      case 17:
      case 78:
      case 79:
      case 80:
      case 81:
      case 100:
        break;
    } 
    return bool;
  }
  
  public String toString() {
    return "PayChannel [channelName=" + this.x + ", desc=" + this.z + ", notifyUrl=" + this.A + ", type=" + this.B + ", hot=" + this.D + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */