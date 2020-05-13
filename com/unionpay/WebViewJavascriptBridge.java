package com.unionpay;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.unionpay.utils.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

public class WebViewJavascriptBridge implements Serializable {
  ac _messageHandler;
  
  Map _messageHandlers;
  
  Map _responseCallbacks;
  
  long _uniqueId;
  
  Activity mContext;
  
  WebView mWebView;
  
  public WebViewJavascriptBridge(Activity paramActivity, WebView paramWebView, ac paramac) {
    this.mContext = paramActivity;
    this.mWebView = paramWebView;
    this._messageHandler = paramac;
    this._messageHandlers = new HashMap<Object, Object>();
    this._responseCallbacks = new HashMap<Object, Object>();
    this._uniqueId = 0L;
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.addJavascriptInterface(this, "_WebViewJavascriptBridge");
    this.mWebView.setWebViewClient(new ab(this, (byte)0));
    this.mWebView.setWebChromeClient(new aa(this, (byte)0));
  }
  
  private void _callbackJs(String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("responseId", paramString1);
    hashMap.put("responseData", paramString2);
    _dispatchMessage(hashMap);
  }
  
  private void _dispatchMessage(Map paramMap) {
    String str = (new JSONObject(paramMap)).toString();
    h.a("test", "sending:" + str);
    str = String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", new Object[] { doubleEscapeString(str) });
    this.mContext.runOnUiThread(new y(this, str));
  }
  
  private void _sendData(String paramString1, ad paramad, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("data", paramString1);
    if (paramad != null) {
      StringBuilder stringBuilder = new StringBuilder("java_cb_");
      long l = this._uniqueId + 1L;
      this._uniqueId = l;
      String str = stringBuilder.append(l).toString();
      this._responseCallbacks.put(str, paramad);
      hashMap.put("callbackId", str);
    } 
    if (paramString2 != null)
      hashMap.put("handlerName", paramString2); 
    _dispatchMessage(hashMap);
  }
  
  public static String convertStreamToString(InputStream paramInputStream) {
    String str;
    try {
      Scanner scanner = new Scanner();
      this(paramInputStream, "UTF-8");
      scanner = scanner.useDelimiter("\\A");
      if (scanner.hasNext()) {
        str = scanner.next();
      } else {
        str = "";
      } 
      try {
        paramInputStream.close();
        return str;
      } catch (IOException null) {}
    } catch (IOException iOException) {
      str = "";
    } 
    iOException.printStackTrace();
    return str;
  }
  
  private String doubleEscapeString(String paramString) {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f");
  }
  
  private void loadWebViewJavascriptBridgeJs(WebView paramWebView) {
    String str = convertStreamToString(getClass().getResourceAsStream("res/webviewjavascriptbridge.js"));
    paramWebView.loadUrl("javascript:" + str);
  }
  
  @JavascriptInterface
  public void _handleMessageFromJs(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    ac ac1;
    if (paramString2 != null) {
      ((ad)this._responseCallbacks.get(paramString2)).a(paramString3);
      this._responseCallbacks.remove(paramString2);
      return;
    } 
    if (paramString4 != null) {
      z z = new z(this, paramString4);
    } else {
      paramString2 = null;
    } 
    if (paramString5 != null) {
      ac ac2 = (ac)this._messageHandlers.get(paramString5);
      ac1 = ac2;
      if (ac2 == null) {
        h.b("test", "WVJB Warning: No handler for " + paramString5);
        return;
      } 
    } else {
      ac1 = this._messageHandler;
    } 
    try {
      Activity activity = this.mContext;
      x x = new x();
      this(this, ac1, paramString1, (ad)paramString2);
      activity.runOnUiThread(x);
    } catch (Exception exception) {
      h.b("test", "WebViewJavascriptBridge: WARNING: java handler threw. " + exception.getMessage());
    } 
  }
  
  public void callHandler(String paramString) {
    callHandler(paramString, null, null);
  }
  
  public void callHandler(String paramString1, String paramString2) {
    callHandler(paramString1, paramString2, null);
  }
  
  public void callHandler(String paramString1, String paramString2, ad paramad) {
    _sendData(paramString2, paramad, paramString1);
  }
  
  public void registerHandler(String paramString, ac paramac) {
    this._messageHandlers.put(paramString, paramac);
  }
  
  public void send(String paramString) {
    send(paramString, null);
  }
  
  public void send(String paramString, ad paramad) {
    _sendData(paramString, paramad, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\WebViewJavascriptBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */