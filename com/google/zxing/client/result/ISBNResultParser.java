package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ISBNResultParser extends ResultParser {
  public ISBNParsedResult parse(Result paramResult) {
    if (paramResult.getBarcodeFormat() != BarcodeFormat.EAN_13)
      return null; 
    String str = getMassagedText(paramResult);
    return (str.length() != 13) ? null : ((!str.startsWith("978") && !str.startsWith("979")) ? null : new ISBNParsedResult(str));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ISBNResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */