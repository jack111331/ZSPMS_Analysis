package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser extends ResultParser {
  private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN;
  
  private static final Pattern URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
  
  static {
    URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
  }
  
  static boolean isBasicallyValidURI(String paramString) {
    if (paramString.contains(" "))
      return false; 
    Matcher matcher2 = URL_WITH_PROTOCOL_PATTERN.matcher(paramString);
    if (matcher2.find() && matcher2.start() == 0)
      return true; 
    Matcher matcher1 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(paramString);
    return (matcher1.find() && matcher1.start() == 0);
  }
  
  public URIParsedResult parse(Result paramResult) {
    String str = getMassagedText(paramResult);
    if (str.startsWith("URL:") || str.startsWith("URI:"))
      return new URIParsedResult(str.substring(4).trim(), null); 
    str = str.trim();
    return isBasicallyValidURI(str) ? new URIParsedResult(str, null) : null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\URIResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */