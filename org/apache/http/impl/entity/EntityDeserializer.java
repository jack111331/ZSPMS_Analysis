package org.apache.http.impl.entity;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionInputBuffer;

@Deprecated
public class EntityDeserializer {
  public EntityDeserializer(ContentLengthStrategy paramContentLengthStrategy) {
    throw new RuntimeException("Stub!");
  }
  
  public HttpEntity deserialize(SessionInputBuffer paramSessionInputBuffer, HttpMessage paramHttpMessage) throws HttpException, IOException {
    throw new RuntimeException("Stub!");
  }
  
  protected BasicHttpEntity doDeserialize(SessionInputBuffer paramSessionInputBuffer, HttpMessage paramHttpMessage) throws HttpException, IOException {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\impl\entity\EntityDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */