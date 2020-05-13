package com.zz.sdk.e;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.zz.sdk.IWebChromeClient;
import com.zz.sdk.i.bp;

class ar extends IWebChromeClient {
  ar(al paramal) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {
    bp.a("newProgress=" + paramInt);
    if (paramInt == 100) {
      if (al.b(this.a) && al.c(this.a).size() > 0) {
        al.c(this.a).remove(al.c(this.a).size() - 1);
        al.a(this.a, al.c(this.a).get(al.c(this.a).size() - 1));
        bp.a("FloatWindow，onProgressChangedTitle:" + al.d(this.a));
        al.e(this.a).setText(al.d(this.a));
        al.a(this.a, false);
      } 
      al.f(this.a).setVisibility(8);
    } else if (8 == al.f(this.a).getVisibility()) {
      al.f(this.a).setVisibility(0);
    } 
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {
    super.onReceivedTitle(paramWebView, paramString);
    bp.a("FloatWindow，onReceivedTitle:" + paramString);
    if (al.b(this.a)) {
      if (al.c(this.a).size() > 0)
        al.c(this.a).remove(al.c(this.a).size() - 1); 
    } else {
      al.c(this.a).add(paramString);
    } 
    if (!TextUtils.isEmpty(paramString)) {
      if (TextUtils.equals("找不到网页", paramString)) {
        al.c(this.a).remove(paramString);
        al.g(this.a).setVisibility(0);
        al.a(this.a).setVisibility(4);
        al.g(this.a).setText("页面君迷路了，等会儿再来吧");
      } else {
        al.a(this.a, paramString);
        al.a(this.a, false);
      } 
      al.e(this.a).setText(paramString);
    } 
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams) {
    if (al.h(this.a) != null)
      al.h(this.a).a(paramValueCallback, paramFileChooserParams); 
    return true;
  }
  
  public void openFileChooser(ValueCallback paramValueCallback, String paramString) {
    if (al.h(this.a) != null)
      al.h(this.a).a(paramValueCallback, paramString); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */