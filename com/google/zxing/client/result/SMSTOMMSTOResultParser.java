package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMSTOMMSTOResultParser extends ResultParser {
  public SMSParsedResult parse(Result paramResult) {
    String str1 = getMassagedText(paramResult);
    if (!str1.startsWith("smsto:") && !str1.startsWith("SMSTO:") && !str1.startsWith("mmsto:") && !str1.startsWith("MMSTO:"))
      return null; 
    String str2 = str1.substring(6);
    int i = str2.indexOf(':');
    if (i >= 0) {
      str1 = str2.substring(i + 1);
      str2 = str2.substring(0, i);
    } else {
      str1 = null;
    } 
    return new SMSParsedResult(str2, null, null, str1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\SMSTOMMSTOResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */