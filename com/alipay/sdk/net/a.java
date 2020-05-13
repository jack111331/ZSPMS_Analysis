package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpParams;

public final class a {
  public static final String a = "application/octet-stream;binary/octet-stream";
  
  public String b;
  
  private Context c;
  
  private a(Context paramContext) {
    this(paramContext, null);
  }
  
  public a(Context paramContext, String paramString) {
    if (paramContext != null) {
      this.c = paramContext.getApplicationContext();
    } else {
      this.c = paramContext;
    } 
    this.b = paramString;
  }
  
  private String a() {
    return this.b;
  }
  
  private void a(String paramString) {
    this.b = paramString;
  }
  
  private URL b() {
    try {
      URL uRL = new URL();
      this(this.b);
    } catch (Exception exception) {
      exception = null;
    } 
    return (URL)exception;
  }
  
  private HttpHost c() {
    HttpHost httpHost;
    String str1 = null;
    if (Build.VERSION.SDK_INT >= 11) {
      String str = g();
      if (str != null && !str.contains("wap"))
        return (HttpHost)str1; 
      URL uRL = b();
      str = str1;
      if (uRL != null) {
        "https".equalsIgnoreCase(uRL.getProtocol());
        String str3 = System.getProperty("https.proxyHost");
        String str4 = System.getProperty("https.proxyPort");
        str = str1;
        if (!TextUtils.isEmpty(str3))
          httpHost = new HttpHost(str3, Integer.parseInt(str4)); 
      } 
      return httpHost;
    } 
    NetworkInfo networkInfo = f();
    String str2 = str1;
    if (networkInfo != null) {
      str2 = str1;
      if (networkInfo.isAvailable()) {
        str2 = str1;
        if (networkInfo.getType() == 0) {
          String str = Proxy.getDefaultHost();
          int i = Proxy.getDefaultPort();
          str2 = str1;
          if (str != null)
            httpHost = new HttpHost(str, i); 
        } 
      } 
    } 
    return httpHost;
  }
  
  private HttpHost d() {
    HttpHost httpHost1 = null;
    NetworkInfo networkInfo = f();
    HttpHost httpHost2 = httpHost1;
    if (networkInfo != null) {
      httpHost2 = httpHost1;
      if (networkInfo.isAvailable()) {
        httpHost2 = httpHost1;
        if (networkInfo.getType() == 0) {
          String str = Proxy.getDefaultHost();
          int i = Proxy.getDefaultPort();
          httpHost2 = httpHost1;
          if (str != null)
            httpHost2 = new HttpHost(str, i); 
        } 
      } 
    } 
    return httpHost2;
  }
  
  private HttpHost e() {
    HttpHost httpHost;
    String str1 = null;
    String str2 = g();
    if (str2 != null && !str2.contains("wap"))
      return (HttpHost)str1; 
    URL uRL = b();
    str2 = str1;
    if (uRL != null) {
      "https".equalsIgnoreCase(uRL.getProtocol());
      String str4 = System.getProperty("https.proxyHost");
      String str3 = System.getProperty("https.proxyPort");
      str2 = str1;
      if (!TextUtils.isEmpty(str4))
        httpHost = new HttpHost(str4, Integer.parseInt(str3)); 
    } 
    return httpHost;
  }
  
  private NetworkInfo f() {
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
    } catch (Exception exception) {
      exception = null;
    } 
    return (NetworkInfo)exception;
  }
  
  private String g() {
    String str;
    try {
      NetworkInfo networkInfo = f();
      if (networkInfo != null && networkInfo.isAvailable())
        return (networkInfo.getType() == 1) ? "wifi" : networkInfo.getExtraInfo().toLowerCase(); 
      str = "none";
    } catch (Exception exception) {
      str = "none";
    } 
    return str;
  }
  
  public final HttpResponse a(byte[] paramArrayOfbyte, List<Header> paramList) throws Throwable {
    String str = null;
    byte[] arrayOfByte = null;
    (new StringBuilder("requestUrl : ")).append(this.b);
    b b = b.a();
    if (b == null)
      return (HttpResponse)arrayOfByte; 
    try {
      HttpGet httpGet;
      HttpPost httpPost;
      HttpHost httpHost;
      HttpParams httpParams = b.c.getParams();
      if (Build.VERSION.SDK_INT >= 11) {
        String str1 = g();
        if (str1 != null && !str1.contains("wap")) {
          str1 = str;
        } else {
          URL uRL = b();
          str1 = str;
          if (uRL != null) {
            "https".equalsIgnoreCase(uRL.getProtocol());
            String str2 = System.getProperty("https.proxyHost");
            String str3 = System.getProperty("https.proxyPort");
            str1 = str;
            if (!TextUtils.isEmpty(str2))
              httpHost = new HttpHost(str2, Integer.parseInt(str3)); 
          } 
        } 
      } else {
        NetworkInfo networkInfo = f();
        String str1 = str;
        if (networkInfo != null) {
          str1 = str;
          if (networkInfo.isAvailable()) {
            str1 = str;
            if (networkInfo.getType() == 0) {
              String str2 = Proxy.getDefaultHost();
              int i = Proxy.getDefaultPort();
              str1 = str;
              if (str2 != null)
                httpHost = new HttpHost(str2, i); 
            } 
          } 
        } 
      } 
      if (httpHost != null)
        httpParams.setParameter("http.route.default-proxy", httpHost); 
      if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
        httpGet = new HttpGet();
        this(this.b);
      } else {
        HttpPost httpPost1 = new HttpPost();
        this(this.b);
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity();
        this((byte[])httpGet);
        byteArrayEntity.setContentType("application/octet-stream;binary/octet-stream");
        httpPost1.setEntity((HttpEntity)byteArrayEntity);
        httpPost1.addHeader("Accept-Charset", "UTF-8");
        httpPost1.addHeader("Connection", "Keep-Alive");
        httpPost1.addHeader("Keep-Alive", "timeout=180, max=100");
        httpPost = httpPost1;
      } 
      if (paramList != null) {
        Iterator<Header> iterator = paramList.iterator();
        while (iterator.hasNext())
          httpPost.addHeader(iterator.next()); 
      } 
    } catch (Throwable throwable) {
      if (b != null)
        try {
          ClientConnectionManager clientConnectionManager = b.c.getConnectionManager();
          if (clientConnectionManager != null) {
            clientConnectionManager.shutdown();
            b.b = null;
          } 
        } catch (Throwable throwable1) {} 
      throw throwable;
    } 
    HttpResponse httpResponse2 = b.a((HttpUriRequest)throwable);
    Header[] arrayOfHeader1 = httpResponse2.getHeaders("X-Hostname");
    if (arrayOfHeader1 != null && arrayOfHeader1.length > 0 && arrayOfHeader1[0] != null)
      httpResponse2.getHeaders("X-Hostname")[0].toString(); 
    Header[] arrayOfHeader2 = httpResponse2.getHeaders("X-ExecuteTime");
    HttpResponse httpResponse1 = httpResponse2;
    if (arrayOfHeader2 != null) {
      httpResponse1 = httpResponse2;
      if (arrayOfHeader2.length > 0) {
        httpResponse1 = httpResponse2;
        if (arrayOfHeader2[0] != null) {
          httpResponse2.getHeaders("X-ExecuteTime")[0].toString();
          httpResponse1 = httpResponse2;
        } 
      } 
    } 
    return httpResponse1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\net\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */