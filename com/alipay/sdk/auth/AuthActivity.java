package com.alipay.sdk.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.authjs.d;
import com.alipay.sdk.util.l;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public class AuthActivity extends Activity {
  static final String a = "params";
  
  static final String b = "redirectUri";
  
  private WebView c;
  
  private String d;
  
  private com.alipay.sdk.widget.a e;
  
  private Handler f;
  
  private boolean g;
  
  private boolean h;
  
  private Runnable i = new d(this);
  
  private void a() {
    try {
      if (this.e == null) {
        com.alipay.sdk.widget.a a1 = new com.alipay.sdk.widget.a();
        this(this, "正在加载");
        this.e = a1;
      } 
      this.e.a();
    } catch (Exception exception) {
      this.e = null;
    } 
  }
  
  private void a(com.alipay.sdk.authjs.a parama) {
    if (this.c != null && parama != null)
      try {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put("clientId", parama.i);
        jSONObject.put("func", parama.k);
        jSONObject.put("param", parama.m);
        jSONObject.put("msgType", parama.l);
        String str = String.format("AlipayJSBridge._invokeJS(%s)", new Object[] { jSONObject.toString() });
        c c = new c();
        this(this, str);
        runOnUiThread(c);
      } catch (JSONException jSONException) {} 
  }
  
  private boolean a(String paramString) {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString))
      return bool1; 
    boolean bool2 = bool1;
    if (!paramString.startsWith("http://")) {
      bool2 = bool1;
      if (!paramString.startsWith("https://")) {
        if (!"SDKLite://h5quit".equalsIgnoreCase(paramString)) {
          String str = paramString;
          if (TextUtils.equals(paramString, this.d))
            str = paramString + "?resultCode=150"; 
          h.a(this, str);
        } 
        finish();
        bool2 = true;
      } 
    } 
    return bool2;
  }
  
  private void b() {
    if (this.e != null)
      this.e.b(); 
    this.e = null;
  }
  
  private void b(String paramString) {
    d d = new d(getApplicationContext(), new b(this));
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      String str = jSONObject.getString("clientId");
      try {
        if (!TextUtils.isEmpty(str)) {
          JSONObject jSONObject1 = jSONObject.getJSONObject("param");
          if (jSONObject1 instanceof JSONObject) {
            jSONObject1 = jSONObject1;
          } else {
            jSONObject1 = null;
          } 
          String str1 = jSONObject.getString("func");
          String str2 = jSONObject.getString("bundleName");
          com.alipay.sdk.authjs.a a1 = new com.alipay.sdk.authjs.a();
          this("call");
          a1.j = str2;
          a1.k = str1;
          a1.m = jSONObject1;
          a1.i = str;
          d.a(a1);
        } 
        return;
      } catch (Exception exception1) {
        String str1 = str;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    if (!TextUtils.isEmpty((CharSequence)exception))
      try {
        d.a((String)exception, com.alipay.sdk.authjs.a.a.d);
      } catch (JSONException jSONException) {} 
  }
  
  public void onBackPressed() {
    if (this.c.canGoBack()) {
      if (this.h) {
        h.a(this, this.d + "?resultCode=150");
        finish();
      } 
      return;
    } 
    h.a(this, this.d + "?resultCode=150");
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    try {
      paramBundle = getIntent().getExtras();
      if (paramBundle == null) {
        finish();
        return;
      } 
    } catch (Exception null) {
      finish();
      return;
    } 
    try {
      this.d = exception.getString("redirectUri");
      String str = exception.getString("params");
      if (!l.b(str)) {
        finish();
        return;
      } 
    } catch (Exception exception) {
      finish();
      return;
    } 
    requestWindowFeature(1);
    this.f = new Handler(getMainLooper());
    LinearLayout linearLayout = new LinearLayout((Context)this);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    linearLayout.setOrientation(1);
    setContentView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    this.c = new WebView((Context)this);
    layoutParams.weight = 1.0F;
    this.c.setVisibility(0);
    linearLayout.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams);
    WebSettings webSettings = this.c.getSettings();
    webSettings.setUserAgentString(webSettings.getUserAgentString() + l.e(getApplicationContext()));
    webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    webSettings.setSupportMultipleWindows(true);
    webSettings.setJavaScriptEnabled(true);
    webSettings.setSavePassword(false);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setMinimumFontSize(webSettings.getMinimumFontSize() + 8);
    webSettings.setAllowFileAccess(false);
    webSettings.setTextSize(WebSettings.TextSize.NORMAL);
    this.c.setVerticalScrollbarOverlay(true);
    this.c.setWebViewClient(new b((byte)0));
    this.c.setWebChromeClient(new a((byte)0));
    this.c.setDownloadListener(new a(this));
    this.c.loadUrl((String)exception);
    if (Build.VERSION.SDK_INT >= 7)
      try {
        Method method = this.c.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { boolean.class });
        if (method != null)
          method.invoke(this.c.getSettings(), new Object[] { Boolean.valueOf(true) }); 
      } catch (Exception exception1) {} 
    try {
      this.c.removeJavascriptInterface("searchBoxJavaBridge_");
      this.c.removeJavascriptInterface("accessibility");
      this.c.removeJavascriptInterface("accessibilityTraversal");
    } catch (Throwable throwable) {}
    if (Build.VERSION.SDK_INT >= 19)
      this.c.getSettings().setCacheMode(1); 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.c != null) {
      this.c.removeAllViews();
      try {
        this.c.destroy();
      } catch (Throwable throwable) {}
      this.c = null;
    } 
  }
  
  private final class a extends WebChromeClient {
    private a(AuthActivity this$0) {}
    
    public final boolean onConsoleMessage(ConsoleMessage param1ConsoleMessage) {
      String str1 = param1ConsoleMessage.message();
      if (TextUtils.isEmpty(str1))
        return super.onConsoleMessage(param1ConsoleMessage); 
      String str2 = null;
      if (str1.startsWith("h5container.message: "))
        str2 = str1.replaceFirst("h5container.message: ", ""); 
      if (TextUtils.isEmpty(str2))
        return super.onConsoleMessage(param1ConsoleMessage); 
      AuthActivity.b(this.a, str2);
      return super.onConsoleMessage(param1ConsoleMessage);
    }
  }
  
  private final class b extends WebViewClient {
    private b(AuthActivity this$0) {}
    
    public final void onPageFinished(WebView param1WebView, String param1String) {
      AuthActivity.g(this.a);
      AuthActivity.f(this.a).removeCallbacks(AuthActivity.e(this.a));
    }
    
    public final void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
      AuthActivity.d(this.a);
      AuthActivity.f(this.a).postDelayed(AuthActivity.e(this.a), 30000L);
      super.onPageStarted(param1WebView, param1String, param1Bitmap);
    }
    
    public final void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
      AuthActivity.a(this.a);
      super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
    }
    
    public final void onReceivedSslError(WebView param1WebView, SslErrorHandler param1SslErrorHandler, SslError param1SslError) {
      if (AuthActivity.b(this.a)) {
        param1SslErrorHandler.proceed();
        AuthActivity.a(this.a, false);
        return;
      } 
      this.a.runOnUiThread(new e(this, param1SslErrorHandler));
    }
    
    public final boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
      Intent intent;
      boolean bool = true;
      if (param1String.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || param1String.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
        boolean bool1;
        try {
          l.a a = l.a((Context)this.a);
          bool1 = bool;
          if (a != null) {
            if (a.a())
              return bool; 
          } else {
            return bool1;
          } 
          String str = param1String;
          if (param1String.startsWith("intent://platformapi/startapp"))
            str = param1String.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?"); 
          intent = new Intent();
          this("android.intent.action.VIEW", Uri.parse(str));
          this.a.startActivity(intent);
          bool1 = bool;
        } catch (Throwable throwable) {
          bool1 = bool;
        } 
        return bool1;
      } 
      if (AuthActivity.a(this.a, (String)intent)) {
        throwable.stopLoading();
        return bool;
      } 
      return super.shouldOverrideUrlLoading((WebView)throwable, (String)intent);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */