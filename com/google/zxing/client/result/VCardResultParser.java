package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser {
  private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
  
  private static final Pattern COMMA;
  
  private static final Pattern CR_LF_SPACE_TAB;
  
  private static final Pattern EQUALS;
  
  private static final Pattern NEWLINE_ESCAPE;
  
  private static final Pattern SEMICOLON;
  
  private static final Pattern SEMICOLON_OR_COMMA;
  
  private static final Pattern UNESCAPED_SEMICOLONS;
  
  private static final Pattern VCARD_ESCAPES;
  
  private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
  
  static {
    CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    EQUALS = Pattern.compile("=");
    SEMICOLON = Pattern.compile(";");
    UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
    COMMA = Pattern.compile(",");
    SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
  }
  
  private static String decodeQuotedPrintable(CharSequence paramCharSequence, String paramString) {
    int i = paramCharSequence.length();
    StringBuilder stringBuilder = new StringBuilder(i);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int j;
    for (j = 0; j < i; j = k + 1) {
      char c = paramCharSequence.charAt(j);
      int k = j;
      if (c != '\n') {
        k = j;
        if (c != '\r')
          if (c != '=') {
            maybeAppendFragment(byteArrayOutputStream, paramString, stringBuilder);
            stringBuilder.append(c);
            k = j;
          } else {
            k = j;
            if (j < i - 2) {
              char c1 = paramCharSequence.charAt(j + 1);
              k = j;
              if (c1 != '\r') {
                k = j;
                if (c1 != '\n') {
                  j += 2;
                  c = paramCharSequence.charAt(j);
                  int m = parseHexDigit(c1);
                  int n = parseHexDigit(c);
                  k = j;
                  if (m >= 0) {
                    k = j;
                    if (n >= 0) {
                      byteArrayOutputStream.write((m << 4) + n);
                      k = j;
                    } 
                  } 
                } 
              } 
            } 
          }  
      } 
    } 
    maybeAppendFragment(byteArrayOutputStream, paramString, stringBuilder);
    return stringBuilder.toString();
  }
  
  private static void formatNames(Iterable<List<String>> paramIterable) {
    if (paramIterable != null)
      for (Iterable<List<String>> paramIterable : paramIterable) {
        String str = (String)paramIterable.get(0);
        String[] arrayOfString = new String[5];
        byte b = 0;
        int i = 0;
        while (b < 4) {
          int j = str.indexOf(';', i);
          if (j >= 0) {
            arrayOfString[b] = str.substring(i, j);
            b++;
            i = j + 1;
          } 
        } 
        arrayOfString[b] = str.substring(i);
        StringBuilder stringBuilder = new StringBuilder(100);
        maybeAppendComponent(arrayOfString, 3, stringBuilder);
        maybeAppendComponent(arrayOfString, 1, stringBuilder);
        maybeAppendComponent(arrayOfString, 2, stringBuilder);
        maybeAppendComponent(arrayOfString, 0, stringBuilder);
        maybeAppendComponent(arrayOfString, 4, stringBuilder);
        paramIterable.set(0, stringBuilder.toString().trim());
      }  
  }
  
  private static boolean isLikeVCardDate(CharSequence paramCharSequence) {
    return (paramCharSequence == null || VCARD_LIKE_DATE.matcher(paramCharSequence).matches());
  }
  
  static List<String> matchSingleVCardPrefixedField(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    List<List<String>> list = matchVCardPrefixedField(paramCharSequence, paramString, paramBoolean1, paramBoolean2);
    return (list == null || list.isEmpty()) ? null : list.get(0);
  }
  
  static List<List<String>> matchVCardPrefixedField(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    int i = paramString.length();
    int j = 0;
    String str = null;
    while (true) {
      ArrayList<ArrayList<String>> arrayList;
      if (j < i) {
        StringBuilder stringBuilder = new StringBuilder("(?:^|\n)");
        stringBuilder.append(paramCharSequence);
        stringBuilder.append("(?:;([^:]*))?:");
        Matcher matcher = Pattern.compile(stringBuilder.toString(), 2).matcher(paramString);
        int k = j;
        if (j > 0)
          k = j - 1; 
        if (matcher.find(k)) {
          List<String> list;
          String str2;
          String str3;
          int n;
          int m = matcher.end(0);
          String str1 = matcher.group(1);
          if (str1 != null) {
            String[] arrayOfString = SEMICOLON.split(str1);
            int i1 = arrayOfString.length;
            k = 0;
            list = null;
            j = 0;
            str1 = null;
            for (str2 = null; k < i1; str2 = str4) {
              String str4 = arrayOfString[k];
              ArrayList<String> arrayList2 = (ArrayList<String>)list;
              if (list == null)
                arrayList2 = new ArrayList(1); 
              arrayList2.add(str4);
              String[] arrayOfString1 = EQUALS.split(str4, 2);
              n = j;
              String str5 = str1;
              str4 = str2;
              if (arrayOfString1.length > 1) {
                String str7 = arrayOfString1[0];
                String str6 = arrayOfString1[1];
                if ("ENCODING".equalsIgnoreCase(str7) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                  n = 1;
                  str5 = str1;
                  str4 = str2;
                } else if ("CHARSET".equalsIgnoreCase(str7)) {
                  n = j;
                  str5 = str6;
                  str4 = str2;
                } else {
                  n = j;
                  str5 = str1;
                  str4 = str2;
                  if ("VALUE".equalsIgnoreCase(str7)) {
                    str4 = str6;
                    str5 = str1;
                    n = j;
                  } 
                } 
              } 
              k++;
              ArrayList<String> arrayList1 = arrayList2;
              j = n;
              str1 = str5;
            } 
            k = j;
            str3 = str1;
          } else {
            str2 = null;
            list = null;
            k = 0;
            str3 = null;
          } 
          j = m;
          while (true) {
            n = paramString.indexOf('\n', j);
            if (n >= 0) {
              if (n < paramString.length() - 1) {
                j = n + 1;
                if (paramString.charAt(j) == ' ' || paramString.charAt(j) == '\t') {
                  j = n + 2;
                  continue;
                } 
              } 
              if (k != 0 && ((n > 0 && paramString.charAt(n - 1) == '=') || (n >= 2 && paramString.charAt(n - 2) == '='))) {
                j = n + 1;
                continue;
              } 
            } 
            break;
          } 
          if (n < 0) {
            j = i;
            continue;
          } 
          if (n > m) {
            ArrayList<ArrayList<String>> arrayList1;
            str1 = str;
            if (str == null)
              arrayList1 = new ArrayList(1); 
            j = n;
            if (n > 0) {
              j = n;
              if (paramString.charAt(n - 1) == '\r')
                j = n - 1; 
            } 
            String str4 = paramString.substring(m, j);
            str = str4;
            if (paramBoolean1)
              str = str4.trim(); 
            if (k != 0) {
              str3 = decodeQuotedPrintable(str, str3);
              str = str3;
              if (paramBoolean2)
                str = UNESCAPED_SEMICOLONS.matcher(str3).replaceAll("\n").trim(); 
            } else {
              str3 = str;
              if (paramBoolean2)
                str3 = UNESCAPED_SEMICOLONS.matcher(str).replaceAll("\n").trim(); 
              str = CR_LF_SPACE_TAB.matcher(str3).replaceAll("");
              str = NEWLINE_ESCAPE.matcher(str).replaceAll("\n");
              str = VCARD_ESCAPES.matcher(str).replaceAll("$1");
            } 
            if ("uri".equals(str2))
              try {
                str2 = URI.create(str).getSchemeSpecificPart();
                str = str2;
              } catch (IllegalArgumentException illegalArgumentException) {} 
            if (list == null) {
              ArrayList<String> arrayList2 = new ArrayList(1);
              arrayList2.add(str);
              arrayList1.add(arrayList2);
            } else {
              list.add(0, str);
              arrayList1.add(list);
            } 
            j++;
            arrayList = arrayList1;
            continue;
          } 
          j = n + 1;
          continue;
        } 
      } 
      return (List)arrayList;
    } 
  }
  
  private static void maybeAppendComponent(String[] paramArrayOfString, int paramInt, StringBuilder paramStringBuilder) {
    if (paramArrayOfString[paramInt] != null && !paramArrayOfString[paramInt].isEmpty()) {
      if (paramStringBuilder.length() > 0)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append(paramArrayOfString[paramInt]);
    } 
  }
  
  private static void maybeAppendFragment(ByteArrayOutputStream paramByteArrayOutputStream, String paramString, StringBuilder paramStringBuilder) {
    if (paramByteArrayOutputStream.size() > 0) {
      String str;
      byte[] arrayOfByte = paramByteArrayOutputStream.toByteArray();
      if (paramString == null) {
        paramString = new String(arrayOfByte, StandardCharsets.UTF_8);
      } else {
        try {
          String str1 = new String();
          this(arrayOfByte, paramString);
          paramString = str1;
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          str = new String(arrayOfByte, StandardCharsets.UTF_8);
        } 
      } 
      paramByteArrayOutputStream.reset();
      paramStringBuilder.append(str);
    } 
  }
  
  private static String toPrimaryValue(List<String> paramList) {
    return (paramList == null || paramList.isEmpty()) ? null : paramList.get(0);
  }
  
  private static String[] toPrimaryValues(Collection<List<String>> paramCollection) {
    if (paramCollection == null || paramCollection.isEmpty())
      return null; 
    ArrayList<String> arrayList = new ArrayList(paramCollection.size());
    Iterator<List<String>> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      String str = ((List<String>)iterator.next()).get(0);
      if (str != null && !str.isEmpty())
        arrayList.add(str); 
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  private static String[] toTypes(Collection<List<String>> paramCollection) {
    if (paramCollection == null || paramCollection.isEmpty())
      return null; 
    ArrayList<String> arrayList = new ArrayList(paramCollection.size());
    for (List<String> list : paramCollection) {
      String str = list.get(0);
      if (str != null && !str.isEmpty()) {
        byte b = 1;
        while (true) {
          if (b < list.size()) {
            str = list.get(b);
            int i = str.indexOf('=');
            if (i < 0)
              break; 
            if ("TYPE".equalsIgnoreCase(str.substring(0, i))) {
              str = str.substring(i + 1);
              break;
            } 
            b++;
            continue;
          } 
          str = null;
          break;
        } 
        arrayList.add(str);
      } 
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  public AddressBookParsedResult parse(Result paramResult) {
    String[] arrayOfString1;
    String[] arrayOfString2;
    String str = getMassagedText(paramResult);
    Matcher matcher = BEGIN_VCARD.matcher(str);
    if (!matcher.find() || matcher.start() != 0)
      return null; 
    List<List<String>> list1 = matchVCardPrefixedField("FN", str, true, false);
    List<List<String>> list2 = list1;
    if (list1 == null) {
      list2 = matchVCardPrefixedField("N", str, true, false);
      formatNames(list2);
    } 
    list1 = (List)matchSingleVCardPrefixedField("NICKNAME", str, true, false);
    if (list1 == null) {
      arrayOfString2 = null;
    } else {
      arrayOfString2 = COMMA.split((CharSequence)list1.get(0));
    } 
    List<List<String>> list3 = matchVCardPrefixedField("TEL", str, true, false);
    List<List<String>> list4 = matchVCardPrefixedField("EMAIL", str, true, false);
    List<String> list5 = matchSingleVCardPrefixedField("NOTE", str, false, false);
    List<List<String>> list6 = matchVCardPrefixedField("ADR", str, true, true);
    List<String> list7 = matchSingleVCardPrefixedField("ORG", str, true, true);
    List<String> list8 = matchSingleVCardPrefixedField("BDAY", str, true, false);
    if (list8 != null && !isLikeVCardDate(list8.get(0)))
      list8 = null; 
    List<String> list9 = matchSingleVCardPrefixedField("TITLE", str, true, false);
    List<List<String>> list10 = matchVCardPrefixedField("URL", str, true, false);
    List<String> list11 = matchSingleVCardPrefixedField("IMPP", str, true, false);
    list1 = (List)matchSingleVCardPrefixedField("GEO", str, true, false);
    if (list1 == null) {
      list1 = null;
    } else {
      arrayOfString1 = SEMICOLON_OR_COMMA.split((CharSequence)list1.get(0));
    } 
    if (arrayOfString1 != null && arrayOfString1.length != 2)
      arrayOfString1 = null; 
    return new AddressBookParsedResult(toPrimaryValues(list2), arrayOfString2, null, toPrimaryValues(list3), toTypes(list3), toPrimaryValues(list4), toTypes(list4), toPrimaryValue(list11), toPrimaryValue(list5), toPrimaryValues(list6), toTypes(list6), toPrimaryValue(list7), toPrimaryValue(list8), toPrimaryValue(list9), toPrimaryValues(list10), arrayOfString1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\VCardResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */