package org.apache.http;

@Deprecated
public interface HeaderElement {
  String getName();
  
  NameValuePair getParameter(int paramInt);
  
  NameValuePair getParameterByName(String paramString);
  
  int getParameterCount();
  
  NameValuePair[] getParameters();
  
  String getValue();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\HeaderElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */