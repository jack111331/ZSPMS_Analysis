package com.zz.sdk.floatdlg.b;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class ac extends WebViewClient {
  ac(ab paramab) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    ab.a(this.a, paramString);
    if (ab.c(this.a).canGoBack()) {
      ab.d(this.a).setVisibility(0);
      return;
    } 
    ab.d(this.a).setVisibility(8);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    paramSslErrorHandler.proceed();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    boolean bool = false;
    ab.a(this.a).setVisibility(0);
    ab.a(this.a).setProgress(0);
    Uri uri = Uri.parse(paramString);
    if (ab.b(this.a) != null && ab.b(this.a).equals(paramString)) {
      if (!"http".equals(uri.getScheme())) {
        boolean bool1 = bool;
        if ("https".equals(uri.getScheme())) {
          paramWebView.loadUrl(paramString);
          return bool;
        } 
        return bool1;
      } 
    } else {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    } 
    paramWebView.loadUrl(paramString);
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */