package com.sdk.base.framework.utils.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import com.sdk.base.framework.utils.g.b;
import java.net.HttpURLConnection;

public class a {
  private static final String a = a.class.getName();
  
  private static final Boolean b = Boolean.valueOf(c.h);
  
  private static int c = b.a.c.a();
  
  @SuppressLint({"DefaultLocale", "NewApi"})
  public static String a(Context paramContext) {
    String str2 = null;
    String str3 = str2;
    if (paramContext != null)
      try {
        str3 = b(paramContext);
      } catch (Throwable throwable) {
        b.c(a, throwable.getMessage(), b);
        str3 = str2;
      }  
    String str1 = str3;
    if (TextUtils.isEmpty(str3))
      str1 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1"; 
    return str1;
  }
  
  public static boolean a(HttpURLConnection paramHttpURLConnection) {
    boolean bool = false;
    if (paramHttpURLConnection != null) {
      String str = paramHttpURLConnection.getHeaderField("Accept-Ranges");
      if (com.sdk.base.framework.utils.k.a.b(str).booleanValue())
        return "bytes".equals(str); 
      if (com.sdk.base.framework.utils.k.a.b(paramHttpURLConnection.getHeaderField("Content-Range")).booleanValue())
        bool = str.startsWith("bytes"); 
    } 
    return bool;
  }
  
  private static String b(Context paramContext) {
    StringBuffer stringBuffer;
    if (Build.VERSION.SDK_INT >= 17) {
      try {
        String str = WebSettings.getDefaultUserAgent(paramContext);
        stringBuffer = new StringBuffer();
        int i = str.length();
        boolean bool = false;
      } catch (Exception exception) {
        String str = System.getProperty("http.agent");
        stringBuffer = new StringBuffer();
        int i = str.length();
        boolean bool = false;
      } 
    } else {
      String str = System.getProperty("http.agent");
      stringBuffer = new StringBuffer();
      int i = str.length();
      boolean bool = false;
    } 
    return stringBuffer.toString();
  }
  
  public static String b(HttpURLConnection paramHttpURLConnection) {
    String str1 = null;
    String str2 = str1;
    if (paramHttpURLConnection != null)
      try {
        String str = paramHttpURLConnection.getHeaderField("Content-Disposition");
        str2 = str1;
        if (com.sdk.base.framework.utils.k.a.b(str).booleanValue()) {
          String str3 = new String();
          this(str.getBytes("ISO-8859-1"), "GBK");
          str2 = str1;
          if (com.sdk.base.framework.utils.k.a.b(str3).booleanValue())
            str2 = str3.substring(str3.indexOf('"') + 1, str3.lastIndexOf("\"")); 
        } 
      } catch (Throwable throwable) {
        b.c(a, throwable.getMessage(), b);
        str2 = str1;
      }  
    return str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */