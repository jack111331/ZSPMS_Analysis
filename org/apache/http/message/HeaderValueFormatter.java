package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface HeaderValueFormatter {
  CharArrayBuffer formatElements(CharArrayBuffer paramCharArrayBuffer, HeaderElement[] paramArrayOfHeaderElement, boolean paramBoolean);
  
  CharArrayBuffer formatHeaderElement(CharArrayBuffer paramCharArrayBuffer, HeaderElement paramHeaderElement, boolean paramBoolean);
  
  CharArrayBuffer formatNameValuePair(CharArrayBuffer paramCharArrayBuffer, NameValuePair paramNameValuePair, boolean paramBoolean);
  
  CharArrayBuffer formatParameters(CharArrayBuffer paramCharArrayBuffer, NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\message\HeaderValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */