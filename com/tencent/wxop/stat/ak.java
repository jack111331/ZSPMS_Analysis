package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.a.a.a.a.g;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.g;
import com.tencent.wxop.stat.b.l;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class ak {
  private static b cx = l.av();
  
  private static ak dj = null;
  
  private static Context dk = null;
  
  private long cv = 0L;
  
  DefaultHttpClient dg = null;
  
  f dh = null;
  
  StringBuilder di = new StringBuilder(4096);
  
  private ak(Context paramContext) {
    try {
      dk = paramContext.getApplicationContext();
      this.cv = System.currentTimeMillis() / 1000L;
      f f1 = new f();
      this();
      this.dh = f1;
      boolean bool = c.k();
      if (bool)
        try {
          Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
          Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
          System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
          System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
          System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
          System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
          System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
        } catch (Throwable throwable) {} 
      BasicHttpParams basicHttpParams = new BasicHttpParams();
      this();
      HttpConnectionParams.setStaleCheckingEnabled((HttpParams)basicHttpParams, false);
      HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, 10000);
      HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, 10000);
      DefaultHttpClient defaultHttpClient1 = new DefaultHttpClient();
      this((HttpParams)basicHttpParams);
      this.dg = defaultHttpClient1;
      DefaultHttpClient defaultHttpClient2 = this.dg;
      al al = new al();
      this(this);
      defaultHttpClient2.setKeepAliveStrategy((ConnectionKeepAliveStrategy)al);
    } catch (Throwable throwable) {
      cx.b(throwable);
    } 
  }
  
  static ak Z(Context paramContext) {
    // Byte code:
    //   0: getstatic com/tencent/wxop/stat/ak.dj : Lcom/tencent/wxop/stat/ak;
    //   3: ifnonnull -> 31
    //   6: ldc com/tencent/wxop/stat/ak
    //   8: monitorenter
    //   9: getstatic com/tencent/wxop/stat/ak.dj : Lcom/tencent/wxop/stat/ak;
    //   12: ifnonnull -> 28
    //   15: new com/tencent/wxop/stat/ak
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/tencent/wxop/stat/ak.dj : Lcom/tencent/wxop/stat/ak;
    //   28: ldc com/tencent/wxop/stat/ak
    //   30: monitorexit
    //   31: getstatic com/tencent/wxop/stat/ak.dj : Lcom/tencent/wxop/stat/ak;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/tencent/wxop/stat/ak
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
  }
  
  static Context aB() {
    return dk;
  }
  
  static void j(Context paramContext) {
    dk = paramContext.getApplicationContext();
  }
  
  final void a(d paramd, aj paramaj) {
    b(Arrays.asList((Object[])new String[] { paramd.af() }, ), paramaj);
  }
  
  final void a(List<?> paramList, aj paramaj) {
    int k;
    HttpEntity httpEntity;
    b b1;
    ByteArrayOutputStream byteArrayOutputStream;
    InputStream inputStream;
    long l;
    int i = 0;
    if (paramList == null || paramList.isEmpty())
      return; 
    int j = paramList.size();
    paramList.get(0);
    try {
      this.di.delete(0, this.di.length());
      this.di.append("[");
      for (k = 0; k < j; k++) {
        this.di.append(paramList.get(k).toString());
        if (k != j - 1)
          this.di.append(","); 
      } 
      this.di.append("]");
      String str1 = this.di.toString();
      int m = str1.length();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      String str2 = stringBuilder.append(c.y()).append("/?index=").append(this.cv).toString();
      this.cv++;
      if (c.k()) {
        b b2 = cx;
        StringBuilder stringBuilder1 = new StringBuilder();
        this("[");
        b2.b(stringBuilder1.append(str2).append("]Send request(").append(m).append("bytes), content:").append(str1).toString());
      } 
      HttpPost httpPost = new HttpPost();
      this(str2);
      httpPost.addHeader("Accept-Encoding", "gzip");
      httpPost.setHeader("Connection", "Keep-Alive");
      httpPost.removeHeaders("Cache-Control");
      HttpHost httpHost = g.r(dk).V();
      httpPost.addHeader("Content-Encoding", "rc4");
      if (httpHost == null) {
        this.dg.getParams().removeParameter("http.route.default-proxy");
      } else {
        if (c.k()) {
          b b2 = cx;
          StringBuilder stringBuilder1 = new StringBuilder();
          this("proxy:");
          b2.e(stringBuilder1.append(httpHost.toHostString()).toString());
        } 
        httpPost.addHeader("X-Content-Encoding", "rc4");
        this.dg.getParams().setParameter("http.route.default-proxy", httpHost);
        httpPost.addHeader("X-Online-Host", c.al);
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("Content-Type", "json");
      } 
      byteArrayOutputStream = new ByteArrayOutputStream();
      this(m);
      byte[] arrayOfByte2 = str1.getBytes("UTF-8");
      j = arrayOfByte2.length;
      k = i;
      if (m > c.aA)
        k = 1; 
      byte[] arrayOfByte1 = arrayOfByte2;
      if (k != 0) {
        httpPost.removeHeaders("Content-Encoding");
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        String str = stringBuilder1.append("rc4").append(",gzip").toString();
        httpPost.addHeader("Content-Encoding", str);
        if (httpHost != null) {
          httpPost.removeHeaders("X-Content-Encoding");
          httpPost.addHeader("X-Content-Encoding", str);
        } 
        byteArrayOutputStream.write(new byte[4]);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
        this(byteArrayOutputStream);
        gZIPOutputStream.write(arrayOfByte2);
        gZIPOutputStream.close();
        arrayOfByte2 = byteArrayOutputStream.toByteArray();
        ByteBuffer.wrap(arrayOfByte2, 0, 4).putInt(j);
        byte[] arrayOfByte = arrayOfByte2;
        if (c.k()) {
          b b2 = cx;
          StringBuilder stringBuilder2 = new StringBuilder();
          this("before Gzip:");
          b2.e(stringBuilder2.append(j).append(" bytes, after Gzip:").append(arrayOfByte2.length).append(" bytes").toString());
          arrayOfByte1 = arrayOfByte2;
        } 
      } 
      arrayOfByte2 = g.b(arrayOfByte1);
      ByteArrayEntity byteArrayEntity = new ByteArrayEntity();
      this(arrayOfByte2);
      httpPost.setEntity((HttpEntity)byteArrayEntity);
      HttpResponse httpResponse = this.dg.execute((HttpUriRequest)httpPost);
      httpEntity = httpResponse.getEntity();
      k = httpResponse.getStatusLine().getStatusCode();
      l = httpEntity.getContentLength();
      if (c.k()) {
        b b2 = cx;
        StringBuilder stringBuilder1 = new StringBuilder();
        this("http recv response status code:");
        b2.b(stringBuilder1.append(k).append(", content length:").append(l).toString());
      } 
      if (l <= 0L) {
        cx.d("Server response no data.");
        if (paramaj != null)
          paramaj.B(); 
        EntityUtils.toString(httpEntity);
        return;
      } 
    } catch (Throwable throwable1) {
      if (throwable1 != null) {
        cx.a(throwable1);
        if (paramaj != null)
          try {
            paramaj.B();
          } catch (Throwable throwable) {
            cx.b(throwable);
          }  
        if (throwable1 instanceof OutOfMemoryError) {
          System.gc();
          this.di = null;
          this.di = new StringBuilder(2048);
        } 
        g.r(dk).I();
      } 
      return;
    } finally {}
    if (l > 0L) {
      inputStream = httpEntity.getContent();
      DataInputStream dataInputStream = new DataInputStream();
      this(inputStream);
      byte[] arrayOfByte2 = new byte[(int)httpEntity.getContentLength()];
      dataInputStream.readFully(arrayOfByte2);
      inputStream.close();
      dataInputStream.close();
      Header header = paramList.getFirstHeader("Content-Encoding");
      byte[] arrayOfByte1 = arrayOfByte2;
      if (header != null)
        if (header.getValue().equalsIgnoreCase("gzip,rc4")) {
          arrayOfByte1 = g.c(l.b(arrayOfByte2));
        } else if (header.getValue().equalsIgnoreCase("rc4,gzip")) {
          arrayOfByte1 = l.b(g.c(arrayOfByte2));
        } else if (header.getValue().equalsIgnoreCase("gzip")) {
          arrayOfByte1 = l.b(arrayOfByte2);
        } else {
          arrayOfByte1 = arrayOfByte2;
          if (header.getValue().equalsIgnoreCase("rc4"))
            arrayOfByte1 = g.c(arrayOfByte2); 
        }  
      String str = new String();
      this(arrayOfByte1, "UTF-8");
      if (c.k()) {
        b b2 = cx;
        StringBuilder stringBuilder = new StringBuilder();
        this("http get response data:");
        b2.b(stringBuilder.append(str).toString());
      } 
      JSONObject jSONObject = new JSONObject();
      this(str);
      if (k == 200) {
        try {
          str = jSONObject.optString("mid");
          if (h.e(str)) {
            if (c.k()) {
              b b2 = cx;
              StringBuilder stringBuilder = new StringBuilder();
              this("update mid:");
              b2.b(stringBuilder.append(str).toString());
            } 
            g.a(dk).b(str);
          } 
          if (!jSONObject.isNull("cfg")) {
            JSONObject jSONObject1 = jSONObject.getJSONObject("cfg");
            c.a(dk, jSONObject1);
          } 
          if (!jSONObject.isNull("ncts")) {
            i = jSONObject.getInt("ncts");
            k = (int)(i - System.currentTimeMillis() / 1000L);
            if (c.k()) {
              b b2 = cx;
              StringBuilder stringBuilder = new StringBuilder();
              this("server time:");
              b2.b(stringBuilder.append(i).append(", diff time:").append(k).toString());
            } 
            l.Q(dk);
            l.a(dk, k);
          } 
        } catch (Throwable throwable1) {}
      } else {
        b1 = cx;
        StringBuilder stringBuilder1 = new StringBuilder();
        this("Server response error code:");
        StringBuilder stringBuilder2 = stringBuilder1.append(k).append(", error:");
        String str1 = new String();
        this((byte[])throwable1, "UTF-8");
        b1.error(stringBuilder2.append(str1).toString());
        if (throwable != null)
          throwable.B(); 
        inputStream.close();
      } 
    } else {
      EntityUtils.toString((HttpEntity)b1);
      byteArrayOutputStream.close();
      paramList = null;
    } 
    if (throwable != null)
      if (b1.optInt("ret") == 0) {
        throwable.ah();
      } else {
        cx.error("response error data.");
        throwable.B();
      }  
    inputStream.close();
  }
  
  final void b(List<?> paramList, aj paramaj) {
    if (this.dh != null)
      this.dh.a(new am(this, paramList, paramaj)); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */