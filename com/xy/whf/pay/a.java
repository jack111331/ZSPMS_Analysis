package com.xy.whf.pay;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import com.xy.whf.a.c;
import com.xy.whf.a.d;
import com.xy.whf.entity.RuleInfo;
import com.xy.whf.entity.StatusCode;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.StatusBarHelper;
import com.xy.whf.helper.e;
import com.xy.whf.helper.g;
import com.xy.whf.helper.h;
import com.xy.whf.widget.TipToast;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
  private PayActivity a;
  
  private WebView b;
  
  a(PayActivity paramPayActivity, WebView paramWebView) {
    this.a = paramPayActivity;
    this.b = paramWebView;
  }
  
  @JavascriptInterface
  public void exitSdk(String paramString) {
    try {
      if (!LangHelper.isNullOrEmpty(paramString)) {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        int i = jSONObject.optInt("retCode", 0);
        paramString = jSONObject.optString("retMsg", "");
        String str = jSONObject.optString("paystatus", "");
        this.a.handlePayStatus(i, paramString, str);
        return;
      } 
      this.a.finish();
    } catch (Exception exception) {
      exception.printStackTrace();
      this.a.handlePayStatus(StatusCode.FAILED_NEGATIVE_1.getCode(), StatusCode.FAILED_NEGATIVE_1.getMessage(), "");
    } 
  }
  
  @JavascriptInterface
  public String getAppInstallStatus(String paramString) {
    try {
      boolean bool = com.xy.whf.helper.a.a((Context)this.a, paramString);
      if (bool)
        return "0"; 
    } catch (Exception exception) {
      exception.printStackTrace();
      boolean bool = false;
      if (bool)
        return "0"; 
    } 
    return "1";
  }
  
  @JavascriptInterface
  public String getPublicData(String paramString) {
    if (!LangHelper.isNullOrEmpty(paramString))
      try {
        JSONArray jSONArray2 = new JSONArray();
        this(paramString);
        ArrayList<RuleInfo> arrayList = new ArrayList();
        this();
        for (byte b = 0; b < jSONArray2.length(); b++) {
          RuleInfo ruleInfo = new RuleInfo();
          this(jSONArray2.optJSONObject(b));
          arrayList.add(ruleInfo);
        } 
        JSONArray jSONArray1 = c.a((Context)this.a).a(arrayList);
        if (!LangHelper.isNullOrEmpty(jSONArray1))
          return jSONArray1.toString(); 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return (new JSONArray()).toString();
  }
  
  @JavascriptInterface
  public String getStatusBarHeight() {
    JSONObject jSONObject = new JSONObject();
    if (StatusBarHelper.supportTranslucent()) {
      DisplayMetrics displayMetrics = e.a((Context)this.a);
      try {
        jSONObject.put("statusBarHeight", StatusBarHelper.getStatusbarHeight((Context)this.a));
        jSONObject.put("widthPixels", displayMetrics.widthPixels);
        jSONObject.put("heightPixels", displayMetrics.heightPixels);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return jSONObject.toString();
  }
  
  @JavascriptInterface
  public void preAuthorization(String paramString) {
    try {
      if (!LangHelper.isNullOrEmpty(paramString)) {
        JSONObject jSONObject = new JSONObject();
        this(paramString);
        paramString = jSONObject.getString("orderStr");
        String str = jSONObject.getString("returnUrl");
        Runnable runnable = new Runnable() {
            public void run() {
              Map<String, String> map = (new PayTask((Activity)a.a(this.c))).payV2(this.a, true);
              map.put("returnUrl", this.b);
              Message message = new Message();
              message.what = 201;
              message.obj = map;
              (a.a(this.c)).a.sendMessage(message);
            }
          };
        super(this, paramString, str);
        Thread thread = new Thread();
        this(runnable);
        thread.start();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  @JavascriptInterface
  public String readWhfToken() {
    return g.a();
  }
  
  @JavascriptInterface
  public void saveWhfToken(String paramString) {
    g.b(paramString);
  }
  
  @JavascriptInterface
  public void sdkLogin(String paramString) {
    if (!LangHelper.isNullOrEmpty(paramString)) {
      try {
        if (com.xy.whf.helper.a.a((Context)this.a, "com.eg.android.AlipayGphone")) {
          Runnable runnable = new Runnable() {
              public void run() {
                try {
                  JSONObject jSONObject = new JSONObject();
                  this(this.a);
                  String str1 = jSONObject.getString("authInfo");
                  StringBuilder stringBuilder = new StringBuilder();
                  this();
                  h.a(stringBuilder.append("authInfo:").append(str1).toString());
                  String str2 = jSONObject.getString("redirectUrl");
                  AuthTask authTask = new AuthTask();
                  this((Activity)a.a(this.b));
                  Map<String, String> map = authTask.authV2(str1, true);
                  map.put("redirectUrl", str2);
                  Message message = new Message();
                  this();
                  message.what = 202;
                  message.obj = map;
                  (a.a(this.b)).a.sendMessage(message);
                } catch (Exception exception) {
                  exception.printStackTrace();
                } 
              }
            };
          super(this, paramString);
          Thread thread = new Thread();
          this(runnable);
          thread.start();
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
      TipToast.showToast((Context)this.a, "未检测到支付宝");
    } 
  }
  
  @JavascriptInterface
  public void setStatusMode(boolean paramBoolean) {
    try {
      PayActivity payActivity = this.a;
      Runnable runnable = new Runnable() {
          public void run() {
            if (this.a) {
              StatusBarHelper.setStatusBarDarkMode((Activity)a.a(this.b));
              return;
            } 
            StatusBarHelper.setStatusBarLightMode((Activity)a.a(this.b));
          }
        };
      super(this, paramBoolean);
      payActivity.runOnUiThread(runnable);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  @JavascriptInterface
  public void uploadPrivacyData(String paramString) {
    if (!LangHelper.isNullOrEmpty(paramString))
      try {
        JSONArray jSONArray = new JSONArray();
        this(paramString);
        ArrayList<RuleInfo> arrayList = new ArrayList();
        this();
        for (byte b = 0; b < jSONArray.length(); b++) {
          RuleInfo ruleInfo = new RuleInfo();
          this(jSONArray.optJSONObject(b));
          arrayList.add(ruleInfo);
        } 
        c c = c.a((Context)this.a);
        d d = new d() {
            public void a(JSONObject param1JSONObject) {}
          };
        super(this);
        c.a(arrayList, d);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\pay\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */