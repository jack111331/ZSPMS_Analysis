package com.unionpay;

import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

final class aa extends WebChromeClient {
  private aa(WebViewJavascriptBridge paramWebViewJavascriptBridge) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage) {
    return true;
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
    paramJsResult.cancel();
    Toast.makeText((Context)this.a.mContext, paramString2, 0).show();
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */