package org.apache.http;

@Deprecated
public interface HttpRequestFactory {
  HttpRequest newHttpRequest(String paramString1, String paramString2) throws MethodNotSupportedException;
  
  HttpRequest newHttpRequest(RequestLine paramRequestLine) throws MethodNotSupportedException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */