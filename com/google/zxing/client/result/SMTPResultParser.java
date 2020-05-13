package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMTPResultParser extends ResultParser {
  public EmailAddressParsedResult parse(Result paramResult) {
    String str3;
    String str1 = getMassagedText(paramResult);
    if (!str1.startsWith("smtp:") && !str1.startsWith("SMTP:"))
      return null; 
    String str2 = str1.substring(5);
    int i = str2.indexOf(':');
    if (i >= 0) {
      str1 = str2.substring(i + 1);
      str2 = str2.substring(0, i);
      i = str1.indexOf(':');
      if (i >= 0) {
        str3 = str1.substring(i + 1);
        str1 = str1.substring(0, i);
      } else {
        str3 = null;
      } 
    } else {
      str1 = null;
      str3 = str1;
    } 
    return new EmailAddressParsedResult(new String[] { str2 }, null, null, str1, str3);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\SMTPResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */