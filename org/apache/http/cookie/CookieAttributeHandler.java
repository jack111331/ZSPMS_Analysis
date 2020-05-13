package org.apache.http.cookie;

@Deprecated
public interface CookieAttributeHandler {
  boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException;
  
  void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\cookie\CookieAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */