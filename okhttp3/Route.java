package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {
  final Address address;
  
  final InetSocketAddress inetSocketAddress;
  
  final Proxy proxy;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress) {
    if (paramAddress == null)
      throw new NullPointerException("address == null"); 
    if (paramProxy == null)
      throw new NullPointerException("proxy == null"); 
    if (paramInetSocketAddress == null)
      throw new NullPointerException("inetSocketAddress == null"); 
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.inetSocketAddress = paramInetSocketAddress;
  }
  
  public Address address() {
    return this.address;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject instanceof Route) {
      paramObject = paramObject;
      bool2 = bool1;
      if (this.address.equals(((Route)paramObject).address)) {
        bool2 = bool1;
        if (this.proxy.equals(((Route)paramObject).proxy)) {
          bool2 = bool1;
          if (this.inetSocketAddress.equals(((Route)paramObject).inetSocketAddress))
            bool2 = true; 
        } 
      } 
    } 
    return bool2;
  }
  
  public int hashCode() {
    return ((this.address.hashCode() + 527) * 31 + this.proxy.hashCode()) * 31 + this.inetSocketAddress.hashCode();
  }
  
  public Proxy proxy() {
    return this.proxy;
  }
  
  public boolean requiresTunnel() {
    return (this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP);
  }
  
  public InetSocketAddress socketAddress() {
    return this.inetSocketAddress;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Route.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */