package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequestInterceptor;

@Deprecated
public interface HttpRequestInterceptorList {
  void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor);
  
  void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt);
  
  void clearRequestInterceptors();
  
  HttpRequestInterceptor getRequestInterceptor(int paramInt);
  
  int getRequestInterceptorCount();
  
  void removeRequestInterceptorByClass(Class paramClass);
  
  void setInterceptors(List paramList);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\protocol\HttpRequestInterceptorList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */