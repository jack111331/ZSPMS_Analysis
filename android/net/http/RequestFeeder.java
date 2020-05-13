package android.net.http;

import org.apache.http.HttpHost;

interface RequestFeeder {
  Request getRequest();
  
  Request getRequest(HttpHost paramHttpHost);
  
  boolean haveRequest(HttpHost paramHttpHost);
  
  void requeueRequest(Request paramRequest);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\net\http\RequestFeeder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */