package okhttp3;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Platform;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

public class OkHttpClient implements Cloneable, Call.Factory {
  private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  
  private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList((Object[])new Protocol[] { Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1 });
  
  final Authenticator authenticator;
  
  final Cache cache;
  
  final CertificateChainCleaner certificateChainCleaner;
  
  final CertificatePinner certificatePinner;
  
  final int connectTimeout;
  
  final ConnectionPool connectionPool;
  
  final List<ConnectionSpec> connectionSpecs;
  
  final CookieJar cookieJar;
  
  final Dispatcher dispatcher;
  
  final Dns dns;
  
  final boolean followRedirects;
  
  final boolean followSslRedirects;
  
  final HostnameVerifier hostnameVerifier;
  
  final List<Interceptor> interceptors;
  
  final InternalCache internalCache;
  
  final List<Interceptor> networkInterceptors;
  
  final List<Protocol> protocols;
  
  final Proxy proxy;
  
  final Authenticator proxyAuthenticator;
  
  final ProxySelector proxySelector;
  
  final int readTimeout;
  
  final boolean retryOnConnectionFailure;
  
  final SocketFactory socketFactory;
  
  final SSLSocketFactory sslSocketFactory;
  
  final int writeTimeout;
  
  static {
    ArrayList<ConnectionSpec> arrayList = new ArrayList(Arrays.asList((Object[])new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS }));
    if (Platform.get().isCleartextTrafficPermitted())
      arrayList.add(ConnectionSpec.CLEARTEXT); 
    DEFAULT_CONNECTION_SPECS = Util.immutableList(arrayList);
    Internal.instance = new Internal() {
        public void addLenient(Headers.Builder param1Builder, String param1String) {
          param1Builder.addLenient(param1String);
        }
        
        public void addLenient(Headers.Builder param1Builder, String param1String1, String param1String2) {
          param1Builder.addLenient(param1String1, param1String2);
        }
        
        public void apply(ConnectionSpec param1ConnectionSpec, SSLSocket param1SSLSocket, boolean param1Boolean) {
          param1ConnectionSpec.apply(param1SSLSocket, param1Boolean);
        }
        
        public StreamAllocation callEngineGetStreamAllocation(Call param1Call) {
          return ((RealCall)param1Call).engine.streamAllocation;
        }
        
        public void callEnqueue(Call param1Call, Callback param1Callback, boolean param1Boolean) {
          ((RealCall)param1Call).enqueue(param1Callback, param1Boolean);
        }
        
        public boolean connectionBecameIdle(ConnectionPool param1ConnectionPool, RealConnection param1RealConnection) {
          return param1ConnectionPool.connectionBecameIdle(param1RealConnection);
        }
        
        public RealConnection get(ConnectionPool param1ConnectionPool, Address param1Address, StreamAllocation param1StreamAllocation) {
          return param1ConnectionPool.get(param1Address, param1StreamAllocation);
        }
        
        public HttpUrl getHttpUrlChecked(String param1String) throws MalformedURLException, UnknownHostException {
          return HttpUrl.getChecked(param1String);
        }
        
        public InternalCache internalCache(OkHttpClient param1OkHttpClient) {
          return param1OkHttpClient.internalCache();
        }
        
        public void put(ConnectionPool param1ConnectionPool, RealConnection param1RealConnection) {
          param1ConnectionPool.put(param1RealConnection);
        }
        
        public RouteDatabase routeDatabase(ConnectionPool param1ConnectionPool) {
          return param1ConnectionPool.routeDatabase;
        }
        
        public void setCache(OkHttpClient.Builder param1Builder, InternalCache param1InternalCache) {
          param1Builder.setInternalCache(param1InternalCache);
        }
      };
  }
  
  public OkHttpClient() {
    this(new Builder());
  }
  
  private OkHttpClient(Builder paramBuilder) {
    this.dispatcher = paramBuilder.dispatcher;
    this.proxy = paramBuilder.proxy;
    this.protocols = paramBuilder.protocols;
    this.connectionSpecs = paramBuilder.connectionSpecs;
    this.interceptors = Util.immutableList(paramBuilder.interceptors);
    this.networkInterceptors = Util.immutableList(paramBuilder.networkInterceptors);
    this.proxySelector = paramBuilder.proxySelector;
    this.cookieJar = paramBuilder.cookieJar;
    this.cache = paramBuilder.cache;
    this.internalCache = paramBuilder.internalCache;
    this.socketFactory = paramBuilder.socketFactory;
    boolean bool = false;
    for (ConnectionSpec connectionSpec : this.connectionSpecs) {
      if (bool || connectionSpec.isTls()) {
        bool = true;
        continue;
      } 
      bool = false;
    } 
    if (paramBuilder.sslSocketFactory != null || !bool) {
      this.sslSocketFactory = paramBuilder.sslSocketFactory;
      this.certificateChainCleaner = paramBuilder.certificateChainCleaner;
    } else {
      X509TrustManager x509TrustManager = systemDefaultTrustManager();
      this.sslSocketFactory = systemDefaultSslSocketFactory(x509TrustManager);
      this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
    } 
    this.hostnameVerifier = paramBuilder.hostnameVerifier;
    this.certificatePinner = paramBuilder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
    this.proxyAuthenticator = paramBuilder.proxyAuthenticator;
    this.authenticator = paramBuilder.authenticator;
    this.connectionPool = paramBuilder.connectionPool;
    this.dns = paramBuilder.dns;
    this.followSslRedirects = paramBuilder.followSslRedirects;
    this.followRedirects = paramBuilder.followRedirects;
    this.retryOnConnectionFailure = paramBuilder.retryOnConnectionFailure;
    this.connectTimeout = paramBuilder.connectTimeout;
    this.readTimeout = paramBuilder.readTimeout;
    this.writeTimeout = paramBuilder.writeTimeout;
  }
  
  private SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager paramX509TrustManager) {
    try {
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      sSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      return sSLContext.getSocketFactory();
    } catch (GeneralSecurityException generalSecurityException) {
      throw new AssertionError();
    } 
  }
  
  private X509TrustManager systemDefaultTrustManager() {
    TrustManager[] arrayOfTrustManager;
    try {
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init((KeyStore)null);
      arrayOfTrustManager = trustManagerFactory.getTrustManagers();
      if (arrayOfTrustManager.length != 1 || !(arrayOfTrustManager[0] instanceof X509TrustManager)) {
        IllegalStateException illegalStateException = new IllegalStateException();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        this(stringBuilder.append("Unexpected default trust managers:").append(Arrays.toString((Object[])arrayOfTrustManager)).toString());
        throw illegalStateException;
      } 
    } catch (GeneralSecurityException generalSecurityException) {
      throw new AssertionError();
    } 
    return (X509TrustManager)arrayOfTrustManager[0];
  }
  
  public Authenticator authenticator() {
    return this.authenticator;
  }
  
  public Cache cache() {
    return this.cache;
  }
  
  public CertificatePinner certificatePinner() {
    return this.certificatePinner;
  }
  
  public int connectTimeoutMillis() {
    return this.connectTimeout;
  }
  
  public ConnectionPool connectionPool() {
    return this.connectionPool;
  }
  
  public List<ConnectionSpec> connectionSpecs() {
    return this.connectionSpecs;
  }
  
  public CookieJar cookieJar() {
    return this.cookieJar;
  }
  
  public Dispatcher dispatcher() {
    return this.dispatcher;
  }
  
  public Dns dns() {
    return this.dns;
  }
  
  public boolean followRedirects() {
    return this.followRedirects;
  }
  
  public boolean followSslRedirects() {
    return this.followSslRedirects;
  }
  
  public HostnameVerifier hostnameVerifier() {
    return this.hostnameVerifier;
  }
  
  public List<Interceptor> interceptors() {
    return this.interceptors;
  }
  
  InternalCache internalCache() {
    return (this.cache != null) ? this.cache.internalCache : this.internalCache;
  }
  
  public List<Interceptor> networkInterceptors() {
    return this.networkInterceptors;
  }
  
  public Builder newBuilder() {
    return new Builder(this);
  }
  
  public Call newCall(Request paramRequest) {
    return new RealCall(this, paramRequest);
  }
  
  public List<Protocol> protocols() {
    return this.protocols;
  }
  
  public Proxy proxy() {
    return this.proxy;
  }
  
  public Authenticator proxyAuthenticator() {
    return this.proxyAuthenticator;
  }
  
  public ProxySelector proxySelector() {
    return this.proxySelector;
  }
  
  public int readTimeoutMillis() {
    return this.readTimeout;
  }
  
  public boolean retryOnConnectionFailure() {
    return this.retryOnConnectionFailure;
  }
  
  public SocketFactory socketFactory() {
    return this.socketFactory;
  }
  
  public SSLSocketFactory sslSocketFactory() {
    return this.sslSocketFactory;
  }
  
  public int writeTimeoutMillis() {
    return this.writeTimeout;
  }
  
  public static final class Builder {
    Authenticator authenticator;
    
    Cache cache;
    
    CertificateChainCleaner certificateChainCleaner;
    
    CertificatePinner certificatePinner;
    
    int connectTimeout;
    
    ConnectionPool connectionPool;
    
    List<ConnectionSpec> connectionSpecs;
    
    CookieJar cookieJar;
    
    Dispatcher dispatcher = new Dispatcher();
    
    Dns dns;
    
    boolean followRedirects;
    
    boolean followSslRedirects;
    
    HostnameVerifier hostnameVerifier;
    
    final List<Interceptor> interceptors = new ArrayList<Interceptor>();
    
    InternalCache internalCache;
    
    final List<Interceptor> networkInterceptors = new ArrayList<Interceptor>();
    
    List<Protocol> protocols;
    
    Proxy proxy;
    
    Authenticator proxyAuthenticator;
    
    ProxySelector proxySelector;
    
    int readTimeout;
    
    boolean retryOnConnectionFailure;
    
    SocketFactory socketFactory;
    
    SSLSocketFactory sslSocketFactory;
    
    int writeTimeout;
    
    public Builder() {
      this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
      this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
      this.proxySelector = ProxySelector.getDefault();
      this.cookieJar = CookieJar.NO_COOKIES;
      this.socketFactory = SocketFactory.getDefault();
      this.hostnameVerifier = (HostnameVerifier)OkHostnameVerifier.INSTANCE;
      this.certificatePinner = CertificatePinner.DEFAULT;
      this.proxyAuthenticator = Authenticator.NONE;
      this.authenticator = Authenticator.NONE;
      this.connectionPool = new ConnectionPool();
      this.dns = Dns.SYSTEM;
      this.followSslRedirects = true;
      this.followRedirects = true;
      this.retryOnConnectionFailure = true;
      this.connectTimeout = 10000;
      this.readTimeout = 10000;
      this.writeTimeout = 10000;
    }
    
    Builder(OkHttpClient param1OkHttpClient) {
      this.proxy = param1OkHttpClient.proxy;
      this.protocols = param1OkHttpClient.protocols;
      this.connectionSpecs = param1OkHttpClient.connectionSpecs;
      this.interceptors.addAll(param1OkHttpClient.interceptors);
      this.networkInterceptors.addAll(param1OkHttpClient.networkInterceptors);
      this.proxySelector = param1OkHttpClient.proxySelector;
      this.cookieJar = param1OkHttpClient.cookieJar;
      this.internalCache = param1OkHttpClient.internalCache;
      this.cache = param1OkHttpClient.cache;
      this.socketFactory = param1OkHttpClient.socketFactory;
      this.sslSocketFactory = param1OkHttpClient.sslSocketFactory;
      this.certificateChainCleaner = param1OkHttpClient.certificateChainCleaner;
      this.hostnameVerifier = param1OkHttpClient.hostnameVerifier;
      this.certificatePinner = param1OkHttpClient.certificatePinner;
      this.proxyAuthenticator = param1OkHttpClient.proxyAuthenticator;
      this.authenticator = param1OkHttpClient.authenticator;
      this.connectionPool = param1OkHttpClient.connectionPool;
      this.dns = param1OkHttpClient.dns;
      this.followSslRedirects = param1OkHttpClient.followSslRedirects;
      this.followRedirects = param1OkHttpClient.followRedirects;
      this.retryOnConnectionFailure = param1OkHttpClient.retryOnConnectionFailure;
      this.connectTimeout = param1OkHttpClient.connectTimeout;
      this.readTimeout = param1OkHttpClient.readTimeout;
      this.writeTimeout = param1OkHttpClient.writeTimeout;
    }
    
    public Builder addInterceptor(Interceptor param1Interceptor) {
      this.interceptors.add(param1Interceptor);
      return this;
    }
    
    public Builder addNetworkInterceptor(Interceptor param1Interceptor) {
      this.networkInterceptors.add(param1Interceptor);
      return this;
    }
    
    public Builder authenticator(Authenticator param1Authenticator) {
      if (param1Authenticator == null)
        throw new NullPointerException("authenticator == null"); 
      this.authenticator = param1Authenticator;
      return this;
    }
    
    public OkHttpClient build() {
      return new OkHttpClient(this);
    }
    
    public Builder cache(Cache param1Cache) {
      this.cache = param1Cache;
      this.internalCache = null;
      return this;
    }
    
    public Builder certificatePinner(CertificatePinner param1CertificatePinner) {
      if (param1CertificatePinner == null)
        throw new NullPointerException("certificatePinner == null"); 
      this.certificatePinner = param1CertificatePinner;
      return this;
    }
    
    public Builder connectTimeout(long param1Long, TimeUnit param1TimeUnit) {
      if (param1Long < 0L)
        throw new IllegalArgumentException("timeout < 0"); 
      if (param1TimeUnit == null)
        throw new NullPointerException("unit == null"); 
      long l = param1TimeUnit.toMillis(param1Long);
      if (l > 2147483647L)
        throw new IllegalArgumentException("Timeout too large."); 
      if (l == 0L && param1Long > 0L)
        throw new IllegalArgumentException("Timeout too small."); 
      this.connectTimeout = (int)l;
      return this;
    }
    
    public Builder connectionPool(ConnectionPool param1ConnectionPool) {
      if (param1ConnectionPool == null)
        throw new NullPointerException("connectionPool == null"); 
      this.connectionPool = param1ConnectionPool;
      return this;
    }
    
    public Builder connectionSpecs(List<ConnectionSpec> param1List) {
      this.connectionSpecs = Util.immutableList(param1List);
      return this;
    }
    
    public Builder cookieJar(CookieJar param1CookieJar) {
      if (param1CookieJar == null)
        throw new NullPointerException("cookieJar == null"); 
      this.cookieJar = param1CookieJar;
      return this;
    }
    
    public Builder dispatcher(Dispatcher param1Dispatcher) {
      if (param1Dispatcher == null)
        throw new IllegalArgumentException("dispatcher == null"); 
      this.dispatcher = param1Dispatcher;
      return this;
    }
    
    public Builder dns(Dns param1Dns) {
      if (param1Dns == null)
        throw new NullPointerException("dns == null"); 
      this.dns = param1Dns;
      return this;
    }
    
    public Builder followRedirects(boolean param1Boolean) {
      this.followRedirects = param1Boolean;
      return this;
    }
    
    public Builder followSslRedirects(boolean param1Boolean) {
      this.followSslRedirects = param1Boolean;
      return this;
    }
    
    public Builder hostnameVerifier(HostnameVerifier param1HostnameVerifier) {
      if (param1HostnameVerifier == null)
        throw new NullPointerException("hostnameVerifier == null"); 
      this.hostnameVerifier = param1HostnameVerifier;
      return this;
    }
    
    public List<Interceptor> interceptors() {
      return this.interceptors;
    }
    
    public List<Interceptor> networkInterceptors() {
      return this.networkInterceptors;
    }
    
    public Builder protocols(List<Protocol> param1List) {
      param1List = Util.immutableList(param1List);
      if (!param1List.contains(Protocol.HTTP_1_1))
        throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + param1List); 
      if (param1List.contains(Protocol.HTTP_1_0))
        throw new IllegalArgumentException("protocols must not contain http/1.0: " + param1List); 
      if (param1List.contains(null))
        throw new IllegalArgumentException("protocols must not contain null"); 
      this.protocols = Util.immutableList(param1List);
      return this;
    }
    
    public Builder proxy(Proxy param1Proxy) {
      this.proxy = param1Proxy;
      return this;
    }
    
    public Builder proxyAuthenticator(Authenticator param1Authenticator) {
      if (param1Authenticator == null)
        throw new NullPointerException("proxyAuthenticator == null"); 
      this.proxyAuthenticator = param1Authenticator;
      return this;
    }
    
    public Builder proxySelector(ProxySelector param1ProxySelector) {
      this.proxySelector = param1ProxySelector;
      return this;
    }
    
    public Builder readTimeout(long param1Long, TimeUnit param1TimeUnit) {
      if (param1Long < 0L)
        throw new IllegalArgumentException("timeout < 0"); 
      if (param1TimeUnit == null)
        throw new NullPointerException("unit == null"); 
      long l = param1TimeUnit.toMillis(param1Long);
      if (l > 2147483647L)
        throw new IllegalArgumentException("Timeout too large."); 
      if (l == 0L && param1Long > 0L)
        throw new IllegalArgumentException("Timeout too small."); 
      this.readTimeout = (int)l;
      return this;
    }
    
    public Builder retryOnConnectionFailure(boolean param1Boolean) {
      this.retryOnConnectionFailure = param1Boolean;
      return this;
    }
    
    void setInternalCache(InternalCache param1InternalCache) {
      this.internalCache = param1InternalCache;
      this.cache = null;
    }
    
    public Builder socketFactory(SocketFactory param1SocketFactory) {
      if (param1SocketFactory == null)
        throw new NullPointerException("socketFactory == null"); 
      this.socketFactory = param1SocketFactory;
      return this;
    }
    
    public Builder sslSocketFactory(SSLSocketFactory param1SSLSocketFactory) {
      if (param1SSLSocketFactory == null)
        throw new NullPointerException("sslSocketFactory == null"); 
      X509TrustManager x509TrustManager = Platform.get().trustManager(param1SSLSocketFactory);
      if (x509TrustManager == null)
        throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + param1SSLSocketFactory.getClass()); 
      this.sslSocketFactory = param1SSLSocketFactory;
      this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
      return this;
    }
    
    public Builder sslSocketFactory(SSLSocketFactory param1SSLSocketFactory, X509TrustManager param1X509TrustManager) {
      if (param1SSLSocketFactory == null)
        throw new NullPointerException("sslSocketFactory == null"); 
      if (param1X509TrustManager == null)
        throw new NullPointerException("trustManager == null"); 
      this.sslSocketFactory = param1SSLSocketFactory;
      this.certificateChainCleaner = CertificateChainCleaner.get(param1X509TrustManager);
      return this;
    }
    
    public Builder writeTimeout(long param1Long, TimeUnit param1TimeUnit) {
      if (param1Long < 0L)
        throw new IllegalArgumentException("timeout < 0"); 
      if (param1TimeUnit == null)
        throw new NullPointerException("unit == null"); 
      long l = param1TimeUnit.toMillis(param1Long);
      if (l > 2147483647L)
        throw new IllegalArgumentException("Timeout too large."); 
      if (l == 0L && param1Long > 0L)
        throw new IllegalArgumentException("Timeout too small."); 
      this.writeTimeout = (int)l;
      return this;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\OkHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */