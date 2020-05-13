package com.unity3d.player;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class b extends SSLSocketFactory {
  private static volatile SSLSocketFactory c;
  
  private static volatile X509TrustManager d;
  
  private static final Object e = new Object[0];
  
  private static final Object f = new Object[0];
  
  private static final boolean g;
  
  private final SSLSocketFactory a;
  
  private final a b;
  
  static {
    boolean bool2 = bool1;
    if (Build.VERSION.SDK_INT >= 16) {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT < 20)
        bool2 = true; 
    } 
    g = bool2;
  }
  
  private b(b[] paramArrayOfb) {
    SSLContext sSLContext = SSLContext.getInstance("TLS");
    sSLContext.init(null, (TrustManager[])paramArrayOfb, null);
    this.a = sSLContext.getSocketFactory();
    this.b = null;
  }
  
  private Socket a(Socket paramSocket) {
    if (paramSocket != null && paramSocket instanceof SSLSocket) {
      if (g) {
        SSLSocket sSLSocket = (SSLSocket)paramSocket;
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
      } 
      if (this.b != null)
        ((SSLSocket)paramSocket).addHandshakeCompletedListener(this.b); 
    } 
    return paramSocket;
  }
  
  public static SSLSocketFactory a(b paramb) {
    StringBuilder stringBuilder;
    if (paramb == null)
      try {
        return b();
      } catch (Exception exception) {
        stringBuilder = new StringBuilder("CustomSSLSocketFactory: Failed to create SSLSocketFactory (");
        stringBuilder.append(exception.getMessage());
        stringBuilder.append(")");
        g.Log(5, stringBuilder.toString());
        return null;
      }  
    return new b(new b[] { (b)stringBuilder });
  }
  
  private static SSLSocketFactory b() {
    synchronized (e) {
      if (c != null)
        return c; 
      b b1 = new b();
      this(null);
      c = b1;
      return b1;
    } 
  }
  
  private static X509TrustManager c() {
    synchronized (f) {
      if (d != null)
        return d; 
      try {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore)null);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
          if (trustManager instanceof X509TrustManager) {
            trustManager = trustManager;
            d = (X509TrustManager)trustManager;
            return (X509TrustManager)trustManager;
          } 
        } 
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        this("CustomSSLSocketFactory: Failed to find X509TrustManager (");
        stringBuilder.append(exception.getMessage());
        stringBuilder.append(")");
        g.Log(5, stringBuilder.toString());
      } 
      return null;
    } 
  }
  
  public final Socket createSocket() {
    return a(this.a.createSocket());
  }
  
  public final Socket createSocket(String paramString, int paramInt) {
    return a(this.a.createSocket(paramString, paramInt));
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) {
    return a(this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt) {
    return a(this.a.createSocket(paramInetAddress, paramInt));
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) {
    return a(this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) {
    return a(this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public final String[] getDefaultCipherSuites() {
    return this.a.getDefaultCipherSuites();
  }
  
  public final String[] getSupportedCipherSuites() {
    return this.a.getSupportedCipherSuites();
  }
  
  static {
    boolean bool1 = false;
  }
  
  final class a implements HandshakeCompletedListener {
    public final void handshakeCompleted(HandshakeCompletedEvent param1HandshakeCompletedEvent) {
      SSLSession sSLSession = param1HandshakeCompletedEvent.getSession();
      sSLSession.getCipherSuite();
      sSLSession.getProtocol();
      try {
        sSLSession.getPeerPrincipal().getName();
      } catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {}
    }
  }
  
  public static abstract class b implements X509TrustManager {
    protected X509TrustManager a = b.a();
    
    public final void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {
      this.a.checkClientTrusted(param1ArrayOfX509Certificate, param1String);
    }
    
    public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) {
      this.a.checkServerTrusted(param1ArrayOfX509Certificate, param1String);
    }
    
    public final X509Certificate[] getAcceptedIssuers() {
      return this.a.getAcceptedIssuers();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */