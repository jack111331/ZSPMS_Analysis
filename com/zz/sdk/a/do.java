package com.zz.sdk.a;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zz.sdk.b.a.ab;
import com.zz.sdk.i.h;

class do extends WebViewClient {
  do(dn paramdn) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {
    super.onPageFinished(paramWebView, paramString);
    Log.i("zz_sdk", "onPageFinished url:" + paramString);
    ab ab = h.b();
    dn.a(this.a, ab);
    if (ab == null || !ab.c())
      this.a.k.post(new dp(this)); 
    dn.b(this.a);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\a\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */