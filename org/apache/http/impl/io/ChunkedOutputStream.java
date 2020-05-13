package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

@Deprecated
public class ChunkedOutputStream extends OutputStream {
  public ChunkedOutputStream(SessionOutputBuffer paramSessionOutputBuffer) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public ChunkedOutputStream(SessionOutputBuffer paramSessionOutputBuffer, int paramInt) throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void close() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void finish() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public void flush() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  protected void flushCache() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  protected void flushCacheWithAppend(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
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
  
  protected void writeClosingChunk() throws IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\io\ChunkedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */