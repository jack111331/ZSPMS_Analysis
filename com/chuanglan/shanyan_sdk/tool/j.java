package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.os.SystemClock;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import com.chuanglan.shanyan_sdk.b;
import com.chuanglan.shanyan_sdk.utils.AbActivityUtils;
import com.chuanglan.shanyan_sdk.utils.AbObtainUtil;
import com.chuanglan.shanyan_sdk.utils.AbUniqueCodeUtil;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.utils.Base64;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
  private static j a = null;
  
  private Context b;
  
  public static j a() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/j.a : Lcom/chuanglan/shanyan_sdk/tool/j;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/tool/h
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/j.a : Lcom/chuanglan/shanyan_sdk/tool/j;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/tool/j
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/tool/j.a : Lcom/chuanglan/shanyan_sdk/tool/j;
    //   27: ldc com/chuanglan/shanyan_sdk/tool/h
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/tool/j.a : Lcom/chuanglan/shanyan_sdk/tool/j;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/tool/h
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean) {
    try {
      String str1 = AbUniqueCodeUtil.getNetworkTime();
      String str2 = AbUniqueCodeUtil.getUUID();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      String str4 = stringBuilder.append("device=").append(AppSysMgr.getManufacturer()).append("|ip=").append(AppSysMgr.getIP(this.b)).append("|DID=").append(SPTool.get(this.b, "DID", "")).append("|uuid=").append(SPTool.get(this.b, "uuid", "")).toString();
      String str3 = (String)SPTool.get(this.b, "appId", "");
      String str5 = (String)SPTool.get(this.b, "appKey", "");
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      hashMap.put("appId", str3);
      hashMap.put("accessToken", paramString2);
      hashMap.put("telecom", paramString1);
      hashMap.put("timestamp", str1);
      hashMap.put("randoms", str2);
      hashMap.put("version", "2.2.1");
      hashMap.put("device", Base64.encode(str4.getBytes()));
      String str6 = AbObtainUtil.getSign(hashMap, str5);
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("appId", str3);
      jSONObject.put("accessToken", paramString2);
      jSONObject.put("telecom", paramString1);
      jSONObject.put("timestamp", str1);
      jSONObject.put("randoms", str2);
      jSONObject.put("sign", str6);
      jSONObject.put("version", "2.2.1");
      jSONObject.put("device", Base64.encode(str4.getBytes()));
      if (paramBoolean)
        b(); 
      paramString1 = jSONObject.toString();
      h.a().a(1000, paramString1, paramString2, SystemClock.uptimeMillis() - b.O);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  private void b() {
    if (ShanYanOneKeyActivity.a != null && ShanYanOneKeyActivity.a.get() != null)
      ((ShanYanOneKeyActivity)ShanYanOneKeyActivity.a.get()).finish(); 
  }
  
  private void b(String paramString, boolean paramBoolean) {
    (new Thread(new Runnable(this, paramString, paramBoolean) {
          public void run() {
            j.a(this.c, "CTCC", this.a, this.b);
          }
        })).start();
  }
  
  public void a(Context paramContext) {
    this.b = paramContext;
  }
  
  public void a(String paramString, boolean paramBoolean) {
    CtSetting ctSetting = new CtSetting(((Integer)SPTool.get(this.b, "openLoginAuthTimeOut", Integer.valueOf(4))).intValue() * 1000 / 2, ((Integer)SPTool.get(this.b, "openLoginAuthTimeOut", Integer.valueOf(4))).intValue() * 1000 / 2, ((Integer)SPTool.get(this.b, "openLoginAuthTimeOut", Integer.valueOf(8))).intValue() * 1000);
    if (AppStringUtils.isNotEmpty(paramString)) {
      CtAuth.getInstance().requestLogin(paramString, ctSetting, new ResultListener(this, paramBoolean) {
            public void onResult(String param1String) {
              try {
                JSONObject jSONObject = new JSONObject();
                this(param1String);
                i = jSONObject.optInt("result");
                if (i == 0) {
                  jSONObject = jSONObject.optJSONObject("responseData");
                  if (jSONObject != null) {
                    String str2 = jSONObject.optString("accessToken");
                    if (AppStringUtils.isNotEmpty(str2)) {
                      j.a(this.b, str2, this.a);
                      return;
                    } 
                    h h2 = h.a();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    this();
                    String str3 = stringBuilder3.append("requestLogin()").append(param1String).toString();
                    stringBuilder3 = new StringBuilder();
                    this();
                    h2.a(1021, str3, 4, stringBuilder3.append(i).append("").toString(), AbActivityUtils.getCTCCResMsg(param1String), SystemClock.uptimeMillis() - b.O);
                    if (this.a)
                      j.a(this.b); 
                    return;
                  } 
                  h h1 = h.a();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  this();
                  String str1 = stringBuilder1.append("requestLogin()").append(param1String).toString();
                  StringBuilder stringBuilder2 = new StringBuilder();
                  this();
                  h1.a(1021, str1, 4, stringBuilder2.append(i).append("").toString(), AbActivityUtils.getCTCCResMsg(param1String), SystemClock.uptimeMillis() - b.O);
                  if (this.a)
                    j.a(this.b); 
                  return;
                } 
              } catch (JSONException jSONException) {
                h.a().a(1014, "requestLogin()" + jSONException.toString(), 4, "1014", jSONException.getClass().getName(), SystemClock.uptimeMillis() - b.O);
                jSONException.printStackTrace();
                if (this.a)
                  j.a(this.b); 
                return;
              } 
              h h = h.a();
              StringBuilder stringBuilder = new StringBuilder();
              this();
              int i;
              String str = stringBuilder.append("requestLogin()").append((String)jSONException).toString();
              stringBuilder = new StringBuilder();
              this();
              h.a(1021, str, 4, stringBuilder.append(i).append("").toString(), AbActivityUtils.getCTCCResMsg((String)jSONException), SystemClock.uptimeMillis() - b.O);
              if (this.a)
                j.a(this.b); 
            }
          });
      return;
    } 
    h.a().a(1021, "requestLogin() accessCode为空", 4, "1021", "requestLogin() accessCode为空", SystemClock.uptimeMillis() - b.O);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */