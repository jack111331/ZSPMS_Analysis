package org.apache.http.impl.auth;

import java.util.Map;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class RFC2617Scheme extends AuthSchemeBase {
  public RFC2617Scheme() {
    throw new RuntimeException("Stub!");
  }
  
  public String getParameter(String paramString) {
    throw new RuntimeException("Stub!");
  }
  
  protected Map<String, String> getParameters() {
    throw new RuntimeException("Stub!");
  }
  
  public String getRealm() {
    throw new RuntimeException("Stub!");
  }
  
  protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) throws MalformedChallengeException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\auth\RFC2617Scheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */