package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
  public DefaultHttpRequestRetryHandler() {
    throw new RuntimeException("Stub!");
  }
  
  public DefaultHttpRequestRetryHandler(int paramInt, boolean paramBoolean) {
    throw new RuntimeException("Stub!");
  }
  
  public int getRetryCount() {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRequestSentRetryEnabled() {
    throw new RuntimeException("Stub!");
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\client\DefaultHttpRequestRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */