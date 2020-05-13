package com.jdpaysdk.author.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class b extends WebViewClient {
  b(BrowserActivity paramBrowserActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\browser\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */