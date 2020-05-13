package org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public interface HttpEntity {
  void consumeContent() throws IOException;
  
  InputStream getContent() throws IOException, IllegalStateException;
  
  Header getContentEncoding();
  
  long getContentLength();
  
  Header getContentType();
  
  boolean isChunked();
  
  boolean isRepeatable();
  
  boolean isStreaming();
  
  void writeTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */