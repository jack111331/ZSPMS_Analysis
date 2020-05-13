package org.apache.http.cookie;

import java.util.List;
import org.apache.http.Header;

@Deprecated
public interface CookieSpec {
  List<Header> formatCookies(List<Cookie> paramList);
  
  int getVersion();
  
  Header getVersionHeader();
  
  boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException;
  
  void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\cookie\CookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */