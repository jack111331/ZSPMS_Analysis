package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
  public LoggingSessionOutputBuffer(SessionOutputBuffer paramSessionOutputBuffer, Wire paramWire) {
    throw new RuntimeException("Stub!");
  }
  
  public void flush() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public HttpTransportMetrics getMetrics() {
    throw new RuntimeException("Stub!");
  }
  
  public void write(int paramInt) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void write(byte[] paramArrayOfbyte) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void writeLine(String paramString) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void writeLine(CharArrayBuffer paramCharArrayBuffer) throws IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\conn\LoggingSessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */