package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address {
  final CertificatePinner certificatePinner;
  
  final List<ConnectionSpec> connectionSpecs;
  
  final Dns dns;
  
  final HostnameVerifier hostnameVerifier;
  
  final List<Protocol> protocols;
  
  final Proxy proxy;
  
  final Authenticator proxyAuthenticator;
  
  final ProxySelector proxySelector;
  
  final SocketFactory socketFactory;
  
  final SSLSocketFactory sslSocketFactory;
  
  final HttpUrl url;
  
  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector) {
    String str;
    HttpUrl.Builder builder = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null) {
      str = "https";
    } else {
      str = "http";
    } 
    this.url = builder.scheme(str).host(paramString).port(paramInt).build();
    if (paramDns == null)
      throw new NullPointerException("dns == null"); 
    this.dns = paramDns;
    if (paramSocketFactory == null)
      throw new NullPointerException("socketFactory == null"); 
    this.socketFactory = paramSocketFactory;
    if (paramAuthenticator == null)
      throw new NullPointerException("proxyAuthenticator == null"); 
    this.proxyAuthenticator = paramAuthenticator;
    if (paramList == null)
      throw new NullPointerException("protocols == null"); 
    this.protocols = Util.immutableList(paramList);
    if (paramList1 == null)
      throw new NullPointerException("connectionSpecs == null"); 
    this.connectionSpecs = Util.immutableList(paramList1);
    if (paramProxySelector == null)
      throw new NullPointerException("proxySelector == null"); 
    this.proxySelector = paramProxySelector;
    this.proxy = paramProxy;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
  }
  
  public CertificatePinner certificatePinner() {
    return this.certificatePinner;
  }
  
  public List<ConnectionSpec> connectionSpecs() {
    return this.connectionSpecs;
  }
  
  public Dns dns() {
    return this.dns;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject instanceof Address) {
      paramObject = paramObject;
      bool2 = bool1;
      if (this.url.equals(((Address)paramObject).url)) {
        bool2 = bool1;
        if (this.dns.equals(((Address)paramObject).dns)) {
          bool2 = bool1;
          if (this.proxyAuthenticator.equals(((Address)paramObject).proxyAuthenticator)) {
            bool2 = bool1;
            if (this.protocols.equals(((Address)paramObject).protocols)) {
              bool2 = bool1;
              if (this.connectionSpecs.equals(((Address)paramObject).connectionSpecs)) {
                bool2 = bool1;
                if (this.proxySelector.equals(((Address)paramObject).proxySelector)) {
                  bool2 = bool1;
                  if (Util.equal(this.proxy, ((Address)paramObject).proxy)) {
                    bool2 = bool1;
                    if (Util.equal(this.sslSocketFactory, ((Address)paramObject).sslSocketFactory)) {
                      bool2 = bool1;
                      if (Util.equal(this.hostnameVerifier, ((Address)paramObject).hostnameVerifier)) {
                        bool2 = bool1;
                        if (Util.equal(this.certificatePinner, ((Address)paramObject).certificatePinner))
                          bool2 = true; 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    byte b1;
    byte b2;
    byte b3;
    int i = 0;
    int j = this.url.hashCode();
    int k = this.dns.hashCode();
    int m = this.proxyAuthenticator.hashCode();
    int n = this.protocols.hashCode();
    int i1 = this.connectionSpecs.hashCode();
    int i2 = this.proxySelector.hashCode();
    if (this.proxy != null) {
      b1 = this.proxy.hashCode();
    } else {
      b1 = 0;
    } 
    if (this.sslSocketFactory != null) {
      b2 = this.sslSocketFactory.hashCode();
    } else {
      b2 = 0;
    } 
    if (this.hostnameVerifier != null) {
      b3 = this.hostnameVerifier.hashCode();
    } else {
      b3 = 0;
    } 
    if (this.certificatePinner != null)
      i = this.certificatePinner.hashCode(); 
    return (((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + b1) * 31 + b2) * 31 + b3) * 31 + i;
  }
  
  public HostnameVerifier hostnameVerifier() {
    return this.hostnameVerifier;
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
  
  public SocketFactory socketFactory() {
    return this.socketFactory;
  }
  
  public SSLSocketFactory sslSocketFactory() {
    return this.sslSocketFactory;
  }
  
  public HttpUrl url() {
    return this.url;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */