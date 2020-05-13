package com.zz.sdk;

import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public abstract class IWebChromeClient extends WebChromeClient {
  public abstract boolean onShowFileChooser(WebView paramWebView, ValueCallback paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams);
  
  public void openFileChooser(ValueCallback paramValueCallback) {
    openFileChooser(paramValueCallback, "");
  }
  
  public abstract void openFileChooser(ValueCallback paramValueCallback, String paramString);
  
  public void openFileChooser(ValueCallback paramValueCallback, String paramString1, String paramString2) {
    openFileChooser(paramValueCallback, paramString1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\IWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */