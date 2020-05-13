package com.zz.sdk.e;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class hc extends WebViewClient {
  hc(hb paramhb) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */