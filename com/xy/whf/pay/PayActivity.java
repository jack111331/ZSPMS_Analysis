package com.xy.whf.pay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.xy.whf.a.a.a;
import com.xy.whf.base.RootActivity;
import com.xy.whf.entity.AliResult;
import com.xy.whf.entity.StatusCode;
import com.xy.whf.entity.UrlEntity;
import com.xy.whf.helper.EnvironmentHelper;
import com.xy.whf.helper.LangHelper;
import com.xy.whf.helper.b;
import com.xy.whf.helper.g;
import com.xy.whf.helper.h;
import com.xy.whf.helper.l;
import com.xy.whf.widget.TipToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class PayActivity extends RootActivity {
  public static final int CODE_LOGIN_INT = 202;
  
  public static final int CODE_PRE_AUTHORIZATION_INT = 201;
  
  public static final String PARAM_SDK_PARAMETERS = "sdkParameters";
  
  public static final String PARAM_URL_STRING = "url";
  
  private static ResultListener e;
  
  protected Handler a = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        switch (param1Message.what) {
          default:
            return;
          case 201:
            if (param1Message.obj != null)
              PayActivity.a(this.a, (Map)param1Message.obj); 
          case 202:
            break;
        } 
        if (param1Message.obj != null) {
          Map map = (Map)param1Message.obj;
          AliResult aliResult = new AliResult(map, true);
          String str = aliResult.getResultStatus();
          try {
            if (TextUtils.equals(str, "9000") && TextUtils.equals(aliResult.getResultCode(), "200")) {
              str = (String)map.get("redirectUrl");
              String str1 = aliResult.getAuthCode();
              WebView webView = this.a.mWebView;
              StringBuilder stringBuilder = new StringBuilder();
              this();
              webView.loadUrl(stringBuilder.append(str).append("&auth_code=").append(str1).toString());
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            this.a.finish();
          } 
          TipToast.showToast((Context)this.a, StatusCode.FAILED_NEGATIVE_2.getMessage());
          PayActivity payActivity = this.a;
          ValueCallback<String> valueCallback = new ValueCallback<String>() {
              public void a(String param2String) {
                int i;
                if (TextUtils.isEmpty(param2String)) {
                  this.a.a.finish();
                  return;
                } 
                try {
                  param2String = param2String.replace("\\\"", "\"");
                  param2String = param2String.substring(1, param2String.length() - 1);
                  StringBuilder stringBuilder = new StringBuilder();
                  this();
                  h.a(stringBuilder.append("value1:").append(param2String).toString());
                  JSONObject jSONObject = new JSONObject();
                  this(param2String);
                  param2String = jSONObject.optString("zfbCallBackUrl");
                  i = jSONObject.optInt("isFinish", -1);
                  if (!TextUtils.isEmpty(param2String)) {
                    WebView webView = this.a.a.mWebView;
                    Runnable runnable = new Runnable() {
                        public void run() {
                          this.b.a.a.mWebView.loadUrl(this.a);
                        }
                      };
                    super(this, param2String);
                    webView.post(runnable);
                    return;
                  } 
                } catch (Exception exception) {
                  exception.printStackTrace();
                  this.a.a.finish();
                  return;
                } 
                if (i == 0)
                  this.a.a.finish(); 
              }
            };
          super(this);
          payActivity.exec("authExitCallBack()", valueCallback);
        } 
        this.a.finish();
      }
    };
  
  private List<String> b = new ArrayList<String>();
  
  private String c;
  
  private String d;
  
  private WebViewClient f = new WebViewClient(this) {
      public void onPageFinished(WebView param1WebView, String param1String) {
        super.onPageFinished(param1WebView, param1String);
        h.a("onPageFinished:" + param1String);
        try {
          CookieSyncManager.createInstance((Context)this.a);
          CookieManager cookieManager = CookieManager.getInstance();
          cookieManager.setAcceptCookie(true);
          CookieSyncManager.getInstance().sync();
          if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.flush();
            cookieManager.setAcceptThirdPartyCookies(param1WebView, true);
          } 
          StringBuilder stringBuilder = new StringBuilder();
          this();
          h.a(stringBuilder.append("onPageFinished Cookies = ").append(b.a(param1String)).toString());
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      }
      
      public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
        super.onPageStarted(param1WebView, param1String, param1Bitmap);
        h.a("onPageStarted:" + param1String);
      }
      
      public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
        boolean bool = true;
        h.a("shouldOverrideUrlLoading:" + param1String);
        if (param1String.startsWith("http:") || param1String.startsWith("https:")) {
          try {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            this();
            hashMap.put("Referer", this.a.mWebView.getUrl());
            this.a.mWebView.loadUrl(param1String, hashMap);
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          PayActivity.a(this.a, param1String);
          return false;
        } 
        if (param1String.startsWith("weixin://wap/pay")) {
          try {
            Intent intent = new Intent();
            this();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(param1String));
            this.a.startActivity(intent);
          } catch (ActivityNotFoundException activityNotFoundException) {
            activityNotFoundException.printStackTrace();
            TipToast.showToast((Context)this.a, "微信支付失败，请检查是否安装微信");
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          return bool;
        } 
        if (param1String.startsWith("alipays://")) {
          try {
            Intent intent = new Intent();
            this();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(param1String));
            this.a.startActivity(intent);
          } catch (ActivityNotFoundException activityNotFoundException) {
            activityNotFoundException.printStackTrace();
            TipToast.showToast((Context)this.a, "未检测到支付宝");
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          return bool;
        } 
        if (param1String.startsWith("intent://")) {
          try {
            Intent intent = Intent.parseUri(param1String, 1);
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            this.a.startActivity(intent);
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          return bool;
        } 
        try {
          Intent intent = new Intent();
          this();
          intent.setAction("android.intent.action.VIEW");
          intent.setData(Uri.parse(param1String));
          this.a.startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException) {
          activityNotFoundException.printStackTrace();
          TipToast.showToast((Context)this.a, "加载失败，请联系相关技术支持");
          bool = false;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return bool;
      }
    };
  
  private WebChromeClient g = new WebChromeClient(this) {
      public boolean onJsAlert(WebView param1WebView, String param1String1, String param1String2, JsResult param1JsResult) {
        null = true;
        try {
          JSONObject jSONObject = new JSONObject();
          this(param1String2);
          String str = jSONObject.optString("zfbCallBackUrl");
          int i = jSONObject.optInt("isFinish", -1);
          if (!TextUtils.isEmpty(str)) {
            WebView webView = this.a.mWebView;
            Runnable runnable = new Runnable() {
                public void run() {
                  this.c.a.loadUrl(this.a);
                  this.b.confirm();
                }
              };
            super(this, str, param1JsResult);
            webView.post(runnable);
            return null;
          } 
          if (i == 0) {
            this.a.finish();
            param1JsResult.confirm();
            return null;
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          this.a.finish();
          param1JsResult.confirm();
        } 
        return super.onJsAlert(param1WebView, param1String1, param1String2, param1JsResult);
      }
    };
  
  public WebView mWebView;
  
  private View a() {
    RelativeLayout relativeLayout = new RelativeLayout((Context)this);
    relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mWebView = new WebView((Context)this);
    relativeLayout.addView((View)this.mWebView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    return (View)relativeLayout;
  }
  
  private void a(String paramString) {
    if (paramString.startsWith("http://") || paramString.startsWith("https://"))
      this.b.add(paramString); 
  }
  
  private void a(Map<String, String> paramMap) {
    StringBuilder stringBuilder;
    try {
      AliResult aliResult = new AliResult();
      this(paramMap, false);
      String str = paramMap.get("returnUrl");
      stringBuilder = new StringBuilder();
      this();
      if (!LangHelper.isNullOrEmpty(str)) {
        UrlEntity urlEntity = l.a(str);
        stringBuilder.append(urlEntity.baseUrl).append("?");
        HashMap<Object, Object> hashMap = urlEntity.getParams();
        if (LangHelper.isNullOrEmpty(hashMap)) {
          hashMap = new HashMap<Object, Object>();
          this();
        } 
        hashMap.put("resultCode", aliResult.getResultStatus());
        for (String str1 : hashMap.keySet())
          stringBuilder.append(str1).append("=").append(hashMap.get(str1)).append("&"); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      finish();
      return;
    } 
    this.mWebView.loadUrl(stringBuilder.substring(0, stringBuilder.length() - 1));
  }
  
  private void b() {
    d();
  }
  
  private void c() {
    Uri uri = getIntent().getData();
    this.c = getIntent().getStringExtra("url");
    this.d = getIntent().getStringExtra("sdkParameters");
    if (!LangHelper.isNullOrEmpty(this.c)) {
      getIntent().putExtra("url", "");
      e();
      loadUrl(this.c);
      return;
    } 
    if (uri != null) {
      String str = "http:" + uri.toString().substring("whfpay:".length());
      getIntent().setData(null);
      loadUrl(str);
    } 
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void d() {
    String str3;
    WebSettings webSettings = this.mWebView.getSettings();
    webSettings.setDefaultTextEncodingName("UTF-8");
    webSettings.setSaveFormData(false);
    webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setUseWideViewPort(true);
    webSettings.setAllowFileAccess(true);
    webSettings.setDomStorageEnabled(true);
    webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    String str1 = " whfpaysdk " + " deviceId:" + a.d((Context)this) + " versionCode:3";
    String str2 = webSettings.getUserAgentString();
    if (str2 == null || str2.length() == 0) {
      str3 = str1;
    } else {
      str3 = str2;
      if (!str2.contains("whfpaysdk"))
        str3 = str2 + str1; 
    } 
    webSettings.setUserAgentString(str3);
    this.mWebView.addJavascriptInterface(new a(this, this.mWebView), "whfsdk");
    this.mWebView.setWebChromeClient(this.g);
    this.mWebView.setWebViewClient(this.f);
    this.mWebView.setDownloadListener(new DownloadListener(this) {
          public void onDownloadStart(String param1String1, String param1String2, String param1String3, String param1String4, long param1Long) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(param1String1));
            this.a.startActivity(intent);
          }
        });
  }
  
  private void e() {
    try {
      String str1 = g.a();
      String str2 = str1;
      if (LangHelper.isNullOrEmpty(str1))
        str2 = g.a((Context)this, "whfToken"); 
      CookieSyncManager.createInstance((Context)this);
      CookieManager cookieManager = CookieManager.getInstance();
      cookieManager.setAcceptCookie(true);
      if (!LangHelper.isNullOrEmpty(str2)) {
        String str = this.c;
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        cookieManager.setCookie(str, stringBuilder1.append("whfToken=").append(str2).append(";domain=").append(l.b(this.c)).append(";path=/;").toString());
      } 
      CookieSyncManager.getInstance().sync();
      if (Build.VERSION.SDK_INT >= 21) {
        cookieManager.setAcceptThirdPartyCookies(this.mWebView, true);
        cookieManager.flush();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      h.a(stringBuilder.append(EnvironmentHelper.getBaseUrl()).append(":").append(cookieManager.getCookie(EnvironmentHelper.getBaseUrl())).toString());
      stringBuilder = new StringBuilder();
      this();
      h.a(stringBuilder.append(this.c).append(":").append(cookieManager.getCookie(this.c)).toString());
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void startPay(Activity paramActivity, String paramString1, String paramString2, ResultListener paramResultListener) {
    Intent intent = new Intent((Context)paramActivity, PayActivity.class);
    intent.putExtra("url", paramString1);
    intent.putExtra("sdkParameters", paramString2);
    intent.addFlags(536870912);
    paramActivity.startActivity(intent);
    e = paramResultListener;
  }
  
  public void exec(String paramString, ValueCallback<String> paramValueCallback) {
    if (Build.VERSION.SDK_INT >= 19) {
      this.mWebView.evaluateJavascript("javascript:" + paramString, paramValueCallback);
      return;
    } 
    loadUrl("javascript:alert(" + paramString + ")");
  }
  
  public void handlePayStatus(int paramInt, String paramString1, String paramString2) {
    if (paramInt == 0 && !LangHelper.isNullOrEmpty(paramString2)) {
      if ("processing".equals(paramString2)) {
        e.result(StatusCode.FAILED_NEGATIVE_2.getCode(), StatusCode.FAILED_NEGATIVE_2.getMessage());
      } else if ("failed".equals(paramString2)) {
        e.result(StatusCode.FAILED_NEGATIVE_4.getCode(), StatusCode.FAILED_NEGATIVE_4.getMessage());
      } 
    } else {
      e.result(paramInt, paramString1);
    } 
    finish();
  }
  
  public void loadUrl(String paramString) {
    if (paramString.trim().length() > 0) {
      this.mWebView.loadUrl(paramString);
      a(paramString);
    } 
  }
  
  public void onBackPressed() {
    if (this.mWebView != null) {
      if (this.mWebView.canGoBack()) {
        this.mWebView.goBack();
        return;
      } 
      super.onBackPressed();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    setContentView(a());
    b();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
      setIntent(paramIntent); 
  }
  
  protected void onResume() {
    if (getRequestedOrientation() != 1)
      setRequestedOrientation(1); 
    super.onResume();
    c();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\pay\PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */