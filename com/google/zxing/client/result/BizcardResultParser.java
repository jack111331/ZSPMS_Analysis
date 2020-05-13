package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

public final class BizcardResultParser extends AbstractDoCoMoResultParser {
  private static String buildName(String paramString1, String paramString2) {
    if (paramString1 == null)
      return paramString2; 
    if (paramString2 == null)
      return paramString1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(' ');
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  private static String[] buildPhoneNumbers(String paramString1, String paramString2, String paramString3) {
    ArrayList<String> arrayList = new ArrayList(3);
    if (paramString1 != null)
      arrayList.add(paramString1); 
    if (paramString2 != null)
      arrayList.add(paramString2); 
    if (paramString3 != null)
      arrayList.add(paramString3); 
    int i = arrayList.size();
    return (i == 0) ? null : arrayList.<String>toArray(new String[i]);
  }
  
  public AddressBookParsedResult parse(Result paramResult) {
    String str2 = getMassagedText(paramResult);
    if (!str2.startsWith("BIZCARD:"))
      return null; 
    String str3 = buildName(matchSingleDoCoMoPrefixedField("N:", str2, true), matchSingleDoCoMoPrefixedField("X:", str2, true));
    String str4 = matchSingleDoCoMoPrefixedField("T:", str2, true);
    String str1 = matchSingleDoCoMoPrefixedField("C:", str2, true);
    String[] arrayOfString = matchDoCoMoPrefixedField("A:", str2, true);
    String str5 = matchSingleDoCoMoPrefixedField("B:", str2, true);
    String str6 = matchSingleDoCoMoPrefixedField("M:", str2, true);
    String str7 = matchSingleDoCoMoPrefixedField("F:", str2, true);
    str2 = matchSingleDoCoMoPrefixedField("E:", str2, true);
    return new AddressBookParsedResult(maybeWrap(str3), null, null, buildPhoneNumbers(str5, str6, str7), null, maybeWrap(str2), null, null, null, arrayOfString, null, str1, null, str4, null, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\BizcardResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */