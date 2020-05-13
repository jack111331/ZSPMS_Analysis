package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.Header;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2xStream implements HttpStream {
  private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
  
  private static final ByteString ENCODING;
  
  private static final ByteString HOST = ByteString.encodeUtf8("host");
  
  private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
  
  private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS;
  
  private static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
  
  private static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
  
  private static final List<ByteString> SPDY_3_SKIPPED_REQUEST_HEADERS;
  
  private static final List<ByteString> SPDY_3_SKIPPED_RESPONSE_HEADERS;
  
  private static final ByteString TE;
  
  private static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
  
  private static final ByteString UPGRADE;
  
  private final FramedConnection framedConnection;
  
  private HttpEngine httpEngine;
  
  private FramedStream stream;
  
  private final StreamAllocation streamAllocation;
  
  static {
    TE = ByteString.encodeUtf8("te");
    ENCODING = ByteString.encodeUtf8("encoding");
    UPGRADE = ByteString.encodeUtf8("upgrade");
    SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList((Object[])new ByteString[] { 
          CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, 
          Header.VERSION });
    SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList((Object[])new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING });
    HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((Object[])new ByteString[] { 
          CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, 
          Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION });
    HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((Object[])new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE });
  }
  
  public Http2xStream(StreamAllocation paramStreamAllocation, FramedConnection paramFramedConnection) {
    this.streamAllocation = paramStreamAllocation;
    this.framedConnection = paramFramedConnection;
  }
  
  public static List<Header> http2HeadersList(Request paramRequest) {
    Headers headers = paramRequest.headers();
    ArrayList<Header> arrayList = new ArrayList(headers.size() + 4);
    arrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(paramRequest.url(), false)));
    arrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    byte b = 0;
    int i = headers.size();
    while (b < i) {
      ByteString byteString = ByteString.encodeUtf8(headers.name(b).toLowerCase(Locale.US));
      if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(byteString))
        arrayList.add(new Header(byteString, headers.value(b))); 
      b++;
    } 
    return arrayList;
  }
  
  private static String joinOnNull(String paramString1, String paramString2) {
    return paramString1 + Character.MIN_VALUE + paramString2;
  }
  
  public static Response.Builder readHttp2HeadersList(List<Header> paramList) throws IOException {
    String str = null;
    Headers.Builder builder = new Headers.Builder();
    byte b = 0;
    int i = paramList.size();
    while (b < i) {
      String str2;
      ByteString byteString = ((Header)paramList.get(b)).name;
      String str1 = ((Header)paramList.get(b)).value.utf8();
      if (byteString.equals(Header.RESPONSE_STATUS)) {
        str2 = str1;
      } else {
        str2 = str;
        if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
          Internal.instance.addLenient(builder, byteString.utf8(), str1);
          str2 = str;
        } 
      } 
      b++;
      str = str2;
    } 
    if (str == null)
      throw new ProtocolException("Expected ':status' header not present"); 
    StatusLine statusLine = StatusLine.parse("HTTP/1.1 " + str);
    return (new Response.Builder()).protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder.build());
  }
  
  public static Response.Builder readSpdy3HeadersList(List<Header> paramList) throws IOException {
    String str1 = null;
    String str2 = "HTTP/1.1";
    Headers.Builder builder = new Headers.Builder();
    byte b = 0;
    int i = paramList.size();
    while (b < i) {
      ByteString byteString = ((Header)paramList.get(b)).name;
      String str = ((Header)paramList.get(b)).value.utf8();
      int j = 0;
      while (j < str.length()) {
        String str4;
        String str5;
        int k = str.indexOf(false, j);
        int m = k;
        if (k == -1)
          m = str.length(); 
        String str3 = str.substring(j, m);
        if (byteString.equals(Header.RESPONSE_STATUS)) {
          str4 = str3;
          str5 = str2;
        } else if (byteString.equals(Header.VERSION)) {
          str5 = str3;
          str4 = str1;
        } else {
          str4 = str1;
          str5 = str2;
          if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
            Internal.instance.addLenient(builder, byteString.utf8(), str3);
            str4 = str1;
            str5 = str2;
          } 
        } 
        j = m + 1;
        str1 = str4;
        str2 = str5;
      } 
      b++;
    } 
    if (str1 == null)
      throw new ProtocolException("Expected ':status' header not present"); 
    StatusLine statusLine = StatusLine.parse(str2 + " " + str1);
    return (new Response.Builder()).protocol(Protocol.SPDY_3).code(statusLine.code).message(statusLine.message).headers(builder.build());
  }
  
  public static List<Header> spdy3HeadersList(Request paramRequest) {
    Headers headers = paramRequest.headers();
    ArrayList<Header> arrayList = new ArrayList(headers.size() + 5);
    arrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
    arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(paramRequest.url(), false)));
    arrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    LinkedHashSet<ByteString> linkedHashSet = new LinkedHashSet();
    byte b = 0;
    int i = headers.size();
    label21: while (b < i) {
      ByteString byteString = ByteString.encodeUtf8(headers.name(b).toLowerCase(Locale.US));
      if (SPDY_3_SKIPPED_REQUEST_HEADERS.contains(byteString))
        continue; 
      String str = headers.value(b);
      if (linkedHashSet.add(byteString)) {
        arrayList.add(new Header(byteString, str));
        continue;
      } 
      byte b1 = 0;
      while (true) {
        if (b1 < arrayList.size())
          if (((Header)arrayList.get(b1)).name.equals(byteString)) {
            arrayList.set(b1, new Header(byteString, joinOnNull(((Header)arrayList.get(b1)).value.utf8(), str)));
          } else {
            b1++;
            continue;
          }  
        b++;
        continue label21;
      } 
    } 
    return arrayList;
  }
  
  public void cancel() {
    if (this.stream != null)
      this.stream.closeLater(ErrorCode.CANCEL); 
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong) throws IOException {
    return this.stream.getSink();
  }
  
  public void finishRequest() throws IOException {
    this.stream.getSink().close();
  }
  
  public ResponseBody openResponseBody(Response paramResponse) throws IOException {
    StreamFinishingSource streamFinishingSource = new StreamFinishingSource(this.stream.getSource());
    return new RealResponseBody(paramResponse.headers(), Okio.buffer((Source)streamFinishingSource));
  }
  
  public Response.Builder readResponseHeaders() throws IOException {
    return (this.framedConnection.getProtocol() == Protocol.HTTP_2) ? readHttp2HeadersList(this.stream.getResponseHeaders()) : readSpdy3HeadersList(this.stream.getResponseHeaders());
  }
  
  public void setHttpEngine(HttpEngine paramHttpEngine) {
    this.httpEngine = paramHttpEngine;
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink) throws IOException {
    paramRetryableSink.writeToSocket(this.stream.getSink());
  }
  
  public void writeRequestHeaders(Request paramRequest) throws IOException {
    if (this.stream == null) {
      List<Header> list;
      this.httpEngine.writingRequestHeaders();
      boolean bool = this.httpEngine.permitsRequestBody(paramRequest);
      if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
        list = http2HeadersList(paramRequest);
      } else {
        list = spdy3HeadersList((Request)list);
      } 
      this.stream = this.framedConnection.newStream(list, bool, true);
      this.stream.readTimeout().timeout(this.httpEngine.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
      this.stream.writeTimeout().timeout(this.httpEngine.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    } 
  }
  
  class StreamFinishingSource extends ForwardingSource {
    public StreamFinishingSource(Source param1Source) {
      super(param1Source);
    }
    
    public void close() throws IOException {
      Http2xStream.this.streamAllocation.streamFinished(false, Http2xStream.this);
      super.close();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\Http2xStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */