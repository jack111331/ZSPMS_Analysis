package com.cmic.sso.sdk.auth;

import android.os.Bundle;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class c {
  public static JSONObject a(String paramString1, String paramString2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("resultCode", paramString1);
      jSONObject.put("resultDesc", paramString2);
    } catch (JSONException jSONException) {
      Log.e("AuthnResult", "JSONException", (Throwable)jSONException);
    } 
    return jSONObject;
  }
  
  static JSONObject a(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload_2
    //   10: ldc 'authtype'
    //   12: ldc '0'
    //   14: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   20: invokevirtual intValue : ()I
    //   23: istore #5
    //   25: aload_2
    //   26: ldc 'networkType'
    //   28: invokevirtual getInt : (Ljava/lang/String;)I
    //   31: istore #6
    //   33: iload #5
    //   35: tableswitch default -> 60, 2 -> 199, 3 -> 210, 4 -> 238
    //   60: ldc '0'
    //   62: astore #7
    //   64: ldc '其他'
    //   66: astore #8
    //   68: aload #4
    //   70: ldc 'resultCode'
    //   72: aload_0
    //   73: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   76: pop
    //   77: new java/lang/StringBuilder
    //   80: astore #9
    //   82: aload #9
    //   84: invokespecial <init> : ()V
    //   87: aload #4
    //   89: ldc 'authType'
    //   91: aload #9
    //   93: aload #7
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc ''
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual toString : ()Ljava/lang/String;
    //   106: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload #4
    //   112: ldc 'authTypeDes'
    //   114: aload #8
    //   116: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: ldc '103000'
    //   122: aload_0
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: ifeq -> 249
    //   129: iconst_1
    //   130: aload_2
    //   131: ldc 'logintype'
    //   133: iconst_0
    //   134: invokevirtual getInt : (Ljava/lang/String;I)I
    //   137: if_icmpne -> 154
    //   140: aload #4
    //   142: ldc 'openId'
    //   144: aload_2
    //   145: ldc 'openId'
    //   147: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: aload #4
    //   156: ldc 'token'
    //   158: aload_3
    //   159: ldc 'token'
    //   161: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   164: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: ldc 'AuthnResult'
    //   170: new java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial <init> : ()V
    //   177: ldc '返回参数:'
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload #4
    //   184: invokevirtual toString : ()Ljava/lang/String;
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload #4
    //   198: areturn
    //   199: ldc '7'
    //   201: astore #7
    //   203: ldc '短信验证码'
    //   205: astore #8
    //   207: goto -> 68
    //   210: iload #6
    //   212: iconst_3
    //   213: if_icmpne -> 227
    //   216: ldc 'WIFI下网关鉴权'
    //   218: astore #8
    //   220: ldc '1'
    //   222: astore #7
    //   224: goto -> 68
    //   227: ldc '网关鉴权'
    //   229: astore #8
    //   231: ldc '2'
    //   233: astore #7
    //   235: goto -> 68
    //   238: ldc '3'
    //   240: astore #7
    //   242: ldc '短信上行'
    //   244: astore #8
    //   246: goto -> 68
    //   249: aload #4
    //   251: ldc 'resultDesc'
    //   253: aload_1
    //   254: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   257: pop
    //   258: goto -> 168
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual printStackTrace : ()V
    //   266: goto -> 168
    // Exception table:
    //   from	to	target	type
    //   9	33	261	java/lang/Exception
    //   68	154	261	java/lang/Exception
    //   154	168	261	java/lang/Exception
    //   249	258	261	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\auth\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */