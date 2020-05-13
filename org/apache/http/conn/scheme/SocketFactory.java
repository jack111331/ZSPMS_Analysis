package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;

public interface SocketFactory {
  Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams) throws IOException, UnknownHostException, ConnectTimeoutException;
  
  Socket createSocket() throws IOException;
  
  boolean isSecure(Socket paramSocket) throws IllegalArgumentException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\scheme\SocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */