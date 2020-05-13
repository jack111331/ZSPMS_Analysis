package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.List;

public final class VEventResultParser extends ResultParser {
  private static String matchSingleVCardPrefixedField(CharSequence paramCharSequence, String paramString, boolean paramBoolean) {
    List<String> list = VCardResultParser.matchSingleVCardPrefixedField(paramCharSequence, paramString, paramBoolean, false);
    return (list == null || list.isEmpty()) ? null : list.get(0);
  }
  
  private static String[] matchVCardPrefixedField(CharSequence paramCharSequence, String paramString, boolean paramBoolean) {
    List<List<String>> list = VCardResultParser.matchVCardPrefixedField(paramCharSequence, paramString, paramBoolean, false);
    if (list == null || list.isEmpty())
      return null; 
    int i = list.size();
    String[] arrayOfString = new String[i];
    for (byte b = 0; b < i; b++)
      arrayOfString[b] = ((List<String>)list.get(b)).get(0); 
    return arrayOfString;
  }
  
  private static String stripMailto(String paramString) {
    null = paramString;
    if (paramString != null) {
      if (!paramString.startsWith("mailto:")) {
        null = paramString;
        return paramString.startsWith("MAILTO:") ? paramString.substring(7) : null;
      } 
    } else {
      return null;
    } 
    return paramString.substring(7);
  }
  
  public CalendarParsedResult parse(Result paramResult) {
    double d2;
    String str2 = getMassagedText(paramResult);
    if (str2.indexOf("BEGIN:VEVENT") < 0)
      return null; 
    String str3 = matchSingleVCardPrefixedField("SUMMARY", str2, true);
    String str4 = matchSingleVCardPrefixedField("DTSTART", str2, true);
    if (str4 == null)
      return null; 
    String str5 = matchSingleVCardPrefixedField("DTEND", str2, true);
    String str6 = matchSingleVCardPrefixedField("DURATION", str2, true);
    String str7 = matchSingleVCardPrefixedField("LOCATION", str2, true);
    String str1 = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", str2, true));
    String[] arrayOfString = matchVCardPrefixedField("ATTENDEE", str2, true);
    if (arrayOfString != null)
      for (byte b = 0; b < arrayOfString.length; b++)
        arrayOfString[b] = stripMailto(arrayOfString[b]);  
    String str8 = matchSingleVCardPrefixedField("DESCRIPTION", str2, true);
    str2 = matchSingleVCardPrefixedField("GEO", str2, true);
    double d1 = Double.NaN;
    if (str2 == null) {
      d2 = Double.NaN;
    } else {
      int i = str2.indexOf(';');
      if (i < 0)
        return null; 
      try {
        d1 = Double.parseDouble(str2.substring(0, i));
        d2 = Double.parseDouble(str2.substring(i + 1));
        try {
          return new CalendarParsedResult(str3, str4, str5, str6, str7, str1, arrayOfString, str8, d1, d2);
        } catch (IllegalArgumentException null) {
          return null;
        } 
      } catch (NumberFormatException illegalArgumentException) {
        return null;
      } 
    } 
    try {
      return new CalendarParsedResult(str3, str4, str5, str6, str7, (String)illegalArgumentException, arrayOfString, str8, d1, d2);
    } catch (IllegalArgumentException illegalArgumentException1) {
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\VEventResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */