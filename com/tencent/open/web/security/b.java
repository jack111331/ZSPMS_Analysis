package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.a;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b extends a {
  public void a(String paramString1, String paramString2, List<String> paramList, a.a parama) {
    f.a("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + paramString1 + " | methodName: " + paramString2);
    int i = paramList.size();
    for (byte b2 = 0; b2 < i; b2++) {
      try {
        paramList.set(b2, URLDecoder.decode(paramList.get(b2), "UTF-8"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } 
    } 
    a.b b1 = (a.b)this.a.get(paramString1);
    if (b1 != null) {
      f.b("openSDK_LOG.SecureJsBridge", "-->handler != null");
      b1.call(paramString2, paramList, parama);
      return;
    } 
    f.b("openSDK_LOG.SecureJsBridge", "-->handler == null");
    if (parama != null)
      parama.a(); 
  }
  
  public boolean a(WebView paramWebView, String paramString) {
    boolean bool;
    f.a("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + paramString);
    if (paramString == null)
      return false; 
    if (!Uri.parse(paramString).getScheme().equals("jsbridge"))
      return false; 
    ArrayList<String> arrayList = new ArrayList(Arrays.asList((Object[])(paramString + "/#").split("/")));
    if (arrayList.size() < 7)
      return false; 
    String str1 = arrayList.get(2);
    String str2 = arrayList.get(3);
    String str3 = arrayList.get(4);
    String str4 = arrayList.get(5);
    f.a("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + str1 + " | methodName: " + str2 + " | snStr: " + str3);
    if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))
      return false; 
    try {
      long l = Long.parseLong(str3);
      c c = new c(paramWebView, l, paramString, str4);
      a(str1, str2, arrayList.subList(6, arrayList.size() - 1), c);
      bool = true;
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\web\security\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */