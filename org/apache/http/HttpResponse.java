package org.apache.http;

import java.util.Locale;

@Deprecated
public interface HttpResponse extends HttpMessage {
  HttpEntity getEntity();
  
  Locale getLocale();
  
  StatusLine getStatusLine();
  
  void setEntity(HttpEntity paramHttpEntity);
  
  void setLocale(Locale paramLocale);
  
  void setReasonPhrase(String paramString) throws IllegalStateException;
  
  void setStatusCode(int paramInt) throws IllegalStateException;
  
  void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt);
  
  void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString);
  
  void setStatusLine(StatusLine paramStatusLine);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */