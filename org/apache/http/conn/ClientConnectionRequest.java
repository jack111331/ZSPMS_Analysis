package org.apache.http.conn;

import java.util.concurrent.TimeUnit;

@Deprecated
public interface ClientConnectionRequest {
  void abortRequest();
  
  ManagedClientConnection getConnection(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\ClientConnectionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */