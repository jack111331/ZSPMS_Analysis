package org.apache.http;

import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface FormattedHeader extends Header {
  CharArrayBuffer getBuffer();
  
  int getValuePos();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\FormattedHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */