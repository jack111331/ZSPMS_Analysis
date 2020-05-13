package com.criware.filesystem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {
  private SSLSocketFactory internalSSLSocketFactory;
  
  public TLSSocketFactory(SSLSocketFactory paramSSLSocketFactory) throws KeyManagementException, NoSuchAlgorithmException {
    if (paramSSLSocketFactory != null) {
      this.internalSSLSocketFactory = paramSSLSocketFactory;
    } else {
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      sSLContext.init(null, null, null);
      this.internalSSLSocketFactory = sSLContext.getSocketFactory();
    } 
  }
  
  public Socket createSocket() throws IOException {
    return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket());
  }
  
  public Socket createSocket(String paramString, int paramInt) throws IOException, UnknownHostException {
    return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(paramString, paramInt));
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException, UnknownHostException {
    return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt) throws IOException {
    return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(paramInetAddress, paramInt));
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2) throws IOException {
    return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean) throws IOException {
    return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  protected Socket enableTLSOnSocket(Socket paramSocket) {
    if (paramSocket != null && paramSocket instanceof SSLSocket)
      ((SSLSocket)paramSocket).setEnabledProtocols(new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" }); 
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites() {
    return this.internalSSLSocketFactory.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites() {
    return this.internalSSLSocketFactory.getSupportedCipherSuites();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\criware\filesystem\TLSSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */