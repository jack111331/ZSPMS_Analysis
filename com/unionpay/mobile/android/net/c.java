package com.unionpay.mobile.android.net;

import android.content.Context;
import com.unionpay.mobile.android.utils.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.ByteArrayBuffer;

public final class c {
  private HttpClient a = null;
  
  private HttpResponse b = null;
  
  private HttpEntity c = null;
  
  private byte[] d = null;
  
  private InputStream e = null;
  
  private d f = null;
  
  public c(d paramd, Context paramContext) {
    this.f = paramd;
    BasicHttpParams basicHttpParams = new BasicHttpParams();
    ConnManagerParams.setMaxTotalConnections((HttpParams)basicHttpParams, 20);
    HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 30000);
    HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 60000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)basicHttpParams, 8192);
    HttpClientParams.setRedirecting((HttpParams)basicHttpParams, true);
    HttpProtocolParams.setUserAgent((HttpParams)basicHttpParams, "uppay");
    SchemeRegistry schemeRegistry = new SchemeRegistry();
    schemeRegistry.register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
    schemeRegistry.register(new Scheme("https", new a(paramContext), 443));
    this.a = (HttpClient)new DefaultHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams);
    ((AbstractHttpClient)this.a).setHttpRequestRetryHandler((HttpRequestRetryHandler)new DefaultHttpRequestRetryHandler(0, false));
  }
  
  public final int a() {
    HttpGet httpGet;
    int i = 1;
    k.a("uppay", "HttpConn.connect() +++");
    if (this.f == null) {
      k.c("uppay", "params==null!!!");
      return i;
    } 
    if (this.f.a() == 1) {
      HttpPost httpPost = new HttpPost(this.f.b());
    } else {
      httpGet = new HttpGet(this.f.b());
    } 
    if (this.f.e() != null)
      ((HttpPost)httpGet).setEntity((HttpEntity)new ByteArrayEntity(this.f.e())); 
    HashMap<String, String> hashMap = this.f.d();
    if (hashMap != null)
      for (String str : hashMap.keySet())
        httpGet.addHeader(str, hashMap.get(str));  
    try {
      this.b = this.a.execute((HttpUriRequest)httpGet);
      if (this.b.getStatusLine().getStatusCode() == 200) {
        this.c = this.b.getEntity();
        if (this.c != null) {
          ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer();
          this(2048);
          byte[] arrayOfByte = new byte[2048];
          this.e = this.c.getContent();
          while (true) {
            i = this.e.read(arrayOfByte, 0, arrayOfByte.length);
            if (i != -1) {
              if (i > 0)
                byteArrayBuffer.append(arrayOfByte, 0, i); 
              continue;
            } 
            this.d = byteArrayBuffer.toByteArray();
            i = 0;
            k.a("uppay", "HttpConn.connect() ---");
          } 
        } 
      } else {
        if (this.b.getStatusLine().getStatusCode() == 401) {
          i = 8;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          this("http status code:");
          k.c("uppay", stringBuilder.append(this.b.getStatusLine().getStatusCode()).toString());
          i = 1;
        } 
        k.a("uppay", "HttpConn.connect() ---");
      } 
      i = 1;
    } catch (SSLHandshakeException sSLHandshakeException) {
      k.a("uppay", "e0:" + sSLHandshakeException.getMessage());
      i = 4;
    } catch (IOException iOException) {
      String str;
      if ("e1: " + iOException != null) {
        str = iOException.getMessage();
      } else {
        str = "e == null";
      } 
      k.c("uppay", str);
      i = 1;
    } catch (IllegalStateException illegalStateException) {
      String str;
      if ("e2: " + illegalStateException != null) {
        str = illegalStateException.getMessage();
      } else {
        str = "e == null";
      } 
      k.c("uppay", str);
      i = 1;
    } catch (Exception exception) {}
    k.a("uppay", "HttpConn.connect() ---");
  }
  
  public final byte[] b() {
    return this.d;
  }
  
  public final String c() {
    if (this.d != null) {
      try {
        k.a("uppay", this.d.toString());
        String str = new String();
        this(this.d, "utf-8");
        try {
          StringBuilder stringBuilder = new StringBuilder();
          this("respon:");
          k.a("uppay", stringBuilder.append(str).toString());
          return str;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {}
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException = null;
      } 
    } else {
      return null;
    } 
    k.c("uppay", "convert response to utf-8 error!!!!");
    return (String)SYNTHETIC_LOCAL_VARIABLE_1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\net\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */