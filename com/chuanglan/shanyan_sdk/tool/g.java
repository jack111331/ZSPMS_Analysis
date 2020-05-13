package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.os.SystemClock;
import com.chuanglan.shanyan_sdk.b;
import com.chuanglan.shanyan_sdk.b.b;
import com.chuanglan.shanyan_sdk.b.e;
import com.chuanglan.shanyan_sdk.utils.AbObtainUtil;
import com.chuanglan.shanyan_sdk.utils.AbUniqueCodeUtil;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.L;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
  public static final String a = "Unknown_Operator";
  
  private static g b;
  
  private a c;
  
  private String d;
  
  private String e;
  
  private Context f;
  
  public static g a() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/g.b : Lcom/chuanglan/shanyan_sdk/tool/g;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/tool/g
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/g.b : Lcom/chuanglan/shanyan_sdk/tool/g;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/tool/g
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/tool/g.b : Lcom/chuanglan/shanyan_sdk/tool/g;
    //   27: ldc com/chuanglan/shanyan_sdk/tool/g
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/tool/g.b : Lcom/chuanglan/shanyan_sdk/tool/g;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/tool/g
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private String a(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      String str = jSONObject.optString("retMsg");
      paramString = str;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      L.d("ExceptionLogger", "getResMsg()Exception == " + jSONException.toString());
    } 
    return paramString;
  }
  
  private void a(int paramInt) {
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    try {
      c(paramInt);
      str1 = (String)SPTool.get(this.f, "cmccAppid", "");
      str2 = (String)SPTool.get(this.f, "cmccAppkey", "");
      str3 = (String)SPTool.get(this.f, "ctccAppid", "");
      str4 = (String)SPTool.get(this.f, "ctccAppkey", "");
      str5 = (String)SPTool.get(this.f, "cuccAppid", "");
      str6 = (String)SPTool.get(this.f, "cuccAppkey", "");
      String str = (String)SPTool.get(this.f, "appId", "");
      str7 = (String)SPTool.get(this.f, "appKey", "");
      str8 = (String)SPTool.get(this.f, "clientAppId", "");
      str9 = (String)SPTool.get(this.f, "clientAppkey", "");
      if (AppStringUtils.isEmpty(this.d)) {
        a(1016, paramInt, "AppId为空，请配置AppId", "-1", "1016", "check_error");
        return;
      } 
      if (AppStringUtils.isEmpty(this.e)) {
        a(1017, paramInt, "AppKey为空，请配置AppKey", "-1", "1016", "check_error");
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      a(1014, paramInt, "initSYSDK()" + exception.toString(), "-1", "", exception.getClass().getName());
      return;
    } 
    if (AppStringUtils.isEmpty(str1) || AppStringUtils.isEmpty(str2) || AppStringUtils.isEmpty(str3) || AppStringUtils.isEmpty(str4) || AppStringUtils.isEmpty(str5) || AppStringUtils.isEmpty(str6) || AppStringUtils.isEmpty((String)exception) || AppStringUtils.isEmpty(str7) || !this.d.equals(str8) || !this.e.equals(str9)) {
      SPTool.put(this.f, "clientAppId", this.d);
      SPTool.put(this.f, "clientAppkey", this.e);
      b(paramInt);
      return;
    } 
    Long long_2 = (Long)SPTool.get(this.f, "initTimestart", Long.valueOf(1L));
    Long long_1 = (Long)SPTool.get(this.f, "initFlag", Long.valueOf(3600L));
    if ((System.currentTimeMillis() - long_2.longValue()) / 1000L < long_1.longValue()) {
      if (((Integer)SPTool.get(this.f, "accOff", Integer.valueOf(0))).intValue() == 1) {
        a(1032, paramInt, "用户被禁用", "-1", "1032", "check_error");
        return;
      } 
      a(paramInt, "cache", true, "初始化成功");
      return;
    } 
    b(paramInt);
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2) {
    if (this.c != null)
      this.c.a(1022, paramInt, paramString2, paramString1, paramBoolean); 
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt) {
    Map map = com.chuanglan.shanyan_sdk.b.g.a().a(paramString2, "2.2.1", paramString1, paramString3, paramString4, paramString5, "", paramString6);
    (new com.chuanglan.shanyan_sdk.b.a("https://flash.253.com/flash/v2/accountInit", this.f)).a(map, (b)new e(this, paramInt) {
          public void a(String param1String) {
            try {
              if (AppStringUtils.isNotEmpty(param1String)) {
                JSONObject jSONObject = new JSONObject();
                this(param1String);
                String str = jSONObject.optString("retCode");
                if ("0".equals(str)) {
                  JSONObject jSONObject1 = jSONObject.optJSONObject("data");
                  if (jSONObject1 != null) {
                    String str3 = jSONObject1.optString("cmccAppid");
                    String str4 = jSONObject1.optString("cmccAppkey");
                    String str5 = jSONObject1.optString("cuccAppid");
                    String str6 = jSONObject1.optString("cuccAppkey");
                    String str7 = jSONObject1.optString("ctccAppid");
                    String str8 = jSONObject1.optString("ctccAppkey");
                    String str9 = jSONObject1.optString("appId");
                    String str10 = jSONObject1.optString("appKey");
                    String str11 = jSONObject1.optString("reportFlag");
                    String str12 = jSONObject1.optString("reportCount");
                    String str13 = jSONObject1.optString("reportMax");
                    String str14 = jSONObject1.optString("cmccPreFlag");
                    String str15 = jSONObject1.optString("cuccPreFlag");
                    String str16 = jSONObject1.optString("ctccPreFlag");
                    String str17 = jSONObject1.optString("initFlag");
                    String str1 = jSONObject1.optString("authPageFlag");
                    String str18 = jSONObject1.optString("preFailFlag");
                    String str19 = jSONObject1.optString("ispStatus");
                    String str20 = jSONObject1.optString("pks");
                    String str21 = jSONObject1.optString("ssl");
                    String str22 = jSONObject1.optString("cmccfn");
                    String str23 = jSONObject1.optString("accOff");
                    if (AppStringUtils.isNotEmpty(str22))
                      SPTool.put(g.a(this.b), "cmccfn", str22); 
                    if (AppStringUtils.isNotEmpty(str21))
                      SPTool.put(g.a(this.b), "ssl", str21); 
                    if (AppStringUtils.isNotEmpty(str23)) {
                      SPTool.put(g.a(this.b), "accOff", Integer.valueOf(Integer.parseInt(String.valueOf(str23))));
                      if (Integer.parseInt(String.valueOf(str23)) == 1) {
                        this.b.a(1032, this.a, "getOperatorData（）用户被禁用", "-1", "1032", "check_error");
                        return;
                      } 
                    } 
                    String str2 = jSONObject1.optString("sto");
                    if (AppStringUtils.isNotEmpty(str2) && str2.contains(",")) {
                      String[] arrayOfString = str2.split(",");
                      str21 = arrayOfString[0];
                      str2 = arrayOfString[1];
                      String str24 = arrayOfString[2];
                      SPTool.put(g.a(this.b), "initTimeOut", Integer.valueOf(Integer.parseInt(String.valueOf(str21))));
                      SPTool.put(g.a(this.b), "getPhoneInfoTimeOut", Integer.valueOf(Integer.parseInt(String.valueOf(str2))));
                      SPTool.put(g.a(this.b), "openLoginAuthTimeOut", Integer.valueOf(Integer.parseInt(String.valueOf(str24))));
                    } 
                    if (AppStringUtils.isNotEmpty(str1))
                      SPTool.put(g.a(this.b), "authPageFlag", Long.valueOf(Long.parseLong(str1))); 
                    if (AppStringUtils.isNotEmpty(str11))
                      SPTool.put(g.a(this.b), "reportFlag", Long.valueOf(Long.parseLong(str11))); 
                    if (AppStringUtils.isNotEmpty(str12))
                      SPTool.put(g.a(this.b), "reportCount", Long.valueOf(Long.parseLong(str12))); 
                    if (AppStringUtils.isNotEmpty(str13))
                      SPTool.put(g.a(this.b), "reportMax", Integer.valueOf(Integer.parseInt(str13))); 
                    if (AppStringUtils.isNotEmpty(str14))
                      SPTool.put(g.a(this.b), "cmccPreFlag", Long.valueOf(Long.parseLong(str14))); 
                    if (AppStringUtils.isNotEmpty(str15))
                      SPTool.put(g.a(this.b), "cuccPreFlag", Long.valueOf(Long.parseLong(str15))); 
                    if (AppStringUtils.isNotEmpty(str16))
                      SPTool.put(g.a(this.b), "ctccPreFlag", Long.valueOf(Long.parseLong(str16))); 
                    if (AppStringUtils.isEmpty(str17) || "0".equals(str17)) {
                      SPTool.put(g.a(this.b), "initFlag", Long.valueOf(3600L));
                    } else {
                      SPTool.put(g.a(this.b), "initFlag", Long.valueOf(Long.parseLong(str17)));
                    } 
                    if (AppStringUtils.isNotEmpty(str18))
                      SPTool.put(g.a(this.b), "preFailFlag", Long.valueOf(Long.parseLong(str18))); 
                    if (AppStringUtils.isNotEmpty(str20)) {
                      SPTool.put(g.a(this.b), "pks", str20);
                    } else {
                      SPTool.put(g.a(this.b), "pks", "0MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJaqWkyQhbQ6EbYBFaxhfblDc3wmzSV27D/CncV6b1dG9DW/9rPqKLP9TvpcxA8OTgQR/WZ1YKwtcHJurR83spkCAwEAAQ==");
                    } 
                    if (AppStringUtils.isNotEmpty(str19) && str19.length() == 3) {
                      SPTool.put(g.a(this.b), "cmccSwitch", Integer.valueOf(Integer.parseInt(String.valueOf(str19.charAt(0)))));
                      SPTool.put(g.a(this.b), "cuccSwitch", Integer.valueOf(Integer.parseInt(String.valueOf(str19.charAt(1)))));
                      SPTool.put(g.a(this.b), "ctccSwitch", Integer.valueOf(Integer.parseInt(String.valueOf(str19.charAt(2)))));
                    } 
                    if (AppStringUtils.isNotEmpty(str3) && AppStringUtils.isNotEmpty(str4) && AppStringUtils.isNotEmpty(str7) && AppStringUtils.isNotEmpty(str8) && AppStringUtils.isNotEmpty(str5) && AppStringUtils.isNotEmpty(str6)) {
                      SPTool.put(g.a(this.b), "initTimestart", Long.valueOf(System.currentTimeMillis()));
                      SPTool.put(g.a(this.b), "cmccAppid", str3);
                      SPTool.put(g.a(this.b), "cmccAppkey", str4);
                      SPTool.put(g.a(this.b), "ctccAppid", str7);
                      SPTool.put(g.a(this.b), "ctccAppkey", str8);
                      SPTool.put(g.a(this.b), "cuccAppid", str5);
                      SPTool.put(g.a(this.b), "cuccAppkey", str6);
                      SPTool.put(g.a(this.b), "appId", str9);
                      SPTool.put(g.a(this.b), "appKey", str10);
                      g.a(this.b, this.a, "初始化成功", false, "初始化成功");
                      return;
                    } 
                    g g3 = this.b;
                    int k = this.a;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    this();
                    g3.a(1002, k, param1String, "flash/v2/accountInit", stringBuilder2.append(str).append("").toString(), g.a(this.b, param1String));
                    return;
                  } 
                  g g2 = this.b;
                  int j = this.a;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this();
                  g2.a(1002, j, param1String, "flash/v2/accountInit", stringBuilder1.append(str).append("").toString(), g.a(this.b, param1String));
                  return;
                } 
                g g1 = this.b;
                int i = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                this();
                g1.a(1019, i, param1String, "flash/v2/accountInit", stringBuilder.append(str).append("").toString(), param1String);
                return;
              } 
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
              this.b.a(1014, this.a, "getOperatorInfo()" + jSONException.toString(), "flash/v2/accountInit", "1014", jSONException.getClass().getName());
              return;
            } 
            this.b.a(1002, this.a, (String)jSONException, "flash/v2/accountInit", "1002", (String)jSONException);
          }
          
          public void a(String param1String1, String param1String2) {
            this.b.a(1007, this.a, "getOperatorInfo()" + param1String1, "flash/v2/accountInit", "1007", param1String2);
          }
        }Boolean.valueOf(false), "");
  }
  
  private void b(int paramInt) {
    String str1 = AbUniqueCodeUtil.getUUID();
    String str2 = f.a(this.f);
    String str3 = f.b(this.f);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("appId", this.d);
    hashMap.put("client", "2");
    hashMap.put("bundleld", "");
    hashMap.put("packageName", str2);
    hashMap.put("randoms", str1);
    hashMap.put("version", "2.2.1");
    hashMap.put("packageSign", str3);
    String str4 = AbObtainUtil.getSign(hashMap, this.e);
    a(this.d, str3, str1, "2", str2, str4, paramInt);
  }
  
  private void c(int paramInt) {
    if (this.c != null)
      this.c.a(paramInt); 
  }
  
  public g a(a parama) {
    this.c = parama;
    return b;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {
    if (this.c != null)
      this.c.a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4); 
  }
  
  public void a(Context paramContext, String paramString1, String paramString2) {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramContext;
  }
  
  public void a(ExecutorService paramExecutorService, int paramInt) {
    paramExecutorService.execute(new Runnable(this, paramInt) {
          public void run() {
            b.D = System.currentTimeMillis();
            b.E = SystemClock.uptimeMillis();
            L.d("ProcessLogger", "initStart===processName=" + this.a);
            g.a(this.b, this.a);
          }
        });
  }
  
  public static interface a {
    void a(int param1Int);
    
    void a(int param1Int1, int param1Int2, String param1String1, String param1String2, String param1String3, String param1String4);
    
    void a(int param1Int1, int param1Int2, String param1String1, String param1String2, boolean param1Boolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */