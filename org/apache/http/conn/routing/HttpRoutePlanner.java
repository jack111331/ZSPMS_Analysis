package org.apache.http.conn.routing;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpRoutePlanner {
  HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\routing\HttpRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */