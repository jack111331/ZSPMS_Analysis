package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.HttpRequest;

@Deprecated
public interface HttpUriRequest extends HttpRequest {
  void abort() throws UnsupportedOperationException;
  
  String getMethod();
  
  URI getURI();
  
  boolean isAborted();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\methods\HttpUriRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */