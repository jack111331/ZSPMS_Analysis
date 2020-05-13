package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
  private static final Pattern ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");
  
  static boolean isBasicallyValidEmailAddress(String paramString) {
    return (paramString != null && ATEXT_ALPHANUMERIC.matcher(paramString).matches() && paramString.indexOf('@') >= 0);
  }
  
  public EmailAddressParsedResult parse(Result paramResult) {
    String str = getMassagedText(paramResult);
    if (!str.startsWith("MATMSG:"))
      return null; 
    String[] arrayOfString = matchDoCoMoPrefixedField("TO:", str, true);
    if (arrayOfString == null)
      return null; 
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++) {
      if (!isBasicallyValidEmailAddress(arrayOfString[b]))
        return null; 
    } 
    return new EmailAddressParsedResult(arrayOfString, null, null, matchSingleDoCoMoPrefixedField("SUB:", str, false), matchSingleDoCoMoPrefixedField("BODY:", str, false));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\EmailDoCoMoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */