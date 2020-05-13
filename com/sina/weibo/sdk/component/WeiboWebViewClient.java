package com.sina.weibo.sdk.component;

import android.webkit.WebViewClient;

abstract class WeiboWebViewClient extends WebViewClient {
  protected BrowserRequestCallBack mCallBack;
  
  public void setBrowserRequestCallBack(BrowserRequestCallBack paramBrowserRequestCallBack) {
    this.mCallBack = paramBrowserRequestCallBack;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */