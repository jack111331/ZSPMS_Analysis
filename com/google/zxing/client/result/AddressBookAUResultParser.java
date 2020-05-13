package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

public final class AddressBookAUResultParser extends ResultParser {
  private static String[] matchMultipleValuePrefix(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
    ArrayList<String> arrayList;
    byte b = 1;
    StringBuilder stringBuilder = null;
    while (b <= paramInt) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append(b);
      stringBuilder1.append(':');
      String str = matchSinglePrefixedField(stringBuilder1.toString(), paramString2, '\r', paramBoolean);
      if (str != null) {
        ArrayList<String> arrayList1;
        stringBuilder1 = stringBuilder;
        if (stringBuilder == null)
          arrayList1 = new ArrayList(paramInt); 
        arrayList1.add(str);
        b++;
        arrayList = arrayList1;
      } 
    } 
    return (arrayList == null) ? null : arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  public AddressBookParsedResult parse(Result paramResult) {
    String[] arrayOfString1;
    String str1 = getMassagedText(paramResult);
    boolean bool = str1.contains("MEMORY");
    paramResult = null;
    if (!bool || !str1.contains("\r\n"))
      return null; 
    String str2 = matchSinglePrefixedField("NAME1:", str1, '\r', true);
    String str3 = matchSinglePrefixedField("NAME2:", str1, '\r', true);
    String[] arrayOfString2 = matchMultipleValuePrefix("TEL", 3, str1, true);
    String[] arrayOfString3 = matchMultipleValuePrefix("MAIL", 3, str1, true);
    String str4 = matchSinglePrefixedField("MEMORY:", str1, '\r', false);
    str1 = matchSinglePrefixedField("ADD:", str1, '\r', true);
    if (str1 != null) {
      arrayOfString1 = new String[1];
      arrayOfString1[0] = str1;
    } 
    return new AddressBookParsedResult(maybeWrap(str2), null, str3, arrayOfString2, null, arrayOfString3, null, null, str4, arrayOfString1, null, null, null, null, null, null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\AddressBookAUResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */