package com.alipay.sdk.auth;

import android.webkit.WebView;

final class c implements Runnable {
  c(AuthActivity paramAuthActivity, String paramString) {}
  
  public final void run() {
    try {
      WebView webView = AuthActivity.h(this.b);
      StringBuilder stringBuilder = new StringBuilder();
      this("javascript:");
      webView.loadUrl(stringBuilder.append(this.a).toString());
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\auth\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */