package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;

@Deprecated
public class BasicResponseHandler implements ResponseHandler<String> {
  public BasicResponseHandler() {
    throw new RuntimeException("Stub!");
  }
  
  public String handleResponse(HttpResponse paramHttpResponse) throws HttpResponseException, IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\client\BasicResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */