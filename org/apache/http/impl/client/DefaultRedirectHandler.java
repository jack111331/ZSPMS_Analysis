package org.apache.http.impl.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultRedirectHandler implements RedirectHandler {
  public DefaultRedirectHandler() {
    throw new RuntimeException("Stub!");
  }
  
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\client\DefaultRedirectHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */