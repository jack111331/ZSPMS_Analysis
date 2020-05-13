package org.apache.http.io;

import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface SessionInputBuffer {
  HttpTransportMetrics getMetrics();
  
  boolean isDataAvailable(int paramInt) throws IOException;
  
  int read() throws IOException;
  
  int read(byte[] paramArrayOfbyte) throws IOException;
  
  int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  int readLine(CharArrayBuffer paramCharArrayBuffer) throws IOException;
  
  String readLine() throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\io\SessionInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */