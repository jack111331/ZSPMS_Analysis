package org.apache.http.conn;

import java.net.ConnectException;
import org.apache.http.HttpHost;

@Deprecated
public class HttpHostConnectException extends ConnectException {
  public HttpHostConnectException(HttpHost paramHttpHost, ConnectException paramConnectException) {
    throw new RuntimeException("Stub!");
  }
  
  public HttpHost getHost() {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\HttpHostConnectException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */