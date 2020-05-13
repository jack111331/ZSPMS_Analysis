package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class AddressBookDoCoMoResultParser extends AbstractDoCoMoResultParser {
  private static String parseName(String paramString) {
    int i = paramString.indexOf(',');
    if (i >= 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.substring(i + 1));
      stringBuilder.append(' ');
      stringBuilder.append(paramString.substring(0, i));
      return stringBuilder.toString();
    } 
    return paramString;
  }
  
  public AddressBookParsedResult parse(Result paramResult) {
    String str2 = getMassagedText(paramResult);
    if (!str2.startsWith("MECARD:"))
      return null; 
    String[] arrayOfString1 = matchDoCoMoPrefixedField("N:", str2, true);
    if (arrayOfString1 == null)
      return null; 
    String str3 = parseName(arrayOfString1[0]);
    String str4 = matchSingleDoCoMoPrefixedField("SOUND:", str2, true);
    String[] arrayOfString2 = matchDoCoMoPrefixedField("TEL:", str2, true);
    String[] arrayOfString3 = matchDoCoMoPrefixedField("EMAIL:", str2, true);
    String str5 = matchSingleDoCoMoPrefixedField("NOTE:", str2, false);
    String[] arrayOfString4 = matchDoCoMoPrefixedField("ADR:", str2, true);
    String str1 = matchSingleDoCoMoPrefixedField("BDAY:", str2, true);
    if (!isStringOfDigits(str1, 8))
      str1 = null; 
    String[] arrayOfString5 = matchDoCoMoPrefixedField("URL:", str2, true);
    str2 = matchSingleDoCoMoPrefixedField("ORG:", str2, true);
    return new AddressBookParsedResult(maybeWrap(str3), null, str4, arrayOfString2, null, arrayOfString3, null, null, str5, arrayOfString4, null, str2, str1, null, arrayOfString5, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\AddressBookDoCoMoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */