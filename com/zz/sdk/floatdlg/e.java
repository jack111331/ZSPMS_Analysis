package com.zz.sdk.floatdlg;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class e extends WebChromeClient {
  e(WiKiActivity paramWiKiActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    if (paramInt == 100) {
      WiKiActivity.a(this.a).setVisibility(8);
    } else {
      WiKiActivity.a(this.a).setProgress(paramInt);
    } 
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\floatdlg\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */