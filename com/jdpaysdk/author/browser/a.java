package com.jdpaysdk.author.browser;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.jdpaysdk.author.c.f;

class a extends WebChromeClient {
  a(BrowserActivity paramBrowserActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    BrowserActivity.a(this.a).setProgress(paramInt);
    if (paramInt == 100) {
      BrowserActivity.a(this.a).setVisibility(8);
    } else {
      BrowserActivity.a(this.a).setVisibility(0);
    } 
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {
    if (TextUtils.isEmpty((BrowserActivity.b(this.a)).b)) {
      BrowserActivity.c(this.a).setText(this.a.getResources().getString(f.b("brower_title")));
      return;
    } 
    BrowserActivity.c(this.a).setText((BrowserActivity.b(this.a)).b);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\browser\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */