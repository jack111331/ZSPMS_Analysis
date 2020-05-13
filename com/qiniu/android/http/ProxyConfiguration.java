package com.qiniu.android.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public final class ProxyConfiguration {
  public final String hostAddress;
  
  public final String password;
  
  public final int port;
  
  public final Proxy.Type type;
  
  public final String user;
  
  public ProxyConfiguration(String paramString, int paramInt) {
    this(paramString, paramInt, null, null, Proxy.Type.HTTP);
  }
  
  public ProxyConfiguration(String paramString1, int paramInt, String paramString2, String paramString3, Proxy.Type paramType) {
    this.hostAddress = paramString1;
    this.port = paramInt;
    this.user = paramString2;
    this.password = paramString3;
    this.type = paramType;
  }
  
  Authenticator authenticator() {
    return new Authenticator() {
        public Request authenticate(Route param1Route, Response param1Response) throws IOException {
          String str = Credentials.basic(ProxyConfiguration.this.user, ProxyConfiguration.this.password);
          return param1Response.request().newBuilder().header("Proxy-Authorization", str).header("Proxy-Connection", "Keep-Alive").build();
        }
      };
  }
  
  Proxy proxy() {
    return new Proxy(this.type, new InetSocketAddress(this.hostAddress, this.port));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\http\ProxyConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */