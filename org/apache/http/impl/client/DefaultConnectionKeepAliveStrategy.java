package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
  public DefaultConnectionKeepAliveStrategy() {
    throw new RuntimeException("Stub!");
  }
  
  public long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\client\DefaultConnectionKeepAliveStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */