package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer {
  public AbstractSessionInputBuffer() {
    throw new RuntimeException("Stub!");
  }
  
  protected int fillBuffer() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public HttpTransportMetrics getMetrics() {
    throw new RuntimeException("Stub!");
  }
  
  protected boolean hasBufferedData() {
    throw new RuntimeException("Stub!");
  }
  
  protected void init(InputStream paramInputStream, int paramInt, HttpParams paramHttpParams) {
    throw new RuntimeException("Stub!");
  }
  
  public int read() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public int readLine(CharArrayBuffer paramCharArrayBuffer) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public String readLine() throws IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\io\AbstractSessionInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */