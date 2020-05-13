package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public interface HttpResponseInterceptorList {
  void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor);
  
  void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt);
  
  void clearResponseInterceptors();
  
  HttpResponseInterceptor getResponseInterceptor(int paramInt);
  
  int getResponseInterceptorCount();
  
  void removeResponseInterceptorByClass(Class paramClass);
  
  void setInterceptors(List paramList);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\protocol\HttpResponseInterceptorList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */