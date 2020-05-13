package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class q implements Callable<u> {
  private static final HttpRequestRetryHandler e = new ad();
  
  protected l a;
  
  protected Context b;
  
  protected o c;
  
  String d;
  
  private HttpUriRequest f;
  
  private HttpContext g = (HttpContext)new BasicHttpContext();
  
  private CookieStore h = (CookieStore)new BasicCookieStore();
  
  private CookieManager i;
  
  private AbstractHttpEntity j;
  
  private HttpHost k;
  
  private URL l;
  
  private int m = 0;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private String p = null;
  
  private String q;
  
  public q(l paraml, o paramo) {
    this.a = paraml;
    this.b = this.a.a;
    this.c = paramo;
  }
  
  private static long a(String[] paramArrayOfString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: aload_0
    //   4: arraylength
    //   5: if_icmpge -> 46
    //   8: ldc 'max-age'
    //   10: aload_0
    //   11: iload_1
    //   12: aaload
    //   13: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   16: ifeq -> 40
    //   19: aload_0
    //   20: iload_1
    //   21: iconst_1
    //   22: iadd
    //   23: aaload
    //   24: ifnull -> 40
    //   27: aload_0
    //   28: iload_1
    //   29: iconst_1
    //   30: iadd
    //   31: aaload
    //   32: invokestatic parseLong : (Ljava/lang/String;)J
    //   35: lstore_2
    //   36: lload_2
    //   37: lreturn
    //   38: astore #4
    //   40: iinc #1, 1
    //   43: goto -> 2
    //   46: lconst_0
    //   47: lstore_2
    //   48: goto -> 36
    // Exception table:
    //   from	to	target	type
    //   27	36	38	java/lang/Exception
  }
  
  private static HttpUrlHeader a(HttpResponse paramHttpResponse) {
    HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
    for (Header header : paramHttpResponse.getAllHeaders())
      httpUrlHeader.setHead(header.getName(), header.getValue()); 
    return httpUrlHeader;
  }
  
  private u a(HttpResponse paramHttpResponse, int paramInt, String paramString) {
    String str1;
    p p;
    ByteArrayOutputStream byteArrayOutputStream = null;
    String str2 = null;
    (new StringBuilder("开始handle，handleResponse-1,")).append(Thread.currentThread().getId());
    HttpEntity httpEntity = paramHttpResponse.getEntity();
    if (httpEntity != null && paramHttpResponse.getStatusLine().getStatusCode() == 200) {
      (new StringBuilder("200，开始处理，handleResponse-2,threadid = ")).append(Thread.currentThread().getId());
      try {
        byteArrayOutputStream = new ByteArrayOutputStream();
      } finally {
        paramString = null;
        paramHttpResponse = null;
      } 
    } else {
      paramString = str1;
      if (p == null) {
        paramHttpResponse.getStatusLine().getStatusCode();
        paramString = str1;
      } 
      return (u)paramString;
    } 
    if (paramHttpResponse != null)
      try {
        paramHttpResponse.close();
        throw str1;
      } catch (IOException iOException) {
        throw new RuntimeException("ArrayOutputStream close error!", iOException.getCause());
      }  
    throw str1;
  }
  
  private static HashMap<String, String> a(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (String str : paramString.split(";")) {
      String[] arrayOfString;
      if (str.indexOf('=') == -1) {
        arrayOfString = new String[2];
        arrayOfString[0] = "Content-Type";
        arrayOfString[1] = str;
      } else {
        arrayOfString = str.split("=");
      } 
      hashMap.put(arrayOfString[0], arrayOfString[1]);
    } 
    return (HashMap)hashMap;
  }
  
  private void a(HttpEntity paramHttpEntity, OutputStream paramOutputStream) {
    IOException iOException;
    InputStream inputStream = b.a(paramHttpEntity);
    long l1 = paramHttpEntity.getContentLength();
    try {
      byte[] arrayOfByte = new byte[2048];
      while (true) {
        int i = inputStream.read(arrayOfByte);
        if (i != -1 && !this.c.h()) {
          paramOutputStream.write(arrayOfByte, 0, i);
          if (this.c.f() != null && l1 > 0L)
            this.c.f(); 
          continue;
        } 
        break;
      } 
    } catch (Exception exception) {
      exception.getCause();
      iOException = new IOException();
      StringBuilder stringBuilder = new StringBuilder();
      this("HttpWorker Request Error!");
      this(stringBuilder.append(exception.getLocalizedMessage()).toString());
      throw iOException;
    } finally {
      r.a(inputStream);
    } 
    iOException.flush();
    r.a(inputStream);
  }
  
  private static long b(HttpResponse paramHttpResponse) {
    long l1 = 0L;
    Header header2 = paramHttpResponse.getFirstHeader("Cache-Control");
    if (header2 != null) {
      String[] arrayOfString = header2.getValue().split("=");
      if (arrayOfString.length >= 2)
        try {
          return a(arrayOfString);
        } catch (NumberFormatException numberFormatException) {} 
    } 
    Header header1 = paramHttpResponse.getFirstHeader("Expires");
    long l2 = l1;
    if (header1 != null)
      l2 = b.b(header1.getValue()) - System.currentTimeMillis(); 
    return l2;
  }
  
  private URI b() {
    String str = this.c.a();
    if (this.d != null)
      str = this.d; 
    if (str == null)
      throw new RuntimeException("url should not be null"); 
    return new URI(str);
  }
  
  private HttpUriRequest c() {
    if (this.f != null)
      return this.f; 
    if (this.j == null) {
      byte[] arrayOfByte = this.c.b();
      String str = this.c.b("gzip");
      if (arrayOfByte != null) {
        if (TextUtils.equals(str, "true")) {
          this.j = b.a(arrayOfByte);
        } else {
          this.j = (AbstractHttpEntity)new ByteArrayEntity(arrayOfByte);
        } 
        this.j.setContentType(this.c.c());
      } 
    } 
    AbstractHttpEntity abstractHttpEntity = this.j;
    if (abstractHttpEntity != null) {
      HttpPost httpPost = new HttpPost(b());
      httpPost.setEntity((HttpEntity)abstractHttpEntity);
      this.f = (HttpUriRequest)httpPost;
    } else {
      this.f = (HttpUriRequest)new HttpGet(b());
    } 
    return this.f;
  }
  
  private u d() {
    while (true) {
      int i;
      try {
        NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getAllNetworkInfo();
        if (arrayOfNetworkInfo == null) {
          boolean bool = false;
          continue;
        } 
        i = arrayOfNetworkInfo.length;
        byte b1 = 0;
        while (true)
          b1++; 
      } catch (HttpException httpException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          httpException.getCode();
          httpException.getMsg();
        } 
        (new StringBuilder()).append(httpException);
        throw httpException;
      } catch (URISyntaxException uRISyntaxException) {
        throw new RuntimeException("Url parser error!", uRISyntaxException.getCause());
      } catch (SSLHandshakeException sSLHandshakeException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(sSLHandshakeException);
        } 
        (new StringBuilder()).append(sSLHandshakeException);
        throw new HttpException(Integer.valueOf(2), String.valueOf(sSLHandshakeException));
      } catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(sSLPeerUnverifiedException);
        } 
        (new StringBuilder()).append(sSLPeerUnverifiedException);
        throw new HttpException(Integer.valueOf(2), String.valueOf(sSLPeerUnverifiedException));
      } catch (SSLException sSLException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(sSLException);
        } 
        (new StringBuilder()).append(sSLException);
        throw new HttpException(Integer.valueOf(6), String.valueOf(sSLException));
      } catch (ConnectionPoolTimeoutException connectionPoolTimeoutException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(connectionPoolTimeoutException);
        } 
        (new StringBuilder()).append(connectionPoolTimeoutException);
        throw new HttpException(Integer.valueOf(3), String.valueOf(connectionPoolTimeoutException));
      } catch (ConnectTimeoutException connectTimeoutException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(connectTimeoutException);
        } 
        (new StringBuilder()).append(connectTimeoutException);
        throw new HttpException(Integer.valueOf(3), String.valueOf(connectTimeoutException));
      } catch (SocketTimeoutException socketTimeoutException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(socketTimeoutException);
        } 
        (new StringBuilder()).append(socketTimeoutException);
        throw new HttpException(Integer.valueOf(4), String.valueOf(socketTimeoutException));
      } catch (NoHttpResponseException noHttpResponseException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(noHttpResponseException);
        } 
        (new StringBuilder()).append(noHttpResponseException);
        throw new HttpException(Integer.valueOf(5), String.valueOf(noHttpResponseException));
      } catch (HttpHostConnectException httpHostConnectException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(httpHostConnectException);
        } 
        throw new HttpException(Integer.valueOf(8), String.valueOf(httpHostConnectException));
      } catch (UnknownHostException unknownHostException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(unknownHostException);
        } 
        (new StringBuilder()).append(unknownHostException);
        throw new HttpException(Integer.valueOf(9), String.valueOf(unknownHostException));
      } catch (IOException iOException) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(iOException);
        } 
        (new StringBuilder()).append(iOException);
        throw new HttpException(Integer.valueOf(6), String.valueOf(iOException));
      } catch (NullPointerException nullPointerException) {
        e();
        if (this.m <= 0)
          continue; 
        (new StringBuilder()).append(nullPointerException);
        throw new HttpException(Integer.valueOf(0), String.valueOf(nullPointerException));
      } catch (Exception exception) {
        e();
        if (this.c.f() != null) {
          this.c.f();
          (new StringBuilder()).append(exception);
        } 
        throw new HttpException(Integer.valueOf(0), String.valueOf(exception));
      } 
      byte b = 0;
      while (true)
        b++; 
      this.m++;
    } 
  }
  
  private void e() {
    if (this.f != null)
      this.f.abort(); 
  }
  
  private String f() {
    if (!TextUtils.isEmpty(this.q))
      return this.q; 
    this.q = this.c.b("operationType");
    return this.q;
  }
  
  private int g() {
    URL uRL = h();
    return (uRL.getPort() == -1) ? uRL.getDefaultPort() : uRL.getPort();
  }
  
  private URL h() {
    if (this.l != null)
      return this.l; 
    this.l = new URL(this.c.a());
    return this.l;
  }
  
  private CookieManager i() {
    if (this.i != null)
      return this.i; 
    this.i = CookieManager.getInstance();
    return this.i;
  }
  
  public final o a() {
    return this.c;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */