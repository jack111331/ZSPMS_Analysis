package org.apache.http.message;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

@Deprecated
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
  public BasicHttpEntityEnclosingRequest(String paramString1, String paramString2) {
    super((RequestLine)null);
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpEntityEnclosingRequest(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion) {
    super((RequestLine)null);
    throw new RuntimeException("Stub!");
  }
  
  public BasicHttpEntityEnclosingRequest(RequestLine paramRequestLine) {
    super((RequestLine)null);
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


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\message\BasicHttpEntityEnclosingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */