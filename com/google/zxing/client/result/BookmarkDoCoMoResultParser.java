package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
  public URIParsedResult parse(Result paramResult) {
    URIParsedResult uRIParsedResult;
    String str2 = paramResult.getText();
    boolean bool = str2.startsWith("MEBKM:");
    paramResult = null;
    if (!bool)
      return null; 
    String str3 = matchSingleDoCoMoPrefixedField("TITLE:", str2, true);
    String[] arrayOfString = matchDoCoMoPrefixedField("URL:", str2, true);
    if (arrayOfString == null)
      return null; 
    String str1 = arrayOfString[0];
    if (URIResultParser.isBasicallyValidURI(str1))
      uRIParsedResult = new URIParsedResult(str1, str3); 
    return uRIParsedResult;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\BookmarkDoCoMoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */