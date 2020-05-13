package com.zz.sdk.a;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class hr extends WebViewClient {
  hr(hp paramhp) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    this.a.b(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
    paramWebView.getSettings().setBlockNetworkImage(false);
    hp.a(this.a, true);
    this.a.n.setVisibility(0);
    this.a.n.setProgress(0);
    this.a.a(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
    this.a.a("Oh no! " + paramString1);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    paramSslErrorHandler.cancel();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    return this.a.a(paramWebView, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */