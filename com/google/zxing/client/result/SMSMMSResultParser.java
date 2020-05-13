package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class SMSMMSResultParser extends ResultParser {
  private static void addNumberVia(Collection<String> paramCollection1, Collection<String> paramCollection2, String paramString) {
    String str;
    int i = paramString.indexOf(';');
    Collection collection = null;
    if (i < 0) {
      paramCollection1.add(paramString);
      paramCollection2.add(null);
      return;
    } 
    paramCollection1.add(paramString.substring(0, i));
    paramString = paramString.substring(i + 1);
    paramCollection1 = collection;
    if (paramString.startsWith("via="))
      str = paramString.substring(4); 
    paramCollection2.add(str);
  }
  
  public SMSParsedResult parse(Result paramResult) {
    String str1 = getMassagedText(paramResult);
    boolean bool = str1.startsWith("sms:");
    String str2 = null;
    if (!bool && !str1.startsWith("SMS:") && !str1.startsWith("mms:") && !str1.startsWith("MMS:"))
      return null; 
    Map<String, String> map = parseNameValuePairs(str1);
    int i = 0;
    if (map != null && !map.isEmpty()) {
      str2 = map.get("subject");
      String str = map.get("body");
      i = 1;
    } else {
      map = null;
    } 
    int j = str1.indexOf('?', 4);
    if (j < 0 || !i) {
      str1 = str1.substring(4);
    } else {
      str1 = str1.substring(4, j);
    } 
    i = -1;
    ArrayList<String> arrayList1 = new ArrayList(1);
    ArrayList<String> arrayList2 = new ArrayList(1);
    while (true) {
      int k = i + 1;
      j = str1.indexOf(',', k);
      if (j > i) {
        addNumberVia(arrayList1, arrayList2, str1.substring(k, j));
        i = j;
        continue;
      } 
      addNumberVia(arrayList1, arrayList2, str1.substring(k));
      return new SMSParsedResult(arrayList1.<String>toArray(new String[arrayList1.size()]), arrayList2.<String>toArray(new String[arrayList2.size()]), str2, (String)map);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\SMSMMSResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */