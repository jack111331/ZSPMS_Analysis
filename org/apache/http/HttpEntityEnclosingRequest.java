package org.apache.http;

@Deprecated
public interface HttpEntityEnclosingRequest extends HttpRequest {
  boolean expectContinue();
  
  HttpEntity getEntity();
  
  void setEntity(HttpEntity paramHttpEntity);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpEntityEnclosingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */