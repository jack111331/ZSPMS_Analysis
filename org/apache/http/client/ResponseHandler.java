package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;

@Deprecated
public interface ResponseHandler<T> {
  T handleResponse(HttpResponse paramHttpResponse) throws ClientProtocolException, IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\ResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */