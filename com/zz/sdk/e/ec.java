package com.zz.sdk.e;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.ag;

class ec implements g {
  ec(du paramdu) {}
  
  public void a(AsyncTask paramAsyncTask, Object paramObject, a parama) {
    if (this.a.a(paramAsyncTask)) {
      if (parama instanceof ag && parama.c())
        du.a(this.a, ((ag)parama).r); 
      this.a.d(true);
      WebView webView = this.a.v();
      if (webView != null) {
        webView.loadUrl(du.d(this.a));
        this.a.a(-1L, "");
        return;
      } 
    } else {
      return;
    } 
    du.e(this.a);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */