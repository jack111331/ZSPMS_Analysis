package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface LineFormatter {
  CharArrayBuffer appendProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ProtocolVersion paramProtocolVersion);
  
  CharArrayBuffer formatHeader(CharArrayBuffer paramCharArrayBuffer, Header paramHeader);
  
  CharArrayBuffer formatRequestLine(CharArrayBuffer paramCharArrayBuffer, RequestLine paramRequestLine);
  
  CharArrayBuffer formatStatusLine(CharArrayBuffer paramCharArrayBuffer, StatusLine paramStatusLine);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\message\LineFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */