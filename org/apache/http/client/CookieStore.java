package org.apache.http.client;

import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

@Deprecated
public interface CookieStore {
  void addCookie(Cookie paramCookie);
  
  void clear();
  
  boolean clearExpired(Date paramDate);
  
  List<Cookie> getCookies();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\CookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */