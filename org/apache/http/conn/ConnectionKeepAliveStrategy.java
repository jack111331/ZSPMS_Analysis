package org.apache.http.conn;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ConnectionKeepAliveStrategy {
  long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\ConnectionKeepAliveStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */