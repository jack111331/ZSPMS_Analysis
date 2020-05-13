package org.apache.http;

import java.io.IOException;

@Deprecated
public interface HttpServerConnection extends HttpConnection {
  void flush() throws IOException;
  
  void receiveRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException;
  
  HttpRequest receiveRequestHeader() throws HttpException, IOException;
  
  void sendResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException;
  
  void sendResponseHeader(HttpResponse paramHttpResponse) throws HttpException, IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */