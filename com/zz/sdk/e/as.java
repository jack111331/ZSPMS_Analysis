package com.zz.sdk.e;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zz.sdk.i.bp;

class as extends WebViewClient {
  as(al paramal) {}
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError) {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    al.g(this.a).setVisibility(0);
    al.a(this.a).setVisibility(4);
    al.g(this.a).setText("页面君迷路了，等会儿再来吧");
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    bp.a("url=" + paramString);
    al.b(this.a, paramString);
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */