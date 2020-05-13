package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

@Deprecated
public interface ClientConnectionManager {
  void closeExpiredConnections();
  
  void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit);
  
  SchemeRegistry getSchemeRegistry();
  
  void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit);
  
  ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject);
  
  void shutdown();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\ClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */