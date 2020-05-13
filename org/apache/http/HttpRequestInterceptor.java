package org.apache.http;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface HttpRequestInterceptor {
  void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpRequestInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */