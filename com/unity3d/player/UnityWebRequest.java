package com.unity3d.player;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

class UnityWebRequest implements Runnable {
  private static final HostnameVerifier k = new HostnameVerifier() {
      public final boolean verify(String param1String, SSLSession param1SSLSession) {
        return true;
      }
    };
  
  private long a;
  
  private String b;
  
  private String c;
  
  private Map d;
  
  private boolean e;
  
  private int f;
  
  private long g;
  
  private long h;
  
  private boolean i;
  
  private boolean j;
  
  UnityWebRequest(long paramLong, String paramString1, Map paramMap, String paramString2, boolean paramBoolean, int paramInt) {
    this.a = paramLong;
    this.b = paramString2;
    this.c = paramString1;
    this.d = paramMap;
    this.e = paramBoolean;
    this.f = paramInt;
  }
  
  static void clearCookieCache(String paramString1, String paramString2) {
    CookieHandler cookieHandler = CookieHandler.getDefault();
    if (cookieHandler != null && cookieHandler instanceof CookieManager) {
      CookieStore cookieStore = ((CookieManager)cookieHandler).getCookieStore();
      if (cookieStore == null)
        return; 
      if (paramString1 == null) {
        cookieStore.removeAll();
        return;
      } 
      try {
        URI uRI = new URI();
        this(null, paramString1, paramString2, null);
        List<HttpCookie> list = cookieStore.get(uRI);
        if (list != null) {
          Iterator<HttpCookie> iterator = list.iterator();
          while (iterator.hasNext())
            cookieStore.remove(uRI, iterator.next()); 
        } 
        return;
      } catch (URISyntaxException uRISyntaxException) {
        g.Log(6, String.format("UnityWebRequest: failed to parse URI %s", new Object[] { paramString1 }));
      } 
    } 
  }
  
  private static native void contentLengthCallback(long paramLong, int paramInt);
  
  private static native boolean downloadCallback(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private static native void errorCallback(long paramLong, int paramInt, String paramString);
  
  private boolean hasTimedOut() {
    return (this.f <= 0) ? false : ((System.currentTimeMillis() - this.g >= this.f));
  }
  
  private static native void headerCallback(long paramLong, String paramString1, String paramString2);
  
  private static native void responseCodeCallback(long paramLong, int paramInt);
  
  private void runSafe() {
    this.g = System.currentTimeMillis();
    try {
      URL uRL = new URL();
      this(this.b);
      URLConnection uRLConnection = uRL.openConnection();
      uRLConnection.setConnectTimeout(this.f);
      uRLConnection.setReadTimeout(this.f);
      boolean bool = uRLConnection instanceof HttpsURLConnection;
      Map map = null;
      if (bool) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRLConnection;
        if (this.e) {
          sSLSocketFactory = (SSLSocketFactory)new b.b() {
              public final void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {
                byte[] arrayOfByte;
                if (param1ArrayOfX509Certificate != null && param1ArrayOfX509Certificate.length > 0) {
                  arrayOfByte = param1ArrayOfX509Certificate[0].getEncoded();
                } else {
                  arrayOfByte = new byte[0];
                } 
                if (this.b.validateCertificateCallback(arrayOfByte))
                  return; 
                throw new CertificateException();
              }
            };
          super(this);
          httpsURLConnection.setHostnameVerifier(k);
        } else {
          sSLSocketFactory = null;
        } 
        SSLSocketFactory sSLSocketFactory = b.a((b.b)sSLSocketFactory);
        if (sSLSocketFactory != null)
          httpsURLConnection.setSSLSocketFactory(sSLSocketFactory); 
      } 
      if (uRL.getProtocol().equalsIgnoreCase("file") && !uRL.getHost().isEmpty()) {
        malformattedUrlCallback("file:// must use an absolute path");
        return;
      } 
      bool = uRLConnection instanceof HttpURLConnection;
      if (bool)
        try {
          HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
          httpURLConnection.setRequestMethod(this.c);
          httpURLConnection.setInstanceFollowRedirects(false);
          if (this.h > 0L) {
            if (this.j) {
              httpURLConnection.setChunkedStreamingMode(0);
            } else {
              httpURLConnection.setFixedLengthStreamingMode((int)this.h);
            } 
            if (this.i)
              httpURLConnection.addRequestProperty("Expect", "100-continue"); 
          } 
        } catch (ProtocolException protocolException) {
          badProtocolCallback(protocolException.toString());
          return;
        }  
      if (this.d != null)
        for (Map.Entry entry : this.d.entrySet())
          uRLConnection.addRequestProperty((String)entry.getKey(), (String)entry.getValue());  
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(131072);
      if (uploadCallback(null) > 0) {
        uRLConnection.setDoOutput(true);
        try {
          OutputStream outputStream = uRLConnection.getOutputStream();
          while (true) {
            int i = uploadCallback(byteBuffer);
            if (i > 0) {
              if (hasTimedOut()) {
                outputStream.close();
                errorCallback(this.a, 14, "WebRequest timed out.");
                return;
              } 
              outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset(), i);
              continue;
            } 
            break;
          } 
        } catch (Exception exception) {
          errorCallback(exception.toString());
          return;
        } 
      } 
      if (bool) {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
        try {
          responseCodeCallback(httpURLConnection.getResponseCode());
        } catch (UnknownHostException unknownHostException) {
          unknownHostCallback(unknownHostException.toString());
          return;
        } catch (SSLException sSLException) {
          sslCannotConnectCallback(sSLException);
          return;
        } catch (SocketTimeoutException socketTimeoutException) {
          errorCallback(this.a, 14, socketTimeoutException.toString());
          return;
        } catch (IOException iOException) {
          errorCallback(iOException.toString());
          return;
        } 
      } 
      Map<String, List<String>> map1 = uRLConnection.getHeaderFields();
      headerCallback(map1);
      if ((map1 == null || !map1.containsKey("content-length")) && uRLConnection.getContentLength() != -1)
        headerCallback("content-length", String.valueOf(uRLConnection.getContentLength())); 
      if ((map1 == null || !map1.containsKey("content-type")) && uRLConnection.getContentType() != null)
        headerCallback("content-type", uRLConnection.getContentType()); 
      if (map1 != null && map1.containsKey("Set-Cookie") && CookieHandler.getDefault() != null && CookieHandler.getDefault() instanceof CookieManager) {
        CookieStore cookieStore = ((CookieManager)CookieHandler.getDefault()).getCookieStore();
        for (String str : map1.get("Set-Cookie")) {
          StringBuilder stringBuilder;
          try {
            HttpCookie httpCookie = HttpCookie.parse(str).get(0);
            if (httpCookie.getPath() != null && !httpCookie.getPath().equals("") && (httpCookie.getDomain() == null || httpCookie.getDomain().equals(uRL.getHost()))) {
              URI uRI = new URI();
              this(uRL.getProtocol(), uRL.getHost(), httpCookie.getPath(), null);
              httpCookie.setDomain(uRL.getHost());
              cookieStore.add(uRI, httpCookie);
            } 
            continue;
          } catch (IllegalArgumentException illegalArgumentException) {
            stringBuilder = new StringBuilder("UnityWebRequest: error parsing cookie '");
            stringBuilder.append(str);
            stringBuilder.append("': ");
            str = illegalArgumentException.getMessage();
          } catch (URISyntaxException uRISyntaxException) {
            stringBuilder = new StringBuilder("UnityWebRequest: error constructing URI: ");
            str = uRISyntaxException.getMessage();
          } 
          stringBuilder.append(str);
          g.Log(6, stringBuilder.toString());
        } 
      } 
      contentLengthCallback(uRLConnection.getContentLength());
      map1 = map;
      try {
        InputStream inputStream2;
        if (uRLConnection instanceof HttpURLConnection) {
          HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
          responseCodeCallback(httpURLConnection.getResponseCode());
          inputStream2 = httpURLConnection.getErrorStream();
        } 
        InputStream inputStream1 = inputStream2;
        if (inputStream2 == null)
          inputStream1 = uRLConnection.getInputStream(); 
        ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream1);
        while (true) {
          int i = readableByteChannel.read(byteBuffer);
          if (i != -1) {
            if (hasTimedOut()) {
              readableByteChannel.close();
              errorCallback(this.a, 14, "WebRequest timed out.");
              return;
            } 
            if (downloadCallback(byteBuffer, i)) {
              byteBuffer.clear();
              continue;
            } 
          } 
          break;
        } 
        readableByteChannel.close();
        return;
      } catch (UnknownHostException unknownHostException) {
        unknownHostCallback(unknownHostException.toString());
        return;
      } catch (SSLException sSLException) {
        sslCannotConnectCallback(sSLException);
        return;
      } catch (SocketTimeoutException socketTimeoutException) {
        errorCallback(this.a, 14, socketTimeoutException.toString());
        return;
      } catch (IOException iOException) {
        errorCallback(this.a, 12, iOException.toString());
        return;
      } catch (Exception exception) {
        errorCallback(exception.toString());
        return;
      } 
    } catch (MalformedURLException malformedURLException) {
      malformattedUrlCallback(malformedURLException.toString());
      return;
    } catch (IOException iOException) {
      errorCallback(iOException.toString());
      return;
    } 
  }
  
  private static native int uploadCallback(long paramLong, ByteBuffer paramByteBuffer);
  
  private static native boolean validateCertificateCallback(long paramLong, byte[] paramArrayOfbyte);
  
  protected void badProtocolCallback(String paramString) {
    g.Log(6, String.format("UnityWebRequest: badProtocolCallback with error=%s url=%s", new Object[] { paramString, this.b }));
    errorCallback(this.a, 4, paramString);
  }
  
  protected void contentLengthCallback(int paramInt) {
    contentLengthCallback(this.a, paramInt);
  }
  
  protected boolean downloadCallback(ByteBuffer paramByteBuffer, int paramInt) {
    return downloadCallback(this.a, paramByteBuffer, paramInt);
  }
  
  protected void errorCallback(String paramString) {
    g.Log(6, String.format("UnityWebRequest: errorCallback with error=%s url=%s", new Object[] { paramString, this.b }));
    errorCallback(this.a, 2, paramString);
  }
  
  protected void headerCallback(String paramString1, String paramString2) {
    headerCallback(this.a, paramString1, paramString2);
  }
  
  protected void headerCallback(Map paramMap) {
    if (paramMap != null && paramMap.size() != 0)
      for (Map.Entry entry : paramMap.entrySet()) {
        String str2 = (String)entry.getKey();
        String str1 = str2;
        if (str2 == null)
          str1 = "Status"; 
        Iterator<String> iterator = ((List)entry.getValue()).iterator();
        while (iterator.hasNext())
          headerCallback(str1, iterator.next()); 
      }  
  }
  
  protected void malformattedUrlCallback(String paramString) {
    g.Log(6, String.format("UnityWebRequest: malformattedUrlCallback with error=%s url=%s", new Object[] { paramString, this.b }));
    errorCallback(this.a, 5, paramString);
  }
  
  protected void responseCodeCallback(int paramInt) {
    responseCodeCallback(this.a, paramInt);
  }
  
  public void run() {
    try {
      runSafe();
      return;
    } catch (Exception exception) {
      errorCallback(exception.toString());
      return;
    } 
  }
  
  void setupTransferSettings(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
    this.h = paramLong;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
  }
  
  protected void sslCannotConnectCallback(SSLException paramSSLException) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual toString : ()Ljava/lang/String;
    //   4: astore_2
    //   5: bipush #6
    //   7: ldc_w 'UnityWebRequest: sslCannotConnectCallback with error=%s url=%s'
    //   10: iconst_2
    //   11: anewarray java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_2
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: getfield b : Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   28: invokestatic Log : (ILjava/lang/String;)V
    //   31: aload_1
    //   32: ifnull -> 79
    //   35: aload_1
    //   36: instanceof javax/net/ssl/SSLKeyException
    //   39: ifeq -> 48
    //   42: bipush #23
    //   44: istore_3
    //   45: goto -> 82
    //   48: aload_1
    //   49: instanceof javax/net/ssl/SSLPeerUnverifiedException
    //   52: ifne -> 73
    //   55: aload_1
    //   56: instanceof java/security/cert/CertPathValidatorException
    //   59: ifeq -> 65
    //   62: goto -> 73
    //   65: aload_1
    //   66: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   69: astore_1
    //   70: goto -> 31
    //   73: bipush #25
    //   75: istore_3
    //   76: goto -> 82
    //   79: bipush #16
    //   81: istore_3
    //   82: aload_0
    //   83: getfield a : J
    //   86: iload_3
    //   87: aload_2
    //   88: invokestatic errorCallback : (JILjava/lang/String;)V
    //   91: return
  }
  
  protected void unknownHostCallback(String paramString) {
    g.Log(6, String.format("UnityWebRequest: unknownHostCallback with error=%s url=%s", new Object[] { paramString, this.b }));
    errorCallback(this.a, 7, paramString);
  }
  
  protected int uploadCallback(ByteBuffer paramByteBuffer) {
    return uploadCallback(this.a, paramByteBuffer);
  }
  
  protected boolean validateCertificateCallback(byte[] paramArrayOfbyte) {
    return validateCertificateCallback(this.a, paramArrayOfbyte);
  }
  
  static {
    if (CookieHandler.getDefault() == null)
      CookieHandler.setDefault(new CookieManager()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\UnityWebRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */