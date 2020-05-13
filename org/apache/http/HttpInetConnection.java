package org.apache.http;

import java.net.InetAddress;

@Deprecated
public interface HttpInetConnection extends HttpConnection {
  InetAddress getLocalAddress();
  
  int getLocalPort();
  
  InetAddress getRemoteAddress();
  
  int getRemotePort();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpInetConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */