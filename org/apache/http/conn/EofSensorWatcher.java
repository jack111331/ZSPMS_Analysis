package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

@Deprecated
public interface EofSensorWatcher {
  boolean eofDetected(InputStream paramInputStream) throws IOException;
  
  boolean streamAbort(InputStream paramInputStream) throws IOException;
  
  boolean streamClosed(InputStream paramInputStream) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\EofSensorWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */