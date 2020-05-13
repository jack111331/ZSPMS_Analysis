package org.apache.http;

import java.io.Serializable;

@Deprecated
public final class HttpVersion extends ProtocolVersion implements Serializable {
  public static final String HTTP = "HTTP";
  
  public static final HttpVersion HTTP_0_9 = null;
  
  public static final HttpVersion HTTP_1_0 = null;
  
  public static final HttpVersion HTTP_1_1 = null;
  
  public HttpVersion(int paramInt1, int paramInt2) {
    super((String)null, 0, 0);
    throw new RuntimeException("Stub!");
  }
  
  public ProtocolVersion forVersion(int paramInt1, int paramInt2) {
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */