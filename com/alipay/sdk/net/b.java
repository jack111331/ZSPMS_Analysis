package com.alipay.sdk.net;

import android.os.Build;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class b {
  public static final String a = "msp";
  
  static b b;
  
  final DefaultHttpClient c;
  
  private b(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
    this.c = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams);
  }
  
  private b(HttpParams paramHttpParams) {
    this.c = new DefaultHttpClient(paramHttpParams);
  }
  
  public static b a() {
    if (b == null) {
      BasicHttpParams basicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion((HttpParams)basicHttpParams, (ProtocolVersion)HttpVersion.HTTP_1_1);
      HttpConnectionParams.setStaleCheckingEnabled((HttpParams)basicHttpParams, true);
      basicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
      ConnManagerParams.setMaxTotalConnections((HttpParams)basicHttpParams, 50);
      ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)basicHttpParams, (ConnPerRoute)new ConnPerRouteBean(30));
      ConnManagerParams.setTimeout((HttpParams)basicHttpParams, 1000L);
      HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 20000);
      HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 30000);
      HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 16384);
      HttpProtocolParams.setUseExpectContinue((HttpParams)basicHttpParams, false);
      HttpClientParams.setRedirecting((HttpParams)basicHttpParams, true);
      HttpClientParams.setAuthenticating((HttpParams)basicHttpParams, false);
      HttpProtocolParams.setUserAgent((HttpParams)basicHttpParams, "msp");
      try {
        SSLSocketFactory sSLSocketFactory = SSLSocketFactory.getSocketFactory();
        sSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        Scheme scheme1 = new Scheme();
        this("https", (SocketFactory)sSLSocketFactory, 443);
        Scheme scheme2 = new Scheme();
        this("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        this();
        schemeRegistry.register(scheme1);
        schemeRegistry.register(scheme2);
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager();
        this((HttpParams)basicHttpParams, schemeRegistry);
        b b1 = new b();
        this((ClientConnectionManager)threadSafeClientConnManager, (HttpParams)basicHttpParams);
        b = b1;
      } catch (Exception exception) {
        b = new b((HttpParams)basicHttpParams);
      } 
    } 
    return b;
  }
  
  private <T> T a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler) throws Exception {
    try {
      return (T)this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private <T> T a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws Exception {
    try {
      return (T)this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private <T> T a(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler) throws Exception {
    try {
      return (T)this.c.execute(paramHttpUriRequest, paramResponseHandler);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private <T> T a(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws Exception {
    try {
      return (T)this.c.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws Exception {
    try {
      return this.c.execute(paramHttpHost, paramHttpRequest);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws Exception {
    try {
      return this.c.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws Exception {
    try {
      return this.c.execute(paramHttpUriRequest, paramHttpContext);
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private static b b() {
    return b;
  }
  
  private static void c() {
    b = null;
  }
  
  private void d() {
    ClientConnectionManager clientConnectionManager = this.c.getConnectionManager();
    if (clientConnectionManager != null) {
      clientConnectionManager.closeExpiredConnections();
      if (Build.VERSION.SDK_INT >= 9)
        clientConnectionManager.closeIdleConnections(30L, TimeUnit.MINUTES); 
    } 
  }
  
  private void e() {
    ClientConnectionManager clientConnectionManager = this.c.getConnectionManager();
    if (clientConnectionManager != null) {
      clientConnectionManager.shutdown();
      b = null;
    } 
  }
  
  private HttpParams f() {
    return this.c.getParams();
  }
  
  private ClientConnectionManager g() {
    return this.c.getConnectionManager();
  }
  
  public final HttpResponse a(HttpUriRequest paramHttpUriRequest) throws Exception {
    try {
      return this.c.execute(paramHttpUriRequest);
    } catch (Exception exception) {
      throw exception;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\net\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */