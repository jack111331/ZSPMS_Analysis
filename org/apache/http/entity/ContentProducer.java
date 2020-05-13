package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

@Deprecated
public interface ContentProducer {
  void writeTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\entity\ContentProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */