package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class BasicEofSensorWatcher implements EofSensorWatcher {
  protected boolean attemptReuse;
  
  protected ManagedClientConnection managedConn;
  
  public BasicEofSensorWatcher(ManagedClientConnection paramManagedClientConnection, boolean paramBoolean) {
    throw new RuntimeException("Stub!");
  }
  
  public boolean eofDetected(InputStream paramInputStream) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public boolean streamAbort(InputStream paramInputStream) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public boolean streamClosed(InputStream paramInputStream) throws IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\BasicEofSensorWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */