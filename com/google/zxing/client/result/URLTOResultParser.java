package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class URLTOResultParser extends ResultParser {
  public URIParsedResult parse(Result paramResult) {
    String str1;
    String str2 = getMassagedText(paramResult);
    boolean bool = str2.startsWith("urlto:");
    paramResult = null;
    if (!bool && !str2.startsWith("URLTO:"))
      return null; 
    int i = str2.indexOf(':', 6);
    if (i < 0)
      return null; 
    if (i > 6)
      str1 = str2.substring(6, i); 
    return new URIParsedResult(str2.substring(i + 1), str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\URLTOResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */