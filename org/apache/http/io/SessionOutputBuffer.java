package org.apache.http.io;

import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface SessionOutputBuffer {
  void flush() throws IOException;
  
  HttpTransportMetrics getMetrics();
  
  void write(int paramInt) throws IOException;
  
  void write(byte[] paramArrayOfbyte) throws IOException;
  
  void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  void writeLine(String paramString) throws IOException;
  
  void writeLine(CharArrayBuffer paramCharArrayBuffer) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\io\SessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */