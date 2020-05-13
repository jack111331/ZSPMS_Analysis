package com.zz.sdk.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

class gl extends WebViewClient {
  gl(gg paramgg, Context paramContext, FrameLayout paramFrameLayout, WebView paramWebView) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    if (paramString.startsWith("weixin://wap/pay?")) {
      try {
        Intent intent = new Intent();
        this();
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(paramString));
        this.a.startActivity(intent);
        this.d.g();
      } catch (Exception null) {
        exception.printStackTrace();
        this.d.g();
        gg.a(this.d, -1);
      } 
      try {
        this.b.removeView((View)this.c);
        this.c.removeAllViews();
        this.c.destroy();
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return true;
    } 
    return super.shouldOverrideUrlLoading((WebView)exception, paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */