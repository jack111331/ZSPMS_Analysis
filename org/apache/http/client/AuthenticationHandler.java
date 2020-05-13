package org.apache.http.client;

import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface AuthenticationHandler {
  Map<String, Header> getChallenges(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws MalformedChallengeException;
  
  boolean isAuthenticationRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
  
  AuthScheme selectScheme(Map<String, Header> paramMap, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws AuthenticationException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\AuthenticationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */