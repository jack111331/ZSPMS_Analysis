package org.apache.http.client.methods;

import java.io.IOException;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;

@Deprecated
public interface AbortableHttpRequest {
  void abort();
  
  void setConnectionRequest(ClientConnectionRequest paramClientConnectionRequest) throws IOException;
  
  void setReleaseTrigger(ConnectionReleaseTrigger paramConnectionReleaseTrigger) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\methods\AbortableHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */