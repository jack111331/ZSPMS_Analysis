package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpRequestRetryHandler {
  boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\HttpRequestRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */