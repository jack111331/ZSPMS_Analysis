package org.apache.http.conn;

import java.io.IOException;

@Deprecated
public interface ConnectionReleaseTrigger {
  void abortConnection() throws IOException;
  
  void releaseConnection() throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\ConnectionReleaseTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */