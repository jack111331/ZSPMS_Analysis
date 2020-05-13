package okhttp3;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Platform;
import okhttp3.internal.http.HttpEngine;
import okhttp3.internal.http.RequestException;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;

final class RealCall implements Call {
  volatile boolean canceled;
  
  private final OkHttpClient client;
  
  HttpEngine engine;
  
  private boolean executed;
  
  Request originalRequest;
  
  protected RealCall(OkHttpClient paramOkHttpClient, Request paramRequest) {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean) throws IOException {
    return (new ApplicationInterceptorChain(0, this.originalRequest, paramBoolean)).proceed(this.originalRequest);
  }
  
  private String toLoggableString() {
    if (this.canceled) {
      String str1 = "canceled call";
      return str1 + " to " + redactedUrl();
    } 
    String str = "call";
    return str + " to " + redactedUrl();
  }
  
  public void cancel() {
    this.canceled = true;
    if (this.engine != null)
      this.engine.cancel(); 
  }
  
  public void enqueue(Callback paramCallback) {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifeq -> 26
    //   9: new java/lang/IllegalStateException
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 'Already Executed'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    //   26: aload_0
    //   27: iconst_1
    //   28: putfield executed : Z
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield client : Lokhttp3/OkHttpClient;
    //   37: invokevirtual dispatcher : ()Lokhttp3/Dispatcher;
    //   40: new okhttp3/RealCall$AsyncCall
    //   43: dup
    //   44: aload_0
    //   45: aload_1
    //   46: iload_2
    //   47: aconst_null
    //   48: invokespecial <init> : (Lokhttp3/RealCall;Lokhttp3/Callback;ZLokhttp3/RealCall$1;)V
    //   51: invokevirtual enqueue : (Lokhttp3/RealCall$AsyncCall;)V
    //   54: return
    // Exception table:
    //   from	to	target	type
    //   2	21	21	finally
    //   22	24	21	finally
    //   26	33	21	finally
  }
  
  public Response execute() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifeq -> 26
    //   9: new java/lang/IllegalStateException
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 'Already Executed'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    //   26: aload_0
    //   27: iconst_1
    //   28: putfield executed : Z
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield client : Lokhttp3/OkHttpClient;
    //   37: invokevirtual dispatcher : ()Lokhttp3/Dispatcher;
    //   40: aload_0
    //   41: invokevirtual executed : (Lokhttp3/RealCall;)V
    //   44: aload_0
    //   45: iconst_0
    //   46: invokespecial getResponseWithInterceptorChain : (Z)Lokhttp3/Response;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnonnull -> 80
    //   54: new java/io/IOException
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 'Canceled'
    //   61: invokespecial <init> : (Ljava/lang/String;)V
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: getfield client : Lokhttp3/OkHttpClient;
    //   71: invokevirtual dispatcher : ()Lokhttp3/Dispatcher;
    //   74: aload_0
    //   75: invokevirtual finished : (Lokhttp3/Call;)V
    //   78: aload_1
    //   79: athrow
    //   80: aload_0
    //   81: getfield client : Lokhttp3/OkHttpClient;
    //   84: invokevirtual dispatcher : ()Lokhttp3/Dispatcher;
    //   87: aload_0
    //   88: invokevirtual finished : (Lokhttp3/Call;)V
    //   91: aload_1
    //   92: areturn
    // Exception table:
    //   from	to	target	type
    //   2	21	21	finally
    //   22	24	21	finally
    //   26	33	21	finally
    //   33	50	66	finally
    //   54	66	66	finally
  }
  
  Response getResponse(Request paramRequest, boolean paramBoolean) throws IOException {
    RequestBody requestBody = paramRequest.body();
    Request request = paramRequest;
    if (requestBody != null) {
      Request.Builder builder = paramRequest.newBuilder();
      MediaType mediaType = requestBody.contentType();
      if (mediaType != null)
        builder.header("Content-Type", mediaType.toString()); 
      long l = requestBody.contentLength();
      if (l != -1L) {
        builder.header("Content-Length", Long.toString(l));
        builder.removeHeader("Transfer-Encoding");
      } else {
        builder.header("Transfer-Encoding", "chunked");
        builder.removeHeader("Content-Length");
      } 
      request = builder.build();
    } 
    this.engine = new HttpEngine(this.client, request, false, false, paramBoolean, null, null, null);
    byte b = 0;
    while (true) {
      StreamAllocation streamAllocation1;
      Response response;
      Request request1;
      if (this.canceled) {
        this.engine.releaseStreamAllocation();
        throw new IOException("Canceled");
      } 
      boolean bool1 = true;
      boolean bool2 = bool1;
      try {
        this.engine.sendRequest();
        bool2 = bool1;
        this.engine.readResponse();
        if (false)
          this.engine.close().release(); 
        response = this.engine.getResponse();
        request1 = this.engine.followUpRequest();
      } catch (RequestException requestException) {
        bool2 = bool1;
        throw requestException.getCause();
      } catch (RouteException routeException) {
        bool2 = bool1;
        HttpEngine httpEngine = this.engine.recover(routeException.getLastConnectException(), true, null);
        if (httpEngine != null) {
          bool2 = false;
          this.engine = httpEngine;
          if (false)
            this.engine.close().release(); 
          continue;
        } 
        bool2 = bool1;
        throw routeException.getLastConnectException();
      } catch (IOException iOException) {
        bool2 = bool1;
        HttpEngine httpEngine = this.engine.recover(iOException, false, null);
        if (httpEngine != null) {
          bool2 = false;
          this.engine = httpEngine;
          if (false)
            this.engine.close().release(); 
          continue;
        } 
        bool2 = bool1;
        throw iOException;
      } finally {
        if (bool2)
          this.engine.close().release(); 
      } 
      StreamAllocation streamAllocation2 = this.engine.close();
      if (++b > 20) {
        streamAllocation2.release();
        throw new ProtocolException("Too many follow-up requests: " + b);
      } 
      if (!this.engine.sameConnection(request1.url())) {
        streamAllocation2.release();
        paramRequest = null;
      } else {
        streamAllocation1 = streamAllocation2;
        if (streamAllocation2.stream() != null)
          throw new IllegalStateException("Closing the body of " + response + " didn't close its backing stream. Bad interceptor?"); 
      } 
      this.engine = new HttpEngine(this.client, request1, false, false, paramBoolean, streamAllocation1, null, response);
    } 
  }
  
  public boolean isCanceled() {
    return this.canceled;
  }
  
  public boolean isExecuted() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  HttpUrl redactedUrl() {
    return this.originalRequest.url().resolve("/...");
  }
  
  public Request request() {
    return this.originalRequest;
  }
  
  Object tag() {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain implements Interceptor.Chain {
    private final boolean forWebSocket;
    
    private final int index;
    
    private final Request request;
    
    ApplicationInterceptorChain(int param1Int, Request param1Request, boolean param1Boolean) {
      this.index = param1Int;
      this.request = param1Request;
      this.forWebSocket = param1Boolean;
    }
    
    public Connection connection() {
      return null;
    }
    
    public Response proceed(Request param1Request) throws IOException {
      Response response;
      if (this.index < RealCall.this.client.interceptors().size()) {
        ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(this.index + 1, param1Request, this.forWebSocket);
        Interceptor interceptor = RealCall.this.client.interceptors().get(this.index);
        Response response1 = interceptor.intercept(applicationInterceptorChain);
        response = response1;
        if (response1 == null)
          throw new NullPointerException("application interceptor " + interceptor + " returned null"); 
      } else {
        response = RealCall.this.getResponse((Request)response, this.forWebSocket);
      } 
      return response;
    }
    
    public Request request() {
      return this.request;
    }
  }
  
  final class AsyncCall extends NamedRunnable {
    private final boolean forWebSocket;
    
    private final Callback responseCallback;
    
    private AsyncCall(Callback param1Callback, boolean param1Boolean) {
      super("OkHttp %s", new Object[] { this$0.redactedUrl().toString() });
      this.responseCallback = param1Callback;
      this.forWebSocket = param1Boolean;
    }
    
    void cancel() {
      RealCall.this.cancel();
    }
    
    protected void execute() {
      boolean bool1 = false;
      boolean bool2 = bool1;
      try {
        RealCall realCall;
        Response response = RealCall.this.getResponseWithInterceptorChain(this.forWebSocket);
        bool2 = bool1;
        if (RealCall.this.canceled) {
          bool1 = true;
          bool2 = bool1;
          Callback callback = this.responseCallback;
          bool2 = bool1;
          realCall = RealCall.this;
          bool2 = bool1;
          IOException iOException = new IOException();
          bool2 = bool1;
          this("Canceled");
          bool2 = bool1;
          callback.onFailure(realCall, iOException);
        } else {
          bool2 = true;
          this.responseCallback.onResponse(RealCall.this, (Response)realCall);
        } 
        return;
      } catch (IOException iOException) {
        if (bool2) {
          Platform platform = Platform.get();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          platform.log(4, stringBuilder.append("Callback failure for ").append(RealCall.this.toLoggableString()).toString(), iOException);
        } else {
          this.responseCallback.onFailure(RealCall.this, iOException);
        } 
        return;
      } finally {
        RealCall.this.client.dispatcher().finished(this);
      } 
    }
    
    RealCall get() {
      return RealCall.this;
    }
    
    String host() {
      return RealCall.this.originalRequest.url().host();
    }
    
    Request request() {
      return RealCall.this.originalRequest;
    }
    
    Object tag() {
      return RealCall.this.originalRequest.tag();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\RealCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */