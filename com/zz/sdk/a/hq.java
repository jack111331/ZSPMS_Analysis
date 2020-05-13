package com.zz.sdk.a;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class hq extends WebChromeClient {
  hq(hp paramhp) {}
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
    return super.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    super.onProgressChanged(paramWebView, paramInt);
    this.a.n.setProgress(paramInt);
    if (paramInt >= 100) {
      this.a.n.setVisibility(8);
      if (hp.a(this.a)) {
        paramWebView.getSettings().setBlockNetworkImage(false);
        hp.a(this.a, false);
      } 
    } 
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {
    super.onReceivedTitle(paramWebView, paramString);
    this.a.setTitle(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */