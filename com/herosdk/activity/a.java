package com.herosdk.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.herosdk.d.r;

class a extends WebChromeClient {
  a(HuspActivity paramHuspActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    super.onProgressChanged(paramWebView, paramInt);
    if (paramInt >= 100)
      r.a().b(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\activity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */