package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class WifiResultParser extends ResultParser {
  public WifiParsedResult parse(Result paramResult) {
    String str1 = getMassagedText(paramResult);
    if (!str1.startsWith("WIFI:"))
      return null; 
    String str2 = str1.substring(5);
    String str3 = matchSinglePrefixedField("S:", str2, ';', false);
    if (str3 == null || str3.isEmpty())
      return null; 
    String str4 = matchSinglePrefixedField("P:", str2, ';', false);
    String str5 = matchSinglePrefixedField("T:", str2, ';', false);
    str1 = str5;
    if (str5 == null)
      str1 = "nopass"; 
    return new WifiParsedResult(str1, str3, str4, Boolean.parseBoolean(matchSinglePrefixedField("H:", str2, ';', false)), matchSinglePrefixedField("I:", str2, ';', false), matchSinglePrefixedField("A:", str2, ';', false), matchSinglePrefixedField("E:", str2, ';', false), matchSinglePrefixedField("H:", str2, ';', false));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\WifiResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */