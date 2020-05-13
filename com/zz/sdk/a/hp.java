package com.zz.sdk.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class hp extends w {
  protected WebView a;
  
  protected ProgressBar n;
  
  private boolean o = true;
  
  private WebChromeClient p = new hq(this);
  
  private WebViewClient q = new hr(this);
  
  private DownloadListener r = new hs(this);
  
  private hp(Activity paramActivity) {
    super(paramActivity);
  }
  
  public static hp a(Activity paramActivity, String paramString) {
    hp hp1 = new hp(paramActivity);
    hp1.a(bv.a().a("key_url", paramString).a("key_show_back", Boolean.valueOf(false)).a("key_show_close", Boolean.valueOf(true)));
    hp1.m();
    hp1.show();
    return hp1;
  }
  
  public void a() {
    this.a = (WebView)findViewById(2131296506);
    this.n = (ProgressBar)findViewById(2131296507);
    this.a.setWebChromeClient(this.p);
    this.a.setWebViewClient(this.q);
    this.a.setBackgroundColor(0);
    Drawable drawable = this.a.getBackground();
    if (drawable != null)
      drawable.setAlpha(0); 
    a(this.a);
    if (this.a != null) {
      String str = (String)a("key_url");
      this.a.loadUrl(str);
    } 
  }
  
  protected void a(WebView paramWebView) {
    paramWebView.setDownloadListener(this.r);
    WebSettings webSettings = paramWebView.getSettings();
    webSettings.setCacheMode(2);
    webSettings.setUseWideViewPort(true);
    webSettings.setLoadWithOverviewMode(true);
    webSettings.setDefaultTextEncodingName("UTF-8");
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    webSettings.setBlockNetworkImage(true);
    try {
      webSettings.setJavaScriptEnabled(true);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  protected boolean a(WebView paramWebView, String paramString) {
    if (paramString != null && paramString.indexOf("http") == 0) {
      paramWebView.loadUrl(paramString);
      return true;
    } 
    return false;
  }
  
  protected void b(WebView paramWebView, String paramString) {}
  
  int c() {
    return 2130903103;
  }
  
  public void dismiss() {
    super.dismiss();
    try {
      ViewGroup viewGroup = (ViewGroup)this.a.getParent();
      if (viewGroup != null)
        viewGroup.removeAllViews(); 
      this.a.removeAllViews();
      this.a.destroy();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void onBackPressed() {
    dismiss();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */