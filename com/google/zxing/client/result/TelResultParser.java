package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser extends ResultParser {
  public TelParsedResult parse(Result paramResult) {
    String str1;
    String str2 = getMassagedText(paramResult);
    if (!str2.startsWith("tel:") && !str2.startsWith("TEL:"))
      return null; 
    if (str2.startsWith("TEL:")) {
      StringBuilder stringBuilder = new StringBuilder("tel:");
      stringBuilder.append(str2.substring(4));
      str1 = stringBuilder.toString();
    } else {
      str1 = str2;
    } 
    int i = str2.indexOf('?', 4);
    if (i < 0) {
      str2 = str2.substring(4);
    } else {
      str2 = str2.substring(4, i);
    } 
    return new TelParsedResult(str2, str1, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\TelResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */