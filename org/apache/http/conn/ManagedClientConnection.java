package org.apache.http.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface ManagedClientConnection extends HttpClientConnection, HttpInetConnection, ConnectionReleaseTrigger {
  HttpRoute getRoute();
  
  SSLSession getSSLSession();
  
  Object getState();
  
  boolean isMarkedReusable();
  
  boolean isSecure();
  
  void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException;
  
  void markReusable();
  
  void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException;
  
  void setIdleDuration(long paramLong, TimeUnit paramTimeUnit);
  
  void setState(Object paramObject);
  
  void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException;
  
  void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams) throws IOException;
  
  void unmarkReusable();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\ManagedClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */