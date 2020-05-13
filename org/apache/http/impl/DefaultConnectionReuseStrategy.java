package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.TokenIterator;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
  public DefaultConnectionReuseStrategy() {
    throw new RuntimeException("Stub!");
  }
  
  protected TokenIterator createTokenIterator(HeaderIterator paramHeaderIterator) {
    throw new RuntimeException("Stub!");
  }
  
  public boolean keepAlive(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\DefaultConnectionReuseStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */