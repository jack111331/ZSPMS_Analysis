package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

public class b extends WebView {
  public b(Context paramContext) {
    super(paramContext);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    WebSettings webSettings = getSettings();
    if (webSettings != null) {
      Class<?> clazz = webSettings.getClass();
      try {
        Method method = clazz.getMethod("removeJavascriptInterface", new Class[] { String.class });
        if (method != null)
          method.invoke(this, new Object[] { "searchBoxJavaBridge_" }); 
      } catch (Exception exception) {}
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */