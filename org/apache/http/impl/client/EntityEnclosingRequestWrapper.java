package org.apache.http.impl.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;

@Deprecated
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
  public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws ProtocolException {
    super((HttpRequest)null);
    throw new RuntimeException("Stub!");
  }
  
  public boolean expectContinue() {
    throw new RuntimeException("Stub!");
  }
  
  public HttpEntity getEntity() {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRepeatable() {
    throw new RuntimeException("Stub!");
  }
  
  public void setEntity(HttpEntity paramHttpEntity) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\client\EntityEnclosingRequestWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */