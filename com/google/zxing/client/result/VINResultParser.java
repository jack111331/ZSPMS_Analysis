package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Pattern;

public final class VINResultParser extends ResultParser {
  private static final Pattern AZ09;
  
  private static final Pattern IOQ = Pattern.compile("[IOQ]");
  
  static {
    AZ09 = Pattern.compile("[A-Z0-9]{17}");
  }
  
  private static char checkChar(int paramInt) {
    if (paramInt < 10)
      return (char)(paramInt + 48); 
    if (paramInt == 10)
      return 'X'; 
    throw new IllegalArgumentException();
  }
  
  private static boolean checkChecksum(CharSequence paramCharSequence) {
    int i = 0;
    int j = 0;
    while (i < paramCharSequence.length()) {
      int k = i + 1;
      j += vinPositionWeight(k) * vinCharValue(paramCharSequence.charAt(i));
      i = k;
    } 
    return (paramCharSequence.charAt(8) == checkChar(j % 11));
  }
  
  private static String countryCode(CharSequence paramCharSequence) {
    char c1 = paramCharSequence.charAt(0);
    char c2 = paramCharSequence.charAt(1);
    if (c1 != '9') {
      if (c1 != 'S') {
        if (c1 != 'Z') {
          switch (c1) {
            default:
              switch (c1) {
                default:
                  switch (c1) {
                    default:
                      return null;
                    case 'X':
                      if (c2 == '0' || (c2 >= '3' && c2 <= '9'))
                        return "RU"; 
                    case 'W':
                      return "DE";
                    case 'V':
                      break;
                  } 
                  if (c2 >= 'F' && c2 <= 'R')
                    return "FR"; 
                  if (c2 >= 'S' && c2 <= 'W')
                    return "ES"; 
                case 'M':
                  if (c2 >= 'A' && c2 <= 'E')
                    return "IN"; 
                case 'L':
                  return "CN";
                case 'K':
                  if (c2 >= 'L' && c2 <= 'R')
                    return "KO"; 
                case 'J':
                  break;
              } 
              if (c2 >= 'A' && c2 <= 'T')
                return "JP"; 
            case '3':
              if (c2 >= 'A' && c2 <= 'W')
                return "MX"; 
            case '2':
              return "CA";
            case '1':
            case '4':
            case '5':
              break;
          } 
          return "US";
        } 
        if (c2 >= 'A' && c2 <= 'R')
          return "IT"; 
      } 
      if (c2 >= 'A' && c2 <= 'M')
        return "UK"; 
      if (c2 >= 'N' && c2 <= 'T')
        return "DE"; 
    } 
    if ((c2 >= 'A' && c2 <= 'E') || (c2 >= '3' && c2 <= '9'))
      return "BR"; 
  }
  
  private static int modelYear(char paramChar) {
    if (paramChar >= 'E' && paramChar <= 'H')
      return paramChar - 69 + 1984; 
    if (paramChar >= 'J' && paramChar <= 'N')
      return paramChar - 74 + 1988; 
    if (paramChar == 'P')
      return 1993; 
    if (paramChar >= 'R' && paramChar <= 'T')
      return paramChar - 82 + 1994; 
    if (paramChar >= 'V' && paramChar <= 'Y')
      return paramChar - 86 + 1997; 
    if (paramChar >= '1' && paramChar <= '9')
      return paramChar - 49 + 2001; 
    if (paramChar >= 'A' && paramChar <= 'D')
      return paramChar - 65 + 2010; 
    throw new IllegalArgumentException();
  }
  
  private static int vinCharValue(char paramChar) {
    if (paramChar >= 'A' && paramChar <= 'I')
      return paramChar - 65 + 1; 
    if (paramChar >= 'J' && paramChar <= 'R')
      return paramChar - 74 + 1; 
    if (paramChar >= 'S' && paramChar <= 'Z')
      return paramChar - 83 + 2; 
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    throw new IllegalArgumentException();
  }
  
  private static int vinPositionWeight(int paramInt) {
    if (paramInt > 0 && paramInt <= 7)
      return 9 - paramInt; 
    if (paramInt == 8)
      return 10; 
    if (paramInt == 9)
      return 0; 
    if (paramInt >= 10 && paramInt <= 17)
      return 19 - paramInt; 
    throw new IllegalArgumentException();
  }
  
  public VINParsedResult parse(Result paramResult) {
    if (paramResult.getBarcodeFormat() != BarcodeFormat.CODE_39)
      return null; 
    String str1 = paramResult.getText();
    String str2 = IOQ.matcher(str1).replaceAll("").trim();
    if (!AZ09.matcher(str2).matches())
      return null; 
    try {
      if (!checkChecksum(str2))
        return null; 
      str1 = str2.substring(0, 3);
      return new VINParsedResult(str2, str1, str2.substring(3, 9), str2.substring(9, 17), countryCode(str1), str2.substring(3, 8), modelYear(str2.charAt(9)), str2.charAt(10), str2.substring(11));
    } catch (IllegalArgumentException illegalArgumentException) {
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\client\result\VINResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */