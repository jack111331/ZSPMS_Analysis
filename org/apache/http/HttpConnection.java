package org.apache.http;

import java.io.IOException;

@Deprecated
public interface HttpConnection {
  void close() throws IOException;
  
  HttpConnectionMetrics getMetrics();
  
  int getSocketTimeout();
  
  boolean isOpen();
  
  boolean isStale();
  
  void setSocketTimeout(int paramInt);
  
  void shutdown() throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */