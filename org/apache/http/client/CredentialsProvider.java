package org.apache.http.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;

@Deprecated
public interface CredentialsProvider {
  void clear();
  
  Credentials getCredentials(AuthScope paramAuthScope);
  
  void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\CredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */