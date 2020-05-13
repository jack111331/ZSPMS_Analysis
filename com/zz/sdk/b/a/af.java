package com.zz.sdk.b.a;

import com.zz.sdk.b.k;
import org.json.JSONObject;

public class af extends a {
  protected static final String m = "cardAmount";
  
  protected static final String n = "payServerDesc";
  
  protected static final String o = "paies";
  
  protected static final String p = "zyCoin";
  
  protected static final String q = "activityContent";
  
  private static final long w = -8456103310324367514L;
  
  public String r;
  
  public String s;
  
  public k[] t;
  
  public Double u;
  
  public String v;
  
  public JSONObject a() {
    try {
      JSONObject jSONObject = super.a();
      jSONObject.put("zyCoin", String.valueOf(this.u));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (JSONObject)exception;
  }
  
  public void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial a : (Lorg/json/JSONObject;)V
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 'cardAmount'
    //   14: aconst_null
    //   15: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: putfield r : Ljava/lang/String;
    //   21: aload_0
    //   22: aload_1
    //   23: ldc 'payServerDesc'
    //   25: aconst_null
    //   26: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: putfield s : Ljava/lang/String;
    //   32: aload_1
    //   33: ldc 'paies'
    //   35: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull -> 50
    //   43: aload_2
    //   44: invokevirtual length : ()I
    //   47: ifne -> 90
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield t : [Lcom/zz/sdk/b/k;
    //   55: aload_1
    //   56: ldc 'zyCoin'
    //   58: invokevirtual optDouble : (Ljava/lang/String;)D
    //   61: dstore_3
    //   62: dload_3
    //   63: invokestatic isNaN : (D)Z
    //   66: ifeq -> 153
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_0
    //   72: aload_2
    //   73: putfield u : Ljava/lang/Double;
    //   76: aload_0
    //   77: aload_1
    //   78: ldc 'activityContent'
    //   80: aconst_null
    //   81: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: putfield v : Ljava/lang/String;
    //   87: goto -> 4
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual length : ()I
    //   95: anewarray com/zz/sdk/b/k
    //   98: putfield t : [Lcom/zz/sdk/b/k;
    //   101: iconst_0
    //   102: istore #5
    //   104: aload_2
    //   105: invokevirtual length : ()I
    //   108: istore #6
    //   110: iload #5
    //   112: iload #6
    //   114: if_icmpge -> 55
    //   117: aload_0
    //   118: getfield t : [Lcom/zz/sdk/b/k;
    //   121: iload #5
    //   123: new com/zz/sdk/b/k
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: aastore
    //   131: aload_0
    //   132: getfield t : [Lcom/zz/sdk/b/k;
    //   135: iload #5
    //   137: aaload
    //   138: aload_2
    //   139: iload #5
    //   141: invokevirtual optJSONObject : (I)Lorg/json/JSONObject;
    //   144: invokevirtual a : (Lorg/json/JSONObject;)V
    //   147: iinc #5, 1
    //   150: goto -> 110
    //   153: dload_3
    //   154: invokestatic valueOf : (D)Ljava/lang/Double;
    //   157: astore_2
    //   158: goto -> 71
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\a\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */