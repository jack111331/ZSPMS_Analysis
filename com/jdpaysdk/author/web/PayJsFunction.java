package com.jdpaysdk.author.web;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.io.Serializable;

public class PayJsFunction implements Serializable {
  private static String sJsCallback = null;
  
  private static final long serialVersionUID = 1L;
  
  private Activity mActivity = null;
  
  private WebView mWebView = null;
  
  public PayJsFunction(WebView paramWebView) {
    this.mWebView = paramWebView;
    this.mActivity = (Activity)this.mWebView.getContext();
  }
  
  @JavascriptInterface
  public void close(String paramString) {
    this.mActivity.runOnUiThread(new a(this, paramString));
  }
  
  @JavascriptInterface
  public void sendPayResult(String paramString1, String paramString2, String paramString3) {
    this.mActivity.runOnUiThread(new b(this, paramString1, paramString2, paramString3));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\web\PayJsFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */