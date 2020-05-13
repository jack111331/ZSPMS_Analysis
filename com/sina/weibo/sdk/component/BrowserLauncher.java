package com.sina.weibo.sdk.component;

enum BrowserLauncher {
  AUTH, COMMON, SHARE, WIDGET;
  
  static {
    COMMON = new BrowserLauncher("COMMON", 3);
    ENUM$VALUES = new BrowserLauncher[] { AUTH, SHARE, WIDGET, COMMON };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\component\BrowserLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */