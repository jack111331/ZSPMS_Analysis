package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@Deprecated
public class StringEntity extends AbstractHttpEntity {
  protected final byte[] content = null;
  
  public StringEntity(String paramString) throws UnsupportedEncodingException {
    throw new RuntimeException("Stub!");
  }
  
  public StringEntity(String paramString1, String paramString2) throws UnsupportedEncodingException {
    throw new RuntimeException("Stub!");
  }
  
  public Object clone() throws CloneNotSupportedException {
    throw new RuntimeException("Stub!");
  }
  
  public InputStream getContent() throws IOException {
    throw new RuntimeException("Stub!");
  }
  
  public long getContentLength() {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRepeatable() {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStreaming() {
    throw new RuntimeException("Stub!");
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\entity\StringEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */