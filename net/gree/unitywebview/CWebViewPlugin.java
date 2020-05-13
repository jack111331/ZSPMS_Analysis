package net.gree.unitywebview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.unity3d.player.UnityPlayer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CWebViewPlugin {
  private static FrameLayout layout;
  
  private boolean canGoBack;
  
  private boolean canGoForward;
  
  private Hashtable<String, String> mCustomHeaders;
  
  private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
  
  private WebView mWebView;
  
  private CWebViewPluginInterface mWebViewPlugin;
  
  private String mWebViewUA;
  
  private int progress;
  
  public static boolean IsWebViewAvailable() {
    final Activity a = UnityPlayer.currentActivity;
    FutureTask<Boolean> futureTask = new FutureTask(new Callable<Boolean>() {
          public Boolean call() throws Exception {
            boolean bool;
            try {
              bool = true;
            } catch (Exception exception) {
              bool = false;
            } 
            return Boolean.valueOf(bool);
          }
        });
    activity.runOnUiThread(futureTask);
    try {
      return ((Boolean)futureTask.get()).booleanValue();
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void AddCustomHeader(String paramString1, String paramString2) {
    if (this.mCustomHeaders == null)
      return; 
    this.mCustomHeaders.put(paramString1, paramString2);
  }
  
  public void ClearCookies() {
    if (Build.VERSION.SDK_INT >= 21) {
      CookieManager.getInstance().removeAllCookies(null);
      CookieManager.getInstance().flush();
    } else {
      CookieSyncManager cookieSyncManager = CookieSyncManager.createInstance((Context)UnityPlayer.currentActivity);
      cookieSyncManager.startSync();
      CookieManager cookieManager = CookieManager.getInstance();
      cookieManager.removeAllCookie();
      cookieManager.removeSessionCookie();
      cookieSyncManager.stopSync();
      cookieSyncManager.sync();
    } 
  }
  
  public void ClearCustomHeader() {
    if (this.mCustomHeaders == null)
      return; 
    this.mCustomHeaders.clear();
  }
  
  public void Destroy() {
    final Activity a = UnityPlayer.currentActivity;
    activity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            if (CWebViewPlugin.this.mGlobalLayoutListener != null) {
              a.getWindow().getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(CWebViewPlugin.this.mGlobalLayoutListener);
              CWebViewPlugin.access$802(CWebViewPlugin.this, null);
            } 
            CWebViewPlugin.this.mWebView.stopLoading();
            CWebViewPlugin.layout.removeView((View)CWebViewPlugin.this.mWebView);
            CWebViewPlugin.this.mWebView.destroy();
            CWebViewPlugin.access$002(CWebViewPlugin.this, null);
          }
        });
  }
  
  public void EvaluateJS(final String js) {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            if (Build.VERSION.SDK_INT >= 19) {
              CWebViewPlugin.this.mWebView.evaluateJavascript(js, null);
            } else {
              WebView webView = CWebViewPlugin.this.mWebView;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("javascript:");
              stringBuilder.append(URLEncoder.encode(js));
              webView.loadUrl(stringBuilder.toString());
            } 
          }
        });
  }
  
  public String GetCookies(String paramString) {
    return CookieManager.getInstance().getCookie(paramString);
  }
  
  public String GetCustomHeaderValue(String paramString) {
    return (this.mCustomHeaders == null) ? null : (!this.mCustomHeaders.containsKey(paramString) ? null : this.mCustomHeaders.get(paramString));
  }
  
  public void GoBack() {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            CWebViewPlugin.this.mWebView.goBack();
          }
        });
  }
  
  public void GoForward() {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            CWebViewPlugin.this.mWebView.goForward();
          }
        });
  }
  
  public void Init(final String gameObject, final boolean transparent, final String ua) {
    final Activity a = UnityPlayer.currentActivity;
    activity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView != null)
              return; 
            CWebViewPlugin.access$102(CWebViewPlugin.this, new Hashtable<Object, Object>());
            final WebView webView = new WebView((Context)a);
            if (Build.VERSION.SDK_INT >= 19)
              try {
                if (((a.getPackageManager().getApplicationInfo(a.getPackageName(), 0)).flags & 0x2) != 0)
                  WebView.setWebContentsDebuggingEnabled(true); 
              } catch (Exception exception) {} 
            webView.setVisibility(8);
            webView.setFocusable(true);
            webView.setFocusableInTouchMode(true);
            webView.setWebChromeClient(new WebChromeClient() {
                  View videoView;
                  
                  public void onHideCustomView() {
                    super.onHideCustomView();
                    if (CWebViewPlugin.layout != null) {
                      CWebViewPlugin.layout.removeView(this.videoView);
                      CWebViewPlugin.layout.setBackgroundColor(0);
                      this.videoView = null;
                    } 
                  }
                  
                  public void onPermissionRequest(PermissionRequest param2PermissionRequest) {
                    for (String str : param2PermissionRequest.getResources()) {
                      if (str.equals("android.webkit.resource.VIDEO_CAPTURE") || str.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                        param2PermissionRequest.grant(null);
                        break;
                      } 
                    } 
                  }
                  
                  public void onProgressChanged(WebView param2WebView, int param2Int) {
                    CWebViewPlugin.access$202(CWebViewPlugin.this, param2Int);
                  }
                  
                  public void onShowCustomView(View param2View, WebChromeClient.CustomViewCallback param2CustomViewCallback) {
                    super.onShowCustomView(param2View, param2CustomViewCallback);
                    if (CWebViewPlugin.layout != null) {
                      this.videoView = param2View;
                      CWebViewPlugin.layout.setBackgroundColor(-16777216);
                      CWebViewPlugin.layout.addView(this.videoView);
                    } 
                  }
                });
            CWebViewPlugin.access$402(CWebViewPlugin.this, new CWebViewPluginInterface(self, gameObject));
            webView.setWebViewClient(new WebViewClient() {
                  public void onLoadResource(WebView param2WebView, String param2String) {
                    CWebViewPlugin.access$502(CWebViewPlugin.this, webView.canGoBack());
                    CWebViewPlugin.access$602(CWebViewPlugin.this, webView.canGoForward());
                  }
                  
                  public void onPageFinished(WebView param2WebView, String param2String) {
                    CWebViewPlugin.access$502(CWebViewPlugin.this, webView.canGoBack());
                    CWebViewPlugin.access$602(CWebViewPlugin.this, webView.canGoForward());
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnLoaded", param2String);
                  }
                  
                  public void onPageStarted(WebView param2WebView, String param2String, Bitmap param2Bitmap) {
                    CWebViewPlugin.access$502(CWebViewPlugin.this, webView.canGoBack());
                    CWebViewPlugin.access$602(CWebViewPlugin.this, webView.canGoForward());
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnStarted", param2String);
                  }
                  
                  public void onReceivedError(WebView param2WebView, int param2Int, String param2String1, String param2String2) {
                    webView.loadUrl("about:blank");
                    CWebViewPlugin.access$502(CWebViewPlugin.this, webView.canGoBack());
                    CWebViewPlugin.access$602(CWebViewPlugin.this, webView.canGoForward());
                    CWebViewPluginInterface cWebViewPluginInterface = CWebViewPlugin.this.mWebViewPlugin;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(param2Int);
                    stringBuilder.append("\t");
                    stringBuilder.append(param2String1);
                    stringBuilder.append("\t");
                    stringBuilder.append(param2String2);
                    cWebViewPluginInterface.call("CallOnError", stringBuilder.toString());
                  }
                  
                  public void onReceivedHttpError(WebView param2WebView, WebResourceRequest param2WebResourceRequest, WebResourceResponse param2WebResourceResponse) {
                    CWebViewPlugin.access$502(CWebViewPlugin.this, webView.canGoBack());
                    CWebViewPlugin.access$602(CWebViewPlugin.this, webView.canGoForward());
                    CWebViewPlugin.this.mWebViewPlugin.call("CallOnHttpError", Integer.toString(param2WebResourceResponse.getStatusCode()));
                  }
                  
                  public WebResourceResponse shouldInterceptRequest(WebView param2WebView, String param2String) {
                    if (CWebViewPlugin.this.mCustomHeaders == null || CWebViewPlugin.this.mCustomHeaders.isEmpty())
                      return super.shouldInterceptRequest(param2WebView, param2String); 
                    try {
                      URL uRL = new URL();
                      this(param2String);
                      HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
                      httpURLConnection.setRequestProperty("User-Agent", CWebViewPlugin.this.mWebViewUA);
                      for (Map.Entry entry : CWebViewPlugin.this.mCustomHeaders.entrySet())
                        httpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
                      httpURLConnection.connect();
                      return new WebResourceResponse(httpURLConnection.getContentType().split(";", 2)[0], httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                    } catch (Exception exception) {
                      return super.shouldInterceptRequest(param2WebView, param2String);
                    } 
                  }
                  
                  public boolean shouldOverrideUrlLoading(WebView param2WebView, String param2String) {
                    String str;
                    CWebViewPlugin.access$502(CWebViewPlugin.this, webView.canGoBack());
                    CWebViewPlugin.access$602(CWebViewPlugin.this, webView.canGoForward());
                    if (param2String.startsWith("http://") || param2String.startsWith("https://") || param2String.startsWith("file://") || param2String.startsWith("javascript:"))
                      return false; 
                    if (param2String.startsWith("unity:")) {
                      str = param2String.substring(6);
                      CWebViewPlugin.this.mWebViewPlugin.call("CallFromJS", str);
                      return true;
                    } 
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(param2String));
                    if (a.getPackageManager().queryIntentActivities(intent, 0).size() > 0)
                      str.getContext().startActivity(intent); 
                    return true;
                  }
                });
            webView.addJavascriptInterface(CWebViewPlugin.this.mWebViewPlugin, "Unity");
            WebSettings webSettings = webView.getSettings();
            if (ua != null && ua.length() > 0)
              webSettings.setUserAgentString(ua); 
            CWebViewPlugin.access$702(CWebViewPlugin.this, webSettings.getUserAgentString());
            webSettings.setSupportZoom(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setUseWideViewPort(true);
            webSettings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 16)
              webSettings.setAllowUniversalAccessFromFileURLs(true); 
            if (Build.VERSION.SDK_INT >= 17)
              webSettings.setMediaPlaybackRequiresUserGesture(false); 
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDatabasePath(webView.getContext().getDir("databases", 0).getPath());
            if (transparent)
              webView.setBackgroundColor(0); 
            if (CWebViewPlugin.layout == null || CWebViewPlugin.layout.getParent() != a.findViewById(16908290)) {
              CWebViewPlugin.access$302(new FrameLayout((Context)a));
              a.addContentView((View)CWebViewPlugin.layout, new ViewGroup.LayoutParams(-1, -1));
              CWebViewPlugin.layout.setFocusable(true);
              CWebViewPlugin.layout.setFocusableInTouchMode(true);
            } 
            CWebViewPlugin.layout.addView((View)webView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1, 0));
            CWebViewPlugin.access$002(CWebViewPlugin.this, webView);
          }
        });
    final View activityRootView = activity.getWindow().getDecorView().getRootView();
    this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
          int i;
          Rect rect = new Rect();
          activityRootView.getWindowVisibleDisplayFrame(rect);
          Display display = a.getWindowManager().getDefaultDisplay();
          try {
            Point point = new Point();
            this();
            display.getSize(point);
            i = point.y;
          } catch (NoSuchMethodError noSuchMethodError) {
            i = display.getHeight();
          } 
          if (activityRootView.getRootView().getHeight() - rect.bottom - rect.top > i / 3) {
            UnityPlayer.UnitySendMessage(gameObject, "SetKeyboardVisible", "true");
          } else {
            UnityPlayer.UnitySendMessage(gameObject, "SetKeyboardVisible", "false");
          } 
        }
      };
    view.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
  }
  
  public boolean IsInitialized() {
    boolean bool;
    if (this.mWebView != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void LoadHTML(final String html, final String baseURL) {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            CWebViewPlugin.this.mWebView.loadDataWithBaseURL(baseURL, html, "text/html", "UTF8", null);
          }
        });
  }
  
  public void LoadURL(final String url) {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            if (CWebViewPlugin.this.mCustomHeaders != null && !CWebViewPlugin.this.mCustomHeaders.isEmpty()) {
              CWebViewPlugin.this.mWebView.loadUrl(url, CWebViewPlugin.this.mCustomHeaders);
            } else {
              CWebViewPlugin.this.mWebView.loadUrl(url);
            } 
          }
        });
  }
  
  public void OnApplicationPause(final boolean paused) {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            if (paused) {
              CWebViewPlugin.this.mWebView.onPause();
              CWebViewPlugin.this.mWebView.pauseTimers();
            } else {
              CWebViewPlugin.this.mWebView.onResume();
              CWebViewPlugin.this.mWebView.resumeTimers();
            } 
          }
        });
  }
  
  public void RemoveCustomHeader(String paramString) {
    if (this.mCustomHeaders == null)
      return; 
    if (this.mCustomHeaders.containsKey(paramString))
      this.mCustomHeaders.remove(paramString); 
  }
  
  public void SetMargins(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1, 0);
    layoutParams.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            CWebViewPlugin.this.mWebView.setLayoutParams((ViewGroup.LayoutParams)params);
          }
        });
  }
  
  public void SetVisibility(final boolean visibility) {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPlugin.this.mWebView == null)
              return; 
            if (visibility) {
              CWebViewPlugin.this.mWebView.setVisibility(0);
              CWebViewPlugin.layout.requestFocus();
              CWebViewPlugin.this.mWebView.requestFocus();
            } else {
              CWebViewPlugin.this.mWebView.setVisibility(8);
            } 
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\net\gre\\unitywebview\CWebViewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */