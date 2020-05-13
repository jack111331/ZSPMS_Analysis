package okhttp3.internal.io;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.ConnectionSpecSelector;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection extends FramedConnection.Listener implements Connection {
  public int allocationLimit;
  
  public final List<Reference<StreamAllocation>> allocations = new ArrayList<Reference<StreamAllocation>>();
  
  public volatile FramedConnection framedConnection;
  
  private Handshake handshake;
  
  public long idleAtNanos = Long.MAX_VALUE;
  
  public boolean noNewStreams;
  
  private Protocol protocol;
  
  private Socket rawSocket;
  
  private final Route route;
  
  public BufferedSink sink;
  
  public Socket socket;
  
  public BufferedSource source;
  
  public int successCount;
  
  public RealConnection(Route paramRoute) {
    this.route = paramRoute;
  }
  
  private void buildConnection(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    connectSocket(paramInt1, paramInt2, paramInt3, paramConnectionSpecSelector);
    establishProtocol(paramInt2, paramInt3, paramConnectionSpecSelector);
  }
  
  private void buildTunneledConnection(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    Request request = createTunnelRequest();
    HttpUrl httpUrl = request.url();
    byte b = 0;
    while (true) {
      if (++b > 21)
        throw new ProtocolException("Too many tunnel connections attempted: " + '\025'); 
      connectSocket(paramInt1, paramInt2, paramInt3, paramConnectionSpecSelector);
      request = createTunnel(paramInt2, paramInt3, request, httpUrl);
      if (request == null) {
        establishProtocol(paramInt2, paramInt3, paramConnectionSpecSelector);
        return;
      } 
      Util.closeQuietly(this.rawSocket);
      this.rawSocket = null;
      this.sink = null;
      this.source = null;
    } 
  }
  
  private void connectSocket(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    Socket socket;
    Proxy proxy = this.route.proxy();
    Address address = this.route.address();
    if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
      socket = address.socketFactory().createSocket();
    } else {
      socket = new Socket(proxy);
    } 
    this.rawSocket = socket;
    this.rawSocket.setSoTimeout(paramInt2);
    try {
      Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), paramInt1);
      this.source = Okio.buffer(Okio.source(this.rawSocket));
      this.sink = Okio.buffer(Okio.sink(this.rawSocket));
      return;
    } catch (ConnectException connectException) {
      throw new ConnectException("Failed to connect to " + this.route.socketAddress());
    } 
  }
  
  private void connectTls(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    Protocol protocol;
    StringBuilder stringBuilder;
    Address address = this.route.address();
    SSLSocketFactory sSLSocketFactory = address.sslSocketFactory();
    SSLSocket sSLSocket1 = null;
    SSLSocket sSLSocket2 = null;
    try {
      SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
      sSLSocket2 = sSLSocket;
      sSLSocket1 = sSLSocket;
      ConnectionSpec connectionSpec = paramConnectionSpecSelector.configureSecureSocket(sSLSocket);
      sSLSocket2 = sSLSocket;
      sSLSocket1 = sSLSocket;
      if (connectionSpec.supportsTlsExtensions()) {
        sSLSocket2 = sSLSocket;
        sSLSocket1 = sSLSocket;
        Platform.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
      } 
      sSLSocket2 = sSLSocket;
      sSLSocket1 = sSLSocket;
      sSLSocket.startHandshake();
      sSLSocket2 = sSLSocket;
      sSLSocket1 = sSLSocket;
      Handshake handshake = Handshake.get(sSLSocket.getSession());
      sSLSocket2 = sSLSocket;
    } catch (AssertionError assertionError1) {
    
    } finally {
      if (sSLSocket1 != null)
        Platform.get().afterHandshake(sSLSocket1); 
      if (!false)
        Util.closeQuietly(sSLSocket1); 
    } 
    AssertionError assertionError3 = assertionError1;
    AssertionError assertionError2 = assertionError1;
    address.certificatePinner().check(address.url().host(), stringBuilder.peerCertificates());
    assertionError3 = assertionError1;
    assertionError2 = assertionError1;
    if (paramConnectionSpecSelector.supportsTlsExtensions()) {
      assertionError3 = assertionError1;
      assertionError2 = assertionError1;
      String str = Platform.get().getSelectedProtocol((SSLSocket)assertionError1);
    } else {
      paramConnectionSpecSelector = null;
    } 
    assertionError3 = assertionError1;
    assertionError2 = assertionError1;
    this.socket = (Socket)assertionError1;
    assertionError3 = assertionError1;
    assertionError2 = assertionError1;
    this.source = Okio.buffer(Okio.source(this.socket));
    assertionError3 = assertionError1;
    assertionError2 = assertionError1;
    this.sink = Okio.buffer(Okio.sink(this.socket));
    assertionError3 = assertionError1;
    assertionError2 = assertionError1;
    this.handshake = (Handshake)stringBuilder;
    if (paramConnectionSpecSelector != null) {
      assertionError3 = assertionError1;
      assertionError2 = assertionError1;
      protocol = Protocol.get((String)paramConnectionSpecSelector);
    } else {
      assertionError3 = assertionError1;
      assertionError2 = assertionError1;
      protocol = Protocol.HTTP_1_1;
    } 
    assertionError3 = assertionError1;
    assertionError2 = assertionError1;
    this.protocol = protocol;
    if (assertionError1 != null)
      Platform.get().afterHandshake((SSLSocket)assertionError1); 
    if (!true)
      Util.closeQuietly((Socket)assertionError1); 
  }
  
  private Request createTunnel(int paramInt1, int paramInt2, Request paramRequest, HttpUrl paramHttpUrl) throws IOException {
    Request request;
    Response response;
    Http1xStream http1xStream = null;
    String str = "CONNECT " + Util.hostHeader(paramHttpUrl, true) + " HTTP/1.1";
    do {
      Http1xStream http1xStream1 = new Http1xStream(null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      http1xStream1.writeRequest(paramRequest.headers(), str);
      http1xStream1.finishRequest();
      response = http1xStream1.readResponse().request(paramRequest).build();
      long l1 = OkHeaders.contentLength(response);
      long l2 = l1;
      if (l1 == -1L)
        l2 = 0L; 
      Source source = http1xStream1.newFixedLengthSource(l2);
      Util.skipAll(source, 2147483647, TimeUnit.MILLISECONDS);
      source.close();
      switch (response.code()) {
        default:
          throw new IOException("Unexpected response code for CONNECT: " + response.code());
        case 200:
          if (this.source.buffer().exhausted()) {
            http1xStream1 = http1xStream;
            if (!this.sink.buffer().exhausted())
              throw new IOException("TLS tunnel buffered too many bytes!"); 
            break;
          } 
          throw new IOException("TLS tunnel buffered too many bytes!");
        case 407:
          break;
      } 
      request = this.route.address().proxyAuthenticator().authenticate(this.route, response);
      if (request == null)
        throw new IOException("Failed to authenticate with proxy"); 
      Request request1 = request;
    } while (!"close".equalsIgnoreCase(response.header("Connection")));
    return request;
  }
  
  private Request createTunnelRequest() throws IOException {
    return (new Request.Builder()).url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  private void establishProtocol(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector) throws IOException {
    if (this.route.address().sslSocketFactory() != null) {
      connectTls(paramInt1, paramInt2, paramConnectionSpecSelector);
    } else {
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    } 
    if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
      this.socket.setSoTimeout(0);
      FramedConnection framedConnection = (new FramedConnection.Builder(true)).socket(this.socket, this.route.address().url().host(), this.source, this.sink).protocol(this.protocol).listener(this).build();
      framedConnection.start();
      this.allocationLimit = framedConnection.maxConcurrentStreams();
      this.framedConnection = framedConnection;
      return;
    } 
    this.allocationLimit = 1;
  }
  
  public void cancel() {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, List<ConnectionSpec> paramList, boolean paramBoolean) throws RouteException {
    if (this.protocol != null)
      throw new IllegalStateException("already connected"); 
    RouteException routeException1 = null;
    ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(paramList);
    RouteException routeException2 = routeException1;
    if (this.route.address().sslSocketFactory() == null) {
      routeException2 = routeException1;
      if (!paramList.contains(ConnectionSpec.CLEARTEXT))
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList)); 
    } 
    while (this.protocol == null) {
      try {
        if (this.route.requiresTunnel()) {
          buildTunneledConnection(paramInt1, paramInt2, paramInt3, connectionSpecSelector);
          continue;
        } 
      } catch (IOException iOException) {
        RouteException routeException;
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        if (routeException2 == null) {
          routeException = new RouteException(iOException);
        } else {
          routeException2.addConnectException(iOException);
          routeException = routeException2;
        } 
        if (paramBoolean) {
          routeException2 = routeException;
          if (!connectionSpecSelector.connectionFailed(iOException))
            throw routeException; 
          continue;
        } 
        throw routeException;
      } 
      buildConnection(paramInt1, paramInt2, paramInt3, connectionSpecSelector);
    } 
  }
  
  public Handshake handshake() {
    return this.handshake;
  }
  
  boolean isConnected() {
    return (this.protocol != null);
  }
  
  public boolean isHealthy(boolean paramBoolean) {
    boolean bool1 = true;
    if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown())
      return false; 
    boolean bool2 = bool1;
    if (this.framedConnection == null) {
      bool2 = bool1;
      if (paramBoolean)
        try {
          int i = this.socket.getSoTimeout();
          try {
            this.socket.setSoTimeout(1);
            paramBoolean = this.source.exhausted();
            if (paramBoolean) {
              this.socket.setSoTimeout(i);
              return false;
            } 
            this.socket.setSoTimeout(i);
            bool2 = bool1;
          } finally {
            Exception exception;
          } 
        } catch (SocketTimeoutException socketTimeoutException) {
          bool2 = bool1;
        } catch (IOException iOException) {
          bool2 = false;
        }  
    } 
    return bool2;
  }
  
  public boolean isMultiplexed() {
    return (this.framedConnection != null);
  }
  
  public void onSettings(FramedConnection paramFramedConnection) {
    this.allocationLimit = paramFramedConnection.maxConcurrentStreams();
  }
  
  public void onStream(FramedStream paramFramedStream) throws IOException {
    paramFramedStream.close(ErrorCode.REFUSED_STREAM);
  }
  
  public Protocol protocol() {
    return (this.framedConnection == null) ? ((this.protocol != null) ? this.protocol : Protocol.HTTP_1_1) : this.framedConnection.getProtocol();
  }
  
  public Route route() {
    return this.route;
  }
  
  public Socket socket() {
    return this.socket;
  }
  
  public String toString() {
    StringBuilder stringBuilder = (new StringBuilder()).append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
    if (this.handshake != null) {
      CipherSuite cipherSuite = this.handshake.cipherSuite();
      return stringBuilder.append(cipherSuite).append(" protocol=").append(this.protocol).append('}').toString();
    } 
    String str = "none";
    return stringBuilder.append(str).append(" protocol=").append(this.protocol).append('}').toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\io\RealConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */