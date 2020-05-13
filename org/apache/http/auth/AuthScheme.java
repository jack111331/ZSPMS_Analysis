package org.apache.http.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

@Deprecated
public interface AuthScheme {
  Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException;
  
  String getParameter(String paramString);
  
  String getRealm();
  
  String getSchemeName();
  
  boolean isComplete();
  
  boolean isConnectionBased();
  
  void processChallenge(Header paramHeader) throws MalformedChallengeException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\auth\AuthScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */