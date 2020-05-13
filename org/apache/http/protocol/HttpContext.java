package org.apache.http.protocol;

@Deprecated
public interface HttpContext {
  public static final String RESERVED_PREFIX = "http.";
  
  Object getAttribute(String paramString);
  
  Object removeAttribute(String paramString);
  
  void setAttribute(String paramString, Object paramObject);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\protocol\HttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */