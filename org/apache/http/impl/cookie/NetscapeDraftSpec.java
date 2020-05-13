package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

@Deprecated
public class NetscapeDraftSpec extends CookieSpecBase {
  protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
  
  public NetscapeDraftSpec() {
    throw new RuntimeException("Stub!");
  }
  
  public NetscapeDraftSpec(String[] paramArrayOfString) {
    throw new RuntimeException("Stub!");
  }
  
  public List<Header> formatCookies(List<Cookie> paramList) {
    throw new RuntimeException("Stub!");
  }
  
  public int getVersion() {
    throw new RuntimeException("Stub!");
  }
  
  public Header getVersionHeader() {
    throw new RuntimeException("Stub!");
  }
  
  public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\cookie\NetscapeDraftSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */