package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class ResultParser {
  private static final Pattern AMPERSAND;
  
  private static final String BYTE_ORDER_MARK = "﻿";
  
  private static final Pattern DIGITS;
  
  private static final Pattern EQUALS;
  
  private static final ResultParser[] PARSERS = new ResultParser[] { 
      new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), 
      new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser() };
  
  static {
    DIGITS = Pattern.compile("\\d+");
    AMPERSAND = Pattern.compile("&");
    EQUALS = Pattern.compile("=");
  }
  
  private static void appendKeyValue(CharSequence paramCharSequence, Map<String, String> paramMap) {
    String[] arrayOfString = EQUALS.split(paramCharSequence, 2);
    if (arrayOfString.length == 2) {
      paramCharSequence = arrayOfString[0];
      String str = arrayOfString[1];
      try {
        paramMap.put(paramCharSequence, urlDecode(str));
        return;
      } catch (IllegalArgumentException illegalArgumentException) {}
    } 
  }
  
  private static int countPrecedingBackslashes(CharSequence paramCharSequence, int paramInt) {
    paramInt--;
    byte b = 0;
    while (paramInt >= 0 && paramCharSequence.charAt(paramInt) == '\\') {
      b++;
      paramInt--;
    } 
    return b;
  }
  
  protected static String getMassagedText(Result paramResult) {
    String str2 = paramResult.getText();
    String str1 = str2;
    if (str2.startsWith("﻿"))
      str1 = str2.substring(1); 
    return str1;
  }
  
  protected static boolean isStringOfDigits(CharSequence paramCharSequence, int paramInt) {
    return (paramCharSequence != null && paramInt > 0 && paramInt == paramCharSequence.length() && DIGITS.matcher(paramCharSequence).matches());
  }
  
  protected static boolean isSubstringOfDigits(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    if (paramCharSequence == null || paramInt2 <= 0)
      return false; 
    paramInt2 += paramInt1;
    return (paramCharSequence.length() >= paramInt2 && DIGITS.matcher(paramCharSequence.subSequence(paramInt1, paramInt2)).matches());
  }
  
  static String[] matchPrefixedField(String paramString1, String paramString2, char paramChar, boolean paramBoolean) {
    int i = paramString2.length();
    ArrayList<String> arrayList = null;
    int j = 0;
    while (j < i) {
      j = paramString2.indexOf(paramString1, j);
      if (j >= 0) {
        int k = j + paramString1.length();
        boolean bool = true;
        j = k;
        while (bool) {
          j = paramString2.indexOf(paramChar, j);
          if (j < 0) {
            j = paramString2.length();
          } else {
            if (countPrecedingBackslashes(paramString2, j) % 2 != 0) {
              j++;
              continue;
            } 
            ArrayList<String> arrayList1 = arrayList;
            if (arrayList == null)
              arrayList1 = new ArrayList(3); 
            String str2 = unescapeBackslash(paramString2.substring(k, j));
            String str1 = str2;
            if (paramBoolean)
              str1 = str2.trim(); 
            if (!str1.isEmpty())
              arrayList1.add(str1); 
            j++;
            arrayList = arrayList1;
          } 
          bool = false;
        } 
      } 
    } 
    return (arrayList == null || arrayList.isEmpty()) ? null : arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  static String matchSinglePrefixedField(String paramString1, String paramString2, char paramChar, boolean paramBoolean) {
    String[] arrayOfString = matchPrefixedField(paramString1, paramString2, paramChar, paramBoolean);
    return (arrayOfString == null) ? null : arrayOfString[0];
  }
  
  protected static void maybeAppend(String paramString, StringBuilder paramStringBuilder) {
    if (paramString != null) {
      paramStringBuilder.append('\n');
      paramStringBuilder.append(paramString);
    } 
  }
  
  protected static void maybeAppend(String[] paramArrayOfString, StringBuilder paramStringBuilder) {
    if (paramArrayOfString != null) {
      int i = paramArrayOfString.length;
      for (byte b = 0; b < i; b++) {
        String str = paramArrayOfString[b];
        paramStringBuilder.append('\n');
        paramStringBuilder.append(str);
      } 
    } 
  }
  
  protected static String[] maybeWrap(String paramString) {
    return (paramString == null) ? null : new String[] { paramString };
  }
  
  protected static int parseHexDigit(char paramChar) {
    return (paramChar >= '0' && paramChar <= '9') ? (paramChar - 48) : ((paramChar >= 'a' && paramChar <= 'f') ? (paramChar - 97 + 10) : ((paramChar >= 'A' && paramChar <= 'F') ? (paramChar - 65 + 10) : -1));
  }
  
  static Map<String, String> parseNameValuePairs(String paramString) {
    int i = paramString.indexOf('?');
    if (i < 0)
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(3);
    String[] arrayOfString = AMPERSAND.split(paramString.substring(i + 1));
    int j = arrayOfString.length;
    for (i = 0; i < j; i++)
      appendKeyValue(arrayOfString[i], (Map)hashMap); 
    return (Map)hashMap;
  }
  
  public static ParsedResult parseResult(Result paramResult) {
    ResultParser[] arrayOfResultParser = PARSERS;
    int i = arrayOfResultParser.length;
    for (byte b = 0; b < i; b++) {
      ParsedResult parsedResult = arrayOfResultParser[b].parse(paramResult);
      if (parsedResult != null)
        return parsedResult; 
    } 
    return new TextParsedResult(paramResult.getText(), null);
  }
  
  protected static String unescapeBackslash(String paramString) {
    int i = paramString.indexOf('\\');
    if (i < 0)
      return paramString; 
    int j = paramString.length();
    StringBuilder stringBuilder = new StringBuilder(j - 1);
    stringBuilder.append(paramString.toCharArray(), 0, i);
    boolean bool = false;
    while (i < j) {
      char c = paramString.charAt(i);
      if (bool || c != '\\') {
        stringBuilder.append(c);
        bool = false;
      } else {
        bool = true;
      } 
      i++;
    } 
    return stringBuilder.toString();
  }
  
  static String urlDecode(String paramString) {
    try {
      return URLDecoder.decode(paramString, "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new IllegalStateException(unsupportedEncodingException);
    } 
  }
  
  public abstract ParsedResult parse(Result paramResult);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\ResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */