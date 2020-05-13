package org.apache.http;

import java.io.IOException;

@Deprecated
public interface HttpClientConnection extends HttpConnection {
  void flush() throws IOException;
  
  boolean isResponseAvailable(int paramInt) throws IOException;
  
  void receiveResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException;
  
  HttpResponse receiveResponseHeader() throws HttpException, IOException;
  
  void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException;
  
  void sendRequestHeader(HttpRequest paramHttpRequest) throws HttpException, IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpClientConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */