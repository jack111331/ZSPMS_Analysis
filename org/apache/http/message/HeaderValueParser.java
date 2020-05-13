package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface HeaderValueParser {
  HeaderElement[] parseElements(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException;
  
  HeaderElement parseHeaderElement(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException;
  
  NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException;
  
  NameValuePair[] parseParameters(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor) throws ParseException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\message\HeaderValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */