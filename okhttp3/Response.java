package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http.OkHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {
  private final ResponseBody body;
  
  private volatile CacheControl cacheControl;
  
  private final Response cacheResponse;
  
  private final int code;
  
  private final Handshake handshake;
  
  private final Headers headers;
  
  private final String message;
  
  private final Response networkResponse;
  
  private final Response priorResponse;
  
  private final Protocol protocol;
  
  private final long receivedResponseAtMillis;
  
  private final Request request;
  
  private final long sentRequestAtMillis;
  
  private Response(Builder paramBuilder) {
    this.request = paramBuilder.request;
    this.protocol = paramBuilder.protocol;
    this.code = paramBuilder.code;
    this.message = paramBuilder.message;
    this.handshake = paramBuilder.handshake;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.networkResponse = paramBuilder.networkResponse;
    this.cacheResponse = paramBuilder.cacheResponse;
    this.priorResponse = paramBuilder.priorResponse;
    this.sentRequestAtMillis = paramBuilder.sentRequestAtMillis;
    this.receivedResponseAtMillis = paramBuilder.receivedResponseAtMillis;
  }
  
  public ResponseBody body() {
    return this.body;
  }
  
  public CacheControl cacheControl() {
    CacheControl cacheControl = this.cacheControl;
    if (cacheControl == null) {
      cacheControl = CacheControl.parse(this.headers);
      this.cacheControl = cacheControl;
    } 
    return cacheControl;
  }
  
  public Response cacheResponse() {
    return this.cacheResponse;
  }
  
  public List<Challenge> challenges() {
    if (this.code == 401) {
      String str = "WWW-Authenticate";
    } else if (this.code == 407) {
      String str = "Proxy-Authenticate";
    } else {
      return (List)Collections.emptyList();
    } 
    return OkHeaders.parseChallenges(headers(), (String)SYNTHETIC_LOCAL_VARIABLE_1);
  }
  
  public void close() {
    this.body.close();
  }
  
  public int code() {
    return this.code;
  }
  
  public Handshake handshake() {
    return this.handshake;
  }
  
  public String header(String paramString) {
    return header(paramString, null);
  }
  
  public String header(String paramString1, String paramString2) {
    paramString1 = this.headers.get(paramString1);
    if (paramString1 == null)
      paramString1 = paramString2; 
    return paramString1;
  }
  
  public List<String> headers(String paramString) {
    return this.headers.values(paramString);
  }
  
  public Headers headers() {
    return this.headers;
  }
  
  public boolean isRedirect() {
    switch (this.code) {
      default:
        return false;
      case 300:
      case 301:
      case 302:
      case 303:
      case 307:
      case 308:
        break;
    } 
    return true;
  }
  
  public boolean isSuccessful() {
    return (this.code >= 200 && this.code < 300);
  }
  
  public String message() {
    return this.message;
  }
  
  public Response networkResponse() {
    return this.networkResponse;
  }
  
  public Builder newBuilder() {
    return new Builder(this);
  }
  
  public ResponseBody peekBody(long paramLong) throws IOException {
    BufferedSource bufferedSource = this.body.source();
    bufferedSource.request(paramLong);
    Buffer buffer = bufferedSource.buffer().clone();
    if (buffer.size() > paramLong) {
      Buffer buffer1 = new Buffer();
      buffer1.write(buffer, paramLong);
      buffer.clear();
      buffer = buffer1;
    } 
    return ResponseBody.create(this.body.contentType(), buffer.size(), (BufferedSource)buffer);
  }
  
  public Response priorResponse() {
    return this.priorResponse;
  }
  
  public Protocol protocol() {
    return this.protocol;
  }
  
  public long receivedResponseAtMillis() {
    return this.receivedResponseAtMillis;
  }
  
  public Request request() {
    return this.request;
  }
  
  public long sentRequestAtMillis() {
    return this.sentRequestAtMillis;
  }
  
  public String toString() {
    return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
  }
  
  public static class Builder {
    private ResponseBody body;
    
    private Response cacheResponse;
    
    private int code = -1;
    
    private Handshake handshake;
    
    private Headers.Builder headers;
    
    private String message;
    
    private Response networkResponse;
    
    private Response priorResponse;
    
    private Protocol protocol;
    
    private long receivedResponseAtMillis;
    
    private Request request;
    
    private long sentRequestAtMillis;
    
    public Builder() {
      this.headers = new Headers.Builder();
    }
    
    private Builder(Response param1Response) {
      this.request = param1Response.request;
      this.protocol = param1Response.protocol;
      this.code = param1Response.code;
      this.message = param1Response.message;
      this.handshake = param1Response.handshake;
      this.headers = param1Response.headers.newBuilder();
      this.body = param1Response.body;
      this.networkResponse = param1Response.networkResponse;
      this.cacheResponse = param1Response.cacheResponse;
      this.priorResponse = param1Response.priorResponse;
      this.sentRequestAtMillis = param1Response.sentRequestAtMillis;
      this.receivedResponseAtMillis = param1Response.receivedResponseAtMillis;
    }
    
    private void checkPriorResponse(Response param1Response) {
      if (param1Response.body != null)
        throw new IllegalArgumentException("priorResponse.body != null"); 
    }
    
    private void checkSupportResponse(String param1String, Response param1Response) {
      if (param1Response.body != null)
        throw new IllegalArgumentException(param1String + ".body != null"); 
      if (param1Response.networkResponse != null)
        throw new IllegalArgumentException(param1String + ".networkResponse != null"); 
      if (param1Response.cacheResponse != null)
        throw new IllegalArgumentException(param1String + ".cacheResponse != null"); 
      if (param1Response.priorResponse != null)
        throw new IllegalArgumentException(param1String + ".priorResponse != null"); 
    }
    
    public Builder addHeader(String param1String1, String param1String2) {
      this.headers.add(param1String1, param1String2);
      return this;
    }
    
    public Builder body(ResponseBody param1ResponseBody) {
      this.body = param1ResponseBody;
      return this;
    }
    
    public Response build() {
      if (this.request == null)
        throw new IllegalStateException("request == null"); 
      if (this.protocol == null)
        throw new IllegalStateException("protocol == null"); 
      if (this.code < 0)
        throw new IllegalStateException("code < 0: " + this.code); 
      return new Response(this);
    }
    
    public Builder cacheResponse(Response param1Response) {
      if (param1Response != null)
        checkSupportResponse("cacheResponse", param1Response); 
      this.cacheResponse = param1Response;
      return this;
    }
    
    public Builder code(int param1Int) {
      this.code = param1Int;
      return this;
    }
    
    public Builder handshake(Handshake param1Handshake) {
      this.handshake = param1Handshake;
      return this;
    }
    
    public Builder header(String param1String1, String param1String2) {
      this.headers.set(param1String1, param1String2);
      return this;
    }
    
    public Builder headers(Headers param1Headers) {
      this.headers = param1Headers.newBuilder();
      return this;
    }
    
    public Builder message(String param1String) {
      this.message = param1String;
      return this;
    }
    
    public Builder networkResponse(Response param1Response) {
      if (param1Response != null)
        checkSupportResponse("networkResponse", param1Response); 
      this.networkResponse = param1Response;
      return this;
    }
    
    public Builder priorResponse(Response param1Response) {
      if (param1Response != null)
        checkPriorResponse(param1Response); 
      this.priorResponse = param1Response;
      return this;
    }
    
    public Builder protocol(Protocol param1Protocol) {
      this.protocol = param1Protocol;
      return this;
    }
    
    public Builder receivedResponseAtMillis(long param1Long) {
      this.receivedResponseAtMillis = param1Long;
      return this;
    }
    
    public Builder removeHeader(String param1String) {
      this.headers.removeAll(param1String);
      return this;
    }
    
    public Builder request(Request param1Request) {
      this.request = param1Request;
      return this;
    }
    
    public Builder sentRequestAtMillis(long param1Long) {
      this.sentRequestAtMillis = param1Long;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */