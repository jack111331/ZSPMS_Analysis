package okhttp3.internal.http;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine {
  private static final ResponseBody EMPTY_BODY = new ResponseBody() {
      public long contentLength() {
        return 0L;
      }
      
      public MediaType contentType() {
        return null;
      }
      
      public BufferedSource source() {
        return (BufferedSource)new Buffer();
      }
    };
  
  public static final int MAX_FOLLOW_UPS = 20;
  
  public final boolean bufferRequestBody;
  
  private BufferedSink bufferedRequestBody;
  
  private Response cacheResponse;
  
  private CacheStrategy cacheStrategy;
  
  private final boolean callerWritesRequestBody;
  
  final OkHttpClient client;
  
  private final boolean forWebSocket;
  
  private HttpStream httpStream;
  
  private Request networkRequest;
  
  private final Response priorResponse;
  
  private Sink requestBodyOut;
  
  long sentRequestMillis = -1L;
  
  private CacheRequest storeRequest;
  
  public final StreamAllocation streamAllocation;
  
  private boolean transparentGzip;
  
  private final Request userRequest;
  
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse) {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    if (paramStreamAllocation == null)
      paramStreamAllocation = new StreamAllocation(paramOkHttpClient.connectionPool(), createAddress(paramOkHttpClient, paramRequest)); 
    this.streamAllocation = paramStreamAllocation;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
  }
  
  private Response cacheWritingResponse(final CacheRequest cacheRequest, Response paramResponse) throws IOException {
    if (cacheRequest == null)
      return paramResponse; 
    Sink sink = cacheRequest.body();
    Response response = paramResponse;
    if (sink != null) {
      Source source = new Source() {
          boolean cacheRequestClosed;
          
          public void close() throws IOException {
            if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
              this.cacheRequestClosed = true;
              cacheRequest.abort();
            } 
            source.close();
          }
          
          public long read(Buffer param1Buffer, long param1Long) throws IOException {
            try {
              param1Long = source.read(param1Buffer, param1Long);
              if (param1Long == -1L) {
                if (!this.cacheRequestClosed) {
                  this.cacheRequestClosed = true;
                  cacheBody.close();
                } 
                return -1L;
              } 
            } catch (IOException iOException) {
              if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                cacheRequest.abort();
              } 
              throw iOException;
            } 
            iOException.copyTo(cacheBody.buffer(), iOException.size() - param1Long, param1Long);
            cacheBody.emitCompleteSegments();
            return param1Long;
          }
          
          public Timeout timeout() {
            return source.timeout();
          }
        };
      response = paramResponse.newBuilder().body(new RealResponseBody(paramResponse.headers(), Okio.buffer(source))).build();
    } 
    return response;
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2) throws IOException {
    Headers.Builder builder = new Headers.Builder();
    byte b = 0;
    int i = paramHeaders1.size();
    while (b < i) {
      String str1 = paramHeaders1.name(b);
      String str2 = paramHeaders1.value(b);
      if ((!"Warning".equalsIgnoreCase(str1) || !str2.startsWith("1")) && (!OkHeaders.isEndToEnd(str1) || paramHeaders2.get(str1) == null))
        Internal.instance.addLenient(builder, str1, str2); 
      b++;
    } 
    b = 0;
    i = paramHeaders2.size();
    while (b < i) {
      String str = paramHeaders2.name(b);
      if (!"Content-Length".equalsIgnoreCase(str) && OkHeaders.isEndToEnd(str))
        Internal.instance.addLenient(builder, str, paramHeaders2.value(b)); 
      b++;
    } 
    return builder.build();
  }
  
  private HttpStream connect() throws RouteException, RequestException, IOException {
    if (!this.networkRequest.method().equals("GET")) {
      boolean bool1 = true;
      return this.streamAllocation.newStream(this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), this.client.retryOnConnectionFailure(), bool1);
    } 
    boolean bool = false;
    return this.streamAllocation.newStream(this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), this.client.retryOnConnectionFailure(), bool);
  }
  
  private String cookieHeader(List<Cookie> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    byte b = 0;
    int i = paramList.size();
    while (b < i) {
      if (b > 0)
        stringBuilder.append("; "); 
      Cookie cookie = paramList.get(b);
      stringBuilder.append(cookie.name()).append('=').append(cookie.value());
      b++;
    } 
    return stringBuilder.toString();
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest) {
    SSLSocketFactory sSLSocketFactory = null;
    HostnameVerifier hostnameVerifier = null;
    CertificatePinner certificatePinner = null;
    if (paramRequest.isHttps()) {
      sSLSocketFactory = paramOkHttpClient.sslSocketFactory();
      hostnameVerifier = paramOkHttpClient.hostnameVerifier();
      certificatePinner = paramOkHttpClient.certificatePinner();
    } 
    return new Address(paramRequest.url().host(), paramRequest.url().port(), paramOkHttpClient.dns(), paramOkHttpClient.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, paramOkHttpClient.proxyAuthenticator(), paramOkHttpClient.proxy(), paramOkHttpClient.protocols(), paramOkHttpClient.connectionSpecs(), paramOkHttpClient.proxySelector());
  }
  
  public static boolean hasBody(Response paramResponse) {
    boolean bool = false;
    if (!paramResponse.request().method().equals("HEAD")) {
      int i = paramResponse.code();
      if ((i < 100 || i >= 200) && i != 204 && i != 304)
        return true; 
      if (OkHeaders.contentLength(paramResponse) != -1L || "chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding")))
        bool = true; 
    } 
    return bool;
  }
  
  private boolean isRecoverable(IOException paramIOException, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore #4
    //   5: aload_1
    //   6: instanceof java/net/ProtocolException
    //   9: ifeq -> 17
    //   12: iload #4
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: instanceof java/io/InterruptedIOException
    //   21: ifeq -> 45
    //   24: aload_1
    //   25: instanceof java/net/SocketTimeoutException
    //   28: ifeq -> 40
    //   31: iload_2
    //   32: ifeq -> 40
    //   35: iload_3
    //   36: istore_2
    //   37: goto -> 15
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -> 37
    //   45: aload_1
    //   46: instanceof javax/net/ssl/SSLHandshakeException
    //   49: ifeq -> 65
    //   52: iload #4
    //   54: istore_2
    //   55: aload_1
    //   56: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   59: instanceof java/security/cert/CertificateException
    //   62: ifne -> 15
    //   65: iload #4
    //   67: istore_2
    //   68: aload_1
    //   69: instanceof javax/net/ssl/SSLPeerUnverifiedException
    //   72: ifne -> 15
    //   75: iconst_1
    //   76: istore_2
    //   77: goto -> 15
  }
  
  private void maybeCache() throws IOException {
    InternalCache internalCache = Internal.instance.internalCache(this.client);
    if (internalCache != null) {
      if (!CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
        if (HttpMethod.invalidatesCache(this.networkRequest.method()))
          try {
            internalCache.remove(this.networkRequest);
          } catch (IOException iOException) {} 
        return;
      } 
      this.storeRequest = iOException.put(this.userResponse);
    } 
  }
  
  private Request networkRequest(Request paramRequest) throws IOException {
    Request.Builder builder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null)
      builder.header("Host", Util.hostHeader(paramRequest.url(), false)); 
    if (paramRequest.header("Connection") == null)
      builder.header("Connection", "Keep-Alive"); 
    if (paramRequest.header("Accept-Encoding") == null) {
      this.transparentGzip = true;
      builder.header("Accept-Encoding", "gzip");
    } 
    List<Cookie> list = this.client.cookieJar().loadForRequest(paramRequest.url());
    if (!list.isEmpty())
      builder.header("Cookie", cookieHeader(list)); 
    if (paramRequest.header("User-Agent") == null)
      builder.header("User-Agent", Version.userAgent()); 
    return builder.build();
  }
  
  private Response readNetworkResponse() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield httpStream : Lokhttp3/internal/http/HttpStream;
    //   4: invokeinterface finishRequest : ()V
    //   9: aload_0
    //   10: getfield httpStream : Lokhttp3/internal/http/HttpStream;
    //   13: invokeinterface readResponseHeaders : ()Lokhttp3/Response$Builder;
    //   18: aload_0
    //   19: getfield networkRequest : Lokhttp3/Request;
    //   22: invokevirtual request : (Lokhttp3/Request;)Lokhttp3/Response$Builder;
    //   25: aload_0
    //   26: getfield streamAllocation : Lokhttp3/internal/http/StreamAllocation;
    //   29: invokevirtual connection : ()Lokhttp3/internal/io/RealConnection;
    //   32: invokevirtual handshake : ()Lokhttp3/Handshake;
    //   35: invokevirtual handshake : (Lokhttp3/Handshake;)Lokhttp3/Response$Builder;
    //   38: aload_0
    //   39: getfield sentRequestMillis : J
    //   42: invokevirtual sentRequestAtMillis : (J)Lokhttp3/Response$Builder;
    //   45: invokestatic currentTimeMillis : ()J
    //   48: invokevirtual receivedResponseAtMillis : (J)Lokhttp3/Response$Builder;
    //   51: invokevirtual build : ()Lokhttp3/Response;
    //   54: astore_1
    //   55: aload_0
    //   56: getfield forWebSocket : Z
    //   59: ifeq -> 73
    //   62: aload_1
    //   63: astore_2
    //   64: aload_1
    //   65: invokevirtual code : ()I
    //   68: bipush #101
    //   70: if_icmpeq -> 94
    //   73: aload_1
    //   74: invokevirtual newBuilder : ()Lokhttp3/Response$Builder;
    //   77: aload_0
    //   78: getfield httpStream : Lokhttp3/internal/http/HttpStream;
    //   81: aload_1
    //   82: invokeinterface openResponseBody : (Lokhttp3/Response;)Lokhttp3/ResponseBody;
    //   87: invokevirtual body : (Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   90: invokevirtual build : ()Lokhttp3/Response;
    //   93: astore_2
    //   94: ldc_w 'close'
    //   97: aload_2
    //   98: invokevirtual request : ()Lokhttp3/Request;
    //   101: ldc_w 'Connection'
    //   104: invokevirtual header : (Ljava/lang/String;)Ljava/lang/String;
    //   107: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   110: ifne -> 129
    //   113: ldc_w 'close'
    //   116: aload_2
    //   117: ldc_w 'Connection'
    //   120: invokevirtual header : (Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   126: ifeq -> 136
    //   129: aload_0
    //   130: getfield streamAllocation : Lokhttp3/internal/http/StreamAllocation;
    //   133: invokevirtual noNewStreams : ()V
    //   136: aload_2
    //   137: areturn
  }
  
  private static Response stripBody(Response paramResponse) {
    Response response = paramResponse;
    if (paramResponse != null) {
      response = paramResponse;
      if (paramResponse.body() != null)
        response = paramResponse.newBuilder().body(null).build(); 
    } 
    return response;
  }
  
  private Response unzip(Response paramResponse) throws IOException {
    Response response = paramResponse;
    if (this.transparentGzip) {
      if (!"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")))
        return paramResponse; 
    } else {
      return response;
    } 
    response = paramResponse;
    if (paramResponse.body() != null) {
      GzipSource gzipSource = new GzipSource((Source)paramResponse.body().source());
      Headers headers = paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
      response = paramResponse.newBuilder().headers(headers).body(new RealResponseBody(headers, Okio.buffer((Source)gzipSource))).build();
    } 
    return response;
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2) {
    null = true;
    if (paramResponse2.code() == 304)
      return null; 
    Date date = paramResponse1.headers().getDate("Last-Modified");
    if (date != null) {
      Date date1 = paramResponse2.headers().getDate("Last-Modified");
      return (date1 == null || date1.getTime() >= date.getTime()) ? false : null;
    } 
    return false;
  }
  
  private boolean writeRequestHeadersEagerly() {
    return (this.callerWritesRequestBody && permitsRequestBody(this.networkRequest) && this.requestBodyOut == null);
  }
  
  public void cancel() {
    this.streamAllocation.cancel();
  }
  
  public StreamAllocation close() {
    if (this.bufferedRequestBody != null) {
      Util.closeQuietly((Closeable)this.bufferedRequestBody);
    } else if (this.requestBodyOut != null) {
      Util.closeQuietly((Closeable)this.requestBodyOut);
    } 
    if (this.userResponse != null) {
      Util.closeQuietly((Closeable)this.userResponse.body());
      return this.streamAllocation;
    } 
    this.streamAllocation.streamFailed(null);
    return this.streamAllocation;
  }
  
  public Request followUpRequest() throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield userResponse : Lokhttp3/Response;
    //   6: ifnonnull -> 17
    //   9: new java/lang/IllegalStateException
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: athrow
    //   17: aload_0
    //   18: getfield streamAllocation : Lokhttp3/internal/http/StreamAllocation;
    //   21: invokevirtual connection : ()Lokhttp3/internal/io/RealConnection;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull -> 140
    //   29: aload_2
    //   30: invokeinterface route : ()Lokhttp3/Route;
    //   35: astore_2
    //   36: aload_0
    //   37: getfield userResponse : Lokhttp3/Response;
    //   40: invokevirtual code : ()I
    //   43: istore_3
    //   44: aload_0
    //   45: getfield userRequest : Lokhttp3/Request;
    //   48: invokevirtual method : ()Ljava/lang/String;
    //   51: astore #4
    //   53: iload_3
    //   54: lookupswitch default -> 136, 300 -> 251, 301 -> 251, 302 -> 251, 303 -> 251, 307 -> 228, 308 -> 228, 401 -> 207, 407 -> 145, 408 -> 432
    //   136: aload_1
    //   137: astore_2
    //   138: aload_2
    //   139: areturn
    //   140: aconst_null
    //   141: astore_2
    //   142: goto -> 36
    //   145: aload_2
    //   146: ifnull -> 175
    //   149: aload_2
    //   150: invokevirtual proxy : ()Ljava/net/Proxy;
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual type : ()Ljava/net/Proxy$Type;
    //   158: getstatic java/net/Proxy$Type.HTTP : Ljava/net/Proxy$Type;
    //   161: if_acmpeq -> 186
    //   164: new java/net/ProtocolException
    //   167: dup
    //   168: ldc_w 'Received HTTP_PROXY_AUTH (407) code while not using proxy'
    //   171: invokespecial <init> : (Ljava/lang/String;)V
    //   174: athrow
    //   175: aload_0
    //   176: getfield client : Lokhttp3/OkHttpClient;
    //   179: invokevirtual proxy : ()Ljava/net/Proxy;
    //   182: astore_1
    //   183: goto -> 154
    //   186: aload_0
    //   187: getfield client : Lokhttp3/OkHttpClient;
    //   190: invokevirtual proxyAuthenticator : ()Lokhttp3/Authenticator;
    //   193: aload_2
    //   194: aload_0
    //   195: getfield userResponse : Lokhttp3/Response;
    //   198: invokeinterface authenticate : (Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;
    //   203: astore_2
    //   204: goto -> 138
    //   207: aload_0
    //   208: getfield client : Lokhttp3/OkHttpClient;
    //   211: invokevirtual authenticator : ()Lokhttp3/Authenticator;
    //   214: aload_2
    //   215: aload_0
    //   216: getfield userResponse : Lokhttp3/Response;
    //   219: invokeinterface authenticate : (Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;
    //   224: astore_2
    //   225: goto -> 138
    //   228: aload #4
    //   230: ldc 'GET'
    //   232: invokevirtual equals : (Ljava/lang/Object;)Z
    //   235: ifne -> 251
    //   238: aload_1
    //   239: astore_2
    //   240: aload #4
    //   242: ldc_w 'HEAD'
    //   245: invokevirtual equals : (Ljava/lang/Object;)Z
    //   248: ifeq -> 138
    //   251: aload_1
    //   252: astore_2
    //   253: aload_0
    //   254: getfield client : Lokhttp3/OkHttpClient;
    //   257: invokevirtual followRedirects : ()Z
    //   260: ifeq -> 138
    //   263: aload_0
    //   264: getfield userResponse : Lokhttp3/Response;
    //   267: ldc_w 'Location'
    //   270: invokevirtual header : (Ljava/lang/String;)Ljava/lang/String;
    //   273: astore #5
    //   275: aload_1
    //   276: astore_2
    //   277: aload #5
    //   279: ifnull -> 138
    //   282: aload_0
    //   283: getfield userRequest : Lokhttp3/Request;
    //   286: invokevirtual url : ()Lokhttp3/HttpUrl;
    //   289: aload #5
    //   291: invokevirtual resolve : (Ljava/lang/String;)Lokhttp3/HttpUrl;
    //   294: astore #5
    //   296: aload_1
    //   297: astore_2
    //   298: aload #5
    //   300: ifnull -> 138
    //   303: aload #5
    //   305: invokevirtual scheme : ()Ljava/lang/String;
    //   308: aload_0
    //   309: getfield userRequest : Lokhttp3/Request;
    //   312: invokevirtual url : ()Lokhttp3/HttpUrl;
    //   315: invokevirtual scheme : ()Ljava/lang/String;
    //   318: invokevirtual equals : (Ljava/lang/Object;)Z
    //   321: ifne -> 336
    //   324: aload_1
    //   325: astore_2
    //   326: aload_0
    //   327: getfield client : Lokhttp3/OkHttpClient;
    //   330: invokevirtual followSslRedirects : ()Z
    //   333: ifeq -> 138
    //   336: aload_0
    //   337: getfield userRequest : Lokhttp3/Request;
    //   340: invokevirtual newBuilder : ()Lokhttp3/Request$Builder;
    //   343: astore_2
    //   344: aload #4
    //   346: invokestatic permitsRequestBody : (Ljava/lang/String;)Z
    //   349: ifeq -> 391
    //   352: aload #4
    //   354: invokestatic redirectsToGet : (Ljava/lang/String;)Z
    //   357: ifeq -> 421
    //   360: aload_2
    //   361: ldc 'GET'
    //   363: aconst_null
    //   364: invokevirtual method : (Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   367: pop
    //   368: aload_2
    //   369: ldc_w 'Transfer-Encoding'
    //   372: invokevirtual removeHeader : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   375: pop
    //   376: aload_2
    //   377: ldc 'Content-Length'
    //   379: invokevirtual removeHeader : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   382: pop
    //   383: aload_2
    //   384: ldc_w 'Content-Type'
    //   387: invokevirtual removeHeader : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   390: pop
    //   391: aload_0
    //   392: aload #5
    //   394: invokevirtual sameConnection : (Lokhttp3/HttpUrl;)Z
    //   397: ifne -> 408
    //   400: aload_2
    //   401: ldc_w 'Authorization'
    //   404: invokevirtual removeHeader : (Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   407: pop
    //   408: aload_2
    //   409: aload #5
    //   411: invokevirtual url : (Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;
    //   414: invokevirtual build : ()Lokhttp3/Request;
    //   417: astore_2
    //   418: goto -> 138
    //   421: aload_2
    //   422: aload #4
    //   424: aconst_null
    //   425: invokevirtual method : (Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   428: pop
    //   429: goto -> 368
    //   432: aload_0
    //   433: getfield requestBodyOut : Lokio/Sink;
    //   436: ifnull -> 449
    //   439: aload_0
    //   440: getfield requestBodyOut : Lokio/Sink;
    //   443: instanceof okhttp3/internal/http/RetryableSink
    //   446: ifeq -> 472
    //   449: iconst_1
    //   450: istore_3
    //   451: aload_0
    //   452: getfield callerWritesRequestBody : Z
    //   455: ifeq -> 464
    //   458: aload_1
    //   459: astore_2
    //   460: iload_3
    //   461: ifeq -> 138
    //   464: aload_0
    //   465: getfield userRequest : Lokhttp3/Request;
    //   468: astore_2
    //   469: goto -> 138
    //   472: iconst_0
    //   473: istore_3
    //   474: goto -> 451
  }
  
  public BufferedSink getBufferedRequestBody() {
    Sink sink;
    BufferedSink bufferedSink = this.bufferedRequestBody;
    if (bufferedSink == null) {
      sink = getRequestBody();
      if (sink != null) {
        BufferedSink bufferedSink1 = Okio.buffer(sink);
        this.bufferedRequestBody = bufferedSink1;
        return bufferedSink1;
      } 
      sink = null;
    } 
    return (BufferedSink)sink;
  }
  
  public Connection getConnection() {
    return (Connection)this.streamAllocation.connection();
  }
  
  public Request getRequest() {
    return this.userRequest;
  }
  
  public Sink getRequestBody() {
    if (this.cacheStrategy == null)
      throw new IllegalStateException(); 
    return this.requestBodyOut;
  }
  
  public Response getResponse() {
    if (this.userResponse == null)
      throw new IllegalStateException(); 
    return this.userResponse;
  }
  
  public boolean hasResponse() {
    return (this.userResponse != null);
  }
  
  boolean permitsRequestBody(Request paramRequest) {
    return HttpMethod.permitsRequestBody(paramRequest.method());
  }
  
  public void readResponse() throws IOException {
    if (this.userResponse == null) {
      if (this.networkRequest == null && this.cacheResponse == null)
        throw new IllegalStateException("call sendRequest() first!"); 
      if (this.networkRequest != null) {
        Response response;
        InternalCache internalCache;
        if (this.forWebSocket) {
          this.httpStream.writeRequestHeaders(this.networkRequest);
          response = readNetworkResponse();
        } else if (!this.callerWritesRequestBody) {
          response = (new NetworkInterceptorChain(0, this.networkRequest, (Connection)this.streamAllocation.connection())).proceed(this.networkRequest);
        } else {
          if (this.bufferedRequestBody != null && this.bufferedRequestBody.buffer().size() > 0L)
            this.bufferedRequestBody.emit(); 
          if (this.sentRequestMillis == -1L) {
            if (OkHeaders.contentLength(this.networkRequest) == -1L && this.requestBodyOut instanceof RetryableSink) {
              long l = ((RetryableSink)this.requestBodyOut).contentLength();
              this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
            } 
            this.httpStream.writeRequestHeaders(this.networkRequest);
          } 
          if (this.requestBodyOut != null) {
            if (this.bufferedRequestBody != null) {
              this.bufferedRequestBody.close();
            } else {
              this.requestBodyOut.close();
            } 
            if (this.requestBodyOut instanceof RetryableSink)
              this.httpStream.writeRequestBody((RetryableSink)this.requestBodyOut); 
          } 
          response = readNetworkResponse();
        } 
        receiveHeaders(response.headers());
        if (this.cacheResponse != null) {
          if (validate(this.cacheResponse, response)) {
            this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), response.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
            response.body().close();
            releaseStreamAllocation();
            internalCache = Internal.instance.internalCache(this.client);
            internalCache.trackConditionalCacheHit();
            internalCache.update(this.cacheResponse, this.userResponse);
            this.userResponse = unzip(this.userResponse);
            return;
          } 
          Util.closeQuietly((Closeable)this.cacheResponse.body());
        } 
        this.userResponse = internalCache.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)internalCache)).build();
        if (hasBody(this.userResponse)) {
          maybeCache();
          this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
        } 
      } 
    } 
  }
  
  public void receiveHeaders(Headers paramHeaders) throws IOException {
    if (this.client.cookieJar() != CookieJar.NO_COOKIES) {
      List list = Cookie.parseAll(this.userRequest.url(), paramHeaders);
      if (!list.isEmpty())
        this.client.cookieJar().saveFromResponse(this.userRequest.url(), list); 
    } 
  }
  
  public HttpEngine recover(IOException paramIOException, boolean paramBoolean) {
    return recover(paramIOException, paramBoolean, this.requestBodyOut);
  }
  
  public HttpEngine recover(IOException paramIOException, boolean paramBoolean, Sink paramSink) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aload_0
    //   4: getfield streamAllocation : Lokhttp3/internal/http/StreamAllocation;
    //   7: aload_1
    //   8: invokevirtual streamFailed : (Ljava/io/IOException;)V
    //   11: aload_0
    //   12: getfield client : Lokhttp3/OkHttpClient;
    //   15: invokevirtual retryOnConnectionFailure : ()Z
    //   18: ifne -> 28
    //   21: aload #4
    //   23: astore #5
    //   25: aload #5
    //   27: areturn
    //   28: aload_3
    //   29: ifnull -> 43
    //   32: aload #4
    //   34: astore #5
    //   36: aload_3
    //   37: instanceof okhttp3/internal/http/RetryableSink
    //   40: ifeq -> 25
    //   43: aload #4
    //   45: astore #5
    //   47: aload_0
    //   48: aload_1
    //   49: iload_2
    //   50: invokespecial isRecoverable : (Ljava/io/IOException;Z)Z
    //   53: ifeq -> 25
    //   56: aload #4
    //   58: astore #5
    //   60: aload_0
    //   61: getfield streamAllocation : Lokhttp3/internal/http/StreamAllocation;
    //   64: invokevirtual hasMoreRoutes : ()Z
    //   67: ifeq -> 25
    //   70: aload_0
    //   71: invokevirtual close : ()Lokhttp3/internal/http/StreamAllocation;
    //   74: astore_1
    //   75: new okhttp3/internal/http/HttpEngine
    //   78: dup
    //   79: aload_0
    //   80: getfield client : Lokhttp3/OkHttpClient;
    //   83: aload_0
    //   84: getfield userRequest : Lokhttp3/Request;
    //   87: aload_0
    //   88: getfield bufferRequestBody : Z
    //   91: aload_0
    //   92: getfield callerWritesRequestBody : Z
    //   95: aload_0
    //   96: getfield forWebSocket : Z
    //   99: aload_1
    //   100: aload_3
    //   101: checkcast okhttp3/internal/http/RetryableSink
    //   104: aload_0
    //   105: getfield priorResponse : Lokhttp3/Response;
    //   108: invokespecial <init> : (Lokhttp3/OkHttpClient;Lokhttp3/Request;ZZZLokhttp3/internal/http/StreamAllocation;Lokhttp3/internal/http/RetryableSink;Lokhttp3/Response;)V
    //   111: astore #5
    //   113: goto -> 25
  }
  
  public void releaseStreamAllocation() throws IOException {
    this.streamAllocation.release();
  }
  
  public boolean sameConnection(HttpUrl paramHttpUrl) {
    HttpUrl httpUrl = this.userRequest.url();
    return (httpUrl.host().equals(paramHttpUrl.host()) && httpUrl.port() == paramHttpUrl.port() && httpUrl.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void sendRequest() throws RequestException, RouteException, IOException {
    if (this.cacheStrategy == null) {
      Response response;
      if (this.httpStream != null)
        throw new IllegalStateException(); 
      null = networkRequest(this.userRequest);
      InternalCache internalCache = Internal.instance.internalCache(this.client);
      if (internalCache != null) {
        response = internalCache.get(null);
      } else {
        response = null;
      } 
      this.cacheStrategy = (new CacheStrategy.Factory(System.currentTimeMillis(), null, response)).get();
      this.networkRequest = this.cacheStrategy.networkRequest;
      this.cacheResponse = this.cacheStrategy.cacheResponse;
      if (internalCache != null)
        internalCache.trackResponse(this.cacheStrategy); 
      if (response != null && this.cacheResponse == null)
        Util.closeQuietly((Closeable)response.body()); 
      if (this.networkRequest == null && this.cacheResponse == null) {
        this.userResponse = (new Response.Builder()).request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        return;
      } 
      if (this.networkRequest == null) {
        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
        this.userResponse = unzip(this.userResponse);
        return;
      } 
      try {
        this.httpStream = connect();
        this.httpStream.setHttpEngine(this);
        if (writeRequestHeadersEagerly()) {
          long l = OkHeaders.contentLength(null);
          if (this.bufferRequestBody) {
            if (l > 2147483647L) {
              IllegalStateException illegalStateException = new IllegalStateException();
              this("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
              throw illegalStateException;
            } 
            if (l != -1L) {
              this.httpStream.writeRequestHeaders(this.networkRequest);
              RetryableSink retryableSink = new RetryableSink();
              this((int)l);
              this.requestBodyOut = retryableSink;
            } else {
              RetryableSink retryableSink = new RetryableSink();
              this();
              this.requestBodyOut = retryableSink;
            } 
          } else {
            this.httpStream.writeRequestHeaders(this.networkRequest);
            this.requestBodyOut = this.httpStream.createRequestBody(this.networkRequest, l);
          } 
        } 
      } finally {
        if (!false && response != null)
          Util.closeQuietly((Closeable)response.body()); 
      } 
    } 
  }
  
  public void writingRequestHeaders() {
    if (this.sentRequestMillis != -1L)
      throw new IllegalStateException(); 
    this.sentRequestMillis = System.currentTimeMillis();
  }
  
  class NetworkInterceptorChain implements Interceptor.Chain {
    private int calls;
    
    private final Connection connection;
    
    private final int index;
    
    private final Request request;
    
    NetworkInterceptorChain(int param1Int, Request param1Request, Connection param1Connection) {
      this.index = param1Int;
      this.request = param1Request;
      this.connection = param1Connection;
    }
    
    public Connection connection() {
      return this.connection;
    }
    
    public Response proceed(Request param1Request) throws IOException {
      Response response;
      this.calls++;
      if (this.index > 0) {
        Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
        Address address = connection().route().address();
        if (!param1Request.url().host().equals(address.url().host()) || param1Request.url().port() != address.url().port())
          throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port"); 
        if (this.calls > 1)
          throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once"); 
      } 
      if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
        NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, param1Request, this.connection);
        Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index);
        Response response1 = interceptor.intercept(networkInterceptorChain);
        if (networkInterceptorChain.calls != 1)
          throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once"); 
        response = response1;
        if (response1 == null)
          throw new NullPointerException("network interceptor " + interceptor + " returned null"); 
      } else {
        HttpEngine.this.httpStream.writeRequestHeaders((Request)response);
        HttpEngine.access$102(HttpEngine.this, (Request)response);
        if (HttpEngine.this.permitsRequestBody((Request)response) && response.body() != null) {
          BufferedSink bufferedSink = Okio.buffer(HttpEngine.this.httpStream.createRequestBody((Request)response, response.body().contentLength()));
          response.body().writeTo(bufferedSink);
          bufferedSink.close();
        } 
        response = HttpEngine.this.readNetworkResponse();
        int i = response.code();
        if ((i == 204 || i == 205) && response.body().contentLength() > 0L)
          throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + response.body().contentLength()); 
      } 
      return response;
    }
    
    public Request request() {
      return this.request;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\HttpEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */