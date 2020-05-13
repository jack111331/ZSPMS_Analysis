package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

@Deprecated
public interface HttpRequestHandler {
  void handle(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\protocol\HttpRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */