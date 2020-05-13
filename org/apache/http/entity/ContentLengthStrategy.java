package org.apache.http.entity;

import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

@Deprecated
public interface ContentLengthStrategy {
  public static final int CHUNKED = -2;
  
  public static final int IDENTITY = -1;
  
  long determineLength(HttpMessage paramHttpMessage) throws HttpException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\entity\ContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */