package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class dv extends WebViewClient {
  dv(du paramdu) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    super.onPageFinished(paramWebView, paramString);
    this.a.g();
    du.a(this.a, this.a.getContext());
  }
  
  @SuppressLint({"NewApi"})
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    paramSslErrorHandler.proceed();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (du.a(this.a, paramString))
      paramWebView.loadUrl(paramString); 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */