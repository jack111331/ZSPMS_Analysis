package org.apache.http;

@Deprecated
public interface StatusLine {
  ProtocolVersion getProtocolVersion();
  
  String getReasonPhrase();
  
  int getStatusCode();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\StatusLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */