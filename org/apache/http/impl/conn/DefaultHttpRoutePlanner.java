package org.apache.http.impl.conn;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultHttpRoutePlanner implements HttpRoutePlanner {
  protected SchemeRegistry schemeRegistry;
  
  public DefaultHttpRoutePlanner(SchemeRegistry paramSchemeRegistry) {
    throw new RuntimeException("Stub!");
  }
  
  public HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\conn\DefaultHttpRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */