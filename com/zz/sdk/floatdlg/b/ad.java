package com.zz.sdk.floatdlg.b;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class ad extends WebChromeClient {
  ad(ab paramab) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    if (paramInt == 100) {
      ab.a(this.a).setVisibility(8);
    } else {
      ab.a(this.a).setProgress(paramInt);
    } 
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\b\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */