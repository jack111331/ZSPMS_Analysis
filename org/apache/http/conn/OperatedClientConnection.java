package org.apache.http.conn;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.params.HttpParams;

@Deprecated
public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
  Socket getSocket();
  
  HttpHost getTargetHost();
  
  boolean isSecure();
  
  void openCompleted(boolean paramBoolean, HttpParams paramHttpParams) throws IOException;
  
  void opening(Socket paramSocket, HttpHost paramHttpHost) throws IOException;
  
  void update(Socket paramSocket, HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\OperatedClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */