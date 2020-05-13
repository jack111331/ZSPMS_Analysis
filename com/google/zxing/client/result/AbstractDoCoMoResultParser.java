package com.google.zxing.client.result;

abstract class AbstractDoCoMoResultParser extends ResultParser {
  static String[] matchDoCoMoPrefixedField(String paramString1, String paramString2, boolean paramBoolean) {
    return matchPrefixedField(paramString1, paramString2, ';', paramBoolean);
  }
  
  static String matchSingleDoCoMoPrefixedField(String paramString1, String paramString2, boolean paramBoolean) {
    return matchSinglePrefixedField(paramString1, paramString2, ';', paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\AbstractDoCoMoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */