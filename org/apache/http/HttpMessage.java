package org.apache.http;

import org.apache.http.params.HttpParams;

@Deprecated
public interface HttpMessage {
  void addHeader(String paramString1, String paramString2);
  
  void addHeader(Header paramHeader);
  
  boolean containsHeader(String paramString);
  
  Header[] getAllHeaders();
  
  Header getFirstHeader(String paramString);
  
  Header[] getHeaders(String paramString);
  
  Header getLastHeader(String paramString);
  
  HttpParams getParams();
  
  ProtocolVersion getProtocolVersion();
  
  HeaderIterator headerIterator();
  
  HeaderIterator headerIterator(String paramString);
  
  void removeHeader(Header paramHeader);
  
  void removeHeaders(String paramString);
  
  void setHeader(String paramString1, String paramString2);
  
  void setHeader(Header paramHeader);
  
  void setHeaders(Header[] paramArrayOfHeader);
  
  void setParams(HttpParams paramHttpParams);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */