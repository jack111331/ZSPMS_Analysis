package org.apache.http.client.methods;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;

@Deprecated
public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
  public HttpEntityEnclosingRequestBase() {
    throw new RuntimeException("Stub!");
  }
  
  public Object clone() throws CloneNotSupportedException {
    throw new RuntimeException("Stub!");
  }
  
  public boolean expectContinue() {
    throw new RuntimeException("Stub!");
  }
  
  public HttpEntity getEntity() {
    throw new RuntimeException("Stub!");
  }
  
  public void setEntity(HttpEntity paramHttpEntity) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\methods\HttpEntityEnclosingRequestBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */