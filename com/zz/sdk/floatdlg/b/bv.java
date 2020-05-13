package com.zz.sdk.floatdlg.b;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class bv extends WebViewClient {
  bv(bu parambu) {}
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError) {
    paramSslErrorHandler.proceed();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    Uri uri = Uri.parse(paramString);
    if ("http".equals(uri.getScheme()) || "https".equals(uri.getScheme()))
      paramWebView.loadUrl(paramString); 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */