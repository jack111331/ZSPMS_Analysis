package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser {
  private static final Pattern COMMA = Pattern.compile(",");
  
  public EmailAddressParsedResult parse(Result paramResult) {
    String str = getMassagedText(paramResult);
    boolean bool = str.startsWith("mailto:");
    String[] arrayOfString = null;
    if (bool || str.startsWith("MAILTO:")) {
      String str2 = str.substring(7);
      int i = str2.indexOf('?');
      String str1 = str2;
      if (i >= 0)
        str1 = str2.substring(0, i); 
      try {
        String str3;
        String str4;
        str1 = urlDecode(str1);
        if (!str1.isEmpty()) {
          String[] arrayOfString1 = COMMA.split(str1);
        } else {
          str1 = null;
        } 
        Map<String, String> map = parseNameValuePairs(str);
        if (map != null) {
          String[] arrayOfString2;
          str2 = str1;
          if (str1 == null) {
            str4 = map.get("to");
            str2 = str1;
            if (str4 != null)
              arrayOfString2 = COMMA.split(str4); 
          } 
          str1 = map.get("cc");
          if (str1 != null) {
            String[] arrayOfString4 = COMMA.split(str1);
          } else {
            str1 = null;
          } 
          String str6 = map.get("bcc");
          if (str6 != null)
            arrayOfString = COMMA.split(str6); 
          String str7 = map.get("subject");
          String str8 = map.get("body");
          String[] arrayOfString3 = arrayOfString2;
          String[] arrayOfString1 = arrayOfString;
          String str5 = str7;
          str3 = str8;
        } else {
          str4 = str1;
          String str5 = null;
          str1 = str5;
          str2 = str1;
          str3 = str2;
          str = str1;
          str1 = str5;
        } 
        return new EmailAddressParsedResult((String[])str4, (String[])str1, (String[])str, str2, str3);
      } catch (IllegalArgumentException illegalArgumentException) {
        return null;
      } 
    } 
    return !EmailDoCoMoResultParser.isBasicallyValidEmailAddress(str) ? null : new EmailAddressParsedResult(str);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\EmailAddressResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */