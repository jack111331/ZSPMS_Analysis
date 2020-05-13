package com.sdk.mobile.manager.login;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CucWebView extends WebView {
  public CucWebView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public CucWebView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CucWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a() {
    try {
      a("removeJavascriptInterface", "searchBoxJavaBridge_");
    } catch (Exception exception) {}
    try {
      a("removeJavascriptInterface", "accessibility");
    } catch (Exception exception) {}
    try {
      a("removeJavascriptInterface", "accessibilityTraversal");
    } catch (Exception exception) {}
  }
  
  private void a(Context paramContext) {
    WebSettings webSettings = getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    webSettings.setAllowFileAccessFromFileURLs(true);
    a();
  }
  
  private void a(String paramString1, String paramString2) {
    try {
      Method method = WebView.class.getDeclaredMethod(paramString1, new Class[] { String.class });
      method.setAccessible(true);
      method.invoke(this, new Object[] { paramString2 });
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InvocationTargetException invocationTargetException) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\CucWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */